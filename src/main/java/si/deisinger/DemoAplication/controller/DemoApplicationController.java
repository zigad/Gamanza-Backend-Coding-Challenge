package si.deisinger.DemoAplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import si.deisinger.DemoAplication.model.Game;
import si.deisinger.DemoAplication.model.Player;
import si.deisinger.DemoAplication.service.GamesService;
import si.deisinger.DemoAplication.service.PlayersService;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * DemoApplicationController is responsible for CRUD (Create, Read, Update, Delete) operations for Games and Players.
 * We could create two or more separate controllers but for the sake of this assignment I chose to combine it into a single controller.
 */
@RestController
@RequestMapping("/")
public class DemoApplicationController {

    @Autowired
    GamesService gamesService;

    @Autowired
    PlayersService playersService;
    /**
     * GET Request will return all available games in the database with all available information
     * @return
     */
    @GetMapping("games")
    public List<Game> listGames() {
        return gamesService.listAllGames();
    }

    /**
     * GET Request will return specific game with all information that's available in database.
     * @param id
     * Input is game ID
     *
     * @return
     * All information available in database
     */
    @GetMapping("games/{id}")
    public ResponseEntity<Game> getGame(@PathVariable Long id) {
        try {
            Game game = gamesService.getGame(id);
            return new ResponseEntity<Game>(game, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Game>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * POST Request for creating new GAME in the database.
     * @param game
     * POST request must be Content-Type: JSON
     * Example body:
     * {
     *     "name": "Example Game",
     *     "description": "Example Game Description",
     *     "players": "7659,765,5267872,9897,787",
     *     "images": "[img.jpg]"
     * }
     */
    @PostMapping("games")
    public void addGame(@RequestBody Game game) {
        gamesService.saveGame(game);
    }

    /**
     * DELETE Request for deleting game from database
     * @param id
     * Parameter must be game ID.
     */
    @DeleteMapping("games/{id}")
    public void deleteGame(@PathVariable Long id) {
        gamesService.deleteGame(id);
    }

    /**
     * GET Request will search for the games by name
     * @param name game name we wish to search for
     * @param size number of results in single page (optional)
     * @param page select page number (default 0, also optional)
     * @return results
     */
    @GetMapping("games/search")
    public Page<Game> searchGames(@RequestParam String name, @RequestParam(required = false) Integer size, @RequestParam(required = false, defaultValue = "0") int page) {
       if (size == null){
           return gamesService.findByGameName(name);
       } else {
           Pageable paging = PageRequest.of(page, size);
           return gamesService.findByGameName(name, paging);
       }
    }

    /**
     * PUT Request for modifying existing value in database
     */
    @PutMapping("games/{id}")
    public void updateGame(@RequestBody Game newGame, @PathVariable Long id) {
        Game updatedGame = gamesService.getGame(id);
        updatedGame.setName(newGame.getName());
        updatedGame.setDescription(newGame.getDescription());
        updatedGame.setImages(newGame.getImages());
        updatedGame.setPlayers(newGame.getPlayers());
        gamesService.saveGame(updatedGame);
    }

    /**
     * GET Request will return all available players in the database with all available information
     * @return
     */
    @GetMapping("players")
    public List<Player> listPlayers() {
        return playersService.listAllPlayers();
    }


    /**
     * GET Request will return specific player with all information that's available in database.
     * @param id
     * Input is player ID
     *
     * @return
     * All information available in database
     */
    @GetMapping("players/{id}")
    public ResponseEntity<Player> getPlayer(@PathVariable Long id) {
        try {
            Player games = playersService.getPlayer(id);
            return new ResponseEntity<Player>(games, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * POST Request for creating new player in the database.
     * @param games
     * POST request must be Content-Type: JSON
     * Example body:
     * TODO
     */
    @PostMapping("players")
    public void addPlayer(@RequestBody Player games) {
        playersService.savePlayer(games);
    }

    /**
     * DELETE Request for deleting player from database
     * @param id
     * Parameter must be player ID.
     */
    @DeleteMapping("players/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playersService.deletePlayer(id);
    }

    /**
     * GET Request will search for the players by lastName
     * @param lastName player last name we wish to search for
     * @param size number of results in single page (optional)
     * @param page select page number (default 0, also optional)
     * @return results
     */
    @GetMapping("players/search")
    public Page<Player> searchPlayers(@RequestParam String lastName, @RequestParam(required = false) Integer size, @RequestParam(required = false, defaultValue = "0") int page) {
        if (size == null){
            return playersService.findByLastName(lastName);
        } else {
            Pageable paging = PageRequest.of(page, size);
            return playersService.findByLastName(lastName, paging);
        }
    }

    /**
     * PUT Request for modifying existing value in database
     */
    @PutMapping("players/{id}")
    public void updatePlayer(@RequestBody Player newPlayer, @PathVariable Long id) {
        Player updatedPlayer = playersService.getPlayer(id);
        updatedPlayer.setFirstName(newPlayer.getFirstName());
        updatedPlayer.setLastName(newPlayer.getLastName());
        updatedPlayer.setDateOfBirth(newPlayer.getDateOfBirth());
        playersService.savePlayer(updatedPlayer);
    }
}