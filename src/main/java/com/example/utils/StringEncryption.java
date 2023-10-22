package com.example.utils;

import java.util.Base64;

public class StringEncryption {

    public static String encode(String originalString) {
        // Mã hóa chuỗi sử dụng Base64
        byte[] encodedBytes = Base64.getEncoder().encode(originalString.getBytes());
        return new String(encodedBytes);
    }

    public static String decode(String encodedString) {
        // Giải mã chuỗi sử dụng Base64
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString.getBytes());
        return new String(decodedBytes);
    }
}
