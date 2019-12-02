package bestHand;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> deck;
	private String[] suitArray = new String[] {"\u2665", "\u2663", "\u2666", "\u2660"};
	private ArrayList<Card> discard;
	
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
	
	public void discardCard(Card card) {
		
		ArrayList<Card> discardCards = new ArrayList<Card>();
		discardCards = getDeck();
		discardCards.add(card);
		System.out.println(card.getValue() + card.getSuit() + " added to discard deck");
		setDiscard(discardCards);
	

	}
	
	public Card getNewCard() {
		
		ArrayList<Card> discardCards = new ArrayList<Card>();
		discardCards = getDeck();
		Card card = discardCards.get(0);
		discardCards.remove(card);
		System.out.println(card.getValue() + card.getSuit() + " added to deck");
		setDiscard(discardCards);
	
		return card;

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
//	 public void drawCard(Player player) {
//		 
//		 ArrayList<Card> deck = getDeck();
//		 Card newCard = deck.remove(0);
//		 setDeck(deck);
//		 
//		 ArrayList<Card> currentCards = player.getCards();
//		 currentCards.add(newCard);
//		 player.setCards(currentCards);
//		 System.out.println("You drew a " + newCard.getValue() + " " + newCard.getSuit());
//	 }

	public ArrayList<Card> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<Card> deck) {
		this.deck = deck;
	}

	public String[] getSuitArray() {
		return suitArray;
	}

	public ArrayList<Card> getDiscard() {
		return discard;
	}

	public void setDiscard(ArrayList<Card> discard) {
		this.discard = discard;
	}


}
