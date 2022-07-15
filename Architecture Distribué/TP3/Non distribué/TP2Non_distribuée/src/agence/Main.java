package agence;

import Hotel.chambre;
import Hotel.hotel;
import client.Date;
import client.client;
import client.reservation;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {





        ArrayList<chambre> l1 = new ArrayList<>();
        l1.add(new chambre(0,1));
        l1.add(new chambre(1,3));
        l1.add(new chambre(2,2));
        l1.add(new chambre(3,2));
        l1.add(new chambre(4,1));
        l1.add(new chambre(5,1));
        l1.add(new chambre(6,1));
        l1.add(new chambre(7,2));
        l1.add(new chambre(8,3));

        ArrayList<chambre> l2 = new ArrayList<>();
        l2.add(new chambre(0,1));
        l2.add(new chambre(1,3));
        l2.add(new chambre(2,2));
        l2.add(new chambre(3,2));
        l2.add(new chambre(4,1));
        l2.add(new chambre(5,1));
        l2.add(new chambre(6,1));
        l2.add(new chambre(7,2));
        l2.add(new chambre(8,3));


        ArrayList<chambre> l3 = new ArrayList<>();
        l3.add(new chambre(0,1));
        l3.add(new chambre(1,3));
        l3.add(new chambre(2,2));
        l3.add(new chambre(3,2));
        l3.add(new chambre(4,1));
        l3.add(new chambre(5,1));
        l3.add(new chambre(6,1));
        l3.add(new chambre(7,2));
        l3.add(new chambre(8,3));


        ArrayList<chambre> l4 = new ArrayList<>();
        l4.add(new chambre(0,1));
        l4.add(new chambre(1,3));
        l4.add(new chambre(2,2));
        l4.add(new chambre(3,2));
        l4.add(new chambre(4,1));
        l4.add(new chambre(5,1));
        l4.add(new chambre(6,1));
        l4.add(new chambre(7,2));
        l4.add(new chambre(8,3));


        ArrayList<chambre> l5 = new ArrayList<>();
        l5.add(new chambre(0,1));
        l5.add(new chambre(1,3));
        l5.add(new chambre(2,2));
        l5.add(new chambre(3,2));
        l5.add(new chambre(4,1));
        l5.add(new chambre(5,1));
        l5.add(new chambre(6,1));
        l5.add(new chambre(7,2));
        l5.add(new chambre(8,3));

        ArrayList<chambre> l6 = new ArrayList<>();
        l6.add(new chambre(0,1));
        l6.add(new chambre(1,3));
        l6.add(new chambre(2,2));
        l6.add(new chambre(3,2));
        l6.add(new chambre(4,1));
        l6.add(new chambre(5,1));
        l6.add(new chambre(6,1));
        l6.add(new chambre(7,2));
        l6.add(new chambre(8,3));



        ArrayList<chambre> l7 = new ArrayList<>();
        l7.add(new chambre(0,1));
        l7.add(new chambre(1,3));
        l7.add(new chambre(2,2));
        l7.add(new chambre(3,2));
        l7.add(new chambre(4,1));
        l7.add(new chambre(5,1));
        l7.add(new chambre(6,1));
        l7.add(new chambre(7,2));
        l7.add(new chambre(8,3));

        Agence agence = new Agence();



        hotel h1 = new hotel(0,"casa des papels","mexique","mexico","rue père forasse","lop",5689,48,54,2,l1);
        hotel h2 =new hotel(1,"H","france","Paris","rue père forasse","lop",5689,48,54,2,l2);
        hotel h3 =new hotel(2,"diamant","anglettere","londre","rue père forasse","lop",5689,48,54,2,l3);
        hotel h4 =new hotel(3,"robesse pierre","anglettere","londre","rue père forasse","lop",5689,48,54,2,l4);
        hotel h5 =new hotel(4,"castelasse","france","Eyguière","rue père forasse","lop",5689,48,54,2,l5);
        hotel h6 =new hotel(5,"le bureau","france","Eyguière","rue père forasse","lop",5689,48,54,2,l6);
        hotel h7 =   new hotel(6,"le mistralle","france","Paris","rue père forasse","lop",5689,48,54,2,l7);
        agence.add_hotel(h1);
        agence.add_hotel(h2);
        agence.add_hotel(h3);
        agence.add_hotel(h4);
        agence.add_hotel(h5);
        agence.add_hotel(h6);
        agence.add_hotel(h7);
        int choix ;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("\n0. Quitté");
            System.out.println("1. Chercher des offres");
            System.out.println("2. Reserver");
            System.out.println("3. afficher tous les hotels");
             choix = sc.nextInt();
            switch (choix){

                case 1:
                    System.out.println("Quelle ville ?");
                    sc.nextLine();
                    String ville = sc.nextLine();

                    System.out.println("Date de d'arrivée ? jour ");
                    int jour1 = sc.nextInt();
                    System.out.println("Date de d'arrivée ? mois ");
                    int mois1 = sc.nextInt();
                    System.out.println("Date de d'arrivée ? annee");
                    int annee1 = sc.nextInt();
                    Date date1 = new Date(jour1,mois1,annee1);


                    System.out.println("Date de depart ? jour ");
                    int jour2 = sc.nextInt();
                    System.out.println("Date de depart ? mois ");
                    int mois2 = sc.nextInt();
                    System.out.println("Date de depart ? annee");
                    int annee2 = sc.nextInt();
                    Date date2 = new Date(jour2,mois2,annee2);

                    System.out.println("Prix min ?");
                    int prixMin = sc.nextInt();

                    System.out.println("Prix max ? ");
                    int prixMax = sc.nextInt();

                    System.out.println("Catégorie ");
                    int etoiles = sc.nextInt();

                    System.out.println("Nombre lits ? ");
                    int lits = sc.nextInt();

                    System.out.println("Vous cherchez : ");
                    System.out.println(ville + " - " + date1 + " / " + date2);
                    System.out.println(prixMin + " - " + prixMax + "euros  " + etoiles + "* " + lits + "lits.");
                    ArrayList<Pair> response = agence.lookup(ville, date1, date2, prixMin, prixMax, etoiles, lits);
                    System.out.println(response.size());
                    for(int i = 0; i <response.size() ; ++i){
                        System.out.println("numero " + i +" : " + response.get(i).h);
                        for (chambre cha : response.get(i).ch){
                            System.out.println("    "+ cha);
                        }
                    }



                    break;



                case 2:
                    System.out.println("Date de d'arrivée ? jour ");
                    int jourar = sc.nextInt();
                    System.out.println("Date de d'arrivée ? mois ");
                    int moisarr = sc.nextInt();
                    System.out.println("Date de d'arrivée ? annee");
                    int anneear = sc.nextInt();
                    Date date_arrivee = new Date(jourar,moisarr,anneear);


                    System.out.println("Date de depart ? jour ");
                    int jourdepart = sc.nextInt();
                    System.out.println("Date de depart ? mois ");
                    int moisdepart = sc.nextInt();
                    System.out.println("Date de depart ? annee");
                    int anneedepart = sc.nextInt();
                    Date date_depart = new Date(jourdepart,moisdepart,anneedepart);

                    System.out.println("Dans quel hotel reserver (numero) ?");
                    int idhotel = sc.nextInt();
                    System.out.println("Dans quel chambre reserver (numero)?");
                    int idCham = sc.nextInt();

                    System.out.println("Nom du client?");
                    sc.nextLine();
                    String nom = sc.nextLine();

                    System.out.println("prenom du client?");
                    String Prenom = sc.nextLine();

                    System.out.println("Info carte crédit?");
                    int carte = sc.nextInt();

                    client c = new client(nom, Prenom, carte);
                    reservation r = new reservation(date_arrivee, date_depart, c);

                    if(agence.getH().get(idhotel).reservation(r,idCham)){
                        System.out.println("C'est réservé.");
                        System.out.println(agence.getH().get(idhotel).getList_chambre().get(idCham).getList_res());
                    }
                    else{
                        System.out.println("Problème dans la reservation");
                    }



                    break;
                case 3:
                    for(hotel h : agence.getH()){
                        System.out.println("Nom de l'hotel " + h.getNom());
                        System.out.println("id de l'hotel " + h.getId());
                        System.out.println("Prix de l'hotel " + h.getPrix());
                        System.out.println("Nombre d'étoiles " + h.getNombre_etoile());

                        for (chambre e:h.getList_chambre()) {
                            System.out.println("    numero chambre " + e.getNumero());
                            System.out.println("    Nombre de lit " + e.getNb_lit());
                            for (reservation s:e.getList_res()) {
                                System.out.println("          client : " + s.getC().getPrenom() + " " + s.getC().getNom());
                                System.out.println("          reservé du " + s.getDate_arrivee() + " au " + s.getDate_depart());

                            }

                        }
                        System.out.println("\n");

                    }
                    break;

                case 0:
                    System.out.println("Bye...");
                    return;

                default:
                    System.err.println("Sorry, wrong input. Please try again.");
                    return;


            }




            Thread.sleep(3000);
        } while(choix != 0);

        sc.close();

    }
}
