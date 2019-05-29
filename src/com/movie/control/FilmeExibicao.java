package com.movie.control;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.movie.dao.FilmeDAO;
import com.movie.dao.ProgramacaoDAO;
import com.movie.model.Filme;

@Controller
public class FilmeExibicao {
	
	private FormataData formataData = new FormataData();
	
	/*Retorna os filmes em exibi��o(data de estreia menor que a data atual)*/
	@RequestMapping("/filmes-em-exibicao")
	public ModelAndView Filme() throws ParseException {
		List<Filme> filmes = new ArrayList<>();
		Date data_atual = new Date();
		
		
		filmes = new FilmeDAO().listaFilmesEmCartaz(formataData.formataDataYMDHM(data_atual));
		
		for (Filme f : filmes) {
			f.setAudio(new ProgramacaoDAO().consultaAudioPorFilme(f.getId(), formataData.formataDataYMDHM(data_atual)));
			f.setQualidade(new ProgramacaoDAO().consultaQualidadePorFilme(f.getId(), formataData.formataDataYMDHM(data_atual)));	
		}
		
		ModelAndView mv = new ModelAndView("filme", "filmes", filmes);
		
		return mv;
	}
			
}
