package Common;


import Client.Notifiable;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CabinetVeterinaire extends Remote {

    animal get_animal(String nom_patient)throws RemoteException;
    void add_animal(animal patient)throws RemoteException;
    void add_veterinaire(Notifiable vt) throws RemoteException;
    void new_animal(String nom_animal ,String nom_maitre , String nom_espece,String nom_race , int age,String suivi) throws RemoteException;
}
