package net.ethernaught.packet.layers.inter;

public interface Layer {

    byte[] getBytes();

    int length();

    int computeLength();
}
