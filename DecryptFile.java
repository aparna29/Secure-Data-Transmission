 import java.security.*;  
 import java.io.*;  
 import javax.crypto.*;  
 import javax.crypto.spec.*;  
 import java.net.*;  
 public class DecryptFile {  
      public static void main(String args[]) {  
           try {  
                File aesFile = new File("Encrypted.txt");  
                // if file doesnt exists, then create it  
                if (!aesFile.exists()) {  
                     aesFile.createNewFile();  
                }  
                //aesFile=retrieve(args);  
                File aesFileBis = new File("Decrypted.txt");  
                FileInputStream fis;  
                FileOutputStream fos;  
                CipherInputStream cis;  
                 //Creation of Secret key  
                String key = "MySEcRetKeY";  
                int length=key.length();  
                if(length>16 && length!=16){  
                     key=key.substring(0, 15);  
                }  
                if(length<16 && length!=16){  
                     for(int i=0;i<16-length;i++){  
                          key=key+"0";  
                     }  
                }  
                SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(),"AES");  
                 //Creation of Cipher objects  
                Cipher decrypt =Cipher.getInstance("AES/ECB/PKCS5Padding", "SunJCE");  
                decrypt.init(Cipher.DECRYPT_MODE, secretKey);  
                // Open the Encrypted file  
                fis = new FileInputStream(aesFile);  
                cis = new CipherInputStream(fis, decrypt);  
                // Write to the Decrypted file  
                fos = new FileOutputStream(aesFileBis);  
                byte[] b = new byte[8];  
                int i = cis.read(b);  
                while (i != -1) {  
                     fos.write(b, 0, i);  
                     i = cis.read(b);  
                }  
                fos.flush();  
                fos.close();  
                cis.close();  
                fis.close();  
           } catch(Exception e){  
                e.printStackTrace();  
           }  
      }  
     /* public static File retrieve(String args[]){  
           if (args.length!=1) {  
                System.out.println("Usage: UrlRetriever <URL>");  
                System.exit(-1);  
           } */ 
           //File file = new File("Encrypted.txt");  
          /* try {  
                URL url=new URL(args[0]);  
                BufferedInputStream buffer=new  
                BufferedInputStream(url.openStream());  
                DataInputStream in= new DataInputStream(buffer);  
                String line;  
                // if file doesnt exists, then create it  
                if (!file.exists()) {  
                     file.createNewFile();  
                }  
                FileWriter fw = new FileWriter(file);  
                BufferedWriter bw = new BufferedWriter(fw);  
                while ((line=in.readLine())!=null){  
                     bw.write(line);  
                }  
                bw.close();  
                in.close();  
           } catch(MalformedURLException mue) {  
                System.out.println(args[0]+"is an invalid URL:"+mue);  
           }catch(IOException ioe) {  
                     System.out.println("IOException: "+ioe);  */
          // }  
          // return file;  
     // }  
 }  
