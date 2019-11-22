package bestHand;

import java.util.Arrays;

public class Deck {
	private Card[] deck;
	
	public Deck() {
		this.setDeck(createDeck());	
		System.out.println(Arrays.toString(deck));
	}

	public Card[] getDeck() {
		return deck;
	}

	public void setDeck(Card[] deck) {
		this.deck = deck;
	}
	
	private Card[] createDeck() {
		Card[] newDeck = new Card[52];
		
		for(int i = 1, j = 0, k=1; k < 53 ; i++, j++, k++ ) {
			if(j % 4 == 0) {
				j = 0;
			}
			if(i % 14 == 0) {
				i = 1;
			}
			deck[k] = new Card(i, j, k);
			
		}
	
		return newDeck;
		
	}

}
