
package com.example.projectseminar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.example.projectseminar.databinding.ActivityWordBinding;

public class wordActivity extends AppCompatActivity {

    ActivityWordBinding binding;
    String sen = "";
    int space, vowels, consonants, digits, words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =ActivityWordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // Set an OnClickListener for the button
        binding.btnCalculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View view) {
                if (binding.edtSen.getText().toString().trim().isEmpty()) {
                    Toast.makeText(wordActivity.this, "Enter the Value", Toast.LENGTH_SHORT).show();
                } else {
                    sen = "";
                    sen = binding.edtSen.getText().toString().trim();
                    logic(sen);
                }
                hidesoftkey(wordActivity.this);
            }
        });
    }
    private void logic(String sen) {
        space = 0;
        vowels = 0;
        consonants = 0;
        digits = 0;
        words = 0;
        sen = sen.toLowerCase();
        for (int i = 0; i < sen.length(); i++) {
            char ch = sen.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                ++vowels;
            } else if (ch > 'a' && ch <= 'z') {
                ++consonants;
            } else if (ch >= '0' && ch <= '9') {
                ++digits;
            } else if (ch >= ' ') {
                space++;
            }
            words = space + 1;
        }
        binding.tvResult.setText(
                "\n  Total Vowels: " + vowels + "\n Total Consonants: " + consonants +
                        "\nTotal Digits: " + digits + "\nTotal Space: " + space + "\nTotal Words: " + words
        );
    }



    public static void hidesoftkey(Activity activity){
        InputMethodManager inputMethodManager = (InputMethodManager)activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(),0);
    }
}




