package com.oneinthai.mrsitti.myeasyservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oneinthai.mrsitti.myeasyservice.R;

/**
 * Created by Sitti on 21/10/2560.
 * สิ่งที่อยู่ในคลาสเรียนเมธตอด
 * ในเมธตอดมีเสตตเม้น จบด้วย ;
 */

public class MainFragment extends Fragment{
//    การสร้างหน้ากาก
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_main,container,false);
        return view;
    }
}   //Main Class
