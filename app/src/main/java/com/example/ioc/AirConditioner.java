package com.example.ioc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class AirConditioner extends AppCompatActivity {

	private TextView mTxtOnOff;
	private TextView mTxtTemp;
	private TextView mTxtPwr;

	private Switch mSwOnOff;
	private SeekBar mSbTemp;

	private Button mBtnP;
	private Button mBtnM;

	private TextView mTxtSpeed;
	private ImageButton mBack;

	private Button mDel;
	private int mPos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.air_conditioner);
		String Activity_title = getIntent().getStringExtra("ACTIVITY_TITLE");
		TextView activ_title=(TextView)findViewById(R.id.item_name);
		activ_title.setText(Activity_title);

		mTxtOnOff = (TextView)findViewById(R.id.textView_OnOff);
		mTxtTemp = (TextView)findViewById(R.id.temp);

		mBack = (ImageButton)findViewById(R.id.imageButton);
		mDel = (Button)findViewById(R.id.button);

		mTxtPwr = (TextView)findViewById(R.id.integer_number);
		mTxtPwr.setText("3");

		mSbTemp = (SeekBar)findViewById(R.id.seekBar);
		mSwOnOff = (Switch)findViewById(R.id.switch2);

		mBtnM = (Button)findViewById(R.id.decrease);
		mBtnP = (Button)findViewById(R.id.increase);

		mTxtSpeed = (TextView)findViewById(R.id.speed);

		mTxtTemp.setEnabled(false);
		mSbTemp.setEnabled(false);
		mBtnM.setEnabled(false);
		mBtnP.setEnabled(false);
		mTxtPwr.setEnabled(false);
		mTxtSpeed.setEnabled(false);


		mPos = getIntent().getIntExtra("ACTIVITY_NAME", 0);
		mBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});

		mDel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				MainActivity.itemAdapter.ItemList.remove(mPos);
				MainActivity.itemAdapter.notifyDataSetChanged();
				onBackPressed();
			}
		});


		mSwOnOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

				if(isChecked) {
					mTxtOnOff.setText("Power: On");

					mTxtTemp.setEnabled(true);
					mSbTemp.setEnabled(true);

					if(!mTxtPwr.getText().equals("1"))
						mBtnM.setEnabled(true);

					if(!mTxtPwr.getText().equals("5"))
						mBtnP.setEnabled(true);

					mTxtPwr.setEnabled(true);
					mTxtSpeed.setEnabled(true);
				}
				else {
					mTxtOnOff.setText("Power: Off");

					mTxtTemp.setEnabled(false);
					mSbTemp.setEnabled(false);
					mBtnM.setEnabled(false);
					mBtnP.setEnabled(false);
					mTxtPwr.setEnabled(false);
					mTxtSpeed.setEnabled(false);
				}
			}
		});

		mSbTemp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				progress += 15;
				mTxtTemp.setText("Temperature: " + progress);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});

		mBtnP.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mTxtPwr.setText(String.valueOf(Integer.parseInt(mTxtPwr.getText().toString()) + 1));
				if(mTxtPwr.getText().equals("5"))
					mBtnP.setEnabled(false);

				else{
					mBtnM.setEnabled(true);
					mBtnP.setEnabled(true);
				}
			}
		});

		mBtnM.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mTxtPwr.setText(String.valueOf(Integer.parseInt(mTxtPwr.getText().toString()) - 1));
				if(mTxtPwr.getText().equals("1"))
					mBtnM.setEnabled(false);

				else{
						mBtnM.setEnabled(true);
						mBtnP.setEnabled(true);
					}
			}
		});
	}


}