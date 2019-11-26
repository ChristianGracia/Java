package goFish;

import java.util.ArrayList;

public class Player {
	
	private int score = 0;
	private int id;
	private ArrayList<Card> cards;
	
	public Player(int id, ArrayList<Card> cards)	{
		setId(id);
		setCards(cards);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
}