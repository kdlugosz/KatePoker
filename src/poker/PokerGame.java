package poker;

import java.util.ArrayList;
import java.util.Scanner;

public class PokerGame {
	static Scanner keyboard = new Scanner(System.in);
	static boolean needsInput = true;
	static int HAND_SIZE = 3;

	public static void main(String[] args) {
		System.out.println("Please input the number of players (between 0 and 24) on the first line"
				+ " and each player ID and poker hand on the following lines.\n");

		ArrayList<Hand> hands = getHands();
		int winner = determineWinner();
			
		keyboard.close();
		System.out.println("The winner is player " + winner);
		
	}

	private static int determineWinner() {
		return 0;
	}

	private static ArrayList<Hand> getHands() {
		ArrayList<Hand> hands = new ArrayList<Hand>();
		int numOfPlayers = 0;
		
		while (needsInput) {
			if (keyboard.hasNextInt())
				numOfPlayers = keyboard.nextInt();
			
			else {
				System.out.println("Invalid number of players. Please try again\n");
				keyboard.next();
				continue;
			}	
		
			if (numOfPlayers <= 0 || numOfPlayers >= 24) {
				System.out.println("Invalid number of players. Please try again\\n");
				continue;
			}	
		
			if (keyboard.hasNextLine()) {
				String input = keyboard.nextLine();
				
				
				String[] cards = input.split("\\s+");
				Integer playerId = 0;
				
				if (cards.length != (HAND_SIZE + 1)) {
					System.out.println("Invalid number of hands. Please try again\n");
					continue;
				}
				if (!cards[0].matches("\\d"))  {
					System.out.println("Invalid player ID. Please try again\n");
					continue;
				}
				
				playerId = Integer.parseInt(cards[0]);
				Hand hand = new Hand();
				for (int i=0; i<=HAND_SIZE; ++i) {
					System.out.println(cards[i] + "blah");
				}
			}
			needsInput = false;
		}
		
		return hands;
	}

}
