package be.bstorm.akimts.test.exo.annot;

public class Main {

    public static void main(String[] args) {

        Sportif sportif = new Basketteur();

        Equipe<Sportif> equipe = new Equipe<>(8);
        equipe.ajouter( sportif );

    }

}
