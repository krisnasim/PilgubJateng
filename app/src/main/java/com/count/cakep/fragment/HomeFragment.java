package com.count.cakep.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.count.cakep.R;
import com.count.cakep.activity.HomeActivity;
import com.count.cakep.customclass.CustomSpinnerAdapter;
import com.count.cakep.customclass.InfoPersonalDialogFragment;

public class HomeFragment extends Fragment {

    private HomeActivity act;
    private boolean profileIsChecked = true;
    private boolean specialRegion = true;
    private ArrayList<String> web = new ArrayList<String>();
    private ArrayList<Integer> imageID = new ArrayList<Integer>();

    //@BindView(R.id.grid_home_menu) GridView grid_home_menu;
    @BindView(R.id.spinner) Spinner spinner;
    @BindView(R.id.topHomeChart) HorizontalBarChart topHomeChart;
    @BindView(R.id.card_view_direktif) CardView card_view_direktif;
    @BindView(R.id.card_view_pungut_suara) CardView card_view_pungut_suara;
    @BindView(R.id.card_view_laporan_pungut_suara) CardView card_view_laporan_pungut_suara;

    @OnClick(R.id.card_view_direktif)
    public void direktifMenu() {
        //get the fragment to change
        Fragment fragment = new DirektifFragment();
        act.changeFragment(fragment);
    }

    @OnClick(R.id.card_view_laporan_pungut_suara)
    public void laporanPungutSuaraMenu() {
        //get the fragment to change
        Fragment fragment = new InputHistoryTPSFragment();
        act.changeFragment(fragment);
    }

