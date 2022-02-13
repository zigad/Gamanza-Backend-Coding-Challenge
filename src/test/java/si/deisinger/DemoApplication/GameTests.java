package si.deisinger.DemoApplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import si.deisinger.DemoApplication.model.Game;
import si.deisinger.DemoApplication.service.GamesService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = DemoApplication.class)
public class GameTests {

	@Autowired
	GamesService gamesService;

	@Test
	public void findById() {
		Game game = gamesService.getGame(1L);
		assertEquals(1L, game.getId());
		assertEquals("Game", game.getName());
		assertEquals("Simple game", game.getDescription());
	}

	@Test
	public void findByGameName() {
		Page<Game> games = gamesService.findByGameName("Game");
		assertEquals(11, games.getContent().size());
	}

	@Test
	public void createAndDeleteGame() {
		int startNumOfGames = gamesService.listAllGames().size();
		Game game = new Game();
		game.setName("TestGame1");
		game.setDescription("Player1");
		game.setImages("[/img1.jpg]");
		game.setPlayers("[1,2,3,4,22,11]");
		gamesService.saveGame(game);

		int numOfGames = gamesService.listAllGames().size();

		long createdGame = gamesService.findByGameName("TestGame1").getContent().get(0).getId();
		Game lastGame = gamesService.getGame(createdGame);
		assertEquals("TestGame1", lastGame.getName());
		assertEquals("Player1", lastGame.getDescription());
		assertEquals("[/img1.jpg]", lastGame.getImages());
		assertEquals("[1,2,3,4,22,11]", lastGame.getPlayers());
		assertEquals(numOfGames, gamesService.listAllGames().size());

		gamesService.deleteGame(createdGame);
		assertEquals(startNumOfGames, gamesService.listAllGames().size());
	}
}
