package com.count.cakep.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.count.cakep.R;
import com.count.cakep.model.Forum;

/**
 * Created by Jonathan Simananda on 11/07/2016.
 */
public class ForumAdapter extends BaseAdapter implements View.OnClickListener{
    private Activity activity;
    private LayoutInflater inflater;
    private List<Forum> forumData;
    private Forum tempValues;
    public Resources res;

    public ForumAdapter(Activity activity, List<Forum> data, Resources resLocal) {
        this.activity = activity;
        this.forumData = data;
        this.res = resLocal;

        inflater = ( LayoutInflater )activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    private static class ViewHolder {
        private TextView forumTitle;
        private TextView forumDateCreated;
        private TextView forumPost;
        private TextView fullName;
        private TextView numberOfPosts;
        private ImageView avatar;
    }

    @Override
    public int getCount() {
        return forumData.size();
    }

    @Override
    public Object getItem(int position) {
        return forumData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public void onClick(View v) {
        Log.v("ForumAdapter", "=====Row button clicked=====");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder holder;

        if(convertView == null) {
            rowView = inflater.inflate(R.layout.forum_item_layout, parent, false);

            Log.d("GetView", "Finding all the right element after inflating custom layout");

            holder = new ViewHolder();
            holder.fullName = (TextView) rowView.findViewById(R.id.vote_location);
            holder.forumDateCreated = (TextView) rowView.findViewById(R.id.endPoint);
            holder.forumTitle = (TextView) rowView.findViewById(R.id.Distance);
            holder.forumPost = (TextView) rowView.findViewById(R.id.vote_datetime);
            holder.numberOfPosts = (TextView) rowView.findViewById(R.id.availableSeats);
            holder.avatar = (ImageView) rowView.findViewById(R.id.avatar);

            //getting ride data for each row
            Forum post = forumData.get(position);

            //setting up text and image
            //post.getFullName();

            rowView.setTag(holder);
        }
        else {
            holder = (ViewHolder) rowView.getTag();
        }

        if(forumData.size() <= 0) {
            holder.fullName.setText("No Data");
        }
        else {
            tempValues = null;
            tempValues = forumData.get(position);

            Log.d("GetView", "setting each row with data");
            Log.d("GetViewData", tempValues.getFullName());
            Log.d("GetViewData", tempValues.getForumTitle());
            Log.d("GetViewData", String.valueOf(tempValues.getForumDateCreated()));

            Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            //Format formatter = new SimpleDateFormat("EEE MMM d HH:mm:ss Z yyyy");
            Date date = tempValues.getForumDateCreated();
            //Log.d("DateView", String.valueOf(tempValues.getTravelStart()));
            String datetoString = formatter.format(date);

            holder.fullName.setText(tempValues.getFullName());
            holder.forumDateCreated.setText("Last updated: "+datetoString);
            holder.forumTitle.setText(tempValues.getForumTitle());
            holder.forumPost.setText(tempValues.getForumPost());
            holder.numberOfPosts.setText(String.valueOf(tempValues.getNumberOfPosts()));
            holder.avatar.setImageResource(R.drawable.ic_person_big);

            //rowView.setOnClickListener(new OnItemClickListener(position, forumData.get(position)));
        }
        return rowView;
    }
}