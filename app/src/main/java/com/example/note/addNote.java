package com.example.note;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.note.db.Note;

public class addNote extends AppCompatActivity {
viewModel viewModel;
EditText Title,Description;
Button save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        
        Title=findViewById(R.id.title);
        Description=findViewById(R.id.description);
        save=findViewById(R.id.save);
        viewModel=new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(viewModel.class);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title=Title.getText().toString();
                String description=Description.getText().toString();
                if(TextUtils.isEmpty(title) || TextUtils.isEmpty(description)){
                    Toast.makeText(getApplicationContext(),"Please enter title and description",Toast.LENGTH_LONG).show();
                }
                else {
                    viewModel.insert(new Note(title,description));
                    Intent intent=new Intent(addNote.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}