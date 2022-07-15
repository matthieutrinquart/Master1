
--
-- Base de données :  bd_biblio
--


CREATE SCHEMA CTRL3_bd_biblio;
set search_path =  CTRL3_bd_biblio;

-- --------------------------------------------------------

--
-- Structure de la table biblio
--

CREATE TABLE biblio (
  IdBiblio integer primary key,
  nomBiblio varchar(15) NOT NULL,
  adrBiblio varchar(12) DEFAULT NULL,
  cpBiblio varchar(5) DEFAULT NULL
) ;

--
-- Contenu de la table biblio
--

INSERT INTO biblio (IdBiblio, nomBiblio, adrBiblio, cpBiblio) VALUES(208, 'Prado', 'Marseille', '13008');
INSERT INTO biblio (IdBiblio, nomBiblio, adrBiblio, cpBiblio) VALUES(71, 'République', 'Marseille', '13002');
INSERT INTO biblio (IdBiblio, nomBiblio, adrBiblio, cpBiblio) VALUES(112, 'St Charles', 'Marseille', '13001');
INSERT INTO biblio (IdBiblio, nomBiblio, adrBiblio, cpBiblio) VALUES(202, 'Aubagne', 'Aubagne', '13200');

-- --------------------------------------------------------

--
-- Structure de la table categorie
--

CREATE TABLE categorie (
  categLivre integer primary key,
  libCategorie varchar(30) NOT NULL,
  descriptionCat text NOT NULL
) ;

INSERT INTO categorie  VALUES(1, 'Roman', 'roman de la litérature française');
INSERT INTO categorie  VALUES(2, 'Enfant', 'litérature pour les enfants');
INSERT INTO categorie  VALUES(3, 'Poémes', 'recueuil de poémes');
INSERT INTO categorie  VALUES(4, 'Aventures', 'roman d''aventure');
INSERT INTO categorie  VALUES(5, 'Théâtre', 'Le scénario des pièces de Théâtre');
-- --------------------------------------------------------

--
-- Structure de la table emprunt
--

CREATE TABLE emprunt (
  IdLivre varchar(8) NOT NULL,
  IdMembre integer NOT NULL,
  dateEmprunt date DEFAULT NULL,
  dureeEmprunt integer DEFAULT NULL,
  constraint PK_emprunt primary key(IdLivre,IdMembre)
) ;


--
-- Contenu de la table emprunt
--

INSERT INTO emprunt (IdLivre, IdMembre, dateEmprunt, dureeEmprunt) VALUES('1920RLTY', 2, '2010-02-12', 6);
INSERT INTO emprunt (IdLivre, IdMembre, dateEmprunt, dureeEmprunt) VALUES('0228PRAZ', 30, '2011-02-05', 5);
INSERT INTO emprunt (IdLivre, IdMembre, dateEmprunt, dureeEmprunt) VALUES('6154PANB', 2, '2010-09-28', 9);
INSERT INTO emprunt (IdLivre, IdMembre, dateEmprunt, dureeEmprunt) VALUES('1920RLTY', 30, '2011-01-10', 10);
INSERT INTO emprunt (IdLivre, IdMembre, dateEmprunt, dureeEmprunt) VALUES('7658MNLK', 30, '2011-01-28', 11);
INSERT INTO emprunt (IdLivre, IdMembre, dateEmprunt, dureeEmprunt) VALUES('1920RLTY', 15, '2010-03-15', 6);
INSERT INTO emprunt (IdLivre, IdMembre, dateEmprunt, dureeEmprunt) VALUES('1956JJSS', 30, '2011-02-19', 2);
INSERT INTO emprunt (IdLivre, IdMembre, dateEmprunt, dureeEmprunt) VALUES('1206QIQA', 15, '2010-11-02', 10);
INSERT INTO emprunt (IdLivre, IdMembre, dateEmprunt, dureeEmprunt) VALUES('7658MNLK', 2, '2010-06-02', 5);
INSERT INTO emprunt (IdLivre, IdMembre, dateEmprunt, dureeEmprunt) VALUES('4919FFEF', 30, '2011-04-19', 7);
INSERT INTO emprunt (IdLivre, IdMembre, dateEmprunt, dureeEmprunt) VALUES('7658MNLK', 15, '2010-05-04', 5);
INSERT INTO emprunt (IdLivre, IdMembre, dateEmprunt, dureeEmprunt) VALUES('6154PANB', 5, '2010-05-04', 7);

-- --------------------------------------------------------

--
-- Structure de la table livre
--

