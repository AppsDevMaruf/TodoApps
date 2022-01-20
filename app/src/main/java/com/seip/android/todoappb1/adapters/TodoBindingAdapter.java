package com.seip.android.todoappb1.adapters;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.seip.android.todoappb1.R;
import com.seip.android.todoappb1.utils.TodoConstants;

public class TodoBindingAdapter {
    @BindingAdapter(value = "app:setPriorityIcon")
    public static void setPriorityIcon(ImageView imageView, String priority){
        int icon;
        switch (priority){
            case TodoConstants.LOW:
                icon = R.drawable.ic_low;
                break;

            case TodoConstants.NORMAL:
                icon = R.drawable.ic_normal;
                break;

            default:
                icon = R.drawable.ic_high;
                break;
        }
        imageView.setImageResource(icon);
    }
}
