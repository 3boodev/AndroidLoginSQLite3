package com.example.abdullah.task1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signin.*



class Signin : AppCompatActivity() {

    var DB: Database? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        DB = Database(this)
        btn_sign.setOnClickListener {
            if (user.text.toString()==""||pass.text.toString()==""){
                user.error="Must Enter Email"
                pass.error="Must Enter Password"
            }else {
                val checklog = DB!!.chexhall(user.text.toString(), pass.text.toString())
                if (checklog == true) {
                    Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "You should have Email Firstly", Toast.LENGTH_SHORT).show()
                }
            }
        }
        sign.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }
    }
}
