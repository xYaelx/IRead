package com.example.android.pdfrendererbasic;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PrintLevelActivity extends AppCompatActivity {

    private final static String LEVEL_1 = "Dr. Seuss";
    private final static String LEVEL_2 = "Madeleine L'Engle";
    private final static String LEVEL_3 = "Judy Blume";
    private final static String LEVEL_4 = "John Grisham";
    private final static String LEVEL_5 = "Yochi Brandes";
    private final static String LEVEL_6 = "Agatha Christy";
    private final static String LEVEL_7 = "JK Rowling";
    private final static String LEVEL_8 = "William Shakespeare";
    private final static String LEVEL_9 = "John Milton";
    private final static String LEVEL_10 = "James Joyce";
    private final static String LEVEL_0 = "Jackson Pollock";

    private final static Integer images[] ={R.drawable.books1, R.drawable.books2,
            R.drawable.books3, R.drawable.books4, R.drawable.books5, R.drawable.books6,
            R.drawable.books7, R.drawable.books8, R.drawable.books9, R.drawable.books10, R.drawable.pollock};
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print_level);

        Intent intent = getIntent();
        int points = 2500;

        TextView pointTextView = (TextView) findViewById(R.id.pointTextView);
        //setFontTextView(this, pointTextView);
        pointTextView.setText("You have "+points+" points!");

        TextView levelTextView = (TextView) findViewById(R.id.levelTextView);
       // setFontTextView(this, levelTextView);
        levelTextView.setText("You're a regular "+getLevel(points)+"!");

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_print_level);
        imageView = (ImageView) findViewById(R.id.imageDisplay);
        setCurrentImage(points);
    }

    public void setFontTextView(Context c, TextView name) {
        Typeface font = Typeface.createFromAsset(c.getAssets(),"BreeSerifRegular.ttf");
        name.setTypeface(font);
    }

    static String getLevel(int points) {
        if (isBetween(points,0,100)) {
            return LEVEL_1;
        }
        if (isBetween(points,100,200)) {
            return LEVEL_2;
        }
        if (isBetween(points,200,350)) {
            return LEVEL_3;
        }
        if (isBetween(points,350,550)) {
            return LEVEL_4;
        }
        if (isBetween(points,550,800)) {
            return LEVEL_5;
        }
        if (isBetween(points,800,1100)) {
            return LEVEL_6;
        }
        if (isBetween(points,1100,1450)) {
            return LEVEL_7;
        }
        if (isBetween(points,1450,1850)) {
            return LEVEL_8;
        }
        if (isBetween(points,1850,2300)) {
            return LEVEL_9;
        }
        if (points>=2300) {
            return LEVEL_10;
        }
        return LEVEL_0;
    }

    private static boolean isBetween(int num, int num1, int num2) {
        return num >=num1 && num<num2;
    }

    private void setCurrentImage(int points) {
        String level = getLevel(points);
        int currImage = 0;
        switch (level) {
            case LEVEL_1:
                currImage = 0;
                break;
            case LEVEL_2:
                currImage = 1;
                break;
            case LEVEL_3:
                currImage = 2;
                break;
            case LEVEL_4:
                currImage = 3;
                break;
            case LEVEL_5:
                currImage = 4;
                break;
            case LEVEL_6:
                currImage = 5;
                break;
            case LEVEL_7:
                currImage = 6;
                break;
            case LEVEL_8:
                currImage = 7;
                break;
            case LEVEL_9:
                currImage = 8;
                break;
            case LEVEL_10:
                currImage = 9;
                break;
            case LEVEL_0:
            default:
                currImage = 10;
                break;

        }

        imageView.setImageResource(images[currImage]);
//        imageView.setImageResource(R.drawable.books1);

    }
}
