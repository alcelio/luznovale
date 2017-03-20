package br.com.luznovale.data;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.luznovale.exception.DatabaseException;
import br.com.luznovale.model.ParametrosUsuario;
import br.com.luznovale.model.PK.ParametrosUsuarioPK;
import br.com.luznovale.util.CriaCriteria;
/**
 * Session Bean implementation class UsuarioBeanDao
 * 
 * @author "Alcélio Gomes {@link doalcelio@gmail.com}"
 *
 *@since 22/02/2017
 */
@Stateless
@LocalBean
@Remote
public class ParametrosUsuarioDao implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager em;

	public ParametrosUsuarioDao() {
	}

	public ParametrosUsuario buscarPorChave(Integer idParametro, Integer idUsuario) throws DatabaseException {

		final Session session = em.unwrap(Session.class);

		
		try {
			ParametrosUsuarioPK pk = new ParametrosUsuarioPK();
			pk.setIdParametro(idParametro);
			pk.setIdUsuario(idUsuario);
			Criteria crit = CriaCriteria.createCriteria(ParametrosUsuario.class, session);
			crit.add(Restrictions.eq("id", pk));
			return (ParametrosUsuario) crit.uniqueResult();
		} catch (Exception e) {
			throw new DatabaseException("Erro ao consultar ParamentrosUsuario por chave no banco");
		}
		

	}

}
