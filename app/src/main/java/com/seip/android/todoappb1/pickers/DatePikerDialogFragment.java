package com.seip.android.todoappb1.pickers;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.seip.android.todoappb1.utils.TodoConstants;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class DatePikerDialogFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

//     private final OnDatePickListner listener;
//
//     public DatePikerDialogFragment(OnDatePickListner listener){
//         this.listener = listener;
//     }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance(Locale.getDefault());

        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month,day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);

        @SuppressLint("SimpleDateFormat") final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        final String selectedDate = sdf.format(calendar.getTime());

//        listener.onDatePicked(selectedDate);

        final Bundle b = new Bundle();

        b.putString(TodoConstants.DATE_KEY, selectedDate);
        b.putInt(TodoConstants.YEAR, year);
        b.putInt(TodoConstants.MONTH, month);
        b.putInt(TodoConstants.DAY, dayOfMonth);
        getParentFragmentManager().setFragmentResult(TodoConstants.REQUEST_KEY, b);


        Log.d("DATE_PIKER", selectedDate);
        Toast.makeText(getActivity(), selectedDate, Toast.LENGTH_SHORT).show();
    }


//    public interface OnDatePickListner{
//        void onDatePicked(String date);
//    }

}
