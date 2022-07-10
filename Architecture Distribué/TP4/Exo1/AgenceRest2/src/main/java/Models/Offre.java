package Models;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Offre{

    private int id_offre;
    private int numero_chambre;
    private String nom;
    private int nb_lits;
    private ArrayList<Disponibiliter> disponible;
    private float prix;
    private byte[] pic_bytes;

    public Offre() {

	}
    public Offre(int id_offre,String nom,int numero_chambre, int nb_lits, ArrayList<Disponibiliter> disponible , float prix , byte[] pic_bytes){//,byte[] pic_bytes) {
		this.nom = nom;
		this.id_offre = id_offre;
		this.numero_chambre = numero_chambre;
		this.nb_lits = nb_lits;
		this.disponible = disponible;
		this.prix = prix;
		this.pic_bytes = pic_bytes;
	}
	public void EcrireImage() throws IOException {
		
	      ByteArrayInputStream bis = new ByteArrayInputStream(this.pic_bytes);
	      BufferedImage bImage2 = ImageIO.read(bis);
	      String chemin = "src/main/java/Image_chambre/";
	      String fc = this.nom  + " "+this.numero_chambre+".jpg";
	      ImageIO.write(bImage2, "jpg", new File(chemin+fc) );
	      System.out.println("image created");
	     
		
	}
	public int getId_offre() {
		return id_offre;
	}
	public void setId_offre(int id_offre) {
		this.id_offre = id_offre;
	}
	public int getNumero_chambre() {
		return numero_chambre;
	}
	public void setNumero_chambre(int numero_chambre) {
		this.numero_chambre = numero_chambre;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNb_lits() {
		return nb_lits;
	}
	public void setNb_lits(int nb_lits) {
		this.nb_lits = nb_lits;
	}
	public ArrayList<Disponibiliter> getDisponible() {
		return disponible;
	}
	public void setDisponible(ArrayList<Disponibiliter> disponible) {
		this.disponible = disponible;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	public byte[] getPic_bytes() {
		return pic_bytes;
	}
	public void setPic_bytes(byte[] pic_bytes) {
		this.pic_bytes = pic_bytes;
	}
	
	
	
	
	
}
