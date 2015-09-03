package edu.temple.multiactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class ActivityC extends Activity {
    ArrayList<String> dataString = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_c);

        TextView txt;
        txt = (TextView) findViewById(R.id.myTextView);
        dataString = getIntent().getStringArrayListExtra("name");
        if (dataString !=null) {
            String cat = "";

            for (int i = dataString.size()-1; i >=0; i--) {
                if (i == dataString.size()-1) {
                    cat = "Opened by " + dataString.get(i);
                } else {
                    cat += ", which was opened by "+ dataString.get(i);
                }
            }
            txt.setText(cat);

        }

        Button openActivityButton;
        openActivityButton = (Button) findViewById(R.id.myButton);
        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> dataString2;

                Intent launchActivityIntent = new Intent(ActivityC.this, ActivityA.class);
                if (getIntent().getStringArrayListExtra("name")==null) {
                    dataString2 = new ArrayList<String>();
                    dataString2.add("Activity C");
                }
                else {
                    dataString2 = getIntent().getStringArrayListExtra("name");

                    dataString2.add("Activity C");
                }
                launchActivityIntent.putExtra("name", dataString2);
                startActivity(launchActivityIntent);

            }
        };
        openActivityButton.setOnClickListener(ocl);

        Button openActivityButton2;
        openActivityButton2 = (Button) findViewById(R.id.myButton2);
        View.OnClickListener ocl2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> dataString2;

                Intent launchActivityIntent = new Intent(ActivityC.this, ActivityB.class);
                if (getIntent().getStringArrayListExtra("name")==null) {
                    dataString2 = new ArrayList<String>();
                    dataString2.add("Activity C");
                }
                else {
                    dataString2 = getIntent().getStringArrayListExtra("name");

                    dataString2.add("Activity C");
                }
                launchActivityIntent.putExtra("name", dataString2);
                startActivity(launchActivityIntent);
            }
        };
        openActivityButton2.setOnClickListener(ocl2);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_c, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
