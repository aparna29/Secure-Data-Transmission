package Javaminiproject;
import Javaminiproject.Javaminiproject.screen;
import static Javaminiproject.screen4.Seckey;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.File;
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
public class screen3 extends JFrame{
    JButton UploadImage = new JButton("Upload an Image");
    JButton ImageSend = new JButton("Send Image");
    void setupscreen()
    {
        JFrame pane = new JFrame();
   
   setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   pane.setLayout(null);
   
        JLabel background=new JLabel(new ImageIcon("cyber.jpg"));
    add(background);
    UploadImage.setBounds(1000,400,200,50);
            background.add(UploadImage);
         ImageSend.setBounds(1000,600,200,50);
            background.add(ImageSend);
            ImageSend.setVisible(false);
            UploadImage.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent e)
                                {//if(bol)
                                 File_selectimg f=new File_selectimg();
                                 File file= f.setupscreen();
                                 if(file!=null)
                                 {
                                 JLabel l1 = new JLabel(file.getName()+" uploaded!");
                                 System.out.println(file);
                                   l1.setBounds(1000,450,500,50);
                                 l1.setOpaque(false);
                                     background.add(l1);
                                      l1.setFont(new Font("URW Chancery L",Font.BOLD, 25));
        l1.setForeground(Color.WHITE);
        ImageSend.setVisible(true);
               ImageSend.addActionListener(new ActionListener()
                            {
                                
                                public void actionPerformed(ActionEvent e)
                                {
                                 Getkey g=new Getkey(file);
                               Seckey=g.Seckey;
                               
                                 //s1.setupscreen();
                                }  
                            });
                                 }
                                 else
                                 {
                                     JLabel l1 = new JLabel("Please choose an image!");
                               //  System.out.println(file);
                                   l1.setBounds(900,350,500,50);
                                 l1.setOpaque(false);
                                     background.add(l1);
                                      l1.setFont(new Font("URW Chancery L",Font.BOLD, 25));
                                   l1.setForeground(Color.WHITE);
                                   
                                 }
                                }  
                            });
       /*ImageSend.addActionListener(new ActionListener()
                            {
                                public void actionPerformed(ActionEvent e)
                                {
                                 screen4 s1=new screen4();
                                 s1.setupscreen();
                                }  
                            });*/
         this.setSize(1800, 1450);
   this.setVisible(true);
        //dispose();
    }
}
