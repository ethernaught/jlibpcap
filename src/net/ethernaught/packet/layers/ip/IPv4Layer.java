package net.ethernaught.packet.layers.ip;

import net.ethernaught.packet.layers.inter.Layer;

import java.nio.ByteBuffer;

public class IPv4Layer implements Layer {

    public IPv4Layer(){

    }

    public IPv4Layer(ByteBuffer buf){
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
