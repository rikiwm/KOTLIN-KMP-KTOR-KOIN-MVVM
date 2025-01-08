package org.rikimukhraa.project

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import org.rikimukhraa.project.di.iniistializeKoin

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "KOTLIN-KMP-KTOR-KOIN-MVVM",
    ) {
        iniistializeKoin()
        App()
    }
}