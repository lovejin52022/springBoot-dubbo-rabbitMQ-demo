package com.zengjin.common.payload

import java.io.Serializable

/**
 * @desc
 * @author zengjin
 * @date 2020/5/17
 */
data class User(
        var id: Long? = null,
        var name: String? = null,
        var age: Int? = null,
        var address: String? = null
) : Serializable