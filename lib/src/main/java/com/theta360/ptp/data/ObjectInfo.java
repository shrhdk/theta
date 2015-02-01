package com.theta360.ptp.data;

import com.theta360.ptp.io.PtpInputStream;
import com.theta360.ptp.type.UINT16;
import com.theta360.ptp.type.UINT32;
import com.theta360.util.Validators;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * ObjectInfo data set
 * <p/>
 * The ObjectInfo data set defined in PTP
 */
public class ObjectInfo {
    private final UINT32 storageID;
    private final UINT16 objectFormat;
    private final ProtectionStatus protectionStatus;
    private final UINT32 objectCompressedSize;
    private final UINT16 thumbFormat;
    private final UINT32 thumbCompressedSize;
    private final UINT32 thumbPixWidth;
    private final UINT32 thumbPixHeight;
    private final UINT32 imagePixWidth;
    private final UINT32 imagePixHeight;
    private final UINT32 imageBitDepth;
    private final UINT32 parentObject;
    private final UINT16 associationType;
    private final UINT32 associationDesc;
    private final UINT32 sequenceNumber;
    private final String fileName;
    private final String captureDate;
    private final String modificationDate;
    private final String keywords;

    // Constructor

    public ObjectInfo(UINT32 storageID, UINT16 objectFormat, ProtectionStatus protectionStatus, UINT32 objectCompressedSize,
                      UINT16 thumbFormat, UINT32 thumbCompressedSize, UINT32 thumbPixWidth, UINT32 thumbPixHeight,
                      UINT32 imagePixWidth, UINT32 imagePixHeight, UINT32 imageBitDepth,
                      UINT32 parentObject, UINT16 associationType, UINT32 associationDesc, UINT32 sequenceNumber,
                      String fileName, String captureDate, String modificationDate, String keywords
    ) {
        Validators.validateNonNull("storageID", storageID);
        Validators.validateNonNull("objectFormat", objectFormat);
        Validators.validateNonNull("protectionStatus", protectionStatus);
        Validators.validateNonNull("objectCompressedSize", objectCompressedSize);
        Validators.validateNonNull("thumbFormat", thumbFormat);
        Validators.validateNonNull("thumbCompressedSize", thumbCompressedSize);
        Validators.validateNonNull("thumbPixWidth", thumbPixWidth);
        Validators.validateNonNull("thumbPixHeight", thumbPixHeight);
        Validators.validateNonNull("imagePixWidth", imagePixWidth);
        Validators.validateNonNull("imagePixHeight", imagePixHeight);
        Validators.validateNonNull("imageBitDepth", imageBitDepth);
        Validators.validateNonNull("parentObject", parentObject);
        Validators.validateNonNull("associationType", associationType);
        Validators.validateNonNull("associationDesc", associationDesc);
        Validators.validateNonNull("sequenceNumber", sequenceNumber);
        Validators.validateNonNull("fileName", fileName);
        Validators.validateNonNull("captureDate", captureDate);
        Validators.validateNonNull("modificationDate", modificationDate);
        Validators.validateNonNull("keywords", keywords);

        this.storageID = storageID;
        this.objectFormat = objectFormat;
        this.protectionStatus = protectionStatus;
        this.objectCompressedSize = objectCompressedSize;
        this.thumbFormat = thumbFormat;
        this.thumbCompressedSize = thumbCompressedSize;
        this.thumbPixWidth = thumbPixWidth;
        this.thumbPixHeight = thumbPixHeight;
        this.imagePixWidth = imagePixWidth;
        this.imagePixHeight = imagePixHeight;
        this.imageBitDepth = imageBitDepth;
        this.parentObject = parentObject;
        this.associationType = associationType;
        this.associationDesc = associationDesc;
        this.sequenceNumber = sequenceNumber;
        this.fileName = fileName;
        this.captureDate = captureDate;
        this.modificationDate = modificationDate;
        this.keywords = keywords;
    }

    // Static Factory Method

    /**
     * Construct ObjectInfo from InputStream
     */
    public static ObjectInfo read(InputStream is) throws IOException {
        Validators.validateNonNull("is", is);

        try (PtpInputStream pis = new PtpInputStream(is)) {
            return read(pis);
        }
    }

