/* Controle 3*/

/*Exercice 1*/

/*1*/
SELECT titreLivre
FROM livre V INNER JOIN categorie C ON V.categLivre=C.categLivre
WHERE auteurLivre LIKE 'Victor Hugo' AND libCategorie='Théâtre';

/*2*/
SELECT titreLivre
FROM livre V
WHERE auteurLivre LIKE 'Jacques Prévert' OR auteurLivre LIKE 'Gilber Sinoué';

/*3*/
SELECT nomMembre
FROM membre
WHERE adrMembre NOT LIKE 'Marseille';

/*4*/
SELECT DISTINCT nomMembre
FROM membre, biblio
WHERE adrMembre=adrBiblio;

/*5*/
SELECT titreLivre, auteurLivre
FROM livre
WHERE idLivre NOT IN (SELECT V.idLivre FROM livre V INNER JOIN emprunt E ON V.idLivre=E.idLivre);

/*6*/
SELECT nomMembre
FROM membre M INNER JOIN emprunt E ON M.idMembre=E.idMembre
	INNER JOIN livre V ON E.idLivre=V.idLivre
WHERE titreLivre LIKE 'Ruy Blas';

/*7*/
SELECT titreLivre
FROM livre V INNER JOIN emprunt E ON V.idLivre=E.idLivre
/*TODO*/

/*8*/
SELECT idMembre
FROM biblio B INNER JOIN livre V ON B.idBiblio=V.idBiblio
	INNER JOIN emprunt E ON V.idLivre=E.idLivre
WHERE dureeEmprunt>=7 AND adrBiblio LIKE 'Marseille';

/*9*/
SELECT nomMembre
FROM membre
WHERE idMembre IN (SELECT M.idMembre 
		FROM membre M INNER JOIN emprunt E ON M.idMembre=E.idMembre 
			INNER JOIN livre V ON E.idLivre=V.idLivre
		WHERE titreLivre LIKE 'Avicenne');
	
/*10*/
SELECT nomMembre
FROM membre
WHERE idMembre IN (SELECT M.idMembre 
		FROM membre M INNER JOIN emprunt E ON M.idMembre=E.idMembre 
			INNER JOIN livre V ON E.idLivre=V.idLivre
		WHERE titreLivre LIKE 'Avicenne')
	AND idMembre IN (SELECT M.idMembre 
		FROM membre M INNER JOIN emprunt E ON M.idMembre=E.idMembre 
			INNER JOIN livre V ON E.idLivre=V.idLivre
		WHERE titreLivre LIKE 'Contes pour les enfants pas sages');

/*11*/
SELECT idMembre, nomMembre
FROM membre
WHERE idMembre IN (SELECT M.idMembre 
		FROM membre M INNER JOIN emprunt E ON M.idMembre=E.idMembre 
			INNER JOIN livre V ON E.idLivre=V.idLivre
		WHERE auteurLivre LIKE 'Victor Hugo')
	AND idMembre NOT IN (SELECT M.idMembre 
		FROM membre M INNER JOIN emprunt E ON M.idMembre=E.idMembre 
			INNER JOIN livre V ON E.idLivre=V.idLivre
		WHERE auteurLivre LIKE 'Jacques Prévert');

/*12*/
SELECT titreLivre, COALESCE(MIN(dureeEmprunt),0) AS "Durée emprunt min", COALESCE(MAX(dureeEmprunt),0) AS "Durée emprunt max"
FROM livre V LEFT JOIN emprunt E ON V.idLivre=E.idLivre
GROUP BY titreLivre;

/*13*/
SELECT libCategorie, COUNT(idLivre) AS "Nombre de livre"
FROM categorie C LEFT JOIN livre V ON C.categLivre=V.categLivre
GROUP BY libCategorie
ORDER BY "Nombre de livre" DESC;


/*14*/
SELECT titreLivre, auteurLivre, COUNT(dureeEmprunt) AS "Nombre d'emprunt"
FROM livre V LEFT JOIN emprunt E ON V.idLivre=E.idLivre
GROUP BY titreLivre, auteurLivre
ORDER BY "Nombre d'emprunt" DESC;

/*15*/
SELECT titreLivre, auteurLivre,  COUNT(dureeEmprunt)
FROM livre V INNER JOIN emprunt E ON V.idLivre=E.idLivre
GROUP BY titreLivre, auteurLivre
HAVING COUNT(dureeEmprunt) < ALL(SELECT COUNT(dureeEmprunt) FROM emprunt)

/*16*/
SELECT nomMembre
FROM membre M
WHERE M.idMembre IN 

/*17*/


/*18*/
SELECT titreLivre, MOY((SELECT note FROM note WHERE idLivre=V.idLivre)) AS "Moyenne"
FROM note N INNER JOIN livre V ON N.idLivre=V.idLivre
GROUP BY titreLivre, note
HAVING "Moyenne" < MOY((SELECT note FROM note)) /*Marche pas*/