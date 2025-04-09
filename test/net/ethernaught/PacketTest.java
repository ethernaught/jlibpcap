package net.ethernaught;

import net.ethernaught.packet.layers.ethernet_frame.inter.EthernetAddress;

public class PacketTest {

    public static void main(String[] args){
        EthernetAddress address = new EthernetAddress((byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff);
        System.out.println(address);
    }
}
