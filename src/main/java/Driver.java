import java.util.*;
import java.util.Scanner;


public class Driver {

    public static boolean isEnded = false;
    static Scanner userInput = null;

    static List<String> inputHistory = new ArrayList<String>();

    static Player p1 = new Player(0, 0, "", "", new int[0][0], 0, false);

    public static void main(String[] args) {
        System.out.println("List of available commands: I (#), M (#), Q, C, R, L, P, U, D, H");
        userInput = new Scanner(System.in);
        while (!isEnded) {
            System.out.println("Enter command:");
            String userString = userInput.nextLine();
            if (userString.length() == 0) {
                continue;
            }
            if (userString.equals("Q") || userString.equals("q")) {
                isEnded = true;
                System.out.println("Ending Program");
                break;
            }

            System.out.println("You entered command: " + userString);
            if (!p1.isPlayerCreated) {
                if ((userString.charAt(0) == 'I' || userString.charAt(0) == 'i') && userString.length() > 1 && userString.charAt(1) == ' ') {
                    p1 = initializeArray(userString);
                } else {
                    System.out.println("Invalid command. The game needs to be initialized first");
                }
            } else {
                execute(userString);
            }
            inputHistory.add(userString);
        }
    }

    static int execute(String userString) {

        if ((userString.charAt(0) == 'I' || userString.charAt(0) == 'i') && userString.length() > 1 && userString.charAt(1) == ' ') {
            initializeArray(userString);
            return 3;
        } else if (userString.equals("P") || userString.equals("p")) {
            System.out.println(printBoard(p1));
            return 4;
        } else if (userString.equals("C") || userString.equals("c")) {
            System.out.println(printDetails(p1));
            return 5;
        } else if (userString.equals("H") || userString.equals("h")) {
            System.out.println(printHistory());
            return 6;
        } else if (userString.equals("U") || userString.equals("u")) {
            p1.setPen("Up");
            System.out.println("The pen is set " + p1.pen);
            return 7;
        } else if (userString.equals("D") || userString.equals("d")) {
            p1.setPen("Down");
            System.out.println("The pen is set " + p1.pen);
            return 8;
        } else if (userString.equals("R") || userString.equals("r")) {
            if (Objects.equals(p1.getOrientation(), "North")) p1.setOrientation("East");
            else if (Objects.equals(p1.getOrientation(), "East")) p1.setOrientation("South");
            else if (Objects.equals(p1.getOrientation(), "South")) p1.setOrientation("West");
            else if (Objects.equals(p1.getOrientation(), "West")) p1.setOrientation("North");

            System.out.println("The player is facing " + p1.orientation);
            return 9;
        } else if (userString.equals("L") || userString.equals("l")) {
            if (Objects.equals(p1.getOrientation(), "North")) p1.setOrientation("West");
            else if (Objects.equals(p1.getOrientation(), "East")) p1.setOrientation("North");
            else if (Objects.equals(p1.getOrientation(), "South")) p1.setOrientation("East");
            else if (Objects.equals(p1.getOrientation(), "West")) p1.setOrientation("South");
            System.out.println("The player is facing " + p1.orientation);
            return 10;
        } else if ((userString.charAt(0) == 'M' || userString.charAt(0) == 'm') && userString.length() > 1 && userString.charAt(1) == ' ') {
            try {
                int steps = Integer.parseInt(userString.substring(2));
                move(steps, p1);
                return 11;
            } catch (Exception e) {
                System.out.println("Incorrect command format");
                return 12;
            }
        } else System.out.println("Wrong command.");
        return 0;
    }

    static void move(int steps, Player p1) {
        writeToBoard(p1);
        if (steps >= 0) {
            if (Objects.equals(p1.getOrientation(), "North")) {
                if (((p1.horzPos) + steps) > p1.arraySize - 1) {
                    System.out.println("Moved too much");
                } else {
                    for (; steps > 0; steps--) {
                        p1.horzPos++;
                        writeToBoard(p1);
                    }
                }
            } else if (Objects.equals(p1.getOrientation(), "South")) {
                if (((p1.horzPos) - steps) < 0) {
                    System.out.println("Moved too much");
                } else {
                    for (; steps > 0; steps--) {
                        p1.horzPos--;
                        writeToBoard(p1);
                    }
                }
            } else if (Objects.equals(p1.getOrientation(), "East")) {
                if (((p1.vertPos) + steps) > p1.arraySize - 1) {
                    System.out.println("Moved too much");
                } else {
                    for (; steps > 0; steps--) {
                        p1.vertPos++;
                        writeToBoard(p1);
                    }
                }
            } else if (Objects.equals(p1.getOrientation(), "West")) {
                if (((p1.vertPos) - steps) < 0) {
                    System.out.println("Moved too much");
                } else {
                    for (; steps > 0; steps--) {
                        p1.vertPos--;
                        writeToBoard(p1);
                    }
                }
            }
        } else System.out.println("Please enter a positive integer.");
    }


    static Player initializeArray(String userString) {
        int arraySize;
        try {
            arraySize = Integer.parseInt(userString.substring(2));
            if (arraySize > 0 && arraySize < 1000) {
                int[][] newBoard = new int[arraySize][arraySize];
                for (int i = 0; i < arraySize; i++) {
                    for (int j = 0; j < arraySize; j++) {
                        newBoard[i][j] = 0;
                    }
                }
                p1 = new Player(0, 0, "Up", "North", newBoard, arraySize, true);
            } else System.out.println("Size of field must be greater than 0 and smaller than 1000.");
        } catch (Exception e) {
            System.out.println("Invalid initialization input");
        }
        return p1;
    }

    static String printDetails(Player p1) {
        String output = "";
        output = ("Position: " + p1.vertPos + " , " + p1.horzPos + " - Pen: " + p1.pen + " - Facing: " + p1.orientation);
        return output;
    }

    static void writeToBoard(Player p1) {
        if (Objects.equals(p1.pen, "Down")) {
            p1.board[p1.arraySize - 1 - p1.horzPos][p1.vertPos] = 1;
        }
    }

    static String printHistory() {
        String output = "\nYour input history is:\n";
        for (String history : inputHistory) {
            output += (history + "\n");
        }
        return output;
    }

    static String printBoard(Player p1) {

        String boardOutput = "";
        String playerDirection = " ";

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
        switch (p1.orientation) {
            case "North":
                playerDirection = "^";
                break;
            case "South":
                playerDirection = "v";
                break;
            case "East":
                playerDirection = ">";
                break;
            case "West":
                playerDirection = "<";
                break;
        }
        printedBoard[(p1.arraySize - 1) - p1.horzPos][p1.vertPos] = playerDirection;
        for (String[] row : printedBoard) {
            boardOutput = boardOutput + (Arrays.toString(row)) + "\n";
        }
        return boardOutput;
    }
}
