package com.example.mipt_4_note;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class AddNoteActivity {
    private String _fileName;
    public AddNoteActivity(String fileName){
        _fileName = fileName;
    }
    public void writeToFile(String data, Context context, String fileDir) {
        try {
            Log.i("Info", "writing to " + fileDir + _fileName);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(_fileName, Context.MODE_APPEND));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

}
