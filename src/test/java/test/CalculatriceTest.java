package test;

import be.bstorm.akimts.test.calc.Calculatrice;
import static org.junit.jupiter.api.Assertions.*;

import be.bstorm.akimts.test.calc.CalculatriceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatriceTest {

    public Calculatrice calculatrice;

    @BeforeEach
    public void setup(){
        calculatrice = new CalculatriceImpl();
    }

    @Test
    public void addition_whenNoOverflow(){

        int rslt = calculatrice.addition( 4, 5 );
        assertEquals(9, rslt);

    }

    @Test
    public void addition_whenOverflow_positive(){

        int rslt = calculatrice.addition( Integer.MAX_VALUE, Integer.MAX_VALUE );
        assertEquals( Integer.MAX_VALUE, rslt );

    }

    @Test
    public void addition_whenOverflow_negative(){

        int rslt = calculatrice.addition( Integer.MIN_VALUE, Integer.MIN_VALUE );
        assertEquals( Integer.MIN_VALUE, rslt );

    }

    @Test
    public void soustraction_whenNoOverflow(){

        int rslt = calculatrice.soustraction( 5, 3 );
        assertEquals( 2, rslt );

    }

    @Test
    public void soustraction_whenOverflow_negative(){
        int rslt = calculatrice.soustraction( Integer.MIN_VALUE, Integer.MAX_VALUE );
        assertEquals( Integer.MIN_VALUE, rslt );
    }

    public void soustraction_whenOverflow_positive(){
        int rslt = calculatrice.soustraction( Integer.MAX_VALUE, Integer.MIN_VALUE );
        assertEquals( Integer.MAX_VALUE, rslt );
    }

    @Test
    public void multiplication_whenNoOverflow(){
        int rslt = calculatrice.multiplication( 3, 5 );
        assertEquals( 15, rslt );
    }

    @Test
    public void multiplication_whenOverflow_positive(){
        int rslt = calculatrice.multiplication(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals( Integer.MAX_VALUE, rslt );
    }

    @Test
    public void multiplication_whenOverflow_negative(){
        int rslt = calculatrice.multiplication(Integer.MAX_VALUE, Integer.MIN_VALUE);
        assertEquals( Integer.MIN_VALUE, rslt );
    }

    @Test
    public void division_whenNotBy0(){
        double rslt = calculatrice.division( 3, 2 );
        assertEquals( 1.5, rslt );
    }

    @Test
    public void division_whenBy0(){
        assertThrows(
                IllegalArgumentException.class,
                () -> calculatrice.division(5, 0)
        );
    }

    @Test
    public void divisionEntiere_whenNotBy0(){
        int rslt = calculatrice.divisionEntiere( 3, 2 );
        assertEquals( 1, rslt );

    }

    @Test
    public void divisionEntiere_whenBy0(){
        assertThrows(
                IllegalArgumentException.class,
                () -> calculatrice.divisionEntiere(5, 0)
        );
    }

    @Test
    public void modulo_whenNotBy0(){
        int rslt = calculatrice.modulo( 7, 5 );
        assertEquals( 2, rslt );
    }

    @Test
    public void modulo_whenBy0(){
        assertThrows(
                IllegalArgumentException.class,
                () -> calculatrice.modulo(5, 0)
        );
    }
}
