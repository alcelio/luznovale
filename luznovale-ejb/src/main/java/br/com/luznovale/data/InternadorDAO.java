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
import br.com.luznovale.model.Internador;
import br.com.luznovale.util.CriaCriteria;
/**
 * Session Bean implementation class InternadorDao
 * 
 * @author "Alcélio Gomes {@link doalcelio@gmail.com}"
 *
 *@sice 28/02/2017
 */
@Stateless
@LocalBean
@Remote
public class InternadorDAO implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;
	
	private static ALogger log = ALogger.getLogger(InternadorDAO.class);

	public InternadorDAO() {
	}

	public void create(Internador entidade) throws DatabaseException {
		log.debug("Gravando interandor...");
		try{
			em.persist(entidade);
			log.debug("Gravação realizada com sucesso!");
		}catch( Exception e) {
			log.error("Erro durante a gravação na base de dados.", e);
			throw new DatabaseException("Erro durante a gravação na base de dados.",e);
		}
		
	}

	public void update(Internador entidade) throws DatabaseException {
		log.debug("Atualizando inetrnador...");
		try{
		em.merge(entidade);
		log.debug("Atualização realizada com sucesso!");
		}catch ( Exception e){
			log.error("Erro durante a atualização do interandor na base de dados.", e);
			throw new DatabaseException("Erro durante a atualização do interandor na base de dados.", e);
		}
	}

	public void remove(Internador entidade) throws Exception {
		log.debug("Excluido internador...");
		try{
		em.remove(em.getReference(Internador.class, entidade.getIdPessoa()));
		log.debug("Internador excluído com sucesso!");
		}catch ( Exception e){
			log.error("Erro durante a esclusão do internador na base de dados.", e);
			throw new Exception("Erro durante a esclusão do interandor na base de dados", e);
		}
	}

	public List<Internador> listarReligioes() throws DatabaseException{
		log.debug("Gerando lista de internadores no banco de dados...");
		List<Internador> listaInternador = null;
		try {
			listaInternador = em.createNamedQuery("Internador.findAll", Internador.class).getResultList();
			log.debug("Lista de interandores gerada com sucesso!");
			return listaInternador;
		} catch (Exception e) {
			log.debug("Erro ao gerar lista de internadores na base de dados",e);
			throw new DatabaseException("Erro ao gerar lista de internadores na base de dados.",e);
		}
	}
		
	public Internador buscaInternadorPorId(Integer id) throws Exception{

		final Session session = em.unwrap(Session.class);
		log.debug("Buscando interndor por id...");
		try {
			final Criteria crit = CriaCriteria.createCriteria(Internador.class, session);
			crit.add(Restrictions.eq("idInternador", id));
			Internador internador = (Internador) crit.uniqueResult();
			log.debug("Internador encontrado...");
			return internador;
		} catch (final Exception e) {
			log.error("Erro ao buscar Internador por id",e);
			throw new Exception("Erro ao bsucar Internador por ID...", e);
		}
		
    }
	

}
