package poker;

import java.util.Scanner;

public class PokerGame {

	public static void main(String[] args) {
		System.out.println("Please input the number of players (Between 0 and 24) on the first line"
				+ "and each player ID and poker hand on the following lines.");
		Scanner input = new Scanner(System.in);
		int numOfPlayers = input.nextInt();
		System.out.println("The winner is player " + numOfPlayers);

	}

}
