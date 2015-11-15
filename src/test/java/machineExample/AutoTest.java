package machineExample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

/**
 * Created by dkorolev on 11/15/15.
 */
public class AutoTest {
    private Auto bwm;

    @Before
    public void init() {
        bwm = new Auto("bmw",4, Mockito.mock(Driver.class),
                LocalDateTime.of(2013,5,12,12,00),50,250);
    }

    @Test
    public void getName() {
        Assert.assertEquals("bmw",bwm.getBrand());
    }

    @Test
    public void getNumOfSeats() {
        Assert.assertEquals(4,bwm.getNumOfSeats());
    }

    @Test
    public void getMaxDistanceTest() {
        Integer maxDistance = bwm.whatIsMaxDistance(bwm.getSizeOfTank(), bwm.getMaxSpeed());
        Assert.assertEquals(10000L,(long)maxDistance);
    }

    @Test
    public void getDriverName() {
        String driverName = bwm.getDriver().getName();
        System.out.println(driverName);
        Assert.assertNull(driverName);

    }

}
