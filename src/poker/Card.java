package poker;

import java.util.Arrays;
import java.util.List;

public class Card {
	
	private char rank;
	private char suit;
	
	static List<String> RANKS = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A");
	static List<String> SUITS = Arrays.asList("h", "d", "s", "c");
	
	public Card(char rank, char suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
}
