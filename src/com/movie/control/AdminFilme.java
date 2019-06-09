package com.movie.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.movie.dao.FilmeDAO;
import com.movie.dao.ProgramacaoDAO;
import com.movie.dao.SalaDAO;
import com.movie.dao.exception.DAOException;
import com.movie.model.Filme;
import com.movie.model.Programacao;
import com.movie.model.Sala;

@Controller
public class AdminFilme {
	
	private FilmeDAO filmeDAO = new FilmeDAO();
	private ProgramacaoDAO programacaoDAO = new ProgramacaoDAO();
	private SalaDAO salaDAO = new SalaDAO();
	private FormataData formataData = new FormataData();
	
	/*RequestMapping que mostra a tela de adicionar filme*/
	@RequestMapping(value = {"/admin/adicionarFilme"})
	public ModelAndView CadastroFilme() {
		Filme filme = new Filme();
		
		ModelAndView mv = new ModelAndView("Tela adicionar filme", "filme", filme);
	
		return mv;
	}
	
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
	
	/*RequestMapping que mostra a tela de alterar filme*/
	@RequestMapping(value="/admin/alteracaoFilme/{id}")
	public ModelAndView AlteracaoFilme(@PathVariable Long id) {
		
		Filme filme = new Filme();
		List<Programacao> programacoes = new ArrayList<>();
		List<Sala> salas = new ArrayList<>();
		Programacao prog = new Programacao();
		
		String erro = "";
		Date data_atual = new Date();
		
		try {
			filme = filmeDAO.consultaFilme(id);
			programacoes = programacaoDAO.consultaProximasProgramacoes(filme.getId(), formataData.formataDataYMDHM(data_atual));
			filme.setAudio(new ProgramacaoDAO().consultaAudioPorFilme(filme.getId(), formataData.formataDataYMDHM(data_atual)));
			filme.setQualidade(new ProgramacaoDAO().consultaQualidadePorFilme(filme.getId(), formataData.formataDataYMDHM(data_atual)));
			
			/*Atribui o nome da sala por programacao e insere datas na lista de dias(key do hash)*/
			for(Programacao p : programacoes) {
				p.setNome_sala(salaDAO.consultaSalaPorId(p.getId_sala()));
			}
			
			salas = salaDAO.consultaSalas();
			
		} catch (Exception e) {
			e.printStackTrace();
			erro = "Ocorreu um erro inesperado, por favor contate um administrador";
		}
		
		prog.setId_filme(id);
		
		ModelAndView mv = new ModelAndView("Tela Alterar filme", "filme", filme);
		mv.addObject("programacoes", programacoes);
		mv.addObject("prog",prog);
		mv.addObject("salas", salas);
		mv.addObject("erro", erro);
		
				
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
	
	@RequestMapping(value = {"/admin/addProg"}, method=RequestMethod.POST)
	public ModelAndView addProg(
				@ModelAttribute("programacao") Programacao programacao) {
		
		String erro = "";
		
		try {
			programacaoDAO.insereProgramacao(programacao);
		} catch (DAOException e) {
			e.printStackTrace();
			erro = "Erro ao adicionar a Programaï¿½ï¿½o";
		}
		
		//ModelAndView mv = new ModelAndView("programacao", "programacao", programacao);
		//mv.addObject(erro);
		
		//return mv;
		
		return new ModelAndView("redirect:/admin/alteracaoFilme/"+programacao.getId_filme());

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
