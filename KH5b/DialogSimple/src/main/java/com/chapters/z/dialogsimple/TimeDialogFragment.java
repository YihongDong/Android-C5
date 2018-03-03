package com.chapters.z.dialogsimple;

import android.app.Dialog;

import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/1/2.
 */

public class TimeDialogFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{
    Calendar c ;
    int hour, minute;
    String timestring;

    public interface NoticeDialogListener {
        public void onTimeDialogTimeSet(DialogFragment dialog);
    }
    // Use this instance of the interface to deliver action events

    NoticeDialogListener mListener;
    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener


    public NoticeDialogListener getListener(){
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (NoticeDialogListener) getActivity();
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(getActivity().toString()
                    + " must implement NoticeDialogListener");
        }
        return mListener;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        mListener=getListener();
        timestring="选取时间为："+hourOfDay+"点"+minute+"分";
        mListener.onTimeDialogTimeSet(this);
    }

    public String getTimeString(){
        return timestring;
    }

}
