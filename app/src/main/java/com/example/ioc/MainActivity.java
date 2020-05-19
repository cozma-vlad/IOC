package com.example.ioc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> itemList=new ArrayList<>();
    public static ItemAdapter itemAdapter;

    public void init(){
        itemList.add(new Item("Hood",2));
        itemList.add(new Item("Television",1));
        itemList.add(new Item("Air Conditioner",3));
        itemList.add(new Item("Lights",4));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        itemAdapter=new ItemAdapter(itemList,this);

        ListView listView=(ListView)findViewById(R.id.ItemListView);
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long arg3) {
                view.setSelected(true);
                Intent intent;
                switch (itemList.get(position).Type)
                {
                    case 1:
                        intent = new Intent(getApplicationContext(),Televizor.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(),AirConditioner.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getApplicationContext(),Televizor.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(getApplicationContext(),Televizor.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}
