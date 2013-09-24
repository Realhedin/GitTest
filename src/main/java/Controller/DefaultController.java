package controller;


import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: dkorolev
 * Date: 23.09.13
 * Time: 14:51
 * To change this template use File | Settings | File Templates.
 */
public class DefaultController implements Controller {

    private Map<String,RequestHandler> requestHandlers = new HashMap<String, RequestHandler>();

    protected RequestHandler getHandler(Request request) {
        if (!this.requestHandlers.containsKey(request.getName())) {
            String message = "Cannot find handler for request name " + "[" +
                    request.getName() + "]";
            throw new RuntimeException(message);
        }
        return this.requestHandlers.get(request.getName());
    }

    @Override
    public Response processRequest(Request request) {
        Response response;
        try {
            response = getHandler(request).process(request);
        } catch (Exception e) {
            response = new ErrorResponse(request, e);
        }
        return response;
    }

    @Override
    public void addHandler(Request request, RequestHandler requestHandler) {
        if (this.requestHandlers.containsKey(request.getName())) {
            throw new RuntimeException("A request handle r has "
            + "already been registered for request name ["
            + request.getName() + "]");
        } else {
            this.requestHandlers.put(request.getName(),requestHandler);
        }
    }
}
