package ATMSimulator;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser; // for calender in DOB
import java.awt.event.*;
import java.sql.SQLException;

public class SignupOne extends JFrame implements ActionListener{

    long randomNum;

    JLabel name, fatherName, DOB, gender, email, martialStatus, address, city, state, zipcode;
    JTextField nameTextField, fatherNameTextField, emailTextField, addressTextField, cityTextField, stateTextField, zipcodeTextField;
    JDateChooser dateChooser;
    JButton next;
    JRadioButton male, female, single, married, other;
    ButtonGroup genderGroup, martialGroup;


    
    public SignupOne() {

        Random random = new Random();
        randomNum = Math.abs((random.nextLong() % 9000L) + 1000L);

        JLabel formNo = new JLabel("APPLICATION FORM NO: " +randomNum);
        formNo.setBounds(140, 20, 600, 40);
        formNo.setFont(new Font("Arial", Font.BOLD, 38));
        add(formNo);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setBounds(290, 80, 400, 30);
        personalDetails.setFont(new Font("Arial", Font.BOLD, 22));
        add(personalDetails);

       name = new JLabel("Name:");
       name.setBounds(100, 140, 100, 30);
       name.setFont(new Font("Arial", Font.BOLD, 14));
       add(name);

       nameTextField = new JTextField();
       nameTextField.setFont(new Font("Arial", Font.BOLD, 14));
       nameTextField.setBounds(200, 140, 400, 30);
       add(nameTextField);


       fatherName = new JLabel("Father's Name:");
       fatherName.setBounds(100, 190, 200, 30);
       fatherName.setFont(new Font("Arial", Font.BOLD, 14));
       add(fatherName);

       fatherNameTextField = new JTextField();
       fatherNameTextField.setFont(new Font("Arial", Font.BOLD, 14));
       fatherNameTextField.setBounds(200, 190, 400, 30);
       add(fatherNameTextField);

       DOB = new JLabel("Date of Birth: ");
       DOB.setBounds(100, 240, 200, 30);
       DOB.setFont(new Font("Arial",Font.BOLD, 14));
       add(DOB);

       dateChooser = new JDateChooser();
       dateChooser.setBounds(200, 240, 200, 30);
       dateChooser.setForeground(Color.BLACK);
       add(dateChooser);


       gender = new JLabel("Gender:  ");
       gender.setBounds(100, 290, 200, 30);
       gender.setFont(new Font("Arial", Font.BOLD, 14));
       add(gender);

       male = new JRadioButton("Male");
       male.setBounds(200, 290, 100,30);
       male.setBackground(Color.WHITE);
       add(male);

       female = new JRadioButton("Female");
       female.setBounds(300, 290, 100,30);
       female.setBackground(Color.WHITE);
       add(female);

       genderGroup = new ButtonGroup();
       genderGroup.add(female);
       genderGroup.add(male);

       email = new JLabel("Email:  ");
       email.setBounds(100, 340, 200, 30);
       email.setFont(new Font("Arial", Font.BOLD, 14));
       add(email);

       emailTextField = new JTextField();
       emailTextField.setFont(new Font("Arial", Font.BOLD, 10));
       emailTextField.setBounds(200, 340, 400, 30);
       add(emailTextField);

       martialStatus = new JLabel("Martial Staus:  ");
       martialStatus.setBounds(100, 390, 200, 30);
       martialStatus.setFont(new Font("Arial", Font.BOLD, 14));
       add(martialStatus);

       single = new JRadioButton("Single");
       single.setBounds(200, 390, 100,30);
       single.setBackground(Color.WHITE);
       add(single);

       married = new JRadioButton("Married");
       married.setBounds(300, 390, 100,30);
       married.setBackground(Color.WHITE);
       add(married);

       other = new JRadioButton("Other");
       other.setBounds(400, 390, 100,30);
       other.setBackground(Color.WHITE);
       add(other);

       martialGroup = new ButtonGroup();
       martialGroup.add(single);
       martialGroup.add(married);
       martialGroup.add(other);


       address = new JLabel("Address:  ");
       address.setBounds(100, 440, 200, 30);
       address.setFont(new Font("Arial", Font.BOLD, 14));
       add(address);

       addressTextField = new JTextField();
       addressTextField.setFont(new Font("Arial", Font.BOLD, 14));
       addressTextField.setBounds(200, 440, 400, 30);
       add(addressTextField);

       city = new JLabel("City:  ");
       city.setBounds(100, 490, 200, 30);
       city.setFont(new Font("Arial", Font.BOLD, 14));
       add(city);

       cityTextField = new JTextField();
       cityTextField.setFont(new Font("Arial", Font.BOLD, 14));
       cityTextField.setBounds(200, 490, 400, 30);
       add(cityTextField);

       state = new JLabel("State:  ");
       state.setBounds(100, 540, 200, 30);
       state.setFont(new Font("Arial", Font.BOLD, 14));
       add(state);

       stateTextField = new JTextField();
       stateTextField.setFont(new Font("Arial", Font.BOLD, 14));
       stateTextField.setBounds(200, 540, 400, 30);
       add(stateTextField);

       zipcode = new JLabel("Zipcode:  ");
       zipcode.setBounds(100, 590, 200, 30);
       zipcode.setFont(new Font("Arial", Font.BOLD, 14));
       add(zipcode);

       zipcodeTextField = new JTextField();
       zipcodeTextField.setFont(new Font("Arial", Font.BOLD, 14));
       zipcodeTextField.setBounds(200, 590, 400, 30);
       add(zipcodeTextField);


       next = new JButton("Next");
       next.setFont(new Font("Arial", Font.BOLD, 14));
       next.setBounds(500, 650, 100, 30);
       next.setBackground(Color.BLACK);
       next.setForeground(Color.WHITE);
       next.setOpaque(true);
       next.setBorderPainted(false);
       next.addActionListener(this);
       add(next);

       getContentPane().setBackground(Color.WHITE);
       setSize(900, 900);
       setLocation(350, 30);
       setLayout(null);
       setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String formNo = " " +randomNum;
        String name = nameTextField.getText();
        String fatherName = fatherNameTextField.getText();
        String DOB = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()) 
        {
            gender = "Male";
        }
        else if(female.isSelected())
        {
            gender = "Female";
        }
        String email = emailTextField.getText();
        String martialStatus = null;
        if(single.isSelected()) 
        {
            martialStatus = "Single";
        }
        else if(married.isSelected())
        {
            martialStatus = "Married";
        }
        else if(other.isSelected())
        {
            martialStatus = "Other";
        }

        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String zipcode = zipcodeTextField.getText();

        try {
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Name is required!");
            } 
            else
            {
                Conn connection = new Conn();
                String query = "insert into signup values('"+formNo+"', '"+name+"', '"+fatherName+"', '"+DOB+"', '"+gender+"', '"+email+"', '"+martialStatus+"', '"+address+"', '"+city+"', '"+state+"', '"+zipcode+"')";
                connection.statement.execute(query);

                //
            setVisible(false);
            new SignupTwo(formNo).setVisible(true);

            }

        } catch (SQLException ae) {
            
            System.out.println(ae);
        }


    }
}
