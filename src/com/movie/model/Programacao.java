package com.movie.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

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
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date exibicao;
	
	@Transient
	private String nome_sala;
	
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
	public String getNome_sala() {
		return nome_sala;
	}
	public void setNome_sala(String nome_sala) {
		this.nome_sala = nome_sala;
	}
	
}
