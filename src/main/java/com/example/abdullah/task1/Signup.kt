package com.example.abdullah.task1

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signup.*

@SuppressLint("Registered")
class Signup : AppCompatActivity() {


    var DB: Database? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        btn_signup.setOnClickListener {
           signup(mail.text.toString(),pass1.text.toString())
        }
        sign2.setOnClickListener {
            val intent = Intent(this, Signin::class.java)
            startActivity(intent)
        }
    }
    //signup function

    private fun signup(email:String,password:String){
      DB= Database(this)
        if (mail.text.toString()==""||pass2.text.toString()==""||pass1.text.toString()==""){
            mail.error="Must Enter Email"
            pass1.error="Must Enter Password"
            pass2.error="Must Enter Password Again"
        }
        else {

            if (pass1.text.toString()==pass2.text.toString()){
                val check=DB!!.checkemail(email)
           if (check==true){
               val insert=DB!!.insert(email,password)
                  if (insert==true){
                   Toast.makeText(this,"Register Successfully",Toast.LENGTH_SHORT).show()
               }
           }else{
               Toast.makeText(this,"Email Already Exists  ",Toast.LENGTH_SHORT).show()
           }
            }
            else{    Toast.makeText(this,"That is Error on Email or Password ",Toast.LENGTH_SHORT).show()}
        }
    }

}
