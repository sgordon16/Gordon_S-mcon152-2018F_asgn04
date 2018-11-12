
public class MockRandomValueGenerater implements IRandomValueGenerator {
	
	private int randomNum;
	@Override
	public void setRandomNum(int x) {
		
		randomNum = x;
	}
	@Override
	public int getRandomNum() {
		// TODO Auto-generated method stub
		return randomNum;
	}

	@Override
	public int getRandomNumberInRange(int min, int max) {
		// TODO Auto-generated method stub
		return randomNum;
	}

}
