/*
HUTTE(nom_hutte(pk), surface, annee, hauteur)
SPECIALITE(nom_spe(pk))
HABITANT(nom_hab(pk), #nom_hutte, #nom_spe, date_nais, sexe)
POTION(nom_potion(pk), effet, duree, intervalle)
PRISE(date(pk), #nom_hab(pk), #nom_potion(pk), qte)
*/

Create TABLE HUTTE 
	(
		nom_hutte varchar(45) PRIMARY KEY,
		surface integer NOT NULL,
		annee decimal(4,0),
		hauteur real DEFAULT NULL
	);
	
Create TABLE SPECIALITE
	(
		nom_spe varchar(50) PRIMARY KEY
	);
	
Create TABLE HABITANT
	(
		nom_hab varchar(15) PRIMARY KEY,
		nom_hutte varchar(50) NOT NULL,
		nom_spe varchar(50),
		date_nais date NOT NULL,
		sexe char DEFAULT 'M',
		Constraint FK_hutte FOREIGN KEY (nom_hutte) REFERENCES HUTTE (nom_hutte),
		Constraint FK_spe FOREIGN KEY (nom_spe) REFERENCES SPECIALITE (nom_spe)
	);
	
Create TABLE POTION
	(
		nom_potion varchar(15) PRIMARY KEY,
		effet varchar(30) NOT NULL,
		duree integer DEFAULT 2 constraint c_effet CHECK (duree between 0 and 120),
		intervalle decimal(7,3)
	);
	
Create TABLE PRISE
	(
		date date NOT NULL,
		nom_hab varchar(15) NOT NULL,
		nom_potion varchar(50) NOT NULL,
		qte integer NOT NULL DEFAULT 1,
		Constraint FK_habitant FOREIGN KEY (nom_hab) REFERENCES HABITANT (nom_hab),
		Constraint FK_potion FOREIGN KEY (nom_potion) REFERENCES POTION (nom_potion),
		Constraint PK_prise PRIMARY KEY (date, nom_hab, nom_potion)
	);