import java.util.*;
import java.io.*;
public class main {

    public static void main(String[] args) {
        Player bot = new Player(0, 0, "Up", "North");
        int arraySize = 10; //will need to get from input command
        int[][] starterArray = initializeArray(arraySize, bot);
        printBoard(starterArray,arraySize, bot);
    }
    static int[][]  initializeArray(int arraySize, Player p1)
    {
        int[][] newBoard = new int[arraySize][arraySize];
        for (int i = 0; i < arraySize; i++)
        {
            for (int j = 0; j < arraySize; j++)
            {
                newBoard[i][j] = 0;
            }
        }
        return newBoard;
    }

    static void printBoard(int[][] board, int arraySize, Player p1)
    {
        String[][] printedBoard = new String[arraySize][arraySize];
        for (int i = 0; i < arraySize; i++)
        {
            for (int j = 0; j < arraySize; j++)
            {
                if (board[i][j] == 0)
                {
                    printedBoard[i][j] = " ";
                }
                else
                {
                    printedBoard[i][j] = "*";
                }
            }
        }

        printedBoard[p1.horzPos][p1.vertPos] = "P";
        for(String[] row : printedBoard)
        {
            System.out.println(Arrays.toString(row));
        }
    }
}
