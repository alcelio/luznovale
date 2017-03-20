package br.com.luznovale.exception;

/**
 * Lancada quando ocorrem erros no processamento das regras de negócios
 * 
 */
public class RegrasException extends ScreenException {
	private static final long serialVersionUID = 1L;

	/**
	 * @param screenMessage
	 *            String
	 * @param cause
	 *            Throwable
	 */
	public RegrasException(String screenMessage, Throwable cause) {
		super(screenMessage, cause);
	}
	
	/**
	 * @param screenMessage
	 *            String
	 */
	public RegrasException(String screenMessage) {
		super(screenMessage);
	}
	
}
