package net.ethernaught.packet;

import net.ethernaught.packet.layers.ethernet_frame.EthernetFrame;
import net.ethernaught.packet.layers.inter.Layer;
import net.ethernaught.packet.utils.DataLinkTypes;

import java.nio.ByteBuffer;

public class Packet {

    private DataLinkTypes dataLinkType;
    private Layer frame;
    private long frameTime;
    private int length;

    public Packet(DataLinkTypes dataLinkType, long frameTime, byte[] data){
        this.dataLinkType = dataLinkType;
        this.frameTime = frameTime;
        this.length = data.length;

        switch(dataLinkType){
            case EN10MB:
                frame = new EthernetFrame(ByteBuffer.wrap(data));
                break;

            case LOOP:
                break;

            case RAW:
                break;

            case SLL2:
                break;
        }
    }

    public void setDataLinkType(DataLinkTypes dataLinkType){
        this.dataLinkType = dataLinkType;
    }

    public DataLinkTypes getDataLinkType(){
        return dataLinkType;
    }

    public void setFrame(Layer frame){
        this.frame = frame;
    }

    public Layer getFrame(){
        return frame;
    }

    public void setFrameTime(long frameTime){
        this.frameTime = frameTime;
    }

    public long getFrameTime(){
        return frameTime;
    }

    public byte[] getBytes(){
        return new byte[0];
    }

    public long getLength(){
        return length;
    }

    public long computeLength(){
        return 0;
    }
}
