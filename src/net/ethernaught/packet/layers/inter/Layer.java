package net.ethernaught.packet.layers.inter;

public interface Layer {

    byte[] getBytes();

    long length();

    long computeLength();
}
