package com.lms.customerservice.app.exception;

import java.io.IOException;
import java.util.Base64;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Base64Deserializer extends StdDeserializer<byte[]> {
    public Base64Deserializer() {
        super(byte[].class);
    }
    @Override
    public byte[] deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String base64String = p.getText();
        try {
            return Base64.getDecoder().decode(base64String);
        } catch (IllegalArgumentException e) {
            // Handle invalid base64 characters
            log.error("Invalid base64 character: {}", e.getMessage());
            return new byte[0]; // or return an error response
        }
    }
}