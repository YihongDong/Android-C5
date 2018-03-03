package com.chapters.z.dialogsimple;

import android.app.Dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/1/1.
 */

public class SingleChoiceDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
       final String[] colors;
        // Use the Builder class for convenient dialog construction
        colors=getResources().getStringArray(R.array.array_colors);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Color List")
                .setSingleChoiceItems(R.array.array_colors, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(),colors[which],Toast.LENGTH_SHORT).show();
                    }
                }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK, so save the mSelectedItems results somewhere
                        // or return them to the component that opened the dialog
                        dismiss();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        getDialog().cancel();
                    }
                });
        AlertDialog dialog=builder.create();
        //设置对话框显示的位置
        Window window = dialog.getWindow();
        window.setGravity(Gravity.TOP);
        return dialog;
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
