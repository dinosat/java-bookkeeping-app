package com.example.buchalti;

import com.example.buchalti.ui.BillForm;
import com.example.buchalti.ui.ExpenseForm;
import com.example.buchalti.ui.IncomeForm;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Bookkeeping App");
        IncomeForm incomeForm = new IncomeForm();
        ExpenseForm expenseForm = new ExpenseForm();
        BillForm billForm = new BillForm();

        Button showIncomeFormButton = new Button("Show Income Form");
        showIncomeFormButton.setOnAction(event -> incomeForm.showForm());

        Button showExpenseFormButton = new Button("Show Expense Form");
        showExpenseFormButton.setOnAction(event -> expenseForm.showForm());

        Button showBillFormButton = new Button("Show Bill Form");
        showBillFormButton.setOnAction(event -> billForm.showForm());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(showIncomeFormButton, showExpenseFormButton, showBillFormButton);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
