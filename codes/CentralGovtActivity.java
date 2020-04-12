package com.example.crawler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class CentralGovtActivity extends AppCompatActivity {

    Button but1, but2, but3, but4, but5, but6, but7, but8, but9;
    ArrayList<String> heading = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_govt);

        but1 = (Button)findViewById(R.id.button1);
        but2 = (Button)findViewById(R.id.button2);
        but3 = (Button)findViewById(R.id.button3);
        but4 = (Button)findViewById(R.id.button4);
        but5 = (Button)findViewById(R.id.button5);
        but6 = (Button)findViewById(R.id.button6);
        but7 = (Button)findViewById(R.id.button7);
        //but8 = (Button)findViewById(R.id.button8);
        but9 = (Button)findViewById(R.id.button9);

        new fetch().execute();

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CentralGovtActivity.this, cgsDetailActivity.class);
                intent.putExtra("intVariableName", v.getId());
                startActivity(intent);
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CentralGovtActivity.this, cgsDetailActivity.class);
                intent.putExtra("intVariableName", v.getId());
                startActivity(intent);
            }
        });
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CentralGovtActivity.this, cgsDetailActivity.class);
                intent.putExtra("intVariableName", v.getId());
                startActivity(intent);
            }
        });
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CentralGovtActivity.this, cgsDetailActivity.class);
                intent.putExtra("intVariableName", v.getId());
                startActivity(intent);
            }
        });
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CentralGovtActivity.this, cgsDetailActivity.class);
                intent.putExtra("intVariableName", v.getId());
                startActivity(intent);
            }
        });
        but6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CentralGovtActivity.this, cgsDetailActivity.class);
                intent.putExtra("intVariableName", v.getId());
                startActivity(intent);
            }
        });
        but7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CentralGovtActivity.this, cgsDetailActivity.class);
                intent.putExtra("intVariableName", v.getId());
                startActivity(intent);

            }
        });
        /*but8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CentralGovtActivity.this, cgsDetailActivity.class);
                intent.putExtra("intVariableName", v.getId());
                startActivity(intent);
            }
        });*/
        but9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CentralGovtActivity.this, cgsDetailActivity.class);
                intent.putExtra("intVariableName", v.getId());
                startActivity(intent);
            }
        });
    }


    public class fetch extends AsyncTask<Void, Void, ArrayList<String>> {

        Elements div;
        //Elements h1;
        Element section0;
        Elements section;
        Elements section1;
        Elements section2;
        Elements section3;
        Elements section4;

        @Override
        protected ArrayList<String> doInBackground(Void... voids) {

            try {

                Document doc = Jsoup.connect("https://scholarships.gov.in/").get();
                div = doc.select("body > div.row-fluid > div.my-container > div.helpdesk > div.col-md-9 > div#TabbedPanels1.TabbedPanels > div.TabbedPanelsContentGroup > div.TabbedPanelsContent");
                section0 = div.get(0);
                section = section0.select("button");
                //section1 = section.get(0);
                for (int i = 0; i < section.size(); i++) {
                    heading.add(section.get(i).text());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return heading;
        }

        @Override
        protected void onPostExecute(ArrayList<String> strings) {
            super.onPostExecute(strings);

            //textF1.setText(div.text());
            //textF2.setText(section1.text());
            but1.setText(heading.get(0));
            but2.setText(heading.get(1));
            but3.setText(heading.get(2));
            but4.setText(heading.get(3));
            but5.setText(heading.get(4));
            but6.setText(heading.get(5));
            but7.setText(heading.get(6));
            // but8.setText(heading[7]);
            but9.setText(heading.get(7));
        }
    }
}