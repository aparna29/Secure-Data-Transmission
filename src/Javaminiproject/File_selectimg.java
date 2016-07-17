/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Javaminiproject;

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

/**
 *
 * @author aparna
 */
class File_selectimg extends JFrame{
    File setupscreen(){
            JLabel background=new JLabel(new ImageIcon("cyber.jpg"));
    add(background);
	JFrame frame = new JFrame("Upload Image");
	
	frame.setVisible(true);
	/*FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");*/
	JFileChooser fc = new JFileChooser();
	//fc.setFileFilter();
	 //Where frame is the parent component
        fc.setAcceptAllFileFilterUsed(false);
        javax.swing.filechooser.FileFilter pngFilter = new FileTypeFilter(".png", "Images");
javax.swing.filechooser.FileFilter jpgFilter = new FileTypeFilter(".jpg", "Images");
javax.swing.filechooser.FileFilter jpegFilter = new FileTypeFilter(".jpeg", "Images");
javax.swing.filechooser.FileFilter gifFilter = new FileTypeFilter(".gif", "Images");
 
fc.addChoosableFileFilter(pngFilter);
fc.addChoosableFileFilter(jpgFilter);
fc.addChoosableFileFilter(jpegFilter);
fc.addChoosableFileFilter(gifFilter);
int returnVal = fc.showOpenDialog(frame);
 File file = null;
	if (returnVal == JFileChooser.APPROVE_OPTION) {
    	file = fc.getSelectedFile();
        //System.out.println(file);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	/*JLabel l1 = new JLabel(file+" uploaded!");
         l1.setBounds(1000,450,200,50);
         l1.setOpaque(false);
         frame.add(l1);*/
        
         dispose();
         return file;
         
    //Now you have your file to do whatever you want to do
	} else {
    //User did not choose a valid file
    return null;
}
}
}
class FileTypeFilter extends javax.swing.filechooser.FileFilter {
    private String extension;
    private String description;
 
    public FileTypeFilter(String extension, String description) {
        this.extension = extension;
        this.description = description;
    }
 
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
        return file.getName().endsWith(extension);
    }
 
    public String getDescription() {
        return description + String.format(" (*%s)", extension);
    }
}