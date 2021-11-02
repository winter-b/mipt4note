package com.example.mipt_4_note;

import android.content.Context;
import android.util.Log;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GetNoteActivity {
    private String textList[];
    private String dateList[];
    private String _fileName;
    public GetNoteActivity(String fileName){
        _fileName = fileName;
    }
    public void ReadNotes(Context context, ListView listView){
        ArrayList<Note> notes = readFromFile(context);
        dateList = new String[notes.size()];
        textList = new String[notes.size()];
        for(int i = 0; i < notes.size(); i++){
            dateList[i] = notes.get(i).getDate();
            textList[i] = notes.get(i).getText();
        }
        NoteAdapter customAdapter = new NoteAdapter(context, textList, dateList);
        listView.setAdapter(customAdapter);
    }
    private ArrayList<Note> readFromFile(Context context) {

        ArrayList<Note> arr = new ArrayList<>();

        try {
            InputStream inputStream = context.openFileInput(_fileName);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null) {
                    if(!receiveString.equals("")) {
                        stringBuilder.append("\n").append(receiveString);
                        Log.d("Debug", "readFromFile: " + receiveString);
                        String[] str = receiveString.split("[;]");
                        arr.add(new Note(str[0], str[1]));
                    }
                }

                inputStream.close();

            }
        }
        catch (FileNotFoundException e) {
            Log.e("Exception", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("Exception", "Can not read file: " + e.toString());
        }
        return arr;
    }

}
