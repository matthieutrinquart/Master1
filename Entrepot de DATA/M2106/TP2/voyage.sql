create schema TP2_bd_voyage;
set search_path=TP2_bd_voyage;


CREATE TABLE VOYAGE (
IDV NUMERIC(6,2), 
VILLEARR VARCHAR (20), 
PAYSARR VARCHAR (20), 
VILLEDEP VARCHAR (20), 
HOTEL VARCHAR (20), 
NBETOILES NUMERIC(1,0), 
DUREE NUMERIC(2,0), 
CONSTRAINT PK_VOYAGE PRIMARY KEY (IDV) );


CREATE TABLE PLANNING (
IDV NUMERIC(6,0), 
DATEDEP DATE, 
TARIF NUMERIC(6,2), 
CONSTRAINT PK_PLANNING PRIMARY KEY (IDV, DATEDEP) , 
CONSTRAINT FK_PLANNING_IDV FOREIGN KEY (IDV) REFERENCES VOYAGE (IDV) );


CREATE TABLE CLIENT (
NUMCL NUMERIC(6,0), 
NOM VARCHAR (25), 
PRENOM VARCHAR (20), 
ADRESSE VARCHAR (40), 
CP VARCHAR (5), 
VILLE VARCHAR (20), 
CATEGORIE VARCHAR (15),  
CONSTRAINT PK_CLIENT PRIMARY KEY (NUMCL) );


CREATE TABLE RESERVATION (
NUMCL NUMERIC(6,0), 
IDV NUMERIC(6,0),  
DATEDEP DATE, 
NBPERS NUMERIC(2,0), 
DATERES DATE, 
CONSTRAINT PK_RESERVATION PRIMARY KEY (NUMCL, IDV, DATEDEP) , 
CONSTRAINT FK_RESERVATION_IDV_DATEDEP FOREIGN KEY (IDV, DATEDEP) REFERENCES PLANNING (IDV, DATEDEP) , 
CONSTRAINT FK_RESERVATION_NUMCL FOREIGN KEY (NUMCL) REFERENCES CLIENT (NUMCL) );


CREATE TABLE OPTIONV (
CODE NUMERIC(3,0), 
LIBELLE VARCHAR (20), 
CONSTRAINT PK_OPTIONV PRIMARY KEY (CODE) );


CREATE TABLE CARAC (
IDV NUMERIC(6,0),  
CODE NUMERIC(3,0), 
PRIX NUMERIC(3,0), 
CONSTRAINT PK_CARAC PRIMARY KEY (IDV, CODE) , 
CONSTRAINT FK_CARAC_IDV FOREIGN KEY (IDV) REFERENCES VOYAGE (IDV) , 
CONSTRAINT FK_CARAC_CODE FOREIGN KEY (CODE) REFERENCES OPTIONV (CODE) );

/************************/
/* Cr�ation des voyages */
/************************/

