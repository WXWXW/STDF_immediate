package com.stdfcore.handler;

import com.stdfcore.util.ResponseUtils;
import com.stdfcore.util.Result;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginAuthenticationFailureHandler implements AuthenticationFailureHandler {
    /**
     * 一旦登录失败则会被调用
     *
     * @param httpServletRequest
     * @param response
     * @param exception          这个参数是异常信息，可以根据不同的异常类返回不同的提示信息
     * @throws IOException
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException {

        //TODO 根据项目需要返回指定异常提示，陈某这里演示了一个用户名密码错误的异常
        //BadCredentialsException 这个异常一般是用户名或者密码错误
        if (exception instanceof BadCredentialsException) {
            ResponseUtils.result(response, Result.fail("用户名或密码不正确"));
        }
        ResponseUtils.result(response, Result.fail("登录失败"));
    }
}
