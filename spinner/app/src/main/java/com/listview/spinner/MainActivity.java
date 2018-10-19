package com.listview.spinner;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button btnConvert;
    TextView txtView;
    String[] dept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConvert = (Button) findViewById(R.id.btnConvert);
        dept = getResources().getStringArray(R.array.depts);
        Spinner s1 = (Spinner) findViewById(R.id.spDept);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, dept);
        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {
                int index = arg0.getSelectedItemPosition();
                if (index > 0) {

                    Toast.makeText(getBaseContext(), "you have selected " + dept[index], Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//            });

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtView = (TextView) findViewById(R.id.edTxt);
                txtView.setTypeface(null, Typeface.BOLD_ITALIC);
            }
        });


    }
}
