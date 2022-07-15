package hotel;


import java.io.IOException;

import javax.xml.ws.Endpoint;

public class Main {

    public static void main(String[] args) throws IOException {
        

    	HotelRepositoryImp h = new HotelRepositoryImp();
    	
    	h.publishedHotel();

    }

}
