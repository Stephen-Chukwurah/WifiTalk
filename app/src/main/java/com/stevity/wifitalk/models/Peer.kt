package com.stevity.wifitalk.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "peers")
data class Peer(
    @Expose
    @PrimaryKey
    val id: Int,
    /**
     * 06 @SerializedName is used to tell the GSON library that
     * the variable name from the JSON, does not match what you have
     * named Kotlin variable.  In this case, the JSON field
     * employee_name is mapped to the Kotlin variable employeeName.
     *
     * Notice we did not need this line for the id variable.  This is
     * because the variable 'id' in the Kotlin matches the JSON name exactly.
     */
    @SerializedName("full_name")
    @Expose
    val fullName: String,

    @SerializedName("last_message")
    @Expose
    val lastMessage: String,

    @SerializedName("avatar")
    @Expose
    val avatar: String,

    @SerializedName("unread_msg_count")
    @Expose
    val unreadMsgCount: String,

    @SerializedName("last_seen")
    @Expose
    val lastSeen: String


)