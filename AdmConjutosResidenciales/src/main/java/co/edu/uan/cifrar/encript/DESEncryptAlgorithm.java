package co.edu.uan.cifrar.encript;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import sun.misc.BASE64Encoder;

public class DESEncryptAlgorithm implements IEncryptAlgorithm {
	@Override
    public String encrypt(String message, String password) throws Exception {
        DESKeySpec dks = new DESKeySpec(message.getBytes());
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
        SecretKey desKey = skf.generateSecret(dks);
        Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        desCipher.init(Cipher.ENCRYPT_MODE, desKey);

        BASE64Encoder base64encoder = new BASE64Encoder();
        return base64encoder.encode(desCipher.doFinal(message.getBytes()));
    }
}
