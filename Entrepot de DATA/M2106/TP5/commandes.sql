/*              TP5 - triggers et fonction             */

/*1*/
CREATE OR REPLACE FUNCTION listFilm(_nom varchar, _prenom varchar) RETURNS SETOF varchar AS $$
    DECLARE
        film film%ROWTYPE;
    BEGIN
        FOR film IN SELECT * FROM film WHERE idartiste = (SELECT idartiste FROM artiste WHERE prenom LIKE _prenom AND nom LIKE _nom) LOOP
            RETURN NEXT film.titre;
        END LOOP;
        IF film.titre IS NULL
            THEN RAISE EXCEPTION 'Pas de résultat';
        END IF;
    END; $$
LANGUAGE plpgsql;


/*2*/
CREATE OR REPLACE FUNCTION infoFilm(_titre varchar) RETURNS text AS $$ 
    DECLARE
        real artiste%ROWTYPE;
    BEGIN  
        SELECT * INTO real FROM artiste WHERE idartiste = (SELECT idartiste FROM film WHERE titre LIKE _titre);
        IF FOUND
            THEN RETURN real.nom||' '||real.prenom;
            ELSE RAISE EXCEPTION 'Pas de résultat';
        END IF;
    END; $$
LANGUAGE plpgsql;


/*3*/
CREATE OR REPLACE FUNCTION profession(id INTEGER) RETURNS text AS $$ 
    DECLARE
        real artiste%ROWTYPE;
    BEGIN  
        SELECT * INTO real FROM artiste WHERE idartiste = id;
        IF real.idartiste IN (SELECT idartiste FROM film) AND real.idartiste IN (SELECT idartiste FROM role)
            THEN RETURN 'Realisateur et Acteur';
            ELSE IF real.idartiste IN (SELECT idartiste FROM film)
                THEN RETURN 'Realisateur';
                ELSE IF real.idartiste IN (SELECT idartiste FROM role)
                    THEN RETURN 'Acteur';
                    ELSE RAISE EXCEPTION 'Pas de profession';
                END IF;
            END IF;
        END IF;
    END; $$
LANGUAGE plpgsql;

/*4*/
CREATE OR REPLACE FUNCTION add_note() RETURNS trigger AS $$
    BEGIN
        IF NEW.email NOT IN (SELECT email FROM internaute)
            THEN RAISE EXCEPTION 'L''internaute doit avoir un mail !';
        END IF;
        IF NEW.idfilm NOT IN (SELECT idfilm FROM film)
            THEN RAISE EXCEPTION 'Le film n''existe pas';
        END IF;
        IF NEW.email IN (SELECT email FROM notation WHERE idfilm = NEW.idfilm)
            THEN RAISE EXCEPTION 'L''internaute à déjà noté ce film'; 
        END IF;
        RETURN NEW;
    END; $$
LANGUAGE plpgsql;

CREATE TRIGGER add_note BEFORE INSERT OR UPDATE
ON notation FOR EACH ROW 
EXECUTE PROCEDURE add_note();


/*5*/
CREATE OR REPLACE FUNCTION moyenne_note(_titre varchar) RETURNS text AS $$
    DECLARE
        note notation%ROWTYPE;
        nb_note INTEGER := 0;
        notes INTEGER := 0;
    BEGIN 
        FOR note IN SELECT * FROM notation WHERE idfilm = (SELECT idfilm FROM film WHERE titre = _titre) LOOP
            nb_note := nb_note + 1;
            notes := notes + note.note;
        END LOOP;
        IF nb_note = 0  --test si le film à été noté
            THEN RAISE EXCEPTION 'Le film n''a pas encore été noté';
            ELSE RETURN nb_note||' note(s) / '||notes/nb_note;
        END IF;
    END; $$
LANGUAGE plpgsql;

/*6*/
CREATE OR REPLACE FUNCTION change_mail(omail varchar, nmail varchar) RETURNS void AS $$
    DECLARE
        liste varchar;
        nom text := (SELECT conname FROM pg_class PC 
                join pg_namespace PN On PN.oid=PC.relnamespace
                join pg_constraint PCo ON PCo.conrelid=PC.oid
            WHERE nspname='tp_bd_film'and contype='f' and relname='notation'
                and confrelid=(select oid from pg_class where relname='internaute'));
    BEGIN
        UPDATE internaute SET email = nmail WHERE email LIKE (SELECT email FROM internaute WHERE email LIKE omail);
        EXCEPTION
            WHEN foreign_key_violation THEN
                EXECUTE 'ALTER TABLE notation DROP CONSTRAINT '||nom;
                UPDATE internaute SET email = nmail WHERE email LIKE (SELECT email FROM internaute WHERE email LIKE omail);
                FOR liste IN (SELECT email from notation WHERE email = omail) LOOP
                    UPDATE notation SET email = nmail WHERE email=liste;
                END LOOP;
                EXECUTE 'ALTER TABLE notation ADD CONSTRAINT '||nom||' FOREIGN KEY (email) REFERENCES internaute(email)';
    END; $$
LANGUAGE plpgsql;