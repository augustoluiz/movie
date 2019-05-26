package com.movie.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.movie.dao.ProgramacaoDAO;
import com.movie.dao.UsuarioDAO;
import com.movie.model.Filme;
import com.movie.model.Programacao;
import com.movie.model.Sala;

public class ControladoraTeste {
	
	public static void main(String[] args) throws ParseException {
//	
//			Filme filme = new Filme();
//			filme.setNome("Avengers - EndGame");
//			filme.setSinopse("Filme dos Vingadores");
//			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//			filme.setDuracao(sdf.parse("03:10"));
//			filme.setGenero("A��o/Aventura");
//			filme.setElenco("Robert Downey Jr");
//			filme.setDiretor("Irm�os Russo");
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
//				System.out.println("Dados exclu�dos");
//			} else {
//				System.out.println("erro na exclus�o");
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
			
//			Sala sala = new Sala();
//			
//			sala.setNome("Sala 2");
//			
//			SalaDAO salaDAO = new SalaDAO();
//			
//			if(salaDAO.insereSala(sala)) {
//				System.out.println("Sala inserida com sucesso");
//			} else {
//				System.out.println("erro ao inserir");
//			}
//			
//			SalaDAO salaDAO1 = new SalaDAO();
			
//			if(salaDAO1.removeSala(1)) {
//				System.out.println("Sala exclu�da");
//			} else {
//				System.out.println("Erro ao excluir a sala");
//			}
			
//			List<Sala> salas = new ArrayList<>();
//			salas = salaDAO1.consultaSalas();
//			
//			for(Sala s: salas) {
//				System.out.println(s.getNome());
//			}
		
//			Programacao prog = new Programacao();
//			
//			prog.setId_filme(1);
//			prog.setId_sala(2);
//			prog.setAudio("DUB");
//			
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//			prog.setExibicao(sdf.parse("2019-05-26 18:42"));
//			
//			prog.setPreco(23.50);
//			prog.setQualidade("3D");
//			
//			ProgramacaoDAO progDAO = new ProgramacaoDAO();
//			
//			if(progDAO.insereProgramacao(prog)) {
//				System.out.println("Programa��o Inserida com sucesso");
//			} else {
//				System.out.println("Erro ao inserir programa��o");
//			}
//			
//			ProgramacaoDAO progDAO1 = new ProgramacaoDAO();
			
//			if(progDAO1.removeProgramacao(1)) {
//				System.out.println("Programa��o removida com sucesso");
//			} else {
//				System.out.println("Erro ao remover programa��o");
//			}
			
//			List<Programacao> programacoes = new ArrayList<>();
			
//			programacoes = progDAO1.consultaProgramacoes(1);
			
//			List<String> qualidade = new ArrayList<>();
//			qualidade = progDAO1.consultaAudioPorFilme(1, sdf.parse("2019-05-26 16:45"));
//			for(String q: qualidade) {
//				System.out.println(q);
//			}
		
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			
			if(usuarioDAO.confereUsuario("Root", "root")) {
				System.out.println("Usu�rio Cadastrado");
			} else {
				System.out.println("Usu�rio n�o cadastrado");
			}
			
	}
	
}
