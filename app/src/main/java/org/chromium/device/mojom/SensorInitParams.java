
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     device/generic_sensor/public/interfaces/sensor_provider.mojom
//

package org.chromium.device.mojom;

import org.chromium.base.annotations.SuppressFBWarnings;
import org.chromium.mojo.bindings.DeserializationException;


public final class SensorInitParams extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 48;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(48, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

    
    public static final long READ_BUFFER_SIZE_FOR_TESTS = (long) 48L;
    public org.chromium.mojo.system.SharedBufferHandle memory;
    public long bufferOffset;
    public int mode;
    public SensorConfiguration defaultConfiguration;
    public double maximumFrequency;
    public double minimumFrequency;

    private SensorInitParams(int version) {
        super(STRUCT_SIZE, version);
        memory = org.chromium.mojo.system.InvalidHandle.INSTANCE;
    }

    public SensorInitParams() {
        this(0);
    }

    public static SensorInitParams deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static SensorInitParams deserialize(java.nio.ByteBuffer data) {
        if (data == null)
            return null;

        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static SensorInitParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        SensorInitParams result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            result = new SensorInitParams(mainDataHeader.elementsOrVersion);
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.memory = decoder0.readSharedBufferHandle(8, false);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.mode = decoder0.readInt(12);
                    ReportingMode.validate(result.mode);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.bufferOffset = decoder0.readLong(16);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(24, false);
                result.defaultConfiguration = SensorConfiguration.decode(decoder1);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.maximumFrequency = decoder0.readDouble(32);
            }
            if (mainDataHeader.elementsOrVersion >= 0) {
                
                result.minimumFrequency = decoder0.readDouble(40);
            }
        } finally {
            decoder0.decreaseStackDepth();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected final void encode(org.chromium.mojo.bindings.Encoder encoder) {
        org.chromium.mojo.bindings.Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        
        encoder0.encode(memory, 8, false);
        
        encoder0.encode(mode, 12);
        
        encoder0.encode(bufferOffset, 16);
        
        encoder0.encode(defaultConfiguration, 24, false);
        
        encoder0.encode(maximumFrequency, 32);
        
        encoder0.encode(minimumFrequency, 40);
    }

    /**
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (object == null)
            return false;
        if (getClass() != object.getClass())
            return false;
        SensorInitParams other = (SensorInitParams) object;
        if (!org.chromium.mojo.bindings.BindingsHelper.equals(this.memory, other.memory))
            return false;
        if (this.bufferOffset!= other.bufferOffset)
            return false;
        if (this.mode!= other.mode)
            return false;
        if (!org.chromium.mojo.bindings.BindingsHelper.equals(this.defaultConfiguration, other.defaultConfiguration))
            return false;
        if (this.maximumFrequency!= other.maximumFrequency)
            return false;
        if (this.minimumFrequency!= other.minimumFrequency)
            return false;
        return true;
    }

    /**
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = prime + getClass().hashCode();
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(memory);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(bufferOffset);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(mode);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(defaultConfiguration);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(maximumFrequency);
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(minimumFrequency);
        return result;
    }
}