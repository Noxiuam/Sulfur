package gq.noxiuam.encryption.method;

/*
    An abstract "method" that can be utilized in making new methods of encrypting data.
*/
public abstract class AbstractMethod {

    /**
        Main execute function for the encryption method.

        @param dataIn The data you want to encrypt.
    */
    public abstract String execute(String dataIn);

    /**
        Returns the hex dump of ASCII data.

        @param data The string you want to get the hexdump of.
        @param pretty Makes the string look pretty or not.
    */
    public String getHexDump(String data, boolean pretty) {
        StringBuilder sb = new StringBuilder();

        for (char c : data.toCharArray()) {
            String hex = Integer.toHexString(c);
            sb.append(hex);
        }

        String result = sb.toString();

        if (pretty) {
            result = result.replaceAll("(.{55})", "$1\n");
        }

        return result;
    }

}
