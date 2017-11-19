package com.count.cakep.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import com.count.cakep.R;

public class SuccessActivity extends AppCompatActivity {

    private HomeActivity act;

    @OnClick(R.id.new_data_input_button)
    public void newData() {
        Bundle extra = new Bundle();
        extra.putString("intent", "new");
        Intent intent = new Intent(SuccessActivity.this, HomeActivity.class);
        intent.putExtras(extra);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.back_to_home_button)
    public void goHome(){
        Bundle extra = new Bundle();
        extra.putString("intent", "home");
        Intent intent = new Intent(SuccessActivity.this, HomeActivity.class);
        intent.putExtras(extra);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);
        ButterKnife.bind(this);
    }
}
