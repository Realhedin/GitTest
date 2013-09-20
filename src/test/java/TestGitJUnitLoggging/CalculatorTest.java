package TestGitJUnitLoggging;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: dkorolev
 * Date: 19.09.13
 * Time: 16:59
 * To change this template use File | Settings | File Templates.
 */
public class CalculatorTest {

    private Calculator calc;

    @Before
    public void init() {
        calc = new Calculator();
    }


    @Test
    public void addTest() {
        Integer actual = calc.add(Integer.valueOf(6),Integer.valueOf(2));
        Assert.assertEquals(Integer.valueOf(8),actual);
    }

    @Test(expected = NullPointerException.class)
    public void exceptionTest() {
        calc.add(6,null);
    }

}
