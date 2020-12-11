package com.first.mybuy.model

open class UserResponse {
    data class User(val userName: String, val password: String) : UserResponse()
    class UserReadException: UserResponse()
    class NoUserException: UserResponse()
}