CREATE TABLE livre (
  IdLivre varchar(8) primary key,
  titreLivre varchar(40) DEFAULT NULL,
  auteurLivre varchar(30) NOT NULL,
  categLivre integer DEFAULT 1,
  IdBiblio integer NOT NULL
) ;


--
-- Contenu de la table livre
--

INSERT INTO livre  VALUES('0228PRAZ', 'Les Misérables', 'Victor Hugo', 1, 208);
INSERT INTO livre  VALUES('1206QIQA', 'Paroles', 'Jacques Prévert', 3, 202);
INSERT INTO livre  VALUES('7658MNLK', 'Avicenne', 'Gilbert Sinoué', 1, 112);
INSERT INTO livre  VALUES('4021QRPO', 'Les Contemplations', 'Victor Hugo', 1, 112);
INSERT INTO livre  VALUES('7089PQIU', 'Le dernier pharaon', 'Gilbert Sinoué', 1, 202);
INSERT INTO livre  VALUES('6154PANB', 'Ruy Blas', 'Victor Hugo', 5, 71);
INSERT INTO livre  VALUES('1920RLTY', 'Contes pour les enfants pas sages', 'Jacques Prévert', 2, 208);
INSERT INTO livre  VALUES('1956JJSS', 'Le crabe aux pinces d''or', 'Hergé', 4, 71);
INSERT INTO livre  VALUES('4919FFEF', 'Silex and the city', 'Jul', 4, 202);
INSERT INTO Livre  VALUES('056G667X','La planète des sages', 'Jul&Pepin', 4, 208);
INSERT INTO Livre  VALUES ('0056561U','Mort sur le Nil', 'Agatha Christie', 1, 71);


-- --------------------------------------------------------

--
-- Structure de la table membre
--

CREATE TABLE membre (
  IdMembre integer primary key,
  nomMembre varchar(10) NOT NULL,
  adrMembre varchar(12) DEFAULT NULL,
  cpMembre varchar(5) DEFAULT NULL
) ;

--
-- Contenu de la table membre
--

INSERT INTO membre (IdMembre, nomMembre, adrMembre, cpMembre) VALUES(2, 'Durand', 'Marseille', '13008');
INSERT INTO membre (IdMembre, nomMembre, adrMembre, cpMembre) VALUES(7, 'Cassagne', 'Marseille', '13007');
INSERT INTO membre (IdMembre, nomMembre, adrMembre, cpMembre) VALUES(5, 'André', 'Gardanne', '13120');
INSERT INTO membre (IdMembre, nomMembre, adrMembre, cpMembre) VALUES(21, 'Petiot', 'Marseille', '13008');
INSERT INTO membre (IdMembre, nomMembre, adrMembre, cpMembre) VALUES(15, 'Monet', 'Aubagne', '13200');
INSERT INTO membre (IdMembre, nomMembre, adrMembre, cpMembre) VALUES(30, 'Napo', 'Marseille', '13012');


CREATE TABLE note (
  IdLivre varchar(8) NOT NULL,
  IdMembre int NOT NULL,
  Note int NOT NULL DEFAULT 0,
  constraint PK_note primary key(IdLivre,IdMembre)
  
) ;

-- ajout des clés étrangéres 
--
-- Contraintes pour la table note
--
ALTER TABLE note
  ADD CONSTRAINT note_ibfk_1 FOREIGN KEY (IdLivre) REFERENCES livre (IdLivre),
  ADD CONSTRAINT note_ibfk_2 FOREIGN KEY (IdMembre) REFERENCES membre (IdMembre);


alter table emprunt
add constraint FK_emp_livre foreign key(IdLivre) references livre(IdLivre),
add constraint FK_emp_Membre foreign key(IdMembre) references membre(IdMembre);

alter table livre 
add constraint FK_livre_biblio foreign key(IdBiblio) references biblio(IdBiblio),
add constraint FK_livre_cat foreign key(categLivre) references categorie(categLivre);



