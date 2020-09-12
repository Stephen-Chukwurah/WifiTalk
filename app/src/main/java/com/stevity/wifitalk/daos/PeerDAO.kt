package com.stevity.wifitalk.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.stevity.wifitalk.models.Peer

@Dao
interface PeerDAO {

    @Insert
    fun seedPeer(data: List<Peer>)

    @Query("SELECT * FROM peers")
    fun getAllPeers(): LiveData<List<Peer>>

    @Query("SELECT * FROM peers WHERE id = :peerId")
    fun getPeerById(peerId: Long): Peer

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createPeer(peer: Peer)

    @Update
    fun updatePeer(peer: Peer)

    @Delete
    fun deletePeer(peer: Peer)
}