package agence;




import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import proxy.*;

public class Agence {
	
	private String Nom_agence;
	
	private int id_agence;
	
	private String login;
	
	private String mdp;
	
	private float reduction;

    private ArrayList<Ihotel> h;
    
    
   //private ArrayList<HotelRepository> hotelPartenaire;

    public Agence(String Nom_agence, int id_agence , float reduction , String login , String mdp)  {
    	
    	this.Nom_agence = Nom_agence;
    	
    	this.id_agence = id_agence;
    	
    	this.login = login;
    	this.mdp = mdp;
    	
    	
    	this.reduction = reduction;
    	this.h = new ArrayList<>();
    	
    	
        
        
    }
    
    

    public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getMdp() {
		return mdp;
	}



	public void setMdp(String mdp) {
		this.mdp = mdp;
	}



	public String getNom_agence() {
		return Nom_agence;
	}
    

	public ArrayList<Ihotel> getH() {
		return h;
	}
	
	

	public float getReduction() {
		return reduction;
	}



	public void setReduction(float reduction) {
		this.reduction = reduction;
	}



	public void setH(ArrayList<Ihotel> h) {
		this.h = h;
	}

	public void setNom_agence(String nom_agence) {
		Nom_agence = nom_agence;
	}

	public void add_hotel(String a){
    	
    	URL url = null;
    	try {
         url = new URL(a);
    	} catch (MalformedURLException e) {
    	}
        HotelService serviceImp = new HotelService(url);

        Ihotel proxy = serviceImp.getHotelPort();
 

        h.add(proxy);
        

        
    }
    public ArrayList<Disponibiliter> date_disponible(Chambre c) throws ParseException {
    	List<Reservation> test = c.getListRes();
        ArrayList<Disponibiliter> r = new ArrayList<>();
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
       	Date date_min= format1.parse("01/01/0000");
       	Date date_max= format1.parse("31/12/9999");
        if(!c.getListRes().isEmpty()) {
        for(int i = 0 ; i < test.size() -2 ;++i) {
        	
        	int min =i;
        	for(int j = i+1 ; j < test.size() -1 ;++j) {
        		if(test.get(j).getDateArrivee().toGregorianCalendar().compareTo(test.get(min).getDateArrivee().toGregorianCalendar()) <0) {
        			
        			min = j;
        		}
        	}
        	if(min != i) {
        		Reservation s = test.get(i);
        		test.set(i,  test.get(min)) ;
        		test.set(min,  s) ;    		
        	}	

    	}


        

	        Date dated = test.get(0).getDateArrivee().toGregorianCalendar().getTime();
	        Calendar f = Calendar.getInstance();
	        f.setTime(dated);
	        f.add(Calendar.DATE, -1);
	        dated.setTime( f.getTime().getTime() );
	        Disponibiliter d = new Disponibiliter(date_min ,dated);
	        r.add(d);
	        for(int i = 1 ; i < test.size() ; ++i) {
	            
	            Date date1 = test.get(i-1).getDateDepart().toGregorianCalendar().getTime();
	            Calendar f1 = Calendar.getInstance();
	            f1.setTime(date1);
	            f1.add(Calendar.DATE, 1);
	            date1.setTime( f1.getTime().getTime() );
	            
	            
	           
	            
	            Date date2 = test.get(i).getDateArrivee().toGregorianCalendar().getTime();
	            Calendar f2 = Calendar.getInstance();
	            f2.setTime(date2);
	           // f2.add(Calendar.DATE, -1);
	            date2.setTime( f2.getTime().getTime() );  
	            
	            //System.out.println(date1 + "     " + date2);
	            
	            r.add(new Disponibiliter(date1 ,date2));	
	        }
	        
	        Date datefin = test.get(test.size()-1).getDateDepart().toGregorianCalendar().getTime();
	        Calendar f1 = Calendar.getInstance();
	        f1.setTime(datefin);
	        f1.add(Calendar.DATE, 1);
	        datefin.setTime( f1.getTime().getTime() );
	    	
	        
	        r.add(new Disponibiliter(datefin ,date_max));	
        }
        else {
        
            r.add(new Disponibiliter(date_min ,date_max));	
        }
        
        return r;
        
       
    	
    	
    	
    }

    public int getId_agence() {
		return id_agence;
	}



	public void setId_agence(int id_agence) {
		this.id_agence = id_agence;
	}



	public ArrayList<Offre> lookup(Date date_arrivee , Date date_depart, int nb_personne) throws ParseException{
        ArrayList<Offre> ret = new ArrayList<>();

        for(Ihotel c : this.h){
            	GregorianCalendar gc1 = new GregorianCalendar();
            	gc1.setTime(date_arrivee);
            	//System.out.println(c.getNom());
            	
            	GregorianCalendar gc2 = new GregorianCalendar();
            	gc2.setTime(date_depart);
            	XMLGregorianCalendar xmlDate1 = null;
            	XMLGregorianCalendar xmlDate2 = null;
            	
            	 try {
                     xmlDate1 = DatatypeFactory.newInstance()
                                   .newXMLGregorianCalendar(gc1);
                     xmlDate2 = DatatypeFactory.newInstance()
                             .newXMLGregorianCalendar(gc2);
                 }
                 catch (Exception e) {
                     e.printStackTrace();
                     
                 }			
                List<Chambre> lc =  c.canResChambre(xmlDate1, xmlDate2);
                ArrayList<Chambre> lc2 =  new ArrayList<>();
                for (Chambre ch : lc) {
                    if (nb_personne == ch.getNbLit()) {
                    	//System.out.println(ch.getNumero());
                        lc2.add(ch);
                        ret.add(new Offre(c.getid(),c.getNom(),ch.getNumero(),ch.getNbLit(),date_disponible(ch),(float) (c.getPrix(this.id_agence,this.reduction)),ch.getPicBytes()));
                    }
                }
            }


        return ret;





    }
    
    

    public boolean Reserver(Date date_arrivee , Date date_depart, int nb_personne , int id_hotel , int numero_chambre,String nom,String prenom,int infocarte){
      	GregorianCalendar gc1 = new GregorianCalendar();
    	gc1.setTime(date_arrivee);
    	//System.out.println(c.getNom());
    	
    	GregorianCalendar gc2 = new GregorianCalendar();
    	gc2.setTime(date_depart);
    	XMLGregorianCalendar xmlDate1 = null;
    	XMLGregorianCalendar xmlDate2 = null;
    	
    	
    	 try {
             xmlDate1 = DatatypeFactory.newInstance()
                           .newXMLGregorianCalendar(gc1);
             xmlDate2 = DatatypeFactory.newInstance()
                     .newXMLGregorianCalendar(gc2);
         }
         catch (Exception e) {
             e.printStackTrace();
         }
    	 
    	return h.get(id_hotel).reserver(xmlDate1, xmlDate2, nb_personne, numero_chambre ,nom,prenom,infocarte);

    	
   
    	
    }


}
