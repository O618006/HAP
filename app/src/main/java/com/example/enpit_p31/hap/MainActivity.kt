package com.example.enpit_p31.hap

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import io.realm.Realm
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        realm = Realm.getDefaultInstance()
        val Lists = realm.where<List>().findAll()
        listView.adapter = ListAdapter(Lists)
        fub.setOnClickListener{ onFabButtonTapped(it) }

        nyuuryoku.setOnClickListener { onNyuuryokuButtonTapped(it) }
    }

    fun onNyuuryokuButtonTapped(view: View){
        val intent = Intent(this, nyuuryoku2::class.java)
        startActivity(intent)
    }

    fun onFabButtonTapped(view: View){
        val intent = Intent(this, ListEditActivity::class.java)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }
}
