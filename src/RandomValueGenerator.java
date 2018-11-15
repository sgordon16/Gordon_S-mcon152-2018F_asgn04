import java.util.Random;

public class RandomValueGenerator implements IRandomValueGenerator {
	
	Random rand = new Random();
	
	@Override
	public double getRandomDouble() {
		
		return rand.nextDouble();
	}
	@Override
	public int getRandomIntInRange(int min, int max) {
		
		return rand.nextInt((max - min) + 1) + min;
	}
	@Override
	public void setRandomNum(int x) {}
	@Override
	public void setRandomDouble(double d) {}

}
