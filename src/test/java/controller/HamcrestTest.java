package controller;

import org.hamcrest.core.AnyOf;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;
import org.hamcrest.CoreMatchers;

import java.util.ArrayList;
import java.util.List;



/**
 * Created with IntelliJ IDEA.
 * User: dkorolev
 * Date: 24.09.13
 * Time: 16:07
 * To change this template use File | Settings | File Templates.
 */
public class HamcrestTest {
    private List<String> values;

    @Before
    public void setUpList() {
        values = new ArrayList<String>();
        values.add("x");
        values.add("y");
        values.add("z");
    }

    @Test
    public void testWithoutHamcrest() {
        Assert.assertTrue(values.contains("one")
                || values.contains("two")
                || values.contains("three"));
    }

    @Test
    public void testWithHamcrest() {
        Assert.assertThat(values, JUnitMatchers.hasItem(CoreMatchers.anyOf(
                CoreMatchers.equalTo("one"),
                CoreMatchers.equalTo("two"),
                CoreMatchers.equalTo("three")
        )));
    }
}