INSERT INTO VOYAGE VALUES (867, 'LISBONNE', 'PORTUGAL', 'MARSEILLE', 'MONDIAL', 3, 2);
INSERT INTO VOYAGE VALUES (869, 'RABAT', 'MAROC', 'MARSEILLE', 'HASNA' , 3, 3);
INSERT INTO VOYAGE VALUES (865, 'CASABLANCA', 'MAROC', 'MARSEILLE', 'BELLERIVE', 4, 6);
INSERT INTO VOYAGE VALUES (866, 'CASABLANCA', 'MAROC', 'LYON', 'BELLERIVE', 4, 7);
INSERT INTO VOYAGE VALUES (100, 'ISTAMBUL', 'TURQUIE', 'BORDEAUX', 'ANTIQUE', 5, 5);
INSERT INTO VOYAGE VALUES (105, 'DAKAR', 'SENEGAL', 'PARIS', 'ESPADON', 3, 6);
INSERT INTO VOYAGE VALUES (110, 'MARRAKECH', 'MAROC', 'PARIS', 'EL ANDALOUS', 3, 5);
INSERT INTO VOYAGE VALUES (120, 'MARRAKECH', 'MAROC', 'MARSEILLE', 'EL ANDALOUS', 3, 4);
INSERT INTO VOYAGE VALUES (857, 'ISTAMBUL', 'TURQUIE', 'PARIS', 'ANTIQUE', 5, 6);
INSERT INTO VOYAGE VALUES (927, 'LARNACA', 'CHYPRE', 'PARIS', 'OLD BRIDGE', 4, 4);
INSERT INTO VOYAGE VALUES (122, 'LIMASSOL', 'CHYPRE', 'PARIS', 'ELIAS BEACH', 5, 4);
INSERT INTO VOYAGE VALUES (354, 'BOMBASA', 'KENYA', 'MARSEILLE', 'SAFARI JAMBO', 4, 7);
INSERT INTO VOYAGE VALUES (952, 'NAIROBI', 'KENYA', 'PARIS', 'BAMBURI', 3, 6);
INSERT INTO VOYAGE VALUES (321, 'FEZ', 'MAROC', 'MARSEILLE', 'DAR AL BAHAR' , 4, 6);
INSERT INTO VOYAGE VALUES (860, 'SEVILLE', 'ESPAGNE', 'MARSEILLE', 'EL ALMARANTE', 5, 4);
INSERT INTO VOYAGE VALUES (862, 'AGADIR', 'MAROC', 'MARSEILLE', 'ATLAS', 4, 4);
INSERT INTO VOYAGE VALUES (972, 'AGADIR', 'MAROC', 'PARIS', 'TRANSATLANTIQUE', 4, 6);
INSERT INTO VOYAGE VALUES (792, 'MARRAKECH', 'MAROC', 'PARIS', 'KENZI CLUB', 3, 5);


/************************/
/* Cr�ation des plannings*/
/************************/

