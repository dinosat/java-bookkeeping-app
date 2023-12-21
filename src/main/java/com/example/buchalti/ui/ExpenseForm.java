package com.example.buchalti.ui;

import com.example.buchalti.dao.ExpenseDAO;
import com.example.buchalti.model.Expense;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Date;

public class ExpenseForm {
    private final ExpenseDAO expenseDAO = new ExpenseDAO();

    public void showForm() {
        Stage stage = new Stage();
        stage.setTitle("Add Expense");

        Label descriptionLabel = new Label("Description:");
        TextField descriptionField = new TextField();

        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();

        Label dateLabel = new Label("Date:");
        DatePicker datePicker = new DatePicker();

        Button addButton = new Button("Add Expense");
        addButton.setOnAction(event -> {
            String description = descriptionField.getText();
            double amount = Double.parseDouble(amountField.getText());
            Date date = java.sql.Date.valueOf(datePicker.getValue());

            Expense expense = new Expense(description, amount, date);
            expenseDAO.addExpense(expense);
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(descriptionLabel, descriptionField, amountLabel, amountField, dateLabel, datePicker, addButton);

        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.show();
    }
}
