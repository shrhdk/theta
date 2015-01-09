package com.theta360.ptp.packet;

import com.theta360.ptp.io.PtpInputStream;
import com.theta360.ptp.type.UINT32;

import java.io.IOException;

public final class ProbeResponsePacket extends PtpIpPacket {
    private static final int SIZE = 0;

    public ProbeResponsePacket() {
        super(Type.PROBE_RESPONSE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Type.PROBE_RESPONSE.ordinal();
    }

    @Override
    public String toString() {
        return "ProbeResponsePacket{}";
    }

    public static ProbeResponsePacket read(PtpInputStream pis) throws IOException {
        long length = pis.readUINT32().longValue();
        long payloadLength = length - UINT32.SIZE - UINT32.SIZE;
        PtpIpPacket.Type type = PtpIpPacket.Type.read(pis);

        PacketUtils.asseertType(type, Type.PROBE_RESPONSE);
        PacketUtils.checkLength((int) payloadLength, SIZE);

        return new ProbeResponsePacket();
    }
}
