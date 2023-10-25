package com.example.thuoctay.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.thuoctay.nguoidung.NguoiDungService;
import com.example.thuoctay.taikhoanhethong.TaiKhoanNhanVienService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class FilterConfig {

    private final TaiKhoanNhanVienService taiKhoanNhanVienService;
    private final NguoiDungService nguoiDungService;

    @Bean
    public FilterRegistrationBean<LoginFilter> loggingFilter() {
        FilterRegistrationBean<LoginFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LoginFilter(taiKhoanNhanVienService, nguoiDungService));
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }
}
