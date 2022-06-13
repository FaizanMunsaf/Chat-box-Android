package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class message extends AppCompatActivity {
    EditText etabc;
    Button btn;
    DatabaseReference databaseReference;
    ListView list_item;
    MylistAdapter adapter;
    List<UserModel> mylist = new ArrayList<>();
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        btn = findViewById(R.id.btn);
        etabc =findViewById(R.id.etsend);
        databaseReference = FirebaseDatabase.getInstance().getReference("user_data");
        list_item = findViewById(R.id.list);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = databaseReference.push().getKey();
                String msg = etabc.getText().toString();
                UserModel model = new UserModel(msg,id);
                databaseReference.child(id).setValue(model);
            }
        });
    }
    protected void onStart(){
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mylist.clear();
                for(DataSnapshot snapshot1: snapshot.getChildren()){
                    UserModel model = snapshot1.getValue(UserModel.class);
                    mylist.add(model);
                }
                adapter = new MylistAdapter(mylist,message.this);
                list_item.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(message.this,"Fail",Toast.LENGTH_SHORT).show();
            }
        });
    }
}