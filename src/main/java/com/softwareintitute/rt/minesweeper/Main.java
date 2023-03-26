package com.softwareintitute.rt.minesweeper;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

/*
        Game game = new Game();

        game.run();
*/


        MinesweeperGrid myGrid = new MinesweeperGrid(5,5,3);
        Scanner scanner = new Scanner(System.in);


        int xCord;
        int yCord;

        int x =0;

        while(x<5) {
            System.out.println(myGrid);
            System.out.println("Please enter X coordinate");
            xCord = scanner.nextInt();
            System.out.println("Please enter Y coordinate");
            yCord = scanner.nextInt();
            System.out.println(myGrid.revealSquare(xCord, yCord));
            x++;
        }

    }
}
