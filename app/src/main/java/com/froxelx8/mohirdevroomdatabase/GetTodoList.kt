package com.froxelx8.mohirdevroomdatabase

import android.os.AsyncTask


class GetTodoList(val todoDao: TodoDao,val getAllTodoCallback: GetAllTodoCallback) : AsyncTask<Unit, Unit, List<Todo>>(){
    override fun doInBackground(vararg params: Unit?): List<Todo> {

        return todoDao.getAllTodo()
    }
    override fun onPostExecute(result: List<Todo>?) {
        super.onPostExecute(result)
        getAllTodoCallback.onGetList(result!!)
    }
}