package be.bstorm.akimts.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation qualifiant une class de conne à certain niveau.
 * Le niveau est défini par le {@link NiveauConnerie}.
 * @author A.Kimtsaris
 * @see NiveauConnerie
 */
@DeCon( NiveauConnerie.ABRUTI )
@Target( {ElementType.TYPE} )
@Retention( RetentionPolicy.RUNTIME )
public @interface DeCon {

    /**
     * Indique le niveau de connerie de la classe annotée.
     * @return un niveau de connerie défini parmis l'enum {@link NiveauConnerie}
     * @see NiveauConnerie
     */
    NiveauConnerie value() default NiveauConnerie.BETE;

}
