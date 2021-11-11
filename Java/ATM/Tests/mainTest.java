import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class mainTest {
    @Test
    void testTheArray(){
        //Testing random Numbers
        assertEquals("1,2,0,0,0,0,0,0,0", main.berechnen(1400));
        assertEquals("0,0,0,0,0,0,0,2,1", main.berechnen(5));
        assertEquals("0,0,0,0,0,0,0,1,0",main.berechnen(2));

    }

}