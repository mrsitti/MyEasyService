package com.oneinthai.mrsitti.myeasyservice;

import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.oneinthai.mrsitti.myeasyservice.fragment.MainFragment;
import com.oneinthai.mrsitti.myeasyservice.fragment.SecondFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;




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

        //Crate Toolbar
        crateToolbar();

    } //Main Method

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState,
                             @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        actionBarDrawerToggle.syncState();
    }

    private void crateToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);

        actionBarDrawerToggle = new ActionBarDrawerToggle(
                MainActivity.this,
                drawerLayout,
                R.string.open,
                R.string.close

        );
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentFragmentMain, new MainFragment())
                        .commit();

                //Close Drawer ปิดเมนู
                drawerLayout.closeDrawers();


            }
        });

//        For SecondFragment
        secondTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.btnGoToSecound, new SecondFragment())
                        .commit();
                drawerLayout.closeDrawers();
            }
        });

//        for Exit

        exitTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
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
