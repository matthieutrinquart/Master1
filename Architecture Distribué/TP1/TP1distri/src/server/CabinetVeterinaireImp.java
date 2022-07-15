package server;

import Client.Notifiable;
import Common.CabinetVeterinaire;
import Common.animal;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

public class CabinetVeterinaireImp extends UnicastRemoteObject implements CabinetVeterinaire{


    private ArrayList<animal> patients;
    private Vector clientList = null;
    public CabinetVeterinaireImp() throws RemoteException {
        super();
        patients = new ArrayList<>();
        clientList = new Vector();
    }

    public void setNewMessage(String mssg)throws RemoteException{
        for(Enumeration clients = clientList.elements(); clients.hasMoreElements();){
            Notifiable thingToNotify = (Notifiable) clients.nextElement();
            thingToNotify.notify(mssg);
        }


    }


    @Override
    public animal get_animal(String nom_patient) throws RemoteException {
        animal R = null;
        for (int i = 0;i < patients.size();++i){
            if (patients.get(i).get_nom_animal().equals(nom_patient))
                R = patients.get(i);
        }

        return R;
    }

    @Override
    public void add_animal(animal patient) throws RemoteException {
        patients.add(patient);
        mssg();
    }

    public void add_veterinaire(Notifiable vt) throws RemoteException {
        clientList.add(vt);
    }


    @Override
    public void new_animal(String nom_animal, String nom_maitre, String nom_espece, String nom_race,int age , String suivi) throws RemoteException {
        add_animal(new animalImp(nom_animal,nom_maitre,nom_espece,nom_race,age,new dossiersuiviImpl(suivi)));
    }

    public void mssg() throws RemoteException {
        if (patients.size() == 100) {
            setNewMessage("On est passé a 100 patients");
        } else if (patients.size() == 500) {
            setNewMessage("On est passé a 500 patients");
        } else if (patients.size() == 1000) {
            setNewMessage("On est passé a 1000 patients");
        }


    }
}
