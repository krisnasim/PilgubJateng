package id.mdh.pilgubjateng.customclass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.mdh.pilgubjateng.R;

/**
 * Created by Jonathan Simananda on 21/03/2017.
 */

public class CustomGridMenu extends BaseAdapter {

    //put all variables on top
    private Context ctx;
    private ArrayList<String> web = new ArrayList<String>();
    private ArrayList<Integer> imageID = new ArrayList<Integer>();

    public CustomGridMenu(Context c, ArrayList<String> web, ArrayList<Integer> Imageid ) {
        ctx = c;
        this.imageID = Imageid;
        this.web = web;
    }

    @Override
    public int getCount() {
        return web.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder viewer;
        //View grid;

        if (view == null) {
//            grid = new View(ctx);
//            grid = inflater.inflate(R.layout.grid_single, null);
//            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
//            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
//            textView.setText(web.get(i));
//            imageView.setImageResource(imageID.get(i));

            view = inflater.inflate(R.layout.grid_single, null);
            viewer = new ViewHolder(view);
            viewer.grid_text.setText(web.get(i));
            viewer.grid_image.setImageResource(imageID.get(i));
            view.setTag(viewer);
        } else {
            //grid = (View) view;
            viewer = (ViewHolder) view.getTag();
        }

        return view;
    }

    //a static class to bind the layout
    static class ViewHolder {
        @BindView(R.id.grid_text) TextView grid_text;
        @BindView(R.id.grid_image) ImageView grid_image;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
