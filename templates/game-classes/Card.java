package bestHand;

public class Card {
	private int value;
	private int suit;
	private int numberOfCards;
	
	public Card(int value, int suit, int numberOfCards){
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
	public int getSuit() {
		return suit;
	}
	public void setSuit(int suit) {
		this.suit = suit;
	}
	public int getCardNumber() {
		return numberOfCards;
	}
	public void setCardNumber(int cardNumber) {
		this.numberOfCards = cardNumber;
	}

}
