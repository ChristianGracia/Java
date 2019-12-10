package goFish;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> deck;
	private String[] suitArray = new String[] {"\u2665", "\u2663", "\u2666", "\u2660"};
	
	public Deck() {
		setDeck(createDeck());
	}

	private ArrayList<Card> createDeck() {
		
	   Card[] temp = new Card[52];
	   String[] suitArr =  getSuitArray();
		
		for(int value = 1, suit = 0, numberOfCards=0; numberOfCards < 52 ; value++, suit++, numberOfCards++ ) {
			if(suit % 4 == 0) {
				suit = 0;
			}
			if(value % 14 == 0) {
				value = 1;
			}
			temp[numberOfCards] = new Card(value, suitArr[suit]);
		}
		ArrayList<Card> cards = new ArrayList<Card>();
		
		for(Card card : temp) {
			cards.add(card);
		}
		Collections.shuffle(cards);

		return cards;
	}

	 public ArrayList<Card> dealHand(ArrayList<Card> cards, int count) {
		ArrayList<Card> handList = new ArrayList<Card>();
		
		for(int i = 0; i < count; i++) {
			ArrayList<Card> deck = getDeck();
			Card card = deck.get(0);
			handList.add(card);
			deck.remove(0);
		}

		return handList;
		
	}
	 public void drawCard(Player player) {
		 
		 ArrayList<Card> deck = getDeck();
		 Card newCard = deck.remove(0);
		 setDeck(deck);
		 
		 ArrayList<Card> currentCards = player.getCards();
		 currentCards.add(newCard);
		 player.setCards(currentCards);
		 System.out.println("You drew a " + newCard.getValue() + " " + newCard.getSuit());
	 }

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}

	public String[] getSuitArray() {
		return suitArray;
	}


}
