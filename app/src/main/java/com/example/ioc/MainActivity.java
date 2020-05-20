package com.example.ioc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
// push
public class MainActivity extends AppCompatActivity {

    public static ArrayList<Item> itemList=new ArrayList<>();
    public static ArrayList<Item> inactiveList=new ArrayList<>();
    private int listselector=1;
    private EditText editText;
    public static ItemAdapter itemAdapter;
    public int operationdelete=11;
    public static FloatingActionButton fab;

    public void init(){
        Context ctx = getApplicationContext();

        itemList.add(new Item("Hood",3));
        itemList.add(new Item("Television",1));
        itemList.add(new Item("Air Conditioner",2));
        itemList.add(new Item("Lights",4));
//
//        itemList.add(new Item("Hood2",3));
//        itemList.add(new Item("Television2",1));
//        itemList.add(new Item("Air Conditioner2",2));
//        itemList.add(new Item("Lights2",4));
//
//        itemList.add(new Item("Hood3",3));
//        itemList.add(new Item("Television3",1));
//        itemList.add(new Item("Air Conditioner3",2));
//        itemList.add(new Item("Lights3",4));

        inactiveList.add(new Item("new Hood",3));
        inactiveList.add(new Item("new Television",1));
        inactiveList.add(new Item("new Air Conditioner",2));
        inactiveList.add(new Item("new Lights",4));
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        itemAdapter=new ItemAdapter(itemList,this);

        editText = (EditText)findViewById(R.id.editText);
        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ListView listView=(ListView)findViewById(R.id.ItemListView);
                editText.setText("");

                if(listselector==1)
                {
                    itemAdapter.ItemList=inactiveList;
                    listView.setBackgroundColor(getResources().getColor(R.color.unnactive_color));
                    itemAdapter.notifyDataSetChanged();
                    fab.setImageResource(R.drawable.ic_close_black_24dp);
                    listselector=2;
                    operationdelete=22;
                }else{
                    itemAdapter.ItemList=itemList;
                    listView.setBackgroundColor(getResources().getColor(R.color.default_color));
                    itemAdapter.notifyDataSetChanged();
                    fab.setImageResource(R.drawable.ic_add_black_24dp);
                    listselector=1;
                    operationdelete=11;

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
                Item a = itemAdapter.ItemList.get(position);
                switch (a.Type) {
                    case 1:
                        intent = new Intent(getApplicationContext(), Television.class);
                        intent.putExtra("ACTIVITY_NAME", position);
                        intent.putExtra("ACTIVITY_OPERATION", operationdelete);
                        intent.putExtra("ACTIVITY_TITLE", a.Name);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(getApplicationContext(), AirConditioner.class);
                        intent.putExtra("ACTIVITY_NAME", position);
                        intent.putExtra("ACTIVITY_OPERATION", operationdelete);
                        intent.putExtra("ACTIVITY_TITLE", a.Name);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(getApplicationContext(), Hood.class);
                        intent.putExtra("ACTIVITY_NAME", position);
                        intent.putExtra("ACTIVITY_OPERATION", operationdelete);
                        intent.putExtra("ACTIVITY_TITLE", a.Name);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(getApplicationContext(), Lights.class);
                        intent.putExtra("ACTIVITY_NAME", position);
                        intent.putExtra("ACTIVITY_OPERATION", operationdelete);
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
