package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle



class MainActivity : AppCompatActivity() {
    //val ref=FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*val email=findViewById<TextInputEditText>(R.id.email)
        val pass=findViewById<TextInputEditText>(R.id.password)
        val btn=findViewById<Button>(R.id.btnreg)
        btn.setOnClickListener {
            ref.createUserWithEmailAndPassword(email.text.toString().trim(),
            pass.text.toString().trim())
            Toast.makeText(this,"Estas registrado¡",Toast.LENGTH_SHORT).show()
        }

    }*/
    }
}