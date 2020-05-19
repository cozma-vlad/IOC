package com.example.ioc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> itemList=new ArrayList<>();
    public static ItemAdapter itemAdapter;

    public void init(){
        itemList.add(new Item("Frigider",1));
        itemList.add(new Item("Televizor",2));
        itemList.add(new Item("Aer Conditionat",3));
        itemList.add(new Item("Usa",4));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        itemAdapter=new ItemAdapter(itemList,this);

        ListView listView=(ListView)findViewById(R.id.ItemListView);
        listView.setAdapter(itemAdapter);

    }
}
