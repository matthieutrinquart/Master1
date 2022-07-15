
create table utilisateur (
id_user             INT                 not null,
constraint PK_USER primary key (id_user)
);


CREATE TABLE Follow (
id_user1 INT not null,  
id_user2 INT not null, 
CONSTRAINT PK_Follow PRIMARY KEY (id_user1, id_user2) , 
CONSTRAINT FK_Follow_user1 FOREIGN KEY (id_user1) REFERENCES utilisateur (id_user) , 
CONSTRAINT FK_Follow_user2 FOREIGN KEY (id_user2) REFERENCES utilisateur (id_user) );


create table photographie (
id_photographie             INT                  null,
id_user             INT                  null,
nb_enregistrememnt               INT                  null,
coordonné               INT                  null,
code               INT                  null,
licence               varchar(50)                  null,
constraint PK_photographie primary key (id_photographie),
CONSTRAINT FK_photographie FOREIGN KEY (id_user) REFERENCES utilisateur (id_user)
);


create table appareil_photo (
id_photographie             INT                 not null,
id_appareil_photo             INT                 not  null,
constraint PK_appareil_photo primary key (id_appareil_photo , id_photographie),
CONSTRAINT FK_appareil_photo FOREIGN KEY (id_photographie) REFERENCES photographie (id_photographie)
);


create table configurations (
id_configurations             INT                 not null,
id_appareil_photo             INT                 not  null,
ouverture_focal                INT             null,
temps_exposition                INT            null,
flash                           boolean         null,
distance_focal                  INT                    null,
constraint PK_configurations primary key (id_appareil_photo , id_configurations),
CONSTRAINT FK_configurations FOREIGN KEY (id_appareil_photo) REFERENCES appareil_photo (id_appareil_photo)
);

create table discution (
id_discution             INT                 not null,
id_photographie              INT                 not  null,
constraint PK_discution primary key ( id_discution),
CONSTRAINT FK_discution FOREIGN KEY (id_photographie) REFERENCES appareil_photo (id_photographie)
);

create table commentaire (
id_discution             INT                 not null,
id_user                 INT                    not null,
id_commentaire              INT                 not  null,
texte                       varchar(50)                 not null,
CONSTRAINT PK_commentaire primary key (id_commentaire),
CONSTRAINT FK_commentaire FOREIGN KEY (id_discution) REFERENCES discution (id_discution),
CONSTRAINT FK_user FOREIGN KEY (id_user) REFERENCES utilisateur (id_user)
);

create table balise (
id_balise             INT                 not null,
tag               varchar(50)                  null,
mot_cles               varchar(50)                  null,
constraint PK_balise primary key (id_balise)
);


CREATE TABLE likes (
id_user INT null,  
id_photographie INT null, 
CONSTRAINT PK_likes PRIMARY KEY (id_user, id_photographie) , 
CONSTRAINT FK_likes_user FOREIGN KEY (id_user) REFERENCES utilisateur (id_user) , 
CONSTRAINT FK_likes_photographie FOREIGN KEY (id_photographie) REFERENCES photographie (id_photographie) );


CREATE TABLE album (
id_album INT  null, 
id_user INT null, 
CONSTRAINT PK_album PRIMARY KEY (id_album) ,
CONSTRAINT FK_album_user FOREIGN KEY (id_user) REFERENCES utilisateur (id_user)
);

CREATE TABLE ALBUM_USER_PHOTO (
id_album INT  null,  
id_user INT null,
id_photographie INT null,  
CONSTRAINT PK_ALBUM_USER_PHOTO PRIMARY KEY (id_album,id_user,id_photographie) , 
CONSTRAINT FK_ALBUM_USER_PHOTO_user FOREIGN KEY (id_user) REFERENCES utilisateur (id_user),
CONSTRAINT FK_ALBUM_USER_PHOTO_album FOREIGN KEY (id_album) REFERENCES album (id_album),
CONSTRAINT FK_ALBUM_USER_PHOTO_photographie FOREIGN KEY (id_photographie) REFERENCES photographie (id_photographie) 
 );


CREATE TABLE galerie (
id_galerie INT  null, 
id_user INT null, 
CONSTRAINT PK_galerie PRIMARY KEY (id_galerie),
CONSTRAINT FK_galerie_user FOREIGN KEY (id_user) REFERENCES utilisateur (id_user)
 );

