import com.bridgelabz.content.junit.MathOperations;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExampleTest {
    MathOperations mathOps = new MathOperations();

    // Addition Test
    @Test
    public void testAddition() {
        assertEquals(5, mathOps.add(2, 3));
        assertEquals(-1, mathOps.add(2, -3));
        assertEquals(0, mathOps.add(0, 0));
    }

    // Subtraction Test
    @Test
    public void testSubtraction() {
        assertEquals(1, mathOps.subtract(3, 2));
        assertEquals(5, mathOps.subtract(2, -3));
        assertEquals(0, mathOps.subtract(0, 0));
    }

    // Multiplication Test
    @Test
    public void testMultiplication() {
        assertEquals(6, mathOps.multiply(2, 3));
        assertEquals(-6, mathOps.multiply(2, -3));
        assertEquals(0, mathOps.multiply(2, 0));
        assertEquals(2, mathOps.multiply(2, 1));
    }

    // Division Test
    @Test
    public void testDivision() {
        assertEquals(2, mathOps.divide(6, 3));
        assertEquals(-2, mathOps.divide(6, -3));
        assertEquals(0, mathOps.divide(0, 1));
        assertEquals(6, mathOps.divide(6, 1));

        // Testing division by zero
        Exception exception = assertThrows(ArithmeticException.class, () -> mathOps.divide(6, 0));
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }

}
