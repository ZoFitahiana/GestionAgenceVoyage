package com.application.Agence.Repository;

import com.application.Agence.Connection.ConnectionDb;
import com.application.Agence.Model.Payment;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.application.Agence.Connection.ConnectionDb.connection;
@Repository
public class PaymentDAO implements ModelDAOFactory {

    @Override
    public Payment FindById(int id) {
        ConnectionDb.AcquireConnection();
        try {
            String sql = "select * from payment where id_payment = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return new Payment(
                        resultSet.getInt("id_payment"),
                        resultSet.getInt("id_reservation"),
                        resultSet.getFloat("montant"),
                        resultSet.getDate("date_paiement"),
                        resultSet.getString("methode_paiement")
                );
            }
            else {
                return  null;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Payment> FindAll() {
        ConnectionDb.AcquireConnection();
        List<Payment> payments = new ArrayList<>();
        try{
            String sql = "select * from payment";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                payments.add( new Payment(
                        resultSet.getInt("id_payment"),
                        resultSet.getInt("id_reservation"),
                        resultSet.getFloat("montant"),
                        resultSet.getDate("date_paiement"),
                        resultSet.getString("methode_paiement")
                ));
            }
            return payments;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Payment Register(Object entity) {
        Payment payment = (Payment) entity;
        ConnectionDb.AcquireConnection();
        try{
            String sql = "insert into payment (id_payment,id_reservation,montant,date_paiement,methode_paiement) values(?,?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,payment.getId_payment());
            statement.setInt(2,payment.getId_reservation());
            statement.setFloat(3,payment.getMontant());
            statement.setDate(4,payment.getDate_paiement());
            statement.setString(5,payment.getMethode_paiement());
            int row = statement.executeUpdate();
            return FindById(payment.getId_payment());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Payment Update(int id, Object entity) {
        Payment payment = (Payment) entity;
        ConnectionDb.AcquireConnection();
        try{
            String sql = "update payment set id_reservation = ? ,montant = ?,date_paiement = ? ,methode_paiement = ? where id_payment = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,payment.getId_reservation());
            statement.setFloat(2,payment.getMontant());
            statement.setDate(3,payment.getDate_paiement());
            statement.setString(4,payment.getMethode_paiement());
            statement.setInt(5,id);
            int row = statement.executeUpdate();
            return FindById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Payment UpdatePartial(int id, Object entity) {
        Payment payment = (Payment) entity;
        ConnectionDb.AcquireConnection();
        try{
            StringBuilder sql = new StringBuilder("UPDATE payment SET ");
            List<String> updateColumns = new ArrayList<>();
            List<Object> columnValues = new ArrayList<>();
            int parameterIndex = 1;
            if (payment.getId_reservation() != 0){
                updateColumns.add("id_reservation = ?");
                columnValues.add(payment.getId_reservation());
            }
            if (payment.getMontant() != 0){
                updateColumns.add("montant = ?");
                columnValues.add(payment.getMontant());
            }
            if (payment.getDate_paiement() != null){
                updateColumns.add("date_paiement = ?");
                columnValues.add(payment.getDate_paiement());
            }
            if (payment.getMethode_paiement() != null){
                updateColumns.add("methode_paiement = ?");
                columnValues.add(payment.getMethode_paiement());
            }
            sql.append(String.join(", ", updateColumns));
            sql.append(" WHERE id_payment = ?");

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
    public List<Payment> Delete(int id) {
        ConnectionDb.AcquireConnection();
        try{
            String sql = "delete from payment where id_payment = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            int rows = statement.executeUpdate();
            return  FindAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

