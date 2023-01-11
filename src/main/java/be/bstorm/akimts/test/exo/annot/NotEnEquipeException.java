package be.bstorm.akimts.test.exo.annot;

public class NotEnEquipeException extends IllegalArgumentException {

    public NotEnEquipeException() {
        super("Le sportif devrait provenir d'une classe annotée de @EnEquipe");
    }
}
