package TestGitJUnitLoggging;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

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
         public void addNullTest() {
        calc.add(null,null);
    }

    @Test(expected = NullPointerException.class)
    public void addExcTest1() {
        calc.add(null,6);
    }

    @Test(expected = NullPointerException.class)
    public void addExcTest2() {
        calc.add(6,null);
    }


     @Test
    public void subTest() {
        Integer actual = calc.substract(8,2);
        Assert.assertEquals(Integer.valueOf(6),actual);
    }

    @Test(expected = NullPointerException.class)
    public void subNullTest() {
        calc.substract(null,null);
    }

    @Test(expected = NullPointerException.class)
    public void subExcTest1() {
        calc.substract(null,6);
    }

    @Test(expected = NullPointerException.class)
    public void subExcTest2() {
        calc.substract(6,null);
    }

    @Test
    public void mulTest() {
        Integer actual = calc.multiply(4,2);
        Assert.assertEquals(Integer.valueOf(8),actual);
    }

    @Test(expected = NullPointerException.class)
    public void mulNullTest() {
        calc.multiply(null,null);
    }

    @Test(expected = NullPointerException.class)
    public void mulExcTest1() {
        calc.multiply(null,6);
    }

    @Test(expected = NullPointerException.class)
    public void mulExcTest2() {
        calc.multiply(6,null);
    }

    @Test
    public void divTest() {
        Float actual = calc.division(8,2);
        Assert.assertEquals(Float.valueOf(4),actual);
    }

    @Test(expected = NullPointerException.class)
    public void divNullTest() {
        calc.division(null,null);
    }

    @Test(expected = NullPointerException.class)
    public void divExcTest1() {
        calc.division(null,6);
    }

    @Test(expected = NullPointerException.class)
    public void divExcTest2() {
        calc.division(6,null);
    }

    @Test
    public void divEquals0Test() {
        calc.division(6,0);
    }

}
