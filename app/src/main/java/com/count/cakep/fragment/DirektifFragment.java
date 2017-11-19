package com.count.cakep.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.count.cakep.R;
import com.count.cakep.activity.ViewDirektifActivity;
import com.count.cakep.adapter.DirektifAdapter;
import com.count.cakep.adapter.ForumAdapter;
import com.count.cakep.model.Direktif;
import com.count.cakep.model.Forum;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DirektifFragment extends Fragment {

    @BindView(R.id.direktif_list_view) ListView direktif_list_view;

    private Resources res;
    private DirektifAdapter adapter;
    private List<Direktif> direktifData = new ArrayList<Direktif>();

    public DirektifFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_direktif, container, false);
        ButterKnife.bind(this, view);
        getActivity().setTitle("Informasi Direktif");

        //generate the forum data
        for(int a=0; a<10; a++) {
            //create new direktif object
            Direktif newDirektif = new Direktif();
            newDirektif.setDirektifDesc("Ini adalah sebuah berita mengenai cara melakukan pemasukan data TPS");

            //set the date
            Date date = new Date();
            date.getTime();
            newDirektif.setDirektifDate(date);
            newDirektif.setDirektifStatus("Belum Dibaca");
            direktifData.add(newDirektif);
        }

        //set the adapter
        setAdapter();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void setAdapter() {
        if(direktifData.size()>0){
            Log.d("setAdapter", "Setting up direktif adapter");

            adapter = new DirektifAdapter(getActivity(), direktifData, res);
            direktif_list_view.setAdapter(adapter);
            direktif_list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //call new intent here
                    Intent intent = new Intent(getActivity(), ViewDirektifActivity.class);
                    startActivity(intent);
                }
            });
        }
        else {
            Log.d("setAdapter", "The direktifData array is empty!");
        }
    }
}