CREATE TABLE GALERIE_USER_PHOTO (
id_galerie INT  null,  
id_user INT null,
id_photographie INT null,  
CONSTRAINT PK_GALERIE_USER_PHOTO PRIMARY KEY (id_galerie,id_user,id_photographie) , 
CONSTRAINT FK_GALERIE_USER_PHOTO_user FOREIGN KEY (id_user) REFERENCES utilisateur (id_user),
CONSTRAINT FK_GALERIE_USER_PHOTO_galerie FOREIGN KEY (id_galerie) REFERENCES galerie (id_galerie),
CONSTRAINT FK_GALERIE_USER_PHOTO_photographie FOREIGN KEY (id_photographie) REFERENCES photographie (id_photographie) 
);


CREATE TABLE marque (
id_photographie INT  null,  
id_balise INT null, 
CONSTRAINT PK_GALERIE_USER_PHOTO PRIMARY KEY (id_photographie,id_balise) , 
CONSTRAINT FK_marque_photographie FOREIGN KEY (id_photographie) REFERENCES photographie (id_photographie),
CONSTRAINT FK_marque_balise FOREIGN KEY (id_balise) REFERENCES balise (id_balise)
);






INSERT INTO utilisateur (id_user) VALUES(1);
INSERT INTO utilisateur (id_user) VALUES(2);
INSERT INTO utilisateur (id_user) VALUES(3);
INSERT INTO utilisateur (id_user) VALUES(4);
INSERT INTO utilisateur (id_user) VALUES(5);

INSERT INTO Follow(id_user1,id_user2) VALUES(1,2);
INSERT INTO Follow(id_user1,id_user2) VALUES(2,1);
INSERT INTO Follow(id_user1,id_user2) VALUES(3,5);
INSERT INTO Follow(id_user1,id_user2) VALUES(4,2);
INSERT INTO Follow(id_user1,id_user2) VALUES(5,3);

INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(0,1,5,3,4,"tous droits réservés");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(1,1,5,3,4,"licence1");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(2,1,5,3,4,"licence1");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(3,1,5,3,4,"tous droits réservés");


INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(4,1,5,3,4,"tous droits réservés");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(5,1,5,3,4,"licence1");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(6,1,5,3,4,"tous droits réservés");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(7,1,5,3,4,"licence1");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(8,1,5,3,4,"tous droits réservés");



INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(9,2,5,3,4,"tous droits réservés");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(10,2,5,3,4,"licence1");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(11,2,5,3,4,"licence1");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(12,2,5,3,4,"licence1");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(13,2,5,3,4,"tous droits réservés");


INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(14,2,5,3,4,"tous droits réservés");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(15,2,5,3,4,"tous droits réservés");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(16,2,5,3,4,"tous droits réservés");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(17,2,5,3,4,"tous droits réservés");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(18,2,5,3,4,"tous droits réservés");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(19,2,5,3,4,"tous droits réservés");




INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(20,3,5,3,4,"licence1");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(21,3,5,3,4,"licence1");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(22,3,5,3,4,"tous droits réservés");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(23,3,5,3,4,"licence1");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(24,3,5,3,4,"licence1");


INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(25,4,5,3,4,"licence1");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(26,4,5,3,4,"tous droits réservés");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(27,4,5,3,4,"licence1");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(28,4,5,3,4,"tous droits réservés");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(29,4,5,3,4,"licence1");


INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(30,5,5,3,4,"licence1");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(31,5,5,3,4,"licence1");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(32,5,5,3,4,"tous droits réservés");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(33,5,5,3,4,"tous droits réservés");
INSERT INTO photographie(id_photographie,id_user,nb_enregistrememnt,coordonné,code,licence) VALUES(34,5,5,3,4,"licence1");

INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(0,0);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(1,0);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(2,0);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(3,0);





INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(4,1);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(5,1);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(6,1);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(7,1);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(8,1);



INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(9,2);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(10,2);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(11,2);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(12,2);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(13,2);



INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(14,3);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(15,3);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(16,4);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(17,4);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(18,4);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(19,4);


INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(20,3);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(21,3);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(22,3);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(23,3);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(24,3);



INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(25,5);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(26,5);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(27,5);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(28,5);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(29,6);


INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(30,6);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(31,6);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(32,6);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(33,6);
INSERT INTO appareil_photo(id_photographie,id_appareil_photo)VALUES(34,6);



