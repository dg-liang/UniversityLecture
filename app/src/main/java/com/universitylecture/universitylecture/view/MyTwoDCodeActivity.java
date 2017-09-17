package com.universitylecture.universitylecture.view;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.universitylecture.universitylecture.R;
import com.universitylecture.universitylecture.adapter.LectureAdapterTwo;
import com.universitylecture.universitylecture.pojo.Lecture;
import com.universitylecture.universitylecture.pojo.School;
import com.universitylecture.universitylecture.util.MyApplication;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.util.ArrayList;
import java.util.List;

import static android.view.Window.FEATURE_NO_TITLE;

//import com.universitylecture.universitylecture.pojo.SimpleDividerItemDecoration;

/**
 * Created by fengqingyundan on 2017/8/23.
 */

public class MyTwoDCodeActivity extends AppCompatActivity {
    private ImageView myTwoDCode;
    private TextView title;
    private Button back;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my_two_d_code);

        initView();
    }

    private void initView(){
        //生成二维码照片
        myTwoDCode = (ImageView) findViewById(R.id.myTwoDCode);
        Intent intent = getIntent();
        String content = intent.getStringExtra("user_id");//二维码内容
        Bitmap mBitmap = CodeUtils.createImage(content, 400, 400, null);
        myTwoDCode.setImageBitmap(mBitmap);

        title = (TextView) findViewById(R.id.title_in_title_bar);
        title.setText("我的二维码");

        back = (Button) findViewById(R.id.go_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTwoDCodeActivity.super.onBackPressed();
            }
        });
    }
}
