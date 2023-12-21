package com.example.buchalti.dao;

import com.example.buchalti.dao.config.DatabaseConnector;
import com.example.buchalti.model.Income;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IncomeDAO {
    private static final String INSERT_INCOME_SQL = "INSERT INTO income (description, amount, date) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_INCOMES_SQL = "SELECT * FROM income";

    public void addIncome(Income income) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INCOME_SQL)) {

            preparedStatement.setString(1, income.getDescription());
            preparedStatement.setDouble(2, income.getAmount());
            preparedStatement.setDate(3, new java.sql.Date(income.getDate().getTime()));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }

    public List<Income> getAllIncomes() {
        List<Income> incomes = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_INCOMES_SQL)) {

            while (resultSet.next()) {
                Income income = new Income(
                        resultSet.getString("description"),
                        resultSet.getDouble("amount"),
                        resultSet.getDate("date")
                );
                incomes.add(income);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
        return incomes;
    }

    // Other methods for CRUD operations can be added here
}