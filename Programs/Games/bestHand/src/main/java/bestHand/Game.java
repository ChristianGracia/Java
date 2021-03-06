package bestHand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Game {

 private int roundCount = 0;
 private Player[] players = new Player[4];
 private Deck deck;

 public Game() {
  this.deck = new Deck();
  
  setPlayers(new Player[] {
   new Player("Joe", deck.dealHand(deck.getDeck(), 8)), new Player("Dan", deck.dealHand(deck.getDeck(), 8)), new Player("Cliff", deck.dealHand(deck.getDeck(), 8)), new Player("Mark", deck.dealHand(deck.getDeck(), 8))
  });

  gameLogic();

 }

private void gameLogic() {
	while (getRoundCount() < 1) {
		int counter = 0;
	    while (counter < 4) {
	    playerTurn(counter);
	    counter++;
	   }
	   setRoundCount();
	   counter = 0;
	  }
	
	System.out.println("Game over! Scoring time...\n\n");
	Scorer scorer = new Scorer(getPlayers());
	
}

private  boolean containsFace(Player player) {
    for(Card card : player.getCards()) {
        if(card != null && card.getValue() > 10) {
            return true;
        }
    }
    return false;
}

private  boolean checkFace(Player player, String[] desiredCards) {
	
	
	if(desiredCards.length > 2) {
		int[] indices = convertStringArray(desiredCards);
		
		ArrayList<Card> cards = new ArrayList<Card>();
		ArrayList<Card> currentCards = player.getCards();
		
		
		for(int i = 0; i < desiredCards.length - 1; i ++) {
			cards.add(currentCards.get(indices[i] - 1));
		}
		
		
		 for(Card card : cards) {
		        if(card.getValue() > 10) {
		            return true;
		        }
		    }
		 System.out.println("Need face card included if discarding more then 2 cards");
		    return false;
		
	}
	return true;
	

}

private void playerTurn(int counter) {
	Player currentPlayer = startTurn(counter);
	
	if(containsFace(currentPlayer)) {
		System.out.println("Face card found, must sacrifice face card for trades > 2");
	}

	String[] desiredCard = readConfirmInput().split(" ");
	
	int[] indexArr = inputValidator(desiredCard, currentPlayer);
	
	ArrayList<Card> cards = currentPlayer.getCards();


	Arrays.sort(indexArr);
	int length = indexArr.length -1;
	
	for (int i = length; i > -1; i--) {
		Card current = cards.get(indexArr[i] - 1);
		cards.remove(current);  
		deck.discardCard(current);
		
		Card newCard = deck.getNewCard();

		cards.add(newCard);
	}

	currentPlayer.setCards(cards);
	
	System.out.println("\nPress Enter to end turn\n");
   
	showCards(currentPlayer);
	readConfirmInput();
	System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
}

private Player startTurn(int counter) {

	int turn = counter;
	Player currentPlayer = players[turn];
	System.out.println("Player " + (counter + 1)+ ": " + currentPlayer.getName() + "    Round #" + (getRoundCount() + 1));
	System.out.println("Press enter to see your cards....");
	readConfirmInput();
	showCards(currentPlayer);
	System.out.println("\nEnter the numbers of each card you want to exchange. Ex: 1 4 6 7 8");
	System.out.println("You can exchange 0, 1, 2, 3, 5, or 8 cards. exchanges > 2 require a facecard in the exchange");
	
	return currentPlayer;
}

private boolean checkIndices(String[] desiredCard) {
	int[] indexArr = convertStringArray(desiredCard);
	for (int index : indexArr){
		if (index > 8 || index < 1) {
			System.out.println("Card #'s must be between 1 and 8");
			return false;
		}
		
	}
	return true;
	
	
		
	
}

private int[] inputValidator(String[] desiredCard, Player currentPlayer) {

	
	    while (!checkCardDiscardAmount(desiredCard) || !checkInput(desiredCard) || !checkFace(currentPlayer, desiredCard) || !checkIndices(desiredCard)) {
	 
	   	     System.out.println("Incorrect input! Press space to pass on discarding");
		     desiredCard = readConfirmInput().split(" ");

	     };
	     
		 return convertStringArray(desiredCard);
}

private boolean checkCardDiscardAmount(String[] desiredCard) {
	int length = desiredCard.length;
	if(length == 0 || length == 1 || length == 2 || length == 3 || length == 5 || length == 8 ) {
		return true;
	}
	System.out.println("Can only enter fibonacci amounts of cards to discard (0, 1, 2, 3, 5, 8)");
	return false;

}

private int[] convertStringArray(String[] desiredCard) {
    int[] cardIndex = new int[desiredCard.length]; 
    
    for(int i = 0; i < desiredCard.length; i++) {
   	 cardIndex[i] = Integer.parseInt(desiredCard[i]);
    }
    return cardIndex;
	
}


 private boolean checkInput(String[] desiredCard) {

  Boolean check = true;


  for (String item: desiredCard) {
   if (tryParseInt(item) == false) {
    check = false;
   }

  }
  if (check) {
   return true;
  } else {
   return false;
  }
 }

 private void showCards(Player player) {
  System.out.println(player.getName() + ", Your cards:");
  int counter = 0;
  for (Card card: player.getCards()) {

   System.out.print("[" + card.getValue() + "" + card.getSuit() + "] #" + ++counter + "     ");

  }
 }

 public int getRoundCount() {
  return roundCount;
 }

 public void setRoundCount() {
  this.roundCount = this.roundCount + 1;
 }

 public Player[] getPlayers() {
  return players;
 }

 public void setPlayers(Player[] players) {
  this.players = players;
 }


 private String readConfirmInput() {
	 String input = "";

   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

   try {

     input = reader.readLine();

    return input;
   } catch (IOException e) {

    e.printStackTrace();
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

}