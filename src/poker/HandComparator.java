package poker;

import java.util.Comparator;

// sorts hands by player ID, ascending
public class HandComparator implements Comparator<Hand>{

	@Override
	public int compare(Hand arg0, Hand arg1) {
		if (arg0.getPlayerId() > arg1.getPlayerId())
			return 1;
		
		else if (arg0.getPlayerId() < arg1.getPlayerId())
			return -1;
		
		else
			return 0;
	}

}
