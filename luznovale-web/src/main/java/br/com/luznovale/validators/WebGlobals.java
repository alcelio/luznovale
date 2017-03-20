package br.com.luznovale.validators;

import javax.faces.context.FacesContext;

public class WebGlobals {
	
	/**
	 * Enderco raiz da aplicação
	 */
	public static final String PATH_APLICACAO = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();


	/**
	 * Endereço da página HOME do sistema
	 */
	public static final String PAGINA_HOME = "/restrito/home.jsf";
	
	/**
	 * Endereço da página de manutenção de usuarios do sistema
	 */
	public static  final String PAGINA_MANUTENCAO_USUSARIO = "/admin/manutencaoUsuario.jsf";
	
	
	/**
	 * Endereço da página de manutenção de cidades do sistema
	 */
	public static final String PAGINA_MANUTENCAO_CIDADE = "/admin/manutencaoCidade.jsf";
	
	/**
	 * Endereço da página de manutenção de drogas
	 */
	public static final String PAGINA_MANUTENCAO_DROGA = "/admin/manutencaoDroga.jsf";
	
	/**
	 * Endereço da página de manutenção de estados do sistema
	 */
	public static final String PAGINA_MANUTENCAO_ESTADO = "/admin/manutencaoEstado.jsf";

	/**
	 * Endereço da página de manutenção de funções do sistema
	 */
	public static final String PAGINA_MANUTENCAO_FUNCAO = "/admin/manutencaoFuncao.jsf";
	
	/**
	 * Endereço da página de manutenção de instituições
	 */
	public static final String PAGINA_MANUTENCAO_INSTITUICAO = "/admin/manutencaoInstituicao.jsf";
	

	/**
	 * Endereço da página de manutenção de Parametros
	 */
	public static final String PAGINA_MANUTENCAO_PARAMETROS = "/admin/manutencaoParametros.jsf";
	
	/**
	 * Endereço da página de manutenção de Parametros do Usuário
	 */
	public static final String PAGINA_MANUTENCAO_PARAMETROS_USUARIO = "/admin/manutencaoParametrosUsuario.jsf";
	
	/**
	 * Endereço da página de manutenção de Parametros do Sistema
	 */
	public static final String PAGINA_MANUTENCAO_PARAMETROS_SISTEMA = "/admin/manutencaoParametrosSistema.jsf";
	
	

//	/**
//	 * Endereço da página de manutenção de Usuários do sistema
//	 */
//	private final String PAGINA_MANUTENCAO_USUARIO = "/admin/manutencaoUsuario.jsf";

	/**
	 * Endereço da página de manutenção de instituições
	 */
	public static final String PAGINA_REGISTRAR_INTERNACAO = "/restrito/registrarInternacao.jsf";
	

	/**
	 * Endereço da página de Objetos do Interno
	 */
	public static final String PAGINA_OBJETOS_INTERNO = "/restrito/objetosInterno.jsf";
	
	
	/**
	 * Endereço da página para pesquisar internos
	 */
	public static final String PAGINA_PESQUISA_INTERNOS = "/restrito/pesquisaInternos.jsf";
	
	/**
	 * Endereço da página para pesquisar internos
	 */
	public static final String PAGINA_PESQUISA_DROGAS = "/restrito/drogasInterno.jsf";


}
