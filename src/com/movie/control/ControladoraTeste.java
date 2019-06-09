package com.movie.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.movie.dao.ProgramacaoDAO;
import com.movie.dao.SalaDAO;
import com.movie.dao.exception.DAOException;
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
			
		
			/*
			 Filme filme = new Filme();
			filme.setNome("Cidade de Deus");
			filme.setSinopse("Filme do ze pequeno");
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			filme.setDuracao(sdf.parse("02:30"));
			filme.setGenero("Ação/Drama");
			filme.setElenco("Ze pequeno e Busca pe");
			filme.setDiretor("Semaj Rednaw");
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
			filme.setEstreia(sdf1.parse("2020-04-23"));
			filme.setTrailer("https://www.youtube.com/watch?v=TcMBFSGVi1c");
			filme.setClassifIndicativa("livre");
			filme.setPoster(null);
			filme.setDistribuidora("Semaj Productions");
			 */
		
		 /*Filme filme = new Filme();
		filme.setNome("Vovo Zona 2");
		filme.setSinopse("Filme da Velha Gorda");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		filme.setDuracao(sdf.parse("01:30"));
		filme.setGenero("Comedia");
		filme.setElenco("Carinha que faz a vovo zona");
		filme.setDiretor("Semaj Rednaw");
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		filme.setEstreia(sdf1.parse("2019-04-23"));
		filme.setTrailer("https://www.youtube.com/watch?v=TcMBFSGVi1c");
		filme.setClassifIndicativa("10");
		filme.setPoster(null);
		filme.setDistribuidora("Semaj Productions");*/

//			FilmeDAO filmeDAO = new FilmeDAO();
//			try {
//				filmeDAO.insereFilme(filme);
//			} catch (DAOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
////			
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
			
//			Sala sala = new Sala();
//			
//			sala.setNome("Sala dos Vingadores");
//			sala.setId(1);
//			SalaDAO salaDAO = new SalaDAO();
//			
//			if(salaDAO.alteraSala(sala)) {
//				System.out.println("Sala inserida com sucesso");
//			} else {
//				System.out.println("erro ao inserir");
//			}
//			
//			SalaDAO salaDAO1 = new SalaDAO();
			
//			if(salaDAO1.removeSala(1)) {
//				System.out.println("Sala excluída");
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
			
//			prog.setId(1);
//			prog.setId_filme(1);
//			prog.setId_sala(2);
//			prog.setAudio("LEG");
//			
//			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//			prog.setExibicao(sdf2.parse("2019-07-26 23:12"));
//			
//			prog.setPreco(23.50);
//			prog.setQualidade("2D");
//			
//			
//			ProgramacaoDAO progDAO = new ProgramacaoDAO();
////			
//			try {
//				progDAO.insereProgramacao(prog);
//			} catch (DAOException e) {
//				e.printStackTrace();
//			}
			
//			if(progDAO.alteraProgramacao(prog)) {
//				System.out.println("Programação Inserida com sucesso");
//			} else {
//				System.out.println("Erro ao inserir programação");
//			}
			
//			ProgramacaoDAO progDAO1 = new ProgramacaoDAO();
			
//			if(progDAO1.removeProgramacao(1)) {
//				System.out.println("Programação removida com sucesso");
//			} else {
//				System.out.println("Erro ao remover programação");
//			}
			
//			List<Programacao> programacoes = new ArrayList<>();
			
//			programacoes = progDAO1.consultaProgramacoes(1);
			
//			List<String> qualidade = new ArrayList<>();
//			qualidade = progDAO1.consultaAudioPorFilme(1, sdf.parse("2019-05-26 16:45"));
//			for(String q: qualidade) {
//				System.out.println(q);
//			}
		
//			UsuarioDAO usuarioDAO = new UsuarioDAO();
//			
//			if(usuarioDAO.confereUsuario("Root", "root")) {
//				System.out.println("Usuário Cadastrado");
//			} else {
//				System.out.println("Usuário não cadastrado");
//			}
//			
//			FilmeDAO filmeDao = new FilmeDAO();
//			Filme filme = new Filme();
////			filme.setId(1);
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
//			if(filmeDao.insereFilme(filme)) {
//				System.out.println("Filme aterado com sucesso");
//			} else {
//				System.out.println("Erro ao alterar o filme");
//			}
			
//			FilmeDAO film = new FilmeDAO();
//			Filme filme = new Filme();
//			
//			try {
//				filme = film.consultaFilme(1);
//			} catch (DAOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			System.out.println("Nome: "+filme.getNome());
		
		ProgramacaoDAO programacaoDAO = new ProgramacaoDAO();
		SalaDAO salaDAO = new SalaDAO();
		Sala sala = new Sala();
		String erro = "";
		
		try {
			if(programacaoDAO.consultaSalaPorProgramacao(2)) {
				erro = "Impossível excluir a sala. Ela está associada a programações";
				System.out.println(erro);
			} else {
				salaDAO.removeSala(2);
				System.out.println("excluiu");
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
}
