package net.ethernaught.packet.layers.ethernet_frame;

import net.ethernaught.packet.layers.ethernet_frame.arp.ArpExtension;
import net.ethernaught.packet.layers.ethernet_frame.inter.EthernetAddress;
import net.ethernaught.packet.layers.ethernet_frame.inter.EthernetTypes;
import net.ethernaught.packet.layers.inter.Layer;
import net.ethernaught.packet.layers.ip.IPv4Layer;
import net.ethernaught.packet.layers.ip.IPv6Layer;

import java.lang.reflect.MalformedParametersException;
import java.nio.ByteBuffer;

public class EthernetFrame implements Layer {

    public static final int ETHERNET_FRAME_LEN = 14;

    private EthernetAddress destinationMac, sourceMac;
    private EthernetTypes type;
    private Layer data;
    private int length;

    public EthernetFrame(EthernetAddress destinationMac, EthernetAddress sourceMac, EthernetTypes type){
        this.destinationMac = destinationMac;
        this.sourceMac = sourceMac;
        this.type = type;
        this.length = ETHERNET_FRAME_LEN;
    }

    public EthernetFrame(ByteBuffer buf){
        if(buf.remaining() < ETHERNET_FRAME_LEN){
            throw new MalformedParametersException("Buffer is not long enough to be ethernet frame.");
        }

        destinationMac = new EthernetAddress(buf.get(0), buf.get(1), buf.get(2), buf.get(3), buf.get(4), buf.get(5));
        sourceMac = new EthernetAddress(buf.get(6), buf.get(7), buf.get(8), buf.get(9), buf.get(10), buf.get(11));
        type = EthernetTypes.fromCode(((buf.get(12) & 0xFF) << 8) | (buf.get(13) & 0xFF));
        length = buf.remaining();
        buf.position(ETHERNET_FRAME_LEN);

        switch(type){
            case IPV4:
                data = new IPv4Layer(buf);
                break;

            case ARP:
                data = new ArpExtension(buf);
                break;

            case IPV6:
                data = new IPv6Layer(buf);
                break;

            case BROADCAST:
                break;
        }
    }

    public void setDestinationMac(EthernetAddress destinationMac){
        this.destinationMac = destinationMac;
    }

    public EthernetAddress getDestinationMac(){
        return destinationMac;
    }

    public void setSourceMac(EthernetAddress sourceMac){
        this.sourceMac = sourceMac;
    }

    public EthernetAddress getSourceMac(){
        return sourceMac;
    }

    public void setType(EthernetTypes type){
        this.type = type;
    }

    public EthernetTypes getType(){
        return type;
    }

    public void setData(Layer data){
        this.data = data;
    }

    public Layer getData(){
        return data;
    }

    @Override
    public byte[] getBytes(){
        byte[] buf = new byte[ETHERNET_FRAME_LEN];
        System.arraycopy(destinationMac.toBytes(), 0, buf, 0, 6);
        System.arraycopy(sourceMac.toBytes(), 0, buf, 6, 6);

        int type = this.type.getCode();
        buf[12] = (byte) ((type >> 8) & 0xFF);
        buf[13] = (byte) (type & 0xFF);

        return buf;
    }

    @Override
    public int length(){
        return length;
    }

    @Override
    public int computeLength(){
        return 0;
    }
}
