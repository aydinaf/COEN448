import java.util.*;
import java.io.*;
import java.util.Scanner;


public class main {

    public static boolean isEnded = false;
    static Scanner userInput = null;
    static Player p1 = null;
    public static void main(String[] args) {

        while (!isEnded) {
            System.out.println("Enter command:");
            userInput = new Scanner(System.in);
            String userString = userInput.nextLine();
            if (userString.equals("Q") || userString.equals("q"))
            {
                isEnded = true;
                System.out.println("Ending Program");
                break;
            }
            System.out.println("You entered command: " + userString);
            if(p1 == null)
            {
                if (userString.contains("I") || userString.contains("i")) {
                    p1 = initializeArray(userString);
                }
                else
                {
                    System.out.println("Invalid command. The game needs to be initialized first");
                }
            }
            else
            {
                 if (userString.contains("I") || userString.contains("i")) {
                    initializeArray(userString);
                }
            }
        }
    }


    static Player initializeArray(String userString) {
        int arraySize;
        try {
            arraySize = Integer.parseInt(userString.substring(2, userString.length()));
            System.out.println("Array size entered is: " + arraySize);
            Player p1 = new Player(0, 0, "Up", "North");
            int[][] newBoard = new int[arraySize][arraySize];
            for (int i = 0; i < arraySize; i++) {
                for (int j = 0; j < arraySize; j++) {
                    newBoard[i][j] = 0;
                }
            }
            printBoard(newBoard, arraySize, p1);
        } catch (Exception e) {
            System.out.println("Invalid initialization input");
        }
        return p1;
    }

    static void printBoard(int[][] board, int arraySize, Player p1) {
        String[][] printedBoard = new String[arraySize][arraySize];
        for (int i = 0; i < arraySize; i++) {
            for (int j = 0; j < arraySize; j++) {
                if (board[i][j] == 0) {
                    printedBoard[i][j] = " ";
                } else {
                    printedBoard[i][j] = "*";
                }
            }
        }
        printedBoard[(arraySize - 1) - p1.horzPos][p1.vertPos] = "P";
        for (String[] row : printedBoard) {
            System.out.println(Arrays.toString(row));
        }
    }
}
