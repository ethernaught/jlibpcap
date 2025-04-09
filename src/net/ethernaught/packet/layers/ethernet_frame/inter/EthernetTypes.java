package net.ethernaught.packet.layers.ethernet_frame.inter;

public enum EthernetTypes {

    IPV4(2048, "IPv4"),
    ARP(2054, "ARP"),
    IPV6(34525, "IPv6"),
    BROADCAST(34969, "Broadcast"),
    LENGTH(-1, "Length");

    private int code;
    private final String label;

    EthernetTypes(int code, String label){
        this.code = code;
        this.label = label;
    }

    public int getCode(){
        return code;
    }

    public String getLabel(){
        return label;
    }

    public static EthernetTypes lengthType(int code){
        EthernetTypes t = LENGTH;
        t.code = code;
        return t;
    }

    public static EthernetTypes fromCode(int code)throws IllegalArgumentException {
        if(code <= 1500){
            return EthernetTypes.lengthType(code);
        }

        for(EthernetTypes t : EthernetTypes.values()){
            if(t != LENGTH && t.code == code){
                return t;
            }
        }

        throw new IllegalArgumentException("Couldn't find for code: " + code);
    }

    @Override
    public String toString() {
        return this == LENGTH ? "Length" : label;
    }
}
