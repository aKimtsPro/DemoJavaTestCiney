package be.bstorm.akimts.test;



import be.bstorm.akimts.test.exo.annot.Basketteur;
import be.bstorm.akimts.test.exo.annot.Equipe;
import be.bstorm.akimts.test.exo.annot.Sportif;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EquipeTest {

    @Test
    public void ajouter_whenSportif_null(){


        Equipe<Basketteur> equipe = new Equipe<>(5);

        assertThrows(
                IllegalArgumentException.class,
                () -> { equipe.ajouter( null ); }
        );

    }

}
