package com.movie.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.movie.dao.UsuarioDAO;
import com.movie.model.Usuario;

@Controller
public class AdminLogin {
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();

	@RequestMapping(value = {"/login"})
	public ModelAndView CadastroFilme() {
		Usuario usuario = new Usuario();
		
		ModelAndView mv = new ModelAndView("Tela Login", "usuario", usuario);
	
		return mv;
	}
	
	/*Retorna os filmes em exibição(data de estreia menor que a data atual)*/
	@RequestMapping(value = {"/homeAdmin"})
	public ModelAndView Filme(@ModelAttribute("usuario") Usuario usuario) {
		
		if(usuarioDAO.confereUsuario(usuario.getLogin(), usuario.getSenha())) {
			return new ModelAndView("redirect:/adminFilme");
		} else {
			return new ModelAndView("redirect:/login");
		}
	
	}
	
}
