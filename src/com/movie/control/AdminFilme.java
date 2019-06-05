package com.movie.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.movie.dao.FilmeDAO;
import com.movie.dao.ProgramacaoDAO;
import com.movie.dao.exception.DAOException;
import com.movie.model.Filme;
import com.movie.model.Programacao;

@Controller
public class AdminFilme {
	
	private FilmeDAO filmeDAO = new FilmeDAO();
	private ProgramacaoDAO programacaoDAO = new ProgramacaoDAO();
	
	@RequestMapping(value = {"/admin/addFilme"})
	public ModelAndView addFilme(
				@ModelAttribute("filme") Filme filme) {
		
		String erro = null;
		
		try {
			filmeDAO.insereFilme(filme);;
		} catch (DAOException e) {
			e.printStackTrace();
			erro = "Erro ao adicionar o Filme";
		}
		
		ModelAndView mv = new ModelAndView("filme", "filme", filme);
		mv.addObject(erro);
		
		return mv;
	}
	
	@RequestMapping(value = {"/admin/alteraFilme"})
	public ModelAndView alteraFilme(
				@ModelAttribute("filme") Filme filme) {
		
		String erro = null;
		
		try {
			filmeDAO.alteraFilme(filme);
		} catch (DAOException e) {
			e.printStackTrace();
			erro = "Erro ao alterar o filme";
		}
		
		ModelAndView mv = new ModelAndView("filme", "filme", filme);
		mv.addObject(erro);
		
		return mv;
	}
	
	@RequestMapping(value = {"/admin/excluiFilme"})
	public ModelAndView excluiFilme(
				@ModelAttribute("filme") Filme filme) {
		
		String erro = null;
		
		try {
			if(programacaoDAO.consultaFilmePorProgramacao(filme.getId())) {
				erro = "Impossível excluir o filme. Ele está associada a programações";
			} else {
				filmeDAO.removeFilme(filme.getId());
			}
		} catch (DAOException e) {
			e.printStackTrace();
			erro = "Erro ao excluir o filme";
		}
		
		ModelAndView mv = new ModelAndView("filme", "filme", filme);
		mv.addObject(erro);
		
		return mv;
	}
	
	@RequestMapping(value = {"/admin/addProg"})
	public ModelAndView addProg(
				@ModelAttribute("programacao") Programacao programacao) {
		
		String erro = null;
		
		try {
			programacaoDAO.insereProgramacao(programacao);
		} catch (DAOException e) {
			e.printStackTrace();
			erro = "Erro ao adicionar a Programação";
		}
		
		ModelAndView mv = new ModelAndView("programacao", "programacao", programacao);
		mv.addObject(erro);
		
		return mv;
	}
	
	@RequestMapping(value = {"/admin/alteraProg"})
	public ModelAndView alteraProg(
				@ModelAttribute("programacao") Programacao programacao) {
		
		String erro = null;
		
		try {
			programacaoDAO.alteraProgramacao(programacao);
		} catch (DAOException e) {
			e.printStackTrace();
			erro = "Erro ao alterar a Programação";
		}
		
		ModelAndView mv = new ModelAndView("programacao", "programacao", programacao);
		mv.addObject(erro);
		
		return mv;
	}
	
	@RequestMapping(value = {"/admin/excluiProg"})
	public ModelAndView excluiProg(
				@ModelAttribute("programacao") Programacao programacao) {
		
		String erro = null;
		
		try {
			programacaoDAO.removeProgramacao(programacao.getId());
		} catch (DAOException e) {
			e.printStackTrace();
			erro = "Erro ao excluir a Programação";
		}
		
		ModelAndView mv = new ModelAndView("programacao", "programacao", programacao);
		mv.addObject(erro);
		
		return mv;
	}
}
