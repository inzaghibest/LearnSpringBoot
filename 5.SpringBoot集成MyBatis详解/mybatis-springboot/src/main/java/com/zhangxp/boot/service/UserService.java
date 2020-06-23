package com.zhangxp.boot.service;

import com.zhangxp.boot.entity.User;
import com.zhangxp.boot.mapper.UserMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.log4j12.*;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/6/22 0022.
 */
@Service
public class UserService {
    @Autowired(required = false)
    private UserMapper userMapper;

    public void createUser(User user) {
        userMapper.insertSelective(user);
    }

    public void updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }

    public void findUser() {
        // 1. 按主键查询
//      User user =  userMapper.selectByPrimaryKey(1);
//      if (user != null) {
//          System.out.println(user.toString());
//      }else {
//          System.out.println("---------User-------------NULL");
//      }

      // 2. 按字段查询
        User user = new User();
        user.setUsername("user89");
        List<User> listUser = userMapper.select(user);
        System.out.println("size:" + listUser.size());

        // 3. 多个条件查询
        User user1 = new User();
        user.setUsername("user73");
        user.setPassword("3323231");
        User obj = userMapper.selectOne(user);
        if(obj != null) {
            System.out.println(obj.toString());
        }

        // 4. 复杂查询用 Example.Criteria
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username","user73");
        criteria.andEqualTo("password", "3323231");
        List<User> objs = userMapper.selectByExample(example);
        if (objs.size() > 0)
        {
            for (int i = 0; i<objs.size(); i++)
            {
                System.out.println(objs.get(i).toString());
            }
        }

        // 5. 模糊查询的例子
        example = new Example(User.class);
        criteria = example.createCriteria();
        criteria.andLike("username","user4%");
        objs = userMapper.selectByExample(example);
        if (objs.size() > 0)
        {
            for (int i = 0; i<objs.size(); i++)
            {
                System.out.println(objs.get(i).toString());
            }
        }

        // 6. 降序排序
        example = new Example(User.class);
        example.setOrderByClause("id desc");
        criteria = example.createCriteria();
        criteria.andLike("username","user4%");
        objs = userMapper.selectByExample(example);
        System.out.println("--------排序-------------");
        if (objs.size() > 0)
        {
            for (int i = 0; i<objs.size(); i++)
            {
                System.out.println(objs.get(i).toString());
            }
        }

        // 7. in ()查询
        example = new Example(User.class);
        criteria = example.createCriteria();
        List ids = new ArrayList();
        ids.add(1);
        ids.add(2);
        ids.add(49);
        criteria.andIn("id", ids);
        objs = userMapper.selectByExample(example);
        System.out.println("--------in (1,2,49)-------------");
        if (objs.size() > 0)
        {
            for (int i = 0; i<objs.size(); i++)
            {
                System.out.println(objs.get(i).toString());
            }
        }

        // 8. 分页查询1
        System.out.println("------------分页查询1--------------");
        User obj2 = new User();
        obj2.setUsername("121212");
        int count = userMapper.selectCount(obj2);
        System.out.println("分页例子,总条数: " + count);
        objs = userMapper.selectByRowBounds(obj2, new RowBounds(0,10));
        for (User u:objs)
        {
            System.out.println(u.toString());
        }
        // 9 分页查询2
        example = new Example(User.class);
        criteria = example.createCriteria();
        criteria.andLike("username","user4%");
        count = userMapper.selectCountByExample(example);
        System.out.println("----------分页例子2:-----------");
        objs = userMapper.selectByExampleAndRowBounds(example, new RowBounds(0,10));
        System.out.println("--------分页例子2-------------");
        for (User u:objs)
        {
            System.out.println(u.toString());
        }
    }
}
