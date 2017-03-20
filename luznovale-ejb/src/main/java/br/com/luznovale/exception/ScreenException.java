package br.com.luznovale.exception;

import static br.com.luznovale.util.LusnovaleUtil.brakeLineChar;
import static br.com.luznovale.util.LusnovaleUtil.removerAcentos;

/**
 * Lan�ada para a exibi��o de mensagens de erro na tela
 * 
 * @author Rodrigo G. Tavares de Souza
 */
public class ScreenException extends Exception {
	private static final long serialVersionUID = 1L;

	private String	screenMessage;
	private boolean	mostraJanela	= true;
	
	/**
	 * Construtor da classe
	 * 
	 * @param screenMessage
	 *            Mensagem que ser� exibida na tela
	 * @param cause
	 *            Exce��o causadora do erro
	 */
	public ScreenException(String screenMessage, Throwable cause) {
		super(removerAcentos(screenMessage, true), cause);
		this.screenMessage = brakeLineChar(screenMessage, 40);
	}
	
	/**
	 * Construtor da classe
	 * 
	 * @param screenMessage
	 *            Mensagem que ser� exibida na tela
	 */
	public ScreenException(String screenMessage) {
		super(removerAcentos(screenMessage, true));
		this.screenMessage = brakeLineChar(screenMessage, 50);
	}
	
	/**
	 * Construtor da classe
	 * 
	 * @param screenMessage
	 *            Mensagem que ser� exibida na tela
	 */
	public ScreenException(String screenMessage, boolean mostraJanela) {
		super(removerAcentos(screenMessage, true));
		this.screenMessage = brakeLineChar(screenMessage, 50);
		this.mostraJanela = mostraJanela;
	}
	
	/**
	 * Retorna a mensagem que ser� exibida
	 * 
	 * @return String
	 */
	public String getScreenMessage() {
		if (screenMessage == null)
			screenMessage = super.getMessage();
		
		return screenMessage;
	}
	
	/**
	 * Retorna indicador que diz se deve ou n�o mostrar mensagem
	 * 
	 * @return boolean
	 */
	public boolean isMostraJanela() {
		return mostraJanela;
	}
}
