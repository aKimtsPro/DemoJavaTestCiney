package be.bstorm.akimts.test.exo.annot;

public class TeamSizeExceededException extends RuntimeException {

    private final int tailleMax;
    public TeamSizeExceededException(int tailleMax) {
        super("La taille de l'équipe ne peut dépasser " + tailleMax);
        this.tailleMax = tailleMax;
    }

    public int getTailleMax() {
        return tailleMax;
    }
}
