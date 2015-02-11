package com.theta360.ptpip.packet;

import com.theta360.ptp.io.PtpInputStream;
import com.theta360.util.Validators;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.IOException;

/**
 * ProbeRequest Packet defined in PTP-IP
 */
public final class ProbeRequestPacket extends PtpIpPacket {
    private static final int SIZE_IN_BYTES = 0;

    // Static Factory Method

    public static ProbeRequestPacket read(PtpInputStream pis) throws IOException {
        Validators.validateNonNull("pis", pis);

        // Read Header
        long length = pis.readUINT32().longValue();
        long payloadLength = length - HEADER_SIZE_IN_BYTES;
        PtpIpPacket.Type type = PtpIpPacket.Type.read(pis);

        // Validate Header
        PtpIpPacketUtils.assertType(type, Type.PROBE_REQUEST.value(), Type.PROBE_REQUEST);
        PtpIpPacketUtils.checkLength((int) payloadLength, SIZE_IN_BYTES);

        return new ProbeRequestPacket();
    }

    // PtpIpPacket

    @Override
    Type getType() {
        return Type.PROBE_REQUEST;
    }

    @Override
    byte[] getPayload() {
        return ArrayUtils.EMPTY_BYTE_ARRAY;
    }

    // Basic Method

    @Override
    public boolean equals(Object o) {
        return this == o || !(o == null || getClass() != o.getClass());

    }

    @Override
    public int hashCode() {
        return Type.PROBE_REQUEST.ordinal();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).toString();
    }
}
