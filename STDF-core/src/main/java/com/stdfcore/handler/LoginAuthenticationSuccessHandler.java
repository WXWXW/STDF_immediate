package com.stdfcore.handler;

import com.alibaba.fastjson.JSON;
import com.stdfcore.dao.UserAuthDao;
import com.stdfcore.dto.UserDetailDTO;
import com.stdfcore.entity.UserAuth;
import com.stdfcore.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import com.stdfcore.util.JwtTokenUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.stdfcore.constant.CommonConst.APPLICATION_JSON;

@Component
@Slf4j
public class LoginAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    @Autowired
    private UserAuthDao userAuthDao;
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authResult) throws IOException {

        UserDetailDTO jwtUser = (UserDetailDTO) authResult.getPrincipal();
        System.out.println("jwtUser:" + jwtUser.toString());

        //生成令牌
        String accessToken = JwtTokenUtils.createToken(jwtUser.getUsername(), false);

        UserAuth userAuth = BeanCopyUtils.copyObject(UserUtils.getLoginUser(), UserAuth.class);

        httpServletResponse.setContentType(APPLICATION_JSON);
        httpServletResponse.setHeader("token", JwtTokenUtils.TOKEN_PREFIX + accessToken);
        httpServletResponse.getWriter().write(JSON.toJSONString(Result.ok(userAuth)));


        updateUserInfo();
    }

    @Async
    public void updateUserInfo() {

        UserAuth userAuth = UserAuth.builder()
                .id(UserUtils.getLoginUser().getId())
                .ipAddress(UserUtils.getLoginUser().getIpAddress())
                .ipSource(UserUtils.getLoginUser().getIpSource())
                .lastLoginTime(UserUtils.getLoginUser().getLastLoginTime())
                .build();


        System.out.println(userAuth);
        userAuthDao.updateById(userAuth);
    }
}
