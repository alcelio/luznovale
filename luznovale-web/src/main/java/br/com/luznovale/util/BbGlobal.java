package br.com.luznovale.util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@RequestScoped
@ViewScoped
public class BbGlobal {

	/**
	 * Endereço da página HOME do sistema
	 */
	private final String PAGINA_HOME = "/restrito/home.jsf";

	/**
	 * Endereço da página de manutenção de usuarios do sistema
	 */
	private final String PAGINA_MANUTENCAO_USUSARIO = "/admin/manutencaoUsuario.jsf";

	/**
	 * Endereço da página de manutenção de cidades do sistema
	 */
	private final String PAGINA_MANUTENCAO_CIDADE = "/admin/manutencaoCidade.jsf";

	/**
	 * Endereço da página de manutenção de drogas
	 */
	private final String PAGINA_MANUTENCAO_DROGA = "/admin/manutencaoDroga.jsf";

	/**
	 * Endereço da página de manutenção de estados do sistema
	 */
	private final String PAGINA_MANUTENCAO_ESTADO = "/admin/manutencaoEstado.jsf";

	/**
	 * Endereço da página de manutenção de funções do sistema
	 */
	private final String PAGINA_MANUTENCAO_FUNCAO = "/admin/manutencaoFuncao.jsf";

	/**
	 * Endereço da página de manutenção de instituições
	 */
	private final String PAGINA_MANUTENCAO_INSTITUICAO = "/admin/manutencaoInstituicao.jsf";

	/**
	 * Endereço da página de manutenção de Logradouros
	 */
	private final String PAGINA_MANUTENCAO_LOGRADOURO = "/admin/manutencaoLogradouro.jsf";

	/**
	 * Endereço da página de manutenção de objetos
	 */
	private final String PAGINA_MANUTENCAO_OBJETOS = "/admin/manutencaoObjetos.jsf";

	// /**
	// * Endereço da página de manutenção de Usuários do sistema
	// */
	// private final String PAGINA_MANUTENCAO_USUARIO =
	// "/admin/manutencaoUsuario.jsf";

	/**
	 * Endereço da página de manutenção de instituições
	 */
	private final String PAGINA_REGISTRAR_INTERNACAO = "/restrito/registrarInternacao.jsf";

	/**
	 * Endereço da página para pesquisar internos
	 */
	private String PAGINA_PESQUISA_INTERNOS = "/restrito/pesquisaInternos.jsf";

	/**
	 * Endereço da página para pesquisar internos
	 */
	private String PAGINA_PESQUISA_DROGAS = "/restrito/drogasInterno.jsf";
	
	/**
	 * Endereço da página para manter cidades
	 */
	private String PAGINA_BUSCA_CIDADES = "/restrito/buscaCidade.jsf";
	
	/**
	 * Endereço da página para manter logradouros
	 */
	private String PAGINA_BUSCA_LOGRADOURO = "/restrito/buscaLogradouro.jsf";

	/**
	 * Endereço da página de manutenção de Parametros
	 */
	private String PAGINA_MANUTENCAO_PARAMETROS = "/admin/manutencaoParametro.jsf";

	/**
	 * Endereço da página de manutenção de Parametros do Usuário
	 */
	private String PAGINA_MANUTENCAO_PARAMETROS_USUARIO = "/admin/manutencaoParametrosUsuario.jsf";

	/**
	 * Endereço da página de manutenção de Parametros do Sistema
	 */
	private String PAGINA_MANUTENCAO_PARAMETROS_SISTEMA = "/admin/manutencaoParametrosSistema.jsf";

	public String getPAGINA_PESQUISA_INTERNOS() {
		return PAGINA_PESQUISA_INTERNOS;
	}

	public String getPAGINA_REGISTRAR_INTERNACAO() {
		return PAGINA_REGISTRAR_INTERNACAO;
	}

	public String getPAGINA_HOME() {
		return PAGINA_HOME;
	}

	public String getPAGINA_MANUTENCAO_USUARIO() {
		return PAGINA_MANUTENCAO_USUSARIO;
	}

	public String getPAGINA_MANUTENCAO_USUSARIO() {
		return PAGINA_MANUTENCAO_USUSARIO;
	}

	public String getPAGINA_MANUTENCAO_CIDADE() {
		return PAGINA_MANUTENCAO_CIDADE;
	}

	public String getPAGINA_MANUTENCAO_DROGA() {
		return PAGINA_MANUTENCAO_DROGA;
	}

	public String getPAGINA_MANUTENCAO_ESTADO() {
		return PAGINA_MANUTENCAO_ESTADO;
	}

