import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DriverTest {
    @Test
    public void DriverTest() {
        // For testing System.out.println() statements
        String testInput = "I 9\np\nq\n";

        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Driver.main(new String[] {});
        System.out.println(out.toString());
    }

    @Test
    public void Driver2ndTest() {
        int[][] newBoard = new int[9][9];
        Player testBot = new Player(0, 0, "Up", "North", newBoard, 9, true);
        String testOutput = Driver.printBoard(testBot);
        assertEquals("[ ,  ,  ,  ,  ,  ,  ,  ,  ]\n[ ,  ,  ,  ,  ,  ,  ,  ,  ]\n[ ,  ,  ,  ,  ,  ,  ,  ,  ]\n[ ,  ,  ,  ,  ,  ,  ,  ,  ]\n[ ,  ,  ,  ,  ,  ,  ,  ,  ]\n[ ,  ,  ,  ,  ,  ,  ,  ,  ]\n[ ,  ,  ,  ,  ,  ,  ,  ,  ]\n[ ,  ,  ,  ,  ,  ,  ,  ,  ]\n[P,  ,  ,  ,  ,  ,  ,  ,  ]\n", testOutput);
    }
}
