package com.seip.android.todoappb1.db;

import android.content.Context;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.seip.android.todoappb1.daos.TodoDao;
import com.seip.android.todoappb1.enities.TodoModel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {TodoModel.class}, version = 1)
public abstract class TodoDb extends RoomDatabase {

    public abstract TodoDao getTodoDao();
    private static TodoDb db;

    public static final ExecutorService service = Executors.newFixedThreadPool(4);

    public static TodoDb getInstance(Context context){
        if (db == null){
            db = Room.databaseBuilder(context, TodoDb.class, "todo_db").build();
            return db;
        }
        return db;
    }




}
