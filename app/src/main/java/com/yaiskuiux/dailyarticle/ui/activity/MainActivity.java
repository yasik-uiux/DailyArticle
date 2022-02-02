package com.yaiskuiux.dailyarticle.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Window;

import com.yaiskuiux.dailyarticle.R;
import com.yaiskuiux.dailyarticle.ui.adapter.CustomAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViews;
    private  CustomAdapter customAdapter;

    ArrayList articleTitle = new ArrayList<>(Arrays.asList("Building a Creative Space Studio Tour 2022", "How to be a confident sunshine girl ?", "How to Parent When You’re Battling an Epic Hangover."));
    ArrayList articleDesc = new ArrayList<>(Arrays.asList("Establishing a creative space is a creative process in itself. It is a process that you should give thought to, invest in and execute to your liking.","Confidence is like a drug. Sometimes it brings you down and sometimes it gets you so high. While life is a roller coaster and whether we like it or not, the road to confidence is jittery, meandering and never a straight scale.","Lorem ipsum dolor sit amet consectetur adipiscing elit. Phasellus dignissim purus facilisis libero suscipit vulputate.Vestibulum rutrum velit in mauris ullamcorper, id posuere nisi ornare"));
    ArrayList articleSubDesc = new ArrayList<>(Arrays.asList("Creativity is a learning process and creative spaces can help us improve our artistic reflexes. Establishing a creative territory can be beneficial for all parties involved. This includes family, friends and pets. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod","I always look back at how far I’ve come and what all I’ve achieved on the way. Friends help as well. This brings me to another vital point- friends can make the world go around. Have a circle of friends that can life your spirits in your darkest hours. Friend therapy always works. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod","int occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod"));
    ArrayList articleDate = new ArrayList<>(Arrays.asList("January 19, 2022","January 22, 2022","January 28, 2022"));
    ArrayList articleTime = new ArrayList<>(Arrays.asList("08.00 AM","12.00 PM","10.30 PM"));
    ArrayList articleImage = new ArrayList<>(Arrays.asList(R.drawable.article1,R.drawable.article2,R.drawable.article3));
    ArrayList articleUser = new ArrayList<>(Arrays.asList("Eva Longoria","Reese Witherspoon","Hugh Jackman"));
    ArrayList articleFollower = new ArrayList<>(Arrays.asList("1.2 million followers","2.5 million followers","4.0 million followers"));
    ArrayList articleUserimage = new ArrayList<>(Arrays.asList(R.drawable.artuser1,R.drawable.artuser2,R.drawable.artuser3));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //STATUS BAR COLOR
        Window window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.blacktheme));

        recyclerViews = (RecyclerView)findViewById(R.id.recycler_view);
        customAdapter = new CustomAdapter(this, articleTitle,articleDesc,articleSubDesc,articleDate,articleTime,articleImage,articleUser,articleFollower,articleUserimage);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerViews.setLayoutManager(mLayoutManager);
        recyclerViews.setAdapter(customAdapter);
        customAdapter.notifyDataSetChanged();
    }
}