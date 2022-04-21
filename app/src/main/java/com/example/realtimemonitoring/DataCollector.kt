package com.example.realtimemonitoring

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DataCollector : AppCompatActivity(){

private lateinit var database: FirebaseDatabase
private lateinit var reference: DatabaseReference
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

    database = FirebaseDatabase.getInstance();
    reference = database.getReference("value")

}

    private fun getData()
    {
        reference.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {

            }
        })
    }

}
