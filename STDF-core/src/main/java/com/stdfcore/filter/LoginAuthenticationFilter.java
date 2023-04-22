package com.stdfcore.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stdfcore.vo.UserVO;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class LoginAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    /**
     * 构造方法，调用父类的，设置登录地址/login，请求方式POST
     */
    public LoginAuthenticationFilter() {
        super(new AntPathRequestMatcher("/login", "POST"));
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        // 从输入流中获取到登录的信息
        try {
            UserVO userVO = new ObjectMapper().readValue(request.getInputStream(), UserVO.class);
            return super.getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(userVO.getUsername(), userVO.getPassword(), new ArrayList<>())
            );
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
