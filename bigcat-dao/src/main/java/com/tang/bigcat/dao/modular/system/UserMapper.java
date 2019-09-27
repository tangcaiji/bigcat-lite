package com.tang.bigcat.dao.modular.system;

import com.tang.bigcat.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

   // @Select("select user_id id,name from sys_user where user_id=#{0}")
    public User getUserById(String id);

}
