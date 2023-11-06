package com.example.thuoctay.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.thuoctay.anotation.Role;
import com.example.thuoctay.nguoidung.NguoiDungDto;
import com.example.thuoctay.taikhoanhethong.TaiKhoanNhanVienDto;
import com.example.thuoctay.utils.Auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleInterceptor implements HandlerInterceptor {

    private final Auth auth;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Role roleAnnotation = handlerMethod.getMethod().getAnnotation(Role.class);
            
            System.out.println("\n\nROLES: " + roleAnnotation.toString());
            if (roleAnnotation != null) {
                String[] requiredRoles = roleAnnotation.value();

                NguoiDungDto nguoiDungDto = auth.getNguoiDungFromRequest(request);
                if (nguoiDungDto != null) {
                    for (String requiredRole : requiredRoles) {
                        if (requiredRole.equals("CUSTOMER")) {
                            return true;
                        }
                    }
                }

                TaiKhoanNhanVienDto taiKhoanNhanVienDto = auth.getNhanVienFromRequest(request);
                if (taiKhoanNhanVienDto != null) {
                    String taiKhoanNhanVienRole = taiKhoanNhanVienDto.getRole();
                    for (String requiredRole : requiredRoles) {
                        // if (requiredRole.equals(taiKhoanNhanVienRole)) {
                        //     return true;
                        // }
                        System.out.println(taiKhoanNhanVienRole + "____" + requiredRole);
                    }
                }
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                return false;
            }
        return true;
    }
}
