package be.bstorm.akimts.test;

import be.bstorm.akimts.test.calc.Calculatrice;

public class Caisse {

    private final Calculatrice calculatrice;
    private int solde;

    public Caisse(Calculatrice calculatrice) {
        this.calculatrice = calculatrice;
    }

    public void accepterAchat(int prix){
        if( prix <= 0 )
            throw new IllegalArgumentException();

        solde = calculatrice.addition( solde, prix );
    }

    public void accepteAchats(int prix, int qtt){
        if( prix <= 0 || qtt <= 0 )
            throw new IllegalArgumentException();

        solde = calculatrice.addition( solde, calculatrice.multiplication(prix, qtt) );
    }

    public int getSolde() {
        return solde;
    }
}
