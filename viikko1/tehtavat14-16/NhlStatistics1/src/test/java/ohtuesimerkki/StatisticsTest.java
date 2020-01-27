package ohtuesimerkki;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.*;

public class StatisticsTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
    Reader readerStub = new Reader() {
    	 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

	@Before
	public void setUp() throws Exception {
		stats = new Statistics(readerStub);
	}

	@Test
	public void testStatistics() {
		Statistics stats2 = new Statistics(readerStub);
		assertEquals(stats2.getClass(), stats.getClass());
	}
	
	@Test
	public void testSearch() {
		Player p = stats.search("Semenko");
		assertEquals("Semenko", p.getName());
	}

	@Test
	public void testSearchNull() {
		assertEquals(null, stats.search("Semnko"));
	}

	@Test
	public void testTeam() {
		assertEquals("Lemieux", stats.team("PIT").get(0).getName());
	}

	@Test
	public void testTopScorers() {
		assertEquals("Gretzky", stats.topScorers(1).get(0).getName());
	}

}
