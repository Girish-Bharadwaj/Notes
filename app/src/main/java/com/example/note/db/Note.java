package com.example.note.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey(autoGenerate = true)
    int id=0;
    @ColumnInfo(name="note")
    private String note;
    @ColumnInfo(name="description")
    private String description;
    public Note(String note ,String description){
        this.note=note;
        this.description=description;
    }

    public String getNote() {
        return note;
    }

    public String getDescription() {
        return description;
    }
}
