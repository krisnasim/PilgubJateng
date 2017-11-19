package com.count.cakep.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.count.cakep.R;
import com.count.cakep.model.Direktif;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jonat on 09/10/2017.
 */

public class DirektifAdapter extends BaseAdapter implements View.OnClickListener{
    private Activity activity;
    private LayoutInflater inflater;
    private List<Direktif> direktifData;
    private Direktif tempValues;
    public Resources res;

    public DirektifAdapter(Activity activity, List<Direktif> data, Resources resLocal) {
        this.activity = activity;
        this.direktifData = data;
        this.res = resLocal;

        inflater = ( LayoutInflater )activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    static class ViewHolder {
        @BindView(R.id.direktif_short_desc) TextView direktif_short_desc;
        @BindView(R.id.direktif_datetime) TextView direktif_datetime;
        @BindView(R.id.direktif_status) TextView direktif_status;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public int getCount() {
        return direktifData.size();
    }

    @Override
    public Object getItem(int i) {
        return direktifData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = view;
        ViewHolder holder;

        if(view == null) {
            rowView = inflater.inflate(R.layout.row_direktif_item, viewGroup, false);
            holder = new ViewHolder(rowView);
            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
        }

        if(direktifData.size() <= 0) {
            holder.direktif_short_desc.setText("No data");
        } else {
            tempValues = null;
            tempValues = direktifData.get(i);

            Log.d("GetView", "setting each row with data");

            //Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Format formatter = new SimpleDateFormat("dd MMM");
            Date date = tempValues.getDirektifDate();
            String datetoString = formatter.format(date);

            holder.direktif_short_desc.setText(tempValues.getDirektifDesc());
            holder.direktif_datetime.setText(datetoString);
            holder.direktif_status.setText(tempValues.getDirektifStatus());
        }

        return rowView;
    }
}
