package com.example.lenovo.criminalintent;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;


public class CrimeFragment extends Fragment {
    private TextView mCount;
    private EditText mTitleCrime;
    private Crime mCrime;
    private Button date_btn,send_btn,create_btn,test;
    private CheckBox solved;
    private CrimeLab crimeLab;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrime=new Crime();
        crimeLab=CrimeLab.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_crime, container, false);
        mCount=view.findViewById(R.id.count_string);
        mTitleCrime=view.findViewById(R.id.crime_title);
        test=view.findViewById(R.id.test);
        date_btn=view.findViewById(R.id.date_btn);
        date_btn.setText(mCrime.getmDate().toString());
        date_btn.setEnabled(false);
        solved=view.findViewById(R.id.solved);
        send_btn=view.findViewById(R.id.send_crime);
        create_btn=view.findViewById(R.id.create_crime);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),CrimeListActivity.class));
            }
        });
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                crimeLab.getListCrime().add(mCrime);
                for (Crime crime:crimeLab.getListCrime()){
                    Log.i("crime---------",crime.getmId().toString());
                }
            }
        });
        create_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCrime=new Crime();
                date_btn.setText(mCrime.getmDate().toString());
                mTitleCrime.setText("");
//                solved.setText("solved");
                solved.setChecked(false);
            }
        });
        solved.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(solved.isChecked()){
                    mCrime.setmSolved(true);
                }else {
                    mCrime.setmSolved(false);
                }
            }
        });
        mTitleCrime.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            mCount.setText(Integer.toString(charSequence.length()));
            mCrime.setmTitle(charSequence.toString());
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return view;
    }

}
