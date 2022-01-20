package com.seip.android.todoappb1.daos;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.seip.android.todoappb1.enities.TodoModel;

import java.util.List;

@Dao
public interface TodoDao {
    @Insert
    void createTodo(TodoModel todoModel);

    @Update
    void updateTodo(TodoModel todoModel);

    @Delete
    void deleteTodo(TodoModel todoModel);

    @Query("select * from tbl_todo order by id desc")
    LiveData<List<TodoModel>> getAllTodos();

    @Query("select * from tbl_todo where complated = :status order by id desc")
    LiveData<List<TodoModel>>getAllComplatedTodos(boolean status);
}
