package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText etuser,etpass ;
    Button btn;
    FirebaseAuth FAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etuser = findViewById(R.id.email);
        etpass = findViewById(R.id.password);
        btn = findViewById(R.id.loginbtn);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail= etuser.getText().toString();
                String pass= etpass.getText().toString();
                FAuth = FirebaseAuth.getInstance();

                FAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isComplete()){
                            Toast.makeText(MainActivity.this,"Transfered to Firebase",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(MainActivity.this, ContactsContract.Profile.class);
                        }
                    }
                });
            }
        });
    }
}