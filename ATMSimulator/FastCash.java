package ATMSimulator;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{

    JButton btn1, btn2, btn3, btn4, btn5, btn6, backBtn;
    String pinNumber;
    public FastCash(String pinNumber) 
    {
        this.pinNumber = pinNumber;
        setLayout(null);

        // implementaion for loading images file
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        //scaling the image
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        // turn the image back into a imageicon so we can put in a Jlabel and display it
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,900,900);
        add(img);


        JLabel txt = new JLabel("Select Withdraw Amount");
        txt.setBounds(230, 280, 300, 30);
        txt.setFont(new Font("System", Font.PLAIN, 16));
        txt.setForeground(Color.WHITE);
        img.add(txt);

        btn1 = new JButton("$20");
        btn1.setBounds(160, 350, 160,40);
        btn1.setFont(new Font("System", Font.BOLD, 16));
        btn1.setForeground(Color.BLACK);
        btn1.addActionListener(this);
        img.add(btn1);

        btn2 = new JButton("$40");
        btn2.setBounds(350, 350, 160,40);
        btn2.setFont(new Font("System", Font.BOLD, 16));
        btn2.setForeground(Color.BLACK);
        btn2.addActionListener(this);
        img.add(btn2);

        btn3 = new JButton("$80");
        btn3.setBounds(160, 400, 160,40);
        btn3.setFont(new Font("System", Font.BOLD, 16));
        btn3.setForeground(Color.BLACK);
        btn3.addActionListener(this);
        img.add(btn3);

        btn4 = new JButton("$100");
        btn4.setBounds(350, 400, 160,40);
        btn4.setFont(new Font("System", Font.BOLD, 16));
        btn4.setForeground(Color.BLACK);
        btn4.addActionListener(this);
        img.add(btn4);

        btn5 = new JButton("$200");
        btn5.setBounds(160, 450, 160,40);
        btn5.setFont(new Font("System", Font.BOLD, 16));
        btn5.setForeground(Color.BLACK);
        btn5.addActionListener(this);
        img.add(btn5);

        btn6 = new JButton("$400");
        btn6.setBounds(350, 450, 160,40);
        btn6.setFont(new Font("System", Font.BOLD, 16));
        btn6.setForeground(Color.BLACK);
        btn6.addActionListener(this);
        img.add(btn6);

        backBtn = new JButton("Back");
        backBtn.setBounds(350, 500, 160,40);
        backBtn.setFont(new Font("System", Font.BOLD, 16));
        backBtn.setForeground(Color.BLACK);
        backBtn.addActionListener(this);
        img.add(backBtn);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String amount = ((JButton)ae.getSource()).getText().substring(1);

        try{
            if(ae.getSource() == backBtn) 
            {
                setVisible(false);
                new Transaction(pinNumber).setVisible(true);
            }
            else{
                // this code basically extracts the text from the Jbutton
                // amount now equals the text in the JButton (any 6)
                // connect to the database
                Conn connection = new Conn();

                // create a result set for account with same pin
                ResultSet resultSet = connection.statement.executeQuery("select * from bank where Pin= '"+pinNumber+"'");
                int balance = 0;
                while(resultSet.next()) {
                    if(resultSet.getString("Account_Type").equals("Deposit")){
                        balance += Integer.parseInt(resultSet.getString("Amount"));
                    }
                    else{
                        balance -= Integer.parseInt(resultSet.getString("Amount"));
                    }
                }
                if(ae.getSource() != backBtn && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Funds to Withdraw");
                    return;
                }
                else{
                    Date date = new Date();
                    connection.statement.executeUpdate(("insert into bank values('"+pinNumber+"', '"+date+"', 'Withdraw', '"+amount+"')"));
                    JOptionPane.showMessageDialog(null, "$"+amount+" has been Withdrawn");
                }        
            }    
        } catch (SQLException e) {
            System.out.println(e);
        }
}
    public static void main(String[] args) {
        
        new FastCash("").setVisible(true);
    }



}
