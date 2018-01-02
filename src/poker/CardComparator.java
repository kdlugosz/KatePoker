package poker;

import java.util.Comparator;

// Sorts cards by descending rank
public class CardComparator implements Comparator<Card>{

	@Override
	public int compare(Card o1, Card o2) {
		if (o1.getRank() > o2.getRank())
			return -1;
		
		else if (o1.getRank() < o2.getRank())
			return 1;
		
		else
			return 0;
	}

}
