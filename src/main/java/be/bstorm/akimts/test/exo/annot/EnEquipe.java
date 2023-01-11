package be.bstorm.akimts.test.exo.annot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( {ElementType.TYPE} )
@Retention( RetentionPolicy.RUNTIME )
public @interface EnEquipe {
    int[] taille() default {2,3};

}