INSERT INTO PLANNING VALUES (100, TO_DATE ('04/05/04', 'DD/MM/YY'), 470);
INSERT INTO PLANNING VALUES (100, TO_DATE ('05/06/04', 'DD/MM/YY'), 470);
INSERT INTO PLANNING VALUES (857, TO_DATE ('04/05/04', 'DD/MM/YY'), 370);
INSERT INTO PLANNING VALUES (857, TO_DATE ('15/05/04', 'DD/MM/YY'),  370);
INSERT INTO PLANNING VALUES (857, TO_DATE ('03/06/04', 'DD/MM/YY'), 390);
INSERT INTO PLANNING VALUES (857, TO_DATE ('18/06/04', 'DD/MM/YY'),  390);
INSERT INTO PLANNING VALUES (857, TO_DATE ('04/07/04', 'DD/MM/YY'), 500);
INSERT INTO PLANNING VALUES (857, TO_DATE ('10/07/04', 'DD/MM/YY'), 500);
INSERT INTO PLANNING VALUES (857, TO_DATE ('02/08/04', 'DD/MM/YY'), 500);
INSERT INTO PLANNING VALUES (857, TO_DATE ('10/08/04', 'DD/MM/YY'),  500);
INSERT INTO PLANNING VALUES (857, TO_DATE ('14/08/04', 'DD/MM/YY'), 500);
INSERT INTO PLANNING VALUES (857, TO_DATE ('21/08/04', 'DD/MM/YY'), 500);
INSERT INTO PLANNING VALUES (857, TO_DATE ('04/09/04', 'DD/MM/YY'), 390);
INSERT INTO PLANNING VALUES (927, TO_DATE ('07/05/04', 'DD/MM/YY'), 420);
INSERT INTO PLANNING VALUES (927, TO_DATE ('10/06/04', 'DD/MM/YY'), 420);
INSERT INTO PLANNING VALUES (927, TO_DATE ('10/07/04', 'DD/MM/YY'), 490);
INSERT INTO PLANNING VALUES (927, TO_DATE ('17/07/04', 'DD/MM/YY'), 490);
INSERT INTO PLANNING VALUES (927, TO_DATE ('23/07/04', 'DD/MM/YY'), 490);
INSERT INTO PLANNING VALUES (927, TO_DATE ('01/08/04', 'DD/MM/YY'), 490);
INSERT INTO PLANNING VALUES (122, TO_DATE ('05/04/04', 'DD/MM/YY'), 448);
INSERT INTO PLANNING VALUES (122, TO_DATE ('15/05/04', 'DD/MM/YY'), 448);
INSERT INTO PLANNING VALUES (122, TO_DATE ('20/06/04', 'DD/MM/YY'), 490);
INSERT INTO PLANNING VALUES (122, TO_DATE ('01/07/04', 'DD/MM/YY'), 530);
INSERT INTO PLANNING VALUES (122, TO_DATE ('02/08/04', 'DD/MM/YY'), 530);
INSERT INTO PLANNING VALUES (122, TO_DATE ('11/09/04', 'DD/MM/YY'), 490);
INSERT INTO PLANNING VALUES (122, TO_DATE ('01/10/04', 'DD/MM/YY'), 450);
INSERT INTO PLANNING VALUES (122, TO_DATE ('02/11/04', 'DD/MM/YY'), 423);
INSERT INTO PLANNING VALUES (122, TO_DATE ('17/12/04', 'DD/MM/YY'), 450);
INSERT INTO PLANNING VALUES (122, TO_DATE ('04/01/05', 'DD/MM/YY'), 405);
INSERT INTO PLANNING VALUES (354, TO_DATE ('04/05/04', 'DD/MM/YY'), 999);
INSERT INTO PLANNING VALUES (354, TO_DATE ('03/06/04', 'DD/MM/YY'), 999);
INSERT INTO PLANNING VALUES (354, TO_DATE ('11/06/04', 'DD/MM/YY'), 999);
INSERT INTO PLANNING VALUES (952, TO_DATE ('13/06/04', 'DD/MM/YY'), 890);
INSERT INTO PLANNING VALUES (952, TO_DATE ('11/05/04', 'DD/MM/YY'), 890);
INSERT INTO PLANNING VALUES (952, TO_DATE ('23/04/04', 'DD/MM/YY'), 890);
INSERT INTO PLANNING VALUES (972, TO_DATE ('13/04/04', 'DD/MM/YY'), 179);
INSERT INTO PLANNING VALUES (972, TO_DATE ('15/05/04', 'DD/MM/YY'), 179);
INSERT INTO PLANNING VALUES (972, TO_DATE ('30/05/04', 'DD/MM/YY'), 179);
INSERT INTO PLANNING VALUES (972, TO_DATE ('10/06/04', 'DD/MM/YY'), 199);
INSERT INTO PLANNING VALUES (972, TO_DATE ('17/06/04', 'DD/MM/YY'), 199);
INSERT INTO PLANNING VALUES (792, TO_DATE ('13/04/04', 'DD/MM/YY'), 299);
INSERT INTO PLANNING VALUES (792, TO_DATE ('20/04/04', 'DD/MM/YY'), 299);
INSERT INTO PLANNING VALUES (792, TO_DATE ('02/05/04', 'DD/MM/YY'), 299);
INSERT INTO PLANNING VALUES (792, TO_DATE ('15/05/04', 'DD/MM/YY'), 299);
INSERT INTO PLANNING VALUES (792, TO_DATE ('01/06/04', 'DD/MM/YY'), 325);
INSERT INTO PLANNING VALUES (792, TO_DATE ('12/06/04', 'DD/MM/YY'), 325);
INSERT INTO PLANNING VALUES (792, TO_DATE ('21/06/04', 'DD/MM/YY'), 325);
INSERT INTO PLANNING VALUES (792, TO_DATE ('01/07/04', 'DD/MM/YY'), 352);
INSERT INTO PLANNING VALUES (792, TO_DATE ('10/07/04', 'DD/MM/YY'), 352);
INSERT INTO PLANNING VALUES (792, TO_DATE ('21/07/04', 'DD/MM/YY'), 352);
INSERT INTO PLANNING VALUES (792, TO_DATE ('01/08/04', 'DD/MM/YY'), 352);
INSERT INTO PLANNING VALUES (792, TO_DATE ('13/08/04', 'DD/MM/YY'), 352);
INSERT INTO PLANNING VALUES (792, TO_DATE ('22/08/04', 'DD/MM/YY'), 352);
INSERT INTO PLANNING VALUES (792, TO_DATE ('01/09/04', 'DD/MM/YY'), 325);
INSERT INTO PLANNING VALUES (792, TO_DATE ('10/09/04', 'DD/MM/YY'), 325);
INSERT INTO PLANNING VALUES (105, TO_DATE ('18/08/03', 'DD/MM/YY'), 825);
INSERT INTO PLANNING VALUES (105, TO_DATE ('20/09/03', 'DD/MM/YY'), 825);
INSERT INTO PLANNING VALUES (105, TO_DATE ('18/10/03', 'DD/MM/YY'), 825);
INSERT INTO PLANNING VALUES (105, TO_DATE ('18/11/03', 'DD/MM/YY'), 825);
INSERT INTO PLANNING VALUES (105, TO_DATE ('23/11/03', 'DD/MM/YY'), 925);
INSERT INTO PLANNING VALUES (105, TO_DATE ('10/01/04', 'DD/MM/YY'), 825);
INSERT INTO PLANNING VALUES (792, TO_DATE ('01/10/04', 'DD/MM/YY'), 325);
INSERT INTO PLANNING VALUES (792, TO_DATE ('01/11/04', 'DD/MM/YY'), 300);
INSERT INTO PLANNING VALUES (792, TO_DATE ('01/12/04', 'DD/MM/YY'), 300);
INSERT INTO PLANNING VALUES (792, TO_DATE ('22/12/04', 'DD/MM/YY'), 375);
INSERT INTO PLANNING VALUES (862, TO_DATE ('15/08/03', 'DD/MM/YY'), 575);
INSERT INTO PLANNING VALUES (862, TO_DATE ('22/08/03', 'DD/MM/YY'), 575);
INSERT INTO PLANNING VALUES (862, TO_DATE ('15/09/03', 'DD/MM/YY'), 500);
INSERT INTO PLANNING VALUES (862, TO_DATE ('01/10/03', 'DD/MM/YY'), 475);
INSERT INTO PLANNING VALUES (860, TO_DATE ('15/05/03', 'DD/MM/YY'), 275);
INSERT INTO PLANNING VALUES (860, TO_DATE ('17/06/03', 'DD/MM/YY'), 300);
INSERT INTO PLANNING VALUES (860, TO_DATE ('15/07/03', 'DD/MM/YY'), 325);
INSERT INTO PLANNING VALUES (860, TO_DATE ('01/07/03', 'DD/MM/YY'), 325);
INSERT INTO PLANNING VALUES (860, TO_DATE ('05/07/03', 'DD/MM/YY'), 325);
INSERT INTO PLANNING VALUES (860, TO_DATE ('05/08/03', 'DD/MM/YY'), 325);
INSERT INTO PLANNING VALUES (867, TO_DATE ('05/04/04', 'DD/MM/YY'), 305);
INSERT INTO PLANNING VALUES (867, TO_DATE ('15/05/04', 'DD/MM/YY'), 325);
INSERT INTO PLANNING VALUES (869, TO_DATE ('07/08/04', 'DD/MM/YY'), 315);



