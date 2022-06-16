package gq.noxiuam.encryption.method.impl;

import gq.noxiuam.encryption.method.AbstractMethod;
import gq.noxiuam.encryption.util.EncryptionTools;

/*
    This method is intended to be irreversible.
*/
public class WarpMethod extends AbstractMethod {

    @Override
    public String execute(String dataIn) {
        StringBuilder sb = new StringBuilder();

        System.out.println(this.getClass().getSimpleName() + ": Beginning phase 1");
        for (char c : dataIn.toCharArray()) {
            sb.append(EncryptionTools.getRSA(String.valueOf(c)));
        }

        System.out.println(this.getClass().getSimpleName() + ": Beginning phase 2");
        StringBuilder phase2Data = new StringBuilder(EncryptionTools.getShiftedString(sb.toString()));

        System.out.println(this.getClass().getSimpleName() + ": Beginning phase 3");
        String result = this.getHexDump(phase2Data.reverse().toString(), true);

        return result;
    }
}