INSERT INTO configurations(id_configurations,id_appareil_photo,ouverture_focal,temps_exposition,flash,distance_focal)VALUES(0,0,65,10,TRUE,50);
INSERT INTO configurations(id_configurations,id_appareil_photo,ouverture_focal,temps_exposition,flash,distance_focal)VALUES(1,0,65,10,TRUE,50);
INSERT INTO configurations(id_configurations,id_appareil_photo,ouverture_focal,temps_exposition,flash,distance_focal)VALUES(2,0,65,10,TRUE,50);

INSERT INTO configurations(id_configurations,id_appareil_photo,ouverture_focal,temps_exposition,flash,distance_focal)VALUES(3,1,65,10,TRUE,50);
INSERT INTO configurations(id_configurations,id_appareil_photo,ouverture_focal,temps_exposition,flash,distance_focal)VALUES(4,1,65,10,TRUE,50);
INSERT INTO configurations(id_configurations,id_appareil_photo,ouverture_focal,temps_exposition,flash,distance_focal)VALUES(5,1,65,10,TRUE,50);

INSERT INTO configurations(id_configurations,id_appareil_photo,ouverture_focal,temps_exposition,flash,distance_focal)VALUES(6,2,65,10,TRUE,50);
INSERT INTO configurations(id_configurations,id_appareil_photo,ouverture_focal,temps_exposition,flash,distance_focal)VALUES(7,2,65,10,TRUE,50);
INSERT INTO configurations(id_configurations,id_appareil_photo,ouverture_focal,temps_exposition,flash,distance_focal)VALUES(8,2,65,10,TRUE,50);

INSERT INTO configurations(id_configurations,id_appareil_photo,ouverture_focal,temps_exposition,flash,distance_focal)VALUES(9,3,65,10,TRUE,50);
INSERT INTO configurations(id_configurations,id_appareil_photo,ouverture_focal,temps_exposition,flash,distance_focal)VALUES(10,3,65,10,TRUE,50);
INSERT INTO configurations(id_configurations,id_appareil_photo,ouverture_focal,temps_exposition,flash,distance_focal)VALUES(11,3,65,10,TRUE,50);

INSERT INTO configurations(id_configurations,id_appareil_photo,ouverture_focal,temps_exposition,flash,distance_focal)VALUES(12,4,65,10,TRUE,50);
INSERT INTO configurations(id_configurations,id_appareil_photo,ouverture_focal,temps_exposition,flash,distance_focal)VALUES(13,4,65,10,TRUE,50);
INSERT INTO configurations(id_configurations,id_appareil_photo,ouverture_focal,temps_exposition,flash,distance_focal)VALUES(14,4,65,10,TRUE,50);

INSERT INTO configurations(id_configurations,id_appareil_photo,ouverture_focal,temps_exposition,flash,distance_focal)VALUES(15,5,65,10,TRUE,50);
INSERT INTO configurations(id_configurations,id_appareil_photo,ouverture_focal,temps_exposition,flash,distance_focal)VALUES(16,5,65,10,TRUE,50);
INSERT INTO configurations(id_configurations,id_appareil_photo,ouverture_focal,temps_exposition,flash,distance_focal)VALUES(17,5,65,10,TRUE,50);



INSERT INTO configurations(id_configurations,id_appareil_photo,ouverture_focal,temps_exposition,flash,distance_focal)VALUES(17,6,65,10,TRUE,50);
INSERT INTO configurations(id_configurations,id_appareil_photo,ouverture_focal,temps_exposition,flash,distance_focal)VALUES(18,6,65,10,TRUE,50);
INSERT INTO configurations(id_configurations,id_appareil_photo,ouverture_focal,temps_exposition,flash,distance_focal)VALUES(19,6,65,10,TRUE,50);


INSERT INTO balise(id_balise,tag,mot_cles)VALUES(0,"c'est un tag","c'est un mot cles");
INSERT INTO balise(id_balise,tag,mot_cles)VALUES(1,"c'est un tag","c'est un mot cles");
INSERT INTO balise(id_balise,tag,mot_cles)VALUES(2,"c'est un tag","c'est un mot cles");
INSERT INTO balise(id_balise,tag,mot_cles)VALUES(3,"c'est un tag","c'est un mot cles");


INSERT INTO balise(id_balise,tag,mot_cles)VALUES(4,"c'est un tag","c'est un mot cles");
INSERT INTO balise(id_balise,tag,mot_cles)VALUES(5,"c'est un tag","c'est un mot cles");
INSERT INTO balise(id_balise,tag,mot_cles)VALUES(6,"c'est un tag","c'est un mot cles");
INSERT INTO balise(id_balise,tag,mot_cles)VALUES(7,"c'est un tag","c'est un mot cles");




