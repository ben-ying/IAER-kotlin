package com.yjh.iaer.room.entity

import androidx.lifecycle.Transformations.map
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yjh.iaer.model.User

@Entity(tableName = "user_entity")
data class DatabaseUser(
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    var userId: Long,
    @ColumnInfo(name = "username")
    var username: String,
    @ColumnInfo(name = "md5_password")
    var md5Password: String,
    @ColumnInfo(name = "profile")
    var profile: String,
    @ColumnInfo(name = "email")
    var email: String,
    @ColumnInfo(name = "phone")
    var phone: String,
    @ColumnInfo(name = "region")
    var region: String,
    @ColumnInfo(name = "whats_up")
    var whatsUp: String,
    @ColumnInfo(name = "birth")
    var birth: String,
    @ColumnInfo(name = "zone")
    var zone: String,
    @ColumnInfo(name = "locale")
    var locale: String,
    @ColumnInfo(name = "hobbies")
    var hobbies: String,
    @ColumnInfo(name = "highlighted")
    var highlighted: String,
    @ColumnInfo(name = "token")
    var token: String,
    @ColumnInfo(name = "is_login")
    var isLogin: Boolean = false,
    @ColumnInfo(name = "is_in_history")
    var isInHistory: Boolean = false,
    @ColumnInfo(name = "modified")
    var modified: String,
    @ColumnInfo(name = "created")
    var created: String
) {
    fun asDomainUser(): User {
        return User(userId, username, md5Password, profile, email, phone, region, whatsUp,
            birth, zone, locale, hobbies, highlighted, token, isLogin, isInHistory, modified, created)
    }
}


