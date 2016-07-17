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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import javafx.stage.FileChooser.ExtensionFilter;
import java.io.*;
import java.lang.String;
import javafx.stage.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class File_select extends JFrame{

    
	File setupscreen(){
            JLabel background=new JLabel(new ImageIcon("cyber.jpg"));
    add(background);
	JFrame frame = new JFrame("Upload File");
	
	frame.setVisible(true);
	/*FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");*/
	JFileChooser fc = new JFileChooser();
	//fc.setFileFilter();
	
        fc.setAcceptAllFileFilterUsed(false);
 
 javax.swing.filechooser.FileFilter txtFilter = new FileTypeFilter(".txt", "Text Files");
 fc.addChoosableFileFilter(txtFilter);
 int returnVal = fc.showOpenDialog(frame);

	
    File file = null;
	if (returnVal == JFileChooser.APPROVE_OPTION) {
    	file = fc.getSelectedFile();
        //System.out.println(file);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

         dispose();
         return file;
         
    //Now you have your file to do whatever you want to do
	} else {
    //User did not choose a valid file
    return null;
}
}
}
