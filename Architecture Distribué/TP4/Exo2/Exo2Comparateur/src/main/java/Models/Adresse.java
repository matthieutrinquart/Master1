package Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Adresse {
	
	
	private String pays;
	private String ville;
	private String rue;
	private String lieu_dit;
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
