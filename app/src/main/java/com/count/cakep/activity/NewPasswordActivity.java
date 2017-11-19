package com.count.cakep.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.count.cakep.R;

public class NewPasswordActivity extends AppCompatActivity {

    @BindView(R.id.new_pwd_input) EditText new_pwd_input;
    @BindView(R.id.new_pwd_repeat_input) EditText new_pwd_repeat_input;

    @OnClick(R.id.change_pwd_button)
    public void changePassword() {
        //check if password are identical
        String newPassword = new_pwd_input.getText().toString();
        String newRepeatPassword = new_pwd_repeat_input.getText().toString();

        if(!newPassword.matches(newRepeatPassword)) {
            Toast.makeText(this, "Password yang anda ketik tidak sama!", Toast.LENGTH_SHORT).show();
        }
        else {
            //change password here

            //send some toast to show success
            Toast.makeText(this, "Password baru telah disimpan!", Toast.LENGTH_LONG).show();

            //if everything is done, bring back to home screen
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);
        ButterKnife.bind(this);
        setTitle("Ganti Password Baru");
    }
}
