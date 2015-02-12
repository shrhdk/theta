package com.theta360.ptp.data;

import com.theta360.ptp.type.UINT16;
import com.theta360.ptp.type.UINT32;
import com.theta360.util.Validators;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Response {
    private final UINT16 responseCode;
    private final UINT32 sessionID;
    private final UINT32 transactionID;
    private final UINT32 p1, p2, p3, p4, p5;

    // Constructor

    public Response(UINT16 responseCode, UINT32 sessionID, UINT32 transactionID) {
        this(responseCode, sessionID, transactionID, UINT32.ZERO);
    }

    public Response(UINT16 responseCode, UINT32 sessionID, UINT32 transactionID, UINT32 p1) {
        this(responseCode, sessionID, transactionID, p1, UINT32.ZERO);
    }

    public Response(UINT16 responseCode, UINT32 sessionID, UINT32 transactionID, UINT32 p1, UINT32 p2) {
        this(responseCode, sessionID, transactionID, p1, p2, UINT32.ZERO);
    }

    public Response(UINT16 responseCode, UINT32 sessionID, UINT32 transactionID, UINT32 p1, UINT32 p2, UINT32 p3) {
        this(responseCode, sessionID, transactionID, p1, p2, p3, UINT32.ZERO);
    }

    public Response(UINT16 responseCode, UINT32 sessionID, UINT32 transactionID, UINT32 p1, UINT32 p2, UINT32 p3, UINT32 p4) {
        this(responseCode, sessionID, transactionID, p1, p2, p3, p4, UINT32.ZERO);
    }

    public Response(UINT16 responseCode, UINT32 sessionID, UINT32 transactionID, UINT32 p1, UINT32 p2, UINT32 p3, UINT32 p4, UINT32 p5) {
        Validators.validateNonNull("responseCode", responseCode);
        Validators.validateNonNull("sessionID", sessionID);
        Validators.validateNonNull("transactionID", transactionID);
        Validators.validateNonNull("p1", p1);
        Validators.validateNonNull("p2", p2);
        Validators.validateNonNull("p3", p3);
        Validators.validateNonNull("p4", p4);
        Validators.validateNonNull("p5", p5);

        this.responseCode = responseCode;
        this.sessionID = sessionID;
        this.transactionID = transactionID;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
    }

    // Getter

    public UINT16 getResponseCode() {
        return responseCode;
    }

    public UINT32 getSessionID() {
        return sessionID;
    }

    public UINT32 getTransactionID() {
        return transactionID;
    }

    public UINT32 getP1() {
        return p1;
    }

    public UINT32 getP2() {
        return p2;
    }

    public UINT32 getP3() {
        return p3;
    }

    public UINT32 getP4() {
        return p4;
    }

    public UINT32 getP5() {
        return p5;
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

        Response rhs = (Response) o;

        return new EqualsBuilder()
                .append(responseCode, rhs.responseCode)
                .append(sessionID, rhs.sessionID)
                .append(transactionID, rhs.transactionID)
                .append(p1, rhs.p1)
                .append(p2, rhs.p2)
                .append(p3, rhs.p3)
                .append(p4, rhs.p4)
                .append(p5, rhs.p5)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(responseCode)
                .append(sessionID)
                .append(transactionID)
                .append(p1)
                .append(p2)
                .append(p3)
                .append(p4)
                .append(p5)
                .toHashCode();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
