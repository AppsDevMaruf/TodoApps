package com.seip.android.todoappb1.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seip.android.todoappb1.R;
import com.seip.android.todoappb1.adapters.TodoAdapters;
import com.seip.android.todoappb1.databinding.FragmentHomeBinding;
import com.seip.android.todoappb1.enities.TodoModel;
import com.seip.android.todoappb1.viewmodels.TodoViewModel;

import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private TodoViewModel viewModel;

    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(TodoViewModel.class);


        TodoAdapters adapter = new TodoAdapters(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        binding.todoList.setAdapter(adapter);
        binding.todoList.setLayoutManager(layoutManager);

        viewModel.getAlltodos().observe(getViewLifecycleOwner(), new Observer<List<TodoModel>>() {
            @Override
            public void onChanged(List<TodoModel> todoModels) {
                adapter.setTodoModelList(todoModels);
            }
        });

        return binding.getRoot();
    }
}