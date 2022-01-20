package com.seip.android.todoappb1.adapters;

import android.annotation.SuppressLint;
import android.graphics.drawable.DrawableContainer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.seip.android.todoappb1.databinding.SingleTodoBinding;
import com.seip.android.todoappb1.enities.TodoModel;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class TodoAdapters extends RecyclerView.Adapter<TodoAdapters.TodoViewHolder> {

    private List<TodoModel> todoModelList;

    public TodoAdapters(Fragment fragment){
        todoModelList = new ArrayList<>();
    }


    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       final SingleTodoBinding binding = SingleTodoBinding.inflate(LayoutInflater.from(parent.getContext()),  parent,false);

       return new TodoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        TodoModel todo = todoModelList.get(position);
        holder.bidn(todo);
    }

    @Override
    public int getItemCount() {
        return todoModelList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setTodoModelList(List<TodoModel> todoModelList) {
        this.todoModelList = todoModelList;
        notifyDataSetChanged();
    }

    public class TodoViewHolder extends RecyclerView.ViewHolder{

        private SingleTodoBinding binding;
        public TodoViewHolder(@NonNull SingleTodoBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bidn(TodoModel todo) {
            binding.setTodo(todo);
        }
    }
}
