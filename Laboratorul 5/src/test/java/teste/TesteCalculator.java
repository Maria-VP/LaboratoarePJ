package teste;

import Exercitiul1.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TesteCalculator {
    @Test
    void test1_suma() {
        Calculator c=new Calculator(4,5);
        assertEquals(9, c.suma());
    }
    @Test
    void test2_suma() {
        Calculator c=new Calculator(2,2);
        assertTrue(c.suma()==4);
    }
    @Test
    void test3_suma() {
        Calculator c=new Calculator(3,7);
        assertFalse(c.suma()!=10);
    }
}
