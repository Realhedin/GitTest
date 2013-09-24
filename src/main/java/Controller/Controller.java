package controller;

/**
 * Created with IntelliJ IDEA.
 * User: dkorolev
 * Date: 23.09.13
 * Time: 14:38
 * To change this template use File | Settings | File Templates.
 */
public interface Controller {
    Response processRequest(Request request);
    void addHandler(Request request, RequestHandler requestHandler);
}
