package com.example.enpit_p31.hap

import android.app.Application
import io.realm.Realm


class Mail:Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }

}

