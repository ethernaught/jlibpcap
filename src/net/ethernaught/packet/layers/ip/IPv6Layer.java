package net.ethernaught.packet.layers.ip;

import net.ethernaught.packet.layers.inter.Layer;

import java.nio.ByteBuffer;

public class IPv6Layer implements Layer {

    public IPv6Layer(){

    }

    public IPv6Layer(ByteBuffer buf){
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
