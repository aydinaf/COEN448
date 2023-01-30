import java.util.Scanner;
public class Robot {
    private int[][] floor;
    private int x;
    private int y;
    private boolean penDown;
    private int direction; // 0: North, 1: East, 2: South, 3: West

    public Robot(int n) {
        floor = new int[n][n];
        x = 0;
        y = 0;
        penDown = false;
        direction = 0;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter command: ");
            String line = scanner.nextLine();
            if (line.length() == 0) {
                continue;
            }
            char command = line.charAt(0);
            switch (command) {
                case 'U':
                case 'u':
                    penDown = false;
                    break;
                case 'D':
                case 'd':
                    penDown = true;
                    break;
                case 'R':
                case 'r':
                    direction = (direction + 1) % 4;
                    break;
                case 'L':
                case 'l':
                    direction = (direction + 3) % 4;
                    break;
                case 'M':
                case 'm':
                    int steps = Integer.parseInt(line.substring(2));
                    move(steps);
                    break;
                case 'P':
                case 'p':
                    printFloor();
                    break;
                case 'C':
                case 'c':
                    printPosition();
                    break;
                case 'Q':
                case 'q':
                    return;
                case 'I':
                case 'i':
                    int n = Integer.parseInt(line.substring(2));
                    init(n);
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }

    private void move(int steps) {
        int dx = 0;
        int dy = 0;
        switch (direction) {
            case 0:
                dy = -steps;
                break;
            case 1:
                dx = steps;
                break;
            case 2:
                dy = steps;
                break;
            case 3:
                dx = -steps;
                break;
        }
        if (penDown) {
            int x1 = Math.max(0, x + dx);
            int y1 = Math.max(0, y + dy);
            int x2 = Math.min(floor.length - 1, x + dx);
            int y2 = Math.min(floor.length - 1, y + dy);
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    floor[i][j] = 1;
                }
            }
        }
        x += dx;
        y += dy;
        x = Math.max(0, Math.min(floor.length - 1, x));
        y = Math.max(0, Math.min(floor.length - 1, y));
    }
    private void init(int n) {
        floor = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                floor[i][j] = 0;
            }
        }
        x = n / 2;
        y = n / 2;
        penDown = false;
        direction = 0;
    }

    private void printFloor() {
        for (int i = 0; i < floor.length; i++) {
            for (int j = 0; j < floor[i].length; j++) {
                System.out.print(floor[i][j] == 1 ? '*' : ' ');
            }
            System.out.println();
        }
    }

    private void printPosition() {
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("direction: " + direction);
        System.out.println("penDown: " + penDown);
    }

}
