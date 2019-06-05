package com.movie.config;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
@ComponentScan("com.movie")
@EnableWebMvc   
public class Config implements WebMvcConfigurer {
	@Autowired
	ApplicationContext ctx;
	
	@Bean
	public SpringResourceTemplateResolver templateResolver(){
		SpringResourceTemplateResolver tr = new SpringResourceTemplateResolver();
		tr.setApplicationContext(this.ctx);
		tr.setPrefix("/WEB-INF/views/");
		tr.setSuffix(".html");
		tr.setTemplateMode(TemplateMode.HTML);
		tr.setCharacterEncoding("utf-8");
		tr.setCacheable(true);
		return tr;
	}
	
	@Bean
	public SpringTemplateEngine templateEngine(){
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.setEnableSpringELCompiler(true);
		return templateEngine;
	}
	
	@Bean
	public ThymeleafViewResolver viewResolver(){
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setOrder(1);
		// viewResolver.setViewNames(new String[] {".html", ".xhtml"});
		return viewResolver;
	}
	
	@Bean
	public Properties hibernateProperties() { 
		Properties p = new Properties();
		p.put("hibernate.dialect", 
				"org.hibernate.dialect.MariaDB53Dialect");
		p.put("hibernate.hbm2ddl.auto", "update");
		p.put("hibernate.format_sql", false);
		p.put("hibernate.use_sql_comments", true);
		p.put("hibernate.show_sql", true);
		p.put("hibernate.max_fetch_depth", 3);
		p.put("hibernate.jdbc.batch_size", 10);
		p.put("hibernate.jdbc.fetch_size", 50);
		p.put("hibernate.connection.pool_size",100);
		return p;
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
			registry.viewResolver(viewResolver());
	}


} 