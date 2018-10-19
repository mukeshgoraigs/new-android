package com.listview.prog5;

import android.database.Cursor;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    helper  mydb;
   // EditText editName,editSurname,editTextId;
    EditText editName;
    EditText editSurname;
    EditText editTextId;
    Button btnAddData;
    Button btnViewAll;
    Button btnDelete;
    Button btnViewUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb=new helper(this);
        editName=(EditText)findViewById(R.id.edt1);
        editSurname=(EditText)findViewById(R.id.edt2);
       editTextId=(EditText)findViewById(R.id.edt3);
        btnAddData=(Button)findViewById(R.id.btn1);
        btnViewAll=(Button)findViewById(R.id.btn2);
        btnDelete=(Button)findViewById(R.id.btn3);
        btnViewUpdate=(Button)findViewById(R.id.btn4);

       AddData();
       viewAll();
       UpdateData();
       DeleteData();

    }
    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = mydb.insertData(editTextId.getText().toString(),editName.getText().toString(),editSurname.getText().toString());
                System.out.println(isInserted);
                if(isInserted == true)
                    Toast.makeText(MainActivity.this,"Data inserted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data not inserted",Toast.LENGTH_LONG).show();
            }
        });

    }
   public void DeleteData(){
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deleteRow = mydb.deleteData(editTextId.getText().toString());
                if (deleteRow>0)
                    Toast.makeText(MainActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
            }
        });
   }
   public void UpdateData(){
        btnViewUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = mydb.updateData(editTextId.getText().toString(),editName.getText().toString(),editSurname.getText().toString());
                if (isUpdate==true)
                    Toast.makeText(MainActivity.this,"Data Updated",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();
            }
        });
   }
   public void viewAll() {
       btnViewAll.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Cursor res = mydb.getAllData();
                                             if (res.getCount() == 0) {
                                                 showMessage("Error", "Nothing found");
                                                 return;
                                             }

                                             StringBuffer buffer = new StringBuffer();
                                             while (res.moveToNext())

                                             {
                                                 buffer.append("Id :" + res.getString(0) + "\n");
                                                 buffer.append("Name :" + res.getString(1) + "\n");
                                                 buffer.append("Surname :" + res.getString(2) + "\n");
                                             }

                                             showMessage("Data", buffer.toString());
                                         }

                                     }


       );
   }
public void showMessage(String error, String nothing_found) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(0);
        builder.setMessage(0);
        builder.show();
   }

}