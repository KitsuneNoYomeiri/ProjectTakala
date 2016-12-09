package project.lol.lol;


import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface MatchRepository extends CrudRepository <Match, Long> {
	List<Match> findByChampion(String champion); //has to be findByChampion, if not Spring doesn't recognize it
}
