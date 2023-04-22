package com.stdfcore.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author 秀
 * @Description : TODO
 * @create 2023/4/14 13:44
 **/
//用户名与密码VO，登录时用到
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO {



    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String code;
}
