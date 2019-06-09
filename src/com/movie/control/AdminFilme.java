package com.movie.control;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
	
	/*RequestMapping que recebe os dados do form*/
	@RequestMapping(value = {"/admin/addFilme"}, method=RequestMethod.POST)
	public ModelAndView addFilme(@ModelAttribute("filme") Filme filme, @RequestParam(value = "affs") MultipartFile files) throws IOException {
		
		String trailer;
		String erro = "";
	
		try {
			filme.setPoster(files.getBytes());
			if(!filme.getTrailer().isEmpty()) {
				trailer = filme.getTrailer().substring(0, 24) +"embed/"+ filme.getTrailer().substring(32, filme.getTrailer().length());
				filme.setTrailer(trailer);
			}
			filmeDAO.insereFilme(filme);
		} catch (IOException | DAOException e ) {
			e.printStackTrace();
			erro = "Erro ao adicionar o Filme";
		}
		
		ModelAndView mv = new ModelAndView("Tela adicionar filme", "filme", filme);
		mv.addObject(erro);
		
		return mv;
	}
	
	/*RequestMapping que mostra a tela de adicionar/editar filme*/
	@RequestMapping(value = {"/admin/adicionarFilme"})
	public ModelAndView CadastroFilme() {
		Filme filme = new Filme();
		
		ModelAndView mv = new ModelAndView("Tela adicionar filme", "filme", filme);
	
		return mv;
	}
	
	/*RequestMapping que altera o filme cadastrado*/
	@RequestMapping(value = {"/admin/alteraFilme"}, method=RequestMethod.POST)
	public ModelAndView alteraFilme(@ModelAttribute("filme") Filme filme, @RequestParam(value = "affs") MultipartFile files) {
		
		String trailer;
		String erro = "";
		
		try {
			filme.setPoster(files.getBytes());
			if(!filme.getTrailer().isEmpty()) {
				trailer = filme.getTrailer().substring(0, 24) +"embed/"+ filme.getTrailer().substring(32, filme.getTrailer().length());
				filme.setTrailer(trailer);
			}
			filmeDAO.alteraFilme(filme);
		} catch (IOException | DAOException e) {
			e.printStackTrace();
			erro = "Erro ao alterar o filme";
		}
		
		ModelAndView mv = new ModelAndView("filme", "filme", filme);
		mv.addObject(erro);
		
		return mv;
	}
	
	/*RequestMapping que exclui o registro do banco*/
	@RequestMapping(value = {"/admin/excluiFilme"})
	public ModelAndView excluiFilme(
				@ModelAttribute("filme") Filme filme) {
		
		String erro = "";
		
		try {
			if(programacaoDAO.consultaFilmePorProgramacao(filme.getId())) {
				erro = "Impossivel excluir o filme. Ele esta associado a programaçoes";
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
		
		String erro = "";
		
		try {
			programacaoDAO.insereProgramacao(programacao);
		} catch (DAOException e) {
			e.printStackTrace();
			erro = "Erro ao adicionar a Programaï¿½ï¿½o";
		}
		
		ModelAndView mv = new ModelAndView("programacao", "programacao", programacao);
		mv.addObject(erro);
		
		return mv;
	}
	
	@RequestMapping(value = {"/admin/alteraProg"})
	public ModelAndView alteraProg(
				@ModelAttribute("programacao") Programacao programacao) {
		
		String erro = "";
		
		try {
			programacaoDAO.alteraProgramacao(programacao);
		} catch (DAOException e) {
			e.printStackTrace();
			erro = "Erro ao alterar a Programaï¿½ï¿½o";
		}
		
		ModelAndView mv = new ModelAndView("programacao", "programacao", programacao);
		mv.addObject(erro);
		
		return mv;
	}
	
	@RequestMapping(value = {"/admin/excluiProg"})
	public ModelAndView excluiProg(
				@ModelAttribute("programacao") Programacao programacao) {
		
		String erro = "";
		
		try {
			programacaoDAO.removeProgramacao(programacao.getId());
		} catch (DAOException e) {
			e.printStackTrace();
			erro = "Erro ao excluir a Programaï¿½ï¿½o";
		}
		
		ModelAndView mv = new ModelAndView("programacao", "programacao", programacao);
		mv.addObject(erro);
		
		return mv;
	}
}
