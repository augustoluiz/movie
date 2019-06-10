package com.movie.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.movie.dao.ProgramacaoDAO;
import com.movie.dao.SalaDAO;
import com.movie.dao.exception.DAOException;
import com.movie.model.Sala;
import com.movie.model.Usuario;

@Controller
public class AdminSalas {
	
	private SalaDAO salaDAO = new SalaDAO();
	private ProgramacaoDAO programacaoDAO = new ProgramacaoDAO();
	
	@RequestMapping(value = {"/admin/addSala"})
	public ModelAndView addSala(
				@ModelAttribute("sala") Sala sala) {
		
		String erro = "";
		
		try {
			salaDAO.insereSala(sala);
		} catch (DAOException e) {
			e.printStackTrace();
			erro = "Erro ao adicionar a sala";
		}
		
		return new ModelAndView("redirect:/adminFilme");

	}
	
	@RequestMapping(value = {"/admin/alteraSala/{id}"})
	public ModelAndView alteraSala(
				@ModelAttribute("sala") Sala sala) {
		
		String erro = "";
		
		try {
			salaDAO.alteraSala(sala);
		} catch (DAOException e) {
			e.printStackTrace();
			erro = "Erro ao alterar a sala";
		}
		
		return new ModelAndView("redirect:/adminFilme");

	}
	
	@RequestMapping(value = {"/admin/excluiSala/{id}"})
	public ModelAndView excluiSala(
				@ModelAttribute("sala") Sala sala) {
		
		String erro = "";
		
		try {
			if(programacaoDAO.consultaSalaPorProgramacao(sala.getId())) {
				erro = "Impossível excluir a sala. Ela está associada a programações";
			} else {
				salaDAO.removeSala(sala.getId());
			}
		} catch (DAOException e) {
			e.printStackTrace();
			erro = "Erro ao excluir a sala";
		}
		
		return new ModelAndView("redirect:/adminFilme");

	}
	
}
