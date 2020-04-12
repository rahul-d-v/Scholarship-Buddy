package com.example.crawler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class sgsDetailActivity extends AppCompatActivity {

    TextView text1, text2, text3, text4, text5, text6;
    int flag, flag1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sgs_detail);

        text1 = (TextView) findViewById(R.id.sgs1);
        text2 = (TextView) findViewById(R.id.sgs2);
        text3 = (TextView) findViewById(R.id.sgs3);
        text4 = (TextView) findViewById(R.id.sgs4);
        text5 = (TextView) findViewById(R.id.sgs5);
        text6 = (TextView) findViewById(R.id.sgs6);

        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("intVariableName", 0);

        if (intValue == 0) {
        } else {

            if (intValue == R.id.button2) {
                flag = 1;
                new fetch().execute(flag);
            }

            if (intValue == R.id.button4) {
                flag = 3;
                new fetch().execute(flag);
            }

            if (intValue == R.id.button8) {
                flag = 7;
                new fetch().execute(flag);
            }

            if (intValue == R.id.button9) {
                flag = 8;
                new fetch().execute(flag);
            }

            if (intValue == R.id.button11) {
                flag = 10;
                new fetch().execute(flag);
            }

            if (intValue == R.id.button12) {
                flag = 11;
                new fetch().execute(flag);
            }
        }

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag1 = 1;
                sgsDetailActivity.TaskParams paramsSet = new sgsDetailActivity.TaskParams(flag, flag1);
                new sgsDetailActivity.changeData().execute(paramsSet);
            }
        });
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag1 = 2;
                sgsDetailActivity.TaskParams paramsSet = new sgsDetailActivity.TaskParams(flag, flag1);
                new sgsDetailActivity.changeData().execute(paramsSet);
            }
        });
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag1 = 3;
                sgsDetailActivity.TaskParams paramsSet = new sgsDetailActivity.TaskParams(flag, flag1);
                new sgsDetailActivity.changeData().execute(paramsSet);
            }
        });
        text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag1 = 4;
                sgsDetailActivity.TaskParams paramsSet = new sgsDetailActivity.TaskParams(flag, flag1);
                new sgsDetailActivity.changeData().execute(paramsSet);
            }
        });
        text5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag1 = 5;
                sgsDetailActivity.TaskParams paramsSet = new sgsDetailActivity.TaskParams(flag, flag1);
                new sgsDetailActivity.changeData().execute(paramsSet);
            }
        });
        text6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag1 = 6;
                sgsDetailActivity.TaskParams paramsSet = new sgsDetailActivity.TaskParams(flag, flag1);
                new sgsDetailActivity.changeData().execute(paramsSet);
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

    private static class TaskResults {
        int size;
        String link;
        String name;

        TaskResults() {
            this.size = size;
            this.link = link;
            this.name = name;
        }
    }

    protected class fetch extends AsyncTask<Integer, Void, Integer> {

        Elements div, section1, section3, section4;
        Element section0, section2;

        @Override
        protected Integer doInBackground(Integer... integers) {

            int flag = integers[0].intValue();
            try {
                Document doc = Jsoup.connect("https://scholarships.gov.in/").get();
                div = doc.select("body > div.row-fluid > div.my-container > div.helpdesk > div.col-md-9 > div#TabbedPanels1.TabbedPanels > div.TabbedPanelsContentGroup > div.TabbedPanelsContent");
                section0 = div.get(2);// 3 TabbedPanelContent so selected 3rd => for state scheme
                section1 = section0.select("div.panel");
                section2 = section1.get(flag); //12 panel so selected according to flag i.e. selecting state    only 6 working
                section3 = section2.select("div.col-md-5");// scheme name   max17  1st blank
                section4 = section2.select("div.col-md-2"); // dates    68    first-three heading
            } catch (Exception e) {
                e.printStackTrace();
            }
            return section3.size();
        }

        @Override
        protected void onPostExecute(Integer size) {
            super.onPostExecute(size);
            switch (size) {
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

                case 5:
                    text1.setText(section3.get(1).text());
                    text2.setText(section3.get(2).text());
                    text3.setText(section3.get(3).text());
                    text4.setText(section3.get(4).text());
                    break;

                case 6:
                    text1.setText(section3.get(1).text());
                    text2.setText(section3.get(2).text());
                    text3.setText(section3.get(3).text());
                    text4.setText(section3.get(4).text());
                    text5.setText(section3.get(5).text());
                    break;

                case 7:
                    text1.setText(section3.get(1).text());
                    text2.setText(section3.get(2).text());
                    text3.setText(section3.get(3).text());
                    text4.setText(section3.get(4).text());
                    text5.setText(section3.get(5).text());
                    text6.setText(section3.get(6).text());
                    break;

                case 8:
                    text1.setText(section3.get(1).text());
                    text2.setText(section3.get(2).text());
                    text3.setText(section3.get(3).text());
                    text4.setText(section3.get(4).text());
                    text5.setText(section3.get(5).text());
                    text6.setText(section3.get(6).text());
                    break;

                case 9:
                    text1.setText(section3.get(1).text());
                    text2.setText(section3.get(2).text());
                    text3.setText(section3.get(3).text());
                    text4.setText(section3.get(4).text());
                    text5.setText(section3.get(5).text());
                    text6.setText(section3.get(6).text());
                    break;

                case 10:
                    text1.setText(section3.get(1).text());
                    text2.setText(section3.get(2).text());
                    text3.setText(section3.get(3).text());
                    text4.setText(section3.get(4).text());
                    text5.setText(section3.get(5).text());
                    text6.setText(section3.get(6).text());
                    break;

                case 11:
                    text1.setText(section3.get(1).text());
                    text2.setText(section3.get(2).text());
                    text3.setText(section3.get(3).text());
                    text4.setText(section3.get(4).text());
                    text5.setText(section3.get(5).text());
                    text6.setText(section3.get(6).text());
                    break;

                case 12:
                    text1.setText(section3.get(1).text());
                    text2.setText(section3.get(2).text());
                    text3.setText(section3.get(3).text());
                    text4.setText(section3.get(4).text());
                    text5.setText(section3.get(5).text());
                    text6.setText(section3.get(6).text());
                    break;

                case 13:
                    text1.setText(section3.get(1).text());
                    text2.setText(section3.get(2).text());
                    text3.setText(section3.get(3).text());
                    text4.setText(section3.get(4).text());
                    text5.setText(section3.get(5).text());
                    text6.setText(section3.get(6).text());
                    break;

                case 14:
                    text1.setText(section3.get(1).text());
                    text2.setText(section3.get(2).text());
                    text3.setText(section3.get(3).text());
                    text4.setText(section3.get(4).text());
                    text5.setText(section3.get(5).text());
                    text6.setText(section3.get(6).text());
                    break;

                case 15:
                    text1.setText(section3.get(1).text());
                    text2.setText(section3.get(2).text());
                    text3.setText(section3.get(3).text());
                    text4.setText(section3.get(4).text());
                    text5.setText(section3.get(5).text());
                    text6.setText(section3.get(6).text());
                    break;

                case 16:
                    text1.setText(section3.get(1).text());
                    text2.setText(section3.get(2).text());
                    text3.setText(section3.get(3).text());
                    text4.setText(section3.get(4).text());
                    text5.setText(section3.get(5).text());
                    text6.setText(section3.get(6).text());
                    break;

                case 17:
                    text1.setText(section3.get(1).text());
                    text2.setText(section3.get(2).text());
                    text3.setText(section3.get(3).text());
                    text4.setText(section3.get(4).text());
                    text5.setText(section3.get(5).text());
                    text6.setText(section3.get(6).text());
                    break;

            }
        }
    }

    protected class changeData extends AsyncTask<TaskParams, Void, Void> {

        Elements div, section1, section3, section5, section7;
        Element section0, section2, section4, section6;
        String linkHref;

        @Override
        protected Void doInBackground(TaskParams... taskParams) {

            int flag = taskParams[0].flag; //for which state
            int flag1 = taskParams[0].flag1; //for which scholarship

            try {

                Document doc = Jsoup.connect("https://scholarships.gov.in/").get();
                div = doc.select("body > div.row-fluid > div.my-container > div.helpdesk > div.col-md-9 > div#TabbedPanels1.TabbedPanels > div.TabbedPanelsContentGroup > div.TabbedPanelsContent");
                section0 = div.get(2);// 3 TabbedPanelContent so selected 1st => for central scheme
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

        protected void maxDetails() {
            String scholarshipName = "<b>" + section4.text() + "</b> ";
            switch (flag1) {
                case 1:
                    text1.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION" + section5.get(3 * flag1 + 1).text() + "\n" + "\tINSTITUTE VERIFICATION" + section5.get(3 * flag1 + 2).text() + "\n\n" + "Guidlines :\n\t" + linkHref);
                    text1.setTextColor(Color.parseColor("#5054B3"));text1.setBackgroundResource(R.color.textViewBg);
                    text2.setText(section3.get(2).text()); text2.setTextColor(Color.BLACK); text2.setBackgroundResource(R.color.textViewBgN);
                    text3.setText(section3.get(3).text()); text3.setTextColor(Color.BLACK); text3.setBackgroundResource(R.color.textViewBgN);
                    text4.setText(section3.get(4).text()); text4.setTextColor(Color.BLACK); text4.setBackgroundResource(R.color.textViewBgN);
                    text5.setText(section3.get(5).text()); text5.setTextColor(Color.BLACK); text5.setBackgroundResource(R.color.textViewBgN);
                    text6.setText(section3.get(6).text()); text6.setTextColor(Color.BLACK); text6.setBackgroundResource(R.color.textViewBgN);
                    break;

                case 2:
                    text1.setText(section3.get(1).text()); text1.setTextColor(Color.BLACK); text1.setBackgroundResource(R.color.textViewBgN);
                    text2.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION" + section5.get(3 * flag1 + 1).text() + "\n" + "\tINSTITUTE VERIFICATION" + section5.get(3 * flag1 + 2).text() + "\n\n" + "Guidlines :\n\t" + linkHref);
                    text2.setTextColor(Color.parseColor("#5054B3"));text2.setBackgroundResource(R.color.textViewBg);
                    text3.setText(section3.get(3).text()); text3.setTextColor(Color.BLACK); text3.setBackgroundResource(R.color.textViewBgN);
                    text4.setText(section3.get(4).text()); text4.setTextColor(Color.BLACK); text4.setBackgroundResource(R.color.textViewBgN);
                    text5.setText(section3.get(5).text()); text5.setTextColor(Color.BLACK); text5.setBackgroundResource(R.color.textViewBgN);
                    text6.setText(section3.get(6).text()); text6.setTextColor(Color.BLACK); text6.setBackgroundResource(R.color.textViewBgN);
                    break;

                case 3:
                    text1.setText(section3.get(1).text()); text1.setTextColor(Color.BLACK); text1.setBackgroundResource(R.color.textViewBgN);
                    text2.setText(section3.get(2).text()); text2.setTextColor(Color.BLACK); text2.setBackgroundResource(R.color.textViewBgN);
                    text3.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION" + section5.get(3 * flag1 + 1).text() + "\n" + "\tINSTITUTE VERIFICATION" + section5.get(3 * flag1 + 2).text() + "\n\n" + "Guidlines :\n\t" + linkHref);
                    text3.setTextColor(Color.parseColor("#5054B3")); text3.setBackgroundResource(R.color.textViewBg);
                    text4.setText(section3.get(4).text()); text4.setTextColor(Color.BLACK); text4.setBackgroundResource(R.color.textViewBgN);
                    text5.setText(section3.get(5).text()); text5.setTextColor(Color.BLACK); text5.setBackgroundResource(R.color.textViewBgN);
                    text6.setText(section3.get(6).text()); text6.setTextColor(Color.BLACK); text6.setBackgroundResource(R.color.textViewBgN);
                    break;

                case 4:

                    text1.setText(section3.get(1).text()); text1.setTextColor(Color.BLACK); text1.setBackgroundResource(R.color.textViewBgN);
                    text2.setText(section3.get(2).text()); text2.setTextColor(Color.BLACK); text2.setBackgroundResource(R.color.textViewBgN);
                    text3.setText(section3.get(3).text()); text3.setTextColor(Color.BLACK); text3.setBackgroundResource(R.color.textViewBgN);
                    text4.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION" + section5.get(3 * flag1 + 1).text() + "\n" + "\tINSTITUTE VERIFICATION" + section5.get(3 * flag1 + 2).text() + "\n\n" + "Guidlines :\n\t" + linkHref);
                    text4.setTextColor(Color.parseColor("#5054B3")); text4.setBackgroundResource(R.color.textViewBg);
                    text5.setText(section3.get(5).text()); text5.setTextColor(Color.BLACK); text5.setBackgroundResource(R.color.textViewBgN);
                    text6.setText(section3.get(6).text()); text6.setTextColor(Color.BLACK); text6.setBackgroundResource(R.color.textViewBgN);
                    break;

                case 5:
                    text1.setText(section3.get(1).text()); text1.setTextColor(Color.BLACK); text1.setBackgroundResource(R.color.textViewBgN);
                    text2.setText(section3.get(2).text()); text2.setTextColor(Color.BLACK); text2.setBackgroundResource(R.color.textViewBgN);
                    text3.setText(section3.get(3).text()); text3.setTextColor(Color.BLACK); text3.setBackgroundResource(R.color.textViewBgN);
                    text4.setText(section3.get(4).text()); text4.setTextColor(Color.BLACK); text4.setBackgroundResource(R.color.textViewBgN);
                    text5.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION" + section5.get(3 * flag1 + 1).text() + "\n" + "\tINSTITUTE VERIFICATION" + section5.get(3 * flag1 + 2).text() + "\n\n" + "Guidlines :\n\t" + linkHref);
                    text5.setTextColor(Color.parseColor("#5054B3")); text5.setBackgroundResource(R.color.textViewBg);
                    text6.setText(section3.get(6).text()); text6.setTextColor(Color.BLACK); text6.setBackgroundResource(R.color.textViewBgN);
                    break;

                case 6:
                    text1.setText(section3.get(1).text()); text1.setTextColor(Color.BLACK); text1.setBackgroundResource(R.color.textViewBgN);
                    text2.setText(section3.get(2).text()); text2.setTextColor(Color.BLACK); text2.setBackgroundResource(R.color.textViewBgN);
                    text3.setText(section3.get(3).text()); text3.setTextColor(Color.BLACK); text3.setBackgroundResource(R.color.textViewBgN);
                    text4.setText(section3.get(4).text()); text4.setTextColor(Color.BLACK); text4.setBackgroundResource(R.color.textViewBgN);
                    text5.setText(section3.get(5).text()); text5.setTextColor(Color.BLACK); text5.setBackgroundResource(R.color.textViewBgN);
                    text6.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION" + section5.get(3 * flag1 + 1).text() + "\n" + "\tINSTITUTE VERIFICATION" + section5.get(3 * flag1 + 2).text() + "\n\n" + "Guidlines :\n\t" + linkHref);
                    text6.setTextColor(Color.parseColor("#5054B3")); text6.setBackgroundResource(R.color.textViewBg);
                    break;
            }
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            String scholarshipName = "<b>" + section4.text() + "</b> ";

            if (section3.size() == 2) {
                text1.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION" + section5.get(3 * flag1 + 1).text() + "\n" + "\tINSTITUTE VERIFICATION" + section5.get(3 * flag1 + 2).text() + "\n\n" + "Guidlines :\n\t" + linkHref);
                text1.setTextColor(Color.parseColor("#5054B3"));
                text1.setBackgroundResource(R.color.textViewBg);
            }

            if (section3.size() == 3) {
                switch (flag1) {
                    case 1:
                        text1.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION" + section5.get(3 * flag1 + 1).text() + "\n" + "\tINSTITUTE VERIFICATION" + section5.get(3 * flag1 + 2).text() + "\n\n" + "Guidlines :\n\t" + linkHref);
                        text1.setTextColor(Color.parseColor("#5054B3")); text1.setBackgroundResource(R.color.textViewBg);
                        text2.setText(section3.get(2).text()); text2.setTextColor(Color.BLACK); text2.setBackgroundResource(R.color.textViewBgN);
                        break;

                    case 2:
                        text1.setText(section3.get(1).text()); text1.setTextColor(Color.BLACK); text1.setBackgroundResource(R.color.textViewBgN);
                        text2.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION" + section5.get(3 * flag1 + 1).text() + "\n" + "\tINSTITUTE VERIFICATION" + section5.get(3 * flag1 + 2).text() + "\n\n" + "Guidlines :\n\t" + linkHref);
                        text2.setTextColor(Color.parseColor("#5054B3")); text2.setBackgroundResource(R.color.textViewBg);
                        break;
                }
            }

            if (section3.size() == 4) {
                switch (flag1) {
                    case 1:
                        text1.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION" + section5.get(3 * flag1 + 1).text() + "\n" + "\tINSTITUTE VERIFICATION" + section5.get(3 * flag1 + 2).text() + "\n\n" + "Guidlines :\n\t" + linkHref);
                        text1.setTextColor(Color.parseColor("#5054B3")); text1.setBackgroundResource(R.color.textViewBg);
                        text2.setText(section3.get(2).text()); text2.setTextColor(Color.BLACK); text2.setBackgroundResource(R.color.textViewBgN);
                        text3.setText(section3.get(3).text()); text3.setTextColor(Color.BLACK); text3.setBackgroundResource(R.color.textViewBgN);
                        break;

                    case 2:
                        text1.setText(section3.get(1).text()); text1.setTextColor(Color.BLACK); text1.setBackgroundResource(R.color.textViewBgN);
                        text2.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION" + section5.get(3 * flag1 + 1).text() + "\n" + "\tINSTITUTE VERIFICATION" + section5.get(3 * flag1 + 2).text() + "\n\n" + "Guidlines :\n\t" + linkHref);
                        text2.setTextColor(Color.parseColor("#5054B3")); text2.setBackgroundResource(R.color.textViewBg);
                        text3.setText(section3.get(3).text()); text3.setTextColor(Color.BLACK); text3.setBackgroundResource(R.color.textViewBgN);
                        break;

                    case 3:
                        text1.setText(section3.get(1).text()); text1.setTextColor(Color.BLACK); text1.setBackgroundResource(R.color.textViewBgN);
                        text2.setText(section3.get(2).text()); text2.setTextColor(Color.BLACK); text2.setBackgroundResource(R.color.textViewBgN);
                        text3.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION" + section5.get(3 * flag1 + 1).text() + "\n" + "\tINSTITUTE VERIFICATION" + section5.get(3 * flag1 + 2).text() + "\n\n" + "Guidlines :\n\t" + linkHref);
                        text3.setTextColor(Color.parseColor("#5054B3")); text3.setBackgroundResource(R.color.textViewBg);
                        break;
                }
            }

            if (section3.size() == 5) {
                switch (flag1) {
                    case 1:
                        text1.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION" + section5.get(3 * flag1 + 1).text() + "\n" + "\tINSTITUTE VERIFICATION" + section5.get(3 * flag1 + 2).text() + "\n\n" + "Guidlines :\n\t" + linkHref);
                        text1.setTextColor(Color.parseColor("#5054B3")); text1.setBackgroundResource(R.color.textViewBg);
                        text2.setText(section3.get(2).text()); text2.setTextColor(Color.BLACK); text2.setBackgroundResource(R.color.textViewBgN);
                        text3.setText(section3.get(3).text()); text3.setTextColor(Color.BLACK); text3.setBackgroundResource(R.color.textViewBgN);
                        text4.setText(section3.get(4).text()); text4.setTextColor(Color.BLACK); text4.setBackgroundResource(R.color.textViewBgN);
                        break;

                    case 2:
                        text1.setText(section3.get(1).text()); text1.setTextColor(Color.BLACK); text1.setBackgroundResource(R.color.textViewBgN);
                        text2.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION" + section5.get(3 * flag1 + 1).text() + "\n" + "\tINSTITUTE VERIFICATION" + section5.get(3 * flag1 + 2).text() + "\n\n" + "Guidlines :\n\t" + linkHref);
                        text2.setTextColor(Color.parseColor("#5054B3")); text2.setBackgroundResource(R.color.textViewBg);
                        text3.setText(section3.get(3).text()); text3.setTextColor(Color.BLACK); text3.setBackgroundResource(R.color.textViewBgN);
                        text4.setText(section3.get(4).text()); text4.setTextColor(Color.BLACK); text4.setBackgroundResource(R.color.textViewBgN);
                        break;

                    case 3:
                        text1.setText(section3.get(1).text()); text1.setTextColor(Color.BLACK); text1.setBackgroundResource(R.color.textViewBgN);
                        text2.setText(section3.get(2).text()); text2.setTextColor(Color.BLACK); text2.setBackgroundResource(R.color.textViewBgN);
                        text3.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION" + section5.get(3 * flag1 + 1).text() + "\n" + "\tINSTITUTE VERIFICATION" + section5.get(3 * flag1 + 2).text() + "\n\n" + "Guidlines :\n\t" + linkHref);
                        text3.setTextColor(Color.parseColor("#5054B3")); text3.setBackgroundResource(R.color.textViewBg);
                        text4.setText(section3.get(4).text()); text4.setTextColor(Color.BLACK); text4.setBackgroundResource(R.color.textViewBgN);
                        break;

                    case 4:
                        text1.setText(section3.get(1).text()); text1.setTextColor(Color.BLACK); text1.setBackgroundResource(R.color.textViewBgN);
                        text2.setText(section3.get(2).text()); text2.setTextColor(Color.BLACK); text2.setBackgroundResource(R.color.textViewBgN);
                        text3.setText(section3.get(3).text()); text3.setTextColor(Color.BLACK); text2.setBackgroundResource(R.color.textViewBgN);
                        text4.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION" + section5.get(3 * flag1 + 1).text() + "\n" + "\tINSTITUTE VERIFICATION" + section5.get(3 * flag1 + 2).text() + "\n\n" + "Guidlines :\n\t" + linkHref);
                        text4.setTextColor(Color.parseColor("#5054B3")); text4.setBackgroundResource(R.color.textViewBg);
                        break;
                }
            }

            if (section3.size() == 6) {
                switch (flag1) {
                    case 1:
                        text1.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION" + section5.get(3 * flag1 + 1).text() + "\n" + "\tINSTITUTE VERIFICATION" + section5.get(3 * flag1 + 2).text() + "\n\n" + "Guidlines :\n\t" + linkHref);
                        text1.setTextColor(Color.parseColor("#5054B3")); text1.setBackgroundResource(R.color.textViewBg);
                        text2.setText(section3.get(2).text()); text2.setTextColor(Color.BLACK); text2.setBackgroundResource(R.color.textViewBgN);
                        text3.setText(section3.get(3).text()); text3.setTextColor(Color.BLACK); text3.setBackgroundResource(R.color.textViewBgN);
                        text4.setText(section3.get(4).text()); text4.setTextColor(Color.BLACK); text4.setBackgroundResource(R.color.textViewBgN);
                        text5.setText(section3.get(5).text()); text5.setTextColor(Color.BLACK); text5.setBackgroundResource(R.color.textViewBgN);
                        break;

                    case 2:
                        text1.setText(section3.get(1).text()); text1.setTextColor(Color.BLACK); text1.setBackgroundResource(R.color.textViewBgN);
                        text2.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION" + section5.get(3 * flag1 + 1).text() + "\n" + "\tINSTITUTE VERIFICATION" + section5.get(3 * flag1 + 2).text() + "\n\n" + "Guidlines :\n\t" + linkHref);
                        text2.setTextColor(Color.parseColor("#5054B3")); text2.setBackgroundResource(R.color.textViewBg);
                        text3.setText(section3.get(3).text()); text3.setTextColor(Color.BLACK); text3.setBackgroundResource(R.color.textViewBgN);
                        text4.setText(section3.get(4).text()); text4.setTextColor(Color.BLACK); text4.setBackgroundResource(R.color.textViewBgN);
                        text5.setText(section3.get(5).text()); text5.setTextColor(Color.BLACK); text5.setBackgroundResource(R.color.textViewBgN);
                        break;

                    case 3:
                        text1.setText(section3.get(1).text()); text1.setTextColor(Color.BLACK); text1.setBackgroundResource(R.color.textViewBgN);
                        text2.setText(section3.get(2).text()); text2.setTextColor(Color.BLACK); text2.setBackgroundResource(R.color.textViewBgN);
                        text3.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION" + section5.get(3 * flag1 + 1).text() + "\n" + "\tINSTITUTE VERIFICATION" + section5.get(3 * flag1 + 2).text() + "\n\n" + "Guidlines :\n\t" + linkHref);
                        text3.setTextColor(Color.parseColor("#5054B3")); text3.setBackgroundResource(R.color.textViewBg);
                        text4.setText(section3.get(4).text()); text4.setTextColor(Color.BLACK); text4.setBackgroundResource(R.color.textViewBgN);
                        text5.setText(section3.get(5).text()); text5.setTextColor(Color.BLACK); text5.setBackgroundResource(R.color.textViewBgN);
                        break;

                    case 4:
                        text1.setText(section3.get(1).text()); text1.setTextColor(Color.BLACK); text1.setBackgroundResource(R.color.textViewBgN);
                        text2.setText(section3.get(2).text()); text2.setTextColor(Color.BLACK); text2.setBackgroundResource(R.color.textViewBgN);
                        text3.setText(section3.get(3).text()); text3.setTextColor(Color.BLACK); text3.setBackgroundResource(R.color.textViewBgN);
                        text4.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION" + section5.get(3 * flag1 + 1).text() + "\n" + "\tINSTITUTE VERIFICATION" + section5.get(3 * flag1 + 2).text() + "\n\n" + "Guidlines :\n\t" + linkHref);
                        text4.setTextColor(Color.parseColor("#5054B3")); text4.setBackgroundResource(R.color.textViewBg);
                        text5.setText(section3.get(5).text()); text5.setTextColor(Color.BLACK); text5.setBackgroundResource(R.color.textViewBgN);
                        break;

                    case 5:
                        text1.setText(section3.get(1).text()); text1.setTextColor(Color.BLACK); text1.setBackgroundResource(R.color.textViewBgN);
                        text2.setText(section3.get(2).text()); text2.setTextColor(Color.BLACK); text2.setBackgroundResource(R.color.textViewBgN);
                        text3.setText(section3.get(3).text()); text3.setTextColor(Color.BLACK); text3.setBackgroundResource(R.color.textViewBgN);
                        text4.setText(section3.get(4).text()); text4.setTextColor(Color.BLACK); text4.setBackgroundResource(R.color.textViewBgN);
                        text5.setText("-> " + Html.fromHtml(scholarshipName) + "\n\n" + "\tCLOSING DATE :" + section5.get(3 * flag1).text() + "\n" + "\tDEFECTIVE VERIFICATION" + section5.get(3 * flag1 + 1).text() + "\n" + "\tINSTITUTE VERIFICATION" + section5.get(3 * flag1 + 2).text() + "\n\n" + "Guidlines :\n\t" + linkHref);
                        text5.setTextColor(Color.parseColor("#5054B3")); text5.setBackgroundResource(R.color.textViewBg);
                        break;
                }
            }

            if (section3.size() == 7) {
                maxDetails();
            }

            if (section3.size() == 8) {
                maxDetails();
            }

            if (section3.size() == 9) {
                maxDetails();
            }

            if (section3.size() == 10) {
                maxDetails();
            }

            if (section3.size() == 11) {
                maxDetails();
            }

            if (section3.size() == 12) {
                maxDetails();
            }

            if (section3.size() == 13) {
                maxDetails();
            }

            if (section3.size() == 14) {
                maxDetails();
            }

            if (section3.size() == 15) {
                maxDetails();
            }

            if (section3.size() == 16) {
                maxDetails();
            }

            if (section3.size() == 17) {
                maxDetails();
            }
        }

    }
}