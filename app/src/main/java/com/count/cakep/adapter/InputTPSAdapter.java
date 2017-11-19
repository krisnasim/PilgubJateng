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
import com.count.cakep.model.InputTPS;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jonat on 09/10/2017.
 */

public class InputTPSAdapter extends BaseAdapter implements View.OnClickListener{

    private Activity activity;
    private LayoutInflater inflater;
    private List<InputTPS> inputTPSData;
    private InputTPS tempValues;
    public Resources res;

    public InputTPSAdapter(Activity activity, List<InputTPS> data, Resources resLocal) {
        this.activity = activity;
        this.inputTPSData = data;
        this.res = resLocal;

        inflater = ( LayoutInflater )activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    static class ViewHolder {
        @BindView(R.id.vote_location) TextView vote_location;
        @BindView(R.id.vote_datetime) TextView vote_datetime;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public int getCount() {
        return inputTPSData.size();
    }

    @Override
    public Object getItem(int i) {
        return inputTPSData.get(i);
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
            rowView = inflater.inflate(R.layout.row_input_history_tps, viewGroup, false);
            holder = new ViewHolder(rowView);
            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
        }

        if(inputTPSData.size() <= 0) {
            holder.vote_location.setText("No data");
        } else {
            tempValues = null;
            tempValues = inputTPSData.get(i);

            Log.d("GetView", "setting each row with data");

            //Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Format formatter = new SimpleDateFormat("dd MMM");
            Date date = tempValues.getVoteDateCreated();
            String datetoString = formatter.format(date);

            holder.vote_location.setText(tempValues.getVoteLocation());
            holder.vote_datetime.setText(datetoString);
        }

        return rowView;
    }
}
