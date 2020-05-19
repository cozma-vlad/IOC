package com.example.ioc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ItemAdapter extends BaseAdapter {
    List<Item> ItemList;
    Context context;

    public ItemAdapter(List<Item> L,Context context)
    {
        this.ItemList=L;
        this.context=context;
    }
    @Override
    public int getCount() {
        return ItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return ItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        //de returnat un id unic pentru fiecare element ToDo
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View viewItem = layoutInflater.inflate(R.layout.item_layout, parent, false);

        TextView t1=viewItem.findViewById(R.id.text1);

        Item i=ItemList.get(position);
        t1.setText(i.Name);


        return viewItem;
    }

}
