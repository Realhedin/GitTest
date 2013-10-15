package stub;

import org.mortbay.jetty.HttpHeaders;
import org.mortbay.jetty.handler.AbstractHandler;
import org.mortbay.util.ByteArrayISO8859Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: dkorolev
 * Date: 15.10.13
 * Time: 12:46
 * To change this template use File | Settings | File Templates.
 */
public class TestGetContentOkHandler extends AbstractHandler {

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
