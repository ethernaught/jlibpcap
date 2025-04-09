package net.ethernaught.packet.layers.ip;

import net.ethernaught.packet.layers.inter.Layer;
import net.ethernaught.packet.layers.ip.inter.IPProtocols;
import net.ethernaught.packet.layers.ip.inter.IPVersions;

import java.lang.reflect.MalformedParametersException;
import java.net.Inet4Address;
import java.nio.ByteBuffer;

public class IPv4Layer implements Layer {

    public static final int IPV4_HEADER_LEN = 20;

    private IPVersions version;
    private byte ihl, tos, flags, ttl;
    private int totalLength, identification, fragmentOffset, checksum;
    private IPProtocols protocol;
    private Inet4Address sourceAddress, destinationAddress;
    private Layer data;

    public IPv4Layer(Inet4Address sourceAddress, Inet4Address destinationAddress, IPProtocols protocol){
        this.sourceAddress = sourceAddress;
        this.destinationAddress = destinationAddress;
        this.protocol = protocol;
    }

    public IPv4Layer(ByteBuffer buf){
        if(buf.remaining() < IPV4_HEADER_LEN){
            throw new MalformedParametersException("Buffer is not long enough to be ethernet frame.");
        }

        protocol = IPProtocols.fromCode(buf.get(9));

        buf.position(IPV4_HEADER_LEN);

        switch(protocol){
            case HOPBYHOP:
                break;

            case ICMP:
                break;

            case IGMP:
                break;

            case TCP:
                break;

            case UDP:
                break;

            case IPV6:
                break;

            case GRE:
                break;

            case ICMPV6:
                break;

            case OSPF:
                break;

            case SPS:
                break;
        }
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
