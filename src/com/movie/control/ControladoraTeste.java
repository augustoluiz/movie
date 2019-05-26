package com.movie.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.movie.model.Filme;
import com.movie.model.Sala;

public class ControladoraTeste {
	
	public static void main(String[] args) throws ParseException {
//	
//			Filme filme = new Filme();
//			filme.setNome("Avengers - EndGame");
//			filme.setSinopse("Filme dos Vingadores");
//			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//			filme.setDuracao(sdf.parse("03:10"));
//			filme.setGenero("Ação/Aventura");
//			filme.setElenco("Robert Downey Jr");
//			filme.setDiretor("Irmãos Russo");
//			
//			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//			filme.setEstreia(sdf1.parse("2019-04-23"));
//			filme.setTrailer("https://www.youtube.com/watch?v=TcMBFSGVi1c");
//			filme.setClassifIndicativa("12");
//			filme.setPoster(null);
//			filme.setDistribuidora("Marvel Studios");
//
//			FilmeDAO filmeDAO = new FilmeDAO();
//			
//			if(filmeDAO.insereFilme(filme)) {
//				System.out.println("Dados inseridos");
//			} else {
//				System.out.println("erro ao inserir");
//			}
//			
//			if(filmeDAO.removeFilme(10)) {
//				System.out.println("Dados excluídos");
//			} else {
//				System.out.println("erro na exclusão");
//			}
			
//			FilmeDAO fdao = new FilmeDAO();
			
//			List<Filme> filmes = new ArrayList<>();
//			filmes = fdao.consultaFilmes("Aveng");
//			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
//			filmes = fdao.listaFilmesEmCartaz(sdf2.parse("2019-04-23"));
//			filmes = fdao.listaFilmesEmBreve(sdf2.parse("2019-04-23"));
//			for(Filme f: filmes ) {
//				System.out.println(f.getNome());
//			}
			
			Sala sala = new Sala();
			
			sala.setNome("Sala 2");
			
			SalaDAO salaDAO = new SalaDAO();
			
			if(salaDAO.insereSala(sala)) {
				System.out.println("Sala inserida com sucesso");
			} else {
				System.out.println("erro ao inserir");
			}
			
			SalaDAO salaDAO1 = new SalaDAO();
			
//			if(salaDAO1.removeSala(1)) {
//				System.out.println("Sala excluída");
//			} else {
//				System.out.println("Erro ao excluir a sala");
//			}
			
			List<Sala> salas = new ArrayList<>();
			salas = salaDAO1.consultaSalas();
			
			for(Sala s: salas) {
				System.out.println(s.getNome());
			}
	}
	
}
