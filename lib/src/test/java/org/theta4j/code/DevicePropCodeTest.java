package org.theta4j.code;

import org.theta4j.ptp.type.UINT16;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DevicePropCodeTest {
    @Test
    public void value() {
        assertThat(DevicePropCode.BATTERY_LEVEL.value(), is(new UINT16(0x5001)));
    }
}