INSERT INTO note (idlivre,idmembre,note) VALUES ('7658MNLK','30',5);
INSERT INTO note (idlivre,idmembre,note) VALUES ('6154PANB','15',1);
INSERT INTO note (idlivre,idmembre,note) VALUES ('056G667X','5',5);
INSERT INTO note (idlivre,idmembre,note) VALUES ('0056561U','2',3);
INSERT INTO note (idlivre,idmembre,note) VALUES ('7658MNLK','5',2);
INSERT INTO note (idlivre,idmembre,note) VALUES ('7089PQIU','21',4);
INSERT INTO note (idlivre,idmembre,note) VALUES ('4919FFEF','7',1);
INSERT INTO note (idlivre,idmembre,note) VALUES ('1956JJSS','2',1);
INSERT INTO note (idlivre,idmembre,note) VALUES ('1920RLTY','7',1);
INSERT INTO note (idlivre,idmembre,note) VALUES ('4919FFEF','5',2);
INSERT INTO note (idlivre,idmembre,note) VALUES ('0228PRAZ','21',3);
INSERT INTO note (idlivre,idmembre,note) VALUES ('7658MNLK','7',4);
INSERT INTO note (idlivre,idmembre,note) VALUES ('1206QIQA','2',5);
INSERT INTO note (idlivre,idmembre,note) VALUES ('1956JJSS','30',4);
INSERT INTO note (idlivre,idmembre,note) VALUES ('6154PANB','7',5);
INSERT INTO note (idlivre,idmembre,note) VALUES ('4021QRPO','21',3);
INSERT INTO note (idlivre,idmembre,note) VALUES ('1206QIQA','5',4);
INSERT INTO note (idlivre,idmembre,note) VALUES ('1206QIQA','15',4);
INSERT INTO note (idlivre,idmembre,note) VALUES ('0228PRAZ','5',2);
INSERT INTO note (idlivre,idmembre,note) VALUES ('4919FFEF','30',3);
INSERT INTO note (idlivre,idmembre,note) VALUES ('1206QIQA','30',2);
INSERT INTO note (idlivre,idmembre,note) VALUES ('4919FFEF','15',1);
INSERT INTO note (idlivre,idmembre,note) VALUES ('1920RLTY','15',2);
INSERT INTO note (idlivre,idmembre,note) VALUES ('6154PANB','5',2);
INSERT INTO note (idlivre,idmembre,note) VALUES ('7658MNLK','15',4);
INSERT INTO note (idlivre,idmembre,note) VALUES ('1956JJSS','7',5);
INSERT INTO note (idlivre,idmembre,note) VALUES ('0228PRAZ','30',5);
INSERT INTO note (idlivre,idmembre,note) VALUES ('4919FFEF','21',4);
INSERT INTO note (idlivre,idmembre,note) VALUES ('4021QRPO','30',5);
INSERT INTO note (idlivre,idmembre,note) VALUES ('7089PQIU','15',2);
INSERT INTO note (idlivre,idmembre,note) VALUES ('4021QRPO','2',1);
INSERT INTO note (idlivre,idmembre,note) VALUES ('1920RLTY','2',5);
INSERT INTO note (idlivre,idmembre,note) VALUES ('1920RLTY','5',4);
INSERT INTO note (idlivre,idmembre,note) VALUES ('0056561U','15',3);
INSERT INTO note (idlivre,idmembre,note) VALUES ('0228PRAZ','15',3);
INSERT INTO note (idlivre,idmembre,note) VALUES ('6154PANB','21',3);
INSERT INTO note (idlivre,idmembre,note) VALUES ('4021QRPO','7',2);
INSERT INTO note (idlivre,idmembre,note) VALUES ('0228PRAZ','7',1);
INSERT INTO note (idlivre,idmembre,note) VALUES ('4021QRPO','15',1);
INSERT INTO note (idlivre,idmembre,note) VALUES ('1920RLTY','21',1);
INSERT INTO note (idlivre,idmembre,note) VALUES ('056G667X','2',3);
INSERT INTO note (idlivre,idmembre,note) VALUES ('056G667X','7',1);
INSERT INTO note (idlivre,idmembre,note) VALUES ('7658MNLK','2',1);
INSERT INTO note (idlivre,idmembre,note) VALUES ('056G667X','15',1);
INSERT INTO note (idlivre,idmembre,note) VALUES ('0056561U','5',2);
INSERT INTO note (idlivre,idmembre,note) VALUES ('6154PANB','2',2);
INSERT INTO note (idlivre,idmembre,note) VALUES ('0228PRAZ','2',3);
INSERT INTO note (idlivre,idmembre,note) VALUES ('7089PQIU','30',2);
INSERT INTO note (idlivre,idmembre,note) VALUES ('056G667X','30',2);
INSERT INTO note (idlivre,idmembre,note) VALUES ('1956JJSS','21',4);
INSERT INTO note (idlivre,idmembre,note) VALUES ('6154PANB','30',2);
INSERT INTO note (idlivre,idmembre,note) VALUES ('0056561U','21',3);