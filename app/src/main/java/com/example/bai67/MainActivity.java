package com.example.bai67;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    Button read;
    TextView noidung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        read = findViewById(R.id.btnRead);
        noidung = findViewById(R.id.tv1);

        read.setOnClickListener(view -> xuly());
    }
    public void xuly(){
        InputStream in = this.getResources().openRawResource(R.raw.anything);
        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder builder = new StringBuilder();
        String data;

            try {
                while ((data = bufferedReader.readLine())!=null){
                        builder.append(data);
                }
                in.close();
                noidung.setText(builder.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }


    }
}