/************************/
/* Cr�ation des options */
/************************/

INSERT INTO OPTIONV VALUES (10, 'VISITE GUIDEE');
INSERT INTO OPTIONV VALUES (11, 'VISITE EN MINI-BUS');
INSERT INTO OPTIONV VALUES (12, 'PISCINE');
INSERT INTO OPTIONV VALUES (13, 'GARDERIE  ENFANT');
INSERT INTO OPTIONV VALUES (15, 'SAFARI PHOTO');
INSERT INTO OPTIONV VALUES (16, 'SAFARI DECOUVERTE');
INSERT INTO OPTIONV VALUES (20, 'SAUNA');
INSERT INTO OPTIONV VALUES (21, 'PLAGE PRIVEE');
INSERT INTO OPTIONV VALUES (22, 'TERRASSE PRIVATIVE');
INSERT INTO OPTIONV VALUES (23, 'BAGAGERIE');
INSERT INTO OPTIONV VALUES (24, 'JACUZZI');



/************************/
/* Cr�ation des carac */
/************************/

INSERT INTO CARAC VALUES (354, 16, 36);
INSERT INTO CARAC VALUES (354, 15, 36);
INSERT INTO CARAC VALUES (869, 23, NULL);
INSERT INTO CARAC VALUES (867, 23, NULL);
INSERT INTO CARAC VALUES (952, 16, 45);
INSERT INTO CARAC VALUES (952, 15, 45);
INSERT INTO CARAC VALUES (952, 12, NULL);
INSERT INTO CARAC VALUES (952, 22, NULL);
INSERT INTO CARAC VALUES (354, 12, NULL);
INSERT INTO CARAC VALUES (354, 23, NULL);
INSERT INTO CARAC VALUES (354, 24, NULL);
INSERT INTO CARAC VALUES (100, 13, 10);
INSERT INTO CARAC VALUES (100, 20, 5.5);
INSERT INTO CARAC VALUES (105, 13, NULL);
INSERT INTO CARAC VALUES (120, 13, NULL);
INSERT INTO CARAC VALUES (100, 22, NULL);
INSERT INTO CARAC VALUES (927, 11, 35);
INSERT INTO CARAC VALUES (857, 11, 35);
INSERT INTO CARAC VALUES (857, 12, NULL);
INSERT INTO CARAC VALUES (857, 13, NULL);
INSERT INTO CARAC VALUES (857, 20, NULL);
INSERT INTO CARAC VALUES (105, 12, NULL);
INSERT INTO CARAC VALUES (110, 12, NULL);
INSERT INTO CARAC VALUES (120, 12, NULL);
INSERT INTO CARAC VALUES (862, 16, 40);
INSERT INTO CARAC VALUES (862, 21, NULL);
INSERT INTO CARAC VALUES (860, 12, NULL);
INSERT INTO CARAC VALUES (860, 10, 10);
INSERT INTO CARAC VALUES (860, 13, NULL);
INSERT INTO CARAC VALUES (860, 23, NULL);

