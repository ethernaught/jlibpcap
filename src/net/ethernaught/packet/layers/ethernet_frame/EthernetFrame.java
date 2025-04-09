package net.ethernaught.packet.layers.ethernet_frame;

import net.ethernaught.packet.layers.ethernet_frame.inter.EthernetAddress;
import net.ethernaught.packet.layers.ethernet_frame.inter.EthernetTypes;
import net.ethernaught.packet.layers.inter.Layer;

import java.lang.reflect.MalformedParametersException;

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

    public EthernetFrame(byte[] buf){
        if(buf.length < ETHERNET_FRAME_LEN){
            throw new MalformedParametersException("Buffer is not long enough to be ethernet frame.");
        }

        destinationMac = new EthernetAddress(buf[0], buf[1], buf[2], buf[3], buf[4], buf[5]);
        sourceMac = new EthernetAddress(buf[6], buf[7], buf[8], buf[9], buf[10], buf[11]);
        type = EthernetTypes.fromCode(((buf[12] & 0xFF) << 8) | (buf[13] & 0xFF));
        length = buf.length;

        switch(type){
            case IPV4:
                //data = new Ipv4Layer(buf);
                break;

            case ARP:
                //data = new ArpExtension(buf);
                break;

            case IPV6:
                //data = new Ipv6Layer(buf);
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
    public long length(){
        return length;
    }

    @Override
    public long computeLength(){
        return 0;
    }
}
