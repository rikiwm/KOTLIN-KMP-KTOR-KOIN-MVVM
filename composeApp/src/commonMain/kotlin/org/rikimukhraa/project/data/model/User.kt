package org.rikimukhraa.project.data.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id:Int?,
    val username: String? = null,
    val password: String? = null,
    val token: String? = null

    )
