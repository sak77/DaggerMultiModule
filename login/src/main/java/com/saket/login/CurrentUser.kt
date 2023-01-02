package com.saket.login

/*
A singleton class for current user session
 */
class CurrentUser private constructor(
    val userId: Int,
    val name: String
) {
    companion object {
        private var currentUser: CurrentUser? = null
        fun getInstance(): CurrentUser? {
            currentUser?.let {
                return currentUser
            }
            return null
        }
        fun setCurrentUser(userId: Int, name: String) {
            currentUser = CurrentUser(userId, name)
        }
    }
}