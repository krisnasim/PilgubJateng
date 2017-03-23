package id.mdh.pilgubjateng.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.mdh.pilgubjateng.R;
import id.mdh.pilgubjateng.activity.HomeActivity;
import id.mdh.pilgubjateng.customclass.CustomGridMenu;

public class HomeFragment extends Fragment {

    private HomeActivity act;
    private ArrayList<String> web = new ArrayList<String>();
    private ArrayList<Integer> imageID = new ArrayList<Integer>();

    @BindView(R.id.grid_home_menu) GridView grid_home_menu;

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

        //adding up some items for grid menu
        web.add("Registrasi Pers Pam TPS");
        web.add("Hasil Rekap TPS");
        web.add("Rekam Data TPS");
        web.add("Lihat Profil");

        imageID.add(R.drawable.ic_regis_tps_white);
        imageID.add(R.drawable.ic_catat_data_tps_white);
        imageID.add(R.drawable.ic_rekam_data_tps_white);
        imageID.add(R.drawable.ic_profil_white);

        //creating the custom grid layout
        CustomGridMenu adapter = new CustomGridMenu(getActivity(), web, imageID);
        grid_home_menu.setAdapter(adapter);
        grid_home_menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(HomeActivity.this, "You are clicking menu number "+web.get(i), Toast.LENGTH_SHORT).show();
                //set up the fragment here
                Fragment fragment = new Fragment();

                if(i==0) {
                    fragment = new RegistrationTPSFragment();
                } else if(i==1) {
                    fragment = new InputTPSFragment();
                } else if(i==2) {
                    fragment = new InputHistoryTPSFragment();
                } else if(i==3) {
                    fragment = new ProfileFragment();
                }

                if (act != null) // Make sure we are attached
                {
                    act.changeFragment(fragment);
                }
                else {
                    Log.d("changeFragment", "hmm. null?");
                }
            }
        });

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
