package com.theta360.ptp.io;

import com.theta360.ptp.type.*;
import com.theta360.test.categories.UnitTest;
import com.theta360.util.ByteUtils;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@Category(UnitTest.class)
public class PtpInputStreamTest {
    @Test
    public void readUINT16() throws IOException {
        // given
        UINT16 given = new UINT16(UINT16.MAX_VALUE);
        InputStream givenInputStream = new ByteArrayInputStream(given.bytes());

        // arrange
        PtpInputStream pis = new PtpInputStream(givenInputStream);

        // act
        UINT16 actual = pis.readUINT16();

        // verify
        assertThat(actual, is(given));
    }

    @Test
    public void readUINT32() throws IOException {
        // given
        UINT32 given = new UINT32(UINT32.MAX_VALUE);
        InputStream givenInputStream = new ByteArrayInputStream(given.bytes());

        // arrange
        PtpInputStream pis = new PtpInputStream(givenInputStream);

        // act
        UINT32 actual = pis.readUINT32();

        // verify
        assertThat(actual, is(given));
    }

    @Test
    public void readUINT64() throws IOException {
        // given
        UINT64 given = UINT64.ZERO;

        // arrange
        InputStream givenInputStream = new ByteArrayInputStream(given.bytes());
        PtpInputStream pis = new PtpInputStream(givenInputStream);

        // act
        UINT64 actual = pis.readUINT64();

        // verify
        assertThat(actual, is(given));
    }

    @Test
    public void readAUINT16() throws IOException {
        // given
        byte[] given = ByteUtils.join(
                new UINT32(3).bytes(),
                new UINT16(UINT16.MAX_VALUE).bytes(),
                new UINT16(UINT16.MAX_VALUE).bytes(),
                new UINT16(UINT16.MAX_VALUE).bytes()
        );

        // expected
        List<UINT16> expected = new ArrayList<>();
        expected.add(new UINT16(UINT16.MAX_VALUE));
        expected.add(new UINT16(UINT16.MAX_VALUE));
        expected.add(new UINT16(UINT16.MAX_VALUE));

        // arrange
        InputStream givenInputStream = new ByteArrayInputStream(given);
        PtpInputStream pis = new PtpInputStream(givenInputStream);

        // act
        List<UINT16> actual = pis.readAUINT16();

        // verify
        assertThat(actual, is(expected));
    }

    @Test
    public void readAUINT32() throws IOException {
        // given
        byte[] given = ByteUtils.join(
                new UINT32(3).bytes(),
                new UINT32(UINT32.MAX_VALUE).bytes(),
                new UINT32(UINT32.MAX_VALUE).bytes(),
                new UINT32(UINT32.MAX_VALUE).bytes()
        );

        // expected
        List<UINT32> expected = new ArrayList<>();
        expected.add(new UINT32(UINT32.MAX_VALUE));
        expected.add(new UINT32(UINT32.MAX_VALUE));
        expected.add(new UINT32(UINT32.MAX_VALUE));

        // arrange
        InputStream givenInputStream = new ByteArrayInputStream(given);
        PtpInputStream pis = new PtpInputStream(givenInputStream);

        // act
        List<UINT32> actual = pis.readAUINT32();

        // verify
        assertThat(actual, is(expected));
    }

    @Test
    public void readString() throws IOException {
        // given
        String given = "test";

        // arrange
        InputStream givenInputStream = new ByteArrayInputStream(STR.toBytes(given));
        PtpInputStream pis = new PtpInputStream(givenInputStream);

        // act
        String actual = pis.readString();

        // verify
        assertThat(actual, is(given));
    }

    @Test
    public void readPtpIpString() throws IOException {
        // given
        String given = "test";

        // arrange
        InputStream givenInputStream = new ByteArrayInputStream(PtpIpString.toBytes(given));
        PtpInputStream pis = new PtpInputStream(givenInputStream);

        // act
        String actual = pis.readPtpIpString();

        // verify
        assertThat(actual, is(given));
    }
}
