import java.util.Random;

public class RandomValueGenerator implements IRandomValueGenerator {
	
	Random rand = new Random();
	int randomNum;
	@Override
	public int getRandomNum() {
		// TODO Auto-generated method stub
		return randomNum;
	}

	@Override
	public int getRandomNumberInRange(int min, int max) {
		// TODO Auto-generated method stub
		return rand.nextInt((max - min) + 1) + min;
	}

	@Override
	public void setRandomNum(int x) {
		// TODO Auto-generated method stub
		return;
	}

}
