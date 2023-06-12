# ATM Simulator

The ATM Simulator is a Java application that simulates an Automated Teller Machine (ATM) using JSwing for the GUI and MySQL for the database. This application allows users to perform typical ATM operations, such as withdrawing funds, depositing funds, checking balances, and transferring funds between accounts.

# Features
User authentication: Users can log in to their accounts using a unique account number and PIN.
Account management: Users can view their account balance, deposit funds, withdraw funds, and transfer funds between accounts.
Transaction history: The application maintains a transaction history, allowing users to view their past transactions.
Multi-account support: Users can have multiple accounts associated with their profile.
Database integration: The application uses MySQL for storing user account information and transaction records.


# Technologies Used
Java: The programming language used to build the ATM Simulator.
JSwing: The Java GUI framework used to create the graphical user interface for the application.
MySQL: The database management system used to store user account details and transaction records.
Setup Instructions
To run the ATM Simulator locally, follow these steps:

# Prerequisites:
Install Java Development Kit (JDK) on your machine.
Install MySQL Server and create a new database to store account and transaction information.
Clone the repository:
bash
Copy code
git clone https://github.com/your-username/ATM-Simulator.git
Update the database connection details:

Open the src/main/resources/config.properties file.
Update the db.url, db.username, and db.password properties with your MySQL database connection details.
Build the application:

Open a terminal or command prompt.
Navigate to the project directory: cd ATM-Simulator.
Compile the Java source files: javac -d bin src/main/java/*.java.
Run the application:

Execute the main class: java -cp bin main.java.ATMSimulator.
Interact with the ATM Simulator:

The application will launch the login screen.
Enter the account number and PIN of an existing account to log in.
Explore the available ATM operations and follow the on-screen instructions.
Contributing
Contributions to the ATM Simulator are welcome! If you have any suggestions, bug reports, or feature requests, please open an issue or submit a pull request on the project repository.

# License
The ATM Simulator is open-source software released under the MIT License.

Feel free to customize this README.md file according to your specific project requirements and add any additional sections or information that might be relevant.