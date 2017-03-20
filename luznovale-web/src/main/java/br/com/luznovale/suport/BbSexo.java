package br.com.luznovale.suport;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;



import br.com.luznovale.data.SexoDao;
import br.com.luznovale.model.Sexo;

@ManagedBean(name = "bbSexo")
@RequestScoped
public class BbSexo implements Serializable {

	private static final long serialVersionUID = 1L;
//
//	List<Sexo> sexos = new ArrayList<Sexo>();
	@EJB 
	SexoDao dao = new SexoDao();
	
	public List<Sexo> getSexos() throws Exception {
		return dao.listarSexos();
	}

}
