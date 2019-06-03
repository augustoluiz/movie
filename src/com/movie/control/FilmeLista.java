package com.movie.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.movie.dao.FilmeDAO;
import com.movie.dao.ProgramacaoDAO;
import com.movie.model.Filme;

@Controller
public class FilmeLista {
	
	private FilmeDAO filmeDAO;
	private FormataData formataData = new FormataData();
	
	/*Retorna os filmes em exibição(data de estreia menor que a data atual)*/
	@RequestMapping(value = {"/"})
	public ModelAndView Filme() {
		List<Filme> cartaz = new ArrayList<>();
		List<Filme> breve = new ArrayList<>();
		Date data_atual = new Date();
		String erro = null;
		
		filmeDAO = new FilmeDAO();
		
		try {
			cartaz = filmeDAO.listaFilmesEmCartaz(formataData.formataDataYMDHM(data_atual));
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
				f.setAudio(new ProgramacaoDAO().consultaAudioPorFilme(f.getId(), formataData.formataDataYMDHM(data_atual)));
				f.setQualidade(new ProgramacaoDAO().consultaQualidadePorFilme(f.getId(), formataData.formataDataYMDHM(data_atual)));
			} catch (Exception e) {
				erro = "Ocorreu um erro inepserado, por favor contate o administrador";
			}
		}
		
		for (Filme f : breve) {
			try {
				f.setAudio(new ProgramacaoDAO().consultaAudioPorFilme(f.getId(), formataData.formataDataYMDHM(data_atual)));
				f.setQualidade(new ProgramacaoDAO().consultaQualidadePorFilme(f.getId(), formataData.formataDataYMDHM(data_atual)));
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
			
}
