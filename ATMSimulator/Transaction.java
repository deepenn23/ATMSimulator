package ATMSimulator;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{

    JButton depositBtn, cashWithdrawBtn, fastCashBtn, miniStatemntBtn, pinChangeBtn, balanceEnquiryBtn, exitBtn;
    String pinNumber;
    public Transaction(String pinNumber) 
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


        JLabel txt = new JLabel("Please select your Transaction");
        txt.setBounds(210, 280, 300, 30);
        txt.setFont(new Font("System", Font.PLAIN, 16));
        txt.setForeground(Color.WHITE);
        img.add(txt);

        depositBtn = new JButton("Deposit");
        depositBtn.setBounds(160, 350, 160,40);
        depositBtn.setFont(new Font("System", Font.BOLD, 16));
        depositBtn.setForeground(Color.BLACK);
        depositBtn.addActionListener(this);
        img.add(depositBtn);

        cashWithdrawBtn = new JButton("Cash Withdraw");
        cashWithdrawBtn.setBounds(350, 350, 160,40);
        cashWithdrawBtn.setFont(new Font("System", Font.BOLD, 16));
        cashWithdrawBtn.setForeground(Color.BLACK);
        cashWithdrawBtn.addActionListener(this);
        img.add(cashWithdrawBtn);

        fastCashBtn = new JButton("Fast Cash");
        fastCashBtn.setBounds(160, 400, 160,40);
        fastCashBtn.setFont(new Font("System", Font.BOLD, 16));
        fastCashBtn.setForeground(Color.BLACK);
        fastCashBtn.addActionListener(this);
        img.add(fastCashBtn);

        miniStatemntBtn = new JButton("Mini Statement");
        miniStatemntBtn.setBounds(350, 400, 160,40);
        miniStatemntBtn.setFont(new Font("System", Font.BOLD, 16));
        miniStatemntBtn.setForeground(Color.BLACK);
        miniStatemntBtn.addActionListener(this);
        img.add(miniStatemntBtn);

        pinChangeBtn = new JButton("Pin Change");
        pinChangeBtn.setBounds(160, 450, 160,40);
        pinChangeBtn.setFont(new Font("System", Font.BOLD, 16));
        pinChangeBtn.setForeground(Color.BLACK);
        pinChangeBtn.addActionListener(this);
        img.add(pinChangeBtn);

        balanceEnquiryBtn = new JButton("Balance Enquiry");
        balanceEnquiryBtn.setBounds(350, 450, 160,40);
        balanceEnquiryBtn.setFont(new Font("System", Font.BOLD, 16));
        balanceEnquiryBtn.setForeground(Color.BLACK);
        balanceEnquiryBtn.addActionListener(this);
        img.add(balanceEnquiryBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setBounds(350, 500, 160,40);
        exitBtn.setFont(new Font("System", Font.BOLD, 16));
        exitBtn.setForeground(Color.BLACK);
        exitBtn.addActionListener(this);
        img.add(exitBtn);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == exitBtn) 
        {
            System.exit(0);
        }
        else if(ae.getSource() == depositBtn)
        {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == cashWithdrawBtn)
        {
            setVisible(false);
            new Withdraw(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == fastCashBtn)
        {
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == pinChangeBtn)
        {
            setVisible(false);
            new ChangePin(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == balanceEnquiryBtn)
        {
            setVisible(false);
            new ShowBalance(pinNumber).setVisible(true);
        }
        else if(ae.getSource() == miniStatemntBtn)
        {
            setVisible(false);
            new MiniStatement(pinNumber).setVisible(true);
        }

    }
}
