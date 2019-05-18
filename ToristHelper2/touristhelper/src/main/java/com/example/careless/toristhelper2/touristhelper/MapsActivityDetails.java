package com.example.careless.toristhelper2.touristhelper;

import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MapsActivityDetails extends FragmentActivity implements OnMapReadyCallback {


    public String[] long_lagi_Data;
    String titleL;
    ListView listView;
    ImageView imageView;
    TextView title,decription,place;

    ArrayList<String> arrayListTitle=new ArrayList<>();
    ArrayList<String>arrayListDetails=new ArrayList<>();
    ArrayList<String>arrayListDistrict=new ArrayList<>();
    ArrayList<String>arrayListImage=new ArrayList<>();
    ArrayList<String>arrayListLongLagi=new ArrayList<>();
    ArrayList<String>arrayListPlaceName=new ArrayList<>();



    ArrayAdapter<String> adapter;
    String dis;
    DataBaseHelper dataBaseHelper;


    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_details);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        dis=getIntent().getStringExtra("dis");

        imageView=findViewById(R.id.image_view);
        listView = findViewById(R.id.list_place_id);
        title = findViewById(R.id.txt_title);
        decription = findViewById(R.id.txt_decription);
        place = findViewById(R.id.txt_place);
        dataBaseHelper=new DataBaseHelper(MapsActivityDetails.this);
        getData();
        setListView();



    }

    public void getData(){
        Cursor cursor = dataBaseHelper.getAllData(dis);




        while (cursor.moveToNext()){
            titleL=cursor.getString(1);
            String details = cursor.getString(2);
            String district = cursor.getString(3);
            String img = cursor.getString(4);
            String placeName = cursor.getString(6);

            String long_lagi = cursor.getString(5);
            long_lagi_Data = long_lagi.split(",");





            arrayListTitle.add(titleL);
            arrayListDetails.add(details);
            arrayListDistrict.add(district);
            arrayListImage.add(img);
            arrayListLongLagi.add(long_lagi);
            arrayListPlaceName.add(placeName);

        }


    }


    public void setListView(){
        adapter=new ArrayAdapter<String>(MapsActivityDetails.this,R.layout.layout_list_view,arrayListTitle);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setView(position);
            }
        });


    }

    public void setView(int pos){
        title.setText(arrayListTitle.get(pos));
        decription.setText(arrayListDetails.get(pos));
        place.setText(arrayListPlaceName.get(pos));
        imageView.setImageBitmap(getBitmapFromAsset(arrayListImage.get(pos)));

    }

    private Bitmap getBitmapFromAsset(String strName)
    {
        AssetManager assetManager = getAssets();
        InputStream istr = null;
        try {
            istr = assetManager.open(strName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(istr);
        return bitmap;
    }





    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        LatLng careless = new LatLng(152,184);
        mMap.addMarker(new MarkerOptions().position(careless).title("any where"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(careless, 10F));



//        LatLng careless = new LatLng(Double.parseDouble(long_lagi_Data[0]), Double.parseDouble(long_lagi_Data[1]));
//        mMap.addMarker(new MarkerOptions().position(careless).title(titleL));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(careless, 10F));
    }
}
