package com.example.vehiclebuyingapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.vehiclebuyingapp.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText RegisterEmail, RegisterPassword;
    private Button btnRegister;
    private TextView ViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RegisterEmail = findViewById(R.id.RegisterEmail);
        RegisterPassword = findViewById(R.id.RegisterPassword);
        btnRegister = findViewById(R.id.btnRegister);
        ViewLogin = findViewById(R.id.ViewLogin);
    }
    public void reRegister(View v){
        String email = RegisterEmail.getText().toString().trim();
        String password = RegisterPassword.getText().toString().trim();

        // Simple validation
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(RegisterActivity.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
        } else {
            // Register the user (you can implement actual registration logic here)
            Toast.makeText(RegisterActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();

            // Navigate to the login page
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public void viewLogin(View v){
        // Navigate to the login page
        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}