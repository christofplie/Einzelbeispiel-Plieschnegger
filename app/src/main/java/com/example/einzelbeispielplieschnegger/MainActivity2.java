package com.example.einzelbeispielplieschnegger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;



public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void firstPage(View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }

    public void serverAbfrageClick(View view){
        new ServerAbfrage().execute();
    }

    private class ServerAbfrage extends AsyncTask<Void, Void, Void> {

        EditText matNr = findViewById(R.id.inputMatnr2);
        TextView resultField = findViewById(R.id.serverAbfrage);
        String abfrage ="";

        @Override
        protected Void doInBackground(Void... voids){

            try {
                Socket socket = new Socket("se2-isys.aau.at",53212);

                BufferedWriter outWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                outWriter.write(matNr.getText().toString());
                outWriter.newLine();
                outWriter.flush();

                BufferedReader inReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                abfrage = inReader.readLine();

            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }

        @Override
        protected void onPostExecute(Void newVoid){
            super.onPostExecute(newVoid);
            resultField.setText(abfrage);
        }

    }

}