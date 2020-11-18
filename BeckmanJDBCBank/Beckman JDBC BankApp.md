# Beckman JDBC BankApp

To set up your version of this application:
  - In your Java applicaiton, create a file database.properties
  - Inside the database.properties file, you will add your endpoint to access the database
  - You will also need to enter your username and password to authorize access
For production environments...
```sh
url = endpoint 
username = your username
password = your password
adminUser = admin
adminPassword adminpass
```
Once the database.properties file is complete, import the BeckmanJDBCBank.sql file.
Make sure to run the below SQL code to access the database:
```sh
create schema if not exists bankapp authorization (your username);
set search_path to bankapp;
```

The adminUser and adminPassword are required when logging into the Admin Login. Any other username or password will not allow access.

In your Java applicaiton, run com.beckman.driver.Driver to start your jounery through the Beckman JDBC Bank Applicaiton.

Have fun!