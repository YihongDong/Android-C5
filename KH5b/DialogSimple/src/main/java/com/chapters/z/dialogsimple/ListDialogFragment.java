package com.chapters.z.dialogsimple;

import android.app.Dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/1/1.
 */

public class ListDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        final String[] colors=getResources().getStringArray(R.array.array_colors);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Color List")
                .setItems(R.array.array_colors, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position
                        // of the selected item
                        Toast.makeText(getActivity(),colors[which],Toast.LENGTH_SHORT).show();
                    }
                });

        // Create the AlertDialog object and return it
        return builder.create();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        Log.i("listdialog","dismiss----------------------->");
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Log.i("listdialog","cancel----------------------->");
    }
}
