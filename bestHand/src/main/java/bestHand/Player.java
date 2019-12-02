package bestHand;

import java.util.ArrayList;

public class Player {

	private int doublesScore = 0;
	private int straightScore = 0;
	private int faceCardScore = 0;
	private int sum = 0;
	private int totalScore = 0;
	private String name;
	private ArrayList<Card> cards;

	public Player(String name, ArrayList<Card> cards) {
		setName(name);
		setCards(cards);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	public int getDoublesScore() {
		return doublesScore;
	}

	public void setDoublesScore(int doublesScore) {
		this.doublesScore = doublesScore;
	}

	public int getStraightScore() {
		return straightScore;
	}

	public void setStraightScore(int straightScore) {
		this.straightScore = straightScore;
	}

	public int getFaceCardScore() {
		return faceCardScore;
	}

	public void setFaceCardScore(int faceCardScore) {
		this.faceCardScore = faceCardScore;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
}