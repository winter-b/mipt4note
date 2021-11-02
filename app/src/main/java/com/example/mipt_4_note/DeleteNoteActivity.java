package com.example.mipt_4_note;

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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeleteNoteActivity {
    private String _fileName;
    private String GetIdPattern;
    public DeleteNoteActivity(String fileName){
        _fileName = fileName;
    }

    public void DeleteNote(String uniqueID, Context context){
        GetIdPattern = "\\n.*"+uniqueID+".*";
        String notes = "";
        try {
            InputStream inputStream = context.openFileInput(_fileName);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append("\n").append(receiveString);
                }
                notes = stringBuilder.toString();
                Log.d("Debug", "DeleteNote input: "+ notes);
                inputStream.close();
                String updated = notes.replaceAll(GetIdPattern, "");
                Log.d("Debug", "DeleteNote updated: "+ updated);

                try {
                    Log.i("Debug", "writing to " + "/data/data/com.example.mipt_4_note/" + _fileName);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(_fileName, Context.MODE_PRIVATE));
                    outputStreamWriter.write(updated);
                    outputStreamWriter.close();
                }
                catch (IOException e) {
                    Log.e("Exception", "File write failed: " + e.toString());
                }

            }
        }
        catch (FileNotFoundException e) {
            Log.e("Exception", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("Exception", "Can not read file: " + e.toString());
        }
    }
}
