package com.stdfcore.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.stdfcore.dao.UserAuthDao;
import com.stdfcore.entity.UserAuth;
import com.stdfcore.service.UserAuthService;
import com.stdfcore.vo.UserVO;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 * @author 秀
 * @Description : TODO
 * @create 2023/4/17 14:08
 **/

@Service
public class UserAuthServiceImpl implements UserAuthService {


    private UserAuthDao userAuthDao;

    @Override
    public UserAuth getDbUserByUsername(String username) {


        //查询用户名是否存在
        UserAuth userAuth = userAuthDao.selectOne(new LambdaQueryWrapper<UserAuth>()
                .select(UserAuth::getUsername));
       return userAuth;
    }

    @Override
    public Boolean checkUser(UserAuth userAuth , UserVO userVo) {
        boolean passFlag = false;
        if (userAuth != null) {
            //前台传入的登录密码做加盐MD5加密
            String encodePassword = BCrypt.hashpw(userVo.getPassword(), BCrypt.gensalt());
            //比较数据里的加盐密码是否相同
            if (encodePassword.equals(userAuth.getPassword())) {
                passFlag = true;
            }
        }
        return passFlag;
    }
}
