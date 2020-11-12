package goFish;

public class Card {
	private int value;
	private String suit;
	
	public Card(int value, String suit){
		setValue(value);
		setSuit(suit);	
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}

}
