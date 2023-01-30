import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("ADD numbers test")
    void add() {
        assertEquals(14,Calculator.add(6,8));
    }

    @Test
    void multiply() {
    }
}