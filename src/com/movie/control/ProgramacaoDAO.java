package com.movie.control;

import java.util.ArrayList;
import java.util.Date;

import com.movie.model.Filme;
import com.movie.model.Programacao;

public class ProgramacaoDAO {

	public ProgramacaoDAO(){
		
	}
	
	private boolean insereProgramacao(long id_filme, long id_sala) {
		return true;
	}
	
	private boolean removeProgramacao(long id_filme) {
		return true;
	}
	
	private ArrayList<Programacao> consultaProgramacoes(long id_filme){
		ArrayList<Programacao> programacoes = new ArrayList();
		return programacoes;
	}
	
	private ArrayList<String> consultaQualidadePorFilme(long id_filme){
		ArrayList<String> qualidade = new ArrayList<>();
		return qualidade;
	}
	
	private ArrayList<String> consultaAudioPorFilme(long id_filme){
		ArrayList<String> audio = new ArrayList<>();
		return audio;
	}
}
