package Controller;

/**
 * Created with IntelliJ IDEA.
 * User: dkorolev
 * Date: 23.09.13
 * Time: 15:02
 * To change this template use File | Settings | File Templates.
 */
public class ErrorResponse implements Response {
    private Request originalRequest;

    private Exception originalException;


    public ErrorResponse(Request request, Exception exception) {
        this.originalRequest = request;
        this.originalException = exception;
    }

    public Request getOriginalRequest() {
        return this.originalRequest;
    }

    public Exception getOriginalException() {
        return this.originalException;
    }
}
