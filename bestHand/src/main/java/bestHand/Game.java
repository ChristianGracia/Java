package bestHand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

 private int roundCount = 0;
 private Player[] players = new Player[4];

 public Game() {
  Deck deck = new Deck();
  setPlayers(new Player[] {
   new Player("Joe", deck.dealHand(deck.getDeck(), 8)), new Player("Dan", deck.dealHand(deck.getDeck(), 8)), new Player("Cliff", deck.dealHand(deck.getDeck(), 8)), new Player("Mark", deck.dealHand(deck.getDeck(), 8))
  });

  gameLogic();

 }

private void gameLogic() {
	while (getRoundCount() < 5) {
		int counter = 0;
	    while (counter < 4) {
	
	    startTurn(counter);
	
	    String[] desiredCard = readConfirmInput().split(" ");
	    
	    inputValidator(desiredCard);
	    
	//    System.out.println(currentPlayer.getCards().get(desiredCard[0]));
	    counter++;
	
	   }
	   setRoundCount();
	   counter = 0;
	
	  }
}

private void startTurn(int counter) {
	int turn = counter;
	Player currentPlayer = players[turn];
	System.out.println("Player " + (counter + 1)+ ": " + currentPlayer.getName() + "    Round #" + (getRoundCount() + 1));
	System.out.println("Press enter to see your cards....");
	readConfirmInput();
	showCards(currentPlayer);
	System.out.println("\nEnter the numbers of each card you want to exchange. Ex: 1 4 6 7 8");
	System.out.println("You can exchange 0, 1, 2, 3, 5, or 8 cards. exchanges > 2 require a facecard in the exchange");
}

private void inputValidator(String[] desiredCard) {

	
	    while (!checkInput(desiredCard) ) {
		     System.out.println("Incorrect input! Press space to pass on discarding");
		     desiredCard = readConfirmInput().split(" ");
	     };
	     
	     System.out.print("Cards chosen: ");
	     
	     for (String item : desiredCard) {
	    	 System.out.print(item + " ");
	     }
	     System.out.print("\n");

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
  System.out.println("Your cards:");
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

// private int getDesiredCard() {
//
//  int desiredIndex = 0;
//
//  while (true) {
//
//   String desiredCard = readConfirmInput().toLowerCase();
//   if (desiredCard.length() > 0) {
//    desiredCard = faceCardConverter(desiredCard);
//
//    if (tryParseInt(desiredCard) && Integer.parseInt(desiredCard) > 0 && Integer.parseInt(desiredCard) < 15) {
//     desiredIndex = Integer.parseInt(desiredCard);
//     break;
//    }
//   }
//  }
//  return desiredIndex;
//
// }
// private String faceCardConverter(String desiredCard) {
//  switch (desiredCard.charAt(0)) {
//   case 'j':
//    desiredCard = "11";
//    break;
//   case 'q':
//    desiredCard = "12";
//    break;
//   case 'k':
//    desiredCard = "13";
//    break;
//   case 'a':
//    desiredCard = "1";
//    break;
//   default:
//    break;
//  }
//  return desiredCard;
// }



}