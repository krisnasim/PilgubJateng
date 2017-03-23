package id.mdh.pilgubjateng.fragment;

import android.content.Context;
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
import id.mdh.pilgubjateng.R;
import id.mdh.pilgubjateng.adapter.ForumAdapter;
import id.mdh.pilgubjateng.customclass.Forum;

public class InputHistoryTPSFragment extends Fragment {

    private ListView lv;
    private Resources res;
    private ForumAdapter adapter;
    private List<Forum> forumData = new ArrayList<Forum>();

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
        lv = (ListView) view.findViewById(R.id.list_view_input);

        //generate the forum data
        for(int a=0; a<10; a++) {
            //create new forum object
            Forum newForum = new Forum();
            if(a==0 || a==1) {
                newForum.setFullName("Bripda Mukidi");
            }
            if(a==2 || a==3) {
                newForum.setFullName("Aiptu Anwar");
            }
            if(a==4 || a==5) {
                newForum.setFullName("Aiptu Hakim");
            }
            if(a==6 || a==7) {
                newForum.setFullName("Bripda Anwan");
            }
            if(a==8 || a==9) {
                newForum.setFullName("Bripda Munik");
            }

            //newForum.setFullName("John Doe");
            Date date = new Date();
            date.getTime();
            newForum.setForumDateCreated(date);
            newForum.setForumTitle("TPS "+(a+1));
            //newForum.setForumPost("Pelaporan Rekap Data");

            if(a==0 || a==1) {
                newForum.setForumPost("Desa Terlangu, Kecamatan Jatibarang");
            }
            if(a==2 || a==3) {
                newForum.setForumPost("Desa Kaligangsa Kulon, Kecamatan Jatibarang");
            }
            if(a==4 || a==5) {
                newForum.setForumPost("Desa Kaligangsa Wetan, Kecamatan Jatibarang");
            }
            if(a==6 || a==7) {
                newForum.setForumPost("Desa Kalipati, Kecamatan Jatibarang");
            }
            if(a==8 || a==9) {
                newForum.setForumPost("Desa Randusanga, Kecamatan Jatibarang");
            }
            //newForum.setNumberOfPosts(comments.length());
            newForum.setNumberOfPosts(10);
            //newForum.setPostID(postID);
            forumData.add(newForum);
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
        if(forumData.size()>0){
            Log.d("setAdapter", "Setting up forum adapter");

            adapter = new ForumAdapter(getActivity(), forumData, res);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    Bundle bundle = new Bundle();
//                    bundle.putString("postID", forumData.get(position).getPostID());
//                    PostFragment fragment = new PostFragment();
//                    fragment.setArguments(bundle);
//
//                    //get sharedpref level
//                    String level = sharedPref.getString("level", "NoLevel");
//                    if(level.equals("sales_representative") || level.equals("area_manager") || level.equals("promoter") || level.equals("admin")) {
//                        HomeSRActivity act = (HomeSRActivity) getActivity();
//                        act.changeFragment(fragment);
//                    } else if(level.equals("merchandiser")) {
//                        HomeMDSActivity act = (HomeMDSActivity) getActivity();
//                        act.changeFragment(fragment);
//                    }

                    //call new intent here. show mockup
                }
            });
        }
        else {
            Log.d("setAdapter", "The forumData array is empty!");
        }
    }
}
