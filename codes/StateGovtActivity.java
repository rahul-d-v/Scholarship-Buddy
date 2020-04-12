package com.example.crawler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.lang.annotation.Documented;
import java.util.ArrayList;

public class StateGovtActivity extends AppCompatActivity {

    Button but1, but2, but3, but4, but5, but6, but7, but8, but9, but10, but11, but12;
    ArrayList<String> heading = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_govt);

        //but1 = (Button)findViewById(R.id.button1);
        but2 = (Button)findViewById(R.id.button2);
        //but3 = (Button)findViewById(R.id.button3);
        but4 = (Button)findViewById(R.id.button4);
        /*but5 = (Button)findViewById(R.id.button5);
        but6 = (Button)findViewById(R.id.button6);
        but7 = (Button)findViewById(R.id.button7);*/
        but8 = (Button)findViewById(R.id.button8);
        but9 = (Button)findViewById(R.id.button9);
        //but10 = (Button)findViewById(R.id.button10);
        but11 = (Button)findViewById(R.id.button11);
        but12 = (Button)findViewById(R.id.button12);

        new fetch().execute();

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StateGovtActivity.this, sgsDetailActivity.class);
                intent.putExtra("intVariableName", v.getId());
                startActivity(intent);
            }
        });

        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StateGovtActivity.this, sgsDetailActivity.class);
                intent.putExtra("intVariableName", v.getId());
                startActivity(intent);
            }
        });

        but8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StateGovtActivity.this, sgsDetailActivity.class);
                intent.putExtra("intVariableName", v.getId());
                startActivity(intent);
            }
        });

        but9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StateGovtActivity.this, sgsDetailActivity.class);
                intent.putExtra("intVariableName", v.getId());
                startActivity(intent);
            }
        });

        but11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StateGovtActivity.this, sgsDetailActivity.class);
                intent.putExtra("intVariableName", v.getId());
                startActivity(intent);
            }
        });

        but12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StateGovtActivity.this, sgsDetailActivity.class);
                intent.putExtra("intVariableName", v.getId());
                startActivity(intent);
            }
        });
    }


    public class fetch extends AsyncTask<Void, Void, ArrayList<String>>{

        Elements div;
        Element section0;
        Elements section;

        @Override
        protected ArrayList<String> doInBackground(Void... voids) {

            try{
                Document doc = Jsoup.connect("https://scholarships.gov.in/").get();
                div = doc.select("body > div.row-fluid > div.my-container > div.helpdesk > div.col-md-9 > div#TabbedPanels1.TabbedPanels > div.TabbedPanelsContentGroup > div.TabbedPanelsContent");
                section0 = div.get(2);
                section = section0.select("button");
            }
            catch(Exception e){e.printStackTrace();}
            for(int i=0;i<section.size();i++){
                heading.add(section.get(i).text());
            }

            return heading;
        }

        @Override
        protected void onPostExecute(ArrayList<String> strings) {
            super.onPostExecute(strings);

            //but1.setText(heading[0]);
            but2.setText(heading.get(1));
            //but3.setText(heading[2]);
            but4.setText(heading.get(3));
            //but5.setText(heading[4]);
            //but6.setText(heading[5]);
            //but7.setText(heading[6]);
            but8.setText(heading.get(7));
            but9.setText(heading.get(8));
            //but10.setText(heading[9]);
            but11.setText(heading.get(10));
            but12.setText(heading.get(11));
        }
    }
}
