package com.example.thuoctay.filter;

import java.io.IOException;

import com.example.utils.MyRegex;
import com.example.utils.StringEncryption;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String uri = httpRequest.getRequestURI();
        if(MyRegex.pathMatch(uri)){
            String token = StringEncryption.encode("Phungducmanh");
            String username = StringEncryption.decode(token);
            System.out.println("Token: " + token + "\n\ndecode: " + username);
            System.out.println("Response Logging: " + response.getContentType() + "\n\n\n\n\n\n\n");
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
