package proejctAnimal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class SignUp extends JFrame {

    private JLabel pageTitle = new JLabel("Sign Up");
    private JLabel emaillabel =new JLabel("Email Address");
    private JLabel passwordLabel = new JLabel("Password");


    private JTextField emailText = new JTextField(15);
    private JTextField passText = new JTextField(15);



    private JButton logupButton = new JButton("Sign Up");
    private JButton logInButton = new JButton("Sign In now");

    private ImageIcon image = new ImageIcon("image.jpg");
    private JLabel img = new JLabel(image);



    private JMenuBar menu = new JMenuBar();

    private JMenu filemenu = new JMenu("File");
    private JMenu helpMenu = new JMenu("Help");

    private JMenuItem close = new JMenuItem("Close");
    private JMenuItem contact_us = new JMenuItem("Contact Us");


    private JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,230,40));
    private JPanel loginPanel = new JPanel(new GridLayout(2,2,0,50));

    public SignUp(){
        createMenuBar();
        CreateFrame();
        createPanel();
        setVisible(true);

        logupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (emailText.getText().length()>4 && passText.getText().length()>7){

                    try {
                        FileWriter f = new FileWriter("signs.txt",true);

                        f.write(emailText.getText()+"\n");
                        f.write(passText.getText()+"\n");

                        f.close();

                        setVisible(false);
                         new SignIn();

                         return;
                    } catch (Exception e) {
                        System.out.println("File can not open");
                    }


                }
                JOptionPane.showMessageDialog(null,"- password must be more than 7 character\n\n- email must be more than 4");

            }
        });


        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false);

                new SignIn();
            }
        });

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        contact_us.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                JOptionPane.showMessageDialog(null,"ANIMAL CLINIC\n\nContact us: +966585967485");
            }
        });


    }


    public void CreateFrame(){

        setTitle("Animal Clinic");
        setSize(650, 675);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setJMenuBar(menu);

        add(mainPanel);






    }

    public void createPanel(){

        loginPanel.setBackground(Color.decode("#d4d9df"));
        mainPanel.setBackground(Color.decode("#d4d9df"));
        logupButton.setBackground(Color.decode("#433b64"));
        logupButton.setForeground(Color.white);
        logInButton.setBackground(Color.decode("#fde3c9"));

        loginPanel.add(emaillabel);
        loginPanel.add(emailText);
        loginPanel.add(passwordLabel);
        loginPanel.add(passText);


        pageTitle.setFont(new Font("Serif",Font.PLAIN,29));

        mainPanel.add(img);
        mainPanel.add(pageTitle);
        mainPanel.add(loginPanel);
        mainPanel.add(logupButton);
        mainPanel.add(logInButton);


    }

    public void createMenuBar(){

        filemenu.add(close);
        helpMenu.add(contact_us);
        menu.add(filemenu);
        menu.add(helpMenu);

        setJMenuBar(menu);

    }


}
