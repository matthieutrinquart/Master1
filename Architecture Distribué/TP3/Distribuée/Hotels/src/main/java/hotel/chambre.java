package hotel;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.imageio.ImageIO;

public class chambre {

    private int numero;
    private int nb_lit;
    private ArrayList<reservation> list_res;
    private byte[] pic_bytes;


    public chambre(int numero, int nb_lit , String image) throws IOException {
        this.numero = numero;
        this.nb_lit = nb_lit;

        
        
        list_res = new ArrayList<>();
        
        File fichier = new File (image);
        
        BufferedImage bi = ImageIO.read (fichier);
        
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(bi, "jpg", bos );
        this.pic_bytes = bos.toByteArray();

    }
    public boolean can_res(Date a , Date b ){
        boolean tamp = true;

        for (reservation r : list_res){
            if(((a.before(r.getDate_depart())) ) && a.after(r.getDate_arrivee()) || (b.before(r.getDate_depart())  && b.after(r.getDate_arrivee())) || ((r.getDate_depart().after(a) ) && r.getDate_depart().before(b)) || (r.getDate_arrivee().after(a)  && r.getDate_arrivee().before(b))
            		|| r.getDate_arrivee().equals(a) ||  r.getDate_arrivee().equals(b) || r.getDate_depart().equals(a)|| r.getDate_depart().equals(b)){

                tamp = false;
            }
        }
        return tamp;

    }

    public int getNumero() {
        return numero;
    }

    
    
    
    public byte[] getPic_bytes() {
		return pic_bytes;
	}
	public void setPic_bytes(byte[] pic_bytes) {
		this.pic_bytes = pic_bytes;
	}
	public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNb_lit() {
        return nb_lit;
    }

    public void setNb_lit(int nb_lit) {
        this.nb_lit = nb_lit;
    }

    public ArrayList<reservation> getList_res() {
        return list_res;
    }

    public void setList_res(ArrayList<reservation> list_res) {
        this.list_res = list_res;
    }

    public void new_reservation(reservation r) {
        this.list_res.add(r);
    }

    @Override
    public String toString() {
        return "chambre{" +
                "numero=" + numero +
                ", nb_lit=" + nb_lit +
                '}';
    }
}
