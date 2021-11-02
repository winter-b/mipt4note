package com.example.mipt_4_note;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class NoteAdapter extends BaseAdapter {
    private DeleteNoteActivity deleteNoteActivity = new DeleteNoteActivity("betterNotes6.txt");
    Context context;
    String TextList[];
    String DateList[];
    LayoutInflater inflter;

    public NoteAdapter(Context applicationContext, String[] textList, String[] dateList) {
        this.context = applicationContext;
        this.TextList = textList;
        this.DateList = dateList;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return TextList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.note_layout, viewGroup.findViewById(R.id.listView), false);
        TextView text = (TextView) view.findViewById(R.id.textView);
        TextView date = (TextView) view.findViewById(R.id.textView2);
        Button button = (Button) view.findViewById(R.id.buttonDelete);
        text.setText(TextList[i]);
        date.setText(DateList[i]);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = date.getText().toString();
                Log.d("debug", "onClick: "+id);
                deleteNoteActivity.DeleteNote(id, context);
            }
        });

        return view;
    }
}