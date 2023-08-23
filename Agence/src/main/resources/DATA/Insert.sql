-- Insertions dans la table "client"
INSERT INTO client (id_client, nom, prenom, adresse, telephone, email)
VALUES
    (1, 'Dupont1', 'Jean1', '121 Rue de Paris', '0123456789', 'jean1.dupont@example.com'),
    (2, 'Dupont2', 'Jean2', '122 Rue de Paris', '0123456789', 'jean2.dupont@example.com'),
    (3, 'Dupont3', 'Jean3', '123 Rue de Paris', '0123456789', 'jean3.dupont@example.com'),
    (4, 'Dupont4', 'Jean4', '124 Rue de Paris', '0123456789', 'jean4.dupont@example.com'),
    (5, 'Martin5', 'Jean5, '',125 Rue de Paris ','9876543210', 'jean5.martin@example.com');

-- Insertions dans la table "employer"
INSERT INTO employer (id_employer, nom, prenom, poste, adresse, telephone, date_embauche)
VALUES
    (1, 'Garcia1', 'Alex1', 'Agent de Réservation', '781 Rue de la Gare', '4567890123', '2020-05-15'),
    (2, 'Garcia2', 'Alex2', 'Agent de Réservation', '782 Rue de la Gare', '4567890123', '2020-05-16'),
    (3, 'Garcia3', 'Alex3', 'Agent de Réservation', '783 Rue de la Gare', '4567890123', '2020-05-17'),
    (4, 'Garcia4', 'Alex3', 'Agent de Réservation', '784 Rue de la Gare', '4567890123', '2020-05-18'),
    (5, 'Lefebvre', 'Marie5', 'Responsable Voyages', '567 Boulevard du Monde', '7890123456', '2018-10-20');

-- Insertions dans la table "voyage"
INSERT INTO voyage (id_voyage, destination, date_depart, duree, description, prix, places_disponibles)
VALUES
    (1, 'Paris', '2023-09-01', 7, 'Découvrez la ville de l amour', 1200.00, 20),
    (2, 'Paris', '2023-09-01', 7, 'Découvrez la ville de l amour', 1200.00, 20),
    (3, 'Paris', '2023-09-01', 7, 'Découvrez la ville de l amour', 1200.00, 20),
    (4, 'Paris', '2023-09-01', 7, 'Découvrez la ville de l amour', 1200.00, 20),
    (5, 'New York', '2023-10-15', 10, 'Explorez la ville qui ne dort jamais', 2500.00, 15);

-- Insertions dans la table "reservation"
INSERT INTO reservation (id_reservation, id_client, id_voyage, id_employer, date_reservation, statut_reservation, nombre_participants)
VALUES
    (1, 1, 1, 1, '2023-07-20', 'En attente', 2),
    (2, 2, 2, 2, '2023-07-20', 'En attente', 2),
    (3, 3, 3, 3, '2023-07-20', 'En attente', 2),
    (4, 4, 4, 4, '2023-07-20', 'En attente', 2),
    (5, 5, 5, 5, '2023-07-25', 'Confirmée', 1);

-- Insertions dans la table "payment"
INSERT INTO payment (id_payment, id_reservation, montant, date_paiement, methode_paiement)
VALUES
    (1, 1, 1200.00, '2023-07-25', 'Carte de crédit'),
    (2, 2, 1200.00, '2023-07-25', 'Carte de crédit'),
    (3, 3, 1200.00, '2023-07-25', 'Carte de crédit'),
    (4, 4, 1200.00, '2023-07-25', 'Carte de crédit'),
    (5, 5, 2500.00, '2023-07-28', 'Virement bancaire');

