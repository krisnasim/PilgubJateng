package com.count.cakep.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.TypedValue;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.count.cakep.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewInputTPSDetailActivity extends AppCompatActivity {

    @BindView(R.id.input_detail_linear_layout) LinearLayout input_detail_linear_layout;

    //private List<EditText> allVoteCounts = new ArrayList<EditText>();

    @OnClick(R.id.change_input_detail_button)
    public void changeVoteData() {
        //new intent to edit
        Intent intent = new Intent(this, EditInputTPSDetailActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.close_input_detail_button)
    public void closeVoteData() {
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_input_tps_detail);
        ButterKnife.bind(this);

        addNewLayout(input_detail_linear_layout, 3, ViewInputTPSDetailActivity.this);
    }

    private void addNewLayout(LinearLayout layout, int amount, Context ctx) {
        //adding new TextView according to amount given
        for(int x=0; x<amount; x++) {
            TextView label = new TextView(ctx);
            label.setText("Jumlah suara calon "+(x+1));
            label.setTextSize(14);

            //set layout params for the textview
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            int startMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, getResources().getDisplayMetrics());
            int topMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics());
            lp.setMargins(0, startMargin, 0, 0);
            label.setLayoutParams(lp);
            layout.addView(label);

            TextView label2 = new TextView(ctx);
            label2.setText("668");
            label2.setTextSize(20);
            LinearLayout.LayoutParams lpEd = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lpEd.setMargins(0, topMargin, 0, 0);
            label2.setLayoutParams(lpEd);
            layout.addView(label2);

//            Toast.makeText(ctx, "OI "+x, Toast.LENGTH_SHORT).show();

//            EditText ed = new EditText(ctx);
//            ed.setHint("Jumlah suara calon "+(x+1));
//            ed.setInputType(InputType.TYPE_CLASS_NUMBER);
//            int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, getResources().getDisplayMetrics());
//            LinearLayout.LayoutParams lpEd = new LinearLayout.LayoutParams(width, LinearLayout.LayoutParams.WRAP_CONTENT);
//            lpEd.setMargins(startMargin, 0, 0, 0);
//            ed.setLayoutParams(lpEd);
//            allVoteCounts.add(ed);
//            layout.addView(ed);
        }
    }
}
