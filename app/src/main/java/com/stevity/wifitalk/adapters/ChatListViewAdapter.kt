package com.stevity.wifitalk.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.stevity.wifitalk.R
import com.stevity.wifitalk.models.Peer
import com.stevity.wifitalk.util.GeneralUtil
import kotlinx.android.synthetic.main.layout_chat_list.view.*

class ChatListViewAdapter(private val chatList: List<Peer>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemClickListener: OnItemClickListener


    interface OnItemClickListener {
        fun onItemClick(view: View, obj: Peer, position: Int)

        //void onDeleteClick(View view, Chat obj, int position);
    }

    fun setOnItemClickListener(mItemClickListener: OnItemClickListener) {
        this.itemClickListener = mItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_chat_list, parent, false)

        return PlaceViewHolder(itemView)
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        if (viewHolder is PlaceViewHolder) {

            val chat = chatList[position]

            viewHolder.Name.text = chat.fullName

            val context = viewHolder.holderCardView.context
            viewHolder.card.setCardBackgroundColor(ContextCompat.getColor(context, R.color.md_orange_A700))
            viewHolder.card.visibility = View.INVISIBLE

            val id = GeneralUtil.getDrawableInt(context, chat.avatar)
            GeneralUtil.setImageToImageView(context, viewHolder.itemImageView, id)
            GeneralUtil.setUrlCircleImageToImageView(context, viewHolder.itemImageView, chat.avatar, 0, 0)

            viewHolder.Time.text = chat.lastSeen
            val number = Integer.parseInt(chat.unreadMsgCount)

            viewHolder.Count.text = chat.unreadMsgCount
            if (number > 0) {
                viewHolder.Time.setTextColor(ContextCompat.getColor(context, R.color.md_orange_A700))
                viewHolder.Count.visibility = View.VISIBLE
                viewHolder.card.visibility = View.VISIBLE

                if (number > 9)
                    viewHolder.Count.text = "9+"
            }

            viewHolder.message.text = chat.lastMessage


            viewHolder.holderCardView.setOnClickListener { v: View -> itemClickListener.onItemClick(v, chat, position) }


        }
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    inner class PlaceViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view) {
        internal var itemImageView: ImageView
        internal var Name: TextView
        internal var message: TextView
        internal var holderCardView: ConstraintLayout
        internal var Time: TextView
        internal var Count: TextView
        internal var card: CardView

        init {

            itemImageView = view.userImageView
            Name = view.userNameTextView
            message = view.messageTextView
            holderCardView = view.holderCardView
            Time = view.timeTextView
            Count = view.messagecount
            card = view.card_view


        }
    }
}