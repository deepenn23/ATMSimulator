package ATMSimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowBalance extends JFrame implements ActionListener{
    
    JButton backBtn;
    JLabel balanceTxt;
    String pinNumber;
    int balance;


    public ShowBalance(String pinNumber){
        this.pinNumber = pinNumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        //scaling the image
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        // turn the image back into a imageicon so we can put in a Jlabel and display it
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,900,900);
        add(img); 

        backBtn = new JButton("Back");
        backBtn.setBounds(350, 480, 160,40);
        backBtn.setFont(new Font("System", Font.BOLD, 16));
        backBtn.setForeground(Color.BLACK);
        backBtn.addActionListener(this);
        img.add(backBtn);
        

       try {
            
        Conn connection = new Conn();

        // create a result set for account with same pin
        ResultSet resultSet = connection.statement.executeQuery("select * from bank where Pin= '"+pinNumber+"'");
        balance = 0;
        while(resultSet.next()) {
            if(resultSet.getString("Account_Type").equals("Deposit")){
                balance += Integer.parseInt(resultSet.getString("Amount"));
            }
            else{
                balance -= Integer.parseInt(resultSet.getString("Amount"));
            }
        }
    
    } catch (SQLException e) {
        System.out.println(e);
       }

       balanceTxt = new JLabel("Your balance is $" +balance);
       balanceTxt.setBounds(180, 300, 400, 50);
       balanceTxt.setForeground(Color.WHITE);
       balanceTxt.setFont(new Font("System", Font.PLAIN, 22));
       img.add(balanceTxt);
        

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {   
        if(ae.getSource() == backBtn){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
     }
        } catch (Exception e) {
            System.out.println(e);
        }
        }
    public static void main(String[] args) {
        new ShowBalance("").setVisible(true);
    }

}
