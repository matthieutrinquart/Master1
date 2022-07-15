/*TP6 - BDD*/

/*1*/	SELECT nomPilote, prenomPilote, nomCircuit
		FROM pilote P INNER JOIN courir C ON P.idpilote=C.idpilote 
					INNER JOIN grandprix G ON C.idgp=G.idgp
					INNER JOIN circuit I ON G.id_circuit=I.id_circuit
		WHERE positionArrivee='A'
		ORDER BY nomGP, nomPilote;
		
/*2*/	SELECT points AS "si plus de la moitié des tours", points::real/2 AS "si plus de 2 tours et moins de la moitié des tours"
		FROM bareme
		ORDER BY points DESC;
		
/*3*/	SELECT nomGP, nbTour, nbToursEffectue, nbToursEffectue::real/nbTour::real AS "rapport tours réalisés"
		FROM grandprix
		ORDER BY nomGP;
		
/*4*/	SELECT nomGP, longPiste*nbTour AS "distance à parcourir"
		FROM grandprix G INNER JOIN circuit C ON G.id_circuit=C.id_circuit
		ORDER BY "distance à parcourir" DESC;
		
/*5*/	SELECT nomGp AS "Nom du grand prix", nomPilote, COALESCE((
																SELECT
																	CASE 
																		WHEN g.nbToursEffectue::real/g.nbTour::real<=0.5 THEN points::real/2
																		ELSE points
																	END
																FROM bareme 
																WHERE place=I.positionArrivee::integer),0) AS "points", positionArrivee, nbToursEffectue::real/nbTour::real AS "rapport tours réalisés"
		FROM grandprix G INNER JOIN circuit C ON G.id_circuit=C.id_circuit
						INNER JOIN courir I ON G.idgp=I.idgp
						INNER JOIN pilote P ON I.idpilote=P.idpilote
		WHERE positionArrivee != 'A' AND positionArrivee != '0' 
		ORDER BY nomGP, points DESC, positionarrivee;
		
/*6*/	SELECT nomGP, nomEcurie, SUM(COALESCE((
												SELECT
													CASE 
														WHEN g.nbToursEffectue::real/g.nbTour::real<=0.5 THEN points::real/2
														ELSE points
													END
												FROM bareme 
												WHERE place=I.positionArrivee::integer),0)) AS "points"
		FROM grandprix G INNER JOIN circuit C ON G.id_circuit=C.id_circuit
						INNER JOIN courir I ON G.idgp=I.idgp
						INNER JOIN voiture V ON I.numVoiture=V.numVoiture
						INNER JOIN ecurie E ON V.id_ecurie=E.id_ecurie
		WHERE positionArrivee != 'A' AND positionArrivee != '0'
		GROUP BY nomGP, nomEcurie
		ORDER BY nomGP, points DESC;
		
/*7*/	SELECT P.idpilote, nomPilote, prenomPilote, SUM(COALESCE((
												SELECT
													CASE 
														WHEN g.nbToursEffectue::real/g.nbTour::real<=0.5 THEN points::real/2
														ELSE points
													END
												FROM bareme 
												WHERE place=I.positionArrivee::integer AND positionArrivee != 'A'),0)) AS "points"
		FROM pilote P LEFT join courir I ON P.idpilote=I.idpilote
					LEFT JOIN grandprix G ON I.idgp=G.idgp
		GROUP BY P.idpilote, nomPilote, prenomPilote
		ORDER BY points DESC;
		
/*8*/	SELECT nomEcurie, SUM(COALESCE((
										SELECT
											CASE 
												WHEN g.nbToursEffectue::real/g.nbTour::real<=0.5 THEN points::real/2
												ELSE points
											END
										FROM bareme 
										WHERE place=I.positionArrivee::integer),0)) AS "points"
		FROM grandprix G INNER JOIN courir I ON G.idgp=I.idgp
						INNER JOIN voiture V ON I.numVoiture=V.numVoiture
						INNER JOIN ecurie E ON V.id_ecurie=E.id_ecurie
		WHERE positionArrivee != 'A' AND positionArrivee != '0'
		GROUP BY nomEcurie
		ORDER BY points DESC;
		
