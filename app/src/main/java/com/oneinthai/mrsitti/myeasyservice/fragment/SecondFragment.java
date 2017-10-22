package com.oneinthai.mrsitti.myeasyservice.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.oneinthai.mrsitti.myeasyservice.R;

/**
 * Created by Sitti on 22/10/2560.
 */

public class SecondFragment extends Fragment{
    //กด Ctrl+o เลือก onActivityCreate กด Enter

    private ImageView imageView;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Back Controller กดย้อนกลับ ** กด Ctrl+Alt+m ถ้ามีหมายเหตุมากกว่า 1 วรรค จะต้องตั้งชื่อเอง
        backController();

        //Image Controller
        imageController();

    }   //Main Method


    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode,
                                 Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK) {

            //เลือกรูปแล้ว
            try {

                Uri uri=data.getData();
                Bitmap bitmap= BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(uri));
                imageView.setImageBitmap(bitmap);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            //ออกโดยไม่เลือกรูป
            Toast.makeText(getActivity(),"Not choose img.",Toast.LENGTH_SHORT).show();
        }
    }

    private void imageController() {
        imageView = getView().findViewById(R.id.imvHero);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent,
                        "Please. choose App"),3);
            }
        });


    }

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
