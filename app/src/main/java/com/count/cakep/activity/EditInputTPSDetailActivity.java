package com.count.cakep.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.count.cakep.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditInputTPSDetailActivity extends AppCompatActivity {

    @BindView(R.id.edit_nama_personil) EditText edit_nama_personil;
    @BindView(R.id.edit_nrp_personil) EditText edit_nrp_personil;
    @BindView(R.id.edit_jumlah_dpt) EditText edit_jumlah_dpt;

    @OnClick(R.id.edit_input_data_button)
    public void closeEdit() {
        //call intent to home activity
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);

        Toast.makeText(this, "Data berhasil diubah!", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_input_tps_detail);
        ButterKnife.bind(this);

        edit_nama_personil.setEnabled(false);
        edit_nrp_personil.setEnabled(false);
        edit_jumlah_dpt.setEnabled(false);
    }
}
