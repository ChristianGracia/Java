package goFish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Game {
	
	private int turnCount = 0;
	private Player[] players = new Player[2];
	
	public Game() {
		Deck deck = new Deck();
	    setPlayers(new Player[] { new Player("Joe", deck.dealHand(deck.getDeck(), 5)), new Player("Dan", deck.dealHand(deck.getDeck(), 5))}) ;
        while(deck.getDeck().size() != 0) {
        	startTurn(getPlayers(), deck);
        }
        System.out.println("Out of cards! Game over!");
        System.out.println("Score:");
        System.out.println(getPlayers()[0].getName() + ": " + getPlayers()[0].getScore());
        System.out.println(getPlayers()[1].getName() + ": " + getPlayers()[1].getScore());
        

	}
	
	private boolean checkIfUserHasCard(int cardValue, Player player) {
		for (Card card : player.getCards()) {
			if (card.getValue() == cardValue) {
				return true;
			}
		}
		return false;
	}

	private void startTurn(Player[] players, Deck deck) {
		int cardsLeft = deck.getDeck().size();
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
		System.out.println(name + "'s turn. Press enter to see your cards    CARDS LEFT: " + cardsLeft);
		readConfirmInput();
		System.out.println("\n");
		
		Card cardMatch = null;
		boolean cardHaveCheck = false;
		int desiredCard = 0;

		while(!cardHaveCheck) {
			
			for(Card card : currentPlayer.getCards()) {
				System.out.print(card.getValue() + " " +  card.getSuit() + "     ");
			}
		System.out.println(name + ", what card you want hope to find: 2-10 J Q K A");
		 desiredCard = getDesiredCard();
		if(checkIfUserHasCard(desiredCard, currentPlayer)) {
			cardHaveCheck = true;
		   }
		else {
			System.out.println("You dont have that card!");
		}
		}
		
	
		for(Card card : otherPlayer.getCards()) {
			if(card.getValue() == desiredCard) {
				cardMatch = card;

			}
		}
		
		if(cardMatch != null) {

		   resolveCards(currentPlayer, otherPlayer, cardMatch, deck);
		}
		else {

			setTurnCount();
			System.out.println(otherPlayer.getName() + " does not have any " + desiredCard +  "'s \n\n\n\n");
		}

	}
	
	private  void resolveCards(Player currentPlayer, Player otherPlayer, Card cardMatch, Deck deck) {
		
		System.out.println(otherPlayer.getName() + " has a " + cardMatch.getValue() + " " + cardMatch.getSuit() + " for you!");
	    
	    ArrayList<Card> otherPlayerHand = otherPlayer.getCards();
	    otherPlayerHand.remove(cardMatch);
	    otherPlayer.setCards(otherPlayerHand); 
	    
	    ArrayList<Card> currentPlayerHand = currentPlayer.getCards();
	    currentPlayerHand.remove(cardMatch);
	    currentPlayer.setCards(currentPlayerHand); 
	    currentPlayer.setScore(1);
	    System.out.println("+1 points to " + currentPlayer.getName());
	    System.out.println("Current score for " + currentPlayer.getName()+ " " + currentPlayer.getScore());

		deck.drawCard(currentPlayer);
		System.out.println("\n\n\n\n");
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
				if(tryParseInt(desiredCard) && Integer.parseInt(desiredCard) > 0 && Integer.parseInt(desiredCard) < 15 ) {
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

