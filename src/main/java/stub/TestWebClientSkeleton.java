package stub;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: dkorolev
 * Date: 14.10.13
 * Time: 19:07
 * To change this template use File | Settings | File Templates.
 */
public class TestWebClientSkeleton {

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
        //stop Jetty
    }

    @Test
    public void testGetContentOk() throws Exception {
        WebClient client = new WebClient();
        String result = client.getContent(new URL("http://localhost:8080/testGetContentOk"));
        Assert.assertEquals("It works",result);
    }
}
