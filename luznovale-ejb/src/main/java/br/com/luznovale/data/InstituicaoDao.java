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
import br.com.luznovale.model.Instituicao;
import br.com.luznovale.util.CriaCriteria;
/**
 * Session Bean implementation class FuncoesBeanDao
 */
@Stateless
@LocalBean
@Remote
public class InstituicaoDao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static ALogger log = ALogger.getLogger(InstituicaoDao.class);

	@PersistenceContext
	private EntityManager em;
	
	public InstituicaoDao() {
	}
	public void salvarInstituicao(Instituicao entidade) throws Exception {
		if (entidade == null) {
			log.error("Operacao nao permitida, entidare recebida e nula");
			throw new Exception("Operação nao permitida, entidare recebida eh nula");
		}
		log.debug("Persistindo instituicao [" + entidade.getDesNomeInstituicao()+"]...");
		try {
			if (entidade.getIdInstituicao() == null || entidade.getIdInstituicao() == 0) {
				em.persist(entidade);
			} else {
				em.merge(entidade);
			}
		} catch (Exception e) {
			log.error("Erro ao persistir a instituicao [" + entidade.getDesNomeInstituicao()+"]");
			throw new Exception("Erro na operacaos (remove) na base de dados");
		}
		log.debug("Instituicao ["+entidade.getDesNomeInstituicao()+"] persistida com sucesso.");
	}
	
	public void remove(Instituicao entidade) throws Exception {
		log.debug("Excluindo institucao [" + entidade.getDesNomeInstituicao()+"]...");
		try{
		em.remove(em.getReference(Instituicao.class, entidade.getIdInstituicao()));
		}catch ( Exception e){
			log.error("Erro de operacao (remove) na base de dados");
			throw new Exception("Erro de operacao (remove) na base de dados");
		}
		log.debug("Instituicao ["+entidade.getDesNomeInstituicao()+"] excluída com sucesso.");
	}

	public List<Instituicao> listarInstituicoes() throws Exception{
		log.debug("Listando instituicoes...");
		try{
			return em.createNamedQuery("Instituicao.findAll", Instituicao.class).getResultList(); 
		}catch (Exception e){
			log.error("Erro de operacao (ListarInstituicoes) na base de dados");
			throw new Exception("Erro de operacao (ListarInstituicoes) na base de dados");
		}
	}
		
	public Instituicao buscaInstituicaoPorId(Integer id) throws DatabaseException{
		log.debug("Buscando instituição por id: ["+id+"]...");
		final Session session = em.unwrap(Session.class);
		Instituicao instituicao = null;
		try {
			final Criteria crit = CriaCriteria.createCriteria(Instituicao.class, session);
			crit.add(Restrictions.eq("idInstituicao", id));
			instituicao = (Instituicao) crit.uniqueResult();
			log.debug("Retorno: ["+instituicao.getIdInstituicao()+"]...");
			return instituicao;
		} catch (final Exception e) {
			log.error("Erro de operacao (buscaIntituicaoPorId) na base de dados");
			throw new DatabaseException("Erro de operacao (buscaInstituicaoPorId) na base de dados");
		}
    }
	

}
