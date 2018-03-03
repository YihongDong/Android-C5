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
public class BottomFragment extends Fragment {
    OnBottomSelectedListener mCallback;
    Button mBt;

    // The container Activity must implement this interface so the frag can deliver messages
    public interface OnBottomSelectedListener {
        /** Called by HeadlinesFragment when a list item is selected */
        public void onBottomSelected(String str);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_bottom, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        try {
        mCallback = (OnBottomSelectedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement OnBottomSelectedListener");
        }
         mBt= (Button) getActivity().findViewById(R.id.bt);
       // mBt=(Button) getView().findViewById(R.id.bt);
        mBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              mCallback.onBottomSelected("pass me");
            }
        });

    }


}
