package id.mdh.pilgubjateng.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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

    private boolean firstLogin = false;

    @OnClick(R.id.login_button)
    public void login() {
        //get value from both email and password field first
        String emailText = input_email.getText().toString();
        String passText = input_pass.getText().toString();
        //check if input is right
        if(emailText.equals("10101") && passText.equals("admin")) {
            //clean the field first
            input_email.setText("");
            input_pass.setText("");

//            // Check if no view has focus:
//            View view = this.getCurrentFocus();
//            if (view != null) {
//                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//            }

            //prompt to change password if login for first time
            if(firstLogin) {
                Intent intent = new Intent(this, NewPasswordActivity.class);
                startActivity(intent);
                finish();
            } else {
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
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
