package com.zhangxp.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.zhangxp.entity.UserEntity;
/**
 * Created by Administrator on 2020/6/21 0021.
 */
// mybatis有两种形式：xml和注解
public interface UserMapper {
    @Select("select * from user where name = #{name}")
    UserEntity findByName(@Param("name") String name);
    @Insert("insert into user(id, username, password) values(#{id}, #{name}, #{password})")
    int insert(@Param("id") Integer id, @Param("name") String name, @Param("password") String password);
}
