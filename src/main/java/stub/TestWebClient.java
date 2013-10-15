package stub;

import org.junit.*;
import org.mortbay.jetty.HttpHeaders;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.util.ByteArrayISO8859Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;


/**
 * Created with IntelliJ IDEA.
 * User: dkorolev
 * Date: 15.10.13
 * Time: 13:48
 * To change this template use File | Settings | File Templates.
 */
public class TestWebClient {

    WebClient client;


    @BeforeClass
    public static void setUp() throws Exception {
        Server server = new Server(8080);

        TestWebClient t = new TestWebClient();

        Context contentOkContent = new Context(server, "/testGetContentOk");
        contentOkContent.setHandler(t.new TestGetContentOkHandler());

        Context contentNotFound = new Context(server, "/testGetContentNotFound");
        contentNotFound.setHandler(t.new TestGetContentNotFoundHandler());

        Context contentNotAvailable = new Context(server, "/testGetContentNotAvailable");
        contentNotAvailable.setHandler(t.new TestGetContentNotAvailable());

        server.setStopAtShutdown(true);
        server.start();


    }

    @Before
    public void init() {
        client = new WebClient();
    }

    @Test
    public void testGetContentOk() throws Exception {
        //WebClient client = new WebClient();
        String result = client.getContent(new URL(
                "http://localhost:8080/testGetContentOk"));
        Assert.assertEquals("It works", result);
    }


    @Test
    public void testGetContentNotFound() throws Exception {
        //WebClient client = new WebClient();
        String result = client.getContent(new URL(
                "http://localhost:8080/testGetContentNotFound"));
        Assert.assertNull(result);
    }

    @Test
    public void testGetContentNotAvailable() throws Exception {
        //WebClient client = new WebClient();
        String result = client.getContent(new URL("http://localhost:8080/testGetContentNotAvailable"));
        Assert.assertNull(result);
    }

    @AfterClass
    public static void tearDown() {
        //empty
    }

    private class TestGetContentOkHandler extends AbstractHandler {
        @Override
        public void handle(String s, HttpServletRequest request, HttpServletResponse response, int i)
                throws IOException, ServletException {
            OutputStream out = response.getOutputStream();
            ByteArrayISO8859Writer writer = new ByteArrayISO8859Writer();
            writer.write("It works");
            writer.flush();
            response.setIntHeader(HttpHeaders.CONTENT_LENGTH, writer.size());
            writer.writeTo(out);
            out.flush();
        }
    }

    private class TestGetContentNotFoundHandler extends AbstractHandler {

        @Override
        public void handle(String s, HttpServletRequest request, HttpServletResponse response, int i) throws IOException, ServletException {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    private class TestGetContentNotAvailable extends AbstractHandler {

        @Override
        public void handle(String s, HttpServletRequest request, HttpServletResponse response, int i) throws IOException, ServletException {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

}
