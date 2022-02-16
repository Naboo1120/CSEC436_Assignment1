
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;

public class AESCTR {
    public static void main(String[] unused) throws Exception {

        SecureRandom secureRandom = new SecureRandom();

        String cryptSpec = "AES/CTR/NoPadding";
        byte[] key = new byte[256 / 8];
        secureRandom.nextBytes(key);

        byte[] nonce = new byte[96/8];
        secureRandom.nextBytes(nonce);

        // Sender's end
        String s1="HelloHelloHello!HelloHelloHello!HelloHelloHello!HelloHelloHello!";
        byte[] m =s1.getBytes();
        byte []iv = new byte[128 /8];
        System.arraycopy(nonce, 0, iv, 0, nonce.length);

        Key keySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        Cipher cipher1 = Cipher.getInstance(cryptSpec);
        cipher1.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] c = cipher1.doFinal(m);
        String s3 = new String (c);
        System.out.println("Cihphertext:" +  s3);

        //Modification of Cipher Text
        //c[1]=0;

        //Receiver's end
        //byte[] iv = new byte[128/8];
        System.arraycopy(nonce, 0, iv, 0, nonce.length);
        Cipher cipher2 = Cipher.getInstance(cryptSpec);
        //Key keySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
        cipher2.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        m=cipher2.doFinal(c);

        //converting bytes to string -- so that it can be printed
        String s2 = new String(m);
        System.out.println(s2);


    }
}
