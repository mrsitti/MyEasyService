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
 * Created by Sitti on 21/10/2560.
 * สิ่งที่อยู่ในคลาสเรียนเมธตอด
 * ในเมธตอดมีเสตตเม้น จบด้วย ;
 */

public class MainFragment extends Fragment{
// การสร้างเมดธอดหลัก


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

      //Button Controller
        // ได้จากการระบายดำ Button Ctrl+Alt+m
        buttonController();


    } //Main Method

    private void buttonController() {

        //Initial View
        Button button = getView().findViewById(R.id.btnGoToSecound);

        //Get Event From Click
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //เมือคลิกทำการย้าย SecondFragment หรือ เปลี่ยนหน้า(กาก)
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentFragmentMain, new SecondFragment())
                        .addToBackStack(null).commit();


            } //นี่คือส่วนของ onclick  //.addToBackStack(null).commit(); หากเหลือแค่ .commit(); กดปุ่ม Back ที่หน้าที่สอง จะเป็นการเปิด App
        });


    }

    //    การสร้างหน้ากาก
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_main,container,false);
        return view;
    }
}   //Main Class
