A)	SELECT * FROM film WHERE NOT (extract(year from annee)>2000 OR genre = 'Policier')

B)	SELECT * FROM film WHERE (NOT extract(year from annee)>2000 AND genre = 'Drame')

C)	SELECT DISTINCT genre FROM film

D)	SELECT genre FROM film WHERE extract(year from annee)<2000

E)	SELECT nom, prenom FROM individu
	WHERE prenom = 'John'
	UNION
	SELECT nom, prenom FROM individu
	WHERE prenom = 'Paul'
   
F)	SELECT prenom FROM individu
	INTERSECT
	SELECT role FROM jouer
	
G)	SELECT titre, genre, nom FROM film CROSS JOIN cinema
	WHERE extract(year from annee)<=1985
	
H)	SELECT titre, nom, prenom FROM film INNER JOIN individu ON film.num_ind=individu.num_ind

I)	SELECT nom FROM individu WHERE nom~'[TW]'
	EXCEPT
	SELECT nom FROM individu WHERE prenom='John'
	
1)	SELECT titre FROM film WHERE genre = 'Drame'

2)	SELECT DISTINCT titre FROM film INNER JOIN projection ON film.num_film=projection.num_film INNER JOIN cinema ON projection.num_cine=cinema.num_cine
	WHERE nom = 'Le Fontenelle'
	
3)	SELECT DISTINCT nom, prenom FROM individu INNER JOIN film ON individu.num_ind=film.num_ind

4)	SELECT DISTINCT nom, prenom FROM individu INNER JOIN jouer ON individu.num_ind=jouer.num_ind

5)	SELECT DISTINCT nom, prenom FROM individu INNER JOIN film ON individu.num_ind=film.num_ind
	INTERSECT
	SELECT DISTINCT nom, prenom FROM individu INNER JOIN jouer ON individu.num_ind=jouer.num_ind

6)	SELECT DISTINCT titre FROM film INNER JOIN projection ON film.num_film=projection.num_film
	WHERE extract(year from Date)=2002
	
7)	SELECT titre FROM film INNER JOIN individu ON film.num_ind=individu.num_ind
	WHERE nom='von Trier' AND prenom='Lars'
	
8)	SELECT nom, prenom  FROM individu INNER JOIN film ON individu.num_ind=film.num_ind
	WHERE genre='Drame'
	INTERSECT
	SELECT nom, prenom  FROM individu INNER JOIN film ON individu.num_ind=film.num_ind
	WHERE genre='Epouvante'
	
9)	SELECT DISTINCT titre FROM individu INNER JOIN jouer ON individu.num_ind=jouer.num_ind INNER JOIN film ON jouer.num_film=film.num_film INNER JOIN projection ON film.num_film=projection.num_film INNER JOIN cinema ON projection.num_cine=cinema.num_cine
	WHERE individu.nom='Kidman' AND individu.prenom='Nicole' AND cinema.nom='Le Fontenelle'
	
10)	SELECT nom, prenom FROM individu INNER JOIN jouer ON individu.num_ind=jouer.num_ind INNER JOIN film ON jouer.num_film=film.num_film
	WHERE NOT (genre='Drame')

11)	SELECT DISTINCT individu.nom, prenom FROM individu inner join jouer on individu.num_ind=jouer.num_ind inner join film on jouer.num_film=film.num_film inner join projection on film.num_film=projection.num_film inner join cinema on projection.num_cine=cinema.num_cine 
	WHERE cinema.nom='Le Fontenelle' and extract(year from date)>=2000

12)	SELECT DISTINCT titre FROM film join projection on film.num_film=projection.num_film 
	WHERE (extract(year from date)-extract(year from annee ))>=5