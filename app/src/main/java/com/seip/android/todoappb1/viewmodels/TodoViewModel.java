package com.seip.android.todoappb1.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.seip.android.todoappb1.enities.TodoModel;
import com.seip.android.todoappb1.repos.TodoRepository;

import java.util.List;

public class TodoViewModel extends AndroidViewModel {

    private TodoRepository repository;

    public TodoViewModel(@NonNull Application application) {
        super(application);
        repository = new TodoRepository(application);
    }

    public void createTodo(TodoModel todoModel){
        repository.createTodo(todoModel);
    }

    public void updateTodo(TodoModel todoModel){
        repository.updateTodo(todoModel);
    }

    public void deleteTodo(TodoModel todoModel){
        repository.deleteTodo(todoModel);
    }

    public LiveData<List<TodoModel>> getAlltodos(){
        return repository.getAlltodos();
    }

    public LiveData<List<TodoModel>> getAllDonetodos(){
        return repository.getAllDonetodos();
    }


}
