package com.count.cakep.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.count.cakep.R;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.testTest) TextView testTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //testTest.setText("Saya kotak");
        testTest.setTextColor(Color.RED);
        testTest.setVisibility(View.INVISIBLE);
    }
}
