package id.mdh.pilgubjateng.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.mdh.pilgubjateng.R;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.testTest) TextView testTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //testTest.setText("Saya kotak");
        testTest.setTextColor(Color.RED);
    }
}