/************************/
/* Cr�ation des clients */
/************************/

INSERT INTO CLIENT VALUES (2101, 'BARBIER', 'NICOLAS', '12 RUE DU CHERCHE MIDI', '75008', 'PARIS', NULL);
INSERT INTO CLIENT VALUES (2102, 'BARTHALOIS', 'MYLENE', NULL, '13100', 'MARSEILLE', NULL);
INSERT INTO CLIENT VALUES (2103, 'CHASPOUL', 'AUBIN', NULL, '13100', 'MARSEILLE', NULL);
INSERT INTO CLIENT VALUES (2104, 'CORTES', 'SEBASTIEN', NULL, NULL, 'PARIS', NULL);
INSERT INTO CLIENT VALUES (2105, 'COUMES', 'STEPHANIE', '20 RUE MILTON', '75009', 'PARIS', 'PRIVILEGIE');
INSERT INTO CLIENT VALUES (2106, 'FERRIER', 'JEAN-PHILIPPE', '26 RUE RODIER', '75009', 'PARIS', NULL);
INSERT INTO CLIENT VALUES (2107, 'GALERA', 'AXELLE', '60 RUE CHAPON', '75003', 'PARIS', NULL);
INSERT INTO CLIENT VALUES (2108, 'GANDELLI', 'JEAN-BAPTISTE', '70 RUE SAINT HONORE', '75001', 'PARIS', 'PRIVILEGIE');
INSERT INTO CLIENT VALUES (2109, 'GELIBERT', 'CLAIRE', '20 BOULEVARD SEBASTOPOL', '75001', 'PARIS', 'PRIVILEGIE');
INSERT INTO CLIENT VALUES (2110, 'GUZIK', 'DANIEL', '360 BOULEVARD NATIONAL', '13003', 'MARSEILLE', 'PRIVILEGIE');
INSERT INTO CLIENT VALUES (2111, 'JAROLIM', 'THOMAS', '21 RUE DOIZE', '13010', 'MARSEILLE', NULL);
INSERT INTO CLIENT VALUES (2112, 'LA SALA', 'GUILLAUME', '6 TRAVERSE MALVINA', '13012', 'MARSEILLE', NULL);
INSERT INTO CLIENT VALUES (2113, 'LAMIGEON', 'FABIEN', '30 RUE ANNONCIADE', '69001', 'LYON', 'BON');
INSERT INTO CLIENT VALUES (2114, 'LAMY', 'SEBASTIEN', '3 PLACE CROIX PAQUET', '69001', 'LYON', NULL);
INSERT INTO CLIENT VALUES (2115, 'LATCHIMY', 'RUDY', '2 QUAI SAINT ANTOINE', '69002', 'LYON', 'BON');
INSERT INTO CLIENT VALUES (2116, 'LIBERATI', 'JORIS', '80 COURS LUZE', '33300', 'BORDEAUX', 'PRIVILEGIE');
INSERT INTO CLIENT VALUES (2117, 'MAGAUD', 'EVE', '9 RUE PORTE BASSE' , '33000', 'BORDEAUX', NULL);
INSERT INTO CLIENT VALUES (2118, 'MARIN', 'HUBERT', '13 BOULEVARD ANDRE AUNE', '13006', 'MARSEILLE', 'BON');
INSERT INTO CLIENT VALUES (2119, 'MIETLICKI', 'PASCAL', '36 RUE PERRIN SOLIER', '13006', 'MARSEILLE', NULL);
INSERT INTO CLIENT VALUES (2120, 'PEYROCHE', 'ARNAUD', '7 RUE JEAN MERMOZ', '13008', 'MARSEILLE', NULL);
INSERT INTO CLIENT VALUES (2121, 'POTIER', 'NICOLAS', '10 RUE COURCELLE', '75008', 'PARIS', NULL);
INSERT INTO CLIENT VALUES (2122, 'ROGGERO', 'GUILLAUME', '57 RUE PIERRE CHARRON', '75008', 'PARIS', 'BON');
INSERT INTO CLIENT VALUES (2123, 'TARAS', 'SEBASTIEN', '68 RUE DANZIG', '75010', 'PARIS', 'BON');
INSERT INTO CLIENT VALUES (2124, 'TASSARA', 'NICOLAS', '5 IMPASSE LABRADOR', '75010', 'PARIS', NULL);
INSERT INTO CLIENT VALUES (2125, 'TORRES', 'ALEXANDRE', NULL, '75011', 'PARIS', NULL);
INSERT INTO CLIENT VALUES (2201, 'ALLEMAND', 'GREGORY', '24 RUE DAVIEL', '75013', 'PARIS', NULL);
INSERT INTO CLIENT VALUES (2202, 'BENSALAH', 'MALEK', '12 RUE SIMONE WEIL', '75013', 'PARIS', NULL);
INSERT INTO CLIENT VALUES (2203, 'BEUF', 'FRANCOIS', '12 RUE ALPHAND', '75013', 'PARIS', 'PRIVILEGIE');

