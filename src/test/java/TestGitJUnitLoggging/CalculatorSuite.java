package TestGitJUnitLoggging;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created with IntelliJ IDEA.
 * User: dkorolev
 * Date: 19.09.13
 * Time: 17:32
 * To change this template use File | Settings | File Templates.
 */


@RunWith(value = Suite.class)
@Suite.SuiteClasses(
        value = {
                CalculatorTest.class,
                CalculatorNegativeTest.class
        }
)

public class CalculatorSuite {
}
