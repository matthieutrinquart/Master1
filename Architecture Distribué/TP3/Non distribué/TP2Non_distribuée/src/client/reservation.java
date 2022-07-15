package client;

import Hotel.chambre;
import Hotel.hotel;

public class reservation {
    private Date date_arrivee;
    private Date date_depart;
    private client c;


    public reservation(Date date_arrivee, Date date_depart , client c ) {
        this.date_arrivee = date_arrivee;
        this.date_depart = date_depart;
        this.c = c;
    }


    public Date getDate_arrivee() {
        return date_arrivee;
    }
    

    public Date getDate_depart() {
        return date_depart;
    }


    public client getC() {
        return c;
    }


    @Override
    public String toString() {
        return "reservation{" +
                "date_arrivee=" + date_arrivee +
                ", date_depart=" + date_depart +
                ", c=" + c +
                '}';
    }
}
