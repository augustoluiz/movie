package com.movie.control;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@RequestMapping(value = {"/homeAdmin"}, method = RequestMethod.POST)
	public ModelAndView Filme(HttpSession session, @ModelAttribute("usuario") Usuario usuario) {
		
		if(usuarioDAO.confereUsuario(usuario.getLogin(), usuario.getSenha())) {
			session.setAttribute("usuarioLogado", usuario);
			return new ModelAndView("redirect:/adminFilme");
		} else {
			return new ModelAndView("redirect:/login");
		}
	
	}
	
	@RequestMapping(value = {"/sair"})
	public ModelAndView Filme(HttpSession session) {
		
			session.setAttribute("usuarioLogado", null);
			return new ModelAndView("redirect:/login");
	
	}
		
}
