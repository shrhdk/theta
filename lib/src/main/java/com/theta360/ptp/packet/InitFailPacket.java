package com.theta360.ptp.packet;

import com.theta360.ptp.io.PtpInputStream;
import com.theta360.ptp.type.UINT32;
import com.theta360.util.Validators;

import java.io.IOException;

public final class InitFailPacket extends PtpIpPacket {
    private static final int SIZE = UINT32.SIZE;

    private final UINT32 reason;

    public InitFailPacket(UINT32 reason) {
        super(Type.INIT_FAIL);

        Validators.validateNonNull("reason", reason);

        this.reason = reason;
        super.payload = reason.bytes();
    }

    public UINT32 getReason() {
        return reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InitFailPacket that = (InitFailPacket) o;

        if (!reason.equals(that.reason)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return reason.hashCode();
    }

    @Override
    public String toString() {
        return "InitFailPacket{" +
                "reason=" + reason +
                '}';
    }

    public static InitFailPacket read(PtpInputStream pis) throws IOException {
        long length = pis.readUINT32().longValue();
        long payloadLength = length - UINT32.SIZE - UINT32.SIZE;
        PtpIpPacket.Type type = PtpIpPacket.Type.read(pis);

        PacketUtils.asseertType(type, Type.INIT_FAIL);
        PacketUtils.checkLength((int) payloadLength, SIZE);

        UINT32 reason = pis.readUINT32();

        return new InitFailPacket(reason);
    }
}
