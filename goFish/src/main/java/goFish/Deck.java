package goFish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Deck {
	private ArrayList<Card> deck;
	
	public Deck() {
		setDeck(createDeck());
		


		
		for(Card item : getDeck()) {
			System.out.print(item.getCardNumber());
			System.out.print(" ");
			System.out.print(item.getValue());
			System.out.print(" ");
			System.out.print(item.getSuit());
			System.out.println(" ");

		}
	
	}

	private ArrayList<Card> createDeck() {
		
	   Card[] temp = new Card[52];
		
		for(int i = 1, j = 0, k=0; k < 52 ; i++, j++, k++ ) {
			if(j % 4 == 0) {
				j = 0;
			}
			if(i % 14 == 0) {
				i = 1;
			}
			temp[k] = new Card(i, j, k);
		}
		ArrayList<Card> cards = new ArrayList<Card>();
		
		for(Card card : temp) {
			cards.add(card);
		}
		Collections.shuffle(cards);

		return cards;
	}

	private ArrayList<Card> dealHand(ArrayList<Card> cards, int count) {
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

}
