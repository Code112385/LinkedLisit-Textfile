/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Package1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import dataStructures.*;

/**
 *
 * @author senju
 */
public class Login extends JFrame implements ActionListener {

    String[] userType = {"Manager", "Employee"};

    //Combobox
    JComboBox cb = new JComboBox(userType);

    //Panel
    JPanel LoginPanel = new JPanel();
    JPanel yellowPanel = new JPanel();
    JPanel blackPanel = new JPanel();

    //Label
    JLabel adminLabel = new JLabel("Administrator");

    //Label
    JLabel UserNLabel = new JLabel("Username");
    JLabel passLabel = new JLabel("Password");

    //Textfield
    JTextField userNfield = new JTextField();
    JPasswordField passField = new JPasswordField();

    //button
    JButton logButton = new JButton("Log-in");

    UserManager um = new UserManager("users.txt");

    public Login() {

        add(logButton);
        add(userNfield);
        add(passField);
        add(UserNLabel);
        add(passLabel);
        add(adminLabel);
        add(cb);

        cb.setBounds(600, 400, 100, 20);

        //buttons
        logButton.setBounds(500, 365, 93, 23);
        logButton.setBackground(new Color(250, 131, 52));
        logButton.setForeground(new Color(23, 23, 23));
        logButton.setBorder(BorderFactory.createEtchedBorder());
        logButton.setFocusable(false);
        logButton.addActionListener(this);

        //textfield
        userNfield.setBounds(600, 250, 200, 20);
        passField.setBounds(600, 300, 200, 20);

        //label
        UserNLabel.setBounds(450, 250, 100, 15);
        passLabel.setBounds(450, 300, 100, 15);
        adminLabel.setBounds(582, 83, 230, 25);
        adminLabel.setFont(new Font("Consolas", Font.BOLD, 25));
        adminLabel.setForeground(new Color(0, 0, 0));

        //Panel
        LoginPanel.setLayout(null);
        LoginPanel.setBackground(new Color(0, 35, 148));
        LoginPanel.setSize(1080, 720);
        yellowPanel.setLayout(null);
        yellowPanel.setBackground(new Color(221, 179, 14));
        yellowPanel.setSize(774, 720);
        yellowPanel.setBounds(304, 0, 774, 720);
        blackPanel.setLayout(null);
        blackPanel.setBackground(new Color(221, 179, 14));
        blackPanel.setSize(400, 400);
        blackPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        blackPanel.setBounds(391, 198, 600, 270);

        //Frame
        this.setSize(1080, 720);
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.add(blackPanel);
        this.add(yellowPanel);
        this.add(LoginPanel);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String pass = new String(passField.getPassword());
        String user = userNfield.getText();
        String userT = cb.getSelectedItem().toString();

        if (e.getSource() == logButton) {

            if (cb.getSelectedIndex() == 0) {
                if (um.usernameExists(user)) {
                    if (cb.getSelectedIndex() == 0) {
                        if (um.validateLogin(user, pass, userT)) {
                            if (cb.getSelectedIndex() == 0) {
                                this.setVisible(false);
                                new ManagerDashB();
                            }
                            JOptionPane.showMessageDialog(this, "Welcome " + userT, "message", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else if (cb.getSelectedIndex() != 0){
                             JOptionPane.showMessageDialog(this, "Employee is not allowed here ", "message", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            JOptionPane.showMessageDialog(this, "password is incorrect ", "message", JOptionPane.ERROR_MESSAGE);
                        }

                    }
//                    else {
//                        JOptionPane.showMessageDialog(this, "Employee is not allowed here ", "message", JOptionPane.ERROR_MESSAGE);
//                    }

                } else if (user.isEmpty() || pass.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter both Username and Password", "message", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "User not Found", "message", JOptionPane.ERROR_MESSAGE);

                }

            } else {
                if (um.usernameExists(user)) {
                    if (cb.getSelectedIndex() == 1) {
                        if (um.validateLogin(user, pass, userT)) {
                            if (cb.getSelectedIndex() == 1) {
                                this.setVisible(false);
                                new EmploDashB();
                            }
                            JOptionPane.showMessageDialog(this, "Welcome " + userT, "message", JOptionPane.INFORMATION_MESSAGE);
                            
                        } else {
                            JOptionPane.showMessageDialog(this, "password is incorrect ", "message", JOptionPane.ERROR_MESSAGE);
                        }

                   } 
                    //else {
//                        JOptionPane.showMessageDialog(this, "Manager is not allowed here ", "message", JOptionPane.ERROR_MESSAGE);
//                    }

                } else if (user.isEmpty() || pass.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter both Username and Password", "message", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "User not Found", "message", JOptionPane.ERROR_MESSAGE);

                }

            }
        }
    }

}
