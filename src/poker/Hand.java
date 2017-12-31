package poker;

import java.util.ArrayList;

public class Hand {
	ArrayList<Integer> handValue = new ArrayList<Integer>();
	ArrayList<Card> cards = new ArrayList<Card>();
	
	public void addCard(Card newCard) {
		this.cards.add(newCard);		
	}

}
