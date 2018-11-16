
public class Bet {
	
	protected int minBalance;
	protected int currentBalance;
	private IRandomValueGenerator rand;

	public Bet(int minBalance, IRandomValueGenerator rand) {
		
		this.minBalance = minBalance;
		this.rand = rand;
	}
	public int getCurrentBalance() {
		
		return currentBalance;
	}
	public boolean canBet(int amnt) {
		
		return (currentBalance - amnt) >= minBalance;
	}
	public void addMoney(int amnt) {
		
		if(amnt < 0)
			throw new IllegalArgumentException("Cannot add negative ammounts");
		else
			currentBalance += amnt;
	}
	public int betOnANumber(int amnt, int min, int max, int selectedNumber) {
		
		if(amnt < 0)
			throw new IllegalArgumentException("Cannot bet negative ammounts");
		
		if(rand.getRandomIntInRange(min, max) != selectedNumber) {
			currentBalance -= amnt;
			return -amnt;
		}
		else {
			currentBalance += (max - min) * amnt;
			return (max - min) * amnt;
		}
	}
	public int betOnProbability(int amnt, double p) throws NegativeProbabilityException {
		
		if(amnt < 0)
			throw new IllegalArgumentException("Cannot bet negative ammounts");
		if(p < 0)
			throw new NegativeProbabilityException();
		if(rand.getRandomDouble() <= p) {
			currentBalance += (int) ((Math.pow(p, -1) -1) * amnt);
			return (int) ((Math.pow(p, -1) -1) * amnt);
		}
		else {
			currentBalance -= amnt;
			return -amnt;
		}
	}
}
