package com.oneinthai.mrsitti.myeasyservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.oneinthai.mrsitti.myeasyservice.R;

/**
 * Created by Sitti on 22/10/2560.
 */

public class SecondFragment extends Fragment{
    //กด Ctrl+o เลือก onActivityCreate กด Enter
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Back Controller กดย้อนกลับ ** กด Ctrl+Alt+m ถ้ามีหมายเหตุมากกว่า 1 วรรค จะต้องตั้งชื่อเอง
        backController();

    }   //Main Method

    private void backController() {
        Button button = getView().findViewById(R.id.btnBack);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        return view;
    }



} // Main Class
