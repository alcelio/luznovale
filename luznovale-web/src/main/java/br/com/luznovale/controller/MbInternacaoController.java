package br.com.luznovale.controller;

import static br.com.agsolutio.util.IntegerUtil.ONE;
import static br.com.agsolutio.util.IntegerUtil.ZERO;
import static br.com.luznovale.controller.MbLoginController.getUsuarioLogado;
import static br.com.luznovale.util.LuzNovaleGlobal.PAGINA_HOME;
import static br.com.luznovale.util.LuznonaleChaves.PARAM_SYS_INSTIUICAO_PADRAO;
import static javax.faces.application.FacesMessage.SEVERITY_INFO;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.agsolutio.exceptions.DatabaseException;
import br.com.agsolutio.exceptions.ScreenException;
import br.com.luznovale.data.InstituicaoDao;
import br.com.luznovale.data.InternacaoDao;
import br.com.luznovale.data.InternadorDAO;
import br.com.luznovale.data.InternoDao;
import br.com.luznovale.data.ObjetosDao;
import br.com.luznovale.data.ParametrosDao;
import br.com.luznovale.data.UsuarioDao;
import br.com.luznovale.logger.ALogger;
import br.com.luznovale.model.Droga;
import br.com.luznovale.model.Internacao;
import br.com.luznovale.model.Objeto;
import br.com.luznovale.model.ObjetosInterno;
import br.com.luznovale.model.PK.ObjetosInternoPK;

/**
 * Classe para controlar os eventos da entidade Internação
 * 
 * @author Alcélio Gomes
 *
 */

