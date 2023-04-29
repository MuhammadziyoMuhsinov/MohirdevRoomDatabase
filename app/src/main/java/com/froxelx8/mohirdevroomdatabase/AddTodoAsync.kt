package com.froxelx8.mohirdevroomdatabase

import android.os.AsyncTask

class AddTodoAsync(val todoDao: TodoDao, val callback: AddTodoCallback) :
    AsyncTask<Todo, Unit, Unit>() {

    override fun onPreExecute() {
        super.onPreExecute()
        callback.onControlProgressBarr()
    }

    override fun doInBackground(vararg todo: Todo?) {
        Thread.sleep(2000)
        todo[0]?.apply {
            todoDao.insert(this)
        }

    }

    override fun onPostExecute(result: Unit?) {
        super.onPostExecute(result)
        callback.onFinish()
    }

}