package com.chapters.z.dialogsimple;


import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/1/2.
 */

public class MyDialogFragment extends DialogFragment {
 /* The activity that creates an instance of this dialog fragment must
     * implement this interface in order to receive event callbacks.
     * Each method passes the DialogFragment in case the host needs to query it. */
   EditText editTextName,editTextPassword;

    public interface NoticeDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.fragment_my_dialog,null);
        editTextName=(EditText) view.findViewById(R.id.username);
        editTextPassword=(EditText) view.findViewById(R.id.password);

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view)
                // Add action buttons
                .setPositiveButton("登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user .
                        mListener=getListener();
                        mListener.onDialogPositiveClick(MyDialogFragment.this);
                        dismiss();


                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mListener=getListener();
                        mListener.onDialogNegativeClick(MyDialogFragment.this);
                        getDialog().cancel();
                    }
                });
        return builder.create();
    }

    public String  getLoginString(){
        return "name:"+editTextName.getText()+"；password:"+editTextPassword.getText();
    }

}
