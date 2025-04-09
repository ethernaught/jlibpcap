package net.ethernaught.packet.layers.ip.inter;

public enum IPProtocols {

    HOPBYHOP {
        @Override
        public byte getCode(){
            return 0;
        }

        @Override
        public String toString(){
            return "HOP_BY_HOP";
        }
    },
    ICMP {
        @Override
        public byte getCode(){
            return 1;
        }

        @Override
        public String toString(){
            return "ICMP";
        }
    },
    IGMP {
        @Override
        public byte getCode(){
            return 2;
        }

        @Override
        public String toString(){
            return "IGMP";
        }
    },
    TCP {
        @Override
        public byte getCode(){
            return 6;
        }

        @Override
        public String toString(){
            return "TCP";
        }
    },
    UDP {
        @Override
        public byte getCode(){
            return 17;
        }

        @Override
        public String toString(){
            return "UDP";
        }
    },
    IPV6 {
        @Override
        public byte getCode(){
            return 18;
        }

        @Override
        public String toString(){
            return "IPv6";
        }
    },
    GRE {
        @Override
        public byte getCode(){
            return 47;
        }

        @Override
        public String toString(){
            return "GRE";
        }
    },
    ICMPV6 {
        @Override
        public byte getCode(){
            return 58;
        }

        @Override
        public String toString(){
            return "ICMPv6";
        }
    },
    OSPF {
        @Override
        public byte getCode(){
            return 89;
        }

        @Override
        public String toString(){
            return "OSPF";
        }
    },
    SPS {
        @Override
        public byte getCode(){
            return (byte) 128;
        }

        @Override
        public String toString(){
            return "SPS";
        }
    };

    public static IPProtocols fromCode(byte code){
        for(IPProtocols c : values()){
            if(c.getCode() == code){
                return c;
            }
        }

        throw new IllegalArgumentException("No enum constant "+IPProtocols.class.getName()+" "+code);
    }

    public byte getCode(){
        return 0;
    }
}
