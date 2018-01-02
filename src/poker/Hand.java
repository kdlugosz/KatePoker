package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
	private int[] handValue;
	private List<Card> cards = new ArrayList<Card>();
	private int playerId;
	
	public Hand(Integer playerId, int size) {
		this.playerId = playerId;
		handValue = new int[size + 1];
	}
	
	public int getPlayerId() {
		return this.playerId;
	}

	public void addCard(Card newCard) {
		this.cards.add(newCard);		
	}
	
	public void calculateValue() {
		Collections.sort(cards, new CardComparator());
		boolean straight = isStraight();
		boolean flush = isFlush();
		int sameCards = getNumberOfSameCards();
		
		// straight flush
		if (straight && flush) {
			handValue[0] = 6;
			
			// special case, A-2-3 
			if (cards.get(2).getRank() == 2)
				handValue[1] = 3;
			
			else
				handValue[1] = cards.get(0).getRank();
		}
		
		// three of a kind
		else if (sameCards == 3) {
			handValue[0] = 5;
			handValue[1] = cards.get(0).getRank();
		}

		// straight only
		else if (straight) {
			handValue[0] = 4;
			
			// special case, A-2-3 
			if (cards.get(2).getRank() == 2) 
				handValue[1] = 3;
			
			else
				handValue[1] = cards.get(0).getRank();
		}
		
		// flush only
		else if (flush) {
			handValue[0] = 3;
			for (int i=1; i < handValue.length; ++i) {
				handValue[i] = cards.get(i-1).getRank();
			}	
		}
		
		// one pair
		else if (sameCards  == 2) {
			handValue[0] = 2;
			if  (cards.get(0).getRank() == cards.get(1).getRank()) {
				handValue[1] = cards.get(0).getRank();
				handValue[2] = cards.get(2).getRank();
			}
			
			else if (cards.get(1).getRank() == cards.get(2).getRank()) {
				handValue[1] = cards.get(1).getRank();
				handValue[2] = cards.get(0).getRank();
			}
		}
		
		// high card
		else {
			handValue[0] = 1;
			for (int i=1; i < handValue.length; ++i) {
				handValue[i] = cards.get(i-1).getRank();
			}	
		}
		
	}
	
	private int getNumberOfSameCards() {
		if (cards.get(0).getRank() == cards.get(1).getRank() && 
				cards.get(0).getRank() == cards.get(2).getRank()) 
			return 3;
		
		else if (cards.get(0).getRank() == cards.get(1).getRank() ||
				cards.get(1).getRank() == cards.get(2).getRank()) 
			return 2;
		
		else 
			return 1;
	}

	private boolean isFlush() {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isStraight() {
		// TODO Auto-generated method stub
		return false;
	}

	public int compareTo(Hand otherHand) {
		for (int i=0; i < handValue.length; i++)
		{
			if (this.handValue[i] > otherHand.handValue[i])
				return 1;
			
			else if (this.handValue[i] < otherHand.handValue[i])
				return -1;
		}
		
		return 0; 		
	}

	public int[] getValues() {
		return handValue;
	}

}
