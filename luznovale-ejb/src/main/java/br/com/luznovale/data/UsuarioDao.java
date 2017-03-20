package br.com.luznovale.data;

import static br.com.luznovale.logger.ALogger.getLogger;

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
import br.com.luznovale.model.Usuario;
import br.com.luznovale.util.CriaCriteria;
/**
 * Session Bean implementation class UsuarioBeanDao
 */
@Stateless
@LocalBean
@Remote
public class UsuarioDao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private ALogger log =  getLogger(UsuarioDao.class);

	@PersistenceContext
	private EntityManager em;

	public UsuarioDao() {
	}

	public void create(Usuario entidade) throws Exception {
		try{
			em.persist(entidade);
		}catch( Exception e) {
			throw new Exception("Erro de operação (create) na base de dados",e);
		}
		
	}

	public void update(Usuario entidade) throws Exception{
		try {
			em.merge(entidade);
		} catch (Exception e) {
			throw new Exception("Erro de operação (update) na base de dados", e);
		}
	}

	public void remove(Usuario entidade) throws Exception {
		try {
			em.remove(em.getReference(Usuario.class, entidade.getIdPessoa()));
		} catch (Exception e) {
			throw new Exception("Erro de operação (remove) na base de dados", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuarios() throws Exception {
		try {
			final Session session = em.unwrap(Session.class);
			final Criteria crit = CriaCriteria.createCriteria(Usuario.class, session);
			return crit.list();
		} catch (Exception e) {
			throw new Exception("Erro de operação (listarUsuarios) na base de dados", e);
		}
	}
	
	public Usuario buscaUsuarioPorLogin(String login) throws Exception{
		final Session session = em.unwrap(Session.class);
		Usuario usuario = null;
		log.debug("Iniciando busca de usuaário por login");
		try {
			final Criteria crit = CriaCriteria.createCriteria(Usuario.class, session);
			crit.add(Restrictions.eq("login", login));
			usuario = (Usuario) crit.uniqueResult();
			log.debug("Retornando informações do banco de dados...");
			return usuario;
		} catch (Exception e) {
			log.debug("Erro de operação (buscaUsuarioPorLogin) na base de dados",e);
			throw new Exception("Erro de operação (buscaUsuarioPorLogin) na base de dados",e);
		}
    }
	
	public Usuario buscaUsuarioPorId(Integer id) throws DatabaseException{
		final Session session = em.unwrap(Session.class);
		Usuario usuario = null;
		
		try {
			final Criteria crit = CriaCriteria.createCriteria(Usuario.class, session);
			crit.add(Restrictions.eq("idPessoa", id));
			usuario = (Usuario) crit.uniqueResult();
			return usuario;
		} catch (final Exception e) {
			throw new DatabaseException("Erro de operação (buscaUsuarioPorId) na base de dados",e);
		}
    }
	
	public boolean isExisteLogin(String login) throws Exception{
		final Session session = em.unwrap(Session.class);
		Usuario usuario = null;
		try {
			final Criteria crit = CriaCriteria.createCriteria(Usuario.class, session);
			crit.add(Restrictions.eq("login", login));
			usuario = (Usuario) crit.uniqueResult();
			if(usuario != null){
				return true;
			}else{
				return false;
			}
		} catch (final Exception e) {
			throw new Exception("Erro de operação (isExisteLogin) na base de dados",e);
		}
    } 
		
}
