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
public class FilmeEstreia {
	
	private FilmeDAO filmeDAO;
	private FormataData formataData = new FormataData();
	
	/*Retorna os filmes em Breve(data de estreia maior que a data atual)*/
	@RequestMapping(value = {"/filmes-em-breve"})
	public ModelAndView Filme() {
		List<Filme> filmes = new ArrayList<>();
		Date data_atual = new Date();
		String erro = null;
		
		filmeDAO = new FilmeDAO();
		
		try {
			filmes = filmeDAO.listaFilmesEmBreve(formataData.formataDataYMDHM(data_atual));
		} catch (Exception e) {
			erro = "Ocorreu um erro inepserado, por favor contate o administrador";
		}
		
		for (Filme f : filmes) {
			try {
				f.setAudio(new ProgramacaoDAO().consultaAudioPorFilme(f.getId(), formataData.formataDataYMDHM(data_atual)));
				f.setQualidade(new ProgramacaoDAO().consultaQualidadePorFilme(f.getId(), formataData.formataDataYMDHM(data_atual)));
			} catch (Exception e) {
				erro = "Ocorreu um erro inepserado, por favor contate o administrador";
			}
		}
		
		ModelAndView mv = new ModelAndView("filme", "filmes", filmes);
		mv.addObject("erro", erro);
		
		return mv;
	}
	
}
