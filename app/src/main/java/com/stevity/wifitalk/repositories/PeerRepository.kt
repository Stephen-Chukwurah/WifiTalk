package com.stevity.wifitalk.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import com.stevity.wifitalk.daos.PeerDAO
import com.stevity.wifitalk.models.Peer

class PeerRepository private constructor(application: Application) {
    private val peerDAO: PeerDAO = RoomDB.getDatabase(application).getPeerDao()
    fun insertPeer(peer: Peer) {
        peerDAO.insertPeer(peer)
    }

    fun deletePeer(peer: Peer) {
        peerDAO.deletePeer(peer)
    }

    fun getAllPeersLiveData(): LiveData<List<Peer>> {
        return peerDAO.getAllPeersLiveData();
    }

    // Singleton Pattern for Repository.
    companion object {
        /**
         *  This is where the EmployeeRepository all callers will receive. Set it to null at first
         *  and make it private so it can't be directly accessed.
         */
        private var INSTANCE: PeerRepository? = null

        /**
         * This method checks whether or not INSTANCE is null. If it's not null, it returns the
         * Singleton INSTANCE. If it is null, it creates a new Object, sets INSTANCE equal to that,
         * and returns INSTANCE. From here on out, this method will now return the same INSTANCE,
         * every time.
         */
        fun getInstance(application: Application): PeerRepository = INSTANCE ?: kotlin.run {
            INSTANCE = PeerRepository(application = application)
            INSTANCE!!
        }
    }
}