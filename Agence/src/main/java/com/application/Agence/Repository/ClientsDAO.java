package com.application.Agence.Repository;

import com.application.Agence.Connection.ConnectionDb;
import com.application.Agence.Model.Client;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.application.Agence.Connection.ConnectionDb.connection;

@Repository

public class ClientsDAO implements ModelDAOFactory {
    @Override
    public Client FindById(int id_client) {
        ConnectionDb.AcquireConnection();
        try {
            String sql = "select * from client where id_client = ? ;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id_client);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Client(
                        resultSet.getInt("id_client"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("adresse"),
                        resultSet.getString("telephone"),
                        resultSet.getString("email")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Client> FindAll() {
        ConnectionDb.AcquireConnection();
        List<Client> AllClient = new ArrayList<>();
        try {
            String sql = "select * from client ;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                AllClient.add(new Client(
                        resultSet.getInt("id_client"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("adresse"),
                        resultSet.getString("telephone"),
                        resultSet.getString("email")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return AllClient;
    }

    @Override
    public Client Register(Object entity) {
        Client client = (Client) entity ;
        ConnectionDb.AcquireConnection();
        try {
            String sql = "INSERT INTO client (id_client, nom, prenom, adresse, telephone, email) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, client.getId_client());
            statement.setString(2, client.getNom());
            statement.setString(3, client.getPrenom());
            statement.setString(4, client.getAdresse());
            statement.setString(5, client.getTelephone());
            statement.setString(6, client.getEmail());

            int rowsInserted = statement.executeUpdate();
            return FindById(client.getId_client());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Client Update(int id, Object entity) {
        Client client = (Client) entity ;
        ConnectionDb.AcquireConnection();
        try {
            String sql = "UPDATE client SET nom = ?, prenom = ?, adresse = ?, telephone = ?, email = ? WHERE id_client = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, client.getNom());
            statement.setString(2, client.getPrenom());
            statement.setString(3, client.getAdresse());
            statement.setString(4, client.getTelephone());
            statement.setString(5, client.getEmail());
            statement.setInt(6, id);

            int rowsUpdate = statement.executeUpdate();
            return FindById(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Client UpdatePartial(int id, Object entity) {
        Client client = (Client) entity ;
        ConnectionDb.AcquireConnection();
        try {
            StringBuilder sql = new StringBuilder("UPDATE client SET ");
            List<String> updateColumns = new ArrayList<>();
            List<Object> columnValues = new ArrayList<>();
            int parameterIndex = 1;

            if ( client.getNom()!= null) {
                updateColumns.add("nom = ?");
                columnValues.add(client.getNom());
            }

            if (client.getPrenom() != null) {
                updateColumns.add("prenom = ?");
                columnValues.add(client.getPrenom());
            }

            if (client.getAdresse() != null) {
                updateColumns.add("adresse = ?");
                columnValues.add(client.getAdresse());
            }

            if (client.getTelephone() != null) {
                updateColumns.add("telephone = ?");
                columnValues.add(client.getTelephone());
            }

            if (client.getEmail() != null) {
                updateColumns.add("email = ?");
                columnValues.add(client.getEmail());
            }

            if (updateColumns.isEmpty()) {
                throw new IllegalArgumentException("No columns to update");
            }

            sql.append(String.join(", ", updateColumns));
            sql.append(" WHERE id_client = ?");

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
    public List<Client> Delete(int id_client) {
        ConnectionDb.AcquireConnection();
        try{
            String sql = "delete from client where id_client = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id_client);
            int rowDelete = statement.executeUpdate();
            return FindAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
