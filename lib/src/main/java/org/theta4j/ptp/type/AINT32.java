package org.theta4j.ptp.type;

import org.theta4j.util.Validators;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class AINT32 {
    private AINT32() {
        throw new AssertionError();
    }

    public static List<INT32> read(InputStream is) throws IOException {
        Validators.validateNonNull("is", is);

        long length = UINT32.read(is).longValue();

        List<INT32> list = new ArrayList<>((int) length);

        for (int i = 0; i < length; i++) {
            list.add(INT32.read(is));
        }

        return list;
    }
}
