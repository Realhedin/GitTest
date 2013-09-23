package Controller;

/**
 * Created with IntelliJ IDEA.
 * User: dkorolev
 * Date: 23.09.13
 * Time: 14:37
 * To change this template use File | Settings | File Templates.
 */
public interface RequestHandler {
    Response process(Request request) throws Exception;
}
