package br.com.luznovale.util;

public class LuzNovaleGlobal {
	/**
	 * Guarda descricao do tipo de usuario admin;
	 */
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	
	/**
	 * Guarda descricao do tipo de usuario usuario padrão;
	 */
	public static final String ROLE_USUARIO = "ROLE_USUARIO";
	
	/**
	 * Informa o tipo de permissão de ussuario 2 = usuario nomal
	 */
	public static final Integer PERMISSAO_USUARIO = 2;
	
	/**
	 * Informa o tipo de permissão de ussuario 1 = admin
	 */
	public static final Integer PERMISSAO_ADMIN = 1;

	public static final String SENHA_PADRAO = "valeluz";
	
	/**
	 * Armazena string que seta usada como chave para colocar e retirar um obejeto ususario na secessao
	 */
	public static final String USUARIO_PRIMEIRO_ACESSO = "usuarioPrimeiroAcesso";
	
	/**
	 * Retorna endereço para a página HOME do sistema
	 */
	public static final String PAGINA_HOME = "/restrito/home.jsf";
	
	
}
