/*TP5 - BDD*/

/*1.1*/ SELECT * FROM client;

/*1.2*/ SELECT * FROM client WHERE categorie = 'PRIVILEGIE';

/*1.3*/ SELECT nom, prenom FROM client where ville = 'MARSEILLE';

/*1.4*/ SELECT nom FROM client where ville = 'MARSEILLE' AND prenom LIKE '%R%';

/*1.5*/ SELECT C.numcl, idv
		FROM client C INNER JOIN reservation R ON C.numcl=R.numcl
		WHERE dateres BETWEEN '2003/03/01' AND '2004/01/31';
		
		SELECT C.numcl, idv
		FROM client C INNER JOIN reservation R ON C.numcl=R.numcl
		WHERE (extract(year from dateres)=2004 AND extract(month from dateres)<=1) OR (extract(year from dateres)=2003 AND extract(month from dateres)>=3);
		
/*1.6*/ SELECT P.idv, duree
		FROM planning P INNER JOIN voyage V ON P.idv=V.idv
		WHERE paysarr='MAROC' OR hotel='ANTIQUE';
		
/*1.7*/ SELECT DISTINCT villearr
		FROM voyage V INNER JOIN planning P ON V.idv=P.idv
		WHERE paysarr='MAROC';
		
/*1.8*/ SELECT *
		FROM optionv O INNER JOIN carac C ON O.code=C.code
			INNER JOIN voyage V ON C.idv=V.idv
		WHERE libelle LIKE '%VISITE%';
		
/*1.9*/ SELECT datedep
		FROM planning P INNER JOIN voyage V ON P.idv=V.idv
		WHERE (P.idv='927') AND (datedep BETWEEN '2004/06/01' AND '2004/07/30')
		ORDER BY datedep;
		
/*1.10*/SELECT numcl, nom, prenom
		FROM client
		WHERE ville NOT LIKE 'PARIS' AND ville NOT LIKE 'MARSEILLE'
		ORDER BY numcl;
		
		SELECT numcl, nom, prenom
		FROM client
		WHERE not(ville='PARIS') AND not(ville='MARSEILLE')
		ORDER BY numcl;
		
/*1.11*/SELECT numcl, nom
		FROM client
		WHERE adresse IS NULL;
		
------------------------------------------------------------------------------------------------

/*2.1*/ SELECT V.idv, paysarr, villearr
		FROM voyage V INNER JOIN planning P ON V.idv=P.idv
		WHERE tarif = (SELECT MIN(tarif) FROM voyage V INNER JOIN planning P ON V.idv=P.idv);
		
		SELECT V.idv, paysarr, villearr
		FROM voyage V INNER JOIN planning P ON V.idv=P.idv
		WHERE tarif <= ALL (SELECT tarif FROM voyage V INNER JOIN planning P ON V.idv=P.idv);
		
		
/*2.2*/ SELECT villearr, paysarr
		FROM voyage V INNER JOIN planning P ON V.idv=P.idv
		WHERE tarif >= ALL(SELECT tarif FROM voyage V INNER JOIN planning P ON V.idv=P.idv);
		
/*2.3*/ SELECT DISTINCT villedep
		FROM voyage
		WHERE villedep IN (SELECT ville FROM client);
		
		SELECT DISTINCT villedep 
		FROM voyage V INNER JOIN client C ON V.villedep=C.ville
		
/*2.4*/ SELECT libelle
		FROM optionv O INNER JOIN CARAC C ON O.code=C.code
		WHERE idv = 354
		INTERSECT
		SELECT libelle
		FROM optionv O INNER JOIN CARAC C ON O.code=C.code
		WHERE idv = 952;
		
		SELECT libelle
		FROM optionv O INNER JOIN CARAC C ON O.code=C.code
		WHERE  idv = 354 AND libelle IN (SELECT libelle FROM optionv O INNER JOIN CARAC C ON O.code=C.code WHERE idv = 952);
		