@ManagedBean
@SessionScoped
public class MbInternacaoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private static ALogger log = ALogger.getLogger(MbInstituicaoController.class);

	@EJB
	private UsuarioDao daoUsuario;

	@EJB
	private InternacaoDao dao;

	@EJB
	private ObjetosDao daoObjetos;

	@EJB
	private InternoDao daoInterno;

	@EJB
	private InstituicaoDao daoInstituição;

	@EJB
	private ParametrosDao daoParametros;

	@EJB
	private InternadorDAO daoInternador;

	private Internacao internacao;

	private String caminhoOrigem;

	private List<ObjetosInterno> objetosInternoFiltrados;

	private List<Droga> drogasFiltradas;

	/**
	 * @return the drogasFiltradas
	 */
	public List<Droga> getDrogasFiltradas() {
		return drogasFiltradas;
	}

	/**
	 * @param drogasFiltradas
	 *            the drogasFiltradas to set
	 */
	public void setDrogasFiltradas(List<Droga> drogasFiltradas) {
		this.drogasFiltradas = drogasFiltradas;
	}

	private Objeto objeto;

	private Integer qtdObjetos = ONE;

	private Droga droga;

	private boolean salvouInterno;

	@PostConstruct
	public void init() {
		if(getInternacao() == null){
			novaInternacao();
		}
	}

	public void excluirObjetoDaLista(ObjetosInterno obj) throws ScreenException {

		if (obj == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao excluir objetos da lista", ""));
			throw new ScreenException("Objeto nulo.");
		}

		getInternacao().getObjetos().remove(obj);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Objeto excluído com sucesso!", ""));

	}

	public void adicioNaObjetoListaObjetos() {
		log.debug("Adicionando obejtoInterno na lsita de");

		try {

			if (isConstaNaLista()) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Objeto já consta na lista do interno!", ""));
				return;
			}

			getInternacao().getObjetos().add(geraObjetosInterno(getObjeto()));
			log.debug("Objeto adicionado com sucesso na lista!");
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(SEVERITY_INFO, "Objeto adicionado com sucesso!", ""));

		} catch (ScreenException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro ao adicionar objetos do interno", e.getScreenMessage()));
			log.error("Erro ao adicionar objetos do interno", e);
		} finally {
			inicializaQtd();
		}
	}

	/**
	 * Testa se um objeto ja consta na lista de objetos do interno
	 * 
	 * @return
	 */
	private boolean isConstaNaLista() {
		boolean isContemObjeto = false;

		for (ObjetosInterno o : getInternacao().getObjetos()) {
			if (o.getObjeto().equals(getObjeto())) {
				isContemObjeto = true;
				break;
			}
		}
		return isContemObjeto;
	}

	/**
	 * Adicioana uma droga a lista de drogas de um interna durante a sua
	 * intenação
	 * 
	 * @throws ScreenException
	 */
	public void adicioDroganaNaLista(Droga droga) {
		log.debug("Adicionando droga na lsita...");

		if (getInternacao().getInterno().getDrogas() != null
				&& getInternacao().getInterno().getDrogas().contains(droga)) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Droga já consta na lista", ""));
			return;
		}

		try {
			getInternacao().getInterno().getDrogas().add(droga);
			log.debug("Droga adicionada com sucesso na lista!");
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(SEVERITY_INFO, "Objeto adicionado com sucesso!", ""));

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro ao adicionar drogas do interno", e.getMessage()));
			log.error("Erro ao adicionar objetos do interno", e);
		}
	}

	/**
	 * Metodo que exlcui uma droga da lista de dependencias do usuario em
	 * internação
	 * 
	 * @param droga
	 * @throws ScreenException
	 */
	public void excluirDrogaDaLista(Droga droga) throws ScreenException {

		if (droga == null) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao excluir objetos da lista", ""));
			throw new ScreenException("Objeto nulo.");
		}

		getInternacao().getInterno().getDrogas().remove(droga);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Objeto excluído com sucesso!", ""));

	}

	public void salvarInteno() {
		if (getInternacao() != null && getInternacao().getInterno() != null) {
			try {
				getInternacao().setInterno(daoInterno.update(getInternacao().getInterno()));
				setSalvouInterno(true);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Dados do interno gravados com sucesso!.", ""));
			} catch (Exception e) {
				log.error("Erro a tentar salvar dados do interno...");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Erro ao salvar dados do interno.", e.getMessage()));
			}
		}
	}

	/**
	 * Efetua as verificações e solicita a gravação da entidade internação no
	 * banco de dados.
	 */
	public void salvarInternacao() {
		try {

			// Atribui a instituição padrão para a internação
			Integer instituicao;
			try {
				instituicao = daoParametros.buscarParametros(Integer.class, PARAM_SYS_INSTIUICAO_PADRAO, null, ONE);
				if (instituicao != null && instituicao != ZERO) {
					getInternacao().setInstituicao(daoInstituição.buscaInstituicaoPorId(instituicao));
				}
			} catch (Exception e) {
				throw new ScreenException("Erro ao obter dados da instituição...");
			}

			// Seta o usuário do sistema que efetuou a internação
			try {
				getInternacao().setUsuarioInternador(daoUsuario.buscaUsuarioPorId(getUsuarioLogado().getIdPessoa()));
			} catch (DatabaseException e) {
				throw new ScreenException("Erro ao buscar dados do usuário conectado...");
			}

			// Seta a data de inicio da internação
			getInternacao().setDtaEntrada(new Date());

			// getInternacao().setObjetos(null);

			// Seta a data de cadastramento do interno quando o cadastro é novo
			if (getInternacao().getInterno().getDtaCadastro() == null) {
				getInternacao().getInterno().setDtaCadastro(new Date());
			}

			dao.update(getInternacao());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso.", ""));

			novaInternacao();

		} catch (ScreenException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Erro durante gravação das informações", e.getScreenMessage()));
			log.error("Errro ao solicitar gravação de instiuição!", e);
		}
	}

	/**
	 * Remove a internação
	 */
	public void removeInternacao() {
		try {
			dao.remove(getInternacao());
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Operação realizada com sucesso.", ""));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Operação não realizada, tente novamente.", ""));
			e.printStackTrace();
		}
	}

	/**
	 * Prepara as variáveis para uma nova internação;
	 */
	private void novaInternacao() {
		setInternacao(new Internacao());
		setSalvouInterno(false);

	}

	/**
	 * Método resposável por retornar a página que deve ser exibida ao
	 * selecionar valtar.
	 * 
	 * @return
	 */
	public String goBack() {
		if (isBlank(getCaminhoOrigem())) {
			return PAGINA_HOME;
		} else {
			return getCaminhoOrigem();
		}
	}

	public String getCaminhoOrigem() {
		return caminhoOrigem;
	}

	public void setaCaminhoOrigem(String origem) {
		this.caminhoOrigem = origem;
	}

	public Internacao getInternacao() {
		return internacao;
	}

	public void setInternacao(Internacao internacao) {
		this.internacao = internacao;
	}

	/**
	 * @return the objetosInternoFiltrados
	 */
	public List<ObjetosInterno> getObjetosInternoFiltrados() {
		return objetosInternoFiltrados;
	}

	/**
	 * @param objetosInternoFiltrados
	 *            the objetosInternoFiltrados to set
	 */
	public void setObjetosInternoFiltrados(List<ObjetosInterno> objetosInternoFiltrados) {
		this.objetosInternoFiltrados = objetosInternoFiltrados;
	}

	/**
	 * @return o objeto
	 */
	public Objeto getObjeto() {
		return objeto;
	}

	/**
	 * @param objeto
	 *            seta o obejto
	 */
	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

	/**
	 * @return the salvouInterno
	 */
	public boolean isSalvouInterno() {
		return salvouInterno;
	}

	/**
	 * @param salvouInterno
	 *            the salvouInterno to set
	 */
	public void setSalvouInterno(boolean salvouInterno) {
		this.salvouInterno = salvouInterno;
	}

	/**
	 * Gera um ObjetoInterno
	 * 
	 * @return {@link ObjetosInterno}
	 * @throws ScreenException
	 */
	private ObjetosInterno geraObjetosInterno(Objeto obj) throws ScreenException {
		log.debug("inciando a geraçao de ObjetoInterno");
		if (obj == null) {
			log.error("Recebido um obejto nulo!");
			throw new ScreenException("Obejto recebido é nulo!");
		}

		try {
			ObjetosInternoPK pk = new ObjetosInternoPK();
			ObjetosInterno objInterno = new ObjetosInterno();
			objInterno.setDevolvida(false);
			objInterno.setDtaRecebimento(new Date());
			objInterno.setInterno(getInternacao().getInterno());
			objInterno.setQuantidade(getQtdObjetos());
			objInterno.setObjeto(obj);
			pk.setIdObjeto(objeto.getIdObjeto());
			pk.setIdPessoa(getInternacao().getInterno().getIdPessoa());
			objInterno.setId(pk);
			log.debug("Objeto gerado com sucesso...");
			return objInterno;

		} catch (Exception e) {
			log.error("Errro ao setar propriedades do objetoInterno", e);
			throw new ScreenException(e.getMessage());
		}
	}

	public void informaQtdObjetos(String teste) {
		setQtdObjetos(Integer.valueOf(teste));
		// adicioNaObjetoListaObjetos();
	}

	/**
	 * @return the qtdObjetos
	 */
	public Integer getQtdObjetos() {
		return qtdObjetos;
	}

	/**
	 * @param qtdObjetos
	 *            the qtdObjetos to set
	 */
	public void setQtdObjetos(Integer qtdObjetos) {
		this.qtdObjetos = qtdObjetos;
	}

	public void inicializaQtd() {
		setQtdObjetos(ONE);
	}

	/**
	 * @return the droga
	 */
	public Droga getDroga() {
		return droga;
	}

	/**
	 * @param droga
	 *            the droga to set
	 */
	public void setDroga(Droga droga) {
		this.droga = droga;
	}

}
