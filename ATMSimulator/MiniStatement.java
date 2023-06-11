package ATMSimulator;

import java.awt.Color;
import java.sql.*;
import javax.swing.*;

public class MiniStatement extends JFrame {
    
    String pinNumber;
    public MiniStatement(String pinNumber) {

        this.pinNumber = pinNumber;

        setTitle("Mini Statement");

        JLabel bankName = new JLabel("SOFI BANK");
        bankName.setBounds(150,20,100,20);
        add(bankName);


        JLabel cardNum = new JLabel();
        cardNum.setBounds(20,80,300,20);
        add(cardNum);

        JLabel balanceTxt = new JLabel();
        balanceTxt.setBounds(20, 700, 400, 30);
        add(balanceTxt);
        // get card number from the database
        try {
            Conn connection = new Conn();
            ResultSet resultSet = connection.statement.executeQuery("select * from login where Pin = '"+pinNumber+"'");
            while(resultSet.next()){
                cardNum.setText("Card Number: XXXX-XXXX-XXXX-" +resultSet.getString("Card_Number").substring(11,15));
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel miniTxt = new JLabel();
        miniTxt.setBounds(20,140,400,500);
        add(miniTxt);

        // get the more transaction details from the database
        try {
            int balance = 0;
            Conn connection = new Conn();
            ResultSet resultSet = connection.statement.executeQuery("select * from bank where Pin = '"+pinNumber+"'");
            while(resultSet.next()){
                miniTxt.setText(miniTxt.getText() + "<html>"+resultSet.getString("Date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("Account_Type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("Amount") + "<br><br><html>");
                if(resultSet.getString("Account_Type").equals("Deposit")){
                    balance += Integer.parseInt(resultSet.getString("Amount"));
                }else
                {
                    balance -= Integer.parseInt(resultSet.getString("Amount"));
                }
            }

            balanceTxt.setText("Balance: $" +balance);

        } catch (Exception e) {
            System.out.println(e);
        }
        // FETCH THE ACCOUNT BALANCE from DB TO DISPLAY IT
       



        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE );
        setLayout(null);
        setVisible(true);
    }
}