	public String getPAGINA_MANUTENCAO_FUNCAO() {
		return PAGINA_MANUTENCAO_FUNCAO;
	}

	public String getPAGINA_MANUTENCAO_INSTITUICAO() {
		return PAGINA_MANUTENCAO_INSTITUICAO;
	}

	public String getPAGINA_MANUTENCAO_LOGRADOURO() {
		return PAGINA_MANUTENCAO_LOGRADOURO;
	}

	/**
	 * @return the pAGINA_MANUTENCAO_OBJETOS
	 */
	public String getPAGINA_MANUTENCAO_OBJETOS() {
		return PAGINA_MANUTENCAO_OBJETOS;
	}

	/**
	 * @return the pAGINA_MANUTENCAO_PARAMETROS
	 */
	public String getPAGINA_MANUTENCAO_PARAMETROS() {
		return PAGINA_MANUTENCAO_PARAMETROS;
	}


	/**
	 * @return the pAGINA_MANUTENCAO_PARAMETROS_USUARIO
	 */
	public String getPAGINA_MANUTENCAO_PARAMETROS_USUARIO() {
		return PAGINA_MANUTENCAO_PARAMETROS_USUARIO;
	}

	/**
	 * @return the pAGINA_MANUTENCAO_PARAMETROS_SISTEMA
	 */
	public String getPAGINA_MANUTENCAO_PARAMETROS_SISTEMA() {
		return PAGINA_MANUTENCAO_PARAMETROS_SISTEMA;
	}

	

	/**
	 * @param pAGINA_MANUTENCAO_PARAMETROS the pAGINA_MANUTENCAO_PARAMETROS to set
	 */
	public void setPAGINA_MANUTENCAO_PARAMETROS(String pAGINA_MANUTENCAO_PARAMETROS) {
		PAGINA_MANUTENCAO_PARAMETROS = pAGINA_MANUTENCAO_PARAMETROS;
	}

	/**
	 * @param pAGINA_MANUTENCAO_PARAMETROS_USUARIO the pAGINA_MANUTENCAO_PARAMETROS_USUARIO to set
	 */
	public void setPAGINA_MANUTENCAO_PARAMETROS_USUARIO(String pAGINA_MANUTENCAO_PARAMETROS_USUARIO) {
		PAGINA_MANUTENCAO_PARAMETROS_USUARIO = pAGINA_MANUTENCAO_PARAMETROS_USUARIO;
	}

	/**
	 * @param pAGINA_MANUTENCAO_PARAMETROS_SISTEMA the pAGINA_MANUTENCAO_PARAMETROS_SISTEMA to set
	 */
	public void setPAGINA_MANUTENCAO_PARAMETROS_SISTEMA(String pAGINA_MANUTENCAO_PARAMETROS_SISTEMA) {
		PAGINA_MANUTENCAO_PARAMETROS_SISTEMA = pAGINA_MANUTENCAO_PARAMETROS_SISTEMA;
	}

	/**
	 * @return the pAGINA_PESQUISA_DROGAS
	 */
	public String getPAGINA_PESQUISA_DROGAS() {
		return PAGINA_PESQUISA_DROGAS;
	}

	/**
	 * @param pAGINA_PESQUISA_DROGAS the pAGINA_PESQUISA_DROGAS to set
	 */
	public void setPAGINA_PESQUISA_DROGAS(String pAGINA_PESQUISA_DROGAS) {
		PAGINA_PESQUISA_DROGAS = pAGINA_PESQUISA_DROGAS;
	}

	/**
	 * @return the pAGINA_BUSCA_CIDADES
	 */
	public String getPAGINA_BUSCA_CIDADES() {
		return PAGINA_BUSCA_CIDADES;
	}

	/**
	 * @param pAGINA_BUSCA_CIDADES the pAGINA_BUSCA_CIDADES to set
	 */
	public void setPAGINA_BUSCA_CIDADES(String pAGINA_BUSCA_CIDADES) {
		PAGINA_BUSCA_CIDADES = pAGINA_BUSCA_CIDADES;
	}

	/**
	 * @return the pAGINA_BUSCA_LOGRADOURO
	 */
	public String getPAGINA_BUSCA_LOGRADOURO() {
		return PAGINA_BUSCA_LOGRADOURO;
	}

	/**
	 * @param pAGINA_BUSCA_LOGRADOURO the pAGINA_BUSCA_LOGRADOURO to set
	 */
	public void setPAGINA_BUSCA_LOGRADOURO(String pAGINA_BUSCA_LOGRADOURO) {
		PAGINA_BUSCA_LOGRADOURO = pAGINA_BUSCA_LOGRADOURO;
	}
	

}
