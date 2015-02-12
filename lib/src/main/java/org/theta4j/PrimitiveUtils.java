package org.theta4j;

import org.theta4j.ptp.type.UINT32;
import org.theta4j.util.Validators;

import java.util.ArrayList;
import java.util.List;

class PrimitiveUtils {
    private PrimitiveUtils() {
        throw new AssertionError();
    }

    public static List<Long> convert(List<UINT32> src) {
        Validators.validateNonNull("src", src);

        List<Long> dst = new ArrayList<>();
        for (UINT32 uint32 : src) {
            dst.add(uint32.longValue());
        }
        
        return dst;
    }
}
