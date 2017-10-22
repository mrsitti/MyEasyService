package com.oneinthai.mrsitti.myeasyservice;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.oneinthai.mrsitti.myeasyservice.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // การ add fragment คือการใส่เหตุการณ์ให้กับตำแหน่ง
        // สร้างเมดธอด เลือก แล้ว Ctrl+Alt+m ดูรายละเอียด วางที่บรรทัด  Alt+ 7
        addFragment(savedInstanceState);

        // การตั้งค่า Drawer Menu ต้องเป็น ard v 4
        // DrawerLayou กด Shift Ctrl Space ...
        //Ctrl+Shif+Enter ปิดบรรทัด (หลัง myDrawerLayout)
        //Alt+Enter เรียกเมนู เลือก casto
        setupDrawerMenu();


        //ตั้งค่าให้กับปุ่ม Button Controller
        //Text Controller
        textController();


    }

    private void textController() {
        TextView mainTextView = (TextView) findViewById(R.id.txtMainFragment);
        TextView secondTextView = (TextView) findViewById(R.id.txtHero);
        TextView exitTextView = (TextView) findViewById(R.id.txtExit);

        //For MainFragment
        // new เคาะวรรค กด Ctrl Space เลือก View..... Enter
        mainTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Close Drawer ปิดเมนู
                drawerLayout.closeDrawers();


            }
        });

//        For SecondFragment
        secondTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });

//        for Exit

        exitTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawers();
            }
        });


    }

    private void setupDrawerMenu() {
        drawerLayout = (DrawerLayout) findViewById(R.id.myDrawerLayou);
    }

    private void addFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentFragmentMain, new MainFragment()).commit();
        }
    }
}
