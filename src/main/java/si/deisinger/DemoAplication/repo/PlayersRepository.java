package si.deisinger.DemoAplication.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import si.deisinger.DemoAplication.model.Player;

public interface PlayersRepository extends JpaRepository<Player, Long> {

    @Query(value = "SELECT * FROM PLAYERS WHERE LAST_NAME = ?1",
            nativeQuery = true)
    Page<Player> findByLastName(String lastName, Pageable pageable);

}
