// Program written by Binto George for CS395 Students

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.Cipher;

public class AES {
  public static void main(String[] unused) throws Exception {

    String cryptSpec = "AES/CTR/NoPadding";
    // Generate a secret key
    KeyGenerator kg = KeyGenerator.getInstance("AES");

    kg.init(256);
    SecretKey key = kg.generateKey();

    // Sender's end
    String s1="HelloHelloHello!HelloHelloHello!HelloHelloHello!HelloHelloHello!";
    byte[] m =s1.getBytes();
    byte []iv = {48, 63, 46, 58, 67, 7, 8, 8, 10,
    48, 63, 46, 58, 67, 7, 8, 8, 10};
    IvParameterSpec ivspec = new IvParameterSpec(iv, 1, 16);
    Cipher cipher1 = Cipher.getInstance(cryptSpec);
    cipher1.init(Cipher.ENCRYPT_MODE, key, ivspec);
    byte[] c = cipher1.doFinal(m);
    String s3 = new String (c);
    System.out.println("Cihphertext:" +  s3);

    //Modification of Cipher Text
    //c[1]=0;

    //Receiver's end
    Cipher cipher2 = Cipher.getInstance(cryptSpec);
    cipher2.init(Cipher.DECRYPT_MODE, key, ivspec);
    m=cipher2.doFinal(c);

    //converting bytes to string -- so that it can be printed
    String s2 = new String(m);
    System.out.println(s2);
 }
}
