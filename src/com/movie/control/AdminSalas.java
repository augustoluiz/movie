package com.movie.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.movie.dao.ProgramacaoDAO;
import com.movie.dao.SalaDAO;
import com.movie.dao.exception.DAOException;
import com.movie.model.Sala;

@Controller
public class AdminSalas {
	
	private SalaDAO salaDAO = new SalaDAO();
	private ProgramacaoDAO programacaoDAO = new ProgramacaoDAO();
	
	@RequestMapping(value = {"/admin/addSala"})
	public ModelAndView addSala(
				@ModelAttribute("sala") Sala sala) {
		
		String erro = null;
		
		try {
			salaDAO.insereSala(sala);
		} catch (DAOException e) {
			e.printStackTrace();
			erro = "Erro ao adicionar a sala";
		}
		
		ModelAndView mv = new ModelAndView("sala", "sala", sala);
		mv.addObject(erro);
		
		return mv;
	}
	
	@RequestMapping(value = {"/admin/alteraSala"})
	public ModelAndView alteraSala(
				@ModelAttribute("sala") Sala sala) {
		
		String erro = null;
		
		try {
			salaDAO.alteraSala(sala);
		} catch (DAOException e) {
			e.printStackTrace();
			erro = "Erro ao alterar a sala";
		}
		
		ModelAndView mv = new ModelAndView("sala", "sala", sala);
		mv.addObject(erro);
		
		return mv;
	}
	
	@RequestMapping(value = {"/admin/excluiSala"})
	public ModelAndView excluiSala(
				@ModelAttribute("sala") Sala sala) {
		
		String erro = null;
		
		try {
			if(programacaoDAO.consultaSalaPorProgramacao(sala.getId())) {
				erro = "Impossível excluir a sala. Ela está associada a programações";
			} else {
				salaDAO.alteraSala(sala);
			}
		} catch (DAOException e) {
			e.printStackTrace();
			erro = "Erro ao alterar a sala";
		}
		
		ModelAndView mv = new ModelAndView("sala", "sala", sala);
		mv.addObject(erro);
		
		return mv;
	}
	
}
