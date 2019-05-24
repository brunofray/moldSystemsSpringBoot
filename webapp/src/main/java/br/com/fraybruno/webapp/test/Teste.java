package br.com.fraybruno.webapp.test;

import br.com.fraybruno.webapp.model.UsuarioModel;
import br.com.fraybruno.webapp.service.UsuarioService;

public class Teste {

	public static void main(String[] args) {
		
		UsuarioModel usuario = new UsuarioModel();
		UsuarioService usuarioService = new UsuarioService();
		
		usuario.setAtivo(true);
		usuario.setCodigo((long) 1);
		usuario.setLogin("brunofray");
		usuario.setNome("Bruno Fray");
		usuario.setSenha("1234");
		usuario.setGrupos(null);
		
		usuarioService.salvarUsuario(usuario);
		
		
		
	}
}
