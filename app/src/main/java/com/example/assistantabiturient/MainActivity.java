package com.example.assistantabiturient;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.assistantabiturient.Class.FacultiesTusur;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Singleton singleton;
    TextView textView;
    TextView txtTPUview;
    TextView txtTGUview;
    TextView txtFIO;
    final String[] numberOf = {""};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtFIO=(TextView)findViewById(R.id.textViewFIO);
        singleton = Singleton.getInstance();
        txtFIO.setText(singleton.FIO);
        FacultiesTusur Tusur = singleton.list.get(isTrueCheck(singleton.list.size(),0));
        FacultiesTusur Tgu = singleton.list2.get(isTrueCheck(singleton.list2.size(),1));
        FacultiesTusur Tpu = singleton.list3.get(isTrueCheck(singleton.list3.size(),2));
        textView = (TextView)findViewById(R.id.textTusur);
        txtTPUview = (TextView)findViewById(R.id.textTPU);
        txtTGUview =(TextView)findViewById(R.id.textTGU);
        getPositionHtml(Tusur.getLinkFaculties(),0);
        getPositionHtml(Tgu.getLinkFaculties(),1);
        getPositionHtml(Tpu.getLinkFaculties(),2);
    }
    private int isTrueCheck(int size,int univer){
        int indexTrue = 0;
        for (int i = 0; i <size ; i++){
            if (singleton.checkBoxes[univer][i] == true) indexTrue = i;
        }
        return indexTrue;
    }
    private void getPositionHtml(final String site,int univer){

        final int[] i = {0};
        final Document[] doc = new Document[1];

        switch (univer){
            case 0:{//ТУСУР
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            doc[0] = (Document) Jsoup.connect(site).get();
                            while (true) {
                                try {
                                    Element listNews = doc[0].select(".entered").get(i[0]).child(1);
                                    if (listNews.text().equals(singleton.FIO)) {
                                        Element element = doc[0].select(".entered").get(i[0]).child(0);
                                        numberOf[0] = element.text();
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                textView.setText("Позиция на факультете ТУСУР - " + numberOf[0]);
                                            }
                                        });
                                        break;
                                    }
                                    i[0]++;
                                } catch (Exception ex) {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            textView.setText(textView.getText()+" вас нет в списке");
                                        }
                                    });
                                    break;
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
            }
            case 1:{//ТГУ
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            doc[0] = Jsoup.connect(site).get();
                            final Element listNews = doc[0].getElementById("mytbody");

                            String fio;
                            while (true) {
                                try{
                                    fio = listNews.child(i[0]).child(1).text();
                                    if (fio.equals(singleton.FIO)) {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                txtTGUview.setText(txtTGUview.getText()+" "+ listNews.child(i[0]).child(0).text());
                                            }
                                        });
                                        break;
                                    }
                                    i[0]++;
                                }catch (Exception t){
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            txtTGUview.setText(txtTGUview.getText()+" "+"Вы не найдены в списках");
                                        }
                                    });

                                    break;
                                }

                            }
                        } catch (IOException e) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    txtTGUview.setText(txtTGUview.getText()+" "+"проблемы с соединением");
                                }
                            });
                            e.printStackTrace();
                        }

                    }
                }).start();
                break;
            }
            case 2:{//ТПУ
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            doc[0] = (Document)Jsoup.connect(site).get();
                            Element num = doc[0].select("b").get(3);
                            int number = Integer.parseInt(num.text())/20;
                            int ostatok = Integer.parseInt(num.text())%20;
                            if(ostatok>0)
                                number++;
                            int j = 1;
                            while(j<=number) {
                                for (int i = 2; i <= 21; i++) {
                                    try{
                                        Element elem = doc[0].select("tr.last-position").get(i);
                                        String str = elem.child(1).text();
                                        int k = str.indexOf("Зачислен");
                                        str = str.substring(0,k-1);
                                        if(str.equals(singleton.FIO)) {
                                            numberOf[0] = elem.child(0).text();
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    txtTPUview.setText("Позиция на факультете ТПУ " + numberOf[0]);
                                                }
                                            });
                                            break;
                                        }
                                    }
                                    catch (Exception e) {
                                        break;
                                    }
                                }
                                if(txtTPUview.getText().equals("")){
                                    j++;
                                    doc[0] = Jsoup.connect(site + "&page=" + String.valueOf(j)).get();
                                }
                                else{
                                    break;
                                }


                            }
                        }
                        catch (Exception e){

                        }
                    }
                }).start();
                break;
            }
            default:{
                break;
            }
        }

        //Element element = doc.select(".contest_border.entered").first().child(0);
        //int number = Integer.parseInt(element.text());
    }
    }
