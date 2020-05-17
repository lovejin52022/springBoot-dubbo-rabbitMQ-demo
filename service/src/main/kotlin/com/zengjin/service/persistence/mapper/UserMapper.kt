package com.zengjin.service.persistence.mapper

import com.zengjin.common.payload.User
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

/**
 * @desc
 * @author zengjin
 * @date 2020/5/17
 */
@Mapper
interface UserMapper {
    // 使用注解的方式
    @Select("select * from t_user where name like concat('%',#{name},'%')")
    fun likeName(name: String): List<User>

    @Select("select * from t_user where id = #{id}")
    fun getById(id: Long): User

    // 使用xml的方式
    fun getUsers(): List<User>
}