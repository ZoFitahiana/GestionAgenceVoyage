-- Insertions pour la table "client"
INSERT INTO client (id_client, nom, prenom, adresse, telephone, email)
VALUES
    (1, 'Dupont', 'Jean', '123 Rue des Roses', '1234567890', 'jean.dupont@example.com'),
    (2, 'Martin', 'Marie', '456 Avenue des Lilas', '9876543210', 'marie.martin@example.com'),
    (3, 'Lopez', 'Carlos', '789 Rue de la Mer', '5678901234', 'carlos.lopez@example.com'),
    (4, 'Smith', 'Emily', '1010 Oak Street', '5551234567', 'emily.smith@example.com'),
    (5, 'Kim', 'Jiyoung', '234 Cherry Lane', '9998887777', 'jiyoung.kim@example.com');

-- Insertions pour la table "employer"
INSERT INTO employer (id_employer, nom, prenom, poste, adresse, telephone, date_embauche)
VALUES
    (1, 'Garcia', 'Julie', 'Directeur des Voyages', '789 Rue des Orchidées', '4567890123', '2020-01-15'),
    (2, 'Lefebvre', 'Pierre', 'Agent de Réservation', '987 Chemin des Pins', '7890123456', '2021-03-20'),
    (3, 'Johnson', 'Michael', 'Responsable Marketing', '123 Elm Street', '1234567890', '2019-11-10'),
    (4, 'Chen', 'Wei', 'Guide Touristique', '456 Pine Avenue', '2345678901', '2022-05-05'),
    (5, 'Sato', 'Yuki', 'Agent de Voyage', '789 Maple Road', '3456789012', '2023-02-18');

-- Insertions pour la table "voyage"
INSERT INTO voyage (id_voyage, destination, date_depart, duree, description, prix, places_disponibles)
VALUES
    (1, 'Paris', '2023-09-01', 7, 'Découvrez la magnifique ville de Paris.', 1500.00, 20),
    (2, 'New York', '2023-10-15', 10, 'Explorez la ville qui ne dort jamais.', 2200.00, 15),
    (3, 'Tokyo', '2023-11-20', 14, 'Plongez dans la culture japonaise moderne.', 2800.00, 25),
    (4, 'Rome', '2023-09-10', 6, 'Découvrez l histoire de l ancienne Rome.', 1800.00, 10),
    (5, 'Bali', '2023-12-05', 9, 'Détendez-vous sur les plages de sable fin.', 2000.00, 30);

-- Insertions pour la table "reservation"
INSERT INTO reservation (id_reservation, id_client, id_voyage, id_employer, date_reservation, statut_reservation, nombre_participants)
VALUES
    (1, 1, 1, 2, '2023-08-20', 'Confirmée', 2),
    (2, 2, 3, 4, '2023-07-15', 'En attente', 1),
    (3, 3, 2, 3, '2023-08-10', 'Confirmée', 2),
    (4, 4, 4, 1, '2023-06-25', 'Annulée', 0),
    (5, 5, 5, 5, '2023-07-30', 'Confirmée', 1);

-- Insertions pour la table "payement"
INSERT INTO payment (id_payment, id_reservation, montant, date_paiement, methode_paiement)
VALUES
    (1, 1, 1200.00, '2023-08-25', 'Carte de crédit'),
    (2, 2, 1400.00, '2023-07-18', 'PayPal'),
    (3, 3, 2000.00, '2023-08-12', 'Virement bancaire'),
    (4, 4, 0.00, '2023-06-30', 'Aucun paiement'),
    (5, 5, 1000.00, '2023-08-01', 'Espèces');
