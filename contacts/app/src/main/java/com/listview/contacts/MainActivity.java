package com.listview.contacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.listview.contacts.R;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    TextView textView;
    String contacts[] = {"ram ", "syam ", "mohan"};
    String numbers[]= {"9090", "8080", "7070"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);
        textView = (TextView) findViewById(R.id.show);

        ArrayAdapter<String > arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,contacts);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
        listView.getResources().getColor(R.color.colorAccent);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Toast.makeText(MainActivity.this, "you clicked on"+contacts[i]+"\n"+numbers[i], Toast.LENGTH_SHORT).show();
        textView.setText(contacts[i]+"\n"+numbers[i]);
    }
}
