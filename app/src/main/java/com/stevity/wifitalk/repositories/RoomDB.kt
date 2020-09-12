package com.stevity.wifitalk.repositories

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.stevity.wifitalk.daos.PeerDAO
import com.stevity.wifitalk.migrations.seeders.PeersSeeders
import com.stevity.wifitalk.models.Peer
import java.util.concurrent.Executors

/**
 * Room Database class. Refer to README for more information
 */
@Database(entities = [Peer::class], version = 1, exportSchema = false)
abstract class RoomDB : RoomDatabase() {

    abstract fun getPeerDao(): PeerDAO

    /**
     *  Creates a way to ensure that the database accessed in different locations is the same
     *  instance. Also known as a Singleton pattern.
     */

    companion object {
        private var INSTANCE: RoomDB? = null
        private val IO_EXECUTOR = Executors.newSingleThreadExecutor()

        fun getInstance(context: Context): RoomDB =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: getDatabase(context).also { INSTANCE = it }
            }

        fun ioThread(f : () -> Unit) {
            IO_EXECUTOR.execute(f)
        }

        fun getDatabase(context: Context) = INSTANCE ?: kotlin.run {
            Room.databaseBuilder(
                context.applicationContext,
                RoomDB::class.java,
                "wifitalkdb"
            )
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        // insert the data on the IO Thread
                        ioThread {
                            getInstance(context).getPeerDao().seedPeer(PeersSeeders.PREPOPULATE_DATA)
                        }
                    }
                })
//                .createFromAsset("database/app.db")
//                .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}