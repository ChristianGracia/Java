package goFish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Game {
	
	private int turnCount;
	
	public Game() {
		Deck deck = new Deck();
		Player player1 = new Player("player 1", deck.dealHand(deck.getDeck(), 5));
		Player player2 =  new Player("player 2", deck.dealHand(deck.getDeck(), 5)); 
		startTurn(player1);
	}

	private void startTurn(Player player) {
		String name = player.getName();
		System.out.println(name + "'s turn. Press enter to see your cards");
		readConfirmInput();
		for(Card card : player.getCards()) {
			System.out.print(card.getValue() + " " +  card.getSuit() + "     ");
		}
		System.out.println("\n");
		System.out.println("Enter what card you want hope to find: 2-10 J Q K A");

		String desiredCard = readConfirmInput();
		if(desiredCard.toLowerCase() == "j") {
			desiredCard = "11";
		}
		else if (desiredCard.toLowerCase() == "q") {
			desiredCard = "12";
		}
		else if (desiredCard.toLowerCase() == "k") {
			desiredCard = "13";
		}
		else if (desiredCard.toLowerCase() == "a") {
			desiredCard = "1";
		}
		
		

	
		
			
		

	}

	public int getTurnCount() {
		return turnCount;
	}

	public void setTurnCount() {
		this.turnCount = this.turnCount + 1;
	}
	
	private String readConfirmInput() {

		  String input = null;
		  while (input == null) {
		   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		   try {
			 
		    input = reader.readLine();
	
		    	return input;
		    } 

		   catch (IOException e) {

		    e.printStackTrace();
		   }

		 }
		  return input;
	}
	
	 

}

