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
		
//		for(Card item : player2.getCards()) {
//		System.out.print(item.getCardNumber());
//		System.out.print(" ");
//		System.out.print(item.getValue());
//		System.out.print(" ");
//		System.out.print(item.getSuit());
//		System.out.println(deck.getDeck().size());
//
//	}
	}

	private void startTurn(Player player) {
		String name = player.getName();
		System.out.println(name + "'s turn. Press enter to see your cards");
		while(!readConfirmInput());
		for(Card card : player.getCards()) {
			System.out.print(card.getValue() + " " +  card.getSuit() + "     ");
		}
		System.out.println("\n");
		
		

	}

	public int getTurnCount() {
		return turnCount;
	}

	public void setTurnCount() {
		this.turnCount = this.turnCount + 1;
	}
	
	private boolean readConfirmInput() {

		  String input = null;
		  while (input == null) {
		   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		   try {
			 
		    input = reader.readLine();
	
		    	return true;
		    } 

		   catch (IOException e) {

		    e.printStackTrace();
		   }

		 }
		  return true;
	}
//		 private boolean tryParseInt(String value) {
//		  try {
//		   Integer.parseInt(value);
//		   return true;
//		  } catch (NumberFormatException e) {
//		   return false;
//		  }
//		 }

}

