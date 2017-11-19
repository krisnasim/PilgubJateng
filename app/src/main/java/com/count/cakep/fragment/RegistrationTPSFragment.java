package com.count.cakep.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.count.cakep.R;

public class RegistrationTPSFragment extends Fragment {

    @BindView(R.id.editText9) EditText editText9;
    @BindView(R.id.add_more_tps_button) Button add_more_tps_button;
    @BindView(R.id.regis_relative_layout) RelativeLayout regis_relative_layout;
    //@BindView(R.id.test_relative_yo) RelativeLayout test_relative_yo;
    @BindView(R.id.submit_regis_button) Button submit_regis_button;

    public RegistrationTPSFragment() {
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
        View view = inflater.inflate(R.layout.fragment_registration_t, container, false);
        ButterKnife.bind(this, view);
        getActivity().setTitle("Registrasi Pers Pam TPS");

        //try to create new editText when clicked button
//        add_more_tps_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //intantiate new EditText
//                EditText testEdit = new EditText(getContext());
//                testEdit.setLayoutParams(new RelativeLayout.LayoutParams(
//                        RelativeLayout.LayoutParams.MATCH_PARENT,
//                        RelativeLayout.LayoutParams.MATCH_PARENT));
//
//                //set new relative layoutparams
//                RelativeLayout.LayoutParams rl = new RelativeLayout.LayoutParams(
//                        ViewGroup.LayoutParams.MATCH_PARENT,
//                        ViewGroup.LayoutParams.MATCH_PARENT);
//                //add rules
//                //rl.setMargins(0, 10, 0, 0);
//                rl.setMargins(0, 900, 0, 100);
//                add_more_tps_button.setLayoutParams(rl);
//                //add view into here
//                //regis_relative_layout.addView(add_more_tps_button, rl);
//
//                RelativeLayout.LayoutParams rl2 = new RelativeLayout.LayoutParams(
//                        ViewGroup.LayoutParams.MATCH_PARENT,
//                        ViewGroup.LayoutParams.MATCH_PARENT);
//
//                rl2.addRule(RelativeLayout.BELOW, editText9.getId());
//                //rl.addRule(RelativeLayout.ABOVE, add_more_tps_button.getId());
//                rl2.addRule(RelativeLayout.TEXT_ALIGNMENT_CENTER);
//                rl2.addRule(RelativeLayout.CENTER_HORIZONTAL);
//                rl2.addRule(RelativeLayout.ALIGN_START, editText9.getId());
//                rl2.addRule(RelativeLayout.ALIGN_END, editText9.getId());
//                regis_relative_layout.addView(testEdit, rl2);
//                //rl.addRule(RelativeLayout.BELOW, testEdit.getId());
//
//            }
//        });

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
}
