package si.deisinger.DemoAplication.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import si.deisinger.DemoAplication.model.Game;

public interface GamesRepository extends JpaRepository<Game, Long> {

    @Query(value = "SELECT * FROM GAMES WHERE NAME = ?1",
            nativeQuery = true)
    Page<Game> findByName(String name, Pageable pageable);
}
