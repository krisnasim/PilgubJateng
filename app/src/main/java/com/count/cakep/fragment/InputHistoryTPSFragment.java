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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;
import com.count.cakep.R;
import com.count.cakep.activity.ViewInputTPSDetailActivity;
import com.count.cakep.adapter.ForumAdapter;
import com.count.cakep.adapter.InputTPSAdapter;
import com.count.cakep.model.Forum;
import com.count.cakep.model.InputTPS;

public class InputHistoryTPSFragment extends Fragment {

    private ListView lv;
    private Resources res;
    private InputTPSAdapter adapter;
    private List<InputTPS> inputTPSData = new ArrayList<InputTPS>();

    public InputHistoryTPSFragment() {
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
        View view = inflater.inflate(R.layout.fragment_input_history_t, container, false);
        ButterKnife.bind(this, view);
        getActivity().setTitle("Rekam Data TPS");
        lv = view.findViewById(R.id.list_view_input);

        //generate the forum data
        for(int a=0; a<10; a++) {
            //create new input tps object
            InputTPS newInput = new InputTPS();
            if(a==0 || a==1) {
                newInput.setVoteLocation("TPS 1 Desa A Kabupaten A");
            }
            if(a==2 || a==3) {
                newInput.setVoteLocation("TPS 1 Desa B Kabupaten A");
            }
            if(a==4 || a==5) {
                newInput.setVoteLocation("TPS 1 Desa A Kabupaten B");
            }
            if(a==6 || a==7) {
                newInput.setVoteLocation("TPS 1 Desa B Kabupaten B");
            }
            if(a==8 || a==9) {
                newInput.setVoteLocation("TPS 1 Desa C Kabupaten B");
            }

            //newForum.setFullName("John Doe");
            Date date = new Date();
            date.getTime();
            newInput.setVoteDateCreated(date);

            inputTPSData.add(newInput);
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
        if(inputTPSData.size()>0){
            Log.d("setAdapter", "Setting up input tps adapter");

            adapter = new InputTPSAdapter(getActivity(), inputTPSData, res);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //send them into detail activity
                    Intent intent = new Intent(getActivity(), ViewInputTPSDetailActivity.class);
                    startActivity(intent);
                }
            });
        }
        else {
            Log.d("setAdapter", "The inputTPSData array is empty!");
        }
    }
}
