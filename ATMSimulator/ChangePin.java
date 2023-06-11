
package ATMSimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;





public class ChangePin extends JFrame implements ActionListener{

    JLabel changePinTxt, newPinTxt, rePinTxt;
    JPasswordField newPin, rePin;
    JButton changeBtn, backBtn;
    String pinNumber;
    public ChangePin(String pinNumber) 
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

        changePinTxt = new JLabel("CHANGE YOUR PIN");
        changePinTxt.setBounds(220, 280, 300, 30);
        changePinTxt.setFont(new Font("System", Font.BOLD, 22));
        changePinTxt.setForeground(Color.WHITE);
        img.add(changePinTxt);

        newPinTxt = new JLabel("NEW PIN: ");
        newPinTxt.setBounds(160, 340, 350, 30);
        newPinTxt.setFont(new Font("System", Font.PLAIN, 18));
        newPinTxt.setForeground(Color.WHITE);
        img.add(newPinTxt);

        newPin = new JPasswordField("NEW PIN: ");
        newPin.setBounds(330, 340, 150, 30);
        newPin.setFont(new Font("System", Font.PLAIN, 18));
        newPin.setForeground(Color.BLACK);
        newPin.setText("");
        img.add(newPin);

        

        rePinTxt = new JLabel("RE-ENTER PIN: ");
        rePinTxt.setBounds(160, 380, 350, 30);
        rePinTxt.setFont(new Font("System", Font.PLAIN, 18));
        rePinTxt.setForeground(Color.WHITE);
        img.add(rePinTxt);

        rePin = new JPasswordField("NEW PIN: ");
        rePin.setBounds(330, 380, 150, 30);
        rePin.setFont(new Font("System", Font.PLAIN, 18));
        rePin.setText("");
        rePin.setForeground(Color.BLACK);
        img.add(rePin);

        changeBtn = new JButton("Change");
        changeBtn.setBounds(350, 430, 160,40);
        changeBtn.setFont(new Font("System", Font.BOLD, 16));
        changeBtn.setForeground(Color.BLACK);
        changeBtn.addActionListener(this);
        img.add(changeBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(350, 480, 160,40);
        backBtn.setFont(new Font("System", Font.BOLD, 16));
        backBtn.setForeground(Color.BLACK);
        backBtn.addActionListener(this);
        img.add(backBtn);

        setSize(900,900);
        setLocation(350,0);
        setUndecorated(false);
        setLayout(null);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent ae) {
       try {
            if(ae.getSource() == changeBtn){
                String pin = newPin.getText();
                String rPin = rePin.getText();


                // check if both of the pin matches... 
                if(!pin.equals(rPin)){
                    JOptionPane.showMessageDialog(null, "PIN DOES NOT MATCH!!!");
                }
                if(pin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the PIN");
                    return; 
                }
                if(rPin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Re-enter the PIN");
                    return;
                }

                //Updating the new pin in the database
                Conn connection = new Conn();
                String query1 = "update bank set Pin = '"+rPin+"' where Pin= '"+pinNumber+"'";
                String query2 = "update login set Pin = '"+rPin+"' where Pin= '"+pinNumber+"'";
                String query3 = "update signupthree set Pin = '"+rPin+"' where Pin= '"+pinNumber+"'";

                connection.statement.executeUpdate(query1);
                connection.statement.executeUpdate(query2);
                connection.statement.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "Pin Changed Successfully");


            } 
            else{

                setVisible(false);
                new Transaction(pinNumber).setVisible(true);
            }
        
       } catch (SQLException e) {
            System.out.println(e);
        }
    }
}




