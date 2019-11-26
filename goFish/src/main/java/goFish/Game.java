package goFish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Game {
	
	private int turnCount = 1;
	private Player[] players = new Player[2];
	
	public Game() {
		Deck deck = new Deck();
	    setPlayers(new Player[] { new Player("player 1", deck.dealHand(deck.getDeck(), 5)), new Player("player 2", deck.dealHand(deck.getDeck(), 5))}) ;
        while(deck.getDeck().size() != 0) {
        	startTurn(getPlayers()[getTurnCount() % 2]);
        }

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
		int desiredCard = getDesiredCard();
		System.out.println(desiredCard);
		setTurnCount();
		

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
	
	 private boolean tryParseInt(String value) {
		  try {
		   Integer.parseInt(value);
		   return true;
		  } catch (NumberFormatException e) {
		   return false;
		  }
		 }
	 
	 private int getDesiredCard() {

			String desiredCard = readConfirmInput().toLowerCase();
			if(desiredCard.charAt(0) == 'j') {
				desiredCard = "11";
			}
			else if (desiredCard.charAt(0) == 'q') {
				desiredCard = "12";
			}
			else if (desiredCard.charAt(0) == 'k') {
				desiredCard = "13";
			}
			else if (desiredCard.charAt(0) == 'a') {
				desiredCard = "1";
			}
			if(tryParseInt(desiredCard) && Integer.parseInt(desiredCard) > 0 && Integer.parseInt(desiredCard) < 15) {
				return Integer.parseInt(desiredCard);
			}
			else {
				return 0;
			
			}
	
	 }

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

}

