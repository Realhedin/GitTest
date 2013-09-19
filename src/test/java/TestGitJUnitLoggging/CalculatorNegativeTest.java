package TestGitJUnitLoggging;

import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: dkorolev
 * Date: 19.09.13
 * Time: 17:27
 * To change this template use File | Settings | File Templates.
 */
public class CalculatorNegativeTest {

    private Calculator calculator;

    @Before
    public void init() {
        calculator = new Calculator();
    }

    @Test
    public void calculatorNegative() {
        Integer sumNeg = calculator.add(Integer.valueOf(6),Integer.valueOf(4));
        if (!sumNeg.equals(10)) {
            System.out.println("Negative Test failed");
        } else {
            System.out.println("Negative Test successfully completed.");
        }
    }

}
