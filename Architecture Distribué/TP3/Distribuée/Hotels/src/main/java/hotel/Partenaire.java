package hotel;

public class Partenaire {
	
	private String Nom_partenaire;

	
	private int id_partenaire;
	
	
	public Partenaire(String nom_partenaire, int id_part) {
		Nom_partenaire = nom_partenaire;
		this.id_partenaire = id_part;
	}
	public String getNom_partenaire() {
		return Nom_partenaire;
	}
	public void setNom_partenaire(String nom_partenaire) {
		Nom_partenaire = nom_partenaire;
	}
	public int getId_partenaire() {
		return id_partenaire;
	}
	public void setId_partenaire(int id_part) {
		this.id_partenaire = id_part;
	}
	
	
	
	
	
	
	
	

}
