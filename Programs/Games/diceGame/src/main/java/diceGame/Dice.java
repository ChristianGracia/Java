package diceGame;

public class Dice {
	
	private int value;
	
	public Dice() {
	    roll();
	}
	public void roll() {
		setValue((int)(Math.random() * 6) + 1); 	
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}