/* Nouveaux tuples */
INSERT INTO CLIENT VALUES (2302, 'DUVAL', 'ROBERT', NULL, NULL, 'NICE', NULL);
INSERT INTO CLIENT VALUES (2303, 'DUCHEMIN', 'MARIE', NULL, NULL, 'NICE', NULL);
INSERT INTO CLIENT VALUES (2304, 'DUJARDIN', 'FRANCOIS', NULL, NULL, 'AIX', 'PRIVILEGIE');



/*****************************/
/* Cr�ation des r�servations */
/*****************************/

INSERT INTO RESERVATION VALUES (2107, 122, TO_DATE ('20/06/04', 'DD/MM/YY'), 2, TO_DATE ('25/03/04', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2101, 122, TO_DATE ('20/06/04', 'DD/MM/YY'), 1, TO_DATE ('20/04/04', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2110, 122, TO_DATE ('20/06/04', 'DD/MM/YY'), 2, TO_DATE ('12/02/04', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2124, 122, TO_DATE ('02/08/04', 'DD/MM/YY'), 2, TO_DATE ('14/03/04', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2122, 122, TO_DATE ('01/10/04', 'DD/MM/YY'), 2, TO_DATE ('24/07/04', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2118, 354, TO_DATE ('11/06/04', 'DD/MM/YY'), 1, TO_DATE ('22/12/03', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2118, 857, TO_DATE ('04/05/04', 'DD/MM/YY'), 1, TO_DATE ('22/01/04', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2110, 857, TO_DATE ('04/05/04', 'DD/MM/YY'), 1, TO_DATE ('22/01/04', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2102, 860, TO_DATE ('17/06/03', 'DD/MM/YY'), 2, TO_DATE ('05/12/02', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2103, 860, TO_DATE ('15/07/03', 'DD/MM/YY'), 2, TO_DATE ('05/12/02', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2102, 862, TO_DATE ('01/10/03', 'DD/MM/YY'), 1, TO_DATE ('05/07/03', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2111, 862, TO_DATE ('15/09/03', 'DD/MM/YY'), 2, TO_DATE ('25/05/03', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2101, 857, TO_DATE ('04/05/04', 'DD/MM/YY'), 2, TO_DATE ('10/12/03', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2104, 857, TO_DATE ('04/05/04', 'DD/MM/YY'), 3, TO_DATE ('04/01/04', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2121, 857, TO_DATE ('04/05/04', 'DD/MM/YY'), 2, TO_DATE ('10/01/04', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2125, 857, TO_DATE ('04/05/04', 'DD/MM/YY'), 1, TO_DATE ('08/11/03', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2117, 100, TO_DATE ('05/06/04', 'DD/MM/YY'), 2, TO_DATE ('05/12/03', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2107, 105, TO_DATE ('18/10/03', 'DD/MM/YY'), 2, TO_DATE ('25/09/03', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2109, 105, TO_DATE ('23/11/03', 'DD/MM/YY'), 4, TO_DATE ('23/09/03', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2113, 105, TO_DATE ('23/11/03', 'DD/MM/YY'), 1, TO_DATE ('17/07/03', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2111, 354, TO_DATE ('04/05/04', 'DD/MM/YY'), 2, TO_DATE ('14/01/02', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2119, 354, TO_DATE ('04/05/04', 'DD/MM/YY'), 2, TO_DATE ('07/02/04', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2111, 354, TO_DATE ('03/06/04', 'DD/MM/YY'), 2, TO_DATE ('20/03/03', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2120, 354, TO_DATE ('11/06/04', 'DD/MM/YY'), 1, TO_DATE ('05/03/04', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2102, 354, TO_DATE ('11/06/04', 'DD/MM/YY'), 1, TO_DATE ('30/01/04', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2110, 354, TO_DATE ('11/06/04', 'DD/MM/YY'), 1, TO_DATE ('22/12/03', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2109, 867, TO_DATE ('05/04/04', 'DD/MM/YY'), 1, TO_DATE ('22/01/04', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2120, 869, TO_DATE ('07/08/04', 'DD/MM/YY'), 1, TO_DATE ('13/06/04', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2201, 867, TO_DATE ('05/04/04', 'DD/MM/YY'), 1, TO_DATE ('13/01/04', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2201, 869, TO_DATE ('07/08/04', 'DD/MM/YY'), 1, TO_DATE ('03/04/04', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2202, 869, TO_DATE ('07/08/04', 'DD/MM/YY'), 1, TO_DATE ('25/06/04', 'DD/MM/YY'));
INSERT INTO RESERVATION VALUES (2203, 867, TO_DATE ('15/05/04', 'DD/MM/YY'), 1, TO_DATE ('23/03/04', 'DD/MM/YY'));




