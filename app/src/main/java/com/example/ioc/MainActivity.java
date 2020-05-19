package com.example.ioc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> itemList=new ArrayList<>();
    ArrayList<Item> inactiveList=new ArrayList<>();
    private int listselector=1;
    private EditText editText;
    public static ItemAdapter itemAdapter;

    public void init(){
        itemList.add(new Item("Hood",3));
        itemList.add(new Item("Television",1));
        itemList.add(new Item("Air Conditioner",2));
        itemList.add(new Item("Lights",4));
        itemList.add(new Item("Hood",3));
        itemList.add(new Item("Television",1));
        itemList.add(new Item("Air Conditioner",2));
        itemList.add(new Item("Lights",4));
        itemList.add(new Item("Hood",3));
        itemList.add(new Item("Television",1));
        itemList.add(new Item("Air Conditioner",2));
        itemList.add(new Item("Lights",4));
        itemList.add(new Item("Hood",3));
        itemList.add(new Item("Television",1));
        itemList.add(new Item("Air Conditioner",2));
        itemList.add(new Item("Lights",4));
        itemList.add(new Item("Hood",3));
        itemList.add(new Item("Television",1));
        itemList.add(new Item("Air Conditioner",2));
        itemList.add(new Item("Lights",4));


        inactiveList.add(new Item("Hood",3));
        inactiveList.add(new Item("Television",1));
        inactiveList.add(new Item("Air Conditioner",2));
        inactiveList.add(new Item("Lights",4));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        itemAdapter=new ItemAdapter(itemList,this);
        editText = (EditText)findViewById(R.id.editText);
        final FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListView listView=(ListView)findViewById(R.id.ItemListView);
                if(listselector==1)
                {
                    itemAdapter.ItemList=inactiveList;
                    listView.setBackgroundColor(getResources().getColor(R.color.unnactive_color));
                    itemAdapter.notifyDataSetChanged();
                    fab.setImageResource(R.drawable.ic_close_black_24dp);
                    listselector=2;
                }else{
                    itemAdapter.ItemList=itemList;
                    listView.setBackgroundColor(getResources().getColor(R.color.default_color));
                    itemAdapter.notifyDataSetChanged();
                    fab.setImageResource(R.drawable.ic_add_black_24dp);
                    listselector=1;

                }
            }
        });

        ListView listView=(ListView)findViewById(R.id.ItemListView);
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long arg3) {
                view.setSelected(true);
                Intent intent;
                Item a=itemList.get(position);
                switch (a.Type)
                {
                    case 1:
                        intent = new Intent(getApplicationContext(),Television.class);
                        intent.putExtra("ACTIVITY_TITLE", a.Name);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(),AirConditioner.class);
                        intent.putExtra("ACTIVITY_TITLE", a.Name);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getApplicationContext(),Hood.class);
                        intent.putExtra("ACTIVITY_TITLE", a.Name);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(getApplicationContext(),Lights.class);
                        intent.putExtra("ACTIVITY_TITLE", a.Name);
                        startActivity(intent);
                        break;
                }
            }
        });

        editText.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if(!s.equals("") ) {
                    String search = editText.getText().toString().toLowerCase();
                    ArrayList<Item> update=new ArrayList<>();

                    for(int item=0; item < itemList.size(); item++) {
                        if (itemList.get(item).Name.toString().toLowerCase().indexOf(search) != -1)
                        {
                            update.add(itemList.get(item));
                        }
                    }
                    itemAdapter.ItemList = update;
                    itemAdapter.notifyDataSetChanged();
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
