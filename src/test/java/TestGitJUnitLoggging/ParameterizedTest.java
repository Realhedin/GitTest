package TestGitJUnitLoggging;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: dkorolev
 * Date: 20.09.13
 * Time: 14:09
 * To change this template use File | Settings | File Templates.
 */
@RunWith(value = Parameterized.class)
public class ParameterizedTest {

    private Integer expected;
    private Integer valueOne;
    private Integer valueTwo;

    @Parameterized.Parameters
    public static Collection<Integer[]> getTestParameters() {
        return Arrays.asList(new Integer[][] {
                {2,1,1},   //expected, valueOne, valueTwo
                {3,2,1},
                {6,2,4}
        });
    }

    public ParameterizedTest(int exp, int v1, int v2) {
        this.expected = exp;
        this.valueOne = v1;
        this.valueTwo = v2;
    }

    @Test
    public void sum() {
        Calculator calc = new Calculator();
        Assert.assertEquals(expected, calc.add(valueOne,valueTwo));
    }
}
