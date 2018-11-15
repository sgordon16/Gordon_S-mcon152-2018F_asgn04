
public class MockRandomValueGenerator implements IRandomValueGenerator {
	
	private int randomInt;
	public double randomDouble;
	@Override
	public void setRandomNum(int x) {
		
		randomInt = x;
	}

	@Override
	public int getRandomIntInRange(int min, int max) {
		// TODO Auto-generated method stub
		return randomInt;
	}

	@Override
	public double getRandomDouble() {
		// TODO Auto-generated method stub
		return randomDouble;
	}

	@Override
	public void setRandomDouble(double d) {
		
		randomDouble = d;
	}

}
