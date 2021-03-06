package br.com.luznovale.util;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;

public final class CriaCriteria {

	/**
	 * Cria uma {@link Criteria} a partir da classe informada
	 *
	 * @param clazz
	 *            Classe para a criação da {@link Criteria}
	 * @param session
	 *           Sessão do banco para criar a {@link Criteria}
	 * @param joins
	 *            Seleção de quais joins a consulta deverá executar
	 * @return Uma isntância de {@link Criteria}
	 */
	public static Criteria createCriteria(Class<?> clazz, Session session, String... joins) throws Exception {
		try {
			final Criteria crit = session.createCriteria(clazz).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

			for (final String join : joins) {
				crit.setFetchMode(join, FetchMode.JOIN);
			}

			return crit;
		} catch (final Exception e) {
			throw new Exception("Erro ao criar critério de consulta. Endidade: " + clazz.getSimpleName(), e);
		}
	}

}
