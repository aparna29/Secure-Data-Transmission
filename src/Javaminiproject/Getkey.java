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
import Javaminiproject.Javaminiproject.screen;
import static Javaminiproject.screen4.Seckey;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Getkey extends screen4{
    
    JPanel p1;
     Container c;
           //public String Seckey;
     //p1.setlayout(new GridLayout(4,2,10,10));
    private JLabel key;
    private JTextField n;
    private JButton enter,clear;
    
    
    
    Getkey(File file)
    {
        
        setTitle("Enter Key");
        c=getContentPane();
        c.setLayout(new BoxLayout(c,3));
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(6,2,10,10));
        setSize(400,400);
        setVisible(true);
        
        key=new JLabel("Enter Key");
        
        
        n=new JTextField(40);
        
        
        
        enter=new JButton("Enter");
        clear=new JButton("Reset");
       
        p1.add(key);p1.add(n);
        p1.add(enter);p1.add(clear);
       
        c.add(p1);
        
         clear.addActionListener(new ActionListener()
            {public void actionPerformed(ActionEvent ex)
            {
                n.setText("");
            }});
        enter.addActionListener(new ActionListener() 
        {
            //System.out.println(Seckey);
            //Code for saving log in details to file
            public void actionPerformed(ActionEvent ex)
            {
                try {
                    
            String skey;
            {
                skey = n.getText();
                
            }
                   dispose();
                    EncryptFile.Encrypt(file,skey);
                    
                } catch (IOException ex1) {
                    Logger.getLogger(Getkey.class.getName()).log(Level.SEVERE, null, ex1);
                }

            }
        
            
                
        });
    
   
}
     
    
}