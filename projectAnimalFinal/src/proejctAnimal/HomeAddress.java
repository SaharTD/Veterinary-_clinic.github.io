package proejctAnimal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeAddress extends JFrame {

    private JLabel pageTitle = new JLabel("Home Address");
    private JLabel name =new JLabel("Neighborhood name");
    private JLabel streetName = new JLabel("Street name");


    private JTextField nameText = new JTextField(15);
    private JTextField streetText = new JTextField(15);



    private JButton submitButton = new JButton("Submit");





    private JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,230,40));
    private JPanel loginPanel = new JPanel(new GridLayout(3,2,0,50));
    private JPanel timePanel = new JPanel();

    private JLabel timeLabel = new JLabel("Time");
    private JRadioButton radioButton1 = new JRadioButton("12:00 to 2:00");
    private JRadioButton radioButton2 = new JRadioButton("5:00 to 7:00");



    public HomeAddress(){
        CreateFrame();
        createPanel();
        createTimePanel();
        setVisible(true);


        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (nameText.getText().isEmpty() || streetText.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please enter your information ");

                }else {

                    JOptionPane.showMessageDialog(null,"We will be there soon");

                }

            }
        });

    }


    public void CreateFrame(){

        setTitle("Animal Clinic");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(mainPanel);




    }

    public void createPanel(){

        loginPanel.setBackground(Color.decode("#d4d9df"));
        mainPanel.setBackground(Color.decode("#d4d9df"));
        submitButton.setBackground(Color.decode("#433b64"));
        submitButton.setForeground(Color.white);

        loginPanel.add(name);
        loginPanel.add(nameText);
        loginPanel.add(streetName);
        loginPanel.add(streetText);
        loginPanel.add(timeLabel);
        loginPanel.add(timePanel);


        pageTitle.setFont(new Font("Serif",Font.PLAIN,29));

        mainPanel.add(pageTitle);
        mainPanel.add(loginPanel);
        mainPanel.add(submitButton);


    }

    public void createTimePanel(){


        timePanel.add(radioButton1);
        timePanel.add(radioButton2);

    }




}
