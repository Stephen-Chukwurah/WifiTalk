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
    fun getPeerList(): LiveData<List<Peer>> {
        return peerRepository.findAll()
    }

    fun createPeer(peer: Peer) {
        peerRepository.save(peer)
    }
}