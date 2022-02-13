package si.deisinger.DemoAplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import si.deisinger.DemoAplication.model.Game;
import si.deisinger.DemoAplication.repo.GamesRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class GamesService {

    @Autowired
    private GamesRepository gamesRepository;

    public List<Game> listAllGames() {
        return gamesRepository.findAll();
    }

    public void saveGame(Game game) {
        gamesRepository.save(game);
    }

    public Page<Game> findByGameName(String name){
       return gamesRepository.findByName(name, Pageable.unpaged());
    }

    public Page<Game> findByGameName(String name, Pageable pageable){
        return gamesRepository.findByName(name, pageable);
    }

    public Game getGame(Long id) {
        return gamesRepository.findById(id).get();
    }

    public void deleteGame(Long id) {
        gamesRepository.deleteById(id);
    }

}