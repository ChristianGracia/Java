package goFish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Game {
	
	private int turnCount = 0;
	private Player[] players = new Player[2];
	
	public Game() {
		Deck deck = new Deck();
	    setPlayers(new Player[] { new Player("player 1", deck.dealHand(deck.getDeck(), 5)), new Player("player 2", deck.dealHand(deck.getDeck(), 5))}) ;
        while(deck.getDeck().size() != 0) {
        	startTurn(getPlayers());
        }

	}

	private void startTurn(Player[] players) {
		int turn = getTurnCount() % 2;
		Player currentPlayer = players[turn];
		Player otherPlayer;
		if(turn == 0) {
			otherPlayer = players[1];
		}
		else {
			otherPlayer = players[0];
		}
		
		String name = currentPlayer.getName();
		System.out.println(name + "'s turn. Press enter to see your cards");
		readConfirmInput();
		for(Card card : currentPlayer.getCards()) {
			System.out.print(card.getValue() + " " +  card.getSuit() + "     ");
		}
		System.out.println("\n");
		System.out.println("Enter what card you want hope to find: 2-10 J Q K A");
		int desiredCard = getDesiredCard();
		System.out.println(desiredCard);
		

//		
		for(Card card : otherPlayer.getCards()) {
			System.out.print(card.getValue() + " " +  card.getSuit() + "     ");
		}
		
		setTurnCount();

//		setTurnCount();
		

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
		 
		 int desiredIndex = 0;
		 
		 while(true) {

			String desiredCard = readConfirmInput().toLowerCase();
			if(desiredCard.length() > 0) {
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
					desiredIndex = Integer.parseInt(desiredCard);
					break;
				}
			}
			
		 }
		 return desiredIndex;
	
	 }

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

}

