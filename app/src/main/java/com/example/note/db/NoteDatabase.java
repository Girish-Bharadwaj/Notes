package com.example.note.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;



@Database(entities = {Note.class},version = 1,exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {
    public abstract NoteDao noteDao();
    public static NoteDatabase getDataBase;
    public static NoteDatabase getDataBase(Context context){
        if(getDataBase==null){
            synchronized (NoteDatabase.class){
                getDataBase= Room.databaseBuilder(context,NoteDatabase.class,"note_table").fallbackToDestructiveMigration().build();

            }
        }
        return getDataBase;
    }
}
