package gq.noxiuam.encryption.method.impl;

import gq.noxiuam.encryption.method.AbstractMethod;
import lombok.SneakyThrows;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.*;
import java.util.Base64;

/*
    Only use this if you know what you're doing.
*/
public class RSAMethod extends AbstractMethod {
    @Override @SneakyThrows
    public String execute(String dataIn) {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair pair = generator.generateKeyPair();

        PublicKey publicKey = pair.getPublic();

        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);

        byte[] secretMessageBytes = dataIn.getBytes(StandardCharsets.UTF_8);
        byte[] encryptedMessageBytes = encryptCipher.doFinal(secretMessageBytes);

        String encodedMessage = Base64.getEncoder().encodeToString(encryptedMessageBytes);

        return encodedMessage + "\n\n" + publicKey.toString();
    }
}
