package br.com.luznovale.validators;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.luznovale.data.UsuarioDao;

@FacesValidator("loginValidator")
@ManagedBean
public class LoginValidator implements Validator {

	@EJB
	UsuarioDao dao;
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if (value == null) {
			return;
		}
		String login = (String) value;
		boolean isExiste = false;
		try {
				isExiste = dao.isExisteLogin(login);
		} catch (Exception e) {
			System.out.println("Erro ao verificar a existência de login na base de dados");
		}

		if (isExiste) {
			throw new ValidatorException(
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Login já foi utilizado, informe outro!", ""));
		}
	}

}