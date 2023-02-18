package com.example.loginactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText username, password, dob, country, phone, address, email;
    RadioGroup gender;
    Button register, cancel;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        dob = findViewById(R.id.dob);
        country = findViewById(R.id.country);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);
        email = findViewById(R.id.email);
        gender = findViewById(R.id.gender);
        register = findViewById(R.id.register);
        cancel = findViewById(R.id.cancel);

        preferences = getSharedPreferences("Userinfo", 0);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                String dobValue = dob.getText().toString();
                String countryValue = country.getText().toString();
                String phoneValue = phone.getText().toString();
                String addressValue = address.getText().toString();
                String emailValue = email.getText().toString();
                RadioButton checkBtn = findViewById(gender.getCheckedRadioButtonId());
                String genderValue = checkBtn.getText().toString();

                if (usernameValue.length()>1) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("username", usernameValue);
                    editor.putString("password", passwordValue);
                    editor.putString("dob", dobValue);
                    editor.putString("country", countryValue);
                    editor.putString("phone", phoneValue);
                    editor.putString("address", addressValue);
                    editor.putString("email", emailValue);
                    editor.putString("gender", genderValue);
                    editor.apply();
                    Toast.makeText(RegisterActivity.this, "User Registered", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(RegisterActivity.this, "Enter Value in  the Fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        cancel.setOnClickListener((view) ->{
            emptyField();

        });
    }

    public void emptyField(){
        username.setText("");
        password.setText("");
        dob.setText("");
        country.setText("");
        address.setText("");
        email.setText("");
        phone.setText("");


    }
}