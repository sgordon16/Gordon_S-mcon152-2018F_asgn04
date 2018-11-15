import static org.junit.Assert.*; 
import org.junit. *;


public class Bet_Test {

	static Bet bet = null;
	static MockRandomValueGenerator rand = new MockRandomValueGenerator();
	
	@Before
	void Before() {
		rand.setRandomNum(3);
		rand.setRandomDouble(0.3);
		bet = new Bet(0, rand);
	}

	@Test
	void testCanBetTrue() {
		assertTrue(bet.canBet(0));
	}
	
	@Test
	void testCanBetFalse() {
		assertFalse(bet.canBet(1));
	}

	@Test(expected = IllegalArgumentException.class)
	void testAddMoneyThrowsIllegalArgumentException() {
		bet.addMoney(-1);
	}
	

	@Test
	void testBetOnANumberWins() {
		assertEquals(1000, bet.betOnANumber(100, 0, 10, 3));
	}
	
	@Test
	void testBetOnANumberLoses() {
		assertEquals(-100,bet.betOnANumber(100, 0, 10, 4));
	}

	@Test(expected = NegativeProbabilityException.class)
	void testBetOnProbabilityThrowsNegativeProbabilityException() throws NegativeProbabilityException {
		bet.betOnProbability(100, -0.2);
	}
	
	@Test
	void testBetOnProbabilityWins() throws NegativeProbabilityException {
		assertEquals(233, bet.betOnProbability(100, 0.3));
	}
	
	@Test
	void testBetOnProbabilityLoses() throws NegativeProbabilityException {
		assertEquals(-100, bet.betOnProbability(100, 0.4));
	}

}
