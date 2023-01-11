package be.bstorm.akimts.test;

public class Personne {

    // a tester:
    // - constructeur :
    //      - bon age, bon nom
    //      - mauvais age, bon nom
    //      - bon age, mauvais nom
    // - set nom :
    //      - bon nom
    //      - mauvais nom
    // - vieillir :
    //      - verifier si l'age augmente

    private String nom;
    private int age;

    public Personne(String nom, int age) {
        if(nom == null)
            throw new IllegalArgumentException("nom ne devrait pas être null");

        this.nom = nom;
        this.setAge(age);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if( nom != null )
            this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        if( age > 0 )
            this.age = age;
    }

    public void vieillir(){
        age++;
    }
}
