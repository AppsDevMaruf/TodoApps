package com.seip.android.todoappb1.repos;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.seip.android.todoappb1.daos.TodoDao;
import com.seip.android.todoappb1.db.TodoDb;
import com.seip.android.todoappb1.enities.TodoModel;

import java.util.List;

public class TodoRepository {
    private TodoDao todoDao;

    public TodoRepository(Context context){
        todoDao = (TodoDao) TodoDb.getInstance(context).getTodoDao();
    }

    public void createTodo(TodoModel todoModel){
        TodoDb.service.execute(() -> {
            todoDao.createTodo(todoModel);
        });
    }
    public void updateTodo(TodoModel todoModel){
        TodoDb.service.execute(() ->{
            todoDao.updateTodo(todoModel);
        });
    }
    public void deleteTodo(TodoModel todoModel){
        TodoDb.service.execute(() ->{
            todoDao.deleteTodo(todoModel);

        });
    }

    public LiveData<List<TodoModel>> getAlltodos(){
        return todoDao.getAllTodos();
    }
    public LiveData<List<TodoModel>> getAllDonetodos(){
        return todoDao.getAllComplatedTodos(true);
    }



}
