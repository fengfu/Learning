package io.fengfu.learning.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.ws.security.util.Base64;

/**
 * Created by fengfu.qu on 2015/7/1.
 */
public class DigestTest {
    public static void main(String[] args){
        String pwd = "AMADEUS";
        String nonce = "IXFcMmgoWTs=";
        String ts = "2015-06-30T09:24:10.302Z";

        ts.hashCode();

        String algo = "Digest Password = Base64 (sha1(Nonce +  Timestamp + sha1(Pwd) ))";

        try {
            byte[] sha1 = MessageDigest.getInstance("SHA-1").digest(pwd.getBytes());

            byte[] bytes = new byte[nonce.getBytes().length+ts.getBytes().length+sha1.length];

            int idx = 0;
            for (byte b : nonce.getBytes()){
                bytes[idx] = b;
                idx ++;
            }

            for (byte b : ts.getBytes()){
                bytes[idx] = b;
                idx ++;
            }

            for (byte b : sha1){
                bytes[idx] = b;
                idx ++;
            }

            System.out.println(Base64.encode(bytes));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
