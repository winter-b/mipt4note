package com.example.mipt_4_note;


public class Note {
    private String Text;
    private String Date;

    public Note(String text, String date){
        this.Text = text;
        this.Date = date;
    }
    public String getText() {
        return Text;
    }

    public void setText(String text) {
        this.Text = text;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }
}