INSERT INTO marque(id_photographie,id_balise)VALUES(34,1);
INSERT INTO marque(id_photographie,id_balise)VALUES(34,2);
INSERT INTO marque(id_photographie,id_balise)VALUES(33,2);
INSERT INTO marque(id_photographie,id_balise)VALUES(34,3);
INSERT INTO marque(id_photographie,id_balise)VALUES(34,4);
INSERT INTO marque(id_photographie,id_balise)VALUES(34,5);
INSERT INTO marque(id_photographie,id_balise)VALUES(34,6);
INSERT INTO marque(id_photographie,id_balise)VALUES(34,7);





INSERT INTO galerie(id_galerie,id_user)VALUES(0,1);
INSERT INTO galerie(id_galerie,id_user)VALUES(1,1);
INSERT INTO galerie(id_galerie,id_user)VALUES(2,2);
INSERT INTO galerie(id_galerie,id_user)VALUES(3,2);

INSERT INTO galerie(id_galerie,id_user)VALUES(4,3);
INSERT INTO galerie(id_galerie,id_user)VALUES(5,3);
INSERT INTO galerie(id_galerie,id_user)VALUES(6,4);
INSERT INTO galerie(id_galerie,id_user)VALUES(7,4);

INSERT INTO galerie(id_galerie,id_user)VALUES(8,4);
INSERT INTO galerie(id_galerie,id_user)VALUES(9,4);
INSERT INTO galerie(id_galerie,id_user)VALUES(10,5);
INSERT INTO galerie(id_galerie,id_user)VALUES(11,5);
INSERT INTO galerie(id_galerie,id_user)VALUES(12,5);



INSERT INTO album(id_album,id_user)VALUES(0,1);
INSERT INTO album(id_album,id_user)VALUES(1,1);
INSERT INTO album(id_album,id_user)VALUES(2,2);
INSERT INTO album(id_album,id_user)VALUES(3,2);

INSERT INTO album(id_album,id_user)VALUES(4,3);
INSERT INTO album(id_album,id_user)VALUES(5,3);
INSERT INTO album(id_album,id_user)VALUES(6,4);
INSERT INTO album(id_album,id_user)VALUES(7,4);

INSERT INTO album(id_album,id_user)VALUES(8,4);
INSERT INTO album(id_album,id_user)VALUES(9,4);
INSERT INTO album(id_album,id_user)VALUES(10,5);
INSERT INTO album(id_album,id_user)VALUES(11,5);
INSERT INTO album(id_album,id_user)VALUES(12,5);


INSERT INTO GALERIE_USER_PHOTO(id_galerie,id_user,id_photographie)VALUES(0,1,0);
INSERT INTO GALERIE_USER_PHOTO(id_galerie,id_user,id_photographie)VALUES(0,1,1);
INSERT INTO GALERIE_USER_PHOTO(id_galerie,id_user,id_photographie)VALUES(0,1,2);



INSERT INTO GALERIE_USER_PHOTO(id_galerie,id_user,id_photographie)VALUES(1,2,3);
INSERT INTO GALERIE_USER_PHOTO(id_galerie,id_user,id_photographie)VALUES(1,2,4);
INSERT INTO GALERIE_USER_PHOTO(id_galerie,id_user,id_photographie)VALUES(2,2,5);




INSERT INTO GALERIE_USER_PHOTO(id_galerie,id_user,id_photographie)VALUES(3,3,5);
INSERT INTO GALERIE_USER_PHOTO(id_galerie,id_user,id_photographie)VALUES(3,3,4);
INSERT INTO GALERIE_USER_PHOTO(id_galerie,id_user,id_photographie)VALUES(4,3,7);



INSERT INTO GALERIE_USER_PHOTO(id_galerie,id_user,id_photographie)VALUES(5,4,15);
INSERT INTO GALERIE_USER_PHOTO(id_galerie,id_user,id_photographie)VALUES(6,4,33);
INSERT INTO GALERIE_USER_PHOTO(id_galerie,id_user,id_photographie)VALUES(6,4,32);




INSERT INTO GALERIE_USER_PHOTO(id_galerie,id_user,id_photographie)VALUES(7,5,0);
INSERT INTO GALERIE_USER_PHOTO(id_galerie,id_user,id_photographie)VALUES(7,5,1);
INSERT INTO GALERIE_USER_PHOTO(id_galerie,id_user,id_photographie)VALUES(7,5,2);





