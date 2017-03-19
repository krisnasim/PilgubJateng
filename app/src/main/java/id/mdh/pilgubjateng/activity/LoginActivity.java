package id.mdh.pilgubjateng.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.mdh.pilgubjateng.R;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.input_email) EditText input_email;
    @BindView(R.id.input_pass) EditText input_pass;
    @BindView(R.id.login_button) Button login_button;

    @OnClick(R.id.login_button)
    public void login() {
        //get value from both email and password field first
        String emailText = input_email.getText().toString();
        String passText = input_pass.getText().toString();
        //check if input is right
        if(emailText.equals("admin") && passText.equals("admin")) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Anda memasukan username atau kata sandi yang salah. Silahkan coba kembali", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
}