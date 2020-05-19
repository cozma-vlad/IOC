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

public class Television extends AppCompatActivity {

	private Switch mSwPwr;
	private TextView mTxtPwr;

	private TextView mTxtBright;
	private SeekBar mSbBright;

	private TextView mTxtCh;
	private Button mBtnChP;
	private Button mBtnChM;

	private ImageButton mBack;

	private TextView mTxtVol;
	private Button mBtnVolP;
	private Button mBtnVolM;

	private TextView mTxtBrightness;
	private TextView mTxtChannel;

	private Button mDel;
	private int mPos;
	private String mOperation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.television);
		String Activity_title = getIntent().getStringExtra("ACTIVITY_TITLE");
		TextView activ_title=(TextView)findViewById(R.id.item_name);
		activ_title.setText(Activity_title);

		mSwPwr = (Switch)findViewById(R.id.switch2);
		mTxtPwr = (TextView)findViewById(R.id.textView_OnOff);

		mTxtBright = (TextView)findViewById(R.id.temp);
		mSbBright = (SeekBar)findViewById(R.id.seekBar);

		mBack = (ImageButton)findViewById(R.id.imageButton);

		mTxtCh = (TextView)findViewById(R.id.integer_number);
		mBtnChM = (Button)findViewById(R.id.decrease);
		mBtnChP = (Button)findViewById(R.id.increase);

		mTxtVol = (TextView)findViewById(R.id.volume);
		mBtnVolP =(Button)findViewById(R.id.volume_up);
		mBtnVolM =(Button)findViewById(R.id.volume_down);

		mDel = (Button)findViewById(R.id.button);

		mTxtBrightness = (TextView)findViewById(R.id.speed);
		mTxtChannel = (TextView)findViewById(R.id.txt_Volume);

		mSbBright.setEnabled(false);
		mBtnChM.setEnabled(false);
		mBtnChP.setEnabled(false);
		mBtnVolM.setEnabled(false);
		mBtnVolP.setEnabled(false);
		mTxtVol.setEnabled(false);
		mTxtCh.setEnabled(false);
		mTxtBright.setEnabled(false);
		mTxtBrightness.setEnabled(false);
		mTxtChannel.setEnabled(false);

		mOperation = getIntent().getStringExtra("ACTIVITY_OPERATION");


		mPos = getIntent().getIntExtra("ACTIVITY_NAME", 0);
		mBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});

		mSwPwr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

				if(isChecked) {
					mTxtPwr.setText("Power: On");

					mSbBright.setEnabled(true);
					mBtnChM.setEnabled(true);
					mBtnChP.setEnabled(true);

					if(!mTxtVol.getText().equals("0"))
						mBtnVolM.setEnabled(true);
					if(!mTxtVol.getText().equals("99"))
						mBtnVolP.setEnabled(true);

					mTxtVol.setEnabled(true);
					mTxtCh.setEnabled(true);
					mTxtBright.setEnabled(true);
					mTxtBrightness.setEnabled(true);
					mTxtChannel.setEnabled(true);
				}
				else {
					mTxtPwr.setText("Power: Off");

					mSbBright.setEnabled(false);
					mBtnChM.setEnabled(false);
					mBtnChP.setEnabled(false);
					mBtnVolM.setEnabled(false);
					mBtnVolP.setEnabled(false);
					mTxtVol.setEnabled(false);
					mTxtCh.setEnabled(false);
					mTxtBright.setEnabled(false);
					mTxtBrightness.setEnabled(false);
					mTxtChannel.setEnabled(false);
				}
			}
		});

		mDel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mOperation=="del") {
					MainActivity.itemAdapter.ItemList.remove(mPos);
					MainActivity.itemAdapter.notifyDataSetChanged();
					onBackPressed();
				}else{
					MainActivity.itemAdapter.ItemList.add(new Item())
				}
			}
		});


		mSbBright.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				mTxtBright.setText("Brightness: " + progress);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
		});

		mBtnChP.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mTxtCh.setText(String.valueOf(Integer.parseInt(mTxtCh.getText().toString()) + 1));
				if(mTxtCh.getText().equals("41"))
					mTxtCh.setText("1");
			}
		});

		mBtnChM.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mTxtCh.setText(String.valueOf(Integer.parseInt(mTxtCh.getText().toString()) - 1));

				if(mTxtCh.getText().equals("0"))
					mTxtCh.setText("40");
			}
		});

		mBtnVolP.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mTxtVol.setText(String.valueOf(Integer.parseInt(mTxtVol.getText().toString()) + 1));
				if(mTxtVol.getText().equals("99"))
					mBtnVolP.setEnabled(false);
				else{
					mBtnVolP.setEnabled(true);
					mBtnVolM.setEnabled(true);
				}
			}
		});

		mBtnVolM.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mTxtVol.setText(String.valueOf(Integer.parseInt(mTxtVol.getText().toString()) - 1));
				if(mTxtVol.getText().equals("0"))
					mBtnVolM.setEnabled(false);
				else{
					mBtnVolP.setEnabled(true);
					mBtnVolM.setEnabled(true);
				}
			}
		});
	}
}
