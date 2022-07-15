CREATE TABLE Balise(
    id_balise NUMBER PRIMARY KEY UNIQUE NOT NULL,
    tag varchar,
    mot_cles varchar

)

CREATE TABLE collection_photo(
    id_collection_photo NUMBER PRIMARY KEY UNIQUE NOT NULL,

)

CREATE TABLE galerie(

) INHERITS (collection_photo);

CREATE TABLE album(

) INHERITS (collection_photo);


CREATE TABLE contenu_numerique(
    id_contenu_numerique NUMBER PRIMARY KEY UNIQUE NOT NULL,

)
CREATE TABLE utilisateur(
id_user NUMBER PRIMARY KEY UNIQUE NOT NULL,

Appareil_photo(row(
    id_Appareil_photo NUMBER PRIMARY KEY UNIQUE NOT NULL,

    configurations (row(
    ouverture_focal NUMBER,
    temps_exposition NUMBER,
    flash boolean,
    distance_focal NUMBER));
))

)



