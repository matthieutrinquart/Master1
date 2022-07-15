/*              entrainement ctrl 3 - triggers              */


--Exercice 1
--1
CREATE OR REPLACE FUNCTION stock_cereale(refCereale varchar) RETURNS INTEGER AS $$
    DECLARE
        stock INTEGER := 0;
    BEGIN
        SELECT sum(qtestock) INTO stock FROM silo WHERE codecereale= refCereale;
        IF stock is NULL
            THEN RAISE EXCEPTION 'la céréale ref % n''existe pas', refCereale;
        END IF;
        RETURN stock;
    END; $$
LANGUAGE plpgsql;

--2
CREATE OR REPLACE FUNCTION verif_contrat(refCereale varchar, qte INTEGER) RETURNS BOOLEAN AS $$
    BEGIN
        RETURN (stock_cereale(refCereale) >= qte);
    END; $$
LANGUAGE plpgsql;

--3
CREATE OR REPLACE FUNCTION ajout_cereale(refCereale VARCHAR,p_qte INTEGER) RETURNS INTEGER AS $$
    DECLARE
        v_qtelibre NUMERIC; -- quantité restante dans le silo courant
        v_qteAstocker NUMERIC; -- quantité à stocker dans le silo courant
        v_qte_restante NUMERIC := p_qte; -- quantité restante à stocker
        v_ref VARCHAR;
        rec_silo silo%ROWTYPE;
        -- création d'un curseur paramétré qui recherche les silos qui stockent la céréale
        -- trié par ordre décroissant (du plus rempli au moins rempli)
        Curs_ListeSilo CURSOR(ref varchar) IS SELECT * FROM silo WHERE codecereale= ref
            ORDER BY qtestock DESC;
    BEGIN
        -- on vérifie que la céréale existe
        SELECT codecereale INTO v_ref FROM cereale WHERE codecereale= refCereale;
        IF NOT found
            THEN RAISE EXCEPTION 'la céréale ref % n''existe pas', refCereale;
        END IF;
        
        OPEN Curs_ListeSilo(refCereale);
        -- parcours du curseur paramétré
        LOOP
            FETCH Curs_ListeSilo INTO rec_silo;
            EXIT WHEN NOT FOUND; -- sort de la boucle si le curseur ne retourne plus rien
            -- calcul de la place qu'il reste dans le silo courant
            IF v_qte_restante > 0
                THEN
                    -- calcul de la place qu'il reste dans le silo courant
                    v_qtelibre:= rec_silo.qtemax - rec_silo.qtestock ;
                    -- si la qte libre est > à la qte restante on ajoute la qte restante
                    -- sinon la quantité libre
                    IF v_qtelibre > v_qte_restante
                        THEN v_qteAstocker := v_qte_restante;
                        ELSE v_qteAstocker := v_qtelibre;
                    END IF;
                    -- mise à jour du silo
                    UPDATE silo
                    SET qtestock = qtestock+ v_qteAstocker
                    WHERE codesilo = rec_silo.codesilo;
                    -- mise à jour de la quantité restante
                    v_qte_restante := v_qte_restante - v_qteAstocker;
                ELSE EXIT; -- on sort si il n’y a plus rien à socker
            END IF;
        END LOOP;
        CLOSE Curs_ListeSilo;
        Return v_qte_restante;
    END; $$
LANGUAGE plpgsql;


--Exercice 2
--1
CREATE OR REPLACE FUNCTION add_contrat() RETURNS trigger AS $$
    BEGIN
        IF NEW.codecereale NOT IN (SELECT codecereale FROM cereale)
            THEN RAISE EXCEPTION 'la céréale ref % n''existe pas', NEW.codecereale;
        END IF;
        IF NEW.no_negociant NOT IN (SELECT no_negociant FROM negociant)
            THEN RAISE EXCEPTION 'le negociant numero % n''existe pas', NEW.no_negociant;
        END IF;
        IF NEW.qtecde <= 0
            THEN RAISE EXCEPTION 'La quantite % doit etre superieur a 0', NEW.qtecde;
        END IF;
        IF NOT verif_contrat(NEW.codecereale, NEW.qtecde)
            THEN RAISE EXCEPTION 'le stock de % est insuffisant, il en manque %',NEW.codecereale, NEW.qtecde - stock_cereale(NEW.codecereale);
        END IF;

        NEW.datecontrat:= current_timestamp;
        NEW.nocontrat := (SELECT max(nocontrat)+1 from contrat);

        RETURN NEW;
    END; $$
LANGUAGE plpgsql;

CREATE TRIGGER trig_insert_contrat BEFORE INSERT
ON contrat FOR EACH ROW 
EXECUTE PROCEDURE add_contrat();
