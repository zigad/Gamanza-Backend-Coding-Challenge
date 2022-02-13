package si.deisinger.DemoAplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import si.deisinger.DemoAplication.model.Games;
import si.deisinger.DemoAplication.repo.GamesRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GamesService {

    @Autowired
    private GamesRepository gamesRepository;

    public List<Games> listAllGames() {
        return gamesRepository.findAll();
    }

    public void saveGame(Games games) {
        gamesRepository.save(games);
    }

    public Page<Games> findByGameName(String name){
       return gamesRepository.findByName(name, Pageable.unpaged());
    }

    public Page<Games> findByGameName(String name, Pageable pageable){
        return gamesRepository.findByName(name, pageable);
    }

    public Games getGame(Long id) {
        return gamesRepository.findById(id).get();
    }

    public void deleteGame(Long id) {
        gamesRepository.deleteById(id);
    }

}