INSERT INTO ALBUM_USER_PHOTO(id_album,id_user,id_photographie)VALUES(0,1,0);
INSERT INTO ALBUM_USER_PHOTO(id_album,id_user,id_photographie)VALUES(0,1,1);
INSERT INTO ALBUM_USER_PHOTO(id_album,id_user,id_photographie)VALUES(0,1,2);



INSERT INTO ALBUM_USER_PHOTO(id_album,id_user,id_photographie)VALUES(1,2,3);
INSERT INTO ALBUM_USER_PHOTO(id_album,id_user,id_photographie)VALUES(1,2,4);
INSERT INTO ALBUM_USER_PHOTO(id_album,id_user,id_photographie)VALUES(2,2,5);




INSERT INTO ALBUM_USER_PHOTO(id_album,id_user,id_photographie)VALUES(3,3,5);
INSERT INTO ALBUM_USER_PHOTO(id_album,id_user,id_photographie)VALUES(3,3,4);
INSERT INTO ALBUM_USER_PHOTO(id_album,id_user,id_photographie)VALUES(4,3,7);



INSERT INTO ALBUM_USER_PHOTO(id_album,id_user,id_photographie)VALUES(5,4,15);
INSERT INTO ALBUM_USER_PHOTO(id_album,id_user,id_photographie)VALUES(6,4,33);
INSERT INTO ALBUM_USER_PHOTO(id_album,id_user,id_photographie)VALUES(6,4,32);




INSERT INTO ALBUM_USER_PHOTO(id_album,id_user,id_photographie)VALUES(7,5,0);
INSERT INTO ALBUM_USER_PHOTO(id_album,id_user,id_photographie)VALUES(7,5,1);
INSERT INTO ALBUM_USER_PHOTO(id_album,id_user,id_photographie)VALUES(7,5,2);




INSERT INTO discution(id_discution,id_photographie)VALUES(0,0);
INSERT INTO discution(id_discution,id_photographie)VALUES(1,1);
INSERT INTO discution(id_discution,id_photographie)VALUES(2,1);
INSERT INTO discution(id_discution,id_photographie)VALUES(3,5);
INSERT INTO discution(id_discution,id_photographie)VALUES(4,12);
INSERT INTO discution(id_discution,id_photographie)VALUES(5,12);
INSERT INTO discution(id_discution,id_photographie)VALUES(6,32);




INSERT INTO commentaire(id_discution,id_user,id_commentaire,texte)VALUES(0,1,0,"CECI EST UN COMMENTAIRE");
INSERT INTO commentaire(id_discution,id_user,id_commentaire,texte)VALUES(0,1,1,"CECI EST UN COMMENTAIRE");
INSERT INTO commentaire(id_discution,id_user,id_commentaire,texte)VALUES(1,1,2,"CECI EST UN COMMENTAIRE");
INSERT INTO commentaire(id_discution,id_user,id_commentaire,texte)VALUES(1,2,3,"CECI EST UN COMMENTAIRE");
INSERT INTO commentaire(id_discution,id_user,id_commentaire,texte)VALUES(1,1,4,"CECI EST UN COMMENTAIRE");
INSERT INTO commentaire(id_discution,id_user,id_commentaire,texte)VALUES(2,1,5,"CECI EST UN COMMENTAIRE");
INSERT INTO commentaire(id_discution,id_user,id_commentaire,texte)VALUES(2,1,6,"CECI EST UN COMMENTAIRE");
INSERT INTO commentaire(id_discution,id_user,id_commentaire,texte)VALUES(2,4,7,"CECI EST UN COMMENTAIRE");
INSERT INTO commentaire(id_discution,id_user,id_commentaire,texte)VALUES(2,4,8,"CECI EST UN COMMENTAIRE");






