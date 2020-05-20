package com.example.ioc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class Lights extends AppCompatActivity {

	private Switch mSwBedroom;
	private Switch mSwKitcken;
	private Switch mSwLiving;
	private Switch mSwBathroom;

	private SeekBar mSbBedroom;
	private SeekBar mSbKitchen;
	private SeekBar mSbLiving;
	private SeekBar mSbBathroom;

	private ImageButton mBack;
	private Button mDel;
	private int mPos;
	private int mOperation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lights);
		String Activity_title = getIntent().getStringExtra("ACTIVITY_TITLE");
		EditText activ_title = (EditText)findViewById(R.id.item_name);
		activ_title.setText(Activity_title);

		mSwBedroom = (Switch)findViewById(R.id.swBedroom);
		mSwKitcken = (Switch)findViewById(R.id.swPower);
		mSwLiving = (Switch)findViewById(R.id.swLiving);
		mSwBathroom = (Switch)findViewById(R.id.swBathroom);

		mBack = (ImageButton)findViewById(R.id.imageButton);

		mSbBedroom = (SeekBar) findViewById(R.id.sbBedroom);
		mSbKitchen = (SeekBar)findViewById(R.id.sbKitchen);
		mSbLiving = (SeekBar)findViewById(R.id.sbLiving);
		mSbBathroom = (SeekBar)findViewById(R.id.sbBathroom);

		mDel = (Button)findViewById(R.id.button);

		mSbBedroom.setEnabled(false);
		mSbKitchen.setEnabled(false);
		mSbLiving.setEnabled(false);
		mSbBathroom.setEnabled(false);

		mBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});
		mPos = getIntent().getIntExtra("ACTIVITY_NAME", 0);
		mOperation = getIntent().getIntExtra("ACTIVITY_OPERATION",0);


		mSwBedroom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mSbBedroom.setEnabled(isChecked);
			}
		});

		mSwKitcken.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mSbKitchen.setEnabled(isChecked);
			}
		});

		mSwLiving.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mSbLiving.setEnabled(isChecked);
			}
		});

		mSwBathroom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				mSbBathroom.setEnabled(isChecked);
			}
		});

		mDel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mOperation==11) {
					MainActivity.itemList.remove(mPos);
					MainActivity.itemAdapter.ItemList=MainActivity.itemList;
					MainActivity.itemAdapter.notifyDataSetChanged();
					onBackPressed();
				}else{
					MainActivity.inactiveList.remove(mPos);
					EditText activ_title=(EditText) findViewById(R.id.item_name);
					Item a=new Item(activ_title.getText().toString(),1);
					MainActivity.itemList.add(a);
					MainActivity.itemAdapter.ItemList=MainActivity.itemList;
					MainActivity.fab.performClick();
					MainActivity.itemAdapter.notifyDataSetChanged();
					onBackPressed();
				}
			}
		});
		if(mOperation==22)
		{
			mDel.setText("Add");
		}


	}
}
