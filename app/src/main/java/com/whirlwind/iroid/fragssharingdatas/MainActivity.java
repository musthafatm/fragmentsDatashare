package com.whirlwind.iroid.fragssharingdatas;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements OnFragmentInteractionListener {

   private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTitle = (TextView) findViewById(R.id.tvTitle);

        Fragment firstFragment = FirstFragment.newInstance();
        launchFragment(firstFragment);
    }

    private void launchFragment(Fragment fragObj) {

     /*
       SIR's code; AM COMMENTING.....
       if(fragObj instanceof FirstFragment){
            fragObj =  FirstFragment.newInstance();
        }else{
            fragObj = SecondFragment.newInstance();
        }*/


        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

    /*    ft.addToBackStack(null);*/

        ft.replace(R.id.container, fragObj);
        ft.commit();
    }




//
//    @Override
//    public void onFragmentInteraction(String userContent1) {
//        Toast.makeText(getApplicationContext(),"Data Entered:" +userContent1,Toast.LENGTH_LONG).show();
//        SecondFragment secondFragment = SecondFragment.newInstance();
//
//        // ########################******************************
//        secondFragment.updateTextField(userContent1);
//        replaceFragment(secondFragment);
//    }




    @Override
    public void changeTitle(String title) {
        tvTitle.setText(title);
    }

    @Override
    public void replaceFragment(Fragment fragment) {
        launchFragment(fragment);
    }

    @Override
    public void readText() {

       // met1 = (EditText)findViewById(R.id.et1);
      //  mParam1 =met1.getText().toString();

    }

}
