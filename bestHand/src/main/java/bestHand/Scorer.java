package bestHand;

import java.util.ArrayList;

public class Scorer {

 private Player[] players;

 public Scorer(Player[] players) {
  setPlayers(players);

  for (Player player: players) {

   player.setScore(calculateSum(player));
   for (Card card: player.getCards()) {

    System.out.print("[" + card.getValue() + "" + card.getSuit() + "]");

   }
   System.out.println("\n");
  }
  removeFaceCards(getPlayers());

  for (Player player: players) {


   for (Card card: player.getCards()) {

    System.out.print("[" + card.getValue() + "" + card.getSuit() + "]");


   }
   System.out.println("\n");
  }

 }

 public Player[] getPlayers() {
  return players;
 }

 public void setPlayers(Player[] players) {
  this.players = players;
 }

 private int calculateSum(Player player) {
  int sum = 0;
  for (Card card: player.getCards()) {
   sum += card.getValue();
   if (card.getValue() == 1) {
    sum += 10;
   }
  }
  System.out.println(player.getName() + ":  Sum of cards: " + sum);
  return sum;
 }
 private void removeFaceCards(Player[] players) {

  int[] arr = new int[3];

  for (Player player: players) {
   for (Card card: player.getCards()) {
    switch (card.getValue()) {
     case 11:
      arr[0]++;
      break;
     case 12:
      arr[1]++;
      break;
     case 13:
      arr[2]++;
      break;
     default:
      break;
    }
   }
  }

  for (int i = 0; i < 3; i++) {
   if (arr[i] > 1) {

    for (Player player: players) {

     ArrayList < Card > cards = player.getCards();
     int counter = 0;
     for (int j = 0; j < cards.size(); j++) {

      if (cards.get(j).getValue() == i + 11 && counter == 0) {
       cards.remove(j);
       counter++;
      }
     }
     player.setCards(cards);

    }
   }

  }

  System.out.println("Cards remaining after red wedding: ");
  for (Player player: players) {
   System.out.println(player.getName() + ":  " + player.getCards().size());
  }


 }
}