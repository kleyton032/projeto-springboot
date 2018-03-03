package com.sistema.cervejaria;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

//classe de inicialização de spring boot
@SpringBootApplication
public class CervejariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CervejariaApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}
}
