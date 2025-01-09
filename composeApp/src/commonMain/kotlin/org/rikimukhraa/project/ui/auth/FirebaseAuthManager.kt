package org.rikimukhraa.project.ui.auth

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.AuthResult
import dev.gitlive.firebase.auth.FirebaseAuth
import dev.gitlive.firebase.auth.auth

class FirebaseAuthManager {
    private val auth: FirebaseAuth = Firebase.auth

    suspend fun login(email: String, password: String): AuthResult = auth.signInWithEmailAndPassword(email, password)
    suspend fun register(email: String, password: String): AuthResult = auth.createUserWithEmailAndPassword(email, password)

    fun getCurrentUser() = auth.currentUser
    suspend fun logout() {
        auth.signOut()
    }
}