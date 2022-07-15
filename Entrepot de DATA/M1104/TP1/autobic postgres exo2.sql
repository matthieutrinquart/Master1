
-- --------------------------------------------------------

--
-- Structure de la table 'categorie'
--


--
-- Structure de la table 'cours'
--

CREATE TABLE cours (
  refCours varchar(7) NOT NULL,
  codeorga int NOT NULL,
  designation text,
  prix decimal(10,2) DEFAULT NULL,
  lieu varchar(30) DEFAULT NULL,
  nbMaxParticip int DEFAULT NULL,
  nbMinParticip int DEFAULT NULL,
  duree int DEFAULT NULL,
  PRIMARY KEY (refCours)
);

--
-- Structure de la table 'employe'
--

CREATE TABLE employe (
  numEmp serial,
  nomEmp varchar(25) DEFAULT NULL,
  preEmp varchar(25) DEFAULT NULL,
  sexeEmp char(1) DEFAULT NULL,
  dateNais date DEFAULT NULL,
  dateEmb date DEFAULT NULL,
  PRIMARY KEY (numEmp)
);

-- Structure de la table 'facture'
--

CREATE TABLE facture (
  codeFac int NOT NULL,
  DateFac date DEFAULT NULL,
  PRIMARY KEY (codeFac)
) ;

--
-- Structure de la table 'inscrire'
--

CREATE TABLE inscrire (
  numEmp int NOT NULL,
  refCours varchar(7) NOT NULL,
  PRIMARY KEY (numEmp,refCours)
) ;

--
-- Structure de la table 'organisme'
--

CREATE TABLE organisme (
  codeorga serial,
  denomination text,
  adresse varchar(100) DEFAULT NULL,
  ville varchar(75) DEFAULT NULL,
  cp decimal(5,0) DEFAULT NULL,
  tel varchar(20) DEFAULT NULL,
  PRIMARY KEY (codeorga)
);


--
-- Structure de la table 'session'
--

CREATE TABLE session (
  numEmp int NOT NULL,
  refCours varchar(7) NOT NULL,
  codeFac int DEFAULT NULL,
  datedeb date DEFAULT NULL,
  nbplaceMax int DEFAULT NULL,
  PRIMARY KEY (numEmp,refCours)
) ;


--
-- Contraintes pour la table cours
--
ALTER TABLE cours
  ADD CONSTRAINT FK_animer FOREIGN KEY (codeorga) REFERENCES organisme (codeorga);

-

--
-- Contraintes pour la table inscrire
--
ALTER TABLE inscrire
  ADD CONSTRAINT FK_inscrirenumEmp FOREIGN KEY (numEmp) REFERENCES employe (numEmp),
  ADD CONSTRAINT FK_inscrirerefCours FOREIGN KEY (refCours) REFERENCES cours (refCours);

--
-- Contraintes pour la table session
--
ALTER TABLE session
  ADD CONSTRAINT FK_concerner FOREIGN KEY (codeFac) REFERENCES facture (codeFac),
  ADD CONSTRAINT FK__numEmp FOREIGN KEY (numEmp) REFERENCES employe (numEmp),
  ADD CONSTRAINT FK__refCours FOREIGN KEY (refCours) REFERENCES cours (refCours);
COMMIT;



