package com.stevity.wifitalk.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import com.stevity.wifitalk.daos.PeerDAO
import com.stevity.wifitalk.models.Peer

class PeerRepository private constructor(application: Application) : CrudRepository<Peer> {
    private val peerDAO: PeerDAO = RoomDB.getDatabase(application).getPeerDao() // get singleton database object

    override fun findAll(): LiveData<List<Peer>> {
        return peerDAO.getAllPeers()
    }

    override fun findById(id: Long): Peer {
        return peerDAO.getPeerById(id)
    }

    override fun save(peer: Peer) {
        peerDAO.createPeer(peer)
    }

    override fun update(peer: Peer) {
        peerDAO.updatePeer(peer)
    }

    override fun delete(peer: Peer) {
        peerDAO.deletePeer(peer)
    }


    // Singleton Pattern for Repository.
    companion object {
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