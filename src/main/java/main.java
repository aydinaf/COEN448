import java.util.*;
import java.io.*;
import java.util.Scanner;


public class main {

    public static boolean isEnded = false;
    static Scanner userInput = null;
    public static void main(String[] args) {

        while (!isEnded) {
            System.out.println("Enter command:");
            userInput = new Scanner(System.in);
            String userString = userInput.nextLine();
            System.out.println("You entered command: " + userString);
            if (userString.contains("Q") || userString.contains("q"))
            {
                isEnded = true;
            } else if (userString.contains("I") || userString.contains("i")) {
                initializeArray(userString);
            }
        }
    }


    static void initializeArray(String userString) {
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
            System.out.println("Invalid input");
        }
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
