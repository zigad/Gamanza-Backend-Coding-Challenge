package si.deisinger.DemoAplication.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import si.deisinger.DemoAplication.model.Players;

public interface PlayersRepository extends JpaRepository<Players, Long> {

    @Query(value = "SELECT * FROM PLAYERS WHERE LAST_NAME = ?1",
            nativeQuery = true)
    Page<Players> findByLastName(String lastName, Pageable pageable);

}
