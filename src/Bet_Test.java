
import org.junit.Test;

import static org.junit.Assert. *;



import org.junit.Before;

public class Bet_Test {

	static Bet bet = null;
	static MockRandomValueGenerator rand = new MockRandomValueGenerator();
	
	@Before
	public void Before() {
		rand.setRandomNum(3);
		rand.setRandomDouble(0.3);
		bet = new Bet(0, rand);
	}

	@Test
	public void testGetCurrentBalance() {
		assertEquals(bet.currentBalance, bet.getCurrentBalance());
	}
	@Test
	public void testAddMoney() {
		bet.addMoney(100);
		assertEquals(100, bet.currentBalance);
	}
	@Test
	public void testCanBetTrue() {
		assertTrue(bet.canBet(0));
	}
	
	@Test
	public void testCanBetFalse() {
		assertFalse(bet.canBet(1));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddMoneyThrowsIllegalArgumentException() {
		bet.addMoney(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testBetOnANumberThrowsIllegalArgumentException() {
		assertEquals(1000, bet.betOnANumber(-100, 0, 10, 3));
	}
	@Test
	public void testBetOnANumberWins() {
		assertEquals(1000, bet.betOnANumber(100, 0, 10, 3));
	}
	
	@Test
	public void testBetOnANumberLoses() {
		assertEquals(-100,bet.betOnANumber(100, 0, 10, 4));
	}

	@Test(expected = NegativeProbabilityException.class)
	public void testBetOnProbabilityThrowsNegativeProbabilityException() throws NegativeProbabilityException {
		bet.betOnProbability(100, -0.2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testBetOnProbabilityThrowsIllegalArgumentException() throws NegativeProbabilityException  {
		bet.betOnProbability(-100, 0.2);
	}
	@Test
	public void testBetOnProbabilityWins() throws NegativeProbabilityException {
		assertEquals(233, bet.betOnProbability(100, 0.3));
	}
	
	@Test
	public void testBetOnProbabilityLoses() throws NegativeProbabilityException {
		assertEquals(-100, bet.betOnProbability(100, 0.2));
	}

}
