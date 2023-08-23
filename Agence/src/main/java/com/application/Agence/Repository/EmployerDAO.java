package com.application.Agence.Repository;

import com.application.Agence.Connection.ConnectionDb;
import com.application.Agence.Model.Client;
import com.application.Agence.Model.Employer;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.application.Agence.Connection.ConnectionDb.connection;
@Repository

public class EmployerDAO implements ModelDAOFactory {
    @Override
    public Employer FindById(int id_employer) {
        ConnectionDb.AcquireConnection();
        try{
            String sql = "select * from employer where id_employer = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id_employer);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return new Employer(
                        resultSet.getInt("id_employer"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("poste"),
                        resultSet.getString("adresse"),
                        resultSet.getString("telephone"),
                        resultSet.getDate("date_embauche")
                );
            }else {
                return null ;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employer> FindAll() {
        ConnectionDb.AcquireConnection();
        List<Employer> employers = new ArrayList<>();
        try{
            String sql = "select * from employer ";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                employers.add(new Employer(
                        resultSet.getInt("id_employer"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("poste"),
                        resultSet.getString("adresse"),
                        resultSet.getString("telephone"),
                        resultSet.getDate("date_embauche")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employers;
    }

    @Override
    public Employer Register(Object entity) {
        Employer employer = (Employer) entity;
        ConnectionDb.AcquireConnection();
        try{
            String sql = "insert into employer (id_employer,nom,prenom,poste,adresse,telephone,date_embauche) values(?,?,?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,employer.getId_employer());
            statement.setString(2, employer.getNom());
            statement.setString(3, employer.getPrenom());
            statement.setString(4, employer.getPoste());
            statement.setString(5, employer.getAdresse());
            statement.setString(6, employer.getTelephone());
            statement.setDate(7,employer.getDate_embauche());

            int rowsEmployer = statement.executeUpdate();
            return FindById(employer.getId_employer());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employer Update(int id, Object entity) {
        Employer employer = (Employer) entity;
        ConnectionDb.AcquireConnection();
        try{
            String sql = "update employer set nom = ? , prenom = ? ,poste = ? ,adresse = ?,telephone = ?,date_embauche = ? where id_employer = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(7,id);
            statement.setString(1, employer.getNom());
            statement.setString(2, employer.getPrenom());
            statement.setString(3, employer.getPoste());
            statement.setString(4, employer.getAdresse());
            statement.setString(5, employer.getTelephone());
            statement.setDate(6,employer.getDate_embauche());

            int rowsUpdate = statement.executeUpdate();
            return FindById(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employer UpdatePartial(int id, Object entity) {
        Employer employer = (Employer) entity;
        ConnectionDb.AcquireConnection();
        try{
            StringBuilder sql = new StringBuilder("UPDATE employer SET ");
            List<String> updateColumns = new ArrayList<>();
            List<Object> columnValues = new ArrayList<>();
            int parameterIndex = 1;
            if (employer.getNom() != null){
                updateColumns.add("nom = ?");
                columnValues.add(employer.getNom());
            }
            if (employer.getPrenom() != null){
                updateColumns.add("prenom = ?");
                columnValues.add(employer.getPrenom());
            }
            if (employer.getPoste() != null){
                updateColumns.add("poste = ?");
                columnValues.add(employer.getPoste());
            }
            if (employer.getAdresse() != null){
                updateColumns.add("adresse = ?");
                columnValues.add(employer.getAdresse());
            }
            if (employer.getTelephone() != null){
                updateColumns.add("telephone = ?");
                columnValues.add(employer.getTelephone());
            }
            if (employer.getDate_embauche() != null){
                updateColumns.add("date_embauche = ?");
                columnValues.add(employer.getDate_embauche());
            }
            if (updateColumns.isEmpty()) {
                throw new IllegalArgumentException("No columns to update");
            }

            sql.append(String.join(", ", updateColumns));
            sql.append(" WHERE id_employer = ?");

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
    public List<Employer> Delete(int id) {
           ConnectionDb.AcquireConnection();
           try{
               String sql = "delete from employer where id_employer = ?";
               PreparedStatement statement = connection.prepareStatement(sql);
               statement.setInt(1,id);
               int rowDelete = statement.executeUpdate();
               return FindAll();

           } catch (SQLException e) {
               throw new RuntimeException(e);
           }
    }
}
