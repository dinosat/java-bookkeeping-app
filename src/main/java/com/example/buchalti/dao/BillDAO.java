package com.example.buchalti.dao;

import com.example.buchalti.dao.config.DatabaseConnector;
import com.example.buchalti.model.Bill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillDAO {
    private static final String INSERT_BILL_SQL = "INSERT INTO bill (description, amount, date, attachment_path) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_BILLS_SQL = "SELECT * FROM bill";

    public void addBill(Bill bill) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BILL_SQL)) {

            preparedStatement.setString(1, bill.getDescription());
            preparedStatement.setDouble(2, bill.getAmount());
            preparedStatement.setDate(3, new java.sql.Date(bill.getDate().getTime()));
            preparedStatement.setString(4, bill.getAttachmentPath());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }

    public List<Bill> getAllBills() {
        List<Bill> bills = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_BILLS_SQL)) {

            while (resultSet.next()) {
                Bill bill = new Bill(
                        resultSet.getString("description"),
                        resultSet.getDouble("amount"),
                        resultSet.getDate("date"),
                        resultSet.getString("attachment_path")
                );
                bills.add(bill);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
        return bills;
    }

    // Other methods for CRUD operations can be added here
}