package com.example.enpit_p31.hap

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_list_edit.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.yesButton
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class ListEditActivity : AppCompatActivity() {
    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_edit)
        realm = Realm.getDefaultInstance()

        save.setOnClickListener{
            realm.executeTransaction {
                val maxId = realm.where<List>().max("id")
                val nextId = (maxId?.toLong() ?:  0L) + 1
                val list = realm.createObject<List>(nextId)
                dateEdit.text.toString().toDate("yyyy/MM/dd")?.let {
                    list.date = it
                }
                list.title = titleEdit.text.toString()
                list.detail = detailEdit.text.toString()
            }
            alert("送信しました"){
                yesButton { finish() }
            }.show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    fun String.toDate(pattern: String = "yyyy/MM/dd HH:mm"): Date? {
        val sdFormat = try {
            SimpleDateFormat(pattern)
        } catch (e: IllegalAccessException) {
            null
        }
        val date = sdFormat?.let {
            try {
                it.parse(this)
            }catch (e: ParseException){
                null
            }
        }
        return  date
    }
}
