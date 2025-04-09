package net.ethernaught.utils;

public enum DataLinkTypes {

    NULL {
        @Override
        public int getCode(){
            return 0;
        }

        @Override
        public String toString(){
            return "Null";
        }
    },
    EN10MB {
        @Override
        public int getCode(){
            return 1;
        }

        @Override
        public String toString(){
            return "Ethernet";
        }
    },
    EN3MB {
        @Override
        public int getCode(){
            return 2;
        }

        @Override
        public String toString(){
            return "Experimental Ethernet";
        }
    },
    AX25 {
        @Override
        public int getCode(){
            return 3;
        }

        @Override
        public String toString(){
            return "AX.25";
        }
    },
    PRONET {
        @Override
        public int getCode(){
            return 4;
        }

        @Override
        public String toString(){
            return "ProNET Token Ring";
        }
    },
    CHAOS {
        @Override
        public int getCode(){
            return 5;
        }

        @Override
        public String toString(){
            return "Chaosnet";
        }
    },
    IEEE802 {
        @Override
        public int getCode(){
            return 6;
        }

        @Override
        public String toString(){
            return "IEEE 802";
        }
    },
    ARCNET {
        @Override
        public int getCode(){
            return 7;
        }

        @Override
        public String toString(){
            return "ARCNET";
        }
    },
    SLIP {
        @Override
        public int getCode(){
            return 8;
        }

        @Override
        public String toString(){
            return "SLIP";
        }
    },
    PPP {
        @Override
        public int getCode(){
            return 9;
        }

        @Override
        public String toString(){
            return "PPP";
        }
    },
    FDDI {
        @Override
        public int getCode(){
            return 10;
        }

        @Override
        public String toString(){
            return "FDDI";
        }
    },
    RAW {
        @Override
        public int getCode(){
            return 101;
        }

        @Override
        public String toString(){
            return "Raw";
        }
    },
    IEEE802_11 {
        @Override
        public int getCode(){
            return 105;
        }

        @Override
        public String toString(){
            return "IEEE 802.11";
        }
    },
    LOOP {
        @Override
        public int getCode(){
            return 108;
        }

        @Override
        public String toString(){
            return "Loop";
        }
    },
    IPV4 {
        @Override
        public int getCode(){
            return 228;
        }

        @Override
        public String toString(){
            return "IPv4";
        }
    },
    IPV6 {
        @Override
        public int getCode(){
            return 229;
        }

        @Override
        public String toString(){
            return "IPv6";
        }
    },
    SLL2 {
        @Override
        public int getCode(){
            return 276;
        }

        @Override
        public String toString(){
            return "SLL2";
        }
    };

    public static DataLinkTypes fromCode(int code){
        for(DataLinkTypes c : values()){
            if(c.getCode() == code){
                return c;
            }
        }

        throw new IllegalArgumentException("No enum constant "+DataLinkTypes.class.getName()+" "+code);
    }

    public int getCode(){
        return 0;
    }
}
