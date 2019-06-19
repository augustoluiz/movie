package com.movie.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Filme.class)
public abstract class Filme_ {

	public static volatile SingularAttribute<Filme, String> sinopse;
	public static volatile SingularAttribute<Filme, String> trailer;
	public static volatile SingularAttribute<Filme, String> elenco;
	public static volatile SingularAttribute<Filme, String> genero;
	public static volatile SingularAttribute<Filme, String> distribuidora;
	public static volatile SingularAttribute<Filme, String> nome;
	public static volatile SingularAttribute<Filme, Long> id;
	public static volatile SingularAttribute<Filme, Date> duracao;
	public static volatile SingularAttribute<Filme, Date> estreia;
	public static volatile SingularAttribute<Filme, String> classifIndicativa;
	public static volatile SingularAttribute<Filme, String> diretor;
	public static volatile SingularAttribute<Filme, byte[]> poster;

}

