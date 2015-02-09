package com.theta360.ptpip.packet;

import com.theta360.ptp.io.PtpInputStream;
import com.theta360.ptp.type.UINT32;
import com.theta360.util.Validators;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.IOException;

/**
 * InitFail Packet defined in PTP-IP
 */
public final class InitFailPacket extends PtpIpPacket {
    private static final int SIZE_IN_BYTES = UINT32.SIZE_IN_BYTES;

    private final UINT32 reason;

    // Constructor

    public InitFailPacket(UINT32 reason) {
        super(Type.INIT_FAIL);

        Validators.validateNonNull("reason", reason);

        this.reason = reason;
        super.payload = reason.bytes();
    }

    // Static Factory Method

    public static InitFailPacket read(PtpInputStream pis) throws IOException {
        Validators.validateNonNull("pis", pis);

        // Read Header
        long length = pis.readUINT32().longValue();
        long payloadLength = length - HEADER_SIZE_IN_BYTES;
        PtpIpPacket.Type type = PtpIpPacket.Type.read(pis);

        // Validate Header
        PacketUtils.assertType(type, Type.INIT_FAIL);
        PacketUtils.checkLength((int) payloadLength, SIZE_IN_BYTES);

        // Read Body
        UINT32 reason = pis.readUINT32();

        return new InitFailPacket(reason);
    }

    // Getter

    public UINT32 getReason() {
        return reason;
    }

    // Basic Method

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        InitFailPacket rhs = (InitFailPacket) o;

        return reason.equals(rhs.reason);
    }

    @Override
    public int hashCode() {
        return reason.hashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(reason)
                .toString();
    }
}
