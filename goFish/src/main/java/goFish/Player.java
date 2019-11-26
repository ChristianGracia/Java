package goFish;

import java.util.ArrayList;

public class Player {
	
	private int score = 0;
	private String name;
	private ArrayList<Card> cards;
	
	public Player(String name, ArrayList<Card> cards)	{
		setName(name);
		setCards(cards);
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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