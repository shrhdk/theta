package com.theta360.ptp.packet;

import com.theta360.ptp.io.PtpInputStream;
import com.theta360.ptp.type.UINT16;
import com.theta360.ptp.type.UINT32;
import com.theta360.test.categories.UnitTest;
import com.theta360.util.ByteUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static com.theta360.ptp.packet.PtpIpPacket.Type.EVENT;
import static com.theta360.ptp.packet.PtpIpPacket.Type.INIT_EVENT_REQUEST;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Category(UnitTest.class)
public class EventPacketTest {
    private static final byte[] PAYLOAD = new byte[UINT16.SIZE + UINT32.SIZE + UINT32.SIZE * 3];
    private static final UINT16 EVENT_CODE = new UINT16(0);
    private static final UINT32 TRANSACTION_ID = new UINT32(0);
    private static final UINT32 P1 = new UINT32(1);
    private static final UINT32 P2 = new UINT32(2);
    private static final UINT32 P3 = new UINT32(3);

    // Constructor with error

    @Test(expected = NullPointerException.class)
    public void withNullEventCode() {
        // act
        new EventPacket(null, TRANSACTION_ID, P1, P2, P3);
    }

    @Test(expected = NullPointerException.class)
    public void withNullTransactionID() {
        // act
        new EventPacket(EVENT_CODE, null, P1, P2, P3);
    }

    @Test(expected = NullPointerException.class)
    public void withNullParam1() {
        // act
        new EventPacket(EVENT_CODE, TRANSACTION_ID, null, P2, P3);
    }

    @Test(expected = NullPointerException.class)
    public void withNullParam2() {
        // act
        new EventPacket(EVENT_CODE, TRANSACTION_ID, P1, null, P3);
    }

    @Test(expected = NullPointerException.class)
    public void withNullParam3() {
        // act
        new EventPacket(EVENT_CODE, TRANSACTION_ID, P1, P2, null);
    }

    // Constructor

    @Test
    public void constructAndGet() {
        // expected
        byte[] expectedPayload = ByteUtils.join(
                EVENT_CODE.bytes(),
                TRANSACTION_ID.bytes(),
                P1.bytes(), P2.bytes(), P3.bytes()
        );

        // act
        EventPacket packet = new EventPacket(EVENT_CODE, TRANSACTION_ID, P1, P2, P3);

        // verify
        assertThat(packet.getType(), is(EVENT));
        assertThat(packet.getEventCode(), is(EVENT_CODE));
        assertThat(packet.getTransactionID(), is(TRANSACTION_ID));
        assertThat(packet.getP1(), is(P1));
        assertThat(packet.getP2(), is(P2));
        assertThat(packet.getP3(), is(P3));
        assertThat(packet.getPayload(), is(expectedPayload));
    }

    // read with error

    @Test(expected = NullPointerException.class)
    public void readNull() throws IOException {
        // act
        EventPacket.read(null);
    }

    @Test(expected = IOException.class)
    public void readOfInvalidType() throws IOException {
        // given
        PtpIpPacket.Type invalidType = INIT_EVENT_REQUEST;

        // arrange
        PtpIpPacket givenPacket = new PtpIpPacket(invalidType, PAYLOAD);
        PtpInputStream givenInputStream = new PtpInputStream(new ByteArrayInputStream(givenPacket.bytes()));

        // act
        EventPacket.read(givenInputStream);
    }

    @Test(expected = IOException.class)
    public void readInvalidLengthPayload() throws IOException {
        // given
        byte[] givenPayload = new byte[PAYLOAD.length - 1];  // expected length - 1

        // arrange
        PtpIpPacket givenPacket = new PtpIpPacket(EVENT, givenPayload);
        PtpInputStream givenInputStream = new PtpInputStream(new ByteArrayInputStream(givenPacket.bytes()));

        // act
        EventPacket.read(givenInputStream);
    }

    // read

    @Test
    public void read() throws IOException {
        // given
        byte[] givenPayload = ByteUtils.join(
                EVENT_CODE.bytes(),
                TRANSACTION_ID.bytes(),
                P1.bytes(), P2.bytes(), P3.bytes()
        );

        // arrange
        PtpIpPacket givenPacket = new PtpIpPacket(EVENT, givenPayload);
        PtpInputStream givenInputStream = new PtpInputStream(new ByteArrayInputStream(givenPacket.bytes()));

        // act
        EventPacket actual = EventPacket.read(givenInputStream);

        // verify
        assertThat(actual.getType(), is(EVENT));
        assertThat(actual.getEventCode(), is(EVENT_CODE));
        assertThat(actual.getTransactionID(), is(TRANSACTION_ID));
        assertThat(actual.getP1(), is(P1));
        assertThat(actual.getP2(), is(P2));
        assertThat(actual.getP3(), is(P3));
        assertThat(actual.getPayload(), is(givenPayload));
    }
}
