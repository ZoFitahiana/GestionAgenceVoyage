package com.application.Agence.Repository;

import com.application.Agence.Connection.ConnectionDb;
import com.application.Agence.Model.Employer;
import com.application.Agence.Model.Reservation;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.application.Agence.Connection.ConnectionDb.connection;
@Repository
public class ReservationDAO implements  ModelDAOFactory {

    @Override
    public Reservation FindById(int id) {
        ConnectionDb.AcquireConnection();
        try{
            String sql = "select * from  reservation where id_reservation = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return  new Reservation(
                        resultSet.getInt("id_reservation"),
                        resultSet.getInt("id_client"),
                        resultSet.getInt("id_voyage"),
                        resultSet.getInt("id_employer"),
                        resultSet.getDate("date_reservation"),
                        resultSet.getString("statut_reservation"),
                        resultSet.getInt("nombre_participants")
                );
            }else {
                return null ;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Reservation> FindAll() {
        ConnectionDb.AcquireConnection();
        List<Reservation> listOfReservation = new ArrayList<>();
        try{
            String sql = "select * from reservation";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    listOfReservation.add(
                            new Reservation(
                                    resultSet.getInt("id_reservation"),
                                    resultSet.getInt("id_client"),
                                    resultSet.getInt("id_voyage"),
                                    resultSet.getInt("id_employer"),
                                    resultSet.getDate("date_reservation"),
                                    resultSet.getString("statut_reservation"),
                                    resultSet.getInt("nombre_participants")
                            )
                    );
                }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listOfReservation;
    }

    @Override
    public Reservation Register(Object entity) {
        Reservation reservations = (Reservation) entity;
        ConnectionDb.AcquireConnection();
        try{
            String sql = "insert into reservation (id_reservation,id_client,id_voyage,id_employer,date_reservation,statut_reservation,nombre_participants) values (?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,reservations.getId_reservation());
            statement.setInt(2,reservations.getId_client());
            statement.setInt(3,reservations.getId_voyage());
            statement.setInt(4,reservations.getId_employer());
            statement.setDate(5,reservations.getDate_reservation());
            statement.setString(6,reservations.getStatut_reservation());
            statement.setInt(7,reservations.getNombre_participants());
            int row = statement.executeUpdate();
            return FindById(reservations.getId_reservation());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Reservation Update(int id, Object entity) {
        Reservation reservations = (Reservation) entity;
        ConnectionDb.AcquireConnection();
        try{
            String sql = "update reservation set id_client = ? ,id_voyage = ? , id_employer = ?,date_reservation = ? ,statut_reservation = ? ,nombre_participants = ? where  id_reservation = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,reservations.getId_client());
            statement.setInt(2,reservations.getId_voyage());
            statement.setInt(3,reservations.getId_employer());
            statement.setDate(4,reservations.getDate_reservation());
            statement.setString(5,reservations.getStatut_reservation());
            statement.setInt(6,reservations.getNombre_participants());
            statement.setInt(7,id);
            int rows = statement.executeUpdate();
            return FindById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Reservation UpdatePartial(int id, Object entity) {
        Reservation reservations = (Reservation) entity;
        ConnectionDb.AcquireConnection();
        try {
            StringBuilder sql = new StringBuilder("UPDATE reservation SET ");
            List<String> updateColumns = new ArrayList<>();
            List<Object> columnValues = new ArrayList<>();
            int parameterIndex = 1;
            if (reservations.getId_client() != 0) {
                updateColumns.add("id_client = ?");
                columnValues.add(reservations.getId_client());
            }
            if (reservations.getId_voyage() != 0) {
                updateColumns.add("id_voyage = ?");
                columnValues.add(reservations.getId_voyage());
            }
            if (reservations.getId_employer() != 0) {
                updateColumns.add("id_employer = ?");
                columnValues.add(reservations.getId_employer());
            }
            if (reservations.getDate_reservation() != null) {
                updateColumns.add("date_reservation = ?");
                columnValues.add(reservations.getDate_reservation());
            }
            if (reservations.getStatut_reservation() != null){
                updateColumns.add("statut_reservation = ?");
                columnValues.add(reservations.getStatut_reservation());
            }
            if (reservations.getNombre_participants() != 0){
                updateColumns.add("nombre_participants = ?");
                columnValues.add(reservations.getNombre_participants());

            }
            sql.append(String.join(", ", updateColumns));
            sql.append(" WHERE id_reservation = ?");

            PreparedStatement statement = connection.prepareStatement(sql.toString());

            for (Object value : columnValues) {
                statement.setObject(parameterIndex++, value);
            }
            statement.setInt(parameterIndex, id);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                return FindById(id);
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Reservation> Delete(int id) {
        ConnectionDb.AcquireConnection();
        try{
            String sql = "delete from reservation where id_reservation = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            int row = statement.executeUpdate();
            return FindAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
