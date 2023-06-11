package ATMSimulator;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;







public class Withdraw extends JFrame implements ActionListener{

    JLabel accountTxt;
    JTextField amountTxtField;
    JButton withdrawBtn, backBtn;
    String pinNumber;

    public Withdraw(String pinNumber) 
    {

        this.pinNumber = pinNumber;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        //scaling the image
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        // turn the image back into a imageicon so we can put in a Jlabel and display it
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,900,900);
        add(img);

        accountTxt = new JLabel("Enter the amount you want to Withdraw");
        accountTxt.setBounds(180, 280, 300, 30);
        accountTxt.setFont(new Font("System", Font.BOLD, 12));
        accountTxt.setForeground(Color.WHITE);
        img.add(accountTxt);

        amountTxtField = new JTextField();
        amountTxtField.setBounds(160, 320, 350, 30);
        amountTxtField.setFont(new Font("System", Font.PLAIN, 16));
        img.add(amountTxtField);


        withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(350, 430, 160,40);
        withdrawBtn.setFont(new Font("System", Font.BOLD, 16));
        withdrawBtn.setForeground(Color.BLACK);
        withdrawBtn.addActionListener(this);
        img.add(withdrawBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(350, 480, 160,40);
        backBtn.setFont(new Font("System", Font.BOLD, 16));
        backBtn.setForeground(Color.BLACK);
        backBtn.addActionListener(this);
        img.add(backBtn);

        setSize(900,900);
        setLocation(350,0);
        setVisible(true);
        setUndecorated(false);
        setLayout(null);

    }
    @Override
    public void actionPerformed(ActionEvent ae){
        try{        
            String amount = amountTxtField.getText();
            Date date = new Date();
            if(ae.getSource()== withdrawBtn){
                if(amount.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                }else{
                    Conn connection = new Conn();
                  
                    connection.statement.executeUpdate("insert into bank values('"+pinNumber+"', '"+date+"', 'Withdraw', '"+amount+"')");
                    JOptionPane.showMessageDialog(null, "$"+amount+" Withdrawn Successfully");
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                }
            }else if(ae.getSource()==backBtn){
                setVisible(false);
                new Transaction(pinNumber).setVisible(true);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }   
    }
    

    public static void main(String[] args) {
        new Withdraw("").setVisible(true);
    }
}
