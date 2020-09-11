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

//
//
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

            model.createPeer(Peer(1, "Sean Puffy Combs", "I need a girl to ride ride ride, i need a girl to be my wife", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/13/Sean_Combs_2010.jpg/220px-Sean_Combs_2010.jpg", "30", "9:50pm"))
            model.createPeer(Peer(2, "Marshal Bruce Mathers", "I am sorry mama i never meant to kurt you i never meant to make you cry but", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4a/Eminem_-_Concert_for_Valor_in_Washington%2C_D.C._Nov._11%2C_2014_%282%29_%28Cropped%29.jpg/220px-Eminem_-_Concert_for_Valor_in_Washington%2C_D.C._Nov._11%2C_2014_%282%29_%28Cropped%29.jpg", "30", "2:00am"))
            model.createPeer(Peer(3, "Chris Maurice Brown", "Is your man on the floor and if he aint then let me know", "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6a/Chris_Brown_5%2C_2012.jpg/230px-Chris_Brown_5%2C_2012.jpg", "30", "9:50pm"))
            model.createPeer(Peer(4, "Kevin Mcall", "Lets retrace our steps and figure out where we are", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3a/Kmacc.jpg/220px-Kmacc.jpg", "30", "6:30am"))
            model.createPeer(Peer(5, "Will Smith", "Turn around and switch or turn it over and hitch oh oh oh oh", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3f/TechCrunch_Disrupt_2019_%2848834434641%29_%28cropped%29.jpg/220px-TechCrunch_Disrupt_2019_%2848834434641%29_%28cropped%29.jpg", "30", "9:50pm"))
            model.createPeer(Peer(6, "Bryson Tiller", "Dont play with the thumb beat in sience tonight we gettin the logix", "https://upload.wikimedia.org/wikipedia/commons/thumb/7/70/Bryson_Tiller_August_2018.jpg/220px-Bryson_Tiller_August_2018.jpg", "30", "9:50pm"))
            model.createPeer(Peer(7, "Mariah Carey", "Oh baby i ll just melt away on my way and every time i see your face", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Mariah_Carey_WBLS_2018_Interview_2.jpg/220px-Mariah_Carey_WBLS_2018_Interview_2.jpg", "30", "7:380pm"))
            model.createPeer(Peer(8, "Drake Aubrey Graham", "Muthafuckers never loved us thats why we on our worse behaviour", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Drake_at_The_Carter_Effect_2017_%2836818935200%29_%28cropped%29.jpg/220px-Drake_at_The_Carter_Effect_2017_%2836818935200%29_%28cropped%29.jpg", "30", "9:50pm"))
            model.createPeer(Peer(9, "Andre Young", "Nowadays everybody wanna talk like they gat suntin to say bt nun", "https://upload.wikimedia.org/wikipedia/commons/thumb/d/de/Dr._Dre_in_2011.jpg/220px-Dr._Dre_in_2011.jpg", "30", "5:50pm"))
            model.createPeer(Peer(10, "Robin Fente", "When the sun shine we shine togther told you i ll be here forever", "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c2/Rihanna_Fenty_2018.png/220px-Rihanna_Fenty_2018.png", "30", "9:50pm"))
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