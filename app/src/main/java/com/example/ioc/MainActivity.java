package com.example.ioc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> itemList=new ArrayList<>();
    public static ItemAdapter itemAdapter;

    public void init(){
        Context ctx = getApplicationContext();

        itemList.add(new Item("Hood",3));
        itemList.add(new Item("Television",1));
        itemList.add(new Item("Air Conditioner",2));
        itemList.add(new Item("Lights",4));

        itemList.add(new Item("Hood2",3));
        itemList.add(new Item("Television2",1));
        itemList.add(new Item("Air Conditioner2",2));
        itemList.add(new Item("Lights2",4));

        itemList.add(new Item("Hood3",3));
        itemList.add(new Item("Television3",1));
        itemList.add(new Item("Air Conditioner3",2));
        itemList.add(new Item("Lights3",4));
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
                Item a = itemList.get(position);
                switch (a.Type) {
                    case 1:
                        intent = new Intent(getApplicationContext(), Television.class);
                        intent.putExtra("ACTIVITY_NAME", position);
                        intent.putExtra("ACTIVITY_TITLE", a.Name);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(), AirConditioner.class);
                        intent.putExtra("ACTIVITY_NAME", position);
                        intent.putExtra("ACTIVITY_TITLE", a.Name);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getApplicationContext(), Hood.class);
                        intent.putExtra("ACTIVITY_NAME", position);
                        intent.putExtra("ACTIVITY_TITLE", a.Name);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(getApplicationContext(), Lights.class);
                        intent.putExtra("ACTIVITY_NAME", position);
                        intent.putExtra("ACTIVITY_TITLE", a.Name);
                        startActivity(intent);
                        break;
                }
            }
        });

    }
}
