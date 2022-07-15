package hotel;


import java.util.Date;

public class reservation {
	private client c;
    private Date date_arrivee;
    private Date date_depart;


    public reservation(Date date_arrivee, Date date_depart,client c  ) {
        this.date_arrivee = date_arrivee;
        this.date_depart = date_depart;
        this.c = c;
    }


    public Date getDate_arrivee() {
        return date_arrivee;
    }

    public void setDate_arrivee(Date date_arrivee) {
        this.date_arrivee = date_arrivee;
    }

    public Date getDate_depart() {
        return date_depart;
    }

    public void setDate_depart(Date date_depart) {
        this.date_depart = date_depart;
    }


    @Override
    public String toString() {
        return "reservation{" +
                "date_arrivee=" + date_arrivee +
                ", date_depart=" + date_depart +
                '}';
    }
}
