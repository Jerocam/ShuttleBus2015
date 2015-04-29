package com.example.jeronimoj.shuttlebus2015;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.content.res.TypedArray;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity

{
    private ImageView image;
    private ImageView image2;
    private String[] states;
    private Spinner spinner;
    private Spinner spinner2;
    private TypedArray imgs;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        states = getResources().getStringArray(R.array.place_array);

        imgs = getResources().obtainTypedArray(R.array.places_list);

        text = (TextView) findViewById (R.id.testing);

        image = (ImageView) findViewById(R.id.imageView);
        image2 = (ImageView) findViewById(R.id.imageView2);

        spinner = (Spinner) findViewById(R.id.from);
        spinner2 = (Spinner) findViewById(R.id.to);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, states);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, states);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(dataAdapter);
        spinner2.setAdapter(dataAdapter2);

        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                image.setImageResource(imgs.getResourceId(spinner.getSelectedItemPosition(), -1));

                String item = parent.getItemAtPosition(position).toString();
                text.setText(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                text.setText("");
            }
        });


        spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                image2.setImageResource(imgs.getResourceId(spinner2.getSelectedItemPosition(), -1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

    }
    }


 /*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
*/