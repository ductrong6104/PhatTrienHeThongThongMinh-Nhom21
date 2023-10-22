package com.example.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyRegex {
    public static String[] regexPatterns = {"^/chitietgiohang.*$", "^/donhang.*$"};

    public static boolean pathMatch(String uri){
        for (int i = 0; i < regexPatterns.length; i++) {
            String regexPattern = regexPatterns[i];
            Pattern pattern = Pattern.compile(regexPattern);
            Matcher matcher = pattern.matcher(uri);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }
}
