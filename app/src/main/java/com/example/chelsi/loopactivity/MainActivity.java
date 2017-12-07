package com.example.chelsi.loopactivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView01);
    }

    private class Main extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected Integer doInBackground(Integer[] value) {


            for (int i= 0; i<=100000; i++){
                 execute(value);
                System.out.println(i);
            }
            publishProgress(value);
            return null;
        }


        @Override
        protected void onProgressUpdate(Integer... progress) {
            textView.setText("Loops Completed: " + progress);

        }

        @Override
        protected void onPostExecute(Integer result) {
            textView.setText("Loops Completed: " + result);
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);

        }
    }
}
