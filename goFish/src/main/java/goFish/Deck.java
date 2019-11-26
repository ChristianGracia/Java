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
		
		for(int i = 1, j = 0, k=0; k < 52 ; i++, j++, k++ ) {
			if(j % 4 == 0) {
				j = 0;
			}
			if(i % 14 == 0) {
				i = 1;
			}
			temp[k] = new Card(i, suitArr[j], k);
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
