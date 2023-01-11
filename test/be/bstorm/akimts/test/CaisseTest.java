package be.bstorm.akimts.test;

import be.bstorm.akimts.test.calc.Calculatrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CaisseTest {

    private Caisse caisse;

    @BeforeEach
    public void setup(){

        Calculatrice calculatrice = Mockito.mock();

        Mockito.when( calculatrice.addition(0, 4) )
                .thenReturn(4);
        Mockito.when( calculatrice.addition(4, Integer.MAX_VALUE) )
                .thenReturn( Integer.MAX_VALUE );

        caisse = new Caisse( calculatrice );

    }

    @Test
    public void accepterAchat_whenNoOverflow(){
        caisse.accepterAchat(4);
        int soldeFinal = caisse.getSolde();

        Assertions.assertEquals(4, soldeFinal);
    }


}
