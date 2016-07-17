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
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login_page extends screen{
    
    JPanel p1;
     Container c;
     
     //p1.setlayout(new GridLayout(4,2,10,10));
    private JLabel name,password;
    private JTextField n;
    private JPasswordField p;
    private JButton login,clear;
    
    
    
    Login_page()
    {
        
        setTitle("Login");
        c=getContentPane();
        c.setLayout(new BoxLayout(c,3));
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(6,2,10,10));
        setSize(400,400);
        setVisible(true);
        
        name=new JLabel("Name");
        
        
        n=new JTextField(40);
        
        
        password=new JLabel("Password");
        
        
        p=new JPasswordField(8);
        p.setEchoChar('*');
        
        
        
        
        login=new JButton("Login as server");
        clear=new JButton("Clear all");
        JLabel l1=new JLabel("");
        JLabel l2=new JLabel("");
        
        p1.add(l1);
        p1.add(l2);
        p1.add(name);p1.add(n);
        p1.add(password);p1.add(p);
        
        p1.add(login);p1.add(clear);
       
        c.add(p1);
        
         clear.addActionListener(new ActionListener()
            {public void actionPerformed(ActionEvent ex)
            {n.setText("");
            p.setText("");
            //e.setText("");
            }});
        login.addActionListener(new ActionListener() 
        {
            //Code for saving log in details to file
            public void actionPerformed(ActionEvent ex)
            {
            int flag1=0;
            
             try 
              {
              
                if(n.getText().equals("server") && (new String(p.getPassword())).equals("server"))
                 {  
                     flag1=1;
                 }
              
              }
              catch(NullPointerException np){System.out.println(np.getMessage());
              np.printStackTrace();}
             
             if(flag1==1)
              { JOptionPane.showMessageDialog(null,
                      "You have succesfully logged in as the server!","Message", 
                JOptionPane.INFORMATION_MESSAGE);
              screen2 s2=new screen2();
                                dispose();
                                 s2.setupscreen();
               
              }
             else
             {
                 JOptionPane.showMessageDialog(null, n.getText()+
                         ", Invalid name/password ","Message", 
                 JOptionPane.INFORMATION_MESSAGE);
             }
            }
        
            
                
        });
    
   
}
     
    
}


