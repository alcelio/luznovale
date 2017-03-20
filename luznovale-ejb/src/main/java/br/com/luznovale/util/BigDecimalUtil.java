package br.com.luznovale.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Classe para auxiliar nos calculos e construção de um {@link BigDecimal}
 * 
 * @author Alcélio Gomes
 */
public class BigDecimalUtil {
	
	/**
	 * Quantidade de casas decimais após a virgula, padrão: 15
	 */
	private static int				defaultPrecision;
	/**
	 * Método de arredondamento, padrão: {@link RoundingMode#HALF_UP}
	 */
	private static RoundingMode		defaultRounding;
	/**
	 * Contexto matem�tico que � constru�do com {@link #defaultPrecision} e {@link #defaultRounding}
	 */
	private static MathContext		defaultContext;
	
	static {
		// Atribui��o do valores iniciais dos atributos
		defaultPrecision = 15;
		defaultRounding = RoundingMode.HALF_UP;
		defaultContext = new MathContext(defaultPrecision, defaultRounding);
	}
	
	/**
	 * Instancia de {@link BigDecimal} com duas casas decimais e o valor zero (0)
	 */
	public final static BigDecimal	ZERO		= createBigDecimal(0);
	
	/**
	 * Instancia de {@link BigDecimal} com duas casas decimais e o valor um (1)
	 */
	public final static BigDecimal	ONE			= createBigDecimal(1);
	
	/**
	 * Instancia de {@link BigDecimal} com duas casas decimais e o valor dez (10)
	 */
	public final static BigDecimal	TEN			= createBigDecimal(10);
	
	/**
	 * Instancia de {@link BigDecimal} com duas casas decimais e o valor cem
	 */
	public final static BigDecimal	HUNDRED		= createBigDecimal(100);
	
	/**
	 * Instancia de {@link BigDecimal} com duas casas decimais e o valor mil
	 */
	public final static BigDecimal	THOUSAND	= createBigDecimal(1000);
	
	/**
	 * Cria um novo {@link BigDecimal} informando a escala padrao
	 * 
	 * @return BigDecimal
	 * @see BigDecimal#BigDecimal(String)
	 */
	public static BigDecimal createBigDecimal(String value, int scale) {
		if (scale <= 1)
			throw new RuntimeException("Escala deve ser maior ou igual a 2");
		
		return new BigDecimal(value, defaultContext).setScale(scale, defaultRounding);
	}
	
	/**
	 * Cria um novo {@link BigDecimal} informando a escala padrao
	 * 
	 * @return BigDecimal
	 * @see BigDecimal#BigDecimal(String)
	 */
	public static BigDecimal createBigDecimal(String value) {
		return new BigDecimal(value);
	}
	
	/**
	 * Cria um novo {@link BigDecimal} informando a escala padrao
	 * 
	 * @return BigDecimal
	 * @see BigDecimal#BigDecimal(double)
	 */
	public static BigDecimal createBigDecimal(double value, int scale) {
		if (scale <= 1)
			throw new RuntimeException("Escala deve ser maior ou igual a 2");
		
		return new BigDecimal(value, defaultContext).setScale(scale, defaultRounding);
	}
	
	/**
	 * Cria um novo {@link BigDecimal} informando a escala padrao
	 * 
	 * @return BigDecimal
	 * @see BigDecimal#BigDecimal(int)
	 */
	public static BigDecimal createBigDecimal(int value, int scale) {
		if (scale <= 1)
			throw new RuntimeException("Escala deve ser maior ou igual a 2");
		
		return new BigDecimal(value, defaultContext).setScale(scale, defaultRounding);
	}
	
	/**
	 * Cria um novo {@link BigDecimal} informando utilizando duas casas apos a virgula
	 * 
	 * @return BigDecimal
	 * @see BigDecimal#BigDecimal(int)
	 */
	public static BigDecimal createBigDecimal(int value) {
		return createBigDecimal(value, 2);
	}
	
	/**
	 * Cria um novo {@link BigDecimal} informando a esclala padrao
	 * 
	 * @return BigDecimal
	 * @see BigDecimal#BigDecimal(long)
	 */
	public static BigDecimal createBigDecimal(long value, int scale) {
		if (scale <= 1)
			throw new RuntimeException("Escala deve ser maior ou igual a 2");
		
		return new BigDecimal(value, defaultContext).setScale(scale, defaultRounding);
	}
	
	/**
	 * Cria um novo {@link BigDecimal} informando a esclala padrao
	 * 
	 * @return BigDecimal
	 * @see BigDecimal#BigDecimal(long)
	 */
	public static BigDecimal createBigDecimal(long value) {
		return createBigDecimal(value, 2);
	}
	
	/**
	 * Atribuiçãoo da precisão, quantidade de casas decimais apás a virgula, que
	 * será usada nas operações matemáticas
	 * 
	 * @param defaultPrecision
	 *            Quantidade de casas decimais (deve ser maior que zero)
	 */
	public static void setDefaultPrecision(int defaultPrecision) {
		if (defaultPrecision <= 0)
			throw new RuntimeException("Escala deve ser maior que zero");
		
		BigDecimalUtil.defaultPrecision = defaultPrecision;
		defaultContext = new MathContext(defaultPrecision, defaultRounding);
	}
	
	/**
	 * Atribuiçãoo do método de arredondamento
	 * 
	 * @param defaultRounding
	 *            Método de arredondamento que será usado nas operações
	 *            Matemáticas
	 * 
	 * @see RoundingMode
	 */
	public static void setDefaultRounding(RoundingMode defaultRounding) {
		if (defaultRounding == null)
			throw new NullPointerException("Arredondamento nao pode ser nulo");
		
		BigDecimalUtil.defaultRounding = defaultRounding;
		defaultContext = new MathContext(defaultPrecision, defaultRounding);
	}
	
	/**
	 * Efetua a adiçãoo do segundo valor ao primeiro
	 * 
	 * @param v1
	 *            Primeiro valor
	 * @param v2
	 *            Segundo valor
	 * @return Um {@link BigDecimal} com o resultado da operação
	 */
	public static BigDecimal sum(BigDecimal v1, BigDecimal v2) {
		// Se � nulo considera como Zero (0)
		if (v1 == null)
			v1 = ZERO;
		
		// Se � nulo considera como Zero (0)
		if (v2 == null)
			v2 = ZERO;
		
		return sum(v1, v2, (v1.scale() > v2.scale()) ? v1.scale() : v2.scale());
	}
	
	/**
	 * Efetua a ação do segundo valor ao primeiro
	 * 
	 * @param v1
	 *            Primeiro valor
	 * @param v2
	 *            Segundo valor
	 * @param scale
	 *            Quantidade de casas decimais apos a virgula que serao
	 *            consideradas
	 * @return Um {@link BigDecimal} com o resultado da operação
	 */
	public static BigDecimal sum(BigDecimal v1, BigDecimal v2, int scale) {
		if (defaultPrecision <= 0)
			throw new RuntimeException("Escala deve ser maior que zero");
		
		// Se � nulo considera como Zero (0)
		if (v1 == null)
			v1 = ZERO;
		
		// Se � nulo considera como Zero (0)
		if (v2 == null)
			v2 = ZERO;
		
		BigDecimal r = v1.add(v2, defaultContext);
		return r.setScale(scale, defaultRounding);
	}
	
	/**
	 * Efetua a soma de todos os {@link BigDecimal}s recebidos e a retorna, considerando valores nulos como zeros.
	 * 
	 * @param vlrs
	 *            os valores a serem somados.
	 * @return um {@link BigDecimal} com o resultado da opera��o.
	 */
	public static BigDecimal sum(BigDecimal... vlrs) {
		BigDecimal result = ZERO;
		
		for (int i = 0; i < vlrs.length; i++) {
			result = result.add(LusnovaleUtil.nvl(vlrs[i], ZERO));
		}
		
		return result;
	}
	
	/**
	 * Efetua a subtraçãoo do primeiro valor com o segundo usando como escala
	 * padrao a maior escala entre os dois valores
	 * 
	 * @param v1
	 *            Primeiro valor
	 * @param v2
	 *            Segundo valor
	 * @return Um {@link BigDecimal} com o resultado da operação
	 */
	public static BigDecimal subtract(BigDecimal v1, BigDecimal v2) {
		// Se � nulo considera como Zero (0)
		if (v1 == null)
			v1 = ZERO;
		
		// Se � nulo considera como Zero (0)
		if (v2 == null)
			v2 = ZERO;
		
		return subtract(v1, v2, (v1.scale() > v2.scale()) ? v1.scale() : v2.scale());
	}
	
	/**
	 * Efetua a subtração do primeiro valor com o segundo usando
	 * 
	 * @param v1
	 *            Primeiro valor
	 * @param v2
	 *            Segundo valor
	 * @param scale
	 *            Quantidade de casas decimais apos a virgula que serao
	 * @return Um {@link BigDecimal} com o resultado da operação
	 */
	public static BigDecimal subtract(BigDecimal v1, BigDecimal v2, int scale) {
		if (defaultPrecision <= 0)
			throw new RuntimeException("Escala deve ser maior que zero");
		
		// Se � nulo considera como Zero (0)
		if (v1 == null)
			v1 = ZERO;
		
		// Se � nulo considera como Zero (0)
		if (v2 == null)
			v2 = ZERO;
		
		BigDecimal r = v1.subtract(v2, defaultContext);
		return r.setScale(scale, defaultRounding);
	}
	
