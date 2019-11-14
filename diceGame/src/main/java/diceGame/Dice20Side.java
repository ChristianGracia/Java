package diceGame;

public class Dice20Side extends Dice {
	private int sides;
	
	public Dice20Side(int sides) {
		setSides(sides);
	}
	
	@Override
	public void roll() {
		setValue((int)(Math.random() * sides) + 1); 
	}

	public int getSides() {
		return sides;
	}

	public void setSides(int sides) {
		this.sides = sides;
	}
}
