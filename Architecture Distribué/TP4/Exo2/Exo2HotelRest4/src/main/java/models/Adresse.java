package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Adresse {
	
	
	@Id
	@GeneratedValue
	private long id_adresse;
	@Column(name = "PAYS")
	private String pays;
	@Column(name = "VILLE")
	private String ville;
	@Column(name = "RUE")
	private String rue;
	@Column(name = "LIEU_DIT")
	private String lieu_dit;
	@Column(name = "NUMERO")
    private int numero;
	
    public Adresse() {
    }

    public Adresse(String pays, String ville, String rue, String lieu_dit, int numero) {
        this.pays = pays;
        this.ville = ville;
        this.rue = rue;
        this.lieu_dit = lieu_dit;
        this.numero = numero;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getLieu_dit() {
        return lieu_dit;
    }

    public void setLieu_dit(String lieu_dit) {
        this.lieu_dit = lieu_dit;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    

}
