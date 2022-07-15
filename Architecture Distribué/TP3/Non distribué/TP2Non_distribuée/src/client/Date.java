package client;

import java.util.Objects;

public class Date {

    private int jour;
    private int mois;
    private int annee;

    public Date(int jour, int mois, int annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }
    public int getJour() {
        return jour;
    }

    public int getMois() {
        return mois;
    }

    public int getAnnee() {
        return annee;
    }


public boolean strictinferieur(Date d){
        if(d.getAnnee() > annee){
            return true;
        }
        else if(d.getAnnee() == annee){

            if(d.getMois() > mois){
                return true;
            }
            else if(d.getMois() == mois){
                if(d.getJour() > jour){
                    return true;
                }
                else if(d.getJour() == jour){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }


}



    public boolean strictsup(Date d){
        if(d.getAnnee() < annee){
            return true;
        }
        else if(d.getAnnee() == annee){

            if(d.getMois() < mois){
                return true;
            }
            else if(d.getMois() == mois){
                if(d.getJour() < jour){
                    return true;
                }
                else if(d.getJour() == jour){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }


    }

    @Override
    public String toString() {
        String s = jour +"/" + mois + "/" + annee;
        return s ;
    }
}
