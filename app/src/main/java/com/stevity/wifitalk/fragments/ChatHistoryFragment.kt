package com.stevity.wifitalk.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stevity.wifitalk.R
import com.stevity.wifitalk.adapters.ChatListViewAdapter
import com.stevity.wifitalk.models.Peer
import com.stevity.wifitalk.viewModels.ChatHistoryViewModel
import kotlinx.android.synthetic.main.fragment_chat_history.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChatHistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ChatHistoryFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    internal lateinit var adapter: ChatListViewAdapter
    internal lateinit var chatList: List<Peer>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        initData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat_history, container, false)
    }

    private fun initData() {
        val model: ChatHistoryViewModel by viewModels()
        model.getPeerList().observe(this, Observer<List<Peer>>{ peers ->
            println("This is the peers: " + peers)
            // update UI

            adapter = ChatListViewAdapter(peers)
            val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)
            photoRecyclerView.layoutManager = mLayoutManager
            photoRecyclerView.itemAnimator = DefaultItemAnimator()
            photoRecyclerView.adapter = adapter

            adapter.setOnItemClickListener(object : ChatListViewAdapter.OnItemClickListener {
                override fun onItemClick(view: View, obj: Peer, position: Int) {
                    Toast.makeText(context, "Clicked " + obj.fullName, Toast.LENGTH_SHORT).show()
                }
            })
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChatHistoryFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChatHistoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}