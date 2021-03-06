package com.movie.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.movie.dao.FilmeDAO;
import com.movie.dao.ProgramacaoDAO;
import com.movie.model.Filme;
import com.movie.model.Programacao;

@Controller
public class FilmeLista {
	
	private FilmeDAO filmeDAO = new FilmeDAO();
	private FormataData formataData = new FormataData();
	private ProgramacaoDAO programacaoDAO = new ProgramacaoDAO();
	
	/*Retorna os filmes em exibi��o(data de estreia menor que a data atual)*/
	@RequestMapping(value = {"/"})
	public ModelAndView Filme() {
		List<Filme> cartaz = new ArrayList<>();
		List<Filme> breve = new ArrayList<>();
		List<Filme> remove_filme = new ArrayList<>();
		List<Programacao> prox_prog = new ArrayList<>();
		Date data_atual = new Date();
		String erro = "";
		
		
		try {
			cartaz = filmeDAO.listaFilmesEmCartaz(formataData.formataDataYMDHM(data_atual));
			for(Filme c : cartaz) {
				prox_prog = programacaoDAO.consultaProximasProgramacoes(c.getId(), data_atual);
				if(prox_prog.isEmpty()) {
					remove_filme.add(c);
				}
			}
	    	cartaz.removeAll(remove_filme);
		} catch (Exception e) {
			erro = "Ocorreu um erro inepserado, por favor contate o administrador";
		}
		
		try {
			breve = filmeDAO.listaFilmesEmBreve(formataData.formataDataYMDHM(data_atual));
		} catch (Exception e) {
			erro = "Ocorreu um erro inepserado, por favor contate o administrador";
		}
		
		for (Filme f : cartaz) {
			try {
				f.setAudio(programacaoDAO.consultaAudioPorFilme(f.getId(), formataData.formataDataYMDHM(data_atual)));
				f.setQualidade(programacaoDAO.consultaQualidadePorFilme(f.getId(), formataData.formataDataYMDHM(data_atual)));
			} catch (Exception e) {
				erro = "Ocorreu um erro inepserado, por favor contate o administrador";
			}
		}
		
		for (Filme f : breve) {
			try {
				f.setAudio(programacaoDAO.consultaAudioPorFilme(f.getId(), formataData.formataDataYMDHM(data_atual)));
				f.setQualidade(programacaoDAO.consultaQualidadePorFilme(f.getId(), formataData.formataDataYMDHM(data_atual)));
			} catch (Exception e) {
				erro = "Ocorreu um erro inepserado, por favor contate o administrador";
			}
		}
		
		ModelAndView mv = new ModelAndView("Tela Filmes Visitante");
		mv.addObject("cartaz", cartaz);
		mv.addObject("breve", breve);
		mv.addObject("erro", erro);
		
		return mv;
	}
	
	@RequestMapping(value="/pesquisaFilme/{nome}")
	public ModelAndView pesquisaFilme(@PathVariable String nome) {
		
		List<Filme> filmes = new ArrayList<>();
		String erro = "";
		Date data_atual = new Date();
		
		try {
			filmes = filmeDAO.consultaFilmes(nome);
		} catch (Exception e) {
			erro = "Erro ao consultar o filme";
		}
		
		
		for(Filme f : filmes) {
			try {
				f.setAudio(programacaoDAO.consultaAudioPorFilme(f.getId(), data_atual));
				f.setQualidade(programacaoDAO.consultaQualidadePorFilme(f.getId(), data_atual));
			} catch (Exception e) {
				erro = "Erro ao consultar a programa��o e/ou qualidade";
			}
		}
		
		
		ModelAndView mv = new ModelAndView("Tela Filmes Pesquisa", "filmes", filmes);
		mv.addObject("erro", erro);
				
		return mv;
	}
			
}
