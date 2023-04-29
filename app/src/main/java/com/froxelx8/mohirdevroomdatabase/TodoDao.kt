package com.froxelx8.mohirdevroomdatabase

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE


@Dao
interface TodoDao {

    @Insert(onConflict = REPLACE)
    fun insert(todo: Todo)

    @Insert
    fun insertAll(todoList:List<Todo>)

    @Delete
    fun delete(todo: Todo)

    @Update
    fun update(todo: Todo)

    @Query("select * from todo limit 10")
    fun getAllTodo():List<Todo>

    @Query("select * from todo where id =:id")
    fun onGetTodoById(id:Int):Todo

}