package be.bstorm.akimts.test;

/**
 * Définit un niveau de connerie.
 * Utilisé dans le cadre de l'annotation {@link Con}.
 * @author A.Kimtsaris
 * @see Con
 */
@Con(NiveauConnerie.DEBILE)
public enum NiveauConnerie {

    BETE,
    ABRUTI,
    DEBILE

}
