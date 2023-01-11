package be.bstorm.akimts.test;

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

        caisse = new Caisse( calculatrice );

    }

    @Test
    public void accepterAchat_whenNoOverflow(){
        caisse.accepterAchat(4);
        int soldeFinal = caisse.getSolde();

        assertEquals(4, soldeFinal);
    }


}
