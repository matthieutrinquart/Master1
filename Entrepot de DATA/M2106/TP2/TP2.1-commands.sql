/* TP2 - BDD */

/*Partie 1*/
/*1*/	
ALTER TABLE planning ADD tarifenf NUMERIC(6,2);
ALTER TABLE reservation ADD nbenf NUMERIC(2,0);

/*2*/	
ALTER TABLE optionv
	ALTER COLUMN libelle TYPE VARCHAR(30);

/*3.1*/	
CREATE DOMAIN DOM_cat_cli AS VARCHAR(15) 
	CONSTRAINT ck_cat
	CHECK (VALUE IN ('PRIVILEGIE','BON','MAUVAIS'));
ALTER TABLE client
	ALTER COLUMN categorie TYPE DOM_cat_cli;

/*3.2*/	
ALTER TABLE client
	ALTER COLUMN categorie SET DEFAULT 'MAUVAIS';
UPDATE client SET categorie='MAUVAIS' WHERE categorie IS NULL;

/*3.3*/	
ALTER TABLE voyage
	ADD CONSTRAINT etoile_c CHECK (nbetoiles between 1 AND 5);

/*4.1*/	
CREATE TABLE HOTEL (
	id_hotel SERIAL PRIMARY KEY,
	NomHotel VARCHAR(20) NULL,
	NbEtoiles numeric(1,0) NULL,
	VilleHotel VARCHAR(20) NULL,
	CONSTRAINT nbetoile_c_hotel CHECK (NbEtoiles between 1 AND 5)
);

CREATE TYPE t_chambre AS ENUM('SINGLE', 'DOUBLE', 'DOUBLE LUXE', 'SUITE', 'SUITE JUNIOR', 'SUITE PRESTIGE');

CREATE TABLE CAPACITE (
	id_hotel INTEGER,
	typeChambre t_chambre,
	NbrCh INTEGER DEFAULT 0,
	CONSTRAINT fk_hotel FOREIGN KEY (id_hotel) REFERENCES HOTEL(id_hotel),
	CONSTRAINT pk_capacite PRIMARY KEY (id_hotel, typeChambre)
);

/*4.2*/
ALTER TABLE voyage
	ADD id_hotel INTEGER,
	ADD CONSTRAINT fk_hotel_voyage FOREIGN KEY (id_hotel) REFERENCES HOTEL(id_hotel);

/*4.3*/
INSERT INTO HOTEL (nomHotel,nbetoiles,villeHotel) 
	(SELECT DISTINCT hotel, nbetoiles, villearr FROM voyage);

/*4.4*/
UPDATE voyage V SET id_hotel=(SELECT id_hotel FROM hotel WHERE nomhotel=V.hotel);

/*4.5*/
SELECT * FROM voyage V INNER JOIN hotel H ON V.id_hotel=H.id_hotel

/*4.6*/
ALTER TABLE voyage DROP COLUMN villearr;
ALTER TABLE voyage DROP COLUMN hotel;
ALTER TABLE voyage DROP COLUMN nbetoiles;

/*4.7*/
CREATE TABLE temp_capa AS SELECT * FROM CAPACITE;
ALTER TABLE temp_capa ADD HOTEL VARCHAR(20);

UPDATE temp_capa T SET id_hotel=(SELECT id_hotel FROM hotel WHERE nomHotel=T.Hotel);

INSERT INTO capacite(id_hotel, typeChambre, nbrch) (SELECT id_hotel, typeChambre, nbrch FROM temp_capa);

DROP TABLE temp_capa;



/*Partie 2*/
/*1*/
UPDATE reservation SET nbenf = 2 WHERE numcl = 2103;
UPDATE reservation SET nbenf = 2 WHERE numcl =(SELECT numcl 
	FROM client 
	WHERE nom LIKE 'JAROLIM' AND prenom LIKE 'THOMAS');

/*2*/
UPDATE planning SET tarifenf = tarif/2;

/*3*/
INSERT INTO client(numcl, nom, prenom, ville)
VALUES((SELECT max(numcl)+ 1 FROM client), 'ALLEMAND', 'GREGORY', 'AIX-EN-PROVENCE');

INSERT INTO client VALUES((SELECT max(numcl)+ 1 FROM client), 'BENSALAH', 'MALEK',NULL, NULL, 'MARSEILLE', NULL);

INSERT INTO client VALUES((SELECT max(numcl)+  1 FROM  client),  'BEUF',  'FRANCOIS',NULL, NULL, 'MARSEILLE', 'PREMIER');

/*4*/
UPDATE VOYAGE SET NBETOILES = 9;