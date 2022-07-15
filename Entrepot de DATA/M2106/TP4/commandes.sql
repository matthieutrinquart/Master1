/*              TP4 - fonctions             */

/*1*/
/*A*/
CREATE OR REPLACE FUNCTION moySalaire() RETURNS numeric AS $$
    DECLARE
        moyenne numeric;
    BEGIN
        SELECT AVG(salaire) INTO moyenne FROM employes;
        RETURN moyenne;
    END; $$
LANGUAGE plpgsql;

/*B
C'est bon ça marche*/

/*C*/
SELECT nom, salaire FROM employes WHERE salaire > moySalaire();

/*D*/
SELECT nom, salaire FROM employes 
WHERE (salaire < moySalaire()*1.1) AND (salaire > moySalaire()*0.9);


/*2*/
CREATE OR REPLACE FUNCTION departement(num integer) RETURNS varchar AS $$
    DECLARE
        dep varchar;
    BEGIN
        SELECT nom INTO dep FROM departement WHERE nodept = (SELECT nodept FROM employes WHERE noemp = num);
        RETURN dep;
    END; $$
LANGUAGE plpgsql;

/*3*/
CREATE OR REPLACE FUNCTION collegue(num integer) RETURNS SETOF record AS $$
    DECLARE
        emp RECORD;
    BEGIN 
        FOR emp IN SELECT nom, prenom FROM employes WHERE nodept = (SELECT nodept FROM employes WHERE noemp=num ) AND noemp <> num LOOP 
            RETURN NEXT emp; 
        END LOOP;
    RETURN; 
    END; $$
LANGUAGE plpgsql;

SELECT * FROM collegue(1) AS (nom varchar, prenom varchar);


/*4*/
CREATE OR REPLACE FUNCTION superieurs(num NUMERIC(7,0)) RETURNS SETOF employes AS $$
    DECLARE
        sup employes%ROWTYPE;
    BEGIN
        FOR sup IN SELECT * FROM employes WHERE noemp = (SELECT nosupr FROM employes WHERE noemp = num) LOOP
            IF sup.nosupr IS NOT NULL 
                THEN RETURN NEXT superieurs(sup.noemp);
            END IF;
            RETURN NEXT sup; 
        END LOOP;
    RETURN; 
    END; $$
LANGUAGE plpgsql;

select nom, prenom from superieurs(6)