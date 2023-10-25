package com.example.thuoctay.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyRegex {
    public static String[] needRoleKhachHang = { 
            "^/chitietgiohang.*$", "^/donhang.*$","^/chitietdonhang.*$" 
        };

    public static String[] needRoleAdmin = {
            "^/thuoc/them.*$", "^/thuoc/sua.*$", "^/thuoc/xoa.*$", 
            "^/nhom/them.*$", "^/nhom/sua.*$", "^/nhom/xoa.*$", 
            "^/thuonghieu/them.*$", "^/thuonghieu/sua.*$", "^/thuonghieu/xoa.*$",
            "^/duocchat/them.*$", "^/duocchat/sua.*$", "^/duocchat/xoa.*$" 
    };

    public static boolean fc_needRoleKhachHang(String uri) {
        for (int i = 0; i < needRoleKhachHang.length; i++) {
            String regexPattern = needRoleKhachHang[i];
            Pattern pattern = Pattern.compile(regexPattern);
            Matcher matcher = pattern.matcher(uri);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }

    public static boolean fc_needRoleAdmin(String uri) {
        for (int i = 0; i < needRoleAdmin.length; i++) {
            String regexPattern = needRoleAdmin[i];
            Pattern pattern = Pattern.compile(regexPattern);
            Matcher matcher = pattern.matcher(uri);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }
}
