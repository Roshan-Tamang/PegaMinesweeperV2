package com.softwareintitute.rt.minesweeper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        boolean exit = false;


        while (!exit) {

            try {
                int userInput = getUserInput(game.mainMenu());

                switch (userInput) {
                    case 0:
                        playTheGame();
                        break;
                    case 1:
                        changeBoardSize();
                        break;
                    case 2:
                        changeDifficultyLvl();
                        break;
                    case 3:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option! try again!");
                        break;
                }

            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Invalid input! try again");
            }
        }


    }

    private static void playTheGame() {

        Game game = new Game();

        System.out.println(game.start());

        String board;
        String messageForX = "Please enter the x coordinate";
        String messageForY = "Please enter the y coordinate";
        boolean exit = false;

        do{

            try {
                int xCord;
                int yCord;

                int userChoice = getUserInput("Press 1: To reveal a square    Press 2: To flag/unflag a square");

                try {

                    if (userChoice == 1) {

                        xCord = getUserInput(messageForX);
                        yCord = getUserInput(messageForY);

                        board = game.takeTurn("Reveal", xCord, yCord);
                        if(game.checkIfGameIsWon()){
                            exit = true;
                            System.out.println("Congratulations! You have won the game");
                        } else if (game.checkIfGameIsOver()) {
                            exit = true;
                            System.out.println("Game Over!");
                        }

                        System.out.println(board);

                    } else if (userChoice == 2) {

                        xCord = getUserInput(messageForX);
                        yCord = getUserInput(messageForY);

                        board = game.takeTurn("Flag", xCord, yCord);
                        System.out.println(board);

                    } else {
                        System.out.println("Invalid choice! Try again");
                    }

                }catch (InvalidCoordinate invalidCoordinate){
                    System.out.println("Invalid input! try again");
                }

            }catch (InputMismatchException inputMismatchException){
                System.out.println("Invalid input! try again");
            }


        }while (!exit);


    }

    private static void changeDifficultyLvl() {

        int difficultyLvl;

        System.out.println("The current difficulty level is " + Settings.getGameDifficulty().getDifficultyLvlAsString());

        try {
            difficultyLvl = getUserInput("Enter 1: Beginner   Enter 2: Intermediate    Enter 3: Hard");

            try {


                Settings.setGameDifficulty(difficultyLvl);


            } catch (InvalidDifficultyLvl invalidDifficultyLvl) {
                System.out.println("Invalid input! try again");
            }


        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Invalid input! try again");
        }


    }

    private static void changeBoardSize() {

        int length;
        int width;

        System.out.println("The current board size is " + Settings.getBoardLength() + "x" + Settings.getBoardWidth());

        try {
            length = getUserInput("Please enter the new board length(Accepted range: 5-30)");
            width = getUserInput("Please enter the board width(Accepted range: 5-30)");

            try {
                Settings.setBoardLength(length);
                Settings.setBoardWidth(width);
            } catch (InvalidBoardSize invalidBoardSize) {
                System.out.println("Board length and width needs to be between the range of 5-30");
            }

        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Input mismatch! Please try again");
        }


    }

    private static int getUserInput(String message) throws InputMismatchException {

        int userChoice;

        System.out.println(message);

        Scanner scanner = new Scanner(System.in);

        userChoice = scanner.nextInt();

        return userChoice;

    }

}