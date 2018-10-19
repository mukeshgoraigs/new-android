package com.add.add1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    TextView result;
    Button add, sub, mul, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIViews();
    }
    private void setupUIViews(){
        number1=(EditText)findViewById(R.id.editno);
        number2=(EditText)findViewById(R.id.edittop);
        result=(TextView)findViewById(R.id.text);
        add=(Button)findViewById(R.id.add);
        sub=(Button)findViewById(R.id.sub);
        mul=(Button)findViewById(R.id.mul);
        div=(Button)findViewById(R.id.division);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    double n1=Double.parseDouble(number1.getText().toString());
                    double n2=Double.parseDouble(number2.getText().toString());
                    double res=n1+n2;
                    result.setText(String.valueOf(res));

            }
        });





        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.getText() != null && number2.getText() != null)
                {
                    double n1=Double.parseDouble(number1.getText().toString());
                    double n2=Double.parseDouble(number2.getText().toString());

                    double res=n1-n2;

                    result.setText(String.valueOf(res));
                }



            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.getText() != null && number2.getText() != null)
                {
                    double n1=Double.parseDouble(number1.getText().toString());
                    double n2=Double.parseDouble(number2.getText().toString());

                    double res=n1*n2;

                    result.setText(String.valueOf(res));
                }



            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(number1.getText() != null && number2.getText() != null)
                {
                    double n1=Double.parseDouble(number1.getText().toString());
                    double n2=Double.parseDouble(number2.getText().toString());

                    double res=n1/n2;

                    result.setText(String.valueOf(res));
                }



            }
        });

    }
}
