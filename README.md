# Java Bookkeeping Application

## Overview

This is a simple Java bookkeeping application designed for small firms operating under Austrian law. The application helps users manage income, expenses, and bills while adhering to the Einnahmen-Ausgaben-Rechnung (income-expense billing) method for determining profits.

## Features

- **Data Models:** Java classes representing key entities (Income, Expense, Bill).
- **Data Access Objects (DAOs):** Database operations for each entity.
- **User Interface (UI):** JavaFX forms for entering and displaying income, expenses, and bills.

## Prerequisites

- Java Development Kit (JDK) installed
- JavaFX library configured in your project
- PostgreSQL or SQLite database

## Setup

1. Clone the repository:

    ```bash
    git clone https://github.com/dinosat/java-bookkeeping-app.git
    ```

2. Set up your database:

    - For PostgreSQL, create a database and update the `DatabaseConnector` class with your connection details.
    - For SQLite, ensure the SQLite JDBC driver is in your dependencies.

3. Configure environment variables or an `.env` file for database credentials.

4. Build and run the application:

    ```bash
    cd java-bookkeeping-app
    ./mvnw clean javafx:run
    ```

## Usage

- Run the `MainApp` class to launch the main application window.
- Use the provided buttons to show forms for entering income, expenses, and bills.

