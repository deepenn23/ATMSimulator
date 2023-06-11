package ATMSimulator;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class SignupTwo extends JFrame implements ActionListener{

    JLabel additonalDetails, ethnicityTxt, incomeTxt, educationTxt, occupationTxt, panNumTxt, ssNTxt, scitizenTxt, eAccountTxt;
    JTextField ssN, panNum;
    JComboBox<String> ethnicity, income, education, occupation; 
    JRadioButton sYesButton, sNoButton, eYesButton, eNoButton;
    ButtonGroup sGroup, eGroup;
    JButton next;
    String formNo;

    public SignupTwo(String formNo) {
        this.formNo = formNo;


        additonalDetails = new JLabel("Page 2: Additional Details");
        additonalDetails.setBounds(290, 80, 400, 30);
        additonalDetails.setFont(new Font("Arial", Font.BOLD, 22));
        add(additonalDetails);


        ethnicityTxt = new JLabel("Ethnicity: ");
        ethnicityTxt.setBounds(100, 140, 400,30);
        ethnicityTxt.setFont(new Font("Arial", Font.BOLD,26));
        add(ethnicityTxt);

        String[] ethnicityChoices = {"White", "African American", "Asian", "Native American"};
        ethnicity = new JComboBox<>(ethnicityChoices);
        ethnicity.setBounds(300, 140, 300, 30);
        add(ethnicity);

        incomeTxt = new JLabel("Income: ");
        incomeTxt.setBounds(100, 190, 400,30);
        incomeTxt.setFont(new Font("Arial", Font.BOLD,26));
        add(incomeTxt);

        String[] incomeChoices= {" <$10,000", "$11,000 ~ $30,000", "$31,000 ~ $50,000", "$51,000 ~ $70,000", "$71,000 ~ $90,000", "  >$90,000"};
        income = new JComboBox<>(incomeChoices);
        income.setBounds(300, 190, 300, 30);
        add(income);

        educationTxt = new JLabel("Education: ");
        educationTxt.setBounds(100, 240, 400,30);
        educationTxt.setFont(new Font("Arial", Font.BOLD,26));
        add(educationTxt);

        String[] educationChoices= {"High School Diploma", "Associates Degree", "Bachelors Degree", "Masters", "PH.D"};
        education = new JComboBox<>(educationChoices);
        education.setBounds(300, 240, 300, 30);
        add(education);

        occupationTxt = new JLabel("Occupation: ");
        occupationTxt.setBounds(100, 290, 400,30);
        occupationTxt.setFont(new Font("Arial", Font.BOLD,26));
        add(occupationTxt);

        String[] occupationChoices= {"Sales Rep.", "Engineer", "Teacher", "Other"};
        occupation = new JComboBox<>(occupationChoices);
        occupation.setBounds(300, 290, 300, 30);
        add(occupation);
        
        panNumTxt = new JLabel("PAN Number: ");
        panNumTxt.setBounds(100, 340, 400,30);
        panNumTxt.setFont(new Font("Arial", Font.BOLD,26));
        add(panNumTxt);

        panNum = new JTextField();
        panNum.setBounds(300, 340, 350, 30);
        panNum.setFont(new Font("Arial", Font.PLAIN, 20));
        add(panNum);

        ssNTxt = new JLabel("SSN: ");
        ssNTxt.setBounds(100, 390, 400,30);
        ssNTxt.setFont(new Font("Arial", Font.BOLD,26));
        add(ssNTxt);

        ssN = new JTextField();
        ssN.setBounds(300, 390, 350, 30);
        ssN.setFont(new Font("Arial", Font.PLAIN, 20));
        add(ssN);

        scitizenTxt = new JLabel("Senior Citizen: ");
        scitizenTxt.setBounds(100, 440, 400,30);
        scitizenTxt.setFont(new Font("Arial", Font.BOLD,26));
        add(scitizenTxt);

        sYesButton = new JRadioButton("Yes");
        sYesButton.setBounds(300, 440, 100, 30);
        sYesButton.setBackground(Color.WHITE);
        add(sYesButton);

        sNoButton = new JRadioButton("No");
        sNoButton.setBounds(400, 440, 100, 30);
        sNoButton.setBackground(Color.WHITE);
        add(sNoButton);

        sGroup = new ButtonGroup();
        sGroup.add(sYesButton);
        sGroup.add(sNoButton);


        eAccountTxt = new JLabel("Existing Account: ");
        eAccountTxt.setBounds(100, 490, 400,30);
        eAccountTxt.setFont(new Font("Arial", Font.BOLD,23));
        add(eAccountTxt);

        eYesButton = new JRadioButton("Yes");
        eYesButton.setBounds(300, 490, 100, 30);
        eYesButton.setBackground(Color.WHITE);
        add(eYesButton);

        eNoButton = new JRadioButton("No");
        eNoButton.setBounds(400, 490, 100, 30);
        eNoButton.setBackground(Color.WHITE);
        add(eNoButton);

        eGroup = new ButtonGroup();
        eGroup.add(eYesButton);
        eGroup.add(eNoButton);

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
    public void actionPerformed(ActionEvent e) {
        String get_ethnicity = (String)ethnicity.getSelectedItem();
        String get_income = (String)income.getSelectedItem();
        String get_education = (String)education.getSelectedItem();
        String get_occupation = (String)occupation.getSelectedItem();
        String get_ssN = ssN.getText();
        String get_panNum = panNum.getText();
        String check_sCitizen = null;
        if(sYesButton.isSelected())
        {
            check_sCitizen = "Yes";
        }
        else if(sNoButton.isSelected()) 
        {
            check_sCitizen = "No";
        }
        String check_eAccount = null;
        if(sYesButton.isSelected())
        {
            check_eAccount = "Yes";
        }
        else if(sNoButton.isSelected()) 
        {
            check_eAccount = "No";
        }

        // add to database
        try {
            if(panNum.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Name is required!");
            } 

            // cretaing an object to send data to the database
            else
            {
                
                Conn connection = new Conn();

                //Step 4: Execute queries and updates
                String query = "insert into signuptwo values('"+formNo+"', '"+get_ethnicity+"', '"+get_income+"', '"+get_education+"', '"+get_occupation+"', '"+get_panNum+"', '"+get_ssN+"', '"+check_sCitizen+"', '"+check_eAccount+"')";
                connection.statement.execute(query);

                setVisible(false);
                new SignupThree(formNo).setVisible(true);
            }

        } catch (SQLException ae) {

            // Handling the exception
            System.out.println(ae);
        }
    }
}

