package be.bstorm.akimts.test;

import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<Class<?>> classes = ClassGetter.findClassesInPackage( Main.class.getPackageName() );

        Personne p = new Personne("luc", 89);
        Class<? extends Personne> clazz = p.getClass();

        Con con;
        for (Class<?> aClass : classes) {
            if( (con = aClass.getAnnotation(Con.class)) != null )
                System.out.println("La classe " + aClass.getSimpleName() + " est conne à un niveau: " + con.value() );
            else
                System.out.println("La classe " + aClass.getSimpleName() + " n'est pas conne");
        }


    }

}
