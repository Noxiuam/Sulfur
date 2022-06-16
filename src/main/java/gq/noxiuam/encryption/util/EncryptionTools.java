package gq.noxiuam.encryption.util;

import lombok.SneakyThrows;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyPairGenerator;
import java.util.Random;

public class EncryptionTools {

    /**
        Encrypts a string with RSA.

        @param dataIn The data you want to encrypt.
    */
    @SneakyThrows
    public static String getRSA(String dataIn) {
        KeyPairGenerator keyPair = KeyPairGenerator.getInstance("RSA");
        keyPair.initialize(2048);

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.generateKeyPair().getPublic());
        cipher.update(dataIn.getBytes());

        return new String(cipher.doFinal(), StandardCharsets.UTF_8);
    }

    /**
        Randomly shifts a string around.

        @param dataIn The data you want to shift.
    */
    public static String getShiftedString(String dataIn) {
        StringBuilder sb = new StringBuilder();
        sb.append(dataIn);

        int index = new Random().nextInt(dataIn.length());
        for (int i = 0; i < dataIn.length(); i++) {
            String gettingSwapped = dataIn.substring(index, index + 1);
            String gettingSwapped2 = dataIn.substring(index, index + 1);
            sb.replace(index, index + 1, gettingSwapped2);
            sb.replace(index, index + 1, gettingSwapped);
        }

        return sb.toString();
    }
}
