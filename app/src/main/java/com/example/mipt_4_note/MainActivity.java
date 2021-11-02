package com.example.mipt_4_note;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends Activity {
    private String _fileName = "betterNotes6.txt";
    private AddNoteActivity addNoteActivity = new AddNoteActivity(_fileName);
    private GetNoteActivity getNoteActivity = new GetNoteActivity(_fileName);
    private Button createButton;
    private Button refreshButton;
    private ListView simpleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createButton = (Button) findViewById(R.id.button);
        refreshButton = (Button) findViewById(R.id.buttonRefresh);
        simpleList = (ListView) findViewById(R.id.listView);
        EditText textBox = (EditText) findViewById(R.id.editTextTextPersonName);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String note = textBox.getText().toString();
                Date c = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault());
                String date = df.format(c);
                String finalString = String.format("%s;%s\n", note, date);
                String dir = getFilesDir().getPath().toString();
                addNoteActivity.writeToFile(finalString, getApplicationContext(), dir);
                textBox.setText("");


                getNoteActivity.ReadNotes(  getApplicationContext(), simpleList);
            }
        });
        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNoteActivity.ReadNotes(  getApplicationContext(), simpleList);
            }
        });

        getNoteActivity.ReadNotes(getApplicationContext(), simpleList);
    }

}