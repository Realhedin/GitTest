package stub;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: dkorolev
 * Date: 15.10.13
 * Time: 15:54
 * To change this template use File | Settings | File Templates.
 */
public class TestWebClient1 {

    @BeforeClass
    public static void setUp() {
        TestWebClient1 t = new TestWebClient1();
        URL.setURLStreamHandlerFactory(t.new StubStreamHandlerFactory());
    }

    private class StubStreamHandlerFactory implements URLStreamHandlerFactory {
        @Override
        public URLStreamHandler createURLStreamHandler(String protocol) {
            return new StubHttpURLStreamHandler();
        }
    }

    private class StubHttpURLStreamHandler extends URLStreamHandler {
        @Override
        protected URLConnection openConnection(URL u) throws IOException {
            return new StubHttpURLConnection(u);
        }
    }

    @Test
    public void testGetContentOk() throws Exception {
        WebClient client = new WebClient();
        String result = client.getContent(new URL("http://localhost"));
        Assert.assertEquals("It works", result);
    }
}
