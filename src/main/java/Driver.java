import java.util.*;
import java.util.Scanner;


public class Driver {

    public static boolean isEnded = false;
    static Scanner userInput = null;

    static Player p1 =  new Player(0, 0, "", "", new int[0][0], 0, false);

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
            if(!p1.isPlayerCreated)
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
                 else if (userString.equals("C") || userString.equals("c")) {
                    printBoard(p1);
                }
                 else if (userString.equals("U") || userString.equals("u")) {
                     p1.setPen("Up");
                     System.out.println("The pen is set " + p1.pen);
                 }
                 else if (userString.equals("D") || userString.equals("d")) {
                     p1.setPen("Down");
                     System.out.println("The pen is set " + p1.pen);
                 }
                 else if (userString.equals("R") || userString.equals("r")) { //need to fix this to take into account the players current orientation
                     p1.setOrientation("East");
                     System.out.println("The player is facing " + p1.orientation);
                 }
                 else if (userString.equals("L") || userString.equals("l")) {  //need to fix this to take into account the players current orientation
                     p1.setOrientation("West");
                     System.out.println("The player is facing " + p1.orientation);
                 }
            }
        }
    }


    static Player initializeArray(String userString) {
        int arraySize;
        try {
            arraySize = Integer.parseInt(userString.substring(2));
            int[][] newBoard = new int[arraySize][arraySize];
            for (int i = 0; i < arraySize; i++) {
                for (int j = 0; j < arraySize; j++) {
                    newBoard[i][j] = 0;
                }
            }
            p1 = new Player(0, 0, "Up", "North", newBoard, arraySize, true);
//            printBoard(p1);
            } catch (Exception e) {
            System.out.println("Invalid initialization input");
        }
        return p1;
    }

    static void printBoard(Player p1) {

        String[][] printedBoard = new String[p1.arraySize][p1.arraySize];
        for (int i = 0; i < p1.arraySize; i++) {
            for (int j = 0; j < p1.arraySize; j++) {
                if (p1.board[i][j] == 0) {
                    printedBoard[i][j] = " ";
                } else {
                    printedBoard[i][j] = "*";
                }
            }
        }
        printedBoard[(p1.arraySize - 1) - p1.horzPos][p1.vertPos] = "P";
        for (String[] row : printedBoard) {
            System.out.println(Arrays.toString(row));
        }
    }
}
