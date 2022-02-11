package si.deisinger.DemoAplication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import si.deisinger.DemoAplication.model.Games;

public interface GamesRepository extends JpaRepository<Games, Long> {

}
