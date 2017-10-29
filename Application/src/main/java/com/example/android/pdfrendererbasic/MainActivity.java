package com.example.android.pdfrendererbasic;

/**
 * Created by Shir on 23/09/2016.
 */
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//Main welcome screen! (not a new user)

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    int points;
    public final static String EXTRA_MESSAGE = "com.example.android.pdfrendererbasic";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        //  MyApplication app = (MyApplication) getApplicationContext();
        //  Database db = app.getData();
        //info from User table (editText, points, level)
        String name = "Alina";
        TextView welcome = (TextView) findViewById(R.id.welcome);
        // PrintLevelActivity.setFontTextView(this, welcome);
        welcome.setText("Welcome back, " + name + "!");

        points = 2500;
        String myLevel = PrintLevelActivity.getLevel(points);
        TextView level = (TextView) findViewById(R.id.level);
        // PrintLevelActivity.setFontTextView(this, level);
        level.setText("Level - " + myLevel);

        Button pointsButton = (Button) findViewById(R.id.button);
        //Typeface typeface = Typeface.createFromAsset(this.getAssets(), "BreeSerifRegular.ttf");
        //pointsButton.setTypeface(typeface);
        pointsButton.setText(points + "\npoints");

        TextView view = (TextView) findViewById(R.id.textView5);
       // view.setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View viewIn) {
          //      go();

    //        }
  //      });
    }

        //info from Books table

public void go(View view){
    Intent intent = new Intent(this, MainActivity1.class);
    startActivity(intent);
    }

    public void viewPoints(View view) {
        Intent intent = new Intent(this,PrintLevelActivity.class);
        intent.putExtra(EXTRA_MESSAGE, points);
        startActivity(intent);
    }
}