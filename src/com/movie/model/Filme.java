package com.movie.model;

import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Filme {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String sinopse;
	
	@DateTimeFormat(pattern = "HH:mm")
	private Date duracao;
	private String genero;
	private String elenco;
	private String diretor;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date estreia;
	private String trailer;
	
	@Column(length = 16777215)
	private byte[] poster;

	private String classifIndicativa;
	private String distribuidora;
	
	@Transient
	private List<String> qualidade;
	
	@Transient
	private List<String> audio;
	
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
	public String getPosterBase64() {
		String stringposter = Base64.getEncoder().encodeToString(poster);
		return stringposter;
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
	public List<String> getQualidade() {
		return qualidade;
	}
	public void setQualidade(List<String> qualidade) {
		this.qualidade = qualidade;
	}
	public List<String> getAudio() {
		return audio;
	}
	public void setAudio(List<String> audio) {
		this.audio = audio;
	}

}
