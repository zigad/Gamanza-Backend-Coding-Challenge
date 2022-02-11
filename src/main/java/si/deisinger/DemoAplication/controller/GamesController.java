package si.deisinger.DemoAplication.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import si.deisinger.DemoAplication.model.Games;
import si.deisinger.DemoAplication.service.GamesService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/games")
public class GamesController {
    @Autowired
    GamesService gamesService;

    @GetMapping("")
    public List<Games> list() {
        return gamesService.listAllGames();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Games> get(@PathVariable Long id) {
        try {
            Games games = gamesService.getGame(id);
            return new ResponseEntity<Games>(games, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Games>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("")
    public void add(@RequestBody Games games) {
        gamesService.saveGame(games);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        gamesService.deleteGame(id);
    }
}