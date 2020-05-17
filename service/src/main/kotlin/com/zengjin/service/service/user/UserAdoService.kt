package com.zengjin.service.service.user

import com.github.pagehelper.Page
import com.github.pagehelper.PageHelper
import com.zengjin.common.payload.User
import com.zengjin.service.persistence.mapper.UserMapper
import org.springframework.stereotype.Service

/**
 * @desc
 * @author zengjin
 * @date 2020/5/17
 */
@Service
class UserAdoService (
        private val userMapper: UserMapper
) {
    fun search(
            page: Int = 0,
            size: Int = 20
    ): Page<User>  {
        PageHelper.startPage<User>(page + 1, size)
        return this.userMapper.getUsers() as Page<User>
    }
}