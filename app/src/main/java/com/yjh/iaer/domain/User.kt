package com.yjh.iaer.domain

data class User(
    val userId: Long = 0,
    var username: String?,
    var md5Password: String?,
    var profile: String?,
    var email: String?,
    var phone: String?,
    var region: String?,
    var whatsUp: String?,
    var birth: String?,
    var zone: String?,
    var locale: String?,
    var hobbies: String?,
    var highlighted: String?,
    var token: String?,
    var isLogin: Boolean = false,
    var isInHistory: Boolean = false,
    var modified: String?,
    var created: String?
)
