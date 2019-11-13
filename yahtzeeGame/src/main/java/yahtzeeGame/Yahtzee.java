package yahtzeeGame;

import java.util.Arrays;

public class Yahtzee {
	
	private int[] diceArray = new int[5];
	private int turns = 0;
	
	public Yahtzee() {
		
		int[] fillArray = new int[5];
		
		for(int i = 0; i < 5; i++) {
			fillArray[i] = roll();
		}
		setDiceArray(fillArray);
		
	}

	public void play() {
		System.out.print("dice rolled are: ");
		System.out.println(Arrays.toString(getDiceArray()));
		while(turns < 2) {
			reroll();		
		}
		
		
		
	}
	private void reroll() {
		
		
	}

	private int roll() {
		int roll = (int)(Math.random() * 6) + 1;
		return roll;
	}
	
	private int[] getDiceArray() {
		return diceArray;
	}
	
	private void setDiceArray(int[] array) {
		this.diceArray = array;
	}
	
	
	

}

