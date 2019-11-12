package com.example.lenovo.criminalintent;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.widget.Toast;

public class CrimeListActivity extends FragmentActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_list);
        Toast.makeText(CrimeListActivity.this,"Hello",Toast.LENGTH_SHORT).show();
        FragmentManager fm=getSupportFragmentManager();
        Fragment fragment=fm.findFragmentById(R.id.fragment_list_container);
        if(fragment==null){
            fragment=new CrimeListFragment();
            fm.beginTransaction().add(R.id.fragment_list_container,fragment).commit();
        }
//        Toast.makeText(CrimeListActivity.this,"Hi",Toast.LENGTH_SHORT).show();

    }
}
