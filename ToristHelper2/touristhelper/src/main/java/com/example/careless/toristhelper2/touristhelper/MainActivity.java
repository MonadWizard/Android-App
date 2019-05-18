package com.example.careless.toristhelper2.touristhelper;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton bt_dhaka, bt_raj, bt_barishal, bt_chittagong, bt_khulna, bt_rangpur, bt_sylhet, bt_mymansingh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_dhaka = findViewById(R.id.ib_dhaka);
        bt_raj = findViewById(R.id.ib_raj);
        bt_barishal = findViewById(R.id.ib_bari);
        bt_chittagong = findViewById(R.id.ib_ctg);
        bt_khulna = findViewById(R.id.ib_klna);
        bt_rangpur = findViewById(R.id.ib_rnpur);
        bt_sylhet = findViewById(R.id.ib_slt);
        bt_mymansingh = findViewById(R.id.ib_mns);


        bt_dhaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mainPageMenuL.setVisibility(View.GONE);
                startActivity(new Intent(MainActivity.this, MapsActivityDetails.class).putExtra("dis","Dhaka"));

            }
        });

        bt_raj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapsActivityDetails.class).putExtra("dis","Rajshahi"));
            }
        });

        bt_barishal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapsActivityDetails.class).putExtra("dis","Barishal"));

            }
        });

        bt_chittagong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapsActivityDetails.class).putExtra("dis","Chittogaon"));

            }
        });

        bt_khulna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapsActivityDetails.class).putExtra("dis","Khulna"));

            }
        });

        bt_rangpur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapsActivityDetails.class).putExtra("dis","Rongpur"));

            }
        });

        bt_sylhet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapsActivityDetails.class).putExtra("dis","Sylhet"));

            }
        });

        bt_mymansingh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MapsActivityDetails.class).putExtra("dis","Mymensingh"));

            }
        });
    }
//
//    public void setFregment(){
//        Fragment fragment = new DistrictFragment();
//        FragmentManager fragmentManager = getFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.fragment,fragment);
//        fragmentTransaction.commit();
//
//    }



}
