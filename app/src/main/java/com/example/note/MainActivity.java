package com.example.note;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.note.db.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity implements deleteNote {
RecyclerView recyclerView;
viewModel viewModel;
FloatingActionButton fb;
String KEY="hello";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView2);
        fb=findViewById(R.id.floatingActionButton);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter adapter=new adapter(this,this);
        recyclerView.setAdapter(adapter);
        String message="HI I am girish";
        viewModel=new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(viewModel.class);
        viewModel.getAllNotes().observe(this, notes -> {
            if(notes!=null)
            {
                adapter.setmAllNotes(notes);
            }
        });
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,addNote.class);
                intent.putExtra(KEY,message);
                startActivity(intent);

            }
        });
    }
    @Override
    public void deletenote(Note note) {
        viewModel.delete(note);
    }

}