package proejctAnimal;

import javafx.application.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SignIn extends JFrame {

    private JLabel pageTitle = new JLabel("Sign In");
    private JLabel emaillabel = new JLabel("Email Address");
    private JLabel passwordLabel = new JLabel("Password");


    private JTextField emailText = new JTextField(15);
    private JTextField passText = new JTextField(15);


    private JButton logButton = new JButton("Sign In");
    private JButton logUpButton = new JButton("Sign Up now");

    private ImageIcon image = new ImageIcon("image.jpg");
    private JLabel img = new JLabel(image);


    private JMenuBar menu = new JMenuBar();

    private JMenu filemenu = new JMenu("File");
    private JMenu helpMenu = new JMenu("Help");

    private JMenuItem close = new JMenuItem("Close");
    private JMenuItem contact_us = new JMenuItem("Contact Us");


    private JPanel mainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 230, 40));
    private JPanel loginPanel = new JPanel(new GridLayout(2, 2, 0, 50));

    public SignIn() {
        createMenuBar();

        CreateFrame();
        createPanel();
        setVisible(true);

        logUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                setVisible(false);
                new SignUp();


            }
        });

        logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String email = emailText.getText();
                String pass = passText.getText();


                try {
                    File f = new File("signs.txt");
                    Scanner r = new Scanner(f);


                    while (r.hasNextLine()) {
                        if (email.equals(r.nextLine())) {

                            if (pass.equals(r.nextLine())) {

                                setVisible(false);
                                Application.launch(ReservationscreenController.class);
                                return;

                            }

                        }
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Your password or email is wrong");
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


    public void CreateFrame() {

        setTitle("Animal Clinic");
        setSize(650, 675);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setJMenuBar(menu);

        add(mainPanel);


    }

    public void createPanel() {

        loginPanel.setBackground(Color.decode("#d4d9df"));
        mainPanel.setBackground(Color.decode("#d4d9df"));
        logButton.setBackground(Color.decode("#433b64"));
        logButton.setForeground(Color.white);
        logUpButton.setBackground(Color.decode("#fde3c9"));

        loginPanel.add(emaillabel);
        loginPanel.add(emailText);
        loginPanel.add(passwordLabel);
        loginPanel.add(passText);


        pageTitle.setFont(new Font("Serif", Font.PLAIN, 29));

        mainPanel.add(img);
        mainPanel.add(pageTitle);
        mainPanel.add(loginPanel);
        mainPanel.add(logButton);
        mainPanel.add(logUpButton);


    }

    public void createMenuBar() {

        filemenu.add(close);
        helpMenu.add(contact_us);
        menu.add(filemenu);
        menu.add(helpMenu);

        setJMenuBar(menu);

    }


}
