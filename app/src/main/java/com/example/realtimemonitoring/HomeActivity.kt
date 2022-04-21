package com.example.realtimemonitoring

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.realtimemonitoring.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {


    private lateinit var auth : FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var reference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        auth = FirebaseAuth.getInstance()

        button_logout.setOnClickListener{
            auth.signOut()
            Intent(this@HomeActivity, LoginActivity::class.java).also{
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }

    database = FirebaseDatabase.getInstance().getReference("value")
        val value = it.child("value")
        data_tx.text = value.toString
    }


    }
}