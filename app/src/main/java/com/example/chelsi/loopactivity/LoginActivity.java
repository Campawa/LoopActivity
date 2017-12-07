package com.example.chelsi.loopactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private static final String SHARED_PREFS_KEY = "sharedPrefsTesting";
    private EditText email;
    private EditText password;
    private Button signInButton;
    private CheckBox checkBox;
    private SharedPreferences login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.emailText);
        password = (EditText) findViewById(R.id.passwordText);
        signInButton = (Button) findViewById(R.id.button01);
        checkBox =(CheckBox) findViewById(R.id.checkbox);

        login = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = login.edit();
                if (checkBox.isChecked()){
                    editor.putString("email", email.getText().toString());
                    editor.putString("password", password.getText().toString());
                    editor.putBoolean("isChecked", checkBox.isChecked());
                    editor.commit();
                } else {
                    editor.putBoolean("isChecked", checkBox.isChecked());
                    editor.commit();
                }

                String checkEmail = "user" + email.getText().toString();
                String checkPassword = "password" + password.getText().toString();

                if (checkEmail == "user@aol.com" && checkPassword == "password1234"){
                    Intent intent1 = new Intent(LoginActivity.this, ListActivity.class);
                    intent1.putExtra("currentUser", email.getText().toString());
                    intent1.putExtra("currentPassword", password.getText().toString());
                    intent1.putExtra("testKey", SHARED_PREFS_KEY);
                    startActivity(intent1);
                }

            }
        });
    }
}
