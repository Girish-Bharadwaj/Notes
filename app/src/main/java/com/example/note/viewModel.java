package com.example.note;

import android.app.Application;
import android.util.Log;


import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.note.db.Note;
import com.example.note.repo.Repository;

import java.util.List;


public class viewModel extends AndroidViewModel {
    Repository repository;
    private LiveData<List<Note>> allNotes;

    public viewModel(@NonNull Application application) {
        super(application);
        repository=new Repository(application);
        allNotes=repository.getmAllNotes();

    }

    public void insert(Note note){
        repository.insert(note);
    }
    public void delete(Note note){
        repository.delete(note);
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

}
