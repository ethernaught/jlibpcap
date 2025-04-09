package net.ethernaught.packet.layers.ip;

import net.ethernaught.packet.layers.inter.Layer;
import net.ethernaught.packet.layers.ip.inter.IPProtocols;
import net.ethernaught.packet.layers.ip.inter.IPVersions;

import java.lang.reflect.MalformedParametersException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

public class IPv4Layer implements Layer {

    public static final int IPV4_HEADER_LEN = 20;

    private IPVersions version;
    private byte ihl = 4, tos = 5, flags, ttl = 64;
    private int totalLength = IPV4_HEADER_LEN, identification, fragmentOffset, checksum;
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

        version = IPVersions.fromCode((byte) (buf.get(0) >> 4));
        ihl = (byte) (buf.get(0) & 0x0F);
        tos = buf.get(1);
        totalLength = ((buf.get(2) & 0xFF) << 8) | (buf.get(3) & 0xFF);
        identification = ((buf.get(4) & 0xFF) << 8) | (buf.get(5) & 0xFF);
        flags = (byte) (buf.get(6) >> 5);
        fragmentOffset = ((buf.get(6) & 0x1F) << 8) | (buf.get(7) & 0xFF);
        ttl = buf.get(8);
        checksum = ((buf.get(10) & 0xFF) << 8) | (buf.get(11) & 0xFF);

        try{
            sourceAddress = (Inet4Address) Inet4Address.getByAddress(new byte[]{ buf.get(12), buf.get(13), buf.get(14), buf.get(15) });
            destinationAddress = (Inet4Address) Inet4Address.getByAddress(new byte[]{ buf.get(16), buf.get(17), buf.get(18), buf.get(19) });

        }catch(UnknownHostException e){
            throw new IllegalArgumentException("Address isn't a valid host.");
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

    public void setVersion(IPVersions version){
        this.version = version;
    }

    public IPVersions getVersion(){
        return version;
    }

    public void setIhl(byte ihl){
        this.ihl = ihl;
    }

    public byte getIhl(){
        return ihl;
    }

    public void setTos(byte tos){
        this.tos = tos;
    }

    public byte getTos(){
        return tos;
    }

    public int getTotalLength(){
        return totalLength;
    }

    public void setIdentification(int identification){
        this.identification = identification;
    }

    public int getIdentification(){
        return identification;
    }

    public void setFlags(byte flags){
        this.flags = flags;
    }

    public byte getFlags(){
        return flags;
    }

    public void setFragmentOffset(int fragmentOffset){
        this.fragmentOffset = fragmentOffset;
    }

    public int getFragmentOffset(){
        return fragmentOffset;
    }

    public void setTtl(byte ttl){
        this.ttl = ttl;
    }

    public byte getTtl(){
        return ttl;
    }

    public void setProtocol(IPProtocols protocol){
        this.protocol = protocol;
    }

    public IPProtocols getProtocol(){
        return protocol;
    }

    //CALC AND COMPUTE CHECKSUM AND VALIDATE


    public int getChecksum(){
        return checksum;
    }

    public void setSourceAddress(Inet4Address sourceAddress){
        this.sourceAddress = sourceAddress;
    }

    public Inet4Address getSourceAddress(){
        return sourceAddress;
    }

    public void setDestinationAddress(Inet4Address destinationAddress){
        this.destinationAddress = destinationAddress;
    }

    public Inet4Address getDestinationAddress(){
        return destinationAddress;
    }

    public void setData(Layer data){
        this.data = data;
    }

    public Layer getData(){
        return data;
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
