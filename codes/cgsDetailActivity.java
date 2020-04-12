package com.example.crawler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.common.util.Strings;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class cgsDetailActivity extends AppCompatActivity {

    TextView text1, text2, text3;
    int flag = 0, flag1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgs_detail);

        text1 = (TextView) findViewById(R.id.cgs1);
        text2 = (TextView) findViewById(R.id.cgs2);
        text3 = (TextView) findViewById(R.id.cgs3);

        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("intVariableName", 0);

        if (intValue == 0) {
        } else {
            if (intValue == R.id.button1) {
                flag = 0;
                new fetch().execute(flag);
            }

            if (intValue == R.id.button2) {
                flag = 1;
                new fetch().execute(flag);
            }

            if (intValue == R.id.button3) {
                flag = 2;
                new fetch().execute(flag);
            }

            if (intValue == R.id.button4) {
                flag = 3;
                new fetch().execute(flag);
            }

            if (intValue == R.id.button5) {
                flag = 4;
                new fetch().execute(flag);
            }

            if (intValue == R.id.button6) {
                flag = 5;
                new fetch().execute(flag);
            }

            if (intValue == R.id.button7) {
                flag = 6;
                new fetch().execute(flag);
            }

            /*if(intValue == R.id.button8){
                flag = 7;
                new fetch().execute(flag);
            }*/

            if (intValue == R.id.button9) {
                flag = 8;
                new fetch().execute(flag);
            }
        }

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag1 = 1;
                TaskParams paramsSet = new TaskParams(flag, flag1);
                new changeData().execute(paramsSet);
            }
        });

        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag1 = 2;
                TaskParams paramsSet = new TaskParams(flag, flag1);
                new changeData().execute(paramsSet);
            }
        });

        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag1 = 3;
                TaskParams paramsSet = new TaskParams(flag, flag1);
                new changeData().execute(paramsSet);
            }
        });


    }

    private static class TaskParams {
        int flag, flag1;

        TaskParams(int flag, int flag1) {
            this.flag = flag;
            this.flag1 = flag1;
        }
    }

    protected class fetch extends AsyncTask<Integer, Void, Void>{

        Elements div, section1, section3, section4;
        Element section0, section2;

        @Override
        protected Void doInBackground(Integer... integers) {

            int flag = integers[0].intValue();
            try {

                Document doc = Jsoup.connect("https://scholarships.gov.in/").get();
                div = doc.select("body > div.row-fluid > div.my-container > div.helpdesk > div.col-md-9 > div#TabbedPanels1.TabbedPanels > div.TabbedPanelsContentGroup > div.TabbedPanelsContent");
                section0 = div.get(0);// 3 TabbedPanelContent so selected 1st => for central scheme
                section1 = section0.select("div.panel");
                section2 = section1.get(flag); //9 panel so selected 1st
                section3 = section2.select("div.col-md-5");// scheme name   4  1st blank
                section4 = section2.select("div.col-md-2"); // dates    12    first-three heading

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            switch (section3.size()) {
                case 2:
                    text1.setText(section3.get(1).text());
                    break;

                case 3:
                    text1.setText(section3.get(1).text());
                    text2.setText(section3.get(2).text());
                    break;

                case 4:
                    text1.setText(section3.get(1).text());
                    text2.setText(section3.get(2).text());
                    text3.setText(section3.get(3).text());
                    break;
            }
        }
    }

    protected class changeData extends AsyncTask<TaskParams, Void, Void>{


        Elements div;
        Element section0;
        Elements section1, section7;
        Element section2, section6;
        Elements section3;
        Element section4;
        Elements section5;

        String linkHref;
        @Override
        protected Void doInBackground(TaskParams... taskParams) {

            int flag = taskParams[0].flag; //for which type of scholarship
            int flag1 = taskParams[0].flag1; //for which scholarship

            try {

                Document doc = Jsoup.connect("https://scholarships.gov.in/").get();
                div = doc.select("body > div.row-fluid > div.my-container > div.helpdesk > div.col-md-9 > div#TabbedPanels1.TabbedPanels > div.TabbedPanelsContentGroup > div.TabbedPanelsContent");
                section0 = div.get(0);// 3 TabbedPanelContent so selected 1st => for central scheme
                section1 = section0.select("div.panel");
                section2 = section1.get(flag); //9 panel, tells which button is pressed
                section3 = section2.select("div.col-md-5");// scheme name   max4  1st blank
                section4 = section3.get(flag1); //selecting scholarship
                section5 = section2.select("div.col-md-2"); // dates    12    first-three heading
                section6 = section2.select("div.col-md-1").get(flag1 * 3 + 1);
                section7 = section6.select("a");

                linkHref = "https://scholarships.gov.in" + section7.attr("href");

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            String scholarshipName = "<b>" + section4.text() + "</b> ";

            if (section3.size() == 2) {
                text1.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION : " + section5.get(3*flag1+1).text() + "\n" + "\tINSTITUTE VERIFICATION : " + section5.get(3*flag1+2).text() + "\n\n" + "Guidlines :\t" + linkHref);
                text1.setTextColor(Color.parseColor("#5054B3"));
                text1.setBackgroundResource(R.color.textViewBg);
            }
            if (section3.size() == 3) {
                switch (flag1) {
                    case 1:
                        text1.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION : " + section5.get(3*flag1+1).text() + "\n" + "\tINSTITUTE VERIFICATION : " + section5.get(3*flag1+2).text() + "\n\n" + "Guidlines :\t" + linkHref);
                        text1.setTextColor(Color.parseColor("#5054B3"));
                        text1.setBackgroundResource(R.color.textViewBg);
                        text2.setText(section3.get(2).text());
                        text2.setTextColor(Color.BLACK);
                        text2.setBackgroundResource(R.color.textViewBgN);
                        break;

                    case 2:
                        text1.setText(section3.get(1).text());
                        text1.setTextColor(Color.BLACK);
                        text1.setBackgroundResource(R.color.textViewBgN);

                        text2.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION : " +section5.get(3*flag1+1).text() + "\n" + "\tINSTITUTE VERIFICATION : " + section5.get(3*flag1+2).text() + "\n\n" + "Guidlines :\t" + linkHref);
                        text2.setTextColor(Color.parseColor("#5054B3"));
                        text2.setBackgroundResource(R.color.textViewBg);

                        break;
                }
            }

            if (section3.size() == 4) {
                switch (flag1) {
                    case 1:
                        text1.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION : " + section5.get(3*flag1+1).text() + "\n" + "\tINSTITUTE VERIFICATION : " + section5.get(3*flag1+2).text() + "\n\n" + "Guidlines :\t" + linkHref);
                        text1.setTextColor(Color.parseColor("#5054B3"));
                        text1.setBackgroundResource(R.color.textViewBg);

                        text2.setText(section3.get(2).text());
                        text2.setTextColor(Color.BLACK);
                        text2.setBackgroundResource(R.color.textViewBgN);

                        text3.setText(section3.get(3).text());
                        text3.setTextColor(Color.BLACK);
                        text3.setBackgroundResource(R.color.textViewBgN);

                        break;

                    case 2:
                        text1.setText(section3.get(1).text());
                        text1.setTextColor(Color.BLACK);
                        text1.setBackgroundResource(R.color.textViewBgN);

                        text2.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION : " + section5.get(3*flag1+1).text() + "\n" + "\tINSTITUTE VERIFICATION : " + section5.get(3*flag1+2).text() + "\n\n" + "Guidlines :\t" + linkHref);
                        text2.setTextColor(Color.parseColor("#5054B3"));
                        text2.setBackgroundResource(R.color.textViewBg);

                        text3.setText(section3.get(3).text());
                        text3.setTextColor(Color.BLACK);
                        text3.setBackgroundResource(R.color.textViewBgN);

                        break;

                    case 3:
                        text1.setText(section3.get(1).text());
                        text1.setTextColor(Color.BLACK);
                        text1.setBackgroundResource(R.color.textViewBgN);

                        text2.setText(section3.get(2).text());
                        text2.setTextColor(Color.BLACK);
                        text2.setBackgroundResource(R.color.textViewBgN);

                        text3.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION : " + section5.get(3*flag1+1).text() + "\n" + "\tINSTITUTE VERIFICATION : " + section5.get(3*flag1+2).text() + "\n\n" + "Guidlines :\t" + linkHref);
                        text3.setTextColor(Color.parseColor("#5054B3"));
                        text3.setBackgroundResource(R.color.textViewBg);

                        break;
                }
            }
        }
    }
}


