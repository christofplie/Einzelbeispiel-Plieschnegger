package com.example.einzelbeispielplieschnegger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calc() {
        String matNr = "12007599";
        ArrayList<Integer> arrayList = new ArrayList<>();

        if (matNr.length() != 8) {
            System.out.println("Ungültige Matrikelnummer");
        } else {

            for (int i = 0; i < 8; i++) {
                arrayList.add(Character.getNumericValue(matNr.charAt(i)));
            }

            int num = 0;
            int count = 0;

            for (int a = 2; a <= 4; a++) {

                for (int i = 0; i < arrayList.size(); i++) {

                    if (count == 0 && (arrayList.get(i) == 5 || arrayList.get(i) == 7)) {
                        num = arrayList.get(i);

                        for (int k = 0; k < arrayList.size(); k++) {
                            if (arrayList.get(k) == num && k > i) {
                                System.out.println(arrayList.get(i) + " + " + arrayList.get(k) + " -> " + " Position " + i + " Position " + k + " Divisor " + num);
                            }
                        }
                        num = 0;
                    } else if (arrayList.get(i) != 0 && arrayList.get(i) % a == 0) {
                        for (int j = 0; j < arrayList.size(); j++) {
                            if (arrayList.get(j) != 0 && arrayList.get(j) % a == 0 && j > i) {
                                System.out.println(arrayList.get(i) + " + " + arrayList.get(j) + " -> " + " Position " + i + " Position " + j + " Divisor " + a);
                            }
                        }
                    }
                }
                count++;
            }
        }
    }
}
