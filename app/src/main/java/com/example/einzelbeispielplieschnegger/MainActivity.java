package com.example.einzelbeispielplieschnegger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calc(View view) {
        EditText input = findViewById(R.id.inputMatnr);
        TextView resultField = findViewById(R.id.resultField);
        StringBuilder result = new StringBuilder();

        ArrayList<Integer> matrNr = new ArrayList<>();

        if (input.length() != 8) {
            resultField.setText("Ungültige Matrikelnummer");
        } else {

            for (int i = 0; i < 8; i++) {
                matrNr.add(Character.getNumericValue(input.getText().charAt(i)));
            }

            for (int a = 2; a <= 9; a++) {

                for (int i = 0; i < matrNr.size(); i++) {

                    if (matrNr.get(i) != 0 && matrNr.get(i) % a == 0) {

                        for (int j = 0; j < matrNr.size(); j++) {

                            if (matrNr.get(j) != 0 && matrNr.get(j) % a == 0 && j > i) {
                                result.append(matrNr.get(i) + " + " + matrNr.get(j) + " -> " + " Position " + i + " Position " + j + " Divisor " + a + "\n");
                            }
                        }
                    }
                }
            }
            resultField.setText(result);
        }
    }
}
