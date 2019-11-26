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
  setPlayers(new Player[] {
   new Player("Joe", deck.dealHand(deck.getDeck(), 5)), new Player("Dan", deck.dealHand(deck.getDeck(), 5))
  });
  while (deck.getDeck().size() != 0) {
   startTurn(getPlayers(), deck);
  }
  endGame(getPlayers());
 }
 private void endGame(Player[] players) {
  System.out.println("\n\nOut of cards! Game over!");
  System.out.println("Score:");
  System.out.println(players[0].getName() + ": " + players[0].getScore());
  System.out.println(players[1].getName() + ": " + players[1].getScore());
 }

 private void checkForDoubles(Player player) {

  int[] arr = new int[15];

  for (Card card: player.getCards()) {
   arr[card.getValue()]++;
  }

  for (int j = 0; j < arr.length; j++) {

   if (arr[j] == 2) {
    resolveDoubles(player, j);
   }
  }

 }

 private void resolveDoubles(Player player, int value) {
  ArrayList < Card > playerHand = player.getCards();
  playerHand.removeIf(card -> card.getValue() == value);
  player.setCards(playerHand);
  System.out.println("Double found!" + " " + value + "'s");
  addPoints(player);

 }

 private boolean checkIfUserHasCard(int cardValue, Player player) {
  for (Card card: player.getCards()) {
   if (card.getValue() == cardValue) {
    return true;
   }
  }
  return false;
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

  if (currentPlayer.getCards().size() == 0) {

   handEmpty(deck, currentPlayer);
  }

  String name = currentPlayer.getName();
  sayTurn(name, cardsLeft);

  readConfirmInput();
  System.out.println("\n");
  checkForDoubles(currentPlayer);

  gameLogic(deck, currentPlayer, otherPlayer, name);


 }
 private void gameLogic(Deck deck, Player currentPlayer, Player otherPlayer, String name) {
  Card cardMatch = null;
  boolean cardHaveCheck = false;
  int desiredCard = 0;

  while (!cardHaveCheck) {

   showCards(currentPlayer);


   System.out.println(name + ", what card do you hope to find: 2-10 J Q K A");
   desiredCard = getDesiredCard();
   if (checkIfUserHasCard(desiredCard, currentPlayer)) {
    cardHaveCheck = true;
   } else {
    System.out.println("You dont have that card!");
   }
  }


  for (Card card: otherPlayer.getCards()) {
   if (card.getValue() == desiredCard) {
    cardMatch = card;
   }
  }

  if (cardMatch != null) {

   resolveCards(currentPlayer, otherPlayer, cardMatch, deck);
  } else {

   checkForDoubles(currentPlayer);
   goFish(currentPlayer, otherPlayer, deck, desiredCard);
  }
 }
 private void handEmpty(Deck deck, Player currentPlayer) {

  for (int i = 0; i < 3; i++) {
   deck.drawCard(currentPlayer);
   if (i > 1) {
    checkForDoubles(currentPlayer);
   }
  }

 }

 private void goFish(Player currentPlayer, Player otherPlayer, Deck deck, int desiredCard) {
  System.out.println(otherPlayer.getName() + " does not have any " + desiredCard + "'s");
  System.out.print("You go fish!   ");
  deck.drawCard(currentPlayer);
  System.out.println("\n\n");
  checkForDoubles(currentPlayer);
  setTurnCount();
 }
 private void sayTurn(String name, int cardsLeft) {
  System.out.println("\n\n" + name + "'s turn. Press enter to see your cards    CARDS LEFT: " + cardsLeft);

 }
 private void resolveCards(Player currentPlayer, Player otherPlayer, Card cardMatch, Deck deck) {

  System.out.println(otherPlayer.getName() + " has a " + cardMatch.getValue() + " " + cardMatch.getSuit() + " for you!");

  if (checkIfUserHasCard(cardMatch.getValue(), currentPlayer)) {

   discardCard(otherPlayer, cardMatch);
   discardCard(currentPlayer, cardMatch);
   addPoints(currentPlayer);
  } else {
   System.out.println("too bad you don't have that card!");

  }
 }
 private void addPoints(Player currentPlayer) {
  currentPlayer.setScore(1);
  System.out.println("+1 points to " + currentPlayer.getName());
  System.out.println("Current score for " + currentPlayer.getName() + " " + currentPlayer.getScore());
  System.out.println("\n\n");
 }
 private void discardCard(Player player, Card cardMatch) {
  ArrayList < Card > playerHand = player.getCards();
  playerHand.removeIf(card -> card.getValue() == cardMatch.getValue());
  player.setCards(playerHand);
 }

 public int getTurnCount() {
  return turnCount;
 }

 public void setTurnCount() {
  this.turnCount = this.turnCount + 1;
 }

 private String readConfirmInput() {

  String input = "";
  while (input == "") {
   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

   try {

    input = reader.readLine();

    return input;
   } catch (IOException e) {

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

  while (true) {

   String desiredCard = readConfirmInput().toLowerCase();
   if (desiredCard.length() > 0) {
    if (desiredCard.charAt(0) == 'j') {
     desiredCard = "11";
    } else if (desiredCard.charAt(0) == 'q') {
     desiredCard = "12";
    } else if (desiredCard.charAt(0) == 'k') {
     desiredCard = "13";
    } else if (desiredCard.charAt(0) == 'a') {
     desiredCard = "1";
    }
    if (tryParseInt(desiredCard) && Integer.parseInt(desiredCard) > 0 && Integer.parseInt(desiredCard) < 15) {
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