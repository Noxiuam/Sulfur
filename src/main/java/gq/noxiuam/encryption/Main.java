package gq.noxiuam.encryption;

import gq.noxiuam.encryption.method.impl.*;

public class Main {

    /**
        I do NOT recommend running multiple of these methods at a time, just call their execute method with the data String you want to encrypt.
        Example:  new WarpMethod().execute(data);

        @param args The string you want to encrypt.
    */
    public static void main(String[] args) {
        String data = "Hello world";

        System.out.println(new RSAMethod().execute(data));
    }
}
