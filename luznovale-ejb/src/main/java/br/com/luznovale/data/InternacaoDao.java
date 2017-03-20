package br.com.luznovale.data;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.luznovale.exception.DatabaseException;
import br.com.luznovale.logger.ALogger;
import br.com.luznovale.model.Internacao;
import br.com.luznovale.util.CriaCriteria;
/**
 * Session Bean implementation class InternacaoBeanDao
 */
@Stateless
@LocalBean
@Remote
public class InternacaoDao implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static ALogger log = ALogger.getLogger(InternacaoDao.class);
	
	@PersistenceContext
	private EntityManager em;

	public InternacaoDao() {
	}

	public void create(Internacao entidade) throws DatabaseException {
		log.debug("Inciciando gravação de internação no banco de dados...");
		try{
			em.persist(entidade);
			log.debug("Gravação da internação realizada com sucesso!");
		}catch( Exception e) {
			log.error("Erro ao gravar internação no banco de dados!", e);
			throw new DatabaseException(e.getMessage(),e);
		}
		
	}

	public void update(Internacao entidade) throws DatabaseException {
		log.debug("Inciciando atualização de internação ["+entidade.getIdInternacao()+"] no banco de dados...");
		try{
		em.merge(entidade);
		log.debug("Atualização da internação realizada com sucesso!");
		}catch ( Exception e){
			log.error("Erro ao atualizar internação ["+entidade.getIdInternacao()+"] no banco de dados!", e);
			throw new DatabaseException(e.getMessage(), e);
		}
	}

	public void remove(Internacao entidade) throws DatabaseException {
		log.debug("Inciciando remoção da internação ["+entidade.getIdInternacao()+"] no banco de dados...");
		try{
		em.remove(em.getReference(Internacao.class, entidade.getIdInternacao()));
		log.debug("Remoção da internação realizada com sucesso!");
		}catch ( Exception e){
			log.error("Erro ao atualizar internação ["+entidade.getIdInternacao()+"] no banco de dados!", e);
			throw new DatabaseException("Erro de operação (remove) na base de dados", e);
		}
	}

	public List<Internacao> listarInternacaos() throws DatabaseException{
		log.debug("Buscando lista de internações no banco de dados...");
		try {
			List<Internacao> listaIntenacoes =  em.createNamedQuery("Internacao.findAll", Internacao.class).getResultList();
			log.debug("Lista de intenações gerada com sucesso:["+listaIntenacoes.size()+" internações]");
			return listaIntenacoes;
		} catch (Exception e) {
			log.error("Erro ao lsitar gerar lista de internações no banco de dados!", e);
			throw new DatabaseException("Erro de operação (listarInternacoes) na base de dados", e);
		}
		
		
	}
		
	public Internacao buscaInternacaoPorId(Integer id) throws DatabaseException{
		final Session session = em.unwrap(Session.class);
		Internacao Internacao = null;
		log.debug("Inciciando busca de internação por id: ["+id+"] no banco de dados...");
		try {
			final Criteria crit = CriaCriteria.createCriteria(Internacao.class, session);
			crit.add(Restrictions.eq("idInternacao", id));
			Internacao = (Internacao) crit.uniqueResult();
			log.debug("Encontrado internação id: ["+id+"] no banco de dados...");
			return Internacao;
		} catch (final Exception e) {
			throw new DatabaseException("Erro obeter o id ["+id+"] na base de dados", e);
		}
    }
	
	@SuppressWarnings("unchecked")
	public List<Internacao>  buscaInternacaoInterno(Integer idPessoa) throws Exception{
		final Session session = em.unwrap(Session.class);
		List<Internacao> internacoes = null;
		log.debug("Inciando busca de internação da pessoa: ["+ idPessoa+"]...");
		try {
			final Criteria crit = CriaCriteria.createCriteria(Internacao.class, session);
			crit.add(Restrictions.eq("idPessoa", idPessoa));
			internacoes =  crit.list();
			log.debug("Retorno: ["+ internacoes.size()+"] intenações");
			return internacoes;
		} catch (final Exception e) {
			throw new Exception("Não foi possível gerar lista.", e);
		}
		
    }

	@SuppressWarnings("unchecked")
	public List<Internacao>  buscaTodasInternacoesAbertas() throws Exception{
		final Session session = em.unwrap(Session.class);
		List<Internacao> internacoes = null;
		log.debug("Inciando pesquisa de internações em aberto.");
		try {
			final Criteria crit = CriaCriteria.createCriteria(Internacao.class, session);
			crit.add(Restrictions.eq("dtaSaida", null));
			internacoes =  crit.list();
			log.debug("Localizadas "+internacoes.size()+"] internações em aberto.");
			return internacoes;
		} catch (final Exception e) {
			throw new Exception("Erro ao gerar lista de internações", e);
		}
    }
	
	
}
