import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DriverTest {
    @Test
    public void DriverMainTest() {
        // For testing System.out.println() statements
        String testInput = "I 9\np\nq\n";

        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Driver.main(new String[]{});
        System.out.println(out.toString());
    }

    @Test
    public void Driver2ndTest() {
        int[][] newBoard = new int[9][9];
        Player testBot = new Player(0, 0, "Up", "North", newBoard, 9, true);
        String testOutput = Driver.printBoard(testBot);
        assertEquals("[ ,  ,  ,  ,  ,  ,  ,  ,  ]\n[ ,  ,  ,  ,  ,  ,  ,  ,  ]\n[ ,  ,  ,  ,  ,  ,  ,  ,  ]\n[ ,  ,  ,  ,  ,  ,  ,  ,  ]\n[ ,  ,  ,  ,  ,  ,  ,  ,  ]\n[ ,  ,  ,  ,  ,  ,  ,  ,  ]\n[ ,  ,  ,  ,  ,  ,  ,  ,  ]\n[ ,  ,  ,  ,  ,  ,  ,  ,  ]\n[^,  ,  ,  ,  ,  ,  ,  ,  ]\n", testOutput);
    }

    @Test
    public void penDownPrintDetailsTest() {
        int[][] newBoard = new int[9][9];
        Player testBot = new Player(0, 0, "Down", "North", newBoard, 9, true);
        String testOutput = Driver.printDetails(testBot);
        assertEquals("Position: 0 , 0 - Pen: Down - Facing: North", testOutput);
    }

    @Test
    public void penUpPrintDetailsTest() {
        int[][] newBoard = new int[9][9];
        Player testBot = new Player(0, 0, "Down", "North", newBoard, 9, true);
        String testOutput = Driver.printDetails(testBot);
        assertEquals("Position: 0 , 0 - Pen: Down - Facing: North", testOutput);
    }

    @Test
    public void penSouthPrintDetailsTest() {
        int[][] newBoard = new int[9][9];
        Player testBot = new Player(0, 0, "Up", "South", newBoard, 9, true);
        String testOutput = Driver.printDetails(testBot);
        assertEquals("Position: 0 , 0 - Pen: Up - Facing: South", testOutput);
    }

    @Test
    public void penEastPrintDetailsTest() {
        int[][] newBoard = new int[9][9];
        Player testBot = new Player(0, 0, "Up", "East", newBoard, 9, true);
        String testOutput = Driver.printDetails(testBot);
        assertEquals("Position: 0 , 0 - Pen: Up - Facing: East", testOutput);
    }

    @Test
    public void penWestPrintDetailsTest() {
        int[][] newBoard = new int[9][9];
        Player testBot = new Player(0, 0, "Up", "West", newBoard, 9, true);
        String testOutput = Driver.printDetails(testBot);
        assertEquals("Position: 0 , 0 - Pen: Up - Facing: West", testOutput);
    }

    /////////////////////
    private final ByteArrayOutputStream outstream = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errstream = new ByteArrayOutputStream();
    private final PrintStream out = System.out;
    private final PrintStream err = System.err;

    @Before

    public void setUp() {

        System.setOut(new PrintStream(outstream));

        System.setErr(new PrintStream(errstream));
    }

    @After
    public void tearDown() {

        System.setOut(out);

        System.setErr(err);

    }

    @Test
    public void Move2NpenUpTest() {
        int[][] newBoard = new int[5][5];
        Player testBot = new Player(0, 0, "Up", "North", newBoard, 5, true);
        Driver.move(2, testBot);
        String expected = "[ ,  ,  ,  ,  ]\n[ ,  ,  ,  ,  ]\n[^,  ,  ,  ,  ]\n[ ,  ,  ,  ,  ]\n[ ,  ,  ,  ,  ]\n";
        assertEquals(expected, Driver.printBoard(testBot));
    }

    @Test
    public void Move2EpenDownTest() {
        int[][] newBoard = new int[5][5];
        Player testBot = new Player(0, 0, "Down", "East", newBoard, 5, true);
        Driver.move(2, testBot);
        String expected = "[ ,  ,  ,  ,  ]\n[ ,  ,  ,  ,  ]\n[ ,  ,  ,  ,  ]\n[ ,  ,  ,  ,  ]\n[*, *, >,  ,  ]\n";
        assertEquals(expected, Driver.printBoard(testBot));
    }

    @Test
    public void Move6EpenDownTest() {
        int[][] newBoard = new int[5][5];
        Player testBot = new Player(0, 0, "Down", "East", newBoard, 5, true);
        Driver.move(6, testBot);
        String expected = "[ ,  ,  ,  ,  ]\n" +
                "[ ,  ,  ,  ,  ]\n" +
                "[ ,  ,  ,  ,  ]\n" +
                "[ ,  ,  ,  ,  ]\n" +
                "[>,  ,  ,  ,  ]\n";
        assertEquals(expected, Driver.printBoard(testBot));
    }

    @Test
    public void Move6NpenDownTest() {
        int[][] newBoard = new int[5][5];
        Player testBot = new Player(0, 0, "Down", "North", newBoard, 5, true);
        Driver.move(6, testBot);
        String expected = "[ ,  ,  ,  ,  ]\n" +
                "[ ,  ,  ,  ,  ]\n" +
                "[ ,  ,  ,  ,  ]\n" +
                "[ ,  ,  ,  ,  ]\n" +
                "[^,  ,  ,  ,  ]\n";
        assertEquals(expected, Driver.printBoard(testBot));
    }

    @Test
    public void Move0NpenDownTest() {
        int[][] newBoard = new int[5][5];
        Player testBot = new Player(0, 0, "Down", "North", newBoard, 5, true);
        Driver.move(0, testBot);
        String expected = "[ ,  ,  ,  ,  ]\n" +
                "[ ,  ,  ,  ,  ]\n" +
                "[ ,  ,  ,  ,  ]\n" +
                "[ ,  ,  ,  ,  ]\n" +
                "[^,  ,  ,  ,  ]\n";
        assertEquals(expected, Driver.printBoard(testBot));
    }

    @Test
    public void Move1SpenDownTest() {
        int[][] newBoard = new int[5][5];
        Player testBot = new Player(0, 0, "Down", "South", newBoard, 5, true);
        Driver.move(1, testBot);
        String expected = "[ ,  ,  ,  ,  ]\n" +
                "[ ,  ,  ,  ,  ]\n" +
                "[ ,  ,  ,  ,  ]\n" +
                "[ ,  ,  ,  ,  ]\n" +
                "[v,  ,  ,  ,  ]\n";
        assertEquals(expected, Driver.printBoard(testBot));
    }

    @Test
    public void Move1NpenUp2NpenDown3EpenUp3SpenDownTest() {
        int[][] newBoard = new int[5][5];
        Player testBot = new Player(0, 0, "Up", "North", newBoard, 5, true);
        Driver.move(1, testBot);
        testBot.pen = "Down";
        Driver.move(2, testBot);
        testBot.orientation = "East";
        testBot.pen = "Up";
        Driver.move(3, testBot);
        testBot.orientation = "South";
        testBot.pen = "Down";
        Driver.move(3, testBot);
        String expected = "[ ,  ,  ,  ,  ]\n" +
                "[*,  ,  , *,  ]\n" +
                "[*,  ,  , *,  ]\n" +
                "[*,  ,  , *,  ]\n" +
                "[ ,  ,  , v,  ]\n";
        assertEquals(expected, Driver.printBoard(testBot));
    }

    @Test
    public void Move4E2WpenDownTest() {
        int[][] newBoard = new int[5][5];
        Player testBot = new Player(0, 0, "Down", "East", newBoard, 5, true);
        Driver.move(4, testBot);
        testBot.orientation = "West";
        Driver.move(2, testBot);
        String expected = "[ ,  ,  ,  ,  ]\n" +
                "[ ,  ,  ,  ,  ]\n" +
                "[ ,  ,  ,  ,  ]\n" +
                "[ ,  ,  ,  ,  ]\n" +
                "[*, *, <, *, *]\n";
        assertEquals(expected, Driver.printBoard(testBot));
    }

    @Test
    public void execute3Test() {
        String testCommand = "i 9";
        int expected = 3;
        assertEquals(expected, Driver.execute(testCommand));
    }

    @Test
    public void execute3CapitalTest() {
        String testCommand = "I 9";
        int expected = 3;
        assertEquals(expected, Driver.execute(testCommand));
    }

    @Test
    public void execute4Test() {
        String testCommand = "p";
        int expected = 4;
        assertEquals(expected, Driver.execute(testCommand));
    }

    @Test
    public void execute4CapitalTest() {
        String testCommand = "P";
        int expected = 4;
        assertEquals(expected, Driver.execute(testCommand));
    }

    @Test
    public void execute5Test() {
        String testCommand = "c";
        int expected = 5;
        assertEquals(expected, Driver.execute(testCommand));
    }

    @Test
    public void execute5CapitalTest() {
        String testCommand = "C";
        int expected = 5;
        assertEquals(expected, Driver.execute(testCommand));
    }

    @Test
    public void execute6Test() {
        String testCommand = "h";
        int expected = 6;
        assertEquals(expected, Driver.execute(testCommand));
    }

    @Test
    public void execute6CapitalTest() {
        String testCommand = "H";
        int expected = 6;
        assertEquals(expected, Driver.execute(testCommand));
    }

    @Test
    public void execute7Test() {
        String testCommand = "u";
        int expected = 7;
        assertEquals(expected, Driver.execute(testCommand));
    }

    @Test
    public void execute7CapitalTest() {
        String testCommand = "U";
        int expected = 7;
        assertEquals(expected, Driver.execute(testCommand));
    }

    @Test
    public void execute8Test() {
        String testCommand = "d";
        int expected = 8;
        assertEquals(expected, Driver.execute(testCommand));
    }

    @Test
    public void execute8CapitalTest() {
        String testCommand = "D";
        int expected = 8;
        assertEquals(expected, Driver.execute(testCommand));
    }

    @Test
    public void execute9Test() {
        String testCommand = "r";
        int expected = 9;
        assertEquals(expected, Driver.execute(testCommand));
    }

    @Test
    public void execute9CapitalTest() {
        String testCommand = "R";
        int expected = 9;
        assertEquals(expected, Driver.execute(testCommand));
    }

    @Test
    public void execute10Test() {
        String testCommand = "l";
        int expected = 10;
        assertEquals(expected, Driver.execute(testCommand));
    }

    @Test
    public void execute10CapitalTest() {
        String testCommand = "L";
        int expected = 10;
        assertEquals(expected, Driver.execute(testCommand));
    }

    @Test
    public void execute11Test() {
        String testCommand = "m 3";
        int expected = 11;
        assertEquals(expected, Driver.execute(testCommand));
    }

    @Test
    public void execute11CapitalTest() {
        String testCommand = "M 3";
        int expected = 11;
        assertEquals(expected, Driver.execute(testCommand));
    }

    @Test
    public void execute12Test() {
        String testCommand = "m 0.5";
        int expected = 12;
        assertEquals(expected, Driver.execute(testCommand));
    }

    @Test
    public void execute12CapitalTest() {
        String testCommand = "M 0.5";
        int expected = 12;
        assertEquals(expected, Driver.execute(testCommand));
    }

    @Test
    public void execute0Test() {
        String testCommand = "wrong Command";
        int expected = 0;
        assertEquals(expected, Driver.execute(testCommand));
    }

    @Test
    public void printHistoryTest() {
        Driver.inputHistory.add("i 9");
        Driver.inputHistory.add("m 2");
        Driver.inputHistory.add("someWrongCommand");
        Driver.inputHistory.add("c");
        String expected = "\n" +
                "Your input history is:\n" +
                "i 9\n" +
                "m 2\n" +
                "someWrongCommand\n" +
                "c\n";
        assertEquals(expected, Driver.printHistory());
    }
}