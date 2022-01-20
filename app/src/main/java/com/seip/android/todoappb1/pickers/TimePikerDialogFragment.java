package com.seip.android.todoappb1.pickers;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.seip.android.todoappb1.utils.TodoConstants;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TimePikerDialogFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

//    private final OnTimePicListener listener;
//
//    public TimePikerDialogFragment(OnTimePicListener listener) {
//        this.listener = listener;
//    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance(Locale.getDefault());

        final int hour = calendar.get(Calendar.HOUR);
        final int min = calendar.get(Calendar.MINUTE);
        return new TimePickerDialog(getActivity(), this, hour, min, false);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        final Calendar calendar = Calendar.getInstance();

        calendar.set(0,0,0,hourOfDay, minute);
        @SuppressLint("SimpleDateFormat") final SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
        final String selectedTime = sdf.format(calendar.getTime()) ;

        Bundle bundle = new Bundle();

        bundle.putString(TodoConstants.TIME_KEY, selectedTime);
        bundle.putInt(TodoConstants.HOUR, hourOfDay);
        bundle.putInt(TodoConstants.MINUTE, minute);

        getParentFragmentManager().setFragmentResult(TodoConstants.REQUEST_KEY, bundle);

//        listener.onTimePicked(selectedTime);
//        Log.d("TIME_PIKER", selectedTime);
//        Toast.makeText(getActivity(), selectedTime, Toast.LENGTH_SHORT).show();
    }


//    public interface OnTimePicListener{
//        void onTimePicked(String time);
//    }




}