    @OnClick(R.id.card_view_pungut_suara)
    public void pungutSuaraMenu() {
        //check if the region is special
        if(specialRegion) {
            //create a custom dialog first
            AlertDialog.Builder choiceDialog = new AlertDialog.Builder(getActivity());
            choiceDialog.setTitle("Pilih salah satu");
            //adding the array of choice here
            final ArrayAdapter<String> choices = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_selectable_list_item);
            choices.add("Lapor pungut suara Pilgub");
            choices.add("Lapor pungut suara Pilbup/walkot");
            //generate the dialog
            choiceDialog.setAdapter(choices, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String choice = choices.getItem(i);
                    if(choice.matches("Lapor pungut suara Pilgub")) {
                        //get the fragment to change for pilgub vote
                        Fragment fragment = new InputTPSFragment();
                        act.changeFragment(fragment);
                        //Toast.makeText(act, "Kamu memilih pilgub!", Toast.LENGTH_SHORT).show();
                    } else if(choice.matches("Lapor pungut suara Pilbup/walkot")) {
                        //get the fragment to change for pilbup vote
                        Fragment fragment = new InputTPSFragment();
                        act.changeFragment(fragment);
                        //Toast.makeText(act, "Kamu memilih pilbup!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            //show the dialog
            choiceDialog.show();

        } else {
            //get the fragment to change for pilgub vote
            Fragment fragment = new InputTPSFragment();
            act.changeFragment(fragment);
            //Toast.makeText(act, "Kamu memilih pilgub!", Toast.LENGTH_SHORT).show();
        }
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //call the activity here
        act = (HomeActivity) getActivity();
        ButterKnife.bind(this, view);
        getActivity().setTitle("Beranda");

        if(specialRegion == false) {
            spinner.setVisibility(View.GONE);
        }

        if(!profileIsChecked) {
            FragmentManager manager = getActivity().getSupportFragmentManager();
            InfoPersonalDialogFragment dialog = new InfoPersonalDialogFragment();
            dialog.show(manager, "Alert dialog");
        }

        // in this example, a LineChart is initialized from xml
        //BarChart chart = (BarChart) getActivity().findViewById(R.id.topHomeChart);
        //adding dummy data
        int[] dataObjects = {123, 667, 456};
        int[] numberData = {1, 2, 3};
        //List<Integer> colors = new ArrayList<Integer>();
        int[] colors = {
                            ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark),
                            ContextCompat.getColor(getActivity(), R.color.colorPrimary),
                            ContextCompat.getColor(getActivity(), R.color.DarkRedMaterial)
                        };

        //adding the data into chart obj
        List<BarEntry> entries = new ArrayList<BarEntry>();

        for (int x=0; x<numberData.length; x++) {

            // turn your data into Entry objects
            entries.add(new BarEntry(numberData[x], dataObjects[x]));
        }

        BarDataSet dataSet = new BarDataSet(entries, "Suara jumlah Paslon"); // add entries to dataset
        //dataSet.setValueTextColors(colors);
        dataSet.setColors(colors);
        //dataSet.setValueTextColor(...); // styling, ...

        BarData barData = new BarData(dataSet);
        topHomeChart.setData(barData);
        topHomeChart.setBorderColor(ContextCompat.getColor(getActivity(),R.color.colorPrimaryDark));
        topHomeChart.setGridBackgroundColor(ContextCompat.getColor(getActivity(), R.color.White));
        topHomeChart.setDrawValueAboveBar(true);
        //topHomeChart.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.White));
        topHomeChart.invalidate(); // refresh
        topHomeChart.animateY(3000);
        topHomeChart.setDoubleTapToZoomEnabled(false);

        //set up x and y axis, and legend color

        XAxis xAxis = topHomeChart.getXAxis();
        xAxis.setAxisLineColor(ContextCompat.getColor(getActivity(), R.color.White));
        xAxis.setTextColor(ContextCompat.getColor(getActivity(), R.color.White));

        YAxis yAxis = topHomeChart.getAxisRight();
        yAxis.setAxisLineColor(ContextCompat.getColor(getActivity(), R.color.White));
        yAxis.setTextColor(ContextCompat.getColor(getActivity(), R.color.White));


        Legend legend = topHomeChart.getLegend();
        legend.setTextColor(ContextCompat.getColor(getActivity(), R.color.White));

        List<String> items = new ArrayList<String>();
        items.add("Pilgub");
        items.add("Pilbup/walkot");

        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(getActivity(), R.layout.spinner_item, items);
        spinner.setAdapter(adapter);
        spinner.getBackground().setColorFilter(getResources().getColor(R.color.White), PorterDuff.Mode.SRC_ATOP);


//        //adding up some items for grid menu
//        web.add("Registrasi Pers Pam TPS");
//        web.add("Hasil Rekap TPS");
//        web.add("Rekam Data TPS");
//        web.add("Lihat Profil");
//
//        imageID.add(R.drawable.ic_regis_tps_white);
//        imageID.add(R.drawable.ic_catat_data_tps_white);
//        imageID.add(R.drawable.ic_rekam_data_tps_white);
//        imageID.add(R.drawable.ic_profil_white);
//
//        //creating the custom grid layout
//        CustomGridMenu adapter = new CustomGridMenu(getActivity(), web, imageID);
//        grid_home_menu.setAdapter(adapter);
//        grid_home_menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                //Toast.makeText(HomeActivity.this, "You are clicking menu number "+web.get(i), Toast.LENGTH_SHORT).show();
//                //set up the fragment here
//                Fragment fragment = new Fragment();
//
//                if(i==0) {
//                    fragment = new RegistrationTPSFragment();
//                } else if(i==1) {
//                    fragment = new InputTPSFragment();
//                } else if(i==2) {
//                    fragment = new InputHistoryTPSFragment();
//                } else if(i==3) {
//                    fragment = new ProfileFragment();
//                }
//
//                if (act != null) // Make sure we are attached
//                {
//                    web.clear();
//                    imageID.clear();
//                    grid_home_menu.setAdapter(null);
//                    act.changeFragment(fragment);
//                }
//                else {
//                    Log.d("changeFragment", "hmm. null?");
//                }
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
