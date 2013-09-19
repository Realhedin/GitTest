package TestGitJUnitLoggging;

import java.lang.Float;
import java.lang.Integer;
import java.lang.NullPointerException;

/**
 * Created with IntelliJ IDEA.
 * User: dkorolev
 * Date: 19.09.13
 * Time: 15:06
 * To change this template use File | Settings | File Templates.
 */
public class Calculator {

    public Integer add(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new NullPointerException();
        }
        return a + b;
    }

    public Integer substract(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new NullPointerException();
        }
        return a - b;
    }

    public Integer multiply(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new NullPointerException();
        }
        return a * b;
    }

    public Float division(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new NullPointerException();
        }
        if (b.equals(0)) {
            System.out.println("Deletion by Zero is prohibited!");
            return null;
        } else {
            return (float) a / (float) b;
        }
    }
}
