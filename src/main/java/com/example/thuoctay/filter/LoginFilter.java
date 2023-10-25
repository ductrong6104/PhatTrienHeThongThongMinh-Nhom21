package com.example.thuoctay.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.example.thuoctay.nguoidung.NguoiDungDto;
import com.example.thuoctay.nguoidung.NguoiDungService;
import com.example.thuoctay.taikhoanhethong.TaiKhoanNhanVienDto;
import com.example.thuoctay.taikhoanhethong.TaiKhoanNhanVienService;
import com.example.thuoctay.utils.MyRegex;
import com.example.thuoctay.utils.StringEncryption;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LoginFilter implements Filter {

    private final TaiKhoanNhanVienService taiKhoanNhanVienService;
    private final NguoiDungService nguoiDungService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String uri = httpRequest.getRequestURI();

        if(MyRegex.fc_needRoleKhachHang(uri)){
            String token = httpRequest.getHeader("token");
            if(token == null){
                httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
                httpResponse.getWriter().write("Access denied");
                return;
            }
            String soDienThoai = StringEncryption.decode(token);
            NguoiDungDto dto = nguoiDungService.getBySoDienThoai(soDienThoai);
            if(dto == null){
                httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
                httpResponse.getWriter().write("Access denied");
                return;
            }
            httpRequest.setAttribute("user", dto);
        }
        else if(MyRegex.fc_needRoleAdmin(uri)){
            String token = httpRequest.getHeader("token");
            if(token == null){
                httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
                httpResponse.getWriter().write("Access denied");
                return;
            }
            String tenDangNhap = StringEncryption.decode(token);
            TaiKhoanNhanVienDto dto = taiKhoanNhanVienService.getDtoByTenDangNhap(tenDangNhap);
            if(dto == null || dto.getRole() != "ADMIN"){
                httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
                httpResponse.getWriter().write("Access denied");
                return;
            }
            httpRequest.setAttribute("user", dto);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Khởi tạo Filter (có thể bỏ trống nếu không cần).
    }

    @Override
    public void destroy() {
        // Hủy Filter (có thể bỏ trống nếu không cần).
    }
    
}