    /**
     * Construct ObjectInfo from PtpInputStream.
     *
     * @throws IOException
     */
    public static ObjectInfo read(PtpInputStream pis) throws IOException {
        Validators.validateNonNull("pis", pis);

        UINT32 storageID = pis.readUINT32();
        UINT16 objectFormat = pis.readUINT16();
        ProtectionStatus protectionStatus = ProtectionStatus.valueOf(pis.readUINT16());
        UINT32 objectCompressedSize = pis.readUINT32();
        UINT16 thumbFormat = pis.readUINT16();
        UINT32 thumbCompressedSize = pis.readUINT32();
        UINT32 thumbPixWidth = pis.readUINT32();
        UINT32 thumbPixHeight = pis.readUINT32();
        UINT32 imagePixWidth = pis.readUINT32();
        UINT32 imagePixHeight = pis.readUINT32();
        UINT32 imageBitDepth = pis.readUINT32();
        UINT32 parentObject = pis.readUINT32();
        UINT16 associationType = pis.readUINT16();
        UINT32 associationDesc = pis.readUINT32();
        UINT32 sequenceNumber = pis.readUINT32();
        String fileName = pis.readString();
        String captureDate = pis.readString();
        String modificationDate = pis.readString();
        String keywords = pis.readString();

        return new ObjectInfo(storageID, objectFormat, protectionStatus, objectCompressedSize,
                thumbFormat, thumbCompressedSize, thumbPixWidth, thumbPixHeight,
                imagePixWidth, imagePixHeight, imageBitDepth,
                parentObject, associationType, associationDesc, sequenceNumber,
                fileName, captureDate, modificationDate, keywords
        );
    }

    // Getter

    public UINT32 getStorageID() {
        return storageID;
    }

    public UINT16 getObjectFormat() {
        return objectFormat;
    }

    public ProtectionStatus getProtectionStatus() {
        return protectionStatus;
    }

    public UINT32 getObjectCompressedSize() {
        return objectCompressedSize;
    }

    public UINT16 getThumbFormat() {
        return thumbFormat;
    }

    public UINT32 getThumbCompressedSize() {
        return thumbCompressedSize;
    }

    public UINT32 getThumbPixWidth() {
        return thumbPixWidth;
    }

    public UINT32 getThumbPixHeight() {
        return thumbPixHeight;
    }

    public UINT32 getImagePixWidth() {
        return imagePixWidth;
    }

    public UINT32 getImagePixHeight() {
        return imagePixHeight;
    }

    public UINT32 getImageBitDepth() {
        return imageBitDepth;
    }

    public UINT32 getParentObject() {
        return parentObject;
    }

    public UINT16 getAssociationType() {
        return associationType;
    }

    public UINT32 getAssociationDesc() {
        return associationDesc;
    }

    public UINT32 getSequenceNumber() {
        return sequenceNumber;
    }

    public String getFileName() {
        return fileName;
    }

    public String getCaptureDate() {
        return captureDate;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public String getKeywords() {
        return keywords;
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

        ObjectInfo rhs = (ObjectInfo) o;

        return new EqualsBuilder()
                .append(storageID, rhs.storageID)
                .append(objectFormat, rhs.objectFormat)
                .append(protectionStatus, rhs.protectionStatus)
                .append(objectCompressedSize, rhs.objectCompressedSize)
                .append(thumbFormat, rhs.thumbFormat)
                .append(thumbCompressedSize, rhs.thumbCompressedSize)
                .append(thumbPixWidth, rhs.thumbPixWidth)
                .append(thumbPixHeight, rhs.thumbPixHeight)
                .append(imagePixWidth, rhs.imagePixWidth)
                .append(imagePixHeight, rhs.imagePixHeight)
                .append(imageBitDepth, rhs.imageBitDepth)
                .append(parentObject, rhs.parentObject)
                .append(associationType, rhs.associationType)
                .append(associationDesc, rhs.associationDesc)
                .append(sequenceNumber, rhs.sequenceNumber)
                .append(fileName, rhs.fileName)
                .append(captureDate, rhs.captureDate)
                .append(modificationDate, rhs.modificationDate)
                .append(keywords, rhs.keywords)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(storageID)
                .append(objectFormat)
                .append(protectionStatus)
                .append(objectCompressedSize)
                .append(thumbFormat)
                .append(thumbCompressedSize)
                .append(thumbPixWidth)
                .append(thumbPixHeight)
                .append(imagePixWidth)
                .append(imagePixHeight)
                .append(imageBitDepth)
                .append(parentObject)
                .append(associationType)
                .append(associationDesc)
                .append(sequenceNumber)
                .append(fileName)
                .append(captureDate)
                .append(modificationDate)
                .append(keywords)
                .toHashCode();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    // Related Classes

    /**
     * ProtectionStatus in ObjectInfo defined in PTP
     */
    public enum ProtectionStatus {
        NO_PROTECTION(new UINT16(0x0000)),
        READ_ONLY(new UINT16(0x0001));

        private static final Map<UINT16, ProtectionStatus> PROTECTION_STATUS_MAP = new HashMap<>();

        static {
            for (ProtectionStatus type : ProtectionStatus.values()) {
                PROTECTION_STATUS_MAP.put(type.value, type);
            }
        }

        private final UINT16 value;

        private ProtectionStatus(UINT16 value) {
            this.value = value;
        }

        /**
         * Get ProtectionStatus from value.
         *
         * @param value
         */
        public static ProtectionStatus valueOf(UINT16 value) {
            Validators.validateNonNull("value", value);

            if (!PROTECTION_STATUS_MAP.containsKey(value)) {
                throw new IllegalArgumentException();
            }

            return PROTECTION_STATUS_MAP.get(value);
        }
    }
}
