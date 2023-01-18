package test;

import be.bstorm.akimts.test.Caisse;
import be.bstorm.akimts.test.calc.Calculatrice;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


public class CaisseTest {

    private Caisse caisse;

    @BeforeEach
    public void setup(){

        Calculatrice calculatrice = mock();

        when( calculatrice.addition(0, 4) )
                .thenReturn(4);
        when( calculatrice.addition(4, Integer.MAX_VALUE) )
                .thenReturn( Integer.MAX_VALUE );
        when( calculatrice.addition(0, Integer.MAX_VALUE) )
                .thenReturn( Integer.MAX_VALUE );

        when( calculatrice.multiplication(2, 2) )
                .thenReturn(4);
        when( calculatrice.multiplication(2, Integer.MAX_VALUE) )
                .thenReturn(Integer.MAX_VALUE);

        caisse = new Caisse( calculatrice );

    }

    public void accepterAchat_whenPrixInvalid(){
    }

    @Test
    public void accepterAchat_whenNoOverflow(){
        caisse.accepterAchat(4);
        int soldeFinal = caisse.getSolde();

        assertEquals(4, soldeFinal);
    }


    @Test
    public void accepterAchat_whenOverflow(){
        caisse.accepterAchat(4);
        caisse.accepterAchat(Integer.MAX_VALUE);

        assertEquals(Integer.MAX_VALUE, caisse.getSolde());
    }

    @Test
    public void accepterAchat_whenPrixNegatif(){
        assertThrows(
                IllegalArgumentException.class,
                () -> caisse.accepterAchat(-5)
        );
    }

    @Test
    public void accepteAchats_whenNoOverflow(){
        caisse.accepteAchats(2, 2);

        assertEquals( 4, caisse.getSolde() );
    }

    @Test
    public void accepteAchats_whenPrixNegatif(){
        assertThrows(
                IllegalArgumentException.class,
                () -> caisse.accepteAchats(-5, 2)
        );
    }


    @Test
    public void accepteAchats_whenQttNegatif(){
        assertThrows(
                IllegalArgumentException.class,
                () -> caisse.accepteAchats(5, -2)
        );
    }

    @Test
    public void accepteAchats_whenOverflow(){
        caisse.accepteAchats(2,Integer.MAX_VALUE);

        assertEquals( Integer.MAX_VALUE, caisse.getSolde() );
    }

}
