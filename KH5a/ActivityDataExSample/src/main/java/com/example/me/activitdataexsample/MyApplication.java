package com.example.me.activitdataexsample;

import android.app.Application;
import android.text.Editable;

/**
 * Created by Administrator on 2015/12/7.
 */
public class MyApplication extends Application {
     private String name;
    private int age;
    private  boolean pass;

    public String getName(){
        return  this.name;
    }
    public void setName(String name){
        this.name=name;
    }

    public int getAge(){
        return  this.age;
    }
    public void setAge(int age){
        this.age=age;
    }

    public boolean getPass(){
        return  this.pass;
    }
    public void setPass(boolean pass){
        this.pass=pass;
    }
}