	/**
	 * Efetua a divisão do primeiro valor pelo segundo usando como escala
	 * padrao a maior escala entre os dois valores
	 * 
	 * @param v1
	 *            Primeiro valor
	 * @param v2
	 *            Segundo valor
	 * @return Um {@link BigDecimal} com o resultado da operação
	 */
	public static BigDecimal divide(BigDecimal v1, BigDecimal v2) {
		// Se � nulo considera como Zero (0)
		if (v1 == null)
			v1 = ZERO;
		
		// Se � nulo considera como Zero (0)
		if (v2 == null)
			v2 = ZERO;
		
		return divide(v1, v2, (v1.scale() > v2.scale()) ? v1.scale() : v2.scale());
	}
	
	/**
	 * Efetua a divisão do primeiro valor pelo segundo
	 * 
	 * @param v1
	 *            Primeiro valor
	 * @param v2
	 *            Segundo valor
	 * @param scale
	 *            Quantidade de casas decimais apos a virgula que serao
	 * @return Um {@link BigDecimal} com o resultado da operação
	 */
	public static BigDecimal divide(BigDecimal v1, BigDecimal v2, int scale) {
		if (defaultPrecision <= 0)
			throw new RuntimeException("Escala deve ser maior que zero");
		
		// Se � nulo considera como Zero (0)
		if (v1 == null)
			v1 = ZERO;
		
		// Se � nulo considera como Zero (0)
		if (v2 == null)
			v2 = ZERO;
		
		BigDecimal r = v1.divide(v2, scale, defaultRounding);
		return r;
	}
	
	/**
	 * Efetua a divis�o do valor por 100
	 * 
	 * @param v1
	 *            Valor para divisao
	 * @param scale
	 *            Quantidade de casas decimais apos a virgula que serao
	 * @return Um {@link BigDecimal} com o resultado da operação
	 */
	public static BigDecimal divideByHundred(BigDecimal v1, int scale) {
		return divide(v1, HUNDRED, scale);
	}
	
	/**
	 * Efetua a divisão do valor por 100
	 * 
	 * @param v1
	 *            Valor para divisao
	 * @return Um {@link BigDecimal} com o resultado da operação
	 */
	public static BigDecimal divideByHundred(BigDecimal v1) {
		return divide(v1, HUNDRED);
	}
	
	/**
	 * Efetua a multiplicação do primeiro valor pelo segundo usando como escala
	 * padrao a maior escala entre os dois valores
	 * 
	 * @param v1
	 *            Primeiro valor
	 * @param v2
	 *            Segundo valor
	 * @return Um {@link BigDecimal} com o resultado da operação
	 */
	public static BigDecimal multiply(BigDecimal v1, BigDecimal v2) {
		// Se � nulo considera como Zero (0)
		if (v1 == null)
			v1 = ZERO;
		
		// Se � nulo considera como Zero (0)
		if (v2 == null)
			v2 = ZERO;
		
		return multiply(v1, v2, (v1.scale() > v2.scale()) ? v1.scale() : v2.scale());
	}
	
	/**
	 * Efetua a multiplicação do primeiro valor pelo segundo
	 * 
	 * @param v1
	 *            Primeiro valor
	 * @param v2
	 *            Segundo valor
	 * @param scale
	 *            Quantidade de casas decimais apos a virgula que serao
	 * @return Um {@link BigDecimal} com o resultado da operação
	 */
	public static BigDecimal multiply(BigDecimal v1, BigDecimal v2, int scale) {
		if (defaultPrecision <= 0)
			throw new RuntimeException("Escala deve ser maior que zero");
		
		// Se � nulo considera como Zero (0)
		if (v1 == null)
			v1 = ZERO;
		
		// Se � nulo considera como Zero (0)
		if (v2 == null)
			v2 = ZERO;
		
		BigDecimal r = v1.multiply(v2, defaultContext);
		return r.setScale(scale, defaultRounding);
	}
	
	/**
	 * Verifica se o valor informado é menor que zero
	 * 
	 * @param v1
	 *            Valor 1
	 * @return <code>true</code> se valor for menor zero
	 */
	public static boolean lessThanZero(BigDecimal v1) {
		if (v1 == null)
			return false;
		
		return (v1.compareTo(ZERO) == -1);
	}
	
