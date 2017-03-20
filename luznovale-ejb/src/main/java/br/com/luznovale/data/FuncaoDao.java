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
import org.jboss.logging.Logger;

import br.com.luznovale.model.Funcao;
import br.com.luznovale.util.CriaCriteria;
/**
 * Session Bean implementation class FuncoesBeanDao
 */
@Stateless
@LocalBean
@Remote
public class FuncaoDao implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;
	Logger log = Logger.getLogger(FuncaoDao.class);
	public FuncaoDao() {
	}
	public void salvarFuncao(Funcao entidade) throws Exception {
		if (entidade == null) {
			log.error("Operação não permitida, entidare recebida é nula");
			throw new Exception("Operação não permitida, entidare recebida é nula");
		}
		log.debug("Persistindo função [" + entidade.getDesFuncao()+"]...");
		try {
			if (entidade.getIdFuncao() == null || entidade.getIdFuncao() == 0) {
				em.persist(entidade);
			} else {
				em.merge(entidade);
			}
		} catch (Exception e) {
			log.error("Erro ao persistir a função [" + entidade.getDesFuncao()+"]");
			throw new Exception("Erro na operação (remove) na base de dados");
		}
		log.debug("Função ["+entidade.getDesFuncao()+"] persistida com sucesso.");
	}
	
	public void remove(Funcao entidade) throws Exception {
		log.debug("Excluindo função [" + entidade.getDesFuncao()+"]...");
		try{
		em.remove(em.getReference(Funcao.class, entidade.getIdFuncao()));
		}catch ( Exception e){
			log.error("Erro de operação (remove) na base de dados");
			throw new Exception("Erro de operação (remove) na base de dados");
		}
		log.debug("Função ["+entidade.getDesFuncao()+"] excluída com sucesso.");
	}

	public List<Funcao> listarFuncoes() throws Exception{
		log.debug("Listando funções...");
		try{
			return em.createNamedQuery("Funcao.findAll", Funcao.class).getResultList(); 
		}catch (Exception e){
			log.error("Erro de operação (ListarFuncoes) na base de dados");
			throw new Exception("Erro de operação (ListarFuncoes) na base de dados");
		}
	}
		
	public Funcao buscaFuncoesPorId(Integer id) throws Exception{
		log.debug("Buscando função por id: ["+id+"]...");
		final Session session = em.unwrap(Session.class);
		Funcao Funcoes = null;
		try {
			final Criteria crit = CriaCriteria.createCriteria(Funcao.class, session);
			crit.add(Restrictions.eq("idFuncao", id));
			Funcoes = (Funcao) crit.uniqueResult();
			return Funcoes;
		} catch (final Exception e) {
			log.error("Erro de operação (buscaFuncoesPorId) na base de dados");
			throw new Exception("Erro de operação (buscaFuncoesPorId) na base de dados");
		}
    }
	

}
