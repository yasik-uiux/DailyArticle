package com.yaiskuiux.dailyarticle.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yaiskuiux.dailyarticle.R;
import com.yaiskuiux.dailyarticle.ui.activity.ArticleDetailview;
import com.yaiskuiux.dailyarticle.ui.activity.MainActivity;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter {
    ArrayList articleTitle;
    ArrayList articleDesc;
    ArrayList articleSubDesc;
    ArrayList articleDate;
    ArrayList articleTime;
    ArrayList articleImage;
    ArrayList articleUser;
    ArrayList articleFollower;
    ArrayList articleUserimage;

    private long doneButtonClickTime = 0;
    Context context;

    public CustomAdapter(Context context, ArrayList articleTitle, ArrayList articleDesc, ArrayList articleSubDesc, ArrayList articleDate, ArrayList articleTime, ArrayList articleImage, ArrayList articleUser,ArrayList articleFollower,ArrayList articleUserimage) {
        this.context = context;
        this.articleTitle = articleTitle;
        this.articleDesc = articleDesc;
        this.articleSubDesc = articleSubDesc;
        this.articleDate = articleDate;
        this.articleTime = articleTime;
        this.articleImage = articleImage;
        this.articleUser = articleUser;
        this.articleFollower = articleFollower;
        this. articleUserimage=articleUserimage;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);

            return new CustomAdapter.MyViewHolder(view);




    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        populateItemRows((CustomAdapter.MyViewHolder) holder, position);

    }

    private void populateItemRows(MyViewHolder holder, int position) {

        holder.articletitle.setText((CharSequence) articleTitle.get(position));
        holder.articledate.setText((CharSequence) articleDate.get(position));
        holder.articletime.setText((CharSequence) articleTime.get(position));
        holder.articledesc.setText((CharSequence) articleDesc.get(position));

        holder.articleimage.setImageResource((Integer) articleImage.get(position));


        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SystemClock.elapsedRealtime() - doneButtonClickTime < 500){
                    return;
                }
                doneButtonClickTime = SystemClock.elapsedRealtime();
                Intent i = new Intent(context, ArticleDetailview.class);

                i.putExtra("articleTitle",(CharSequence) articleTitle.get(position));
                i.putExtra("articleDate",(CharSequence) articleDate.get(position));
                i.putExtra("articleTime",(CharSequence) articleTime.get(position));
                i.putExtra("articleDesc",(CharSequence) articleDesc.get(position));
                i.putExtra("articleSubDesc",(CharSequence) articleSubDesc.get(position));
                i.putExtra("articleUser",(CharSequence) articleUser.get(position));
                i.putExtra("articleFollower",(CharSequence) articleFollower.get(position));
                i.putExtra("articleUserimage",(Integer) articleUserimage.get(position));
                i.putExtra("articleImage",(Integer) articleImage.get(position));

                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return articleTitle.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView articletitle,articledate,articletime,articledesc;
        ImageView articleimage;
        public MyViewHolder(View itemView) {
            super(itemView);
            articletitle = (TextView) itemView.findViewById(R.id.article_title);
            articledate = (TextView) itemView.findViewById(R.id.article_date);
            articletime = (TextView) itemView.findViewById(R.id.article_time);
            articledesc = (TextView) itemView.findViewById(R.id.article_desc);
            articleimage = (ImageView) itemView.findViewById(R.id.article_image);
        }
    }

    public class LoadingViewHolder extends RecyclerView.ViewHolder {

        //  LoadingView progressBar;

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
            //  progressBar = itemView.findViewById(R.id.loadingView);
        }
    }
}