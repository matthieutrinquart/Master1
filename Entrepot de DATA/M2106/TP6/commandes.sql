/*              TP6 - triggers             */

/*1*/
CREATE OR REPLACE FUNCTION add_cmdline() RETURNS trigger AS $$
    BEGIN
        IF NEW.no_cde NOT IN (SELECT no_cde FROM commande)
            THEN RAISE EXCEPTION 'La commande n''existe pas !';
        END IF;
        IF NEW.no_pdt NOT IN (SELECT no_pdt FROM produit)
            THEN RAISE EXCEPTION 'Le produit n''existe pas';
        END IF;
        IF NEW.qte > (SELECT stock FROM produit WHERE no_pdt = NEW.no_pdt)
            THEN RAISE EXCEPTION 'Le stock est insuffisant '; 
        END IF;

        IF NEW.no_pdt IN (SELECT no_pdt FROM ligne_cde WHERE no_cde = NEW.no_cde)
            THEN EXECUTE 'UPDATE ligne_cde SET qte = '||NEW.qte+(SELECT qte FROM ligne_cde WHERE no_cde = NEW.no_cde AND no_pdt = NEW.no_pdt)||' WHERE no_cde='||NEW.no_cde||' AND no_pdt='||NEW.no_pdt;
            RETURN NULL;
        END IF;

        NEW.num_ligne := (SELECT COUNT(num_ligne) FROM ligne_cde) + 1;
        EXECUTE 'UPDATE commande SET montant ='||(SELECT pu FROM produit WHERE no_pdt = NEW.no_pdt) * NEW.qte + (SELECT montant FROM commande WHERE no_cde = NEW.no_cde)||'WHERE no_cde ='||NEW.no_cde;
        EXECUTE 'UPDATE produit SET stock = '||(SELECT stock FROM produit WHERE no_pdt = NEW.no_pdt) - NEW.qte||'WHERE no_pdt ='||NEW.no_pdt;

        RETURN NEW;
    END; $$
LANGUAGE plpgsql;

CREATE TRIGGER add_cmdline BEFORE INSERT
ON ligne_cde FOR EACH ROW 
EXECUTE PROCEDURE add_cmdline();


/*2*/
CREATE OR REPLACE FUNCTION mod_cmdline() RETURNS trigger AS $$
    DECLARE
        qte INTEGER := (SELECT qte FROM ligne_cde WHERE no_cde = NEW.no_cde AND no_pdt = NEW.no_pdt);
    BEGIN
        IF NEW.no_pdt NOT IN (SELECT no_pdt FROM produit)
            THEN RAISE EXCEPTION 'Le produit n''existe pas';
        END IF;
        IF NEW.qte-qte > (SELECT stock FROM produit WHERE no_pdt = NEW.no_pdt)
            THEN RAISE EXCEPTION 'Le stock est insuffisant '; 
        END IF;

        IF NEW.qte >= qte
            THEN EXECUTE 'UPDATE commande SET montant ='||(SELECT montant FROM commande WHERE no_cde = NEW.no_cde) + ((SELECT pu FROM produit WHERE no_pdt = NEW.no_pdt) * (NEW.qte-qte))||'WHERE no_cde ='||NEW.no_cde; -- Ajoute au montant le nombre de produits en plus
                 EXECUTE 'UPDATE produit SET stock = '||(SELECT stock FROM produit WHERE no_pdt = NEW.no_pdt) - (NEW.qte-qte)||'WHERE no_pdt ='||NEW.no_pdt; -- enleve au sotck les produit ajoutés
            ELSE EXECUTE 'UPDATE commande SET montant ='||(SELECT montant FROM commande WHERE no_cde = NEW.no_cde) - ((SELECT pu FROM produit WHERE no_pdt = NEW.no_pdt) * (qte-NEW.qte))||'WHERE no_cde ='||NEW.no_cde; -- enleve au montant le nombre de produits enlevé
                 EXECUTE 'UPDATE produit SET stock = '||(SELECT stock FROM produit WHERE no_pdt = NEW.no_pdt) + (qte-NEW.qte)||'WHERE no_pdt ='||NEW.no_pdt; -- ajoute au sotck les produit supprimé
        END IF;
        RETURN NEW;
    END; $$
LANGUAGE plpgsql;

CREATE TRIGGER mod_cmdline BEFORE UPDATE
ON ligne_cde FOR EACH ROW 
EXECUTE PROCEDURE mod_cmdline();


/*3*/
CREATE OR REPLACE FUNCTION del_cmdline() RETURNS trigger AS $$
    DECLARE
        num_ligne INTEGER := 1;
        line_cde ligne_cde%ROWTYPE;
    BEGIN
        EXECUTE 'UPDATE commande SET montant ='||(SELECT montant FROM commande WHERE no_cde = OLD.no_cde) - ((SELECT pu FROM produit WHERE no_pdt = OLD.no_pdt) * (OLD.qte))||'WHERE no_cde ='||OLD.no_cde; -- enleve au montant le nombre de produits enlevé
        EXECUTE 'UPDATE produit SET stock = '||(SELECT stock FROM produit WHERE no_pdt = OLD.no_pdt) + (OLD.qte)||'WHERE no_pdt ='||OLD.no_pdt; -- ajoute au sotck les produit supprimé
        
        FOR line_cde IN SELECT * FROM ligne_cde LOOP
            EXECUTE 'UPDATE ligne_cde SET num_ligne ='||num_ligne||' WHERE no_cde ='||OLD.no_cde||' AND no_pdt ='||OLD.no_pdt;
            num_ligne := num_ligne + 1;
        END LOOP;
        
        RETURN OLD;
    END; $$
LANGUAGE plpgsql;

CREATE TRIGGER del_cmdline BEFORE DELETE
ON ligne_cde FOR EACH ROW 
EXECUTE PROCEDURE del_cmdline();
