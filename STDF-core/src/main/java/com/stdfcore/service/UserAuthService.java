package com.stdfcore.service;

import com.stdfcore.entity.UserAuth;
import com.stdfcore.vo.UserVO;

/**
 * @author 秀
 * @Description : TODO
 * @create 2023/4/17 14:08
 **/
public interface UserAuthService {

    UserAuth getDbUserByUsername(String username);

    Boolean checkUser(UserAuth userAuth , UserVO userVo);
}
