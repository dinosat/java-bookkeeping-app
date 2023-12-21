package com.example.buchalti.dao;

import com.example.buchalti.dao.config.DatabaseConnector;
import com.example.buchalti.model.Expense;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {
    private static final String INSERT_EXPENSE_SQL = "INSERT INTO expense (description, amount, date) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_EXPENSES_SQL = "SELECT * FROM expense";

    public void addExpense(Expense expense) {
        try (Connection connection = DatabaseConnector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EXPENSE_SQL)) {

            preparedStatement.setString(1, expense.getDescription());
            preparedStatement.setDouble(2, expense.getAmount());
            preparedStatement.setDate(3, new java.sql.Date(expense.getDate().getTime()));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }

    public List<Expense> getAllExpenses() {
        List<Expense> expenses = new ArrayList<>();
        try (Connection connection = DatabaseConnector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SELECT_ALL_EXPENSES_SQL)) {

            while (resultSet.next()) {
                Expense expense = new Expense(
                        resultSet.getString("description"),
                        resultSet.getDouble("amount"),
                        resultSet.getDate("date")
                );
                expenses.add(expense);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
        return expenses;
    }

}