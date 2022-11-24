package be.bstorm.akimts.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class PersonneTest {

    @Disabled
    @Test
    void allAsserts(){

        // Si un test echoue, la méthode suivante est appelée
        // fail()
        // Elle lance une AssertionFailedError -> notre test est raté

        assertFalse(false);
        assertTrue(true);

        // ?.equals(?)
        assertEquals(1, 1);
        assertNotEquals(1,2);

        Object a = new Object();
        Object b = a;
        // ? == ?
        assertSame(a, b);
        assertNotSame(a, new Object());

        assertArrayEquals(new int[]{1},new int[]{1});

        assertInstanceOf(Object.class, new Object());

        assertTimeout(Duration.of(5, ChronoUnit.SECONDS),
                () -> Thread.sleep(4000)
        ); // va jusqu'au bout de l'exec
        assertTimeoutPreemptively(Duration.of(5, ChronoUnit.SECONDS),
                () -> Thread.sleep(4000)
        ); // s'arrête une fois la durée excédée

        assertDoesNotThrow(() -> {});
        assertThrows(RuntimeException.class, () -> {
            throw new IllegalArgumentException();
        });
        assertThrowsExactly(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException();
        });

    }

    @Test
    void ctor_valid(){
        String nom = "luc";
        int age = 15;

        Personne p = new Personne(nom, age);

        assertEquals("luc", p.getNom());
        assertEquals(15, p.getAge());
    }

    @Test
    void ctor_nomInvalid(){
        String nom = null;
        int age = 15;

        assertThrows( IllegalArgumentException.class, () -> new Personne(nom, age) );
    }

    @Test
    void ctor_ageInvalid(){
        String nom = "luc";
        int age = -5;

        Personne p = new Personne(nom, age);

        assertEquals("luc", p.getNom());
        assertEquals(0, p.getAge());
    }

    @Test
    void setNom_null() {
        Personne p = new Personne("pol", 27);

        p.setNom( null );

        assertEquals( "pol", p.getNom() );
    }

    @Test
    void setNom_valid() {
        Personne p = new Personne("pol", 27);

        p.setNom( "luc" );

        assertEquals( "luc", p.getNom() );
    }

    @Test
    void vieillir() {
        Personne p = new Personne("pol", 10);

        p.vieillir();

        assertEquals( 11, p.getAge() );
    }
}