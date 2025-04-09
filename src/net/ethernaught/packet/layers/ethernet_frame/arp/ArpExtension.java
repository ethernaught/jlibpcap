package net.ethernaught.packet.layers.ethernet_frame.arp;

import net.ethernaught.packet.layers.inter.Layer;

import java.nio.ByteBuffer;

public class ArpExtension implements Layer {

    public ArpExtension(){

    }

    public ArpExtension(ByteBuffer buf){
    }

    @Override
    public byte[] getBytes(){
        return new byte[0];
    }

    @Override
    public int length(){
        return 0;
    }

    @Override
    public int computeLength(){
        return 0;
    }
}
