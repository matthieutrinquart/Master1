1)	SELECT nomclient, adrclient, cpclient, villeclient, telclient FROM clients WHERE nomclient like '_A_IN%'

2)	SELECT numcmde FROM commandes INNER JOIN clients ON commandes.codeclient=clients.codeclient
	WHERE nomclient='RABIN'
	
3)	SELECT DISTINCT designation FROM produits P INNER JOIN lignes_commande L ON P.ref=L.ref INNER JOIN commandes C ON L.numcmde=C.numcmde INNER JOIN clients ON C.codeclient=clients.codeclient
	WHERE nomclient='RABIN'
	
4)	SELECT SUM(totht) FROM commandes INNER JOIN clients ON commandes.codeclient=clients.codeclient
	WHERE nomclient='RABIN'
	
5)	SELECT SUM(qtdemande*puht) FROM produits P INNER JOIN lignes_commande L ON P.ref=L.ref INNER JOIN commandes C ON L.numcmde=C.numcmde INNER JOIN clients ON C.codeclient=clients.codeclient
	WHERE nomclient='RABIN'
	
6)	SELECT SUM(totht+tottva) FROM commandes WHERE extract(month from datecmde)=10 AND extract(year from datecmde)=1998

7)	SELECT SUM(totht+tottva) AS "CA Marc BAUDOT" FROM commandes C INNER JOIN vendeurs V ON C.codevendeur=V.codevendeur
	WHERE extract(month from datecmde)=10 AND extract(year from datecmde)=1998 AND nomvendeur='BAUDOT' AND prevendeur='Marc'
	
8)	SELECT designation, (puht*1000)/(qte*poidsPiece) AS "Prix au Kg", puht AS "Prix du sachet", qte*poidsPiece AS "Poids"
	FROM produits WHERE descriptif='P' ORDER BY "Prix au Kg"
	
9)	SELECT designation, qte*poidsPiece AS "Poids" FROM produits WHERE descriptif='P'
	UNION
	SELECT designation, qte AS "Poids" FROM produits WHERE descriptif='G' ORDER BY "Poids"

10)	SELECT SUL((case WHEN PoidsPiece>0 THEN poidspiece*qte ELSE qte END) * Stock  )/1000as "poids du stock" FROM Produits
	ORDER BY 1
	
11)	SELECT SUM(puht*Stock) AS "prix du stock" FROM Produits

12) SELECT SUM((CASE WHEN PoidsPiece>0 THEN poidspiece*qte ELSE qte END) * Stock ) /1000 AS "poids en kilo", 
		   SUM(puht*Stock) AS "prix du stock", 
		   (SUM(puht*Stock)/ (SUM((CASE WHEN PoidsPiece>0 THEN poidspiece*qte ELSE qte END) * Stock ) /1000) ) AS "prix moyen" 
		   FROM Produits ORDER BY "prix moyen" DESC

13)	SELECT numcmde FROM commandes INNER JOIN lignes_commande L ON commandes.numcmde=L.numcmde INNER JOIN produit ON L.ref=produit.ref
	WHERE designation LIKE 'COLA CITRIQUE'
	INTERSECT
	SELECT numcmde FROM commandes INNER JOIN lignes_commande L ON commandes.numcmde=L.numcmde INNER JOIN produit ON L.ref=produit.ref
	WHERE designation LIKE 'FRAISE TSOIN-TSOIN'
	
14)	SELECT numcmde FROM commandes INNER JOIN lignes_commande L ON commandes.numcmde=L.numcmde INNER JOIN produit ON L.ref=produit.ref
	WHERE designation LIKE 'COLA CITRIQUE'
	EXCEPT
	SELECT numcmde FROM commandes INNER JOIN lignes_commande L ON commandes.numcmde=L.numcmde INNER JOIN produit ON L.ref=produit.ref
	WHERE designation LIKE 'FRAISE TSOIN-TSOIN'