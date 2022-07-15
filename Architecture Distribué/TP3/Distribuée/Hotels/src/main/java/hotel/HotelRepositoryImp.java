package hotel;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
public class HotelRepositoryImp{// implements HotelRepository {
	
	private ArrayList<hotel> ListHotel ;

	public HotelRepositoryImp() throws IOException{
		String chemin = "src\\main\\java\\Image_chambre\\" ;
		
		ListHotel = new ArrayList<>();
	    ArrayList<chambre> l1 = new ArrayList() {{
	        add(new chambre(0,1,chemin +"chambre1.jpg"));
	        add(new chambre(1,3,chemin +"chambre1.jpg"));
	        add(new chambre(2,2,chemin +"chambre1.jpg"));
	        add(new chambre(3,2,chemin +"chambre1.jpg"));
	        add(new chambre(4,1,chemin +"chambre1.jpg"));
	        add(new chambre(5,1,chemin +"chambre1.jpg"));
	        add(new chambre(6,1,chemin +"chambre1.jpg"));
	        add(new chambre(7,2,chemin +"chambre1.jpg"));
	        add(new chambre(8,3,chemin +"chambre1.jpg"));
	    }};

    	ArrayList<Partenaire> t1 = new ArrayList<>();
    	
    	t1.add(new Partenaire("agence du plaisir",0));
    	t1.add(new Partenaire("agence Renne",5));
    	
    	
    	
		hotel h1 = new hotel(0,"casa des papels","mexique","mexico","rue père forasse","lop",5689,48,54,2,l1,t1);
		ListHotel.add(h1);
	    ArrayList<chambre> l2 = new ArrayList() {{
	        add(new chambre(0,1,chemin +"chambre2.jpg"));
	        add(new chambre(1,3,chemin +"chambre2.jpg"));
	        add(new chambre(2,2,chemin +"chambre2.jpg"));
	        add(new chambre(3,2,chemin +"chambre2.jpg"));
	        add(new chambre(4,1,chemin +"chambre2.jpg"));
	        add(new chambre(5,1,chemin +"chambre2.jpg"));
	        add(new chambre(6,1,chemin +"chambre2.jpg"));
	        add(new chambre(7,2,chemin +"chambre2.jpg"));
	        add(new chambre(8,3,chemin +"chambre2.jpg"));
	    }};
	    

    	ArrayList<Partenaire> t2 = new ArrayList<>();
    	
    	t2.add(new Partenaire("agence du bonheur",1));
    	t2.add(new Partenaire("agence",2));
	     hotel h2 = new hotel(1,"H","france","Paris","rue père forasse","lop",5689,48,54,2,l2,t2);
	     
	     ListHotel.add(h2);
		    ArrayList<chambre> l3 = new ArrayList() {{
		        add(new chambre(0,1,chemin +"chambre3.jpg"));
		        add(new chambre(1,3,chemin +"chambre3.jpg"));
		        add(new chambre(2,2,chemin +"chambre3.jpg"));
		        add(new chambre(3,2,chemin +"chambre3.jpg"));
		        add(new chambre(4,1,chemin +"chambre3.jpg"));
		        add(new chambre(5,1,chemin +"chambre3.jpg"));
		        add(new chambre(6,1,chemin +"chambre3.jpg"));
		        add(new chambre(7,2,chemin +"chambre3.jpg"));
		        add(new chambre(8,3,chemin +"chambre3.jpg"));
		    }};
		    
		    
	    	ArrayList<Partenaire> t3 = new ArrayList<>();
	  
	    	t3.add(new Partenaire("agence du plaisir",0));
	    	t3.add(new Partenaire("agence du bonheur",1));
	    	t3.add(new Partenaire("agence",2));
	    	
	    	t3.add(new Partenaire("agence Paris",3));
	    	t3.add(new Partenaire("agence Marseille",4));
	    	t3.add(new Partenaire("agence Renne",5));	
	    	
	    	
	    	
	     hotel h3 = new hotel(2,"diamant","anglettere","londre","rue père forasse","lop",5689,48,54,2,l3,t3);
	     ListHotel.add(h3);
		    ArrayList<chambre> l4 = new ArrayList() {{
		        add(new chambre(0,1,chemin +"chambre4.jpg"));
		        add(new chambre(1,3,chemin +"chambre4.jpg"));
		        add(new chambre(2,2,chemin +"chambre4.jpg"));
		        add(new chambre(3,2,chemin +"chambre4.jpg"));
		        add(new chambre(4,1,chemin +"chambre4.jpg"));
		        add(new chambre(5,1,chemin +"chambre4.jpg"));
		        add(new chambre(6,1,chemin +"chambre4.jpg"));
		        add(new chambre(7,2,chemin +"chambre4.jpg"));
		        add(new chambre(8,3,chemin +"chambre4.jpg"));
		    }};
		    
	    	ArrayList<Partenaire> t4 = new ArrayList<>();

	    	t4.add(new Partenaire("agence du plaisir",0));
	    	t4.add(new Partenaire("agence du bonheur",1));
	    	t4.add(new Partenaire("agence Renne",5));	
	    	
	     hotel h4 = new hotel(3,"le mistralle","france","Paris","rue père forasse","lop",5689,48,54,2,l4,t4);
	     ListHotel.add(h4);
	     
		    ArrayList<chambre> l5 = new ArrayList() {{
		        add(new chambre(0,1,chemin +"chambre5.jpg"));
		        add(new chambre(1,3,chemin +"chambre5.jpg"));
		        add(new chambre(2,2,chemin +"chambre5.jpg"));
		        add(new chambre(3,2,chemin +"chambre5.jpg"));
		        add(new chambre(4,1,chemin +"chambre5.jpg"));
		        add(new chambre(5,1,chemin +"chambre5.jpg"));
		        add(new chambre(6,1,chemin +"chambre5.jpg"));
		        add(new chambre(7,2,chemin +"chambre5.jpg"));
		        add(new chambre(8,3,chemin +"chambre5.jpg"));
		    }};
		    
	    	ArrayList<Partenaire> t5 = new ArrayList<>();
	
	    	t5.add(new Partenaire("agence du plaisir",0));
	    	t5.add(new Partenaire("agence Marseille",4));
	    	t5.add(new Partenaire("agence Renne",5));	
	    	
	    	
	     hotel h5 = new hotel(4,"le bureau","france","Eyguière","rue père forasse","lop",5689,48,54,2,l5,t5);
	     ListHotel.add(h5);
		
		
		
	}
	
	public void publishedHotel() {
		
        Endpoint.publish("http://localhost:1111/HotelRepository1",
        		ListHotel.get(0));
        System.err.println("Server is ready");
        
        Endpoint.publish("http://localhost:2222/HotelRepository2",
        		ListHotel.get(1));
        System.err.println("Server is ready");
        
        Endpoint.publish("http://localhost:3333/HotelRepository3",
        		ListHotel.get(2));
        System.err.println("Server is ready");
        
        Endpoint.publish("http://localhost:4444/HotelRepository4",
        		ListHotel.get(3));
        System.err.println("Server is ready");
        
        Endpoint.publish("http://localhost:5555/HotelRepository5",
        		ListHotel.get(4));
        System.err.println("Server is ready");
	}


}
