package si.deisinger.DemoApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import si.deisinger.DemoApplication.model.Player;
import si.deisinger.DemoApplication.repo.PlayersRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PlayersService {

	@Autowired
	private PlayersRepository playersRepository;

	public List<Player> listAllPlayers() {
		return playersRepository.findAll();
	}

	public void savePlayer(Player player) {
		playersRepository.save(player);
	}

	public Page<Player> findByLastName(String lastName) {
		return playersRepository.findByLastName(lastName, Pageable.unpaged());
	}

	public Page<Player> findByLastName(String lastName, Pageable pageable) {
		return playersRepository.findByLastName(lastName, pageable);
	}

	public Player getPlayer(Long id) {
		return playersRepository.findById(id).get();
	}

	public void deletePlayer(Long id) {
		playersRepository.deleteById(id);
	}

}