package com.yaiskuiux.dailyarticle.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import android.widget.TextView;
import android.widget.Toast;

import com.example.readmoretextview.ReadMoreTextView;
import com.yaiskuiux.dailyarticle.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ArticleDetailview extends AppCompatActivity {

    TextView txtarticletitle,txtarticledate,txtarticletime,txtarticledesc,txtarticlesubdesc,txtarticleuser,txtarticlefollower;
    ImageView articleimage,articleuserimage,back_arrow,dropdown_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detailview);

        //STATUS BAR COLOR
        Window window = this.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.blacktheme));


        Bundle bundle = getIntent().getExtras();
        String articletitle = bundle.getString("articleTitle");
        String articledate = bundle.getString("articleDate");
        String articletime = bundle.getString("articleTime");
        String articleuser = bundle.getString("articleUser");
        String articlesubdesc = bundle.getString("articleSubDesc");
        String articledesc = bundle.getString("articleDesc");
        String articlefollower = bundle.getString("articleFollower");

    //GET LIST ITEM



        txtarticletitle=(TextView)findViewById(R.id.article_title);
        txtarticletitle.setText(articletitle);

        txtarticledate=(TextView)findViewById(R.id.article_date);
        txtarticledate.setText(articledate);

        txtarticletime=(TextView)findViewById(R.id.article_time);
        txtarticletime.setText(articletime);

        txtarticledesc=(TextView)findViewById(R.id.article_desc);
        txtarticledesc.setText(articledesc);

        txtarticlesubdesc=(TextView)findViewById(R.id.article_subdesc);
        txtarticlesubdesc.setText(articlesubdesc);

        txtarticleuser=(TextView)findViewById(R.id.article_user);
        txtarticleuser.setText(articleuser);

        txtarticlefollower=(TextView)findViewById(R.id.article_follower);
        txtarticlefollower.setText(articlefollower);




        if (bundle != null) {
            int resId = bundle.getInt("articleImage");
            articleimage = (ImageView) findViewById(R.id.article_image);
            articleimage.setImageResource(resId);

            int resId2 = bundle.getInt("articleUserimage");
            articleuserimage = (CircleImageView) findViewById(R.id.article_userimg);
            articleuserimage.setImageResource(resId2);
        }


        ReadMoreTextView readMoreTextView = new ReadMoreTextView();
        readMoreTextView.setTextView(txtarticlesubdesc);
        readMoreTextView.setMaximumLine(3);
        readMoreTextView.setCollapseText("Read Less");
        readMoreTextView.setExpandText("Read More");
        readMoreTextView.setColorCode("#333333");
        readMoreTextView.setReadMore();


        //BACK ARROW

        back_arrow=(ImageView)findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //POPUP

        dropdown_menu=(ImageView)findViewById(R.id.dropdown_menu);
        final PopupMenu popupMenu= new PopupMenu(this,dropdown_menu);
        popupMenu.inflate(R.menu.popup_menu);

        dropdown_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                popupMenu.show();

            }
        });

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.setting:
                        Toast.makeText(ArticleDetailview.this,"You have selected Setting",Toast.LENGTH_SHORT).show();
                        break;
                    //return true;


                }return true;
            }
        });

    }
}