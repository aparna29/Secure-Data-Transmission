/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Javaminiproject;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 *
 * @author aparna
 */
public class screen2 extends JFrame{
    JButton Imagetransfer = new JButton("Image Transfer");
    JButton Filetransfer = new JButton("File Transfer");
    void setupscreen()
    {
        JFrame pane = new JFrame();
   
   pane.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   pane.setLayout(null);
   
        JLabel background=new JLabel(new ImageIcon("cyber.jpg"));
    add(background);
       
        Imagetransfer.setBounds(1000,400,200,50);
            background.add(Imagetransfer);
         Filetransfer.setBounds(1000,600,200,50);
            background.add(Filetransfer);
         Imagetransfer.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent e)
                                {//if(bol)
                                 dispose();
                                 screen3 s=new screen3();
                                 s.setupscreen();
                                }  
                            });
         Filetransfer.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent e)
                                {
                                    dispose();
                                 screen4 s1=new screen4();
                                 s1.setupscreen();
                                }  
                            });
         this.setSize(1800, 1450);
   this.setVisible(true);
   //dispose();
        
    }
}
