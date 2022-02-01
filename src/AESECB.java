// Program written by Binto George for CSEC436 Students

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.Cipher;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.Cipher;

public class AESECB {
  public static void main(String[] unused) throws Exception {

    String cryptSpec = "AES/ECB/PKCS5Padding";
    // Generate a secret key
    KeyGenerator kg = KeyGenerator.getInstance("AES");

    kg.init(128); 
    SecretKey key = kg.generateKey();

    // Sender's end
    String s1="AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
    byte[] m =s1.getBytes();
    Cipher cipher1 = Cipher.getInstance(cryptSpec);
    cipher1.init(Cipher.ENCRYPT_MODE, key);
    byte[] c = cipher1.doFinal(m);
    String s3 = new String (c);
    System.out.println("Cihphertext:" +  s3);

    //Modification of Cipher Text
    //c[2]=0;

    //Receiver's end
    Cipher cipher2 = Cipher.getInstance(cryptSpec);
    cipher2.init(Cipher.DECRYPT_MODE, key);
    m=cipher2.doFinal(c);

    //converting bytes to string -- so that it can be printed
    String s2 = new String(m);
    System.out.println(s2);
 }
}