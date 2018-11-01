package com.example.enpit_p31.hap

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_nyuuryoku2.*

class nyuuryoku2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nyuuryoku2)

        asa.setOnClickListener { onGohanButtonTapped(it) }

        backbutton.setOnClickListener { finish() }
    }

    fun onGohanButtonTapped(view: View){
        val intent = Intent(this, gohan::class.java)
        startActivity(intent)
    }
}
