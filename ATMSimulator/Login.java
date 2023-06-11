package ATMSimulator;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
/*
 * Jframe from the swing library allows us to create frame with title bar and border.
 */
public class Login extends JFrame implements ActionListener{

    JButton login, clear, signup;
    JTextField cardFieldText;
    JPasswordField pinTextField;


    public Login() {
        
            // Add image to the frame (scaled using image class from awt package)
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));          // find image by giving the pathway of the designated file  
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);     //  sets the size of the new scaled image
        ImageIcon i3 = new ImageIcon(i2);                                                           // change the scaled image back to Imageicon in order to display it in the frame using JLabel
        JLabel label = new JLabel(i3);                                                              // create a label to put the image in..
        label.setBounds(70,10,100,100);                                         // moves image icon top left
        add(label);                                                                                // add the label in the frame that contains the image

             // ADDING Text to the frame (change fonts, size, etx ) => JLABEL
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setBounds(200, 40, 400, 40); // need to set bounds in order to display the label because setLayout is null therefore we need to manually define the label
        text.setFont(new Font("Times New Roman", Font.BOLD, 38));
        add(text);

        JLabel cardNo = new JLabel("Card Number: ");
        cardNo.setBounds(120, 220, 250, 30); // need to set bounds in order to display the label because setLayout is null therefore we need to manually define the label
        cardNo.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(cardNo);

            // Adding a text field
        cardFieldText = new JTextField();
        cardFieldText.setBounds(300, 220, 250, 30);
        cardFieldText.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardFieldText);

        JLabel pin = new JLabel("PIN: ");
        pin.setBounds(120, 300, 250, 30); // need to set bounds in order to display the label because setLayout is null therefore we need to manually define the label
        pin.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 300, 250, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

      
            // Adding Buttons
        login = new JButton("LOGIN");
        login.setBounds(300,350,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.setOpaque(true);
        login.setBorderPainted(false);
        login.addActionListener(this);
        add(login);


        clear = new JButton("CLEAR");
        clear.setBounds(450,350,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setOpaque(true);
        clear.setBorderPainted(false);
        clear.addActionListener(this);
        add(clear);


        signup = new JButton("SIGN UP");
        signup.setBounds(300,395,250,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.setOpaque(true);
        signup.setBorderPainted(false);
        signup.addActionListener(this);    
        add(signup);
        // setting and displaying the frame
                        //opening postion of the frame
      getContentPane().setBackground(Color.LIGHT_GRAY);
      setTitle("ATM");
      setSize(900, 900);
      setLocation(350, 30);
      setLayout(null);
      setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource() == login) 
        {
            // establish connection
            Conn conncection = new Conn();

            String cardNum = cardFieldText.getText();
            String pinNum = pinTextField.getText();
            String query = "select * from login where Card_Number = '"+cardNum+"' and Pin = '"+pinNum+"'";

            try {
                
                ResultSet resultSet = conncection.statement.executeQuery(query);
                if(resultSet.next())
                {
                    setVisible(false);
                    new Transaction(pinNum).setVisible(true);
                }
                else 
                {
                    JOptionPane.showMessageDialog(null, "Invalid Card Number or PIN!!!");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        else if (ae.getSource() == clear) 
        {
            cardFieldText.setText("");       // clears the text if the clear button is clicked  
            pinTextField.setText("");       // use the setText function with an empty string to get the clearing the text field mechanism
        }

        else if (ae.getSource() == signup)
        {
            //opens the signup page if the signup button is pressed
            setVisible(false);
            new SignupOne().setVisible(true); 
        }
    }
    
    public static void main(String[] args) {
        
        Login login = new Login();
    }
}