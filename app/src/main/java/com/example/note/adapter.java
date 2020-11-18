package com.example.note;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.note.db.Note;
import java.util.List;

public class adapter extends RecyclerView.Adapter<viewholder> {
    List<Note> mAllNotes;
    Context context;
    deleteNote deleteNote;
    public adapter(Context context,deleteNote deleteNote) {
        this.context = context;
        this.deleteNote=deleteNote;

    }

    public void setmAllNotes(List<Note> notes) {
        mAllNotes = notes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view, parent, false);
        viewholder viewholder = new viewholder(view);
        viewholder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteNote.deletenote(mAllNotes.get(viewholder.getAdapterPosition()));
            }
        });
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        if (mAllNotes != null) {
            Log.d("Ironman", "binded view");
            Note currentNote = mAllNotes.get(position);
            holder.textView.setText(currentNote.getNote());
            holder.Desc.setText(currentNote.getDescription());
        }
    }

    @Override
    public int getItemCount() {
        if (mAllNotes != null) {
            return mAllNotes.size();
        } else {
            return 0;
        }
    }
}
interface deleteNote{
    public default void deletenote(Note note){

    }
}
class viewholder extends RecyclerView.ViewHolder{
TextView textView,Desc;
Button button;
    public viewholder(@NonNull View itemView) {
        super(itemView);
        textView=itemView.findViewById(R.id.text);
        button=itemView.findViewById(R.id.buttonimg);
        Desc=itemView.findViewById(R.id.text2);
    }
}