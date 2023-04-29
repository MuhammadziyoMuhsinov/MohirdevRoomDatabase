package com.froxelx8.mohirdevroomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class Todo(
    @PrimaryKey(autoGenerate = true) val id: Int?=null,
    @ColumnInfo(name = "name") val title: String,
    var description:String?,
    var createdAt:String,
    var status:String,
)
