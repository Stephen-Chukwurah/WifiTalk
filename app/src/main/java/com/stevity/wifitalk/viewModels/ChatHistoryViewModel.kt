package com.stevity.wifitalk.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.stevity.wifitalk.models.Peer
import com.stevity.wifitalk.repositories.PeerRepository

class ChatHistoryViewModel(application: Application) : AndroidViewModel(application) {
    // coordinates between the local and remote databases
    private val peerRepository = PeerRepository.getInstance(application)

    // This LiveData is created using a ktx library shortcut
    val employeeListLiveData: LiveData<List<Peer>> = peerRepository.getAllPeersLiveData()

    fun getPeerList(): LiveData<List<Peer>> {
        return peerRepository.getAllPeersLiveData()
    }

    fun createPeer(peer: Peer) {
        return peerRepository.insertPeer(peer)
    }
}