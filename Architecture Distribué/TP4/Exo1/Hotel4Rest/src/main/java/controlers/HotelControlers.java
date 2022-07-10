package controlers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Exception.HotelsNotFoundException;
import models.Chambre;
import models.Client;
import models.Disponibiliter;
//import Exception.HotelsNotFoundException;
import models.Hotel;
import models.Offre;
import models.Partenaire;
import models.Reservation;
import models.NewReservation;
import repositories.ChambreRepository;
import repositories.ClientRepository;
import repositories.HotelRepository;
import repositories.PartenaireRepository;
import repositories.ReservationRepository;
@RestController
public class HotelControlers {
	@Autowired
	private HotelRepository repository;
	
	@Autowired
	public ChambreRepository chambreRepository;
	
	@Autowired
	public PartenaireRepository partenaireRepository;
	
	@Autowired
	public ReservationRepository reservationRepository;
	
	@Autowired
	public ClientRepository clientRepository;
	
	private static final String uri = "hotelservice/api";
	

	
	@GetMapping(uri + "/hotel/Lookup/from={date},to={date1},beds={lits},partenaire={id_partenaire},reduction={pourcentage_reduc}")
	public Offre[] Lookup(@PathVariable String date, @PathVariable String date1, @PathVariable int lits, @PathVariable int id_partenaire, @PathVariable float pourcentage_reduc) throws ParseException, IOException  {
		
		System.out.println(date);
		System.out.println(date1);
		System.out.println(lits);
		System.out.println(id_partenaire);
		System.out.println(pourcentage_reduc);
		
			List<Offre> of = new ArrayList<>() ;
		
		Optional<Hotel> c	= repository.findById((long) 3);
        ArrayList<Offre> ret = new ArrayList<>();

        Date y = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        Date z = new SimpleDateFormat("dd-MM-yyyy").parse(date1);

				System.out.println(y);
				System.out.println(z);
        
				ArrayList<Chambre> lc =  c.get().can_res_chambre(y, z);
                ArrayList<Chambre> lc2 =  new ArrayList<>();
                for (Chambre ch : lc) {
                    if (lits == ch.getNb_lit()) {
                    	//System.out.println(ch.getNumero());
                        lc2.add(ch);
                         of.add(new Offre((int)c.get().getId_hotel(),c.get().getNom(),(int)ch.getNumero(),ch.getNb_lit(),c.get().date_disponible(ch),(float) (c.get().getPrix(id_partenaire,pourcentage_reduc)),ch.getImage()));
                    }
                }
            

                Offre[] retour =of.toArray(new Offre[0]);
        return retour;

		
		//return repository.findById(id).orElseThrow(() -> new HotelsNotFoundException("hotel " + id + " n'existe pas"));
	}
	

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(uri + "/hotel/Reservation")
	public NewReservation NewReservation(@RequestBody NewReservation res) throws HotelsNotFoundException {
		
		Client c = new Client(res.getRes().getClient().getNom(),res.getRes().getClient().getPrenom(),res.getRes().getClient().getInfo_carte_credit());

		List<Chambre> Lch = chambreRepository.findAll();
		Chambre c1 = null; ;
		long id_chambre;
		for(Chambre ch :Lch ) {
			if(ch.getNumero() == res.getCh().getNumero()) {
				id_chambre = ch.getId_chambre();
				c1 = ch;
				
			}
		}
		Client r = clientRepository.save(c);
		
		if(c1.can_res(res.getRes().getDate_arrivee(), res.getRes().getDate_depart())) {
		Reservation t=reservationRepository.save(new Reservation(res.getRes().getDate_arrivee(),res.getRes().getDate_depart(),r,c1));
		NewReservation retour = new NewReservation(t ,t.getChambre());
		return retour;
		}
		else {
			return null;
		}
		
		
		
	}
	
	
	

	 

}
