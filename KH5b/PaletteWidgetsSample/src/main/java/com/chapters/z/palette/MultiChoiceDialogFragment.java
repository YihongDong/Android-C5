package com.chapters.z.palette;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2018/1/1.
 */

public class MultiChoiceDialogFragment extends DialogFragment {
    ArrayList colors;
    public interface NoticeDialogListener {
        public void onDialogPositiveClick1(DialogFragment dialog);
    }
    // Use this instance of the interface to deliver action events
    MultiChoiceDialogFragment.NoticeDialogListener mListener;
    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener


    public MultiChoiceDialogFragment.NoticeDialogListener getListener(){
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (MultiChoiceDialogFragment.NoticeDialogListener) getActivity();
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(getActivity().toString()
                    + " must implement NoticeDialogListener");
        }
        return mListener;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        colors=new ArrayList();
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Like List")
                .setMultiChoiceItems(R.array.array_like, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which,
                                                boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    colors.add(which);
                                } else if (colors.contains(which)) {
                                    // Else, if the item is already in the array, remove it
                                    colors.remove(Integer.valueOf(which));
                                }
                            }
                        })
                // Set the action buttons
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        mListener=getListener();
                        mListener.onDialogPositiveClick1(MultiChoiceDialogFragment.this);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        return builder.create();
    }


    public String  getLoginString(){
        String Like="";
        String[] like=getResources().getStringArray(R.array.array_like);
        for(int i=0;i<colors.size();i++)
            Like+=like[(int) colors.get(i)];
        return Like;
    }
}