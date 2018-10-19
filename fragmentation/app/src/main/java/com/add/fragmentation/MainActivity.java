package com.add.fragmentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
   public void ChangeFragment (View view) {
       //Fragment fragment=new Fragment();
       if (view == findViewById(R.id.bt1)) {
           Fragment fragment = new Fragment();
           FragmentManager fm = getFragmentManager();
           FragmentTransaction ft = fm.beginTransaction();
           ft.replace(R.id.fragmant123, fragment);
           ft.commit();
       }
       else if (view == findViewById(R.id.bt2)){

           Fragment fragment2=new Fragment();
       }
   }
}
