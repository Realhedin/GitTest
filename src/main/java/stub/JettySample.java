package stub;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.ResourceHandler;
import org.mortbay.jetty.servlet.Context;

/**
 * Created with IntelliJ IDEA.
 * User: dkorolev
 * Date: 14.10.13
 * Time: 18:26
 * To change this template use File | Settings | File Templates.
 */
public class JettySample {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        Context root = new Context(server, "/");
        root.setResourceBase("./pom.xml");
        root.setHandler(new ResourceHandler());

        server.start();
    }
}
