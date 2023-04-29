package com.froxelx8.mohirdevroomdatabase

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec

@Database(entities = [Todo::class], version = 1, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {


    abstract fun todoDao(): TodoDao



    companion object {
        private var INSTANCE: TodoDatabase? = null
        fun getInstance(context: Context): TodoDatabase {
            return INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,
                TodoDatabase::class.java,
                "myRoomDatabase"
            ).build()
        }

    }
}