/*2.5*/	SELECT idv, villearr, paysarr
		FROM voyage
		EXCEPT
		SELECT V.idv, villearr, paysarr
		FROM voyage V INNER JOIN planning P ON V.idv=P.idv;
		
		SELECT idv, villearr, paysarr
		FROM voyage
		WHERE idv NOT IN (SELECT V.idv FROM voyage V INNER JOIN planning P ON V.idv=P.idv);
		
		SELECT V.idv, villearr, paysarr
		FROM voyage V LEFT JOIN planning P ON V.idv=P.idv
		WHERE P.idv IS NULL;
		
/*2.6*/	SELECT libelle
		FROM optionv O INNER JOIN CARAC C ON O.code=C.code
		WHERE idv = 354 AND prix IS NULL
		UNION
		SELECT libelle
		FROM optionv O INNER JOIN CARAC C ON O.code=C.code
		WHERE idv = 952 AND prix IS NOT NULL;
		
		SELECT libelle
		FROM optionv O INNER JOIN CARAC C ON O.code=C.code
		WHERE (idv = 354 AND prix IS NULL) OR (idv = 952 AND prix IS NOT NULL);
		
/*2.7*/	SELECT V.idv, villearr, paysarr
		FROM voyage V INNER JOIN carac C ON V.idv=C.idv INNER JOIN optionv O ON C.code=O.code
		WHERE libelle='VISITE GUIDEE'
		INTERSECT
		SELECT V.idv, villearr, paysarr
		FROM voyage V INNER JOIN carac C ON V.idv=C.idv INNER JOIN optionv O ON C.code=O.code
		WHERE libelle='PISCINE';
		
		SELECT V.idv, villearr, paysarr
		FROM voyage V INNER JOIN carac C ON V.idv=C.idv INNER JOIN optionv O ON C.code=O.code
		WHERE libelle='VISITE GUIDEE' AND V.idv IN (SELECT V.idv
													FROM voyage V INNER JOIN carac C ON V.idv=C.idv INNER JOIN optionv O ON C.code=O.code
													WHERE libelle='PISCINE');
													
/*2.8*/	SELECT nom, prenom
		FROM client
		WHERE numcl NOT IN (SELECT numcl FROM reservation);
		
		SELECT nom, prenom
		FROM client C LEFT JOIN reservation R ON C.numcl=R.numcl
		WHERE R.numcl IS NULL;
		
		SELECT nom, prenom
		FROM client
		EXCEPT
		SELECT nom, prenom
		FROM client C INNER JOIN reservation R ON C.numcl=R.numcl;
		
		SELECT nom, prenom
		FROM client C
		WHERE NOT EXISTS (SELECT * FROM reservation WHERE numcl=C.numcl);
		
/*2.9*/	SELECT villearr, paysarr
		FROM voyage
		WHERE villedep NOT LIKE 'MARSEILLE'
		
/*2.10*/SELECT code, libelle FROM optionv
		EXCEPT
		SELECT O.code, libelle
		FROM optionv O INNER JOIN carac C ON O.code=C.code INNER JOIN voyage V ON C.idv=V.idv
		WHERE paysarr LIKE 'CHYPRE';
		
/*2.11*/SELECT DISTINCT hotel
		FROM voyage
		WHERE nbetoiles IN (SELECT MAX(nbetoiles) FROM voyage);
		
/*2.12*/SELECT DISTINCT paysarr
		FROM voyage
		WHERE nbetoiles NOT IN (SELECT MAX(nbetoiles) FROM voyage);
		
/*2.13*/SELECT paysarr , COUNT(DISTINCT hotel) AS "Nb Hotel"
		FROM voyage
		WHERE paysarr IN (SELECT paysarr
							FROM voyage
							WHERE nbetoiles IN (SELECT MAX(nbetoiles) FROM voyage) 
							GROUP BY paysarr)
		GROUP BY paysarr;
		
------------------------------------------------------------------------------------------------

