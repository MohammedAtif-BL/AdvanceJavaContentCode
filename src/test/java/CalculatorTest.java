import com.bridgelabz.content.calculatorapp.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testAddition() {
        assertEquals(5, calculator.performOperation("add", 2, 3));
    }

    @Test
    public void testSubtraction() {
        assertEquals(1, calculator.performOperation("subtract", 3, 2));
    }

    @Test
    public void testMultiplication() {
        assertEquals(6, calculator.performOperation("multiply", 2, 3));
    }

    @Test
    public void testDivision() {
        assertEquals(2, calculator.performOperation("divide", 6, 3));
    }

    @Test
    public void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.performOperation("divide", 6, 0);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }

    @Test
    public void testExponentiation() {
        assertEquals(8, calculator.performOperation("exponentiate", 2, 3));
    }

    @Test
    public void testSquareRoot() {
        assertEquals(2, calculator.performOperation("squareroot", 4, 0));
    }

    @Test
    public void testInvalidOperation() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.performOperation("invalid", 2, 3);
        });
        assertEquals("Invalid operation: invalid", exception.getMessage());
    }
}

