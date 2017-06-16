package br.com.luznovale.data;

import static br.com.agsolutio.util.SolutioUtil.stringToBigDecimal;
import static org.apache.commons.lang3.StringUtils.trimToEmpty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.StringUtils;

import br.com.agsolutio.exceptions.DatabaseException;
import br.com.agsolutio.exceptions.ScreenException;
import br.com.agsolutio.util.BigDecimalUtil;
import br.com.agsolutio.util.IntegerUtil;
import br.com.agsolutio.util.StringUtil;
import br.com.luznovale.logger.ALogger;
import br.com.luznovale.model.ParametrosSistema;
import br.com.luznovale.model.ParametrosUsuario;

/**
 * Session Bean implementation class UsuarioBeanDao
 * 
 * @author "Alcélio Gomes {@link doalcelio@gmail.com}"
 *
 *@since 24/02/2017
 */

@Stateless
@LocalBean
@Remote
public class ParametrosDao implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static ALogger log = ALogger.getLogger(ParametrosDao.class);

	@PersistenceContext
	private EntityManager em;
	
	@EJB
	ParametrosSistemaDao daoParametrosSistema;
	
	@EJB
	ParametrosUsuarioDao daoParametrosUsuario;

	public ParametrosDao() {
	}

/**
 * Efetua a busca dos parâmetros de sitemas e usuário quanto usuario for igual a nulo ira efetuar a busca por parametros de sistema
 * 
 * @param clazz
 * 			Tipo do retorno desejado
 * @param parametro
 * 			Parametro que será consultado
 * @param defaultValue
 * 			Valor que será retornado caso o parametro nao retornar valroes válidos
 * @return
 * @throws ScreenException
 */
	public <T> T buscarParametros(final Class<T> clazz, final Object parametro, Integer idUsuario,final T defaultValue)
			throws ScreenException {

		T retorno = null;
		
		if (clazz == null) {
			throw new ScreenException("É necessário informar uma classe com o tipo do parâmetro!");
		}

		if (parametro == null) {
			throw new ScreenException("Parâmetro a ser buscado não informado!");
		}
		

		// considera parametro de Sistema
		if (idUsuario == null) {
			log.debug("Buscando parametro de integracao [" + parametro + "]");
			retorno = buscarParametroSistema(clazz, parametro, defaultValue);
			log.info("Valor do parametro [" + parametro + "]: " + retorno);
			
			//Considera parametro de usuario
		} else if (idUsuario != null) {

			String[] param = new String[2];
			StringBuilder sbChave = new StringBuilder();
			sbChave.append(String.valueOf(parametro));
			sbChave.append(String.valueOf(idUsuario));
			param[0] = String.valueOf(parametro);
			param[1] = String.valueOf(idUsuario);

			log.debug("Buscando parametro [" + sbChave + "]..");

			retorno = buscarParametroUsuario(clazz, param, defaultValue);
			log.debug("Valor do parametro [" + sbChave.toString() + "]: " + retorno);

		}

		return retorno;

	}



	/**
	 * Consulta os parametros de usuario retornando seu valor
	 */
	private <T> T buscarParametroUsuario(final Class<T> clazz, final Object parametro, final T defaultValue) {

		Object retorno = null;

		if (clazz.equals(Integer.class)) {
			retorno = buscarValorParametroUsuarioPorInteger((String[]) parametro,
					defaultValue == null ? null : (Integer) defaultValue);
		} else

		if (clazz.equals(Long.class)) {
			retorno = buscarValorParametroUsuarioPorLong((String[]) parametro,
					defaultValue == null ? null : (Long) defaultValue);
		} else

		if (clazz.equals(BigDecimal.class)) {
			retorno = buscarValorParametroUsuarioPorBigDecimal((String[]) parametro,
					defaultValue == null ? null : (BigDecimal) defaultValue);
		} else

		if (clazz.equals(Date.class)) {
			retorno = buscarValorParametroUsuarioPorDate((String[]) parametro,
					(Date) defaultValue == null ? null : (Date) defaultValue);
		} else

		if (clazz.equals(String.class)) {
			retorno = buscarValorParametroUsuarioString((String[]) parametro,
					defaultValue == null ? null : (String) defaultValue);
		} else

		if (clazz.equals(Boolean.class)) {
			retorno = buscarValorParametroUsuarioPorBoolean((String[]) parametro,
					defaultValue == null ? null : (Boolean) defaultValue);
		}

		return clazz.cast(retorno);
	}
	
	/**
	 * Solicita a bsuca do parametro no banco de dados e converte para um boolean
	 * @param descESeqParametro
	 * @param valorDefault
	 * @return
	 */	
	public Boolean buscarValorParametroUsuarioPorBoolean(String[] descESeqParametro, Boolean valorDefault) {

		String valorString = buscarValorParametroUsuarioString(descESeqParametro, null);

		if (valorString == null)
			return valorDefault;
		if (StringUtil.ONE.equals(valorString))
			return true;
		if (StringUtil.ZERO.equals(valorString))
			return false;

		log.error("Erro na conversão do valor " + valorString + " do parâmetro para o formato boolean.");
		return valorDefault;
	}
	
	
	/**
	 * Solicita a bsuca do parametro no banco de dados e converte para um Date
	 * @param descESeqParametro
	 * @param valorDefault
	 * @return
	 */
	public Date buscarValorParametroUsuarioPorDate(String[] descESeqParametro, Date valorDefault) {

		String valorString = buscarValorParametroUsuarioString(descESeqParametro, null);

		if (StringUtils.trimToEmpty(valorString).isEmpty()) {
			return valorDefault;
		}
		String formato = "dd-MM-yyyy";

		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formato);
			return sdf.parse(valorString.trim());
		} catch (Exception e) {
			log.error("Erro na conversão do valor " + valorString + " do parâmetro para o formato Date.", e);

			return valorDefault;
		}
	}

	
	/**
	 * Solicita a bsuca do parametro no banco de dados e converte para um BigDecimal
	 * @param descESeqParametro
	 * @param valorDefault
	 * @return
	 */
	public BigDecimal buscarValorParametroUsuarioPorBigDecimal(String[] descESeqParametro, BigDecimal valorDefault) {

		String valorString = buscarValorParametroUsuarioString(descESeqParametro, null);

		if (StringUtils.trimToEmpty(valorString).isEmpty()) {
			return valorDefault;
		}

		try {
			return stringToBigDecimal(valorString);
		} catch (Exception e) {
			log.error("Erro na conversão do valor " + valorString + " do parâmetro para o formato BigDecimal.", e);
			return valorDefault;
		}
	}

	
	/**
	 * Solicita a bsuca do parametro no banco de dados e converte para um  Long
	 * @param descESeqParametro
	 * @param valorDefault
	 * @return
	 */
	public Long buscarValorParametroUsuarioPorLong(String[] descESeqParametro, Long valorDefault) {

		String valorString = buscarValorParametroUsuarioString(descESeqParametro, null);

		try {

			if (StringUtils.trimToEmpty(valorString).isEmpty()) {
				return valorDefault;
			}

			return Long.valueOf(valorString);
		} catch (Exception e) {
			log.error("Erro na conversão do valor " + valorString + " do parâmetro para o formato Long.", e);
			return valorDefault;
		}
	}
	
	/**
	 * Solicita a bsuca do parametro no banco de dados e converte para um  Integer
	 * @param descESeqParametro
	 * @param valorDefault
	 * @return
	 */
	public Integer buscarValorParametroUsuarioPorInteger(String[] descESeqParametro, Integer valorDefault) {

		String valorString = buscarValorParametroUsuarioString(descESeqParametro, null);

		if (StringUtils.trimToEmpty(valorString).isEmpty()) {
			return valorDefault;
		}

		try {

			return Integer.valueOf(valorString);
		} catch (Exception e) {
			log.error("Erro na conversão do valor " + valorString + " do parâmetro para o formato Integer.", e);
			return valorDefault;
		}
	}
	
	public String buscarValorParametroUsuarioString(String[] descESeqParametro, String valorDefault) {

		// Retorna valor default caso sequência ou descrição do parâmetro não
		// tenha sido informado
		if (descESeqParametro == null || descESeqParametro[0] == null || descESeqParametro[1] == null)
			return valorDefault;

		log.info("Buscando parâmetro: [" + descESeqParametro[1] + " - " + descESeqParametro[0]+"]");

		String retorno = valorDefault;

		try {
			ParametrosUsuario paramUsuario = daoParametrosUsuario.buscarPorChave(Integer.valueOf(descESeqParametro[0]),
					Integer.valueOf(descESeqParametro[1]));

			if (paramUsuario != null && !StringUtils.trimToEmpty(paramUsuario.getDesValorParametro()).isEmpty())
				retorno = paramUsuario.getDesValorParametro();

		} catch (Exception e) {
			log.error("Falha ao buscar parametro de sistema [idParametro:" + descESeqParametro[0] + " - idUsuario:"
					+ descESeqParametro[1] + "]", e);
		} finally {
			log.info("Valor retorno: " + retorno);
		}

		return retorno;
	}
	
	
	/**
	 * Consulta os parametros de sistema retornando seu valor
	 */
	private <T> T buscarParametroSistema(final Class<T> clazz, final Object parametro, final T defaultValue) {

		Object retorno = null;

		if (clazz.equals(String.class)) {
			retorno = buscarParametroSistemaPorString((Integer) parametro, (String) defaultValue);
		} else if (clazz.equals(Integer.class)) {
			retorno = buscarParametroSistemaPorInteger((Integer) parametro, (Integer) defaultValue);
		} else

		if (clazz.equals(Long.class)) {
			retorno = buscarParametroSistemaPorLong((Integer) parametro, (Long) defaultValue);
		} else

		if (clazz.equals(BigDecimal.class)) {
			BigDecimal decimal = new BigDecimal(defaultValue.toString());
			retorno = buscarParametroSistemaPorBigDecimal((Integer) parametro, decimal);
		} else

		if (clazz.equals(Date.class)) {
			retorno = buscarPatametroSistemaPorData((Integer) parametro, (Date) defaultValue);
		} else

		if (clazz.equals(Boolean.class)) {
			retorno = buscarParametroSistemaPorBoolean((Integer) parametro, (Boolean) defaultValue);
		}

		return clazz.cast(retorno);

	}
	
	/**
	 * Busca parametro de sistema no banco de dados e converte para o tipo String
	 * @param idParametro
	 * @param strDefault
	 * @return
	 */
	public String buscarParametroSistemaPorString(Integer idParametro, String strDefault) {

		try {
			ParametrosSistema param = daoParametrosSistema.buscarPorChave(idParametro);

			if ((param == null)
					|| ((param != null) && (StringUtils.trimToEmpty(param.getDesValorParametro()).isEmpty())))
				return strDefault;

			return param.getDesValorParametro();
			
		} catch (DatabaseException e) {
			log.error("Falha ao consultar parametro [" + idParametro + "]", e);
			return strDefault;
		}
	}
	
	/**
	 * Busca parametro de sistema no banco de dados e converte para o tipo Integer
	 * @param idParametro
	 * @param strDefault
	 * @return
	 */
	public Integer buscarParametroSistemaPorInteger(Integer idParametro, Integer intDefault) {

		// Consultando parâmetro
		ParametrosSistema param = null;
		try {
			param = daoParametrosSistema.buscarPorChave(idParametro);

			// Verifica se encontrou o parametro
			if ((param == null) || ((param != null) && (trimToEmpty(param.getDesValorParametro()).isEmpty())))
				return intDefault;

			// Converte para um Inteiro
			return Integer.valueOf(param.getDesValorParametro().trim());
		} catch (DatabaseException e) {
			log.error("Falha ao consultar parametro [" + idParametro + "]", e);
			return intDefault;
		}
	}
	
	
	/**
	 * Busca parametro de sistema no banco de dados e converte para o tipo Long
	 * @param idParametro
	 * @param strDefault
	 * @return
	 */
	public Long buscarParametroSistemaPorLong(Integer idParamero, Long lngDefault) {

		try {
			ParametrosSistema param = daoParametrosSistema.buscarPorChave(idParamero);

			if ((param == null)
					|| ((param != null) && (StringUtils.trimToEmpty(param.getDesValorParametro()).isEmpty())))
				return lngDefault;

			return Long.valueOf(param.getDesValorParametro().trim());
		} catch (DatabaseException e) {
			log.error("Falha ao consultar parametro [" + idParamero + "]", e);
			return lngDefault;
		}
	}
	
	
	/**
	 * Busca parametro de sistema no banco de dados e converte para o tipo BigDecimal
	 * @param idParametro
	 * @param strDefault
	 * @return
	 */
	public BigDecimal buscarParametroSistemaPorBigDecimal(Integer idParametro, BigDecimal bigDefault) {

		try {
			ParametrosSistema param = daoParametrosSistema.buscarPorChave(idParametro);

			if ((param == null) || ((param != null) && (trimToEmpty(param.getDesValorParametro()).isEmpty())))
				return bigDefault;

			if (param.getDesValorParametro().indexOf('.') >= 0 && param.getDesValorParametro().indexOf(',') >= 0) {
				log.info("Valor do parametro de integração [" + idParametro + "] contém formato inválido ["
						+ param.getDesValorParametro() + "]");
				return bigDefault;
			}

			// Convertendo "," em "."
			String aux = StringUtils.replace(param.getDesValorParametro().trim(), ",", ".");

			BigDecimal bigAux = BigDecimalUtil.createBigDecimal(aux, 10);
			return bigAux.setScale(10, RoundingMode.DOWN);
		} catch (DatabaseException e) {
			log.error("Falha ao consultar parametro [" + idParametro + "]", e);
			return bigDefault;
		}
	}
	
	
	/**
	 * Busca parametro de sistema no banco de dados e converte para o tipo Date
	 * @param idParametro
	 * @param strDefault
	 * @return
	 */
	public Date buscarPatametroSistemaPorData(Integer idParametro, Date dateDefault) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			ParametrosSistema param = daoParametrosSistema.buscarPorChave(idParametro);

			if ((param == null) || (StringUtils.trimToEmpty(param.getDesValorParametro()).isEmpty()))
				return dateDefault;

			try {
				return sdf.parse(param.getDesValorParametro().trim());
			} catch (Exception e) {
				log.error("Falha ao converter String [" + param.getDesValorParametro() + "] para Date. "
						+ "Formato esperado [DD/MM/AAAA]", e);
				return dateDefault;
			}
		} catch (DatabaseException e) {
			log.error("Falha ao consultar parametro [" + idParametro + "]", e);
			return dateDefault;
		}
	}
	
	
	/**
	 * Busca parametro de sistema no banco de dados e converte para o tipo boolean
	 * @param idParametro
	 * @param strDefault
	 * @return
	 */
	public boolean buscarParametroSistemaPorBoolean(Integer idParametro, boolean booDefault) {

		ParametrosSistema param = null;
		try {
			param = daoParametrosSistema.buscarPorChave(idParametro);

			if ((param == null) || ((param != null) && (StringUtils.isEmpty(param.getDesValorParametro()))))
				return booDefault;

			String vlrParam = StringUtils.trimToEmpty(param.getDesValorParametro());

			if (!StringUtils.isNumeric(vlrParam))
				return booDefault;

			return IntegerUtil.ONE.equals(Integer.valueOf(vlrParam));
		} catch (DatabaseException e) {
			log.error("Falha ao consultar parametro [" + idParametro + "]", e);
			return booDefault;
		}
	}
	
}
