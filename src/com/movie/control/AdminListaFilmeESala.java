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
import com.movie.dao.SalaDAO;
import com.movie.model.Filme;
import com.movie.model.Sala;


@Controller
public class AdminListaFilmeESala {
	
	private FilmeDAO filmeDAO = new FilmeDAO();
	private ProgramacaoDAO programacaoDAO = new ProgramacaoDAO();
	private SalaDAO salaDAO = new SalaDAO();
	
	private FormataData formataData = new FormataData();
	
	
	/*Retorna os filmes em exibição(data de estreia menor que a data atual)*/
	@RequestMapping(value = {"/adminFilme"})
	public ModelAndView Filme() {
		
		List<Filme> filmes = new ArrayList<>();
		List<Sala> salas = new ArrayList<>();
		Date data_atual = new Date();
		Sala sala = new Sala();
		String erro = "";
		
		try {
				filmes = filmeDAO.listaFilmesCadastrados();
				salas = salaDAO.consultaSalas();
				
				for (Filme f : filmes) {
					try {
						f.setAudio(programacaoDAO.consultaAudioPorFilme(f.getId(), formataData.formataDataYMDHM(data_atual)));
						f.setQualidade(programacaoDAO.consultaQualidadePorFilme(f.getId(), formataData.formataDataYMDHM(data_atual)));
					} catch (Exception e) {
						erro = "Ocorreu um erro inepserado, por favor contate o administrador";
					}
				}
		} catch (Exception e) {
			erro = "Ocorreu um erro inepserado, por favor contate o administrador";
		}
		
		ModelAndView mv = new ModelAndView("Tela Filmes e Salas Administrador");
		mv.addObject("filmes", filmes);
		mv.addObject("salas", salas);
		mv.addObject("sala", sala);
		mv.addObject("erro", erro);
		
		return mv;
	}
	
	@RequestMapping(value = {"/adminFilme/{erro}"})
	public ModelAndView FilmeErro(@PathVariable String erro) {
		
		List<Filme> filmes = new ArrayList<>();
		List<Sala> salas = new ArrayList<>();
		Date data_atual = new Date();
		Sala sala = new Sala();
		System.out.println(erro);

		
		try {
				filmes = filmeDAO.listaFilmesCadastrados();
				salas = salaDAO.consultaSalas();
				
				for (Filme f : filmes) {
					try {
						f.setAudio(programacaoDAO.consultaAudioPorFilme(f.getId(), formataData.formataDataYMDHM(data_atual)));
						f.setQualidade(programacaoDAO.consultaQualidadePorFilme(f.getId(), formataData.formataDataYMDHM(data_atual)));
					} catch (Exception e) {
						erro = "Ocorreu um erro inepserado, por favor contate o administrador";
					}
				}
		} catch (Exception e) {
			erro = "Ocorreu um erro inepserado, por favor contate o administrador";
		}
		
		ModelAndView mv = new ModelAndView("Tela Filmes e Salas Administrador");
		mv.addObject("filmes", filmes);
		mv.addObject("salas", salas);
		mv.addObject("sala", sala);
		mv.addObject("erro", erro);
		
		return mv;
	}
	
	@RequestMapping(value="/admin/pesquisaFilme/{nome}")
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
				erro = "Erro ao consultar a programação e/ou qualidade";
			}
		}
		
		
		ModelAndView mv = new ModelAndView("Tela Filmes Pesquisa Admin", "filmes", filmes);
		mv.addObject("erro", erro);
				
		return mv;
	}
}
