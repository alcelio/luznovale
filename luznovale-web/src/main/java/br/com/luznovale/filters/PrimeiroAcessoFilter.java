package br.com.luznovale.filters;

import static br.com.luznovale.util.LuzNovaleGlobal.USUARIO_PRIMEIRO_ACESSO;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.luznovale.model.Usuario;

@javax.servlet.annotation.WebFilter("/restrito/*")
public class PrimeiroAcessoFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain arg2)
			throws IOException, ServletException {

		HttpServletRequest rq = (HttpServletRequest) req;
		HttpServletResponse res = (HttpServletResponse) resp;
		String uri = null;

		arg2.doFilter(req, resp);

		try {
			uri = rq.getRequestURI();

			if (uri.contains("home.jsf")) {
			
				Usuario usr = (Usuario) rq.getSession().getAttribute(USUARIO_PRIMEIRO_ACESSO);
				
				if (usr != null) {
					res.sendRedirect(rq.getContextPath() + "/publico/atualizarSenha.jsf");
					arg2.doFilter(rq, resp);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
