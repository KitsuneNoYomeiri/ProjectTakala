package project.lol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import project.lol.lol.User;
import project.lol.lol.UserRepository;
import project.lol.lol.Category;
import project.lol.lol.CategoryRepository;
import project.lol.lol.Match;
import project.lol.lol.MatchRepository;


@SpringBootApplication
public class ProjectlolApplication {
	private static final Logger log = LoggerFactory.getLogger(ProjectlolApplication.class); // to create a logger for writing wanted details into console
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectlolApplication.class, args); //runs the app
	}
	
	@Bean
	public CommandLineRunner matchDemo(MatchRepository repository, CategoryRepository crepository, UserRepository urepository) {		//Command line runner 
		return(args) -> {
			log.info("Save some matches");
			
			// creating map categories
			crepository.save(new Category("Summoner's Rift"));
			crepository.save(new Category("Twisted Treeline"));
			crepository.save(new Category("Howling Abyss"));
			
			//saving example matches
			repository.save(new Match("Nidalee", "Jungle", 20, 5, 10, 180, 38.42, "Victory", crepository.findByMapname("Summoner's Rift").get(0)));
			repository.save(new Match("Jinx", "Top", 12, 2, 4, 250, 23.42, "Victory", crepository.findByMapname("Twisted Treeline").get(0)));
			repository.save(new Match("Quinn", "Air-Force", 12, 11, 32, 15, 30.42, "Defeat", crepository.findByMapname("Howling Abyss").get(0)));
			
			//Create default users
			User user1 = new User("user", "$2a$04$J2AH4PPW382lfKAQx6SBAONo7l/e21bhLCe.bZGY93ndyFO/frpQO", "USER");
			//user password = 'user'
			User user2 = new User("admin", "$2a$04$FRP6wG0k8sNoXYOgaYwM/OjRin7QlNvpI.I6zrFrw.PvoRvfs0kb2", "ADMIN");
			//admin password = 'admin'
			urepository.save(user1);
			urepository.save(user2);
		
		//show all matches in console
		log.info("fetch all matches");
		for(Match match : repository.findAll()) {
			log.info(match.toString());
			}
		};
	}
}

	
	



