package com.listview.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listView;
    TextView textView;
    String[] contacts={"Allen","Ben","vikas"};
    String[] numbers={"90920393","74858595","756849484"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.lv1);
        textView = (TextView) findViewById(R.id.tv1);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);
        listView.setAdapter(arrayAdapter);
        listView.getResources().getColor(R.color.colorAccent);
        listView.setOnItemClickListener(this);
    }





    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        Toast.makeText(MainActivity.this,"you clicked on:"+contacts[i]+"\n"+numbers[i],Toast.LENGTH_SHORT).show();
        textView.setText(contacts[i]+"\n"+numbers[i]);
    }
}
