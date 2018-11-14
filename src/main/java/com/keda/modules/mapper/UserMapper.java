package com.keda.modules.mapper;

import com.keda.modules.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 查询所有用户数据
     *
     * @return 用户数据列表
     */
    @Results(value = {
            @Result(property = "userId", column = "userId"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("select userId, name, age from user")
    List<User> getUsers();

    @Delete("delete from user where userId=#{id}")
    int delete(long id);
}

