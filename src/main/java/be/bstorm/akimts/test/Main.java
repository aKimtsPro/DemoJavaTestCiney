package be.bstorm.akimts.test;

import java.util.Set;

public class Main {

    public static void main(String[] args) {

        System.out.println(-2147483648 / 2);

        for (int i = 0; i < 100; i++) {
            System.out.println(Integer.MIN_VALUE * (1+i*2));
        }


//        Set<Class<?>> classes = ClassGetter.findClassesInPackage( Main.class.getPackageName() );
//
//        Personne p = new Personne("luc", 89);
//        Class<? extends Personne> clazz = p.getClass();
//
//        DeCon con;
//        for (Class<?> aClass : classes) {
//            if( (con = aClass.getAnnotation(DeCon.class)) != null )
//                System.out.println("La classe " + aClass.getSimpleName() + " est conne à un niveau: " + con.value() );
//            else
//                System.out.println("La classe " + aClass.getSimpleName() + " n'est pas conne");
//        }


    }

}
