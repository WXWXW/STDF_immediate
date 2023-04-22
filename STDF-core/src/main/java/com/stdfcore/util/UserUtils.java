package com.stdfcore.util;

import com.stdfcore.dto.UserDetailDTO;
import com.stdfcore.entity.UserAuth;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;


/**
 * 用户工具类
 *
 * @author yezhiqiu
 * @date 2021/08/10
 */
@Component
public class UserUtils {

    /**
     * 获取当前登录用户
     *
     * @return 用户登录信息
     */
    public static UserDetailDTO getLoginUser() {
        return  (UserDetailDTO)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

}
