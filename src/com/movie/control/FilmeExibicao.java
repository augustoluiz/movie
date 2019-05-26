package com.movie.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.movie.model.Filme;

@Controller
public class FilmeExibicao {
	
	@RequestMapping("/filmes-em-exibicao")
	public ModelAndView jogo() throws ParseException {
		ArrayList<Filme> filmes = new ArrayList<>();
		
		for (int i = 0; i < 10; i ++) {
			Filme filme = new Filme();
			filme.setNome("Nome"+i);
			filme.setSinopse("Sinopse"+i);
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			filme.setDuracao(sdf.parse("02:40"));
			filme.setGenero("Genero"+i);
			filme.setElenco("Elenco"+i);
			filme.setDiretor("Diretor"+i);
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			filme.setEstreia(sdf1.parse("2019-05-26"));
			filme.setTrailer("trailer"+i);
			filme.setClassifIndicativa("Classif"+i);
			filme.setPoster(null);
			filme.setDistribuidora("distribuidora"+1);
			filmes.add(filme);
		}

		ModelAndView mv = new ModelAndView("filme", "filmes", filmes);
		
		return mv;
	}
			
}
