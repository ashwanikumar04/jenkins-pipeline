package in.ashwanik.jp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void givenTwoIntegersWhenAddThenReturnSum() {
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.add(1, 2));
    }

    @Test
    public void givenTwoSameIntegersWhenAddThenReturnSum() {
        Calculator calculator = new Calculator();
        assertEquals(2, calculator.add(1, 1));
    }

    @Test
    public void givenTwoIntegersWhenAddThenReturnDifference() {
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.minus(4, 1));
    }
}
