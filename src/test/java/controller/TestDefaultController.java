package controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
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
//    @Test
//    public void testMethod() {
//        throw new RuntimeException("implement me");
//    }

    //Testing for positive way
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


    @Test
    public void testProcessRequestAnswersErrorResponse() {
        SampleRequest request1 = new SampleRequest("testError");
        SampleExceptionHandler handler1 = new SampleExceptionHandler();
        controller.addHandler(request1,handler1);
        Response response = controller.processRequest(request1);
        Assert.assertNotNull("Must not return a null response", response);
        Assert.assertEquals(ErrorResponse.class, response.getClass());
    }


    //Testing for exceptions
    @Test(expected = RuntimeException.class)
    public void testGetHandlerNotDefined() {
        SampleRequest request = new SampleRequest("testNotDefined");

        //The following line is supposed to throw a Runtime Exception
        controller.getHandler(request);
    }

    @Test(expected = RuntimeException.class)
    public void testAddRequestDuplicateName() {
        SampleRequest request = new SampleRequest();
        SampleHandler handler = new SampleHandler();

        //The following line is supposed to throw a RuntimeException
        controller.addHandler(request,handler);
    }


    //Timeout test
    @Test(timeout = 10)
    @Ignore (value = "Ignore for now until higher time-limit")
    public void testProcessMultipleRequestsTimeout() {
        Request request;
        Response response = new SampleResponse();
        RequestHandler handler = new SampleHandler();

        for (int i=0; i<99999; i++) {
            request = new SampleRequest(String.valueOf(i));
            controller.addHandler(request, handler);
            response = controller.processRequest(request);
            Assert.assertNotNull(response);
            Assert.assertNotSame(ErrorResponse.class, response.getClass());
        }
    }


    /*
    test inner classes
     */
    private class SampleRequest implements Request {
        private static final String DEFAULT_NAME = "Test";
        private String name;

        public SampleRequest(String name) {
            this.name = name;
        }

        public SampleRequest() {
            this(DEFAULT_NAME);
        }

        public String getName() {
            return this.name;
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
                result = ((SampleResponse) object).getName().equals(getName());
            }
            return result;
        }

        public int hashcode() {
            return NAME.hashCode();
        }
    }

    private class SampleExceptionHandler implements RequestHandler {

        @Override
        public Response process(Request request) throws Exception {
            throw new Exception("error processing request");
        }
    }
}
