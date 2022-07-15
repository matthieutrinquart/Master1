-- ==============================================================*/                      */
--  Date de crÚation :  06/11/2008 13:32:50                      */
-- ==============================================================*/

create schema film;
set search_path=film;
-- ==============================================================*/
--  Table : cinema                                               */
-- ==============================================================*/
create table cinema (
num_cine             INT4                 not null,
nom                  VARCHAR(50)             null,
adresse              VARCHAR(75)             null,
constraint PK_CINEMA primary key (num_cine)
);

-- ==============================================================*/
--  Table : film                                                 */
-- ==============================================================*/
create table film (
num_film             INT4                 not null,
num_ind              INT4                 null,
titre                VARCHAR(100)            null,
genre                VARCHAR(50)             null,
annee                DATE                 null,
constraint PK_FILM primary key (num_film)
);

-- ==============================================================*/
--  Table : individu                                             */
-- ==============================================================*/
create table individu (
num_ind              INT4                 not null,
nom                  VARCHAR(50)             null,
prenom               VARCHAR(50)             null,
constraint PK_INDIVIDU primary key (num_ind)
);

-- ==============================================================*/
--  Table : jouer                                                */
-- ==============================================================*/
create table jouer (
num_ind              INT4                 not null,
num_film             INT4                 not null,
role                 VARCHAR(50)             null,
constraint PK_JOUER primary key (num_ind, num_film)
);

-- ==============================================================*/
--  Table : projection                                           */
-- ==============================================================*/
create table projection (
num_cine             INT4                 not null,
num_film             INT4                 not null,
date                 DATE                 null,
constraint PK_PROJECTION primary key (num_cine, num_film,date)
);

alter table film
   add constraint FK_FILM_REFERENCE_INDIVIDU foreign key (num_ind)
      references individu (num_ind)
      on delete restrict on update restrict;

alter table jouer
   add constraint FK_JOUER_REFERENCE_FILM foreign key (num_film)
      references film (num_film)
      on delete restrict on update restrict;

alter table jouer
   add constraint FK_JOUER_REFERENCE_INDIVIDU foreign key (num_ind)
      references individu (num_ind)
      on delete restrict on update restrict;

alter table projection
   add constraint FK_PROJECTI_REFERENCE_CINEMA foreign key (num_cine)
      references cinema (num_cine)
      on delete restrict on update restrict;

alter table projection
   add constraint FK_PROJECTI_REFERENCE_FILM foreign key (num_film)
      references film (num_film)
      on delete restrict on update restrict;



-- Base de donnÚes: 'film'
--

--
-- Contenu de la table 'cinema'
--

INSERT INTO cinema (num_cine, nom, adresse) VALUES(1, 'Le Renoir', '13100 Aix-en-Provence');
INSERT INTO cinema (num_cine, nom, adresse) VALUES(2, 'Le Fontenelle', '78160 Marly-le-Roi');
INSERT INTO cinema (num_cine, nom, adresse) VALUES(3, 'Gaumont Wilson', '31000 Toulouse');
INSERT INTO cinema (num_cine, nom, adresse) VALUES(4, 'Espace Cin', '93800 Epinay-sur-Seine');
--
-- Contenu de la table 'individu'
--

INSERT INTO individu (num_ind, nom, prenom) VALUES(1, 'Kidman', 'Nicole');
INSERT INTO individu (num_ind, nom, prenom) VALUES(2, 'Bettany', 'Paul');
INSERT INTO individu (num_ind, nom, prenom) VALUES(3, 'Watson', 'Emily');
INSERT INTO individu (num_ind, nom, prenom) VALUES(4, 'Skarsgard', 'Stellan');
INSERT INTO individu (num_ind, nom, prenom) VALUES(5, 'Travolta', 'John');
INSERT INTO individu (num_ind, nom, prenom) VALUES(6, 'L. Jackson', 'Samuel');
INSERT INTO individu (num_ind, nom, prenom) VALUES(7, 'Willis', 'Bruce');
INSERT INTO individu (num_ind, nom, prenom) VALUES(8, 'Irons', 'Jeremy');
INSERT INTO individu (num_ind, nom, prenom) VALUES(9, 'Spader', 'James');
INSERT INTO individu (num_ind, nom, prenom) VALUES(10, 'Hunter', 'Holly');
INSERT INTO individu (num_ind, nom, prenom) VALUES(11, 'Arquette', 'Rosanna');
INSERT INTO individu (num_ind, nom, prenom) VALUES(12, 'Wayne', 'John');
INSERT INTO individu (num_ind, nom, prenom) VALUES(13, 'von Trier', 'Lars');
INSERT INTO individu (num_ind, nom, prenom) VALUES(14, 'Tarantino', 'Quentin');
INSERT INTO individu (num_ind, nom, prenom) VALUES(15, 'Cronenberg', 'David');
INSERT INTO individu (num_ind, nom, prenom) VALUES(16, 'Mazursky', 'Paul');
INSERT INTO individu (num_ind, nom, prenom) VALUES(17, 'Jones', 'Grace');
INSERT INTO individu (num_ind, nom, prenom) VALUES(18, 'Glen', 'John');
--
-- Contenu de la table 'film'
--

INSERT INTO film (num_film, num_ind, titre, genre, annee) VALUES(5, 13, 'Dogville', 'Drame', '2002-06-24');
INSERT INTO film (num_film, num_ind, titre, genre, annee) VALUES(4, 13, 'Breaking the waves', 'Drame', '1996-06-18');
INSERT INTO film (num_film, num_ind, titre, genre, annee) VALUES(3, 14, 'Pulp Fiction', 'Policier', '1994-06-16');
INSERT INTO film (num_film, num_ind, titre, genre, annee) VALUES(2, 15, 'Faux-Semblants', 'Epouvante', '1988-06-10');
INSERT INTO film (num_film, num_ind, titre, genre, annee) VALUES(1, 15, 'Crash', 'Drame', '1996-06-01');
INSERT INTO film (num_film, num_ind, titre, genre, annee) VALUES(6, 12, 'Alamo', 'Western', '1960-05-13');
INSERT INTO film (num_film, num_ind, titre, genre, annee) VALUES(7, 18, 'Dangereusement vôtre', 'Espionnage', '1985-06-07');


--
-- Contenu de la table 'jouer'
--
INSERT INTO jouer (num_ind, num_film, role) VALUES(1, 5, 'Grace');
INSERT INTO jouer (num_ind, num_film, role) VALUES(2, 5, 'Tom Edison');
INSERT INTO jouer (num_ind, num_film, role) VALUES(3, 4, 'Bess');
INSERT INTO jouer (num_ind, num_film, role) VALUES(4, 4, 'Jan');
INSERT INTO jouer (num_ind, num_film, role) VALUES(4, 5, 'Chuck');
INSERT INTO jouer (num_ind, num_film, role) VALUES(5, 3, 'Vincent Vega');
INSERT INTO jouer (num_ind, num_film, role) VALUES(6, 3, 'Jules Winnfield');
INSERT INTO jouer (num_ind, num_film, role) VALUES(7, 3, 'Butch Coolidge');
INSERT INTO jouer (num_ind, num_film, role) VALUES(8, 2, 'Beverly & Elliot Mantle');
INSERT INTO jouer (num_ind, num_film, role) VALUES(9, 1, 'James Ballard');
INSERT INTO jouer (num_ind, num_film, role) VALUES(10, 1, 'Helen Remington');
INSERT INTO jouer (num_ind, num_film, role) VALUES(11, 1, 'Gabrielle');
INSERT INTO jouer (num_ind, num_film, role) VALUES(14, 3, 'Le Mari');
INSERT INTO jouer (num_ind, num_film, role) VALUES(16, 7, 'May Day');

--
-- Contenu de la table 'projection'
--

INSERT INTO projection (num_cine, num_film, date) VALUES(1, 1, '1996-05-07');
INSERT INTO projection (num_cine, num_film, date) VALUES(1, 2, '1988-03-12');
INSERT INTO projection (num_cine, num_film, date) VALUES(1, 4, '1996-08-02');
INSERT INTO projection (num_cine, num_film, date) VALUES(1, 6, '1980-07-05');
INSERT INTO projection (num_cine, num_film, date) VALUES(2, 2, '1990-09-25');
INSERT INTO projection (num_cine, num_film, date) VALUES(2, 4, '1996-09-02');
INSERT INTO projection (num_cine, num_film, date) VALUES(2, 4, '1996-12-02');
INSERT INTO projection (num_cine, num_film, date) VALUES(2, 5, '2002-05-01');
INSERT INTO projection (num_cine, num_film, date) VALUES(2, 5, '2002-05-02');
INSERT INTO projection (num_cine, num_film, date) VALUES(2, 5, '2002-05-03');
INSERT INTO projection (num_cine, num_film, date) VALUES(2, 7, '1985-05-09');
INSERT INTO projection (num_cine, num_film, date) VALUES(3, 3, '1994-11-05');
INSERT INTO projection (num_cine, num_film, date) VALUES(3, 6, '1960-11-09');
INSERT INTO projection (num_cine, num_film, date) VALUES(3, 6, '1990-12-02');
INSERT INTO projection (num_cine, num_film, date) VALUES(4, 3, '1994-04-08');
INSERT INTO projection (num_cine, num_film, date) VALUES(4, 3, '1994-11-06');
INSERT INTO projection (num_cine, num_film, date) VALUES(4, 6, '2002-08-01');
	