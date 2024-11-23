/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Package1;
    
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.io.*;
import javax.swing.JComboBox;
import dataStructures.*;


public class Signup extends JFrame implements ActionListener {
    
   UserManager um = new UserManager("users.txt");
   
    String[] userType ={"Manager","Employee"};
    
    JPanel signPanel = new JPanel();
    JLabel SignLabel = new JLabel("Sign-Up Form");
    JLabel UserSignLabel = new JLabel("Username");
    JLabel SignpassLabel = new JLabel("Password");
    JLabel ConfpassLabel = new JLabel("Confirm Password");
    
    //Fields-SignUp
    JTextField SignUserField = new JTextField();
    JPasswordField SignpassField = new JPasswordField();
    JPasswordField SignCpassField = new JPasswordField();
    
    //Buttons
    JButton signupBt = new JButton("Sign-Up");
    JButton backBt = new JButton("Back");
    
    //Combobox
    JComboBox cb = new JComboBox(userType);
    
        public Signup() {

        //Sign
        this.add(cb);
        this.add(SignLabel);
        this.add(UserSignLabel);
        this.add(SignpassLabel); 
        this.add(ConfpassLabel);
        this.add(SignUserField);
        this.add(SignpassField); 
        this.add(SignCpassField);
        this.add(signupBt);
        this.add(backBt);
        
        //cb
        cb.setBounds(220, 400, 70, 20);
        
        //Buttons
        signupBt.setBounds(190, 370, 100, 30);
        signupBt.setBackground(new Color(250, 131, 52));
        signupBt.setForeground(new Color(23, 23, 23));
        signupBt.setBorder(BorderFactory.createEtchedBorder());
        signupBt.setFocusable(false);
        signupBt.addActionListener(this);
        backBt.setBounds(310, 370, 100, 30);
        backBt.setBackground(new Color(250, 131, 52));
        backBt.setForeground(new Color(23, 23, 23));
        backBt.setBorder(BorderFactory.createEtchedBorder());
        backBt.setFocusable(false);
        backBt.addActionListener(this);
        
        //Fields
        SignUserField.setBounds(75, 150, 300, 25);
        SignpassField.setBounds(75, 226, 300, 25);
        SignCpassField.setBounds(75, 302, 300, 25);

        //Labels
        SignLabel.setBounds(155, 47, 150, 23);
        SignLabel.setFont(new Font("Consolas", Font.BOLD, 20));
        SignLabel.setForeground(new Color(23, 23, 23));
        UserSignLabel.setBounds(41, 124, 90, 15);
        SignpassLabel.setBounds(41, 203, 90, 15);
        ConfpassLabel.setBounds(41, 276, 115, 15);

        //Panels
        signPanel.setLayout(null);
        signPanel.setBackground(new Color(255, 165, 82));
        signPanel.setSize(450, 500);

        //Frame
        this.setSize(450, 500);
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.add(signPanel);
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String SignUser = SignUserField.getText();
        String SignPass = new String(SignpassField.getPassword());
        String SignCPass = new String(SignCpassField.getPassword());
        String userType = cb.getSelectedItem().toString();
        
        if (e.getSource() == signupBt){
            
            
            
            
            if(SignUser.isEmpty() || SignPass.isEmpty() || SignCPass.isEmpty()){
                JOptionPane.showMessageDialog(this, "Please enter both Username and Password", "message", JOptionPane.INFORMATION_MESSAGE);
            return;
            }
           if(SignPass.equals(SignCPass)){
//                try (BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt", true))) {
//                    bw.write(SignUser + "," + SignPass + "," + userType + "\n");
//                    
//            } catch (IOException d) {
//                d.printStackTrace();
            um.addUser(SignUser, SignCPass, userType);
           
           

                
                JOptionPane.showMessageDialog(this, "SignUp Successfully", "message", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);
                new Login();
//                
          }
            else{
                  JOptionPane.showMessageDialog(this, "The Password do not match", "message", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource()== backBt){
           
        }
    }
}