INSERT INTO likes(id_user,id_photographie)VALUES(1,25);
INSERT INTO likes(id_user,id_photographie)VALUES(1,30);
INSERT INTO likes(id_user,id_photographie)VALUES(1,20);
INSERT INTO likes(id_user,id_photographie)VALUES(1,12);
INSERT INTO likes(id_user,id_photographie)VALUES(1,6);
INSERT INTO likes(id_user,id_photographie)VALUES(1,10);
INSERT INTO likes(id_user,id_photographie)VALUES(1,16);
INSERT INTO likes(id_user,id_photographie)VALUES(2,25);
INSERT INTO likes(id_user,id_photographie)VALUES(2,29);
INSERT INTO likes(id_user,id_photographie)VALUES(2,28);
INSERT INTO likes(id_user,id_photographie)VALUES(2,27);
INSERT INTO likes(id_user,id_photographie)VALUES(2,26);
INSERT INTO likes(id_user,id_photographie)VALUES(2,24);
INSERT INTO likes(id_user,id_photographie)VALUES(2,23);
INSERT INTO likes(id_user,id_photographie)VALUES(2,22);
INSERT INTO likes(id_user,id_photographie)VALUES(2,21);
INSERT INTO likes(id_user,id_photographie)VALUES(3,25);
INSERT INTO likes(id_user,id_photographie)VALUES(3,20);
INSERT INTO likes(id_user,id_photographie)VALUES(3,19);
INSERT INTO likes(id_user,id_photographie)VALUES(3,18);
INSERT INTO likes(id_user,id_photographie)VALUES(3,17);
INSERT INTO likes(id_user,id_photographie)VALUES(3,16);
INSERT INTO likes(id_user,id_photographie)VALUES(3,15);
INSERT INTO likes(id_user,id_photographie)VALUES(3,14);
INSERT INTO likes(id_user,id_photographie)VALUES(4,25);
INSERT INTO likes(id_user,id_photographie)VALUES(4,13);
INSERT INTO likes(id_user,id_photographie)VALUES(4,12);
INSERT INTO likes(id_user,id_photographie)VALUES(4,11);
INSERT INTO likes(id_user,id_photographie)VALUES(4,10);
INSERT INTO likes(id_user,id_photographie)VALUES(4,9);
INSERT INTO likes(id_user,id_photographie)VALUES(4,8);
INSERT INTO likes(id_user,id_photographie)VALUES(4,7);
INSERT INTO likes(id_user,id_photographie)VALUES(4,6);
INSERT INTO likes(id_user,id_photographie)VALUES(4,5);
INSERT INTO likes(id_user,id_photographie)VALUES(4,4);
INSERT INTO likes(id_user,id_photographie)VALUES(4,3);
INSERT INTO likes(id_user,id_photographie)VALUES(5,25);
INSERT INTO likes(id_user,id_photographie)VALUES(5,2);
INSERT INTO likes(id_user,id_photographie)VALUES(5,1);
INSERT INTO likes(id_user,id_photographie)VALUES(5,34);
INSERT INTO likes(id_user,id_photographie)VALUES(5,33);
INSERT INTO likes(id_user,id_photographie)VALUES(5,32);
INSERT INTO likes(id_user,id_photographie)VALUES(5,31);
INSERT INTO likes(id_user,id_photographie)VALUES(5,30);
INSERT INTO likes(id_user,id_photographie)VALUES(5,29);
INSERT INTO likes(id_user,id_photographie)VALUES(5,28);
INSERT INTO likes(id_user,id_photographie)VALUES(5,27);
INSERT INTO likes(id_user,id_photographie)VALUES(5,26);
INSERT INTO likes(id_user,id_photographie)VALUES(5,24);
INSERT INTO likes(id_user,id_photographie)VALUES(5,23);

INSERT INTO likes(id_user,id_photographie)VALUES(2,6);
INSERT INTO likes(id_user,id_photographie)VALUES(3,6);
INSERT INTO likes(id_user,id_photographie)VALUES(4,6);
INSERT INTO likes(id_user,id_photographie)VALUES(5,6);


1)
(Liste des photo d un utilisateur en fonction de son id)
select *
from photographie
where 2= id_user

(galerie d un utilisateur)
select *
from galerie
where 2= id_user

(photographie d une galerie qui n appartiennent pas a l utilisateur de cette galerie)
SELECT p.id_photographie , p.id_user , nb_enregistrememnt,coordonné,code ,licence FROM utilisateur INNER JOIN GALERIE_USER_PHOTO L ON utilisateur.id_user=L.id_user INNER JOIN photographie P ON L.id_photographie=P.id_photographie
where utilisateur.id_user != P.id_user 
2)

select p.id_photographie , p.id_user , nb_enregistrememnt,coordonné,code ,licence
from likes l INNER JOIN photographie p on l.id_photographie = p.id_photographie 
where p.licence like "tous droits réservés" GROUP BY l.id_photographie ORDER BY COUNT(l.id_photographie) DESC LIMIT 1


3)
select *
from photographie
where  id_photographie=(SELECT id_photographie FROM GALERIE_USER_PHOTO GROUP BY id_photographie ORDER BY COUNT(id_photographie) DESC LIMIT 1)