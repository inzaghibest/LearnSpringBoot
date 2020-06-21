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
    @Select("select * from users where name = #{name}")
    UserEntity findByName(@Param("name") String name);
    @Insert("insert into users(name, age) values(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);
}
