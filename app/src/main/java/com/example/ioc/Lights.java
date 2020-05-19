package com.example.ioc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Switch;

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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lights);

		mSwBedroom = (Switch)findViewById(R.id.swBedroom);
		mSwKitcken = (Switch)findViewById(R.id.swPower);
		mSwLiving = (Switch)findViewById(R.id.swLiving);
		mSwBathroom = (Switch)findViewById(R.id.swBathroom);

		mBack = (ImageButton)findViewById(R.id.imageButton);

		mSbBedroom = (SeekBar) findViewById(R.id.sbBedroom);
		mSbKitchen = (SeekBar)findViewById(R.id.sbKitchen);
		mSbLiving = (SeekBar)findViewById(R.id.sbLiving);
		mSbBathroom = (SeekBar)findViewById(R.id.sbBathroom);

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
	}
}
