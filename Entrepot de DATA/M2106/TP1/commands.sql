/* TP1 - BDD */

/*1*/
/*a)*/	INSERT INTO formateur VALUES(DEFAULT, 'Jacques' ,'Mesrine');
/*b)*/	INSERT INTO inscrire VALUES(21, 'X00005',1);
/*c)*/	INSERT INTO inscrire VALUES(42, 10600,1);
/*d)*/	INSERT INTO planifier VALUES(42, 6 ,'2019-01-23', 1, 2, 1, 'Matin','E410');

/*2*/	UPDATE planifier SET dateform= dateform + integer '9' WHERE id_formation = (SELECT id_formation FROM formation WHERE intitule_formation LIKE 'Initiation a Linux');

/*3*/	DELETE FROM planifier WHERE id_formation = (SELECT id_formation FROM formation WHERE intitule_formation LIKE 'Bases de donnees (Access)');
		DELETE FROM inscrire WHERE id_formation = (SELECT id_formation FROM formation WHERE intitule_formation LIKE 'Bases de donnees (Access)');
		DELETE FROM formation WHERE id_formation = (SELECT id_formation FROM formation WHERE intitule_formation LIKE 'Bases de donnees (Access)');
		
/*4*/	UPDATE formateur SET nom_formateur= LOWER(nom_formateur), prenom_formateur= LOWER(prenom_formateur);

/*5*/	UPDATE formateur SET nom_formateur= UPPER(nom_formateur), prenom_formateur= INITCAP(prenom_formateur);

/*6*/	UPDATE planifier SET numsalle = 'G333' WHERE dateform IN (SELECT dateform FROM planifier WHERE dateform BETWEEN '2006-4-8' AND date '2006-4-8' + 30);

/*7*/	UPDATE planifier SET dateform = dateform + 3 WHERE dateform = date '2006-01-01' + 138;

/*8*/
/*A*/	SELECT intitule_formation, to_char(dateform,'DD/MM/YYYY') AS "Date", groupe, numseance, duree, mat_am, numsalle, nom_formateur, prenom_formateur FROM planifier P INNER JOIN formateur F ON P.id_formateur=F.id_formateur INNER JOIN formation O ON P.id_formation=O.id_formation;
/*B-a*/	INSERT INTO formateur VALUES(DEFAULT, 'DURANT', 'Pierre');
/*B-b*/	UPDATE planifier SET id_formateur = (SELECT id_formateur FROM formateur WHERE nom_formateur LIKE 'DURANT' AND prenom_formateur LIKE 'Pierre') WHERE id_formateur = (SELECT id_formateur FROM formateur WHERE nom_formateur LIKE 'CANCEL' AND prenom_formateur LIKE 'Christophe');
/*C*/	SELECT intitule_formation, to_char(dateform,'DD/MM/YYYY') AS "Date", groupe, numseance, duree, mat_am, numsalle, nom_formateur, prenom_formateur FROM planifier P INNER JOIN formateur F ON P.id_formateur=F.id_formateur INNER JOIN formation O ON P.id_formation=O.id_formation;

/*9*/
/*A*/	INSERT INTO formation VALUES (DEFAULT, 'Javascript', 12, 'Confirme');
/*B*/	INSERT INTO inscrire(id_formation, id_stagiaire, groupe)
			SELECT (SELECT id_formation FROM formation WHERE intitule_formation LIKE 'Javascript'), id_stagiaire, 2
			FROM inscrire
			WHERE id_formation = (SELECT id_formation FROM formation WHERE intitule_formation LIKE 'Formation Excel');

/*10*/	
/*A*/ 	SELECT * FROM formation WHERE nbheures = 0;
/*B*/	SELECT * FROM inscrire WHERE id_formation IN (SELECT id_formation FROM formation WHERE nbheures = 0);
/*C.a*/	CREATE TABLE Formation_Ext AS SELECT * FROM formation WHERE nbheures = 0;
		CREATE TABLE Inscrit_Form_Ext AS SELECT * FROM inscrire WHERE id_formation IN (SELECT id_formation FROM formation WHERE nbheures = 0);
/*C.b*/	DELETE FROM inscrire WHERE id_formation IN (SELECT id_formation FROM formation WHERE nbheures = 0);
		DELETE FROM formation WHERE nbheures = 0;
		