package br.com.luznovale.util;

import java.util.HashSet;
import java.util.Set;

import br.com.luznovale.model.Permissao;


public class GeraPermissoes {
	static private Set<Permissao> permissoes; 
	
	private static final Integer admin = 1;
	private static final Integer usuario =2;

	public static Set<Permissao> getPermissaoUsuario(){
		permissoes = new HashSet<Permissao>();
		Permissao  u = new Permissao();
		u.setIdPermissao(usuario);
		permissoes.add(u);
		return permissoes;
	}
	
	public static Set<Permissao> getPermissaoAdmin(){
		permissoes = new HashSet<Permissao>();
		Permissao  a = new Permissao();
		Permissao  u = new Permissao();
		a.setIdPermissao(admin);
		u.setIdPermissao(usuario);
		permissoes.add(a);
		permissoes.add(u);
		return permissoes;
	}

	
}
