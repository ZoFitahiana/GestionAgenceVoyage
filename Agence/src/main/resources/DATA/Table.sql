CREATE DATABASE voyage ;

\c voyage

CREATE TABLE client (
    id_client INT PRIMARY KEY,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    adresse VARCHAR(255),
    telephone VARCHAR(20),
    email VARCHAR(255)
);

CREATE TABLE employer (
    id_employer INT PRIMARY KEY,
    nom VARCHAR(255),
    prenom VARCHAR(255),
    poste VARCHAR(100),
    adresse VARCHAR(255),
    telephone VARCHAR(20),
    date_embauche DATE
);

CREATE TABLE voyage (
    id_voyage INT PRIMARY KEY,
    destination VARCHAR(255),
    date_depart DATE,
    duree INT,
    description TEXT,
    prix DECIMAL(10, 2),
    places_disponibles INT
);

CREATE TABLE reservation (
    id_reservation INT PRIMARY KEY,
    id_client INT,
    id_voyage INT,
    id_employer INT,
    date_reservation DATE,
    statut_reservation VARCHAR(50),
    nombre_participants INT,
    FOREIGN KEY (id_client) REFERENCES client(id_client),
    FOREIGN KEY (id_voyage) REFERENCES voyage(id_voyage),
    FOREIGN KEY (id_employer) REFERENCES employer(id_employer)
);

CREATE TABLE  payment (
    id_payment INT PRIMARY KEY,
    id_reservation INT,
    montant DECIMAL(10, 2),
    date_paiement DATE,
    methode_paiement VARCHAR(50),
    FOREIGN KEY (id_reservation) REFERENCES reservation(id_reservation)
);
