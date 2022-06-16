package gq.noxiuam.encryption.method.impl;

import gq.noxiuam.encryption.method.AbstractMethod;

/*
    Gets the hex dump of a string, nothing special.
*/
public class HexMethod extends AbstractMethod {

    @Override
    public String execute(String dataIn) {
        System.out.println("[HexMethod] Getting hexdump...");
        return this.getHexDump(dataIn, true);
    }
}
