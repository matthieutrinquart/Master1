package hotel;

import java.util.ArrayList;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import hotel.*;
@WebService
public interface Ihotel {
	

    @WebMethod
    int getid();

    @WebMethod
    String getNom();
    @WebMethod
    void setNom(String nom);
    @WebMethod
    adresse getAddr();
    @WebMethod
    float getPrix(int id_agence , float reduction);
    @WebMethod
    int getNombre_etoile();
    @WebMethod
    int getNombre_lit();
    @WebMethod
    void setAddr(adresse addr);
    @WebMethod
    void setPrix(int prix);
    @WebMethod
    void setNombre_etoile(int nombre_etoile);
    @WebMethod
    void setNombre_lit(int nombre_lit);
    @WebMethod
    ArrayList<chambre> getList_chambre();
    @WebMethod
    void setList_chambre(ArrayList<chambre> list_chambre);
    @WebMethod
    boolean Reserver(Date a , Date b , int nombre_personne, int numero_chambre , String nom , String prenom,int infocarte);

    @WebMethod
    ArrayList<chambre> can_res_chambre(Date a, Date b);

    @WebMethod
    String toString() ;

}
