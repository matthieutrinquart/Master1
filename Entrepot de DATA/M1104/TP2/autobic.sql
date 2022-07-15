/*
ORGANISME (codeOrga(pk), denomination, adresse, ville, cp, tel)
COURS (refCours(pk), #codeorga, designation, prix, lieu, nbMinParticip, duree)
QUALIFICATION (codeQualif(pk), libQualif)
CATEGORIE (codeCat(pk), libCat)
DEPARTEMENT (nomDep(pk), respDep)
EMPLOYER (numEmp(pk), #codeQualif, #codeCat, #nomDep, nomEmp, preEmp, sexeEmp, date_nais, date_emb)
INSCRIRE(#refCours(pk), #numEmp(pk))
FACTURE (codeFac(pk), dateFac)
SESSION (#numEmp(pk), #refCours(pk), #codeFac, datedeb, nbPlaceMax)
*/

CREATE TABLE ORGANISME
	(
		codeOrga SERIAL PRIMARY KEY,
		denomination VARCHAR(100) NOT NULL,
		adresse VARCHAR(75) NOT NULL,
		ville VARCHAR(50),
		cp DECIMAL(5,0),
		tel VARCHAR(15) DEFAULT NULL
	);

CREATE TABLE COURS
	(
		refCours SERIAL PRIMARY KEY,
		codeOrga INTEGER NOT NULL,
		designation TEXT NOT NULL,
		prix REAL NOT NULL,
		lieu VARCHAR(100) NOT NULL,
		nbMinParticip INTEGER DEFAULT 15,
		duree INTEGER NOT NULL,
		Constraint FK_ORGA FOREIGN KEY (codeOrga) REFERENCES ORGANISME (codeOrga)
	);
	
CREATE TABLE QUALIFICATION
	(
		codeQualif SERIAL PRIMARY KEY,
		libQualif VARCHAR(100) NOT NULL
	);
	
CREATE TABLE CATEGORIE
	(
		codeCat SERIAL PRIMARY KEY,
		libCat VARCHAR(100) NOT NULL
	);
	
CREATE TABLE DEPARTEMENT
	(
		nomDep VARCHAR(50) PRIMARY KEY,
		respDep VARCHAR(50) NOT NULL
	);
	
CREATE TABLE EMPLOYER
	(
		numEmp SERIAL PRIMARY KEY,
		codeQualif INTEGER NOT NULL,
		codeCat INTEGER NOT NULL,
		nomDep VARCHAR(50) NOT NULL,
		
		nomEmp VARCHAR(50) NOT NULL,
		preEmp VARCHAR(50) NOT NULL,
		sexeEmp CHAR(4) NOT NULL,
		date_nais DATE DEFAULT NULL,
		date_emb DATE NOT NULL,
		
		Constraint FK_QUALIF FOREIGN KEY (codeQualif) REFERENCES QUALIFICATION (codeQualif),
		Constraint FK_CAT FOREIGN KEY (codeCat) REFERENCES CATEGORIE (codeCat),
		Constraint FK_DEP FOREIGN KEY (nomDep) REFERENCES DEPARTEMENT (nomDep)
	);
	
CREATE TABLE INSCRIRE
	(
		refCours INTEGER NOT NULL,
		numEmp INTEGER NOT NULL,
		
		Constraint FK_COURS FOREIGN KEY (refCours) REFERENCES COURS (refCours),
		Constraint FK_EMP FOREIGN KEY (numEmp) REFERENCES EMPLOYER (numEmp),
		Constraint PK_INSC PRIMARY KEY (refCours, numEmp)
	);
	
CREATE TABLE FACTURE
	(
		codeFac SERIAL PRIMARY KEY,
		dateFac DATE DEFAULT CURRENT_TIMESTAMP
	);
	
CREATE TABLE SESSION
	(
		refCours INTEGER NOT NULL,
		numEmp INTEGER NOT NULL,
		codeFac INTEGER NOT NULL,
		datedeb DATE NOT NULL,
		nbPlaceMax INTEGER DEFAULT 10,
		
		Constraint FK_COURS_S FOREIGN KEY (refCours) REFERENCES COURS (refCours),
		Constraint FK_EMP_S FOREIGN KEY (numEmp) REFERENCES EMPLOYER (numEmp),
		Constraint FK_FACT FOREIGN KEY (codeFac) REFERENCES FACTURE (codeFac),
		
		Constraint PK_SESS PRIMARY KEY (refCours, numEmp)
	);
	