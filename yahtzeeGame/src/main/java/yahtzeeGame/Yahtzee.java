package yahtzeeGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Yahtzee {
	
	private int[] diceArray = new int[5];
	private int turns = 0;
	
	public Yahtzee() {
	   fillArray();
	}
	
	private void fillArray() {
		int[] fillArray = new int[5];
		
		for(int i = 0; i < 5; i++) {
			fillArray[i] = roll();
		}
		setDiceArray(fillArray);
	}

	public void play() {
		System.out.println("Welcome to Yahztee");

		while(turns < 2) {
			reroll();		
		}
		System.out.println(Arrays.toString(getDiceArray()));
		System.out.println("Game Over!");
		
	}
	private void reroll() {
		int[] currentArray = getDiceArray();
		System.out.print("Dice rolled are: ");
		System.out.println(Arrays.toString(currentArray));
		System.out.println("Enter 1-5 to select die to be rolled, then send a letter to break and roll all selected");
		readWantedRerolls();
		setTurns();
		boolean check = checkYahtzee();
		if (check) {
			System.out.println("Yahztee!");
			setTurns();
			setTurns();
		}
	}

	private boolean checkYahtzee() {
	
		int[] checkYahtzee = getDiceArray();
		int num = checkYahtzee[0];
		boolean check = true;
		for(int i = 1; i < 5; i++) {
			if(checkYahtzee[i] != num) {
				check = false;
			}
		}
		return check;
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
	private int getTurns() {
		return turns;
	}
	
	private void setTurns() {
		this.turns = getTurns() + 1;
	}
	private void readWantedRerolls() {
	

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); 

        String indices = "0";
		int[] temp = getDiceArray();
        while (tryParseInt(indices) && Integer.parseInt(indices) < 6 && Integer.parseInt(indices) > -1) {
        	try {
    			indices = reader.readLine();
    			if(tryParseInt(indices) && Integer.parseInt(indices) < 7 && Integer.parseInt(indices) > -1) {
    				temp[Integer.parseInt(indices) - 1] = roll();
    			}
    			else {
    				System.out.println("Incorrect input. Rolling selected");
    				
    			}
    	
    			
    		} catch (IOException e) {
    			e.printStackTrace();
    	
    		} 
        	
        }
        setDiceArray(temp);
	
	}
	private boolean tryParseInt(String value) {  
	     try {  
	         Integer.parseInt(value);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}
}

