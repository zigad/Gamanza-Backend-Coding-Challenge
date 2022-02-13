package si.deisinger.DemoAplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import si.deisinger.DemoAplication.model.Games;
import si.deisinger.DemoAplication.model.Players;
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
    public List<Games> listGames() {
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
    public ResponseEntity<Games> getGame(@PathVariable Long id) {
        try {
            Games games = gamesService.getGame(id);
            return new ResponseEntity<Games>(games, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Games>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * POST Request for creating new GAME in the database.
     * @param games
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
    public void addGame(@RequestBody Games games) {
        gamesService.saveGame(games);
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
    public Page<Games> searchGames(@RequestParam String name, @RequestParam(required = false) Integer size, @RequestParam(required = false, defaultValue = "0") int page) {
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
    public void updateGame(@RequestBody Games newGame, @PathVariable Long id) {
        Games updatedGame = gamesService.getGame(id);
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
    public List<Players> listPlayers() {
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
    public ResponseEntity<Players> getPlayer(@PathVariable Long id) {
        try {
            Players games = playersService.getPlayer(id);
            return new ResponseEntity<Players>(games, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Players>(HttpStatus.NOT_FOUND);
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
    public void addPlayer(@RequestBody Players games) {
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
    public Page<Players> searchPlayers(@RequestParam String lastName, @RequestParam(required = false) Integer size, @RequestParam(required = false, defaultValue = "0") int page) {
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
    public void updatePlayer(@RequestBody Players newPlayer, @PathVariable Long id) {
        Players updatedPlayer = playersService.getPlayer(id);
        updatedPlayer.setFirstName(newPlayer.getFirstName());
        updatedPlayer.setLastName(newPlayer.getLastName());
        updatedPlayer.setDateOfBirth(newPlayer.getDateOfBirth());
        playersService.savePlayer(updatedPlayer);
    }
}