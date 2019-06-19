package com.movie.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Programacao.class)
public abstract class Programacao_ {

	public static volatile SingularAttribute<Programacao, Double> preco;
	public static volatile SingularAttribute<Programacao, Date> exibicao;
	public static volatile SingularAttribute<Programacao, Long> id_sala;
	public static volatile SingularAttribute<Programacao, String> qualidade;
	public static volatile SingularAttribute<Programacao, Long> id_filme;
	public static volatile SingularAttribute<Programacao, Long> id;
	public static volatile SingularAttribute<Programacao, String> audio;

}

