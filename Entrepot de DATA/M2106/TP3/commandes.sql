/* TP3 - BDD - Vues */

/*Q1*/
/*A*/
CREATE VIEW view_location (numcl, nom_cl,duree_loc,nbper,date_loc,numgite,nomgite)
AS (SELECT C.numcli, nomcli, duree, nbpers, date_debut, G.numgite, nomgite
    FROM clients C JOIN louer L ON C.numcli=L.numcli 
        JOIN gites G ON G.numgite=L.numgite);

/*B*/
CREATE VIEW view_tarif_gite (numgite,nom_gite,nom_proprietaire,saison,tarif)
AS (SELECT G.numgite, nomgite, nomProp, tarifttc, saison
    FROM gites G JOIN proprietaire P ON G.numprop=P.numprop 
        JOIN facturer F ON G.numgite=F.numgite);

/*C*/
CREATE VIEW view_gite_sans_loc (num_gite,nom_gite,nom_proprietaire,saison,tarif,tel_gite,description,num_prop,superficiegite,nb_epis,nb_personne)
AS (SELECT G.numgite, nomgite, nomProp, saison, tarifttc, telgite, description, P.numprop, superficiegit, nbepis, nbpers
    FROM gites G JOIN proprietaire P ON G.numprop=P.numprop
        JOIN facturer F ON G.numgite=F.numgite
    WHERE G.numgite NOT IN (SELECT numgite FROM louer));

/*D*/
CREATE VIEW view_activite_gite (numgite,nom_gite,activite,distance,interet)
AS (SELECT G.numgite, nomgite, nomact, (info).distance, (info).interet
    FROM gites G JOIN proposer P ON G.numgite=P.numgite
        JOIN activites A ON P.numact=A.numact);


/*Q2*/
/*A*/
CREATE RULE view_location_update AS ON UPDATE TO view_location
DO INSTEAD
    UPDATE LOUER L
    SET duree = NEW.duree_loc, 
        nbper = NEW.nbper
    WHERE OLD.numgite = L.numgite AND OLD.numcl = L.numcli AND NEW.nbper <= (SELECT nbpers FROM gites G WHERE G.numgite=L.numgite);