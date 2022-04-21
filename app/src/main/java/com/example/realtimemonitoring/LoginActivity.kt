package com.example.realtimemonitoring

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        button_login.setOnClickListener{
            val email = username_tx.text.toString().trim()
            val password = password_tx.text.toString().trim()

            if (email.isEmpty()){
                username_tx.error = "Email harus diisi"
                username_tx.requestFocus()
                return@setOnClickListener
            }

            if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                username_tx.error = "Email tidak valid"
                username_tx.requestFocus()
                return@setOnClickListener
            }

            if(password.isEmpty() || password.length < 6){
                password_tx.error = "Password harus lebih dari 6 karakter"
                password_tx.requestFocus()
                return@setOnClickListener
            }

        LoginUser (email,password)
        }


    }

    private fun LoginUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    Intent(this@LoginActivity,HomeActivity::class.java).also{intent ->
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)
                    }
                } else{
                    Toast.makeText(this,"${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onStart() {
        super.onStart()
        if(auth.currentUser !=null){
            Intent(this@LoginActivity,HomeActivity::class.java).also{intent ->
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }
    }
}