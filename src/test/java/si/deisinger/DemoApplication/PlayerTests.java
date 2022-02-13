package si.deisinger.DemoApplication;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import si.deisinger.DemoAplication.DemoApplication;
import si.deisinger.DemoAplication.model.Player;
import si.deisinger.DemoAplication.service.PlayersService;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = DemoApplication.class)
public class PlayerTests {

    @Autowired
    PlayersService playersService;

    @Test
    public void findById() {
        Player player = playersService.getPlayer(1L);
        assertEquals(1L, player.getId());
        assertEquals("Žiga", player.getFirstName());
        assertEquals("Deisinger", player.getLastName());
    }

    @Test
    public void findByLastName() {
        Page<Player> players = playersService.findByLastName("Novak");
        for (Player player: players) {
            assertEquals("Novak", player.getLastName());
        }
    }

    @Test
    public void createAndDeletePlayer() {
        int startNumOfPlayers = playersService.listAllPlayers().size();
        Player player = new Player();
        player.setFirstName("Test");
        player.setLastName("Player1");
        Date date = new GregorianCalendar(2000, Calendar.JANUARY, 11).getTime();
        player.setDateOfBirth(date);
        playersService.savePlayer(player);

        int numOfPlayers = playersService.listAllPlayers().size();

        long createdPlayer = playersService.findByLastName("Player1").getContent().get(0).getId();
        Player lastPlayer = playersService.getPlayer(createdPlayer);
        assertEquals("Test", lastPlayer.getFirstName());
        assertEquals("Player1", lastPlayer.getLastName());
        assertEquals(numOfPlayers, playersService.listAllPlayers().size());

        playersService.deletePlayer(createdPlayer);
        assertEquals(startNumOfPlayers, playersService.listAllPlayers().size());
    }

}
