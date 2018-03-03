package com.example.me.fragmentpassvaluesample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/12/23.
 */
public class TopFragment extends Fragment {
TextView mTv;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
               return inflater.inflate(R.layout.fragment_top, container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        mTv= (TextView)getView().findViewById(R.id.tv);
        // mTv= (TextView) getActivity().findViewById(R.id.tv);
    }

    public void setTv(String str){

      mTv.setText(str);
    }
}
