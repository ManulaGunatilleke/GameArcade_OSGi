package com.gamearcade.gamepublisher.minesweeper;

import java.util.Scanner;

public class MinesweeperController {

	Field field;
    int size, nMines;

    public MinesweeperController() {
        initGame();
        gameLoop();
    }

    private void initGame() {
        @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

        System.out.print("Field size > ");
        this.size = sc.nextInt();
        System.out.print("Number of mines > ");
        this.nMines = sc.nextInt();

        this.field = new Field(size, nMines);
    }

    private void gameLoop() {
        while(!field.minesRevealed) {
            field.printField();
            field.makeGuess();
            field.checkMarkedMines();
            
            if(field.allMinesMarked) {
                break;
            }
        }

        if(field.minesRevealed) {
            field.printField();
            System.out.println("You lost!");
        } else {
            field.printField();
            System.out.println("You found all the mines!");
        }
    }
}
