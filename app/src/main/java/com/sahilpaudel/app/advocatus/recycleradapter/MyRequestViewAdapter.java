package com.sahilpaudel.app.advocatus.recycleradapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sahilpaudel.app.advocatus.R;
import com.sahilpaudel.app.advocatus.dataprovider.MyRequestPost;
import com.sahilpaudel.app.advocatus.facebook.SharedPrefFacebook;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Sahil Paudel on 2/13/2017.
 */

public class MyRequestViewAdapter extends RecyclerView.Adapter<MyRequestViewAdapter.MyViewHolder> {


    List<MyRequestPost> list;
    Context context;

    public TextView tv_posterName, tv_timeTable, tv_numofhelpers,userPost;
    public ImageView poster_profile;

    public MyRequestViewAdapter(Context context, List<MyRequestPost> list) {
        this.list = list;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public MyViewHolder(View view) {
            super(view);
            tv_posterName = (TextView)view.findViewById(R.id.tv_posterName);
            tv_timeTable = (TextView)view.findViewById(R.id.timeTable);
            tv_numofhelpers = (TextView)view.findViewById(R.id.nohelpers);
            poster_profile = (ImageView)view.findViewById(R.id.poster_pic);
            userPost = (TextView) view.findViewById(R.id.userPost);
        }
    }

    @Override
    public MyRequestViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.myrequestview,parent,false);
        return new MyRequestViewAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyRequestViewAdapter.MyViewHolder holder, int position) {
        MyRequestPost feed = list.get(position);
        String fname = feed.firstName;
        String lname = feed.lastName;
        tv_posterName.setText(fname+" "+lname);
        tv_timeTable.setText(feed.startTime+" to "+feed.endTime);
        String imageUrl = "https://graph.facebook.com/" +feed.facebook_id+ "/picture?type=large";

        Picasso.with(context).load(imageUrl).into(poster_profile);
        tv_numofhelpers.setText(feed.no_of_helpers);
        userPost.setText(feed.description);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
