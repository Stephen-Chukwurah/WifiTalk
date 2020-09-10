package com.stevity.wifitalk.daos

import androidx.lifecycle.LiveData
import androidx.room.*
import com.stevity.wifitalk.models.Peer

@Dao
interface PeerDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPeer(peer: Peer)

    @Delete
    fun deletePeer(peer: Peer)

    @Query("SELECT * FROM peers")
    fun getAllPeersLiveData(): LiveData<List<Peer>>

    @Query("SELECT * FROM peers WHERE id = :peerId")
    fun getPeerByIdLiveData(peerId: Int): LiveData<Peer?>
}