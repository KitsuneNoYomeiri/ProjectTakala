package project.lol.lol;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findByMapname(String mapname); //has to be Mapname
}
