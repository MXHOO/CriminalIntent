package com.example.lenovo.criminalintent;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;


public class CrimeListFragment extends android.support.v4.app.Fragment {
    private RecyclerView recyclerView;
    private List<Crime>  crimes;
    public CrimeListFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_crime_list, container, false);
        recyclerView=v.findViewById(R.id.mRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        upDateUI();
        return v;
    }
    public void upDateUI(){
        CrimeLab crimeLab=CrimeLab.getInstance();
        List<Crime> list=crimeLab.getListCrime();
        CrimeAdapter adapter=new CrimeAdapter(list);
        recyclerView.setAdapter(adapter);
    }
    private class CrimeHolder extends RecyclerView.ViewHolder{
        private TextView list_item_title,list_item_date;
        private CheckBox list_item_checkbox;

        public TextView getList_item_title() {
            return list_item_title;
        }

        public TextView getList_item_date() {
            return list_item_date;
        }

        public CheckBox getList_item_checkbox() {
            return list_item_checkbox;
        }

        public CrimeHolder(View itemView) {
            super(itemView);
            list_item_title=itemView.findViewById(R.id.list_item_title);
            list_item_date=itemView.findViewById(R.id.list_item_date);
            list_item_checkbox=itemView.findViewById(R.id.list_item_checkbox);
        }
    }
    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{
        private List<Crime> crimes;
        public CrimeAdapter(List<Crime> crime){
            this.crimes=crime;
        }
        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater lf=LayoutInflater.from(getActivity());
            View v=lf.inflate(R.layout.list_item_crime,parent,false);
            return new CrimeHolder(v);
        }

        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            Crime c=crimes.get(position);
            holder.list_item_title.setText(c.getmTitle());
            holder.list_item_date.setText(c.getmDate().toString());
            holder.list_item_checkbox.setChecked(c.getmSolved());
        }

        @Override
        public int getItemCount() {
            return crimes.size();
        }
    }

}
