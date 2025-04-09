package net.ethernaught.packet.layers.ethernet_frame.inter;

import java.util.Arrays;

public class EthernetAddress {

    private byte[] address;

    public EthernetAddress(byte[] address){
        this.address = address;
    }

    public EthernetAddress(byte a, byte b, byte c, byte d, byte e, byte f){
        this.address = new byte[]{ a, b, c, d, e, f };
    }

    public byte[] toBytes(){
        return this.address;
    }

    public boolean isBroadcast(){
        return Arrays.equals(address, new byte[]{ (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff });
    }

    public boolean equals(Object object){
        if(object instanceof EthernetAddress){
            return Arrays.equals(address, ((EthernetAddress) object).address);
        }

        return false;
    }

    public String toString(){
        return "";
    }
}
