package com.chapters.z.dialogsimple;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyDialogFragment.NoticeDialogListener,
        TimeDialogFragment.NoticeDialogListener,DateDialogFragment.NoticeDialogListener{
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView) findViewById(R.id.tv);
    }

    public void btnnOnClick(View v){
        DialogFragment newFragment = new NormalAlertDialogFragment();
        newFragment.show(getSupportFragmentManager(), "normal");

    }

    public void btnlOnClick(View v){
        DialogFragment newFragment = new ListDialogFragment();
        newFragment.show(getSupportFragmentManager(), "list");
    }

    public void btnmOnClick(View v){
        DialogFragment newFragment = new MultiChoiceDialogFragment();
        newFragment.show(getSupportFragmentManager(), "multichoice");
    }

    public void btnsOnClick(View v){
        DialogFragment newFragment = new SingleChoiceDialogFragment();
        newFragment.show(getSupportFragmentManager(), "singlechoice");
    }

    public void btncOnClick(View v){
        DialogFragment newFragment = new MyDialogFragment();
        newFragment.show(getSupportFragmentManager(), "mydialog");
    }

    public void btnaOnClick(View v){
        Intent intent=new Intent(this,DialogStyleActivity.class);
        startActivity(intent);
    }

    public void btndOnClick(View v){
        DialogFragment newFragment = new DateDialogFragment();
        newFragment.show(getSupportFragmentManager(), "datedialog");
    }

    public void btntOnClick(View v){
        DialogFragment newFragment = new TimeDialogFragment();
        newFragment.show(getSupportFragmentManager(), "timedailog");
    }


    //MyDialogFragment.NoticeDialogListener override method
    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        MyDialogFragment mydialog= (MyDialogFragment)dialog;
        textView.setText(mydialog.getLoginString());
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }
//TimeDialogFragment.NoticeDialogListener override method

    @Override
    public void onDateDialogDateSet(DialogFragment dialog) {
        DateDialogFragment dialogFragment=(DateDialogFragment) dialog;
        textView.setText(dialogFragment.getDateString());
    }

    @Override
    public void onTimeDialogTimeSet(DialogFragment dialog) {
        TimeDialogFragment dialogFragment=(TimeDialogFragment) dialog;
        textView.setText(dialogFragment.getTimeString());
    }
}
