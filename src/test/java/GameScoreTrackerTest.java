import com.bridgelabz.content.junit.GameScoreTracker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class GameScoreTrackerTest {

    private GameScoreTracker tracker;

    @BeforeEach
    public void setUp() {
        tracker = new GameScoreTracker();
    }

    @Test
    public void testAddPlayer() {
        tracker.addPlayer("Alice");
        assertTrue(tracker.getPlayerScores().containsKey("Alice"));
    }

    @Test
    public void testRecordScore() {
        tracker.addPlayer("Bob");
        tracker.recordScore("Bob", 10);
        assertEquals(10, tracker.getPlayerScores().get("Bob"));
    }

    @Test
    public void testGetHighestScore() {
        tracker.addPlayer("Alice");
        tracker.addPlayer("Bob");
        tracker.recordScore("Alice", 10);
        tracker.recordScore("Bob", 15);
        assertEquals(15, tracker.getHighestScore().orElse(0));
    }

    @Test
    public void testGetWinnersSingleWinner() {
        tracker.addPlayer("Alice");
        tracker.recordScore("Alice", 10);
        assertEquals(Set.of("Alice"), tracker.getWinners());
    }

    @Test
    public void testGetWinnersMultipleWinners() {
        tracker.addPlayer("Alice");
        tracker.addPlayer("Bob");
        tracker.recordScore("Alice", 20);
        tracker.recordScore("Bob", 20);
        assertEquals(Set.of("Alice", "Bob"), tracker.getWinners());
    }

    @ParameterizedTest
    @CsvSource({
            "Alice, 10, Bob, 5, Alice",
            "Alice, 20, Bob, 20, Alice;Bob",
            "Alice, 15, Bob, 10, Alice"
    })
    public void testParameterizedWinners(String player1, int score1, String player2, int score2, String expectedWinners) {
        tracker.addPlayer(player1);
        tracker.addPlayer(player2);
        tracker.recordScore(player1, score1);
        tracker.recordScore(player2, score2);
        Set<String> winners = Set.of(expectedWinners.split(";"));
        assertEquals(winners, tracker.getWinners());
    }
}

