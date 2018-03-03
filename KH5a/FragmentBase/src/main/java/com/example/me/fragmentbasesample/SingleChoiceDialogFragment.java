package com.example.me.fragmentbasesample;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

/**
 * Created by Administrator on 2018/1/1.
 */

public class SingleChoiceDialogFragment extends DialogFragment {
    String editText;

    public interface NoticeDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
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
       final String[] colors;
        // Use the Builder class for convenient dialog construction
        colors=getResources().getStringArray(R.array.array_wlan);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("wlan List")
                .setSingleChoiceItems(R.array.array_wlan, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        editText=colors[which];
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        mListener=getListener();
                        mListener.onDialogPositiveClick(SingleChoiceDialogFragment.this);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        getDialog().cancel();
                    }
                });
        AlertDialog dialog=builder.create();

        return dialog;
    }

    public String  getLoginString(){
        return editText;
    }
    @Override
    public void dismiss() {
        super.dismiss();
        Log.i("singlechoicedialog","dismiss----------------------->");
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Log.i("singlechoicedialog","cancel----------------------->");
    }
}
