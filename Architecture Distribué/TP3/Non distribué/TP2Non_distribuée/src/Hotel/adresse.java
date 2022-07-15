package Hotel;

public class adresse {

    private String pays, ville, rue, lieu_dit;

    private int numero, positionGPS;

    public adresse(String pays, String ville, String rue, String lieu_dit, int numero, int positionGPS) {
        this.pays = pays;
        this.ville = ville;
        this.rue = rue;
        this.lieu_dit = lieu_dit;
        this.numero = numero;
        this.positionGPS = positionGPS;
    }



    public String getVille() {
        return ville;
    }

    @Override
    public String toString() {
        return "adresse{" +
                "pays='" + pays + '\'' +
                ", ville='" + ville + '\'' +
                ", rue='" + rue + '\'' +
                ", lieu_dit='" + lieu_dit + '\'' +
                ", numero=" + numero +
                ", positionGPS=" + positionGPS +
                '}';
    }
}
