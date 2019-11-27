import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Game {

 private int turnCount = 0;
 private Player[] players = new Player[2];

 public Game() {
  Deck deck = new Deck();
  setPlayers(new Player[] {
   new Player("Joe", deck.dealHand(deck.getDeck(), 5)), new Player("Dan", deck.dealHand(deck.getDeck(), 5))
  });
  while (deck.getDeck().size() != 0) {
   startTurn(getPlayers(), deck);
  }
  endGame(getPlayers());
 }
 private void endGame(Player[] players) {
  System.out.println("\n Game over!");
  System.out.println("Score:");
  System.out.println(players[0].getName() + ": " + players[0].getScore());
  System.out.println(players[1].getName() + ": " + players[1].getScore());
 }


 private void showCards(Player player) {
  System.out.println("Your cards:");
  for (Card card: player.getCards()) {
   System.out.print(card.getValue() + " " + card.getSuit() + "     ");
  }

 }

 private void startTurn(Player[] players, Deck deck) {
  int cardsLeft = deck.getDeck().size();
  int turn = getTurnCount() % 2;
  Player currentPlayer = players[turn];
  Player otherPlayer = turn == 0 ? players[1] : players[0];
 }
 public Player[] getPlayers() {
  return players;
 }

 public void setPlayers(Player[] players) {
  this.players = players;
 }

}