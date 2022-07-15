package agence;

import Hotel.chambre;
import Hotel.hotel;
import client.Date;

import java.util.ArrayList;
class Pair{

    public hotel h;
    public ArrayList<chambre> ch = new ArrayList<>();

    public Pair(hotel h, ArrayList<chambre> ch) {
        this.h = h;
        this.ch = ch;
    }
}

public class Agence {

    private ArrayList<hotel> h;

    public Agence() {
        h = new ArrayList<>();
    }

    public void add_hotel(hotel a){

        h.add(a);
    }

    public ArrayList<Pair> lookup(String ville , Date date_arrivee , Date date_depart, int prix1, int prix2 , int nb_etoile , int nb_personne){
        ArrayList<Pair> ret = new ArrayList<>();

        for(hotel c : this.h){
         //   System.out.println(c.getNom());
            if((prix1 <= c.getPrix() && c.getPrix() <=prix2) && c.getNombre_etoile() == nb_etoile && c.getAddr().getVille().equals(ville)) {
                ArrayList<chambre> lc = new ArrayList<>();
                for (chambre ch : c.getList_chambre()) {
                    if (ch.can_res(date_arrivee, date_depart) && nb_personne == ch.getNb_lit()) {
                        lc.add(ch);
                    }
                }
                ret.add(new Pair(c,lc));
            }


        }

        return ret;





    }

    public ArrayList<hotel> getH() {
        return h;
    }
}
