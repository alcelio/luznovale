/**
 * 
 */
package br.com.luznovale.util;

/**
 * Classe que guarda informações gerais do sistema e configurações básicas de
 * funcionamento;
 * 
 * @author "Alcélio Gomes {@link doalcelio@gmail.com}"
 *
 *@since 22/02/2017
 */
public class LuznonaleChaves {

	/**
	 * Parametro utilizado para buscar o código da instituição padrão;
	 */
	public final static Integer PARAM_SYS_INSTIUICAO_PADRAO = Integer.valueOf(1);

	/**
	 * Indica o nome do diretor que será colocado nas assinaturas impressas.
	 */
	public final static Integer PARAM_SYS_NOME_DIRETOR_FICHA = Integer.valueOf(2);

	/**
	 * Indica se deve exibir o nome do diretor nos formulário impresso (0- Não
	 * exibe, 1 - exibe)
	 */
	public final static Integer PARAM_SYS_IND_EXIBE_NOME_DIRETOR = Integer.valueOf(3);

	/**
	 * Guarda o valor básica das mensalidades que serão cobradas.
	 */
	public final static Integer PARAM_SYS_VALOR_MENSALIDADE = Integer.valueOf(6);

	/**
	 * Guarda a senha dos que será cadastrada de forma automática para cada novo
	 * usuáriomou quando o mesmo solicitar o reset de sua senha.
	 */
	public final static Integer PARAM_SYS_SENHA_PADRAO_NOVO_USUARIO = Integer.valueOf(7);
	
	/**
	 * Contém o título que será impresso na ficha de internação.
	 */
	public final static Integer PARAM_SYS_TITULO_FICHA_INTERNACAO = Integer.valueOf(9);
	
	/**
	 * Guarda o texto de declaração do interno, concordando com internação e as regras 
	 * da instituição, que será impressp na finha de internação
	 */
	public final static Integer PARAM_SYS_DECLARACAO_CIENCIA_INTERNACAO = Integer.valueOf(10);
	
	/**
	 * Contém o título que será impresso na ficha de internação.
	 */
	public final static Integer PARAM_SYS_TERMO_RESP_INTERNACAO = Integer.valueOf(9);
	
	/**
	 * Guarda o texto qeu será impresso como pessoa declarante nos relatórios.
	 */
	public final static Integer PARAM_SYS_PESSOA_DECLARANTE = Integer.valueOf(11); 


	/**
	 * Gurda o texto que setá adicionado na ficha de internação como ciencia de pagamento e 
	 * nao aceite de devolução de valores
	 */
	public final static Integer PARAM_SYS_CIENCIA_PAGTO_TAXA = Integer.valueOf(12);
	
	/**
	 * Indica se deve exibir no relatório a obeservação que não serão devolvidos valores pagos na taxa de inscrição. 
	 * (0- Não, 1 - sim) Valor defult 1
	 */
	public final static Integer PARAM_SYS_IND_EXIBE_OBS_DEV_TAXA = Integer.valueOf(13); 
	
	/**
	 * Guarda o texto qeu será impresso como observação de não devolução de valores.
	 */
	public final static Integer PARAM_SYS_TEXTO_OBSERVACAO_TAXA_INSCRICAO = Integer.valueOf(14); 

	
	/**
	 * Guarda o texto onde a pessoa que efetuou a internação do candidato declara ciencia e responsabilidade perante a internação.
	 */
	public final static Integer PARAM_SYS_RESPONSAVEL_INTERNACAO = Integer.valueOf(25);
	
	
	/**
	 * Guarda o valor que será exibido como título da declaração de responsabilidade de internação na ficha de internação
	 */
	public final static Integer PARAM_SYS_TITULO_TERMO_REPOSNSABILIDADE = Integer.valueOf(26);
	
	
	
	/**
	 * Guarda o texto onde interno declara estar ciente e seguir as regras da isntituição
	 */
	public final static Integer PARAM_SYS_CIENCIA_REGULAMENTO = Integer.valueOf(27);
	
}
