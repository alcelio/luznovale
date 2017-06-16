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

import br.com.agsolutio.exceptions.DatabaseException;
import br.com.luznovale.logger.ALogger;
import br.com.luznovale.model.Profissao;
import br.com.luznovale.util.CriaCriteria;

/**
 * Session Bean implementation class ProfissaoDao
 * 
 * @author "Alcélio Gomes {@link doalcelio@gmail.com}"
 * 
 * @since 28/02/2017
 *
 */
@Stateless
@LocalBean
@Remote
public class ProfissaoDAO implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;
	
	private static ALogger log = ALogger.getLogger(ProfissaoDAO.class);

	public ProfissaoDAO() {
	}

	public void create(Profissao entidade) throws DatabaseException {
		log.debug("Gravando profissao...");
		try{
			em.persist(entidade);
			log.debug("Gravação realizada com sucesso!");
		}catch( Exception e) {
			log.error("Erro durante a gravação da profissao na base de dados.", e);
			throw new DatabaseException("Erro durante a gravação na base de dados.",e);
		}
		
	}

	public void update(Profissao entidade) throws DatabaseException {
		log.debug("Atualizando profissao...");
		try{
		em.merge(entidade);
		log.debug("Atualização realizada com sucesso!");
		}catch ( Exception e){
			log.error("Erro durante a atualização da profissao na base de dados.", e);
			throw new DatabaseException("Erro de operação (update) na base de dados", e);
		}
	}

	public void remove(Profissao entidade) throws Exception {
		log.debug("Excluido profissao...");
		try{
		em.remove(em.getReference(Profissao.class, entidade.getIdProfissao()));
		log.debug("Profissao excluída com sucesso!");
		}catch ( Exception e){
			log.error("Erro durante a esclusão da profissao na base de dados.", e);
			throw new Exception("Erro durante a esclusão da profissao na base de dados", e);
		}
	}

	public List<Profissao> listarReligioes() throws DatabaseException{
		log.debug("Gerando lista de profissoes no banco de dados...");
		List<Profissao> listaProfissao = null;
		try {
			listaProfissao = em.createNamedQuery("Profissao.findAll", Profissao.class).getResultList();
			log.debug("Lista de profissoes gerada com sucesso!");
			return listaProfissao;
		} catch (Exception e) {
			log.debug("Erro ao gerar lista de profissoes na base de dados",e);
			throw new DatabaseException("Erro ao gerar lista de profissoes na base de dados.",e);
		}
	}
		
	public Profissao buscaProfissaoPorId(Integer id) throws Exception{

		final Session session = em.unwrap(Session.class);
		log.debug("Buscando profissao por id...");
		try {
			final Criteria crit = CriaCriteria.createCriteria(Profissao.class, session);
			crit.add(Restrictions.eq("idProfissao", id));
			Profissao Profissao = (Profissao) crit.uniqueResult();
			log.debug("profissao encontrada...");
			return Profissao;
		} catch (final Exception e) {
			log.error("Erro ao buscar profissao por id",e);
			throw new Exception("Erro ao bsucar profissao por ID...", e);
		}
		
    }
	

}
