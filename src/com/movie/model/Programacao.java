package com.movie.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Programacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private long id_sala;
	private long id_filme;
	private double preco;
	private String audio;
	private String qualidade;
	private Date exibicao;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId_sala() {
		return id_sala;
	}
	public void setId_sala(long id_sala) {
		this.id_sala = id_sala;
	}
	public long getId_filme() {
		return id_filme;
	}
	public void setId_filme(long id_filme) {
		this.id_filme = id_filme;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getAudio() {
		return audio;
	}
	public void setAudio(String audio) {
		this.audio = audio;
	}
	public String getQualidade() {
		return qualidade;
	}
	public void setQualidade(String qualidade) {
		this.qualidade = qualidade;
	}
	public Date getExibicao() {
		return exibicao;
	}
	public void setExibicao(Date exibicao) {
		this.exibicao = exibicao;
	}
	
}
