/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Javaminiproject;

/**
 *
 * @author aparna
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Javaminiproject {

    public static void main(String[] args) {
        // TODO code application logic here

        screen s=new screen();
        s.setupscreen();
}

static class screen extends JFrame
{  
    
       
    JButton login=new JButton("Login");

    void setupscreen()
    {
      
      
   JFrame pane = new JFrame();
   
   pane.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   pane.setLayout(null);
   
        JLabel background=new JLabel(new ImageIcon("Secure.jpg"));
    add(background);
       
        login.setBounds(850,600,200,50);
            background.add(login);
         JLabel label = new JLabel("Being able to break security doesn’t make you a hacker anymore than being able to hotwire cars makes you an automotive engineer.",JLabel.CENTER);
        label.setBounds(10,100,1300,100);
         label.setOpaque(false);
         background.add(label);
        label.setFont(new Font("URW Chancery L",Font.BOLD, 25));
        label.setForeground(Color.WHITE);
        
        JLabel lab=new JLabel("Welcome to the server-side interface!");
        lab.setBounds(100,200,1500,200);
         lab.setOpaque(false);
         background.add(lab);
        lab.setFont(new Font("URW Chancery L",Font.BOLD, 25));
        lab.setForeground(Color.WHITE);

                    login.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent e)
                                {//if(bol)
                                    //dispose();
                                    Login_page lp=new Login_page();
                                 
                                }  
                            });
         
   this.setSize(1800, 1450);
   this.setVisible(true);
     //dispose();
    }
    
 
 }
}
