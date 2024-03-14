package com.gamearcade.gamepublisher;

import java.util.Scanner;

import com.gamearcade.gamepublisher.minesweeper.MinesweeperController;
import com.gamearcade.gamepublisher.tictactoe.Tictactoe;

public class GamePublisherImpl implements IGamePublisher{
	
	Scanner input = new Scanner(System.in);

	@Override
	public void selectPlayerType() {
	    boolean validInput = false;
	    
	    while (!validInput) {
	        System.out.println("==============================");
	        System.out.println("Please Select Player Type(1, 2)");
	        System.out.println("==============================\n");
	        
	        System.out.println("1. Single Player");
	        System.out.println("2. Multiplayer");
	        System.out.println("Enter -1 to exit\n");
	        
	        System.out.println("Enter a number : ");
	        String selection = input.next();
	        
	        if (selection.equals("1")) {
	            singlePlayerGames();
	            validInput = true;
	        } else if (selection.equals("2")) {
	            multiplayerGames();
	            validInput = true;
	        } else if (selection.equals("-1")) {
	            System.out.println("Write the code to exit the program");
	            validInput = true;
	        } else {
	            System.out.println("Please enter a valid number!");
	        }
	    }
	}

	@Override
	public void singlePlayerGames() {
		
        boolean validInput = false;
	    
	    while (!validInput) {
	        System.out.println("======================");
	        System.out.println("Please Select the Game");
	        System.out.println("======================\n");
	        
	        System.out.println("1. Minesweeper");
	        System.out.println("Enter -1 to exit\n");
	        
	        System.out.println("Enter a number : ");
	        String selection = input.next();
	        
	        if (selection.equals("1")) {
	        	startMinesweeper();
	            validInput = true;
	        } else if (selection.equals("2")) {
	            multiplayerGames();
	            validInput = true;
	        } else if (selection.equals("-1")) {
	            System.out.println("Write the code to exit the program");
	            validInput = true;
	        } else {
	            System.out.println("Please enter a valid number!");
	        }
	    }
		
	}

	@Override
	public void multiplayerGames() {
        boolean validInput = false;
	    
	    while (!validInput) {
	        System.out.println("======================");
	        System.out.println("Please Select the Game");
	        System.out.println("======================\n");
	        
	        System.out.println("1. TicTacToe");
	        System.out.println("Enter -1 to exit\n");
	        
	        System.out.println("Enter a number : ");
	        String selection = input.next();
	        
	        if (selection.equals("1")) {
	        	startTicTacToe();
	            validInput = true;
	        } else if (selection.equals("2")) {
	            multiplayerGames();
	            validInput = true;
	        } else if (selection.equals("-1")) {
	            System.out.println("Write the code to exit the program");
	            validInput = true;
	        } else {
	            System.out.println("Please enter a valid number!");
	        }
	    }
		
	}
	
	@Override
	public void startTicTacToe() {
		
		System.out.println("==============================");
        System.out.println("TicTacToe started, Good Luck!!!");
        System.out.println("==============================\n");
		
		Tictactoe game = new Tictactoe();
		String player = "X";
		
		do {
			System.out.println(game.printBoard());
			System.out.println("enter row for " + player + " or -1 to exit: ");
			int row = input.nextInt();
			if(row == -1) 
				break;
			System.out.println("enter column for " + player + ": ");
			int column = input.nextInt();
			game.setPlay(row,  column, player);
			if(game.isGameOver()) {
				System.out.println(game.printBoard() + "\n" + player +" wins!");
				break;
			}
			if(player == "X") {
				player = "O";				
			}
			else {
				player = "X";
			}
		}while(true);
		
		System.out.println("Goodbye!..");
		
		
	}

	@Override
	public void startMinesweeper() {
		
		System.out.println("=================================");
        System.out.println("Minesweeper started, Good Luck!!!");
        System.out.println("=================================\n");
		
		MinesweeperController minessweeper = new MinesweeperController();
		selectPlayerType();
		
	}

}

