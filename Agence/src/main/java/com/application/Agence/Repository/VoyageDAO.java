package com.application.Agence.Repository;

import com.application.Agence.Connection.ConnectionDb;
import com.application.Agence.Model.Employer;
import com.application.Agence.Model.Voyage;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static com.application.Agence.Connection.ConnectionDb.connection;
@Repository
public class VoyageDAO implements ModelDAOFactory{
    @Override
    public Voyage FindById(int id_voyage) {
        ConnectionDb.AcquireConnection();
        try {
            String sql = "select * from voyage where id_voyage = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id_voyage);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Voyage(
                        resultSet.getInt("id_voyage"),
                        resultSet.getString("destination"),
                        resultSet.getDate("date_depart"),
                        resultSet.getInt("duree"),
                        resultSet.getString("description"),
                        resultSet.getFloat("prix"),
                        resultSet.getInt("places_disponibles")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Voyage> FindAll() {
        ConnectionDb.AcquireConnection();
        List<Voyage> voyages = new ArrayList<>();
        try{
            String sql = "select * from voyage";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                voyages.add(
                 new Voyage(
                        resultSet.getInt("id_voyage"),
                        resultSet.getString("destination"),
                        resultSet.getDate("date_depart"),
                        resultSet.getInt("duree"),
                        resultSet.getString("description"),
                        resultSet.getFloat("prix"),
                        resultSet.getInt("places_disponibles")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return voyages;
    }

    @Override
    public Voyage Register(Object entity) {
        if (!(entity instanceof Voyage voyages)) {
            throw new IllegalArgumentException("Entity must be of type voyage");
        }

        ConnectionDb.AcquireConnection();
        try{
            String sql = "insert into voyage (id_voyage,destination,date_depart,duree,description,prix,places_disponibles) values (?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,voyages.getId_voyage());
            statement.setString(2, voyages.getDestination());
            statement.setDate(3,voyages.getDate_depart());
            statement.setInt(4,voyages.getDuree());
            statement.setString(5,voyages.getDescription());
            statement.setFloat(6,voyages.getPrix());
            statement.setInt(7,voyages.getPlaces_disponibles());
             int rows = statement.executeUpdate();
             return FindById(voyages.getId_voyage());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Voyage Update(int id, Object entity) {
        if (!(entity instanceof Voyage voyages)) {
            throw new IllegalArgumentException("Entity must be of type Voyage");
        }
        ConnectionDb.AcquireConnection();

        try{
             String sql= "update voyage set destination = ?,date_depart = ?,duree = ?,description = ?,prix = ?,places_disponibles = ? where id_voyage = ? ";
             PreparedStatement statement = connection.prepareStatement(sql);
             statement.setString(1,voyages.getDestination());
             statement.setDate(2,voyages.getDate_depart());
             statement.setInt(3,voyages.getDuree());
             statement.setString(4,voyages.getDescription());
             statement.setFloat(5,voyages.getPrix());
             statement.setInt(6,voyages.getPlaces_disponibles());
             statement.setInt(7,voyages.getId_voyage());

             int rows = statement.executeUpdate();
             return FindById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Voyage UpdatePartial(int id, Object entity) {
        if (!(entity instanceof Voyage voyages)) {
            throw new IllegalArgumentException("Entity must be of type Voyage");
        }
        ConnectionDb.AcquireConnection();
         try{
             StringBuilder sql = new StringBuilder("UPDATE voyage SET ");
             List<String> updateColumns = new ArrayList<>();
             List<Object> columnValues = new ArrayList<>();
             int parameterIndex = 1;

             if (voyages.getDestination() != null){
                 updateColumns.add("destination = ?");
                 columnValues.add(voyages.getDestination());
             }
             if (voyages.getDate_depart() != null){
                 updateColumns.add("date_depart = ?");
                 columnValues.add(voyages.getDate_depart());
             }
             if (voyages.getDuree() != 0) {
                 updateColumns.add("duree = ?");
                 columnValues.add(voyages.getDuree());
             }
            if (voyages.getDescription() != null){
                updateColumns.add("description = ?");
                columnValues.add(voyages.getDescription());
            }
            if (voyages.getPrix() != 0){
                updateColumns.add("prix = ?");
                columnValues.add(voyages.getPrix());
            }
            if (voyages.getPlaces_disponibles() != 0){
                updateColumns.add("places_disponibles = ?");
                columnValues.add(voyages.getPlaces_disponibles());
            }
             if (updateColumns.isEmpty()) {
                 throw new IllegalArgumentException("No columns to update");
             }

             sql.append(String.join(", ", updateColumns));
             sql.append(" WHERE id_voyage = ?");

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
    public List<Voyage> Delete(int id) {
        ConnectionDb.AcquireConnection();
        try{
            String sql = "delete from voyage where id_voyage = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            int rows  = statement.executeUpdate();
            return  FindAll();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
