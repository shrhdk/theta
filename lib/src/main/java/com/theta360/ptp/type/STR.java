package com.theta360.ptp.type;

import com.theta360.util.ByteUtils;
import com.theta360.util.Validators;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

public final class STR {
    public static final int MIN_SIZE = UINT16.SIZE;

    private static Charset CHARSET = Charset.forName("UTF-16LE");

    private STR() {
    }

    public static byte[] toBytes(String str) {
        Validators.validateNonNull("str", str);

        byte[] length = new byte[]{(byte) str.length()};
        return ByteUtils.join(length, str.getBytes(CHARSET));
    }

    public static String read(InputStream is) throws IOException {
        Validators.validateNonNull("is", is);

        int numChars = is.read();
        if(numChars == -1) {
            throw new IOException();
        }

        int length = numChars * UINT16.SIZE;

        byte[] bytes = new byte[length];
        if (is.read(bytes) == -1) {
            throw new IOException();
        }

        return new String(bytes, CHARSET);
    }
}
