package diceGame;

public class Main {

	public static void main(String[] args) {
		
		Dice dice = new Dice20Side(20);
		dice.roll();
		System.out.println(dice.getValue());
	
	}

}
