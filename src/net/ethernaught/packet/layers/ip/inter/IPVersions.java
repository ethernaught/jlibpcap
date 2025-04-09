package net.ethernaught.packet.layers.ip.inter;

public enum IPVersions {

    IPV4 {
        @Override
        public byte getCode(){
            return 4;
        }

        @Override
        public String toString(){
            return "IPv4";
        }
    },
    IPV6 {
        @Override
        public byte getCode(){
            return 6;
        }

        @Override
        public String toString(){
            return "IPv6";
        }
    };

    public static IPVersions fromCode(byte code){
        for(IPVersions c : values()){
            if(c.getCode() == code){
                return c;
            }
        }

        throw new IllegalArgumentException("No enum constant "+IPVersions.class.getName()+" "+code);
    }

    public byte getCode(){
        return 0;
    }
}
