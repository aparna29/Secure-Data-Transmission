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
import java.io.*;
import java.net.*;  
import java.util.*;
import java.lang.*;
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;  
import java.nio.file.Files;
import java.security.InvalidKeyException;  
import java.security.NoSuchAlgorithmException;  
import javax.crypto.BadPaddingException;  
import javax.crypto.Cipher;  
import javax.crypto.IllegalBlockSizeException;  
import javax.crypto.KeyGenerator;  
import javax.crypto.NoSuchPaddingException;  
import javax.crypto.SecretKey;  
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//import apache.commons.io.FilenameUtils;

public class EncryptFile {  
  
    KeyGenerator keyGenerator = null;  
  //  SecretKey secretKey = null;  
    Cipher cipher = null;  
  
    public EncryptFile() {  
        try {  
           
            //keyGenerator = KeyGenerator.getInstance("AES");  
           // secretKey = keyGenerator.generateKey();  
  String stringKey = "sgyrd";
  byte[] encodedKey= stringKey.getBytes();
            // byte[] encodedKey     = Base64.decode(stringKey, Base64.DEFAULT);
    SecretKey secretKey = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");  
        } catch (NoSuchPaddingException ex) {  
            System.out.println(ex);  
        } catch (NoSuchAlgorithmException ex) {  
            System.out.println(ex);  
        }  
    }  
  
    public static void Encrypt(File file,String key) throws IOException{  
	
        String fileToEncrypt = file.getName();  
        String encryptedFile ="";
        String extension = "";
        int i = fileToEncrypt.lastIndexOf('.');
        if (i > 0) {
            extension = fileToEncrypt.substring(i+1);
            }
        if(extension.equals("txt"))
        encryptedFile = encryptedFile +"encryptedFile.txt";
        else
           encryptedFile = encryptedFile +"encryptedFile."+extension; 
        String directoryPath = file.getPath();  
        EncryptFile encryptFile = new EncryptFile();
        System.out.println("Starting Encryption..."); 
        JOptionPane.showMessageDialog(null,
                      "Starting Encryption...... ","Message",
                JOptionPane.INFORMATION_MESSAGE);
        encryptFile.encrypt(directoryPath,  
                "/home/aparna/OOP_Project/E-T-D/" + encryptedFile,key);  
        System.out.println("Encryption completed..."); 
        JOptionPane.showMessageDialog(null,
                      "Encyption completed! ","Message",
                JOptionPane.INFORMATION_MESSAGE);
       
                   // ae.setupscreen();
        
				
		try{	ServerSocket serverSocket = new ServerSocket(15120);
                    JOptionPane.showMessageDialog(null,
                      "Waiting for client to connect... ","Message",
                JOptionPane.INFORMATION_MESSAGE);
		     Socket socket = serverSocket.accept();
		      System.out.println("Accepted connection : " + socket);
                      JOptionPane.showMessageDialog(null,
                      "Connection accepted!","Message",
                JOptionPane.INFORMATION_MESSAGE);
                      String filetosend = "/home/aparna/OOP_Project/E-T-D/"+ encryptedFile;
		      //File transferFile = new File ("/home/aparna/OOP_Project/E-T-D/encryptedFile.png");
                      File transferFile= new File(filetosend);
		      byte [] bytearray  = new byte [(int)transferFile.length()];
		      FileInputStream fin = new FileInputStream(transferFile);
		      BufferedInputStream bin = new BufferedInputStream(fin);
		      bin.read(bytearray,0,bytearray.length);
		      OutputStream os = socket.getOutputStream();
		      System.out.println("Sending File...");
                      JOptionPane.showMessageDialog(null,
                      "Sending Files ","Message",
                JOptionPane.INFORMATION_MESSAGE);
		      os.write(bytearray,0,bytearray.length);
		      os.flush();
		      socket.close();
		      System.out.println("File transfer completed!");
                      JOptionPane.showMessageDialog(null,
                      "File sent! ","Message",
                JOptionPane.INFORMATION_MESSAGE);
}
catch (IOException e){System.out.println("IO Exception");}
    }  
  
    /*
     * Encrypts the file in srcPath and creates a file in destPath 
     */  
   private void encrypt(String srcPath, String destPath,String key) {  
	
       //System.out.println("inside encrypt");
	String seckey;
        
        seckey =key;
	//System.out.println("\nEnter key : ");
	//seckey = in.next();
	if(seckey.length() >16)
		seckey = seckey.substring(0,16);
	else if(seckey.length() <16)
	{
		while(seckey.length()<16)
			seckey = seckey + seckey;
		seckey = seckey.substring(0,16);
	}
	byte[] encodedKey= seckey.getBytes();
	//byte[] encodedKey     = Base64.decode(seckey, Base64.DEFAULT);
	SecretKey secretKey = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        File rawFile = new File(srcPath);  
        File encryptedFile = new File(destPath);  
        InputStream inStream = null;  
        OutputStream outStream = null;  
        try {  
            /** 
             * Initialize the cipher for encryption 
             */  
           cipher.init(Cipher.ENCRYPT_MODE, secretKey);  
            /** 
             * Initialize input and output streams 
             */  
          inStream = new FileInputStream(rawFile);  
            outStream = new FileOutputStream(encryptedFile);  
            byte[] buffer = new byte[1024];  
            int len;  
            while ((len = inStream.read(buffer)) > 0) {  
                outStream.write(cipher.update(buffer, 0, len));  
                outStream.flush();  
            }  
            outStream.write(cipher.doFinal());  
            inStream.close();  
            outStream.close();  
        } catch (IllegalBlockSizeException ex) {  
            System.out.println(ex);  
        } catch (BadPaddingException ex) {  
            System.out.println(ex);  
        } catch (InvalidKeyException ex) {  
            System.out.println(ex);  
        } catch (FileNotFoundException ex) {  
            System.out.println(ex);  
        } catch (IOException ex) {  
            System.out.println(ex);  
        }  
    }  

}  