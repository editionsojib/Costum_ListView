package com.editions.listview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    ArrayList < HashMap<String, String> > arrayList= new ArrayList<>();

    HashMap<String, String> hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView= findViewById(R.id.listView);

        ListAdapter MyAdapter= new MyAdapter();
        listView.setAdapter(MyAdapter);

        hashMap= new HashMap<>();
        hashMap.put("name", "Sojib Farazi");
        hashMap.put("mobile", "01712345677");
        hashMap.put("text", "This is sojib");
        arrayList.add(hashMap);

        hashMap= new HashMap<>();
        hashMap.put("name", "Rajib Farazi");
        hashMap.put("mobile", "01712345678");
        hashMap.put("text", "This is sojib");
        arrayList.add(hashMap);

        hashMap= new HashMap<>();
        hashMap.put("name", "Shakib Farazi");
        hashMap.put("mobile", "01712345679");
        hashMap.put("text", "This is sojib");
        arrayList.add(hashMap);














    }// OnClick End Here==================================================

    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {

            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater= getLayoutInflater();
            View myView= layoutInflater.inflate(R.layout.item, parent, false);



            ImageView imageView= myView.findViewById(R.id.imageView);
            TextView textView= myView.findViewById(R.id.tvName);
            TextView tvMobile= myView.findViewById(R.id.tvmobile);
            TextView tvText= myView.findViewById(R.id.tvText);

            HashMap<String, String> hashMap= arrayList.get(position);
            textView.setText(hashMap.get("name"));
            tvMobile.setText(hashMap.get("mobile"));
            tvText.setText(hashMap.get("text"));


            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Clicked\nposition "+position, Toast.LENGTH_SHORT).show();
                }
            });

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Toast.makeText(MainActivity.this, "Clecked position "+position, Toast.LENGTH_SHORT).show();

                }
            });


            return myView;
        }
    }





}//=============================