package org.rikimukhraa.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform