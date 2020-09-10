package com.stevity.wifitalk.fragments

import android.os.AsyncTask
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.stevity.wifitalk.R
import com.stevity.wifitalk.models.Peer
import com.stevity.wifitalk.viewModels.ChatHistoryViewModel


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PeerListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PeerListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }



        AsyncTask.execute {
            val model: ChatHistoryViewModel by viewModels()

//            var peer = Peer(
//                1,
//                "James Brown",
//                "Hello World",
//                "https://i.etsystatic.com/18117412/r/il/0aa8e1/1959860411/il_570xN.1959860411_4c0o.jpg",
//                "30",
//                "none"
//            )

            model.createPeer(Peer(1, "Sean Puffy Combs", "Hello world", "https://i.etsystatic.com/18117412/r/il/0aa8e1/1959860411/il_570xN.1959860411_4c0o.jpg", "30", "2020-03-02"))
            model.createPeer(Peer(2, "Marshal Bruce Mathers", "Hello world", "https://i.etsystatic.com/18117412/r/il/0aa8e1/1959860411/il_570xN.1959860411_4c0o.jpg", "30", "2020-03-02"))
            model.createPeer(Peer(3, "Chris Maurice Brown", "Hello world", "https://i.etsystatic.com/18117412/r/il/0aa8e1/1959860411/il_570xN.1959860411_4c0o.jpg", "30", "2020-03-02"))
            model.createPeer(Peer(4, "Kevin Mcall", "Hello world", "https://i.etsystatic.com/18117412/r/il/0aa8e1/1959860411/il_570xN.1959860411_4c0o.jpg", "30", "2020-03-02"))
            model.createPeer(Peer(5, "Will Smith", "Hello world", "https://i.etsystatic.com/18117412/r/il/0aa8e1/1959860411/il_570xN.1959860411_4c0o.jpg", "30", "2020-03-02"))
            model.createPeer(Peer(6, "Bryson Tiller", "Hello world", "https://i.etsystatic.com/18117412/r/il/0aa8e1/1959860411/il_570xN.1959860411_4c0o.jpg", "30", "2020-03-02"))
            model.createPeer(Peer(7, "Mariah Carey", "Hello world", "https://i.etsystatic.com/18117412/r/il/0aa8e1/1959860411/il_570xN.1959860411_4c0o.jpg", "30", "2020-03-02"))
            model.createPeer(Peer(8, "Drake Aubrey Graham", "Hello world", "https://i.etsystatic.com/18117412/r/il/0aa8e1/1959860411/il_570xN.1959860411_4c0o.jpg", "30", "2020-03-02"))
            model.createPeer(Peer(9, "Andre Young", "Hello world", "https://i.etsystatic.com/18117412/r/il/0aa8e1/1959860411/il_570xN.1959860411_4c0o.jpg", "30", "2020-03-02"))
            model.createPeer(Peer(10, "Robin Fente", "Hello world", "https://i.etsystatic.com/18117412/r/il/0aa8e1/1959860411/il_570xN.1959860411_4c0o.jpg", "30", "2020-03-02"))
//
            println("Just Inserted row: ")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_peer_list, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PeerListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PeerListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}