package models;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;



public class Offre{
	   private String nom;
	   private int num_chambre;
	   private int nb_etoile;
	    private Adresse adr;
	    private int nb_lits;
	    private float prix;
	    private byte[] pic_bytes;

	    public Offre() {

		}
	    public Offre(int id_offre,String nom,int numero_chambre, int nb_lits, float prix,int nb_etoile , int num_chambre, Adresse adr){//,byte[] pic_bytes) {
			this.nom = nom;
			this.nb_lits = nb_lits;
			this.prix = prix;
			this.adr = adr;
			this.nb_etoile = nb_etoile;
			this.num_chambre = num_chambre;
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
		public Adresse getAdr() {
			return adr;
		}
		public void setAdr(Adresse adr) {
			this.adr = adr;
		}
		public int getNb_etoile() {
			return nb_etoile;
		}
		public void setNb_etoile(int nb_etoile) {
			this.nb_etoile = nb_etoile;
		}
		public int getNum_chambre() {
			return num_chambre;
		}
		public void setNum_chambre(int num_chambre) {
			this.num_chambre = num_chambre;
		}
		

	
	
	
	
	
}
