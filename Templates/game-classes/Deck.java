package bestHand;

import java.util.Arrays;

public class Deck {
	private Card[] deck;
	
	public Deck() {
		this.setDeck(createDeck());	
		Card[] temp = getDeck();
		
		for(Card item : temp) {
			System.out.println(item.getCardNumber());
			
		}
	
	}

	public Card[] getDeck() {
		return deck;
	}

	public void setDeck(Card[] deck) {
		this.deck = deck;
	}
	
	private Card[] createDeck() {
		Card[] newDeck = new Card[52];
		
		for(int i = 1, j = 0, k=0; k < 52 ; i++, j++, k++ ) {
			if(j % 4 == 0) {
				j = 0;
			}
			if(i % 14 == 0) {
				i = 1;
			}
			newDeck[k] = new Card(i, j, k);
			
		}
	
		return newDeck;
		
	}

}
