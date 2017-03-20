package br.com.luznovale.suport;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.luznovale.data.FuncaoDao;
import br.com.luznovale.model.Funcao;
@ManagedBean
//@RequestScoped
//@ViewScoped
@ViewScoped
public class BbFuncoes {
	@EJB
	FuncaoDao dao;

	public List<Funcao> listarTodasFuncoes(){
		List<Funcao> lista = new ArrayList<Funcao>(); 
		try {
			lista =  dao.listarFuncoes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
