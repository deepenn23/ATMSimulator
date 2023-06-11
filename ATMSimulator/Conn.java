package ATMSimulator;

import java.sql.*;

/*
 * this class allows interaction with databases in Java applications
 * 5 step process:
    1) load the driver
    2) establish a connection to the database
    3) Create statements
    4) Execute Queries and Updates 
    5) Handling Results

 */
public class Conn {

    Connection connection;
    Statement statement;


    public Conn() {

          
        try {

            // Step 1: loading the driver
           // Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            connection = DriverManager.getConnection("jdbc:mysql:///ATMSimulator", "root", "Realmadrid1!");

            // Step 3: Create SQL statements to excuete on the databases
            statement = connection.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();
        }

   
    }

}
