package operations;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;



class OperationsTests {

	@Test
    public void testAddition() {
        Operation<Float> addition = new Addition();
        assertEquals(5.0f, addition.apply(2.0f, 3.0f), 0.0001);
        assertEquals(-1.0f, addition.apply(2.0f, -3.0f), 0.0001);
        assertEquals(0.0f, addition.apply(0.0f, 0.0f), 0.0001);
    }
	
	@Test
    public void testSubtraction() {
        Operation<Float> subtraction = new Subtraction();
        assertEquals(-1.0f, subtraction.apply(2.0f, 3.0f), 0.0001);
        assertEquals(5.0f, subtraction.apply(2.0f, -3.0f), 0.0001);
        assertEquals(0.0f, subtraction.apply(0.0f, 0.0f), 0.0001);
    }
	 @Test
	    public void testMultiplication() {
	        Operation<Float> multiplication = new Multiplication();
	        assertEquals(6.0f, multiplication.apply(2.0f, 3.0f), 0.0001);
	        assertEquals(-6.0f, multiplication.apply(2.0f, -3.0f), 0.0001);
	        assertEquals(0.0f, multiplication.apply(0.0f, 3.0f), 0.0001);
	    }
	 
	 @Test
	    public void testDivision() {
	        Operation<Float> division = new Division();
	        assertEquals(2.0f, division.apply(6.0f, 3.0f), 0.0001);
	        assertEquals(-2.0f, division.apply(6.0f, -3.0f), 0.0001);
	        assertEquals(0.0f, division.apply(0.0f, 3.0f), 0.0001);
	    }

	    @Test
	    public void testDivisionByZero() {
	        Operation<Float> division = new Division();
	        assertThrows(ArithmeticException.class, () -> division.apply(6.0f, 0.0f));
	    }

}