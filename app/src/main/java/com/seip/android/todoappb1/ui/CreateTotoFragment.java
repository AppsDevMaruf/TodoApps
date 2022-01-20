package com.seip.android.todoappb1.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.seip.android.todoappb1.databinding.FragmentCreateTotoBinding;
import com.seip.android.todoappb1.enities.TodoModel;
import com.seip.android.todoappb1.pickers.DatePikerDialogFragment;
import com.seip.android.todoappb1.pickers.TimePikerDialogFragment;
import com.seip.android.todoappb1.utils.TodoConstants;
import com.seip.android.todoappb1.viewmodels.TodoViewModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CreateTotoFragment extends Fragment {

    FragmentCreateTotoBinding binding;

    private String dateString, timeString;
    private int year, month, day, hour, minute;
    private String priority = TodoConstants.NORMAL;
    private TodoViewModel todoViewModel;

    public CreateTotoFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateTotoBinding.inflate(inflater, container, false);
        todoViewModel = new ViewModelProvider(requireActivity()).get(TodoViewModel.class);

        initDateTime();

        binding.dateBV.setOnClickListener(v -> {
            new DatePikerDialogFragment().show(getChildFragmentManager(), null);
        });

        binding.timeBV.setOnClickListener(v -> {
            new TimePikerDialogFragment().show(getChildFragmentManager(), null);
        });

        binding.radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            final RadioButton rb = group.findViewById(checkedId);
            priority = rb.getText().toString();
        });

        binding.saveBV.setOnClickListener(v -> {

            final String name = binding.name.getText().toString();

            TodoModel todoModel = new TodoModel(name, priority, dateString, timeString, false);
            todoViewModel.createTodo(todoModel);
            binding.name.setText("");
        });

        getChildFragmentManager().setFragmentResultListener(TodoConstants.REQUEST_KEY, this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                if (result.containsKey(TodoConstants.DATE_KEY)){
                    dateString = result.getString(TodoConstants.DATE_KEY);
                    year = result.getInt(TodoConstants.YEAR);
                    month = result.getInt(TodoConstants.MONTH);
                    day = result.getInt(TodoConstants.DAY);
                    binding.dateBV.setText(dateString);
                }else if(result.containsKey(TodoConstants.TIME_KEY)){
                    timeString = result.getString(TodoConstants.TIME_KEY);
                    hour = result.getInt(TodoConstants.HOUR);
                    minute = result.getInt(TodoConstants.MINUTE);
                    binding.timeBV.setText(timeString);
                }
            }
        });

//        todoViewModel.createTodo();

        return binding.getRoot();
    }


    @SuppressLint("SimpleDateFormat")
    private void initDateTime(){
        final Calendar calendar = Calendar.getInstance(Locale.getDefault());

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);
        dateString = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        timeString = new SimpleDateFormat("hh:mm a").format(new Date());
    }

}