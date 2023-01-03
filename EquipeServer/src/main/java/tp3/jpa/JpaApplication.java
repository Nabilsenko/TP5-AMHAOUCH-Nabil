package tp3.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tp3.jpa.dao.EquipeRepository;
import tp3.jpa.model.Equipe;

import java.util.Date;
@SpringBootApplication
@EnableJpaRepositories("tp3.jpa.dao")
@EntityScan("tp3.jpa.model")
@EnableDiscoveryClient
@ComponentScan(basePackages = "tp3.jpa.controller")
public class JpaApplication {
	private static final Logger log = LoggerFactory.getLogger(JpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(EquipeRepository repository) {
		return (args) -> {
			repository.save((new Equipe(1, "FCB", "Spain", 88000, new Date())));
			repository.save((new Equipe(2, "PSG", "France", 70000, new Date())));

			log.info("Affichagge de toutes les equipes --(findAll)------");
			for (Equipe e : repository.findAll()){
				System.out.println(e.toString());
			}
//			log.info(repository.findById(1).toString());

		};
	}

}
