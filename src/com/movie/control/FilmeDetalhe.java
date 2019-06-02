package com.movie.control;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.movie.dao.FilmeDAO;
import com.movie.dao.ProgramacaoDAO;
import com.movie.model.Filme;

@Controller
public class FilmeDetalhe {
	
	private FilmeDAO filmeDAO = new FilmeDAO();
	private FormataData formataData = new FormataData();
	
	@RequestMapping(value="/filme/{id}")
	public ModelAndView DetalheFilme(@PathVariable Long id) {
		Filme filme = new Filme();
		String erro = null;
		Date data_atual = new Date();
		
		try {
			filme = filmeDAO.consultaFilme(id);
			
			filme.setAudio(new ProgramacaoDAO().consultaAudioPorFilme(id, formataData.formataDataYMDHM(data_atual)));
			filme.setQualidade(new ProgramacaoDAO().consultaQualidadePorFilme(id, formataData.formataDataYMDHM(data_atual)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		ModelAndView mv = new ModelAndView("detalhe", "filme", filme);
		mv.addObject("erro", erro);
		
		return mv;
	}
	
//	@RequestMapping
//	public ModelAndView Filme() {
//		Filme filme = new Filme();
//		String erro = null;
//		
//		filmeDAO = new FilmeDAO();
//		
//		try {
//			filme = filmeDAO.listaFilmesEmBreve(formataData.formataDataYMDHM(data_atual));
//		} catch (Exception e) {
//			erro = "Ocorreu um erro inepserado, por favor contate o administrador";
//		}
//		
//		for (Filme f : filmes) {
//			try {
//				f.setAudio(new ProgramacaoDAO().consultaAudioPorFilme(f.getId(), formataData.formataDataYMDHM(data_atual)));
//				f.setQualidade(new ProgramacaoDAO().consultaQualidadePorFilme(f.getId(), formataData.formataDataYMDHM(data_atual)));
//			} catch (Exception e) {
//				erro = "Ocorreu um erro inepserado, por favor contate o administrador";
//			}
//		}
//		
//		ModelAndView mv = new ModelAndView("filme", "filmes", filmes);
//		mv.addObject("erro", erro);
//		
//		return mv;
//	}

}
