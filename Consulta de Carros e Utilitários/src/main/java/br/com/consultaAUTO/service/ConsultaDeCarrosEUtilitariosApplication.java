package br.com.consultaAUTO.service;

import br.com.consultaAUTO.Principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ConsultaDeCarrosEUtilitariosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsultaDeCarrosEUtilitariosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Principal main = new Principal();
		main.exibeMenu();


	}
}
