package com.example.stu.pdf;

import android.content.Context;
import android.graphics.pdf.PdfDocument;
import android.os.Vibrator;
import android.print.pdf.PrintedPdfDocument;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    String str;
    HashMap<String, String> map;
    TextView status;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        str = "";
        status = findViewById(R.id.status);
        textView = findViewById(R.id.text);

        map = new HashMap<String, String>();

        map.put("-.","א");
        map.put("...-","ב");
        map.put(".--","ג");
        map.put("..-","ד");
        map.put("---","ה");
        map.put(".","ו");
        map.put("..--","ז");
        map.put("....","ח");
        map.put("-..","ט");
        map.put("..","י");
        map.put("-.-","כ");
        map.put("..-.","ל");
        map.put("--","מ");
        map.put(".-","נ");
        map.put(".-.-","ס");
        map.put("---.","ע");
        map.put(".--.","פ");
        map.put("--.","צ");
        map.put("-.--","ק");
        map.put(".-.","ר");
        map.put("...","ש");
        map.put("-","ת");
        map.put("----.","1");
        map.put("---..","2");
        map.put("--...","3");
        map.put("-....","4");
        map.put(".....","5");
        map.put("....-","6");
        map.put("...--","7");
        map.put("..---","8");
        map.put(".----","9");
        map.put("-----","0");
        map.put("--..","_");

        Set set = map.entrySet();
        Iterator i = set.iterator();

        while (i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            System.out.print("aaa " + me.getKey() + " ");
            System.out.println(me.getValue());
        }

        findViewById(R.id.enter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = textView.getText().toString();
                if (map.containsKey(str)){
                String s = map.get(str).toString();
                textView.setText(text + s);
                str = "";
                status.setText(str);
                }else {
                    str = "";
                    status.setText(str);
                }

            }
        });  findViewById(R.id.dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click(".");
            }
        });
        findViewById(R.id.line).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click("-");
            }
        });
        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = textView.getText().toString();
                if (text.length() > 0){
                    text = text.substring(0, text.length()-1);
                    textView.setText(text);
                }
            }
        });

    }


    public void click(String sigh) {
        str += sigh;
        TextView textView = findViewById(R.id.status);
        status.setText(str);
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(100);
    }
}
