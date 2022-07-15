package Hotel;

import client.Date;
import client.reservation;

import java.util.ArrayList;

public class chambre {

    private int numero;
    private int nb_lit;
    private ArrayList<reservation> list_res;


    public chambre(int numero, int nb_lit) {
        this.numero = numero;
        this.nb_lit = nb_lit;

        list_res = new ArrayList<>();

    }
    public boolean can_res(Date a , Date b ){
        boolean tamp = true;

        for (reservation r : list_res){
            if(((a.strictinferieur(r.getDate_depart()) ) && a.strictsup(r.getDate_arrivee())) || (b.strictinferieur(r.getDate_depart())  && b.strictsup(r.getDate_arrivee())) || ((r.getDate_depart().strictsup(a) ) && r.getDate_depart().strictinferieur(b)) || (r.getDate_arrivee().strictsup(a)  && r.getDate_arrivee().strictinferieur(b))){

                tamp = false;
            }
        }
        return tamp;

    }

    public int getNumero() {
        return numero;
    }


    public int getNb_lit() {
        return nb_lit;
    }


    public ArrayList<reservation> getList_res() {
        return list_res;
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
