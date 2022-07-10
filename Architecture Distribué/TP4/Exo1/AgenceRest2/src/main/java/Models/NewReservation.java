package Models;

public class NewReservation {
	private Reservation res;
	private Chambre ch;
	
	
	public NewReservation() {
		
	}
	
	public NewReservation( Reservation res ,Chambre ch ) {
		this.res = res;
		this.ch = ch;
		
	}

	public Reservation getRes() {
		return res;
	}

	public void setRes(Reservation res) {
		this.res = res;
	}

	public Chambre getCh() {
		return ch;
	}

	public void setCh(Chambre ch) {
		this.ch = ch;
	}
	
	
	

}
