package com.application.Agence.Repository;

import com.application.Agence.Connection.ConnectionDb;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.application.Agence.Connection.ConnectionDb.connection;
@Repository
public class Bonus {
    public List<Map<String, Object>> getReservationInfo() {
        List<Map<String, Object>> reservationInfos = new ArrayList<>();
        ConnectionDb.AcquireConnection();
        try {
            String sql = "SELECT " +
                    "reservation.id_reservation, " +
                    "CONCAT(client.nom, ' ', client.prenom) AS client, " +
                    "voyage.destination, " +
                    "voyage.date_depart, " +
                    "CONCAT(employer.nom, ' ', employer.prenom) AS employer, " +
                    "payment.montant, " +
                    "payment.date_paiement, " +
                    "reservation.statut_reservation " +
                    "FROM " +
                    "reservation " +
                    "INNER JOIN client ON reservation.id_client = client.id_client " +
                    "INNER JOIN voyage ON reservation.id_voyage = voyage.id_voyage " +
                    "INNER JOIN employer ON reservation.id_employer = employer.id_employer " +
                    "INNER JOIN payment ON reservation.id_reservation = payment.id_reservation";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Map<String, Object> info = new HashMap<>();
                info.put("id_reservation", resultSet.getInt("id_reservation"));
                info.put("client", resultSet.getString("client"));
                info.put("destination", resultSet.getString("destination"));
                info.put("date_depart", resultSet.getDate("date_depart"));
                info.put("employer", resultSet.getString("employer"));
                info.put("montant", resultSet.getDouble("montant"));
                info.put("date_paiement", resultSet.getDate("date_paiement"));
                info.put("statut_reservation", resultSet.getString("statut_reservation"));
                reservationInfos.add(info);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }return reservationInfos;
    }

}
