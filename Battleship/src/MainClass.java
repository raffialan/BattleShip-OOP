/**
 * Name:			Raffi Alan Bezirjian (29538690)
 * COMP249
 * Assignment #:	1
 * Due Date:		September 21, 2018
 */
import data.BattleshipBoard;
import players.Player;
import players.Computer;
import players.User;

import java.util.Scanner;

public class MainClass {
	public static void main(String args[]){
		//makes scanner for human
		Scanner sc = new Scanner(System.in);
		
		//initialize players
		Player human = new User("human", sc);
		Player computer = new Computer("computer");
		
		//initialize board
		BattleshipBoard board = new BattleshipBoard(human, computer);
		
		//ask players to place their pieces
		board.setup();
		
		//main game loop
		while(true){
			
			//human turn
			System.out.println("Your turn: ");
			if(board.playTurn()){
				break;
			}
			
			//display board
			System.out.println(board.toString());
			
			//computer turn
			System.out.println("My turn: ");
			if(board.playTurn()){
				break;
			}
			
			//displays board
			System.out.println(board.toString());
		}
		
		sc.close();
		
		//displays to user end of game
		System.out.println("~ ~ Exit Game ~ ~");
	}
}
