package client;

public class client {

    private String nom;
    private String prenom;
    private int info_carte_credit;


    public client(String nom, String prenom, int info_carte_credit) {
        this.nom = nom;
        this.prenom = prenom;
        this.info_carte_credit = info_carte_credit;
    }

    public String getNom() {
        return nom;
    }


    public String getPrenom() {
        return prenom;
    }



    public int getInfo_carte_credit() {
        return info_carte_credit;
    }



    @Override
    public String toString() {
        return "client{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", info_carte_credit=" + info_carte_credit +
                '}';
    }
}
