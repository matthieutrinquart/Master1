-- -----------------------------------------------------------------------------
--             Génération d'une base de données pour
--                           PostgreSQL
--                        (19/9/2018 16:46:23)
-- -----------------------------------------------------------------------------
--      Nom de la base : MLR3
--      Projet : Accueil Win'Design version 16
--      Auteur : Lenhard
--      Date de dernière modification : 19/9/2018 16:43:53
-- -----------------------------------------------------------------------------

drop database MLR3;
-- -----------------------------------------------------------------------------
--       CREATION DE LA BASE 
-- -----------------------------------------------------------------------------

CREATE DATABASE MLR3;

-- -----------------------------------------------------------------------------
--       TABLE : FACTURE
-- -----------------------------------------------------------------------------

CREATE TABLE FACTURE
   (
    CODEFAC INT NOT NULL  ,
    DATEFAC date NULL 
      DEFAULT NULL 
,   CONSTRAINT PK_FACTURE PRIMARY KEY (CODEFAC)
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : DEPARTEMENT
-- -----------------------------------------------------------------------------

CREATE TABLE DEPARTEMENT
   (
    NOMDEP char(32) NOT NULL  ,
    RESPDEP char(32) NULL  
,   CONSTRAINT PK_DEPARTEMENT PRIMARY KEY (NOMDEP)
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : QUALIFICATION
-- -----------------------------------------------------------------------------

CREATE TABLE QUALIFICATION
   (
    CODEQUALIF char(32) NOT NULL  ,
    LIBQUALIF char(32) NOT NULL  ,
    DESQUALIF char(32) NULL  
,   CONSTRAINT PK_QUALIFICATION PRIMARY KEY (CODEQUALIF)
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : ORGANISME
-- -----------------------------------------------------------------------------

CREATE TABLE ORGANISME
   (
    CODEORGA  NOT NULL  ,
    DENOMINATION  NULL  ,
    ADRESSE varchar(100) NULL 
      DEFAULT 'NULL' ,
    VILLE varchar(75) NULL 
      DEFAULT 'NULL' ,
    CP int4 NULL 
      DEFAULT NULL ,
    TEL varchar(20) NULL 
      DEFAULT 'NULL' 
,   CONSTRAINT PK_ORGANISME PRIMARY KEY (CODEORGA)
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : CATEGORIE
-- -----------------------------------------------------------------------------

CREATE TABLE CATEGORIE
   (
    CODECAT char(32) NOT NULL  ,
    LIBCAT char(32) NULL  ,
    DESCCAT char(32) NULL  
,   CONSTRAINT PK_CATEGORIE PRIMARY KEY (CODECAT)
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : EMPLOYE
-- -----------------------------------------------------------------------------

CREATE TABLE EMPLOYE
   (
    NUMEMP  NOT NULL  ,
    NOMDEP char(32) NOT NULL  ,
    CODECAT char(32) NOT NULL  ,
    CODEQUALIF char(32) NOT NULL  ,
    NOMEMP varchar(25) NULL 
      DEFAULT 'NULL' ,
    PREEMP varchar(25) NULL 
      DEFAULT 'NULL' ,
    SEXEEMP char(1) NULL 
      DEFAULT 'NULL' ,
    DATENAIS date NULL 
      DEFAULT NULL ,
    DATEEMB date NULL 
      DEFAULT NULL 
,   CONSTRAINT PK_EMPLOYE PRIMARY KEY (NUMEMP)
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE EMPLOYE
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_EMPLOYE_DEPARTEMENT
     ON EMPLOYE (NOMDEP)
    ;

CREATE  INDEX I_FK_EMPLOYE_CATEGORIE
     ON EMPLOYE (CODECAT)
    ;

CREATE  INDEX I_FK_EMPLOYE_QUALIFICATION
     ON EMPLOYE (CODEQUALIF)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : COURS
-- -----------------------------------------------------------------------------

CREATE TABLE COURS
   (
    REFCOURS varchar(7) NOT NULL  ,
    CODEORGA  NOT NULL  ,
    DESIGNATION  NULL  ,
    PRIX int4 NULL 
      DEFAULT NULL ,
    LIEU varchar(30) NULL 
      DEFAULT 'NULL' ,
    NBMAXPARTICIP INT NULL 
      DEFAULT NULL ,
    NBMINPARTICIP INT NULL 
      DEFAULT NULL ,
    DUREE INT NULL 
      DEFAULT NULL 
,   CONSTRAINT PK_COURS PRIMARY KEY (REFCOURS)
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE COURS
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_COURS_ORGANISME
     ON COURS (CODEORGA)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : INSCRIRE
-- -----------------------------------------------------------------------------

CREATE TABLE INSCRIRE
   (
    NUMEMP  NOT NULL  ,
    REFCOURS varchar(7) NOT NULL  
,   CONSTRAINT PK_INSCRIRE PRIMARY KEY (NUMEMP, REFCOURS)
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE INSCRIRE
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_INSCRIRE_EMPLOYE
     ON INSCRIRE (NUMEMP)
    ;

CREATE  INDEX I_FK_INSCRIRE_COURS
     ON INSCRIRE (REFCOURS)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : SESSION
-- -----------------------------------------------------------------------------

CREATE TABLE SESSION
   (
    CODEFAC INT NOT NULL  ,
    NUMEMP  NOT NULL  ,
    REFCOURS varchar(7) NOT NULL  ,
    DATEDEB date NULL 
      DEFAULT NULL ,
    NBPLACEMAX INT NULL 
      DEFAULT NULL 
,   CONSTRAINT PK_SESSION PRIMARY KEY (CODEFAC, NUMEMP, REFCOURS)
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE SESSION
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_SESSION_FACTURE
     ON SESSION (CODEFAC)
    ;

CREATE  INDEX I_FK_SESSION_EMPLOYE
     ON SESSION (NUMEMP)
    ;

CREATE  INDEX I_FK_SESSION_COURS
     ON SESSION (REFCOURS)
    ;


-- -----------------------------------------------------------------------------
--       CREATION DES REFERENCES DE TABLE
-- -----------------------------------------------------------------------------


ALTER TABLE EMPLOYE ADD 
     CONSTRAINT FK_EMPLOYE_DEPARTEMENT
          FOREIGN KEY (NOMDEP)
               REFERENCES DEPARTEMENT (NOMDEP);

ALTER TABLE EMPLOYE ADD 
     CONSTRAINT FK_EMPLOYE_CATEGORIE
          FOREIGN KEY (CODECAT)
               REFERENCES CATEGORIE (CODECAT);

ALTER TABLE EMPLOYE ADD 
     CONSTRAINT FK_EMPLOYE_QUALIFICATION
          FOREIGN KEY (CODEQUALIF)
               REFERENCES QUALIFICATION (CODEQUALIF);

ALTER TABLE COURS ADD 
     CONSTRAINT FK_COURS_ORGANISME
          FOREIGN KEY (CODEORGA)
               REFERENCES ORGANISME (CODEORGA);

ALTER TABLE INSCRIRE ADD 
     CONSTRAINT FK_INSCRIRE_EMPLOYE
          FOREIGN KEY (NUMEMP)
               REFERENCES EMPLOYE (NUMEMP);

ALTER TABLE INSCRIRE ADD 
     CONSTRAINT FK_INSCRIRE_COURS
          FOREIGN KEY (REFCOURS)
               REFERENCES COURS (REFCOURS);

ALTER TABLE SESSION ADD 
     CONSTRAINT FK_SESSION_FACTURE
          FOREIGN KEY (CODEFAC)
               REFERENCES FACTURE (CODEFAC);

ALTER TABLE SESSION ADD 
     CONSTRAINT FK_SESSION_EMPLOYE
          FOREIGN KEY (NUMEMP)
               REFERENCES EMPLOYE (NUMEMP);

ALTER TABLE SESSION ADD 
     CONSTRAINT FK_SESSION_COURS
          FOREIGN KEY (REFCOURS)
               REFERENCES COURS (REFCOURS);


-- -----------------------------------------------------------------------------
--                FIN DE GENERATION
-- -----------------------------------------------------------------------------