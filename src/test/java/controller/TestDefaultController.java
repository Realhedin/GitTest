package controller;

import Controller.DefaultController;
import Controller.Request;
import Controller.RequestHandler;
import Controller.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: dkorolev
 * Date: 23.09.13
 * Time: 16:52
 * To change this template use File | Settings | File Templates.
 */
public class TestDefaultController {

    private DefaultController controller;
    private Request request;
    private RequestHandler handler;

    @Before
    public void instantiate() throws Exception {
        controller = new DefaultController();
        request = new SampleRequest();
        handler = new SampleHandler();

        controller.addHandler(request, handler);
    }


    /*
    Our tests
     */
    @Test
    public void testMethod() {
        throw new RuntimeException("implement me");
    }


    @Test
    public void testAddHandler() {
        RequestHandler handler2 = controller.getHandler(request);
        Assert.assertSame("Handler we set in controller should be the same, that we get", handler2, handler);
    }


    @Test
    public void testProcessRequest() {   //test if response Object suit us
        Response response = controller.processRequest(request);
        Assert.assertNotNull("This should not be null response", response);
        Assert.assertEquals("Response should be of type SampleResponse", SampleResponse.class, response.getClass());
    }


    @Test
    public void testProcessRequest2() {   //test if response is the same
        Response response = controller.processRequest(request);
        Assert.assertNotNull("this should not be null response", response);
        Assert.assertEquals(" ", new SampleResponse(), response);
    }


    /*
    test inner classes
     */
    private class SampleRequest implements Request {
        public String getName() {
            return "Test";
        }
    }

    private class SampleHandler implements RequestHandler {

        @Override
        public Response process(Request request) throws Exception {
            return new SampleResponse();
        }
    }

    private class SampleResponse implements Response {
        private static final String NAME = "Test";
        public String getName() {
            return NAME;
        }

        public boolean equals(Object object) {
            boolean result = false;
            if (object instanceof SampleResponse) {
                result = ((SampleResponse)object).getName().equals(getName());
            }
            return result;
        }

        public int hashcode() {
            return NAME.hashCode();
        }
    }
}
