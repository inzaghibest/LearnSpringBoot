package com.zhangxp.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2020/6/25 0025.
 */
@RunWith(SpringRunner.class)
public class TestBCrypt {
    @Test
    public void test() {

        // 对密码进行加密
        String strpw = BCrypt.hashpw("1111", BCrypt.gensalt());
        System.out.println(strpw);
        String strpw1 = BCrypt.hashpw("1111", BCrypt.gensalt());
        System.out.println(strpw1);

        // 校验密码
        boolean bCheckPw = BCrypt.checkpw("1111",
                "$2a$10$pwt3edTjK2neigEcM21Dh.Ky5vDInInqUdD4GYq.YHyxPKho5ud7S");
        System.out.println("------------" + bCheckPw + "------------");
    }
}
