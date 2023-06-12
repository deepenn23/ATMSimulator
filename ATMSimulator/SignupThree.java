package ATMSimulator;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;


public class SignupThree extends JFrame implements ActionListener{

    JLabel accountDetailstxt, accountTypetxt, cardNumTxt, cardNum, cardDetails, pinTxt, pin, pinDetails, serviceRequiredTxt;
    JRadioButton savingAccountBtn, fixedDepositBtn, currentAccountBtn, recurringDepositBtn;
    JCheckBox chkbox1, chkbox2, chkbox3, chkbox4, chkbox5, chkbox6, chkbox7; 
    JButton submitBtn, cancelBtn;
    ButtonGroup accountTypeBtnGroup;
    String formNo;
    public SignupThree(String formNo) 
    {
        this.formNo = formNo;

        // setting frame (Jframe

        accountDetailstxt = new JLabel("Page 3: Account Details");
        accountDetailstxt.setFont(new Font("Helvetica", Font.BOLD, 26));
        accountDetailstxt.setBounds(250, 80, 400, 30);
        add(accountDetailstxt);


       accountTypetxt = new JLabel("Account Type");
       accountTypetxt.setFont(new Font("Helvetica", Font.BOLD, 22));
       accountTypetxt.setBounds(100, 130, 300, 30);
       add(accountTypetxt);

       savingAccountBtn = new JRadioButton("Saving Account");
       savingAccountBtn.setFont(new Font("Halvetica", Font.BOLD, 16));
       savingAccountBtn.setBounds(100, 180, 200, 30);
       add(savingAccountBtn);

       fixedDepositBtn = new JRadioButton("Fixed Deposit Amount");
       fixedDepositBtn.setFont(new Font("Halvetica", Font.BOLD, 16));
       fixedDepositBtn.setBounds(400, 180, 250, 30);
       add(fixedDepositBtn);

       currentAccountBtn = new JRadioButton("Current Account");
       currentAccountBtn.setFont(new Font("Halvetica", Font.BOLD, 16));
       currentAccountBtn.setBounds(100, 230, 200, 30);
       add(currentAccountBtn);

       recurringDepositBtn = new JRadioButton("Recurring Deposit Amount");
       recurringDepositBtn.setFont(new Font("Halvetica", Font.BOLD, 16));
       recurringDepositBtn.setBounds(400, 230, 300, 30);
       add(recurringDepositBtn);

       accountTypeBtnGroup = new ButtonGroup();
       accountTypeBtnGroup.add(savingAccountBtn);
       accountTypeBtnGroup.add(fixedDepositBtn);
       accountTypeBtnGroup.add(currentAccountBtn);
       accountTypeBtnGroup.add(recurringDepositBtn);

       cardNumTxt = new JLabel("Card Number");
       cardNumTxt.setFont(new Font("Halvetica", Font.BOLD, 22));
       cardNumTxt.setBounds(100, 300, 300, 30);
       add(cardNumTxt);

       cardNum = new JLabel("XXXX-XXXX-XXXX-1234");
       cardNum.setFont(new Font("Halvetica", Font.BOLD, 22));
       cardNum.setBounds(400, 300, 300, 30);
       add(cardNum);

       cardDetails = new JLabel("Your 16 digit card number");
       cardDetails.setFont(new Font("Halvetica", Font.BOLD, 12));
       cardDetails.setBounds(100, 330, 300, 20);
       add(cardDetails);

       pinTxt = new JLabel("PIN: ");
       pinTxt.setFont(new Font("Halvetica", Font.BOLD, 22));
       pinTxt.setBounds(100, 380, 300, 30);
       add(pinTxt);

       pin = new JLabel("XXXX");
       pin.setFont(new Font("Halvetica", Font.BOLD, 22));
       pin.setBounds(400, 380, 300, 30);
       add(pin);

       pinDetails = new JLabel("Your 4 digit pin number");
       pinDetails.setFont(new Font("Halvetica", Font.BOLD, 12));
       pinDetails.setBounds(100, 410, 300, 20);
       add(pinDetails);



       serviceRequiredTxt = new JLabel("Service Required: ");
       serviceRequiredTxt.setFont(new Font("Halvetica", Font.BOLD, 18));
       serviceRequiredTxt.setBounds(100, 460, 300, 30);
       add(serviceRequiredTxt);

       // checkbox implementation 
       chkbox1 = new JCheckBox("ATM CARD");
       chkbox1.setFont(new Font("Halvetica", Font.BOLD, 14));
       chkbox1.setBounds(100, 500, 300, 30);
       add(chkbox1);

       chkbox2 = new JCheckBox("Internet Banking");
       chkbox2.setFont(new Font("Halvetica", Font.BOLD, 14));
       chkbox2.setBounds(400, 500, 300, 30);
       add(chkbox2);

       chkbox3 = new JCheckBox("Mobile Banking");
       chkbox3.setFont(new Font("Halvetica", Font.BOLD, 14));
       chkbox3.setBounds(100, 550, 300, 30);
       add(chkbox3);

       chkbox4 = new JCheckBox("EMAIL & SMS ALERT");
       chkbox4.setFont(new Font("Halvetica", Font.BOLD, 14));
       chkbox4.setBounds(400, 550, 300, 30);
       add(chkbox4);

       chkbox5 = new JCheckBox("Cheque Book");
       chkbox5.setFont(new Font("Halvetica", Font.BOLD, 14));
       chkbox5.setBounds(100, 600, 300, 30);
       add(chkbox5);

       chkbox6 = new JCheckBox("E-Statement");
       chkbox6.setFont(new Font("Halvetica", Font.BOLD, 14));
       chkbox6.setBounds(400, 600, 300, 30);
       add(chkbox6);

       chkbox7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge!");
       chkbox7.setFont(new Font("Halvetica", Font.BOLD, 14));
       chkbox7.setBounds(100, 670, 800, 30);
       add(chkbox7);

       submitBtn = new JButton("Submit");
       submitBtn.setFont(new Font("Halvetica", Font.BOLD, 16));
       submitBtn.setBounds(250, 720, 120, 30);
       submitBtn.setBackground(Color.BLACK);
       submitBtn.setForeground(Color.WHITE);
       submitBtn.setOpaque(true);
       submitBtn.setBorderPainted(false);
       submitBtn.addActionListener(this);
       add(submitBtn);

       cancelBtn = new JButton("Cancel");
       cancelBtn.setFont(new Font("Halvetica", Font.BOLD, 16));
       cancelBtn.setBounds(400, 720, 120, 30);
       cancelBtn.setBackground(Color.BLACK);
       cancelBtn.setForeground(Color.WHITE);
       cancelBtn.setOpaque(true);
       cancelBtn.setBorderPainted(false);
       cancelBtn.addActionListener(this);
       add(cancelBtn);

       getContentPane().setBackground(Color.WHITE);
       setSize(900, 900);
       setLocation(350, 30);
       setLayout(null);
       setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == submitBtn)
        {
            String accountType = null;
            if(savingAccountBtn.isSelected())
            {
                accountType = "Saving Account";
            }
            else if(fixedDepositBtn.isSelected())
            {
                accountType = "Saving Account";
            }
            else if(currentAccountBtn.isSelected())
            {
                accountType = "Current Account";
            }
            else if(recurringDepositBtn.isSelected())
            {
                accountType = "Saving Account";
            }

            //generating random 16 digit card number
            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

            // also generating a random 4 digit pin
            String pinNumber ="" + Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility = "";
            if(chkbox1.isSelected())
            {
                facility = facility + "ATM CARDS";
            }
            else if(chkbox2.isSelected())
            {
                facility = facility + "Internet Banking";
            }
            else if(chkbox3.isSelected())
            {
                facility = facility + "Mobile Banking";
            }
            else if(chkbox4.isSelected())
            {
                facility = facility + "Emails & SMS Alert";
            }
            else if(chkbox5.isSelected())
            {
                facility = facility + "Cheque Book";
            }
            else if(chkbox6.isSelected())
            {
                facility = facility + "E-Statement";
            }
            try {

                // check for validation
                if(accountTypeBtnGroup.isSelected(null)){
                    JOptionPane.showMessageDialog(null, "Account Type must be specified!");
                } 
                else if(!chkbox1.isSelected() && !chkbox2.isSelected() && !chkbox3.isSelected() && !chkbox4.isSelected() && !chkbox5.isSelected() && !chkbox6.isSelected()){
                    JOptionPane.showMessageDialog(null,"Must specify atleast one service");
                }
                else if(!chkbox7.isSelected()) {
                    JOptionPane.showMessageDialog(null, "You must accept the declaration");
                }
                else { // if no error send the data to the database
                    Conn connection = new Conn();
                    String query1 = "insert into signupthree values('"+formNo+"', '"+accountType+"', '"+cardNumber+"', '"+pinNumber+"', '"+facility+"')";
                    connection.statement.execute(query1);
                    
                    String query2 = "insert into login values('"+formNo+"', '"+cardNumber+"', '"+pinNumber+"')";
                    connection.statement.execute(query2);

                    JOptionPane.showMessageDialog(null, "Card Number: " +cardNumber+ "\n Pin: " +pinNumber);
                    setVisible(false);
                    new Login().setVisible(true);


                }
            } catch (SQLException ae) {
                System.out.println(ae);
            }

        }
        else if (e.getSource() == cancelBtn)
        {

        }
        
    }

    public static void main(String[] args) {
        new SignupThree("").setVisible(true);

    }
}
