package com.mysamples.mvc.model.domain

const val UNKNOWN = ""

data class Account(
    val firstName: String = UNKNOWN,
    val lastName: String = UNKNOWN,
    val email: String = UNKNOWN
)