package com.manuni.fragaddremovewithoutconfigchangeproblem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addFragment(View view) {
        MyFirstFragment firstFragment = new MyFirstFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container,firstFragment).commit();
    }

    public void removeFragment(View view) {
        //this will survive with application configuration changes
       MyFirstFragment fragment = (MyFirstFragment) getSupportFragmentManager().findFragmentById(R.id.container);
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
    }
}