	/**
	 * Verifica se o valor informado é menor ou igual a zero
	 * 
	 * @param v1
	 *            Valor 1
	 * @return <code>true</code> se valor for menor ou igual a zero
	 */
	public static boolean lessThanOrEqualToZero(BigDecimal v1) {
		if (v1 == null)
			return false;
		
		return (v1.compareTo(ZERO) == -1 || v1.compareTo(ZERO) == 0);
	}
	
	/**
	 * Verifica se o valor informado é igual a zero
	 * 
	 * @param v1
	 *            Valor 1
	 * @return <code>true</code> se valor for igual a zero
	 */
	public static boolean equalToZero(BigDecimal v1) {
		if (v1 == null)
			return false;
		
		return (v1.compareTo(ZERO) == 0);
	}
	
	/**
	 * Verifica se o valor informado é maior que zero
	 * 
	 * @param v1
	 *            Valor 1
	 * @return <code>true</code> se valor for maior que zero
	 */
	public static boolean greaterThanZero(BigDecimal v1) {
		if (v1 == null)
			return false;
		
		return (v1.compareTo(ZERO) == 1);
	}
	
	/**
	 * Verifica se o valor informado é maior que zero, considerando null como
	 * Zero
	 * 
	 * @param v1
	 *            Valor 1, se o valor informado for <code>null</code> será
	 *            considrado como Zero
	 * @return <code>true</code> se valor for maior que zero
	 */
	public static boolean greaterThanZeroNullAsZero(BigDecimal v1) {
		if (v1 == null)
			v1 = ZERO;
		
		return (v1.compareTo(ZERO) == 1);
	}
	
	/**
	 * Verifica se o valor informado é maior ou igual a zero
	 * 
	 * @param v1
	 *            Valor 1
	 * @return <code>true</code> se valor for maior ou igual a zero
	 */
	public static boolean greaterThanOrEqualToZero(BigDecimal v1) {
		if (v1 == null)
			return false;
		
		return (v1.compareTo(ZERO) == 1 || v1.compareTo(ZERO) == 0);
	}
	
	/**
	 * Verifica se o valor informado no primeiro parametro e menor que o valor
	 * informado no segundo parâmetro
	 * 
	 * @param v1
	 *            Valor 1
	 * @param v2
	 *            Valor 2
	 * @return <code>true</code> se o segundo valor for menor que o primeiro
	 */
	public static boolean lessThan(BigDecimal v1, BigDecimal v2) {
		if (v1 == null || v2 == null)
			return false;
		
		return (v1.compareTo(v2) == -1);
	}
	
	/**
	 * Verifica se o valor informado no primeiro parametro é menor ou igual que
	 * o valor informado no segundo parâmetro
	 * 
	 * @param v1
	 *            Valor 1
	 * @param v2
	 *            Valor 2
	 * @return <code>true</code> se o segundo valor for menor ou igual que o
	 *         primeiro
	 */
	public static boolean lessThanOrEqual(BigDecimal v1, BigDecimal v2) {
		if (v1 == null || v2 == null)
			return false;
		
		return (v1.compareTo(v2) == -1 || v1.compareTo(v2) == 0);
	}
	
	/**
	 * Verifica se o valor informado no primeiro parametro é igual ao valor
	 * informado no segundo parâmetro
	 * 
	 * @param v1
	 *            Valor 1
	 * @param v2
	 *            Valor 2
	 * @return <code>true</code> se o segundo valor for igual ao primeiro
	 */
	public static boolean equal(BigDecimal v1, BigDecimal v2) {
		if (v1 == null || v2 == null)
			return false;
		
		return v1.compareTo(v2) == 0;
	}
	
	/**
	 * Verifica se o valor informado no primeiro parametro é maior que o valor
	 * informado no segundo parâmetro
	 * 
	 * @param v1
	 *            Valor 1
	 * @param v2
	 *            Valor 2
	 * @return <code>true</code> se o segundo valor for maior que o primeiro
	 */
	public static boolean greaterThan(BigDecimal v1, BigDecimal v2) {
		if (v1 == null || v2 == null)
			return false;
		
		return v1.compareTo(v2) == 1;
	}
	
	/**
	 * Verifica se o valor informado no primeiro parametro é maior ou igual que
	 * o valor informado no segundo parâmetro
	 * 
	 * @param v1
	 *            Valor 1
	 * @param v2
	 *            Valor 2
	 * @return <code>true</code> se o segundo valor for maior ou igual que o
	 *         primeiro
	 */
	public static boolean greaterThanOrEqual(BigDecimal v1, BigDecimal v2) {
		if (v1 == null || v2 == null)
			return false;
		
		return (v1.compareTo(v2) == 1 || v1.compareTo(v2) == 0);
	}
	
}
