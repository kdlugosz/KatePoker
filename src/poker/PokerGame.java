package poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PokerGame {
	static Scanner keyboard = new Scanner(System.in);
	static boolean needsInput = true;
	static int HAND_SIZE = 3;

	public static void main(String[] args) {
		ArrayList<Hand> hands = getHands();
		for (Hand hand : hands)
			hand.calculateValue();
		
		ArrayList<Hand> winners = determineWinners(hands);
			
		keyboard.close();
		
		Collections.sort(winners, new HandComparator());
		
		for (Hand winner : winners) {
			System.out.print(winner.getPlayerId() + " ");
		}
		
	}

	private static ArrayList<Hand> determineWinners(ArrayList<Hand> hands) {
		ArrayList<Hand> winners = new ArrayList<Hand>();
		// winner starts as first hand
		winners.add(hands.get(0));
		
		for (int i=1; i<hands.size(); ++i) {
			Hand hand = hands.get(i);
			int isWinner = winners.get(0).compareTo(hand);
			
			switch (isWinner) {
			// not a winner
			case 1:
				break;
				
			// new winner
			case -1:
				winners.clear();
				winners.add(hand);
				break;
				
			// tied with current winner
			case 0:
				winners.add(hand);
				break;
			}
		}
		return winners;
	}

	private static ArrayList<Hand> getHands() {
		ArrayList<Hand> hands = new ArrayList<Hand>();
		int numOfPlayers = 0;
		
		while (needsInput) {
			if (keyboard.hasNextInt())
				numOfPlayers = keyboard.nextInt();
			
			else {
				System.out.println("Invalid number of players. Please try again.\n");
				keyboard.next();
				continue;
			}	
		
			if (numOfPlayers <= 0 || numOfPlayers >= 24) {
				System.out.println("Invalid number of players. Please try again.\n");
				continue;
			}	
			
			keyboard.nextLine();
			ArrayList<Integer> playerIds = new ArrayList<Integer>();
			
			while (hands.size()<numOfPlayers) {
				String input = keyboard.nextLine();
				
				String[] cards = input.split("\\s+");
				Integer playerId = 0;
						
				if (cards.length != (HAND_SIZE + 1)) {
					System.out.println("Invalid number of cards. Please try again.\n");
					playerIds.clear();
					hands.clear();
					continue;
				}
				if (!cards[0].matches("\\d") || playerIds.contains(Integer.parseInt(cards[0])))  {
					System.out.println("Invalid player ID. Please try again.\n");
					playerIds.clear();
					hands.clear();
					continue;
				}
				
				playerId = Integer.parseInt(cards[0]);
				playerIds.add(playerId);
				boolean badCard = false;
				Hand hand = new Hand(playerId, HAND_SIZE);
				
				for (int i=1; i<=HAND_SIZE; ++i) {
					String card = cards[i];
					if (card.length() != 2) {
						badCard = true;
						break;
					}
					
					char[] cardChars = card.toCharArray();
					char rank = cardChars[0];
					char suit = cardChars[1];
					
					if (Card.RANKS.contains(String.valueOf(rank).toUpperCase()) && 
							Card.SUITS.contains(String.valueOf(suit).toLowerCase())) {
						Card newCard = new Card(rank, suit);
						hand.addCard(newCard);
					}
					
					else {
						badCard = true;
						break;
					}
						
				}
				
				if (badCard) {
					System.out.println("Invalid card input. Please enter hands again.\n");
					hands.clear();
					playerIds.clear();
					continue;
				}
					
				hands.add(hand);
			}
			needsInput = false;
		}
		
		return hands;
	}

}