/*3.1*/	SELECT paysarr, COUNT(*) AS "Nombre de voyage"
		FROM voyage
		GROUP BY paysarr;
		
/*3.2*/	SELECT paysarr, villearr, COUNT(*) AS "Nombre de voyage"
		FROM voyage
		GROUP BY paysarr, villearr
		ORDER BY paysarr;
		
/*3.3*/	SELECT paysarr, COUNT(DISTINCT villearr) AS "Nombre de ville d'arrive"
		FROM voyage
		GROUP BY paysarr;
		
/*3.4*/ SELECT V.idv, villearr, COUNT(datedep) AS "Nombre de date prevu"
		FROM voyage V INNER JOIN planning P ON V.idv=P.idv
		GROUP BY V.idv, villearr
		ORDER BY V.idv;
		
/*3.5*/	SELECT V.idv, villearr, COUNT(code) AS "Nombre d'option gratuite"
		FROM voyage V INNER JOIN carac C ON V.idv=C.idv
		WHERE prix IS NULL
		GROUP BY V.idv, villearr
		ORDER BY V.idv;
		
/*3.6*/	SELECT COALESCE(categorie, 'SANS') AS "Categorie", COUNT(numcl) AS "Nombre de client"
		FROM client
		GROUP BY categorie
		ORDER BY numcl;
		
/*3.7*/	SELECT R.idv, villearr, SUM(nbpers) AS "Nombre de personne", COUNT(*) AS "Nombre de reservation"
		FROM reservation R INNER JOIN voyage V ON R.idv=V.idv
		GROUP BY R.idv, villearr
		ORDER BY villearr;
		
/*3.8*/	SELECT idv, ROUND(AVG(COALESCE(prix, '0')),2) AS "Prix moyen"
		FROM carac
		GROUP BY idv
		ORDER BY "Prix moyen";
		
/*3.9*/	SELECT ville, COUNT(numcl) AS "Nombre de client"
		FROM client
		GROUP BY ville
		HAVING COUNT(numcl)>5;
		
/*3.10*/SELECT V.idv, paysarr, SUM(tarif*nbpers) AS "Tarif total"
		FROM voyage V INNER JOIN planning P ON V.idv=P.idv
					INNER JOIN reservation R ON P.idv=R.idv AND P.datedep=R.datedep
		GROUP BY V.idv, paysarr
		ORDER BY V.idv;
		
/*3.11*/SELECT nom, prenom, C.numcl AS "N° Client", R.datedep, SUM(tarif*nbpers) AS "Tarif total"
		FROM client C INNER JOIN reservation R ON C.numcl=R.numcl
					INNER JOIN planning P ON P.idv=R.idv AND P.datedep=R.datedep
		GROUP BY nom, prenom, C.numcl, R.datedep
		ORDER BY nom;
		
/*3.12*/SELECT paysarr, COUNT(*) AS "Nombre de réservation"
		FROM voyage V INNER JOIN reservation R ON V.idv=R.idv
		GROUP BY paysarr
		HAVING COUNT(*) > (SELECT COUNT(*) 
							FROM voyage V INNER JOIN reservation R ON V.idv=R.idv
							WHERE paysarr LIKE 'ESPAGNE');
							
/*3.13*/SELECT categorie, COUNT(numcl)
		FROM client
		GROUP BY categorie
		HAVING COUNT(numcl) <= ALL (SELECT COUNT(numcl)
									FROM client
									GROUP BY categorie);
									
/*3.14*/SELECT paysarr, COUNT(*)
		FROM voyage V INNER JOIN planning P ON V.idv=P.idv
					INNER JOIN reservation R ON P.idv=R.idv AND P.datedep=R.datedep
		GROUP BY paysarr
		HAVING COUNT(*) >= ALL (SELECT COUNT(*)
								FROM voyage V INNER JOIN planning P ON V.idv=P.idv
											INNER JOIN reservation R ON P.idv=R.idv AND P.datedep=R.datedep
								GROUP BY paysarr);