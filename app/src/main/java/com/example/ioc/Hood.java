package com.example.ioc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Hood extends AppCompatActivity {

    private TextView mtvPower;
    private TextView mtvLight;
    private TextView mtvLevel;
    private TextView mtvNumber;

    private Switch mswPower;
    private Switch mswLight;

    private Button mbtDown;
    private Button mbtUp;

    private ImageButton mBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hood);
        String Activity_title = getIntent().getStringExtra("ACTIVITY_TITLE");
        TextView activ_title=(TextView)findViewById(R.id.item_name);
        activ_title.setText(Activity_title);

        mtvPower = (TextView)findViewById(R.id.tvPower);
        mtvLight = (TextView)findViewById(R.id.tvLight);
        mtvLevel = (TextView)findViewById(R.id.tvLevel);
        mtvNumber = (TextView)findViewById(R.id.tvNumber);

        mswPower = (Switch)findViewById(R.id.swPower);
        mswLight = (Switch)findViewById(R.id.swLight);

        mbtDown = (Button)findViewById(R.id.btDown);
        mbtUp = (Button)findViewById(R.id.btUp);

        mtvLight.setEnabled(false);
        mtvLevel.setEnabled(false);
        mtvNumber.setEnabled(false);

        mswLight.setEnabled(false);

        mBack = (ImageButton)findViewById(R.id.imageButton);

        mbtUp.setEnabled(false);
        mbtDown.setEnabled(false);

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        mswPower.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked) {
                    mtvPower.setText("Power: On");

                    mtvLight.setEnabled(true);
                    mtvLevel.setEnabled(true);
                    mtvNumber.setEnabled(true);

                    mswLight.setEnabled(true);
                    mswPower.setEnabled(true);

                    if(mtvNumber.getText().equals("0"))
                        mbtDown.setEnabled(false);
                    else
                        mbtDown.setEnabled(true);
                    if(mtvNumber.getText().equals("5"))
                        mbtUp.setEnabled(false);
                    else
                        mbtUp.setEnabled(true);
                }
                else {
                    mtvPower.setText("Power: Off");

                    mtvLight.setEnabled(false);
                    mtvLevel.setEnabled(false);
                    mtvNumber.setEnabled(false);

                    mswLight.setEnabled(false);

                    mbtUp.setEnabled(false);
                    mbtDown.setEnabled(false);
                }
            }
        });

        mswLight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    mtvLight.setText("Light: On");
                }
                else
                {
                    mtvLight.setText("Light: Off");
                }
            }
        });

        mbtDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtvNumber.setText(String.valueOf(Integer.parseInt(mtvNumber.getText().toString()) - 1));

                if(mtvNumber.getText().equals("0"))
                    mbtDown.setEnabled(false);

                if(!mbtUp.isEnabled())
                    mbtUp.setEnabled(true);
            }
        });

        mbtUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mtvNumber.setText(String.valueOf(Integer.parseInt(mtvNumber.getText().toString()) + 1));

                if(mtvNumber.getText().equals("5"))
                    mbtUp.setEnabled(false);

                if(!mbtDown.isEnabled())
                    mbtDown.setEnabled(true);
            }
        });
    }

}
