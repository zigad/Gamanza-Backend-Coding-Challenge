package si.deisinger.DemoAplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import si.deisinger.DemoAplication.model.Players;
import si.deisinger.DemoAplication.repo.PlayersRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlayersService {

    @Autowired
    private PlayersRepository playersRepository;

    public List<Players> listAllPlayers() {
        return playersRepository.findAll();
    }

    public void savePlayer(Players players) {
        playersRepository.save(players);
    }

    public Page<Players> findByLastName(String lastName){
        return playersRepository.findByLastName(lastName, Pageable.unpaged());
    }

    public Page<Players> findByLastName(String lastName, Pageable pageable){
        return playersRepository.findByLastName(lastName, pageable);
    }

    public Players getPlayer(Long id) {
        return playersRepository.findById(id).get();
    }

    public void deletePlayer(Long id) {
        playersRepository.deleteById(id);
    }

}