package com.example.mipt_4_note;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class NoteAdapter extends BaseAdapter {
    Context context;
    String TextList[];
    String DateList[];
    LayoutInflater inflter;

    public NoteAdapter(Context applicationContext, String[] textList, String[] dateList) {
        this.context = context;
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
        view = inflter.inflate(R.layout.note_layout, null);
        TextView text = (TextView) view.findViewById(R.id.textView);
        TextView date = (TextView) view.findViewById(R.id.textView2);
        text.setText(TextList[i]);
        date.setText(DateList[i]);
        return view;
    }
}