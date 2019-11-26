package goFish;

public class Card {
	private int value;
	private String suit;
	private int numberOfCards;
	
	public Card(int value, String suit, int numberOfCards){
		setValue(value);
		setSuit(suit);
		setCardNumber(numberOfCards);
		
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
	public int getCardNumber() {
		return numberOfCards;
	}
	public void setCardNumber(int cardNumber) {
		this.numberOfCards = cardNumber;
	}

}
