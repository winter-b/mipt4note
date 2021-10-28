package com.example.mipt_4_note;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends Activity {

    private ListView simpleList;
    private String textList[];
    private String dateList[];
    private Button createButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createButton = (Button) findViewById(R.id.button);i
        EditText textBox = (EditText) findViewById(R.id.editTextTextPersonName);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String note = textBox.getText().toString();
                Date c = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
                String date = df.format(c);
                String finalString = String.format("%s;%s\n", note, date);
                writeToFile(finalString, getApplicationContext());
                textBox.setText("");
                ReadNotes();
            }
        });
        ReadNotes();
    }
    private void ReadNotes(){
        ArrayList<Note> notes = readFromFile(getApplicationContext());
        dateList = new String[notes.size()];
        textList = new String[notes.size()];
        for(int i = 0; i < notes.size(); i++){
            dateList[i] = notes.get(i).getDate();
            textList[i] = notes.get(i).getText();
        }
        simpleList = (ListView) findViewById(R.id.listView);
        NoteAdapter customAdapter = new NoteAdapter(getApplicationContext(), textList, dateList);
        simpleList.setAdapter(customAdapter);
    }
    private void writeToFile(String data, Context context) {
        try {
            String ass = getFilesDir().getPath().toString();
            Log.i("INFO", ass);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("notez.txt", Context.MODE_APPEND));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
    private ArrayList<Note> readFromFile(Context context) {

        ArrayList<Note> arr = new ArrayList<>();

        try {
            InputStream inputStream = context.openFileInput("notez.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append("\n").append(receiveString);
                    String[] str = receiveString.split("[;]");
                    arr.add(new Note(str[0], str[1]));
                }

                inputStream.close();

            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
        return arr;
    }
}