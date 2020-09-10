package com.stevity.wifitalk

import android.app.Application
import androidx.room.Database
import com.stevity.wifitalk.daos.PeerDAO
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class WifiTalkApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {


    }
}