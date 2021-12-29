package com.example.gestiondesnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;


import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Bulletin> listBulletin =new ArrayList<Bulletin>();
    ArrayAdapter<Bulletin> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listBulletin .add(new Bulletin("imane","messaoui"));
        ListView list=(ListView) findViewById(R.id.clients);


        Button save=(Button) findViewById(R.id.save);
        adapter=new ArrayAdapter<Bulletin>(this,android.R.layout.simple_list_item_1,listBulletin );
        list.setAdapter(adapter);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bulletin cl = new Bulletin();
                EditText nom=(EditText) findViewById(R.id.nom);
                EditText prenom=(EditText) findViewById(R.id.prenom);
                cl.setNom(nom.getText().toString());
                cl.setPrenom(prenom.getText().toString());


                listBulletin.add(cl);

                ListView list=(ListView) findViewById(R.id.clients);
                list.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
    }

}