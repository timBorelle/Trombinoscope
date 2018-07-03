package timothee.trombinoscope.dto;

public class Person {

    private String prenom, nom;
    private int avatarColor;

    public Person(String prenom, String nom, int avatarColor) {
        this.prenom = prenom;
        this.nom = nom;
        this.avatarColor = avatarColor;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAvatarColor() {
        return avatarColor;
    }

    public void setAvatarColor(int avatarColor) {
        this.avatarColor = avatarColor;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + prenom + '\'' +
                ", lastName='" + nom + '\'' +
                ", avatarColor='" + avatarColor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (avatarColor != person.avatarColor) return false;
        if (prenom != null ? !prenom.equals(person.prenom) : person.prenom != null)
            return false;
        return nom != null ? nom.equals(person.nom) : person.nom == null;

    }

    @Override
    public int hashCode() {
        int result = prenom != null ? prenom.hashCode() : 0;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + avatarColor;
        return result;
    }
}