/*9.1*/	SELECT nomPilote, prenomPilote
				FROM pilote
				EXCEPT
				SELECT nomPilote, prenomPilote
				FROM pilote P INNER join courir I ON P.idpilote=I.idpilote
				ORDER BY nomPilote, prenomPilote;
		
/*9.2*/	SELECT nomPilote, prenomPilote
				FROM pilote
				WHERE idpilote NOT IN (SELECT P.idpilote FROM pilote P INNER join courir I ON P.idpilote=I.idpilote)
				ORDER BY nomPilote, prenomPilote;
		
/*9.3*/ SELECT nomPilote, prenomPilote
				FROM pilote P LEFT JOIN courir I ON P.idpilote=I.idpilote
				WHERE I.idpilote IS NULL
				ORDER BY nomPilote, prenomPilote;
		
/*9.4*/ SELECT nomPilote, prenomPilote
				FROM pilote P
				WHERE NOT EXISTS (SELECT * FROM courir WHERE idpilote=P.idpilote)
				ORDER BY nomPilote, prenomPilote;
		
/*10*/	SELECT nomPilote, prenomPilote
				FROM pilote P INNER JOIN courir I ON P.idpilote=I.idpilote
				GROUP BY nomPilote, prenomPilote
				HAVING COUNT(idgp)=2
				ORDER BY nomPilote, prenomPilote;
		
/*11*/	SELECT SUM(longPiste*nbToursEffectue) AS "Distance parcouru"
		FROM circuit C INNER JOIN grandprix G ON C.id_circuit=G.id_circuit
		
/*12*/	SELECT nomPilote, prenomPilote, COALESCE(SUM(longPiste*nbToursEffectue),0) AS "Distance parcouru"
				FROM pilote P LEFT join courir I ON P.idpilote=I.idpilote
					LEFT JOIN grandprix G ON I.idgp=G.idgp
					LEFT JOIN circuit C ON G.id_circuit=C.id_circuit
				GROUP BY nomPilote, prenomPilote
				ORDER BY nomPilote, prenomPilote;
		
/*13.1*/SELECT nomPilote, prenomPilote
				FROM pilote P INNER JOIN courir I ON P.idpilote=I.idpilote
				GROUP BY nomPilote, prenomPilote
				HAVING COUNT(DISTINCT I.idgp)=(SELECT COUNT(*) FROM grandprix)
				ORDER BY nomPilote, prenomPilote;
		
/*13.2*/SELECT distinct nomPilote, prenomPilote
				FROM pilote P
				WHERE NOT EXISTS (SELECT * 
					FROM grandprix G
					WHERE NOT EXISTS (SELECT *
						FROM courir
						WHERE idgp=G.idgp AND idpilote=P.idpilote))
				ORDER BY nomPilote, prenomPilote;
				
/*13.3*/SELECT nomPilote, prenomPilote
				FROM pilote P
				
/*14*/	SELECT nomPilote, prenomPilote, COALESCE(SUM(longPiste*nbToursEffectue),0) AS "Distance parcouru",
					SUM(COALESCE((SELECT CASE WHEN g.nbToursEffectue::real/g.nbTour::real<=0.5 THEN points::real/2 ELSE points END FROM bareme WHERE place=I.positionArrivee::integer AND positionArrivee != 'A'),0)) AS "Total des points",
					COUNT((SELECT COUNT(idgp) FROM courir WHERE idpilote=P.idpilote AND positionArrivee != 'A' AND positionArrivee != '0')) "Nombre de grands prix effectués"
				FROM pilote P LEFT join courir I ON P.idpilote=I.idpilote
					LEFT JOIN grandprix G ON I.idgp=G.idgp
					LEFT JOIN circuit C ON G.id_circuit=C.id_circuit
				GROUP BY nomPilote, prenomPilote
				ORDER BY nomPilote, prenomPilote;