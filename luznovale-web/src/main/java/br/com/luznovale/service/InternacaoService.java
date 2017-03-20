package br.com.luznovale.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;

import br.com.luznovale.data.InternacaoDao;
import br.com.luznovale.model.Internacao;
import br.com.luznovale.model.Interno;
import br.com.luznovale.model.PK.InternacaoPK;

public class InternacaoService {
	
	InternacaoPK pk;
	@EJB
	InternacaoDao dao;

	public void efetuarInternacao(Internacao internacao) throws Exception {
		if (internacao == null) {
			throw new Exception("Operação nõa permitida, entidare recebida é nula");
		}
		internacao.setDtaEntrada(new Date());
		try {
			if (internacao.getIdInternacao() == null) {
				//TODO DAR SAIDA DOS OBJETOS
				//TODO IMPRIMIR LISTA DE OBJETOS
				//TODO DAR BAIXA NOS VALORES DEPOSITADOS PELO INTERNO
				//TODO IMPRIMIR FICHA BAIXA DE INTERNO
				dao.create(internacao);
			} else {
				dao.update(internacao);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void encerrarInternacao(Internacao internacao) throws Exception {
		if (internacao == null) {
			throw new Exception("Operação nõa permitida, entidare recebida é nula");
		}
		//TODO VEREFICAR DEBITOS INTERNO
		//TODO DAR SAIDA DOS OBJETOS
		//TODO IMPRIMIR LISTA DE OBJETOS
		//TODO DAR BAIXA NOS VALORES DEPOSITADOS PELO INTERNO
		//TODO IMPRIMIR FICHA BAIXA DE INTERNO
		
		try {
			internacao.setDtaSaida(new Date());
			dao.update(internacao);;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Internacao> listarInternacaos() throws Exception{
		return dao.listarInternacaos();
	}
	
	public List<Internacao> buscaTodasInternacoesInterno(Interno interno) throws Exception{
		if(interno == null){
			throw new Exception("Operação nõa permitida, entidare recebida é nula");
		}
		return dao.buscaInternacaoInterno(interno.getIdPessoa());
	}
	
	public List<Internacao> buscaTodasInternacoesEmAberto() throws Exception{
		return dao.buscaTodasInternacoesAbertas();
	}
	
}
