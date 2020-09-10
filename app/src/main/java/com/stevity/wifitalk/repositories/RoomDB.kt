package com.stevity.wifitalk.repositories

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.stevity.wifitalk.daos.PeerDAO
import com.stevity.wifitalk.models.Peer

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
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE IF NOT EXISTS peers (" +
                        "id INTEGER PRIMARY KEY" +
                        "fullName TEXT NOT NULL," +
                        "lastMessage TEXT DEFAULT null," +
                        "avatar TEXT DEFAULT null," +
                        "unreadMsgCount INTEGER DEFAULT null," +
                        "lastSeen TEXT DEFAULT null" +
                        ");"
                )
            }
        }

        val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("INSERT INTO peers(id, fullName, lastMessage, avatar, unreadMsgCount, lastSeen) " +
                        "VALUES " +
                        "(1, 'Sean Puffy Combs', 'Hello world', 'https://i.etsystatic.com/18117412/r/il/0aa8e1/1959860411/il_570xN.1959860411_4c0o.jpg', '30', '2020-03-02'), " +
                        "(2, 'Marshal Bruce Mathers', 'Hello world', 'https://i.etsystatic.com/18117412/r/il/0aa8e1/1959860411/il_570xN.1959860411_4c0o.jpg', '30', '2020-03-02'), " +
                        "(3, 'Chris Maurice Brown', 'Hello world', 'https://i.etsystatic.com/18117412/r/il/0aa8e1/1959860411/il_570xN.1959860411_4c0o.jpg', '30', '2020-03-02'), " +
                        "(4, 'Kevin Mcall', 'Hello world', 'https://i.etsystatic.com/18117412/r/il/0aa8e1/1959860411/il_570xN.1959860411_4c0o.jpg', '30', '2020-03-02'), " +
                        "(5, 'Will Smith', 'Hello world', 'https://i.etsystatic.com/18117412/r/il/0aa8e1/1959860411/il_570xN.1959860411_4c0o.jpg', '30', '2020-03-02'), " +
                        "(6, 'Bryson Tiller', 'Hello world', 'https://i.etsystatic.com/18117412/r/il/0aa8e1/1959860411/il_570xN.1959860411_4c0o.jpg', '30', '2020-03-02'), " +
                        "(7, 'Mariah Carey', 'Hello world', 'https://i.etsystatic.com/18117412/r/il/0aa8e1/1959860411/il_570xN.1959860411_4c0o.jpg', '30', '2020-03-02'), " +
                        "(8, 'Drake Aubrey Graham', 'Hello world', 'https://i.etsystatic.com/18117412/r/il/0aa8e1/1959860411/il_570xN.1959860411_4c0o.jpg', '30', '2020-03-02'), " +
                        "(9, 'Andre Young', 'Hello world', 'https://i.etsystatic.com/18117412/r/il/0aa8e1/1959860411/il_570xN.1959860411_4c0o.jpg', '30', '2020-03-02'), " +
                        "(10, 'Robin Fente', 'Hello world', 'https://i.etsystatic.com/18117412/r/il/0aa8e1/1959860411/il_570xN.1959860411_4c0o.jpg', '30', '2020-03-02');"
                )
            }
        }

        fun getDatabase(context: Context) = INSTANCE ?: kotlin.run {
            Room.databaseBuilder(
                context.applicationContext,
                RoomDB::class.java,
                "wifitalkdb"
            )
//                .createFromAsset("database/app.db")
                .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}