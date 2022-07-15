-- -----------------------------------------------------------------------------
--             Génération d'une base de données pour
--                           PostgreSQL
--                        (19/9/2018 17:02:30)
-- -----------------------------------------------------------------------------
--      Nom de la base : MLR1
--      Projet : Accueil Win'Design version 16
--      Auteur : Lenhard
--      Date de dernière modification : 19/9/2018 17:02:01
-- -----------------------------------------------------------------------------

drop database MLR1;
-- -----------------------------------------------------------------------------
--       CREATION DE LA BASE 
-- -----------------------------------------------------------------------------

CREATE DATABASE MLR1;

-- -----------------------------------------------------------------------------
--       TABLE : DECISION
-- -----------------------------------------------------------------------------

CREATE TABLE DECISION
   (
    ID_TYPE_DECISION serial NOT NULL  ,
    NOM_DECISION varchar(128) NULL  ,
    TYPE_DECISION varchar(128) NULL  
,   CONSTRAINT PK_DECISION PRIMARY KEY (ID_TYPE_DECISION)
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : AFFAIRE
-- -----------------------------------------------------------------------------

CREATE TABLE AFFAIRE
   (
    NUM_AFFAIRE serial NOT NULL  ,
    NUM_JURIDICTION integer NULL  ,
    DATE_DES_FAITS date(8) NULL  
,   CONSTRAINT PK_AFFAIRE PRIMARY KEY (NUM_AFFAIRE)
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : PRISONNIER
-- -----------------------------------------------------------------------------

CREATE TABLE PRISONNIER
   (
    NUM_ECROU serial NOT NULL  ,
    NOM varchar(128) NULL  ,
    PRENOM varchar(128) NULL  ,
    DATE_DE_NAISSANCE date(8) NULL  ,
    LIEU_NAISSANCE varchar(128) NULL  
,   CONSTRAINT PK_PRISONNIER PRIMARY KEY (NUM_ECROU)
   ) ;

-- -----------------------------------------------------------------------------
--       TABLE : MOTIF
-- -----------------------------------------------------------------------------

CREATE TABLE MOTIF
   (
    NUM_AFFAIRE serial NOT NULL  ,
    NUM_ECROU serial NOT NULL  ,
    ID_MOTIF integer NULL  ,
    LIBELE_MOTIF varchar(128) NULL  
,   CONSTRAINT PK_MOTIF PRIMARY KEY (NUM_AFFAIRE, NUM_ECROU)
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE MOTIF
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_MOTIF_AFFAIRE
     ON MOTIF (NUM_AFFAIRE)
    ;

CREATE  INDEX I_FK_MOTIF_PRISONNIER
     ON MOTIF (NUM_ECROU)
    ;

-- -----------------------------------------------------------------------------
--       TABLE : DUREE
-- -----------------------------------------------------------------------------

CREATE TABLE DUREE
   (
    NUM_ECROU serial NOT NULL  ,
    ID_TYPE_DECISION serial NOT NULL  ,
    DATE_DECISION date(8) NULL  ,
    DUREE_DECISION integer NULL  
,   CONSTRAINT PK_DUREE PRIMARY KEY (NUM_ECROU, ID_TYPE_DECISION)
   ) ;

-- -----------------------------------------------------------------------------
--       INDEX DE LA TABLE DUREE
-- -----------------------------------------------------------------------------

CREATE  INDEX I_FK_DUREE_PRISONNIER
     ON DUREE (NUM_ECROU)
    ;

CREATE  INDEX I_FK_DUREE_DECISION
     ON DUREE (ID_TYPE_DECISION)
    ;


-- -----------------------------------------------------------------------------
--       CREATION DES REFERENCES DE TABLE
-- -----------------------------------------------------------------------------


ALTER TABLE MOTIF ADD 
     CONSTRAINT FK_MOTIF_AFFAIRE
          FOREIGN KEY (NUM_AFFAIRE)
               REFERENCES AFFAIRE (NUM_AFFAIRE);

ALTER TABLE MOTIF ADD 
     CONSTRAINT FK_MOTIF_PRISONNIER
          FOREIGN KEY (NUM_ECROU)
               REFERENCES PRISONNIER (NUM_ECROU);

ALTER TABLE DUREE ADD 
     CONSTRAINT FK_DUREE_PRISONNIER
          FOREIGN KEY (NUM_ECROU)
               REFERENCES PRISONNIER (NUM_ECROU);

ALTER TABLE DUREE ADD 
     CONSTRAINT FK_DUREE_DECISION
          FOREIGN KEY (ID_TYPE_DECISION)
               REFERENCES DECISION (ID_TYPE_DECISION);


-- -----------------------------------------------------------------------------
--                FIN DE GENERATION
-- -----------------------------------------------------------------------------