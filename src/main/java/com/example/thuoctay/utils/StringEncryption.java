package com.example.thuoctay.utils;

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

    // public static void main(String[] args) {
    //     String userName = "0337021937";
    //     String token = encode(userName);
    //     String dc= decode(token);
    //     System.out.println(token);
    //     System.out.println(dc);

    // }
}
