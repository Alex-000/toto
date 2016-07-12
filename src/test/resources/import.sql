

-- DROP TABLE IF EXISTS Personne_Numero;
-- DROP TABLE IF EXISTS Numero;
-- DROP TABLE IF EXISTS Personne;

DELETE FROM Personne_Numero;
DELETE FROM Numero;
DELETE FROM Personne;




--
-- Table structure for table `Numero`
--

-- CREATE TABLE Numero (id int(10) unsigned NOT NULL AUTO_INCREMENT, type varchar(255) DEFAULT NULL, numero varchar(10) NOT NULL, PRIMARY KEY (id));

--
-- Dumping data for table `Numero`
--

INSERT INTO Numero(id, type, numero) VALUES (1,'Pro','0000000000'), (2,'Domicile','0000000001'), (3,'Pro','0000000002'), (4,'Domicile','0000000003'), (5,'Mobile','0000000004'), (6,'Pro','0000000005'), (7,'Pro','0000000006'), (10,'fixe','01'), (11,'pro','fixe'), (13,'fixe','01'), (18,'fixe','02'), (19,'pro','03'), (20,'fixe','05'), (21,'fixe','09'), (22,'g','9'), (23,'dsqf','5'), (24,'hh','6');


--
-- Table structure for table `Personne`
--


-- CREATE TABLE Personne ( id int(10) unsigned NOT NULL AUTO_INCREMENT, nom varchar(255) NOT NULL, prenom varchar(255) NOT NULL, dateNaissance date DEFAULT NULL, PRIMARY KEY (id));

--
-- Dumping data for table `Personne`
--

INSERT INTO Personne(id, nom, prenom, dateNaissance) VALUES (1,'DUPONT','Martin','2000-01-01'), (2,'TOURNESOL','Professeur','1999-11-11'), (3,'HADOCK','Capitaine','1980-02-22'), (4,'TINTIN','Tintin','2005-05-05'), (8,'dupont','martin','1025-02-02'), (11,'d','d','1999-08-08'), (12,'d','d','1999-08-08'), (14,'d','d','1999-08-08'), (20,'d','d','1999-08-08'), (22,'d','a','1999-08-08'), (23,'d','e','1999-05-05'), (24,'d','z','1999-08-08'), (25,'d','c','1999-08-08'), (26,'d','f','1999-08-08'), (27,'d','j','1999-08-08'), (28,'d','h','1999-08-08'), (29,'d','t','1999-08-08'), (30,'f','l','1999-08-08'), (31,'q','q','1999-08-08'), (32,'v','v','1999-08-08'), (33,'b','b','1999-08-08'), (34,'x','x','1999-08-08'), (35,'n','n','1999-08-08'), (36,'k','k','1999-08-08'), (37,'h','h','1999-08-08');

--
-- Table structure for table `Personne_Numero`
--

-- CREATE TABLE Personne_Numero ( personnes_id int(10) unsigned NOT NULL, numeros_id int(10) unsigned NOT NULL, PRIMARY KEY (personnes_id,numeros_id), KEY foreign_numero (numeros_id), CONSTRAINT Personne_Numero_ibfk_1 FOREIGN KEY (personnes_id) REFERENCES Personne (id), CONSTRAINT Personne_Numero_ibfk_2 FOREIGN KEY (numeros_id) REFERENCES Numero (id));

--
-- Dumping data for table `Personne_Numero`
--

INSERT INTO Personne_Numero(personnes_id, numeros_id) VALUES (1,1), (1,2), (2,2), (2,3), (3,4), (3,5), (3,6), (11,10), (20,10), (22,10), (24,10), (27,10), (28,10), (31,10), (32,10), (33,10), (34,10), (35,10), (36,10), (37,10), (12,11), (14,13), (20,18), (23,19), (23,20), (24,21), (25,22), (29,23), (30,24);
