package com.example.buchalti.ui;

import com.example.buchalti.dao.BillDAO;
import com.example.buchalti.model.Bill;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.Date;

public class BillForm {
    private final BillDAO billDAO = new BillDAO();

    public void showForm() {
        Stage stage = new Stage();
        stage.setTitle("Add Bill");

        Label descriptionLabel = new Label("Description:");
        TextField descriptionField = new TextField();

        Label amountLabel = new Label("Amount:");
        TextField amountField = new TextField();

        Label dateLabel = new Label("Date:");
        DatePicker datePicker = new DatePicker();

        Label attachmentLabel = new Label("Attachment Path:");
        TextField attachmentField = new TextField();

        Button addButton = new Button("Add Bill");
        addButton.setOnAction(event -> {
            String description = descriptionField.getText();
            double amount = Double.parseDouble(amountField.getText());
            Date date = java.sql.Date.valueOf(datePicker.getValue());
            String attachmentPath = attachmentField.getText();

            Bill bill = new Bill(description, amount, date, attachmentPath);
            billDAO.addBill(bill);
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(descriptionLabel, descriptionField, amountLabel, amountField, dateLabel, datePicker, attachmentLabel, attachmentField, addButton);

        Scene scene = new Scene(layout, 400, 250);
        stage.setScene(scene);
        stage.show();
    }
}