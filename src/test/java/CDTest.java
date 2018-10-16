import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CDTest {

    CD cd;

    @Before
    public void before(){
        cd = new CD("TEST", 10);
    }

    @Test
    public void hasName(){
        assertEquals("TEST", cd.getName());
    }

    @Test
    public void hasTracks(){
        assertEquals(10, cd.getTracks());
    }

}
