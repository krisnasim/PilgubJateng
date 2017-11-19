package com.count.cakep.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.count.cakep.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewDirektifActivity extends AppCompatActivity {

    @BindView(R.id.direktif_date) TextView direktif_date;
    @BindView(R.id.direktif_description) TextView direktif_description;

    @OnClick(R.id.close_direktif_button)
    public void closeDirektif() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_direktif);
        ButterKnife.bind(this);

        //set the text after receiving data
    }
}
