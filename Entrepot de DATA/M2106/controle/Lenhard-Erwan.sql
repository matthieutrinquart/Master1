/* Controle 3 - Base de données - Lenhard Erwan */

-- Partie 1
-- 1
CREATE OR REPLACE FUNCTION poids_prod(refProd varchar) RETURNS INTEGER AS $$
    DECLARE
        produit produits%ROWTYPE;
    BEGIN
        SELECT * INTO produit FROM produits WHERE ref LIKE refProd;
        IF NOT FOUND
            THEN RAISE EXCEPTION 'le produit ref % n''existe pas', refProd;
        END IF;
        IF produit.descriptif = 'G'
            THEN RETURN produit.qte;
        ELSEIF produit.descriptif = 'P'
            THEN RETURN produit.qte * produit.poidspiece;
        END IF;
    END; $$
LANGUAGE plpgsql;

SELECT poids_prod('4004'); -- 1000
SELECT poids_prod('1004'); -- 500
SELECT poids_prod('10004'); -- ERROR:  le produit ref 10004 n'existe pas


-- 2
CREATE OR REPLACE FUNCTION CA_vendeur(v_nom varchar, v_date integer) RETURNS FLOAT AS $$
    DECLARE
        vendeur vendeurs%ROWTYPE;
        montant_HT FLOAT := 0;
        montant_TVA FLOAT := 0;
    BEGIN
        SELECT * INTO vendeur FROM vendeurs WHERE nomvendeur LIKE v_nom;
        IF NOT FOUND
            THEN RAISE EXCEPTION 'le client % n''existe pas', v_nom;
        END IF;
        SELECT COALESCE(sum(totht),0), COALESCE(sum(tottva),0)
            INTO montant_HT, montant_TVA 
            FROM commandes 
            WHERE codevendeur = vendeur.codevendeur 
                AND extract(year from datecmde) = v_date;
        RETURN montant_HT + montant_TVA;
    END; $$
LANGUAGE plpgsql;

SELECT CA_vendeur('BAUDOT', 1998); -- 734
SELECT CA_vendeur('FILLARD', 1998); -- 1222
SELECT CA_vendeur('CARMI', 1998); -- ERROR:  le client CARMI n'existe pas
SELECT CA_vendeur('FILLARD', 2000); -- 0


-- 3
CREATE OR REPLACE FUNCTION info_stock(refProd varchar) RETURNS RECORD AS $$
    DECLARE
        produit produits%ROWTYPE;
        info RECORD;
    BEGIN
        SELECT * INTO produit FROM produits WHERE ref LIKE refProd;
        IF NOT FOUND
            THEN RAISE EXCEPTION 'le produit ref % n''existe pas', refProd;
        END IF;
        SELECT (SELECT poids_prod(refProd)), stock*puht, puht --J'ai pas compris le prix moyen au kilo du stock
            INTO info
            FROM produits 
            WHERE ref = refProd;
        RETURN info;
    END; $$
LANGUAGE plpgsql;

SELECT * FROM info_stock('4004') 
    AS (poid_stock INTEGER, prix_stock FLOAT, prix_au_kilo FLOAT); 
    -- 1000, 1050, 21
SELECT * FROM info_stock('1004') 
    AS (poid_stock INTEGER, prix_stock FLOAT, prix_au_kilo FLOAT); 
    -- 500, 1150, 23
SELECT * FROM info_stock('12004') 
    AS (poid_stock INTEGER, prix_stock FLOAT, prix_au_kilo FLOAT);
    -- ERROR:  le produit ref 12004 n'existe pas



-- Partie 2
-- 1
CREATE OR REPLACE FUNCTION add_cmd_line() RETURNS trigger AS $$
    BEGIN
        IF NEW.ref NOT IN (SELECT ref FROM produits)
            THEN RAISE EXCEPTION 'le produit ref % n''existe pas', NEW.ref;
        END IF;
        IF NEW.numcmde NOT IN (SELECT numcmde FROM commandes)
            THEN RAISE EXCEPTION 'la commande numero % n''existe pas', NEW.numcmde;
        END IF;
        IF NEW.ref IN (SELECT ref FROM lignes_commande WHERE numcmde = NEW.numcmde)
            THEN RAISE EXCEPTION 'le produit ref % existe deja dans la commande numero %.', NEW.ref, NEW.numcmde;
        END IF;
        IF NEW.qtdemande > (SELECT stock FROM produits WHERE ref = NEW.ref)
            THEN RAISE EXCEPTION 'La quantite du stock est insuffisant';
        END IF;
        
        UPDATE produits SET stock=stock-NEW.qtdemande WHERE ref = NEW.ref;
        NEW.numligne := (SELECT max(numligne)+1 from lignes_commande);

        UPDATE commandes SET TotHT = TotHT+(NEW.qtdemande*(SELECT PUHT FROM produits WHERE ref = NEW.ref)) WHERE numcmde = NEW.numcmde;
        UPDATE commandes SET TotTVA = (SELECT TotHT FROM commandes WHERE numcmde = NEW.numcmde)*0.2 WHERE numcmde = NEW.numcmde;

        RETURN NEW;
    END; $$
LANGUAGE plpgsql;

CREATE TRIGGER trig_insert_lig_cde BEFORE INSERT
ON lignes_commande FOR EACH ROW 
EXECUTE PROCEDURE add_cmd_line();

-- test
SELECT * FROM lignes_commande WHERE numcmde= 10178; --avant
INSERT INTO lignes_commande VALUES(10178,0,'1004',5); -- Insertion
SELECT * FROM lignes_commande WHERE numcmde= 10178; -- après



-- 2
CREATE OR REPLACE FUNCTION del_cmd_line() RETURNS trigger AS $$
    DECLARE
        ligne_cmd lignes_commande%ROWTYPE;
    BEGIN
        UPDATE produits SET stock=stock+OLD.qtdemande WHERE ref = OLD.ref;

        UPDATE commandes SET TotHT = TotHT-(OLD.qtdemande*(SELECT PUHT FROM produits WHERE ref = OLD.ref)) WHERE numcmde = OLD.numcmde;
        UPDATE commandes SET TotTVA = (SELECT TotHT FROM commandes WHERE numcmde = OLD.numcmde)*0.2 WHERE numcmde = OLD.numcmde;

        RETURN NEW;
    END; $$
LANGUAGE plpgsql;

CREATE TRIGGER trig_delete_lig_cde BEFORE INSERT
ON lignes_commande FOR EACH ROW 
EXECUTE PROCEDURE del_cmd_line();

-- test
SELECT * FROM lignes_commande WHERE numcmde= 10178; --avant
DELETE FROM lignes_commande WHERE numcmde=10178 AND numligne=8; -- Insertion
SELECT * FROM lignes_commande WHERE numcmde= 10178; -- après