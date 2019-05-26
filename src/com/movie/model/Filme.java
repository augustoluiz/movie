package com.movie.model;

import java.io.File;
import java.util.Date;

public class Filme {
	
	private long id;
	private String nome;
	private String sinopse;
	private Date duracao;
	private String genero;
	private String elenco;
	private String diretor;
	private Date estreia;
	private String trailer;
	private byte[] poster;
	private String classifIndicativa;
	private String distribuidora;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public Date getDuracao() {
		return duracao;
	}
	public void setDuracao(Date duracao) {
		this.duracao = duracao;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getElenco() {
		return elenco;
	}
	public void setElenco(String elenco) {
		this.elenco = elenco;
	}
	public String getDiretor() {
		return diretor;
	}
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	public Date getEstreia() {
		return estreia;
	}
	public void setEstreia(Date estreia) {
		this.estreia = estreia;
	}
	public String getTrailer() {
		return trailer;
	}
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	public byte[] getPoster() {
		return poster;
	}
	public void setPoster(byte[] poster) {
		this.poster = poster;
	}
	public String getClassifIndicativa() {
		return classifIndicativa;
	}
	public void setClassifIndicativa(String classifIndicativa) {
		this.classifIndicativa = classifIndicativa;
	}
	public String getDistribuidora() {
		return distribuidora;
	}
	public void setDistribuidora(String distribuidora) {
		this.distribuidora = distribuidora;
	}

}
