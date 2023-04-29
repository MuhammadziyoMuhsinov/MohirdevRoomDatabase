package com.froxelx8.mohirdevroomdatabase

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.froxelx8.mohirdevroomdatabase.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var database: TodoDatabase

    private lateinit var binding: ActivityMainBinding
    private  val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = TodoDatabase.getInstance(this)
        val insertTodo = Todo(null,"asyncTodo","","","new")
        database.todoDao().insert(insertTodo)



        AddTodoAsync(database.todoDao(),object : AddTodoCallback{
            override fun onControlProgressBarr() {
                binding.progressbar.visibility = View.VISIBLE
            }

            override fun onFinish() {
                binding.progressbar.visibility = View.GONE
                GetTodoList(database.todoDao(),object : GetAllTodoCallback{
                    override fun onGetList(list: List<Todo?>) {
                        Log.d(TAG, "onGetList: ${list.joinToString()}")
                    }
                }).execute()
            }
        }).execute(insertTodo)

    }



}