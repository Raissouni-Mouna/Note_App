package com.example.note_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn ;
    Spinner spn ;
    EditText Note_edit;
    ListView listView ;
    TextView TextMoyenne ;

    Note note_module;
    ArrayAdapter<Note> arrayAdapter ;
    ArrayList<Note> buletin = new ArrayList<Note>();
    boolean Math = false;
    boolean Informatique = false;
    boolean Pyhsique = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.saisir);
        spn = (Spinner) findViewById(R.id.spinner);
        listView =(ListView)findViewById(R.id.listView);
        Note_edit= findViewById(R.id.Note_edit);
        TextMoyenne= findViewById(R.id.TextMoyenne);
    }
    public void select(View view){
        Double Moyenne = Double.valueOf(0);
        String note_m = Note_edit.getText().toString();
        double Note = Double.parseDouble(note_m);
        String text = spn.getSelectedItem().toString();
        note_module = new Note(text, Note);


        if(!buletin.contains(note_module)) {
            buletin.add(note_module);
            Toast.makeText(getApplicationContext(), "la note est ajouter ", Toast.LENGTH_SHORT).show();
        }
    else {
        Toast.makeText(getApplicationContext(),"la note est deja saisie ",Toast.LENGTH_SHORT).show();
    }


        arrayAdapter = new ArrayAdapter<Note>(this, android.R.layout.simple_list_item_1 , buletin);
        listView.setAdapter(arrayAdapter);

        for(int i = 0; i<buletin.size();i++){
            Moyenne += buletin.get(i).getNote();
        }
        Moyenne = Moyenne / buletin.size();
        TextMoyenne.setText(Moyenne.toString());


    }
}