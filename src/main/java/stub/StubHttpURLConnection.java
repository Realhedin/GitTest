package stub;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: dkorolev
 * Date: 15.10.13
 * Time: 16:05
 * To change this template use File | Settings | File Templates.
 */
public class StubHttpURLConnection extends HttpURLConnection {
    private boolean isInput = true;

    protected StubHttpURLConnection(URL url) {
        super(url);
    }

    public InputStream getInputStream() throws IOException {
        if (!isInput) {
            throw new ProtocolException("Cannot read from URLConnnection" +
                    " if doInput=false (call setDoInput(true)) ");
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(
                new String("It works").getBytes());
        return bais;
    }

    @Override
    public void disconnect() {
        //empty
    }

    @Override
    public boolean usingProxy() {
        return false;
    }

    @Override
    public void connect() throws IOException {
        //empty
    }
}
