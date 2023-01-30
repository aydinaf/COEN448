import java.util.*;
import java.io.*;
public class main {

    public static void main(String[] args) {
        int arraySize = 10;
        int[][] starterArray = initializeArray(10);
        printBoard(starterArray,arraySize);
    }
    static int[][]  initializeArray(int arraySize)
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

    static void printBoard(int[][] board, int arraySize)
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
        for(String[] row : printedBoard)
        {
            System.out.println(Arrays.toString(row));
        }
    }
}
