package com.example.note.repo;

import android.app.Application;
import android.os.AsyncTask;


import androidx.lifecycle.LiveData;


import com.example.note.db.Note;
import com.example.note.db.NoteDao;
import com.example.note.db.NoteDatabase;

import java.util.List;

public class Repository {
    NoteDao noteDao;
    LiveData<List<Note>> mAllNotes;

    public Repository(Application application){
        NoteDatabase db=NoteDatabase.getDataBase(application);
        noteDao=db.noteDao();
        mAllNotes=noteDao.getAllNotes();

    }


    public LiveData<List<Note>> getmAllNotes(){return mAllNotes;}
    public void insert(Note note){
        new insertAsyncTask(noteDao).execute(note);
    }
    public void delete(Note note){new deleteAsyncTask(noteDao).execute(note);}
    static class  insertAsyncTask extends AsyncTask<Note,Void,Void>{
        private NoteDao noteDao;
        insertAsyncTask(NoteDao dao)
        {
            noteDao=dao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }
    static class  deleteAsyncTask extends AsyncTask<Note,Void,Void>{
        private NoteDao noteDao;
        deleteAsyncTask(NoteDao dao)
        {
            noteDao=dao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }
}

