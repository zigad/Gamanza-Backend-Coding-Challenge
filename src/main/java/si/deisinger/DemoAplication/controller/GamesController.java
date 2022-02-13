package si.deisinger.DemoAplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import si.deisinger.DemoAplication.model.Games;
import si.deisinger.DemoAplication.service.GamesService;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Games Controller is responsible for CRUD (Create, Read, Update, Delete) operations for Games.
 */
@RestController
@RequestMapping("/games")
public class GamesController {

    @Autowired
    GamesService gamesService;
    /**
     * GET Request will return all available games in the database with all available information
     * @return
     */
    @GetMapping("")
    public List<Games> list() {
        return gamesService.listAllGames();
    }

    /**
     * GET Request will return specific game with all information that's available in database.
     * @param id
     * Input is game ID
     *
     * @return
     * All information avalable in database
     */
    @GetMapping("/{id}")
    public ResponseEntity<Games> get(@PathVariable Long id) {
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
    @PostMapping("")
    public void add(@RequestBody Games games) {
        gamesService.saveGame(games);
    }

    /**
     * DELETE Request for deleting game from database
     * @param id
     * Parameter must be game ID.
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        gamesService.deleteGame(id);
    }

    /**
     * GET Request will search for the games by name
     * @param name game name we wish to search for
     * @param size number of results in single page (optional)
     * @param page select page number (default 0, also optional)
     * @return results
     */
    @GetMapping("/search")
    public Page<Games> search(@RequestParam String name, @RequestParam(required = false) Integer size, @RequestParam(required = false, defaultValue = "0") int page) {
       if (size == null){
           return gamesService.findByGameName(name);
       } else {
           Pageable paging = PageRequest.of(page, size);
           return gamesService.findByGameName(name, paging);
       }
    }

    @PutMapping("/{id}")
    public void updateGame(@RequestBody Games newGame, @PathVariable Long id) {
        Games updatedGame = gamesService.getGame(id);
        updatedGame.setName(newGame.getName());
        updatedGame.setDescription(newGame.getDescription());
        updatedGame.setImages(newGame.getImages());
        updatedGame.setPlayers(newGame.getPlayers());
        gamesService.saveGame(updatedGame);
    }
}