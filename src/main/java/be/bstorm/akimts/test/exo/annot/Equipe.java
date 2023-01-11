package be.bstorm.akimts.test.exo.annot;

import java.util.ArrayList;
import java.util.List;

public class Equipe<S extends Sportif> {

    private final List<S> equipiers = new ArrayList<>();
    private final int tailleMax;

    public Equipe(int tailleMax) {
        this.tailleMax = tailleMax;
    }

    /**
     * Ajoute un sportif à notre equipe.
     *
     * @param sportif, le sportif à ajouter
     * @throws IllegalArgumentException quand le sportif est null
     * @throws TeamSizeExceededException quand ajouter le sportif excederait la tailleMax
     * @throws NotEnEquipeException quand la classe du sportif ajouté n'est pas n'annotation {@link EnEquipe}
     * @throws InvalidTailleException quand les tailles d'équipes acceptées par
     *      le sportif via l'annotation {@link EnEquipe} ne correspondent pas à la tailleMax
     * @since 1.0
     */
    public void ajouter(S sportif){
        if( sportif == null )
            throw new IllegalArgumentException("sportif ne devrait pas être null");

        if( equipiers.size() == tailleMax )
            throw new TeamSizeExceededException(tailleMax);

        EnEquipe enEquipe = sportif.getClass().getAnnotation( EnEquipe.class );
        if( enEquipe == null )
            throw new NotEnEquipeException();

        boolean valid = false;
        for (int taille: enEquipe.taille()) {
            if( taille == tailleMax ){
                valid = true;
                break;
            }
        }
        if( !valid )
            throw new InvalidTailleException();

        equipiers.add(sportif);
    }
}
