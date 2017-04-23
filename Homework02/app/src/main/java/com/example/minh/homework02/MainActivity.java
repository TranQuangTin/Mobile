package com.example.minh.homework02;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.telephony.SmsManager;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button btnSendSMS;

    RadioGroup size_rg, tortilla_rg;

    RadioButton size_rb, tortilla_rb;

    CheckBox beef_cb, seafood_cb, whitefish_cb, bean_cb, chicken_cb, cheese_cb, pico_cb, lbt_cb, soda_cb, tequilla_cb, juice_cb, cerveza_cb;

    String sms = "Bai 2", size = "", tortilla = "", beverage = "", fillings = "";

    int sizeId, tortillaId;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSendSMS = (Button) findViewById(R.id.btnSendSMS);

        size_rg = (RadioGroup) findViewById(R.id.size_rg);
        tortilla_rg = (RadioGroup) findViewById(R.id.tortilla_rg);

        beef_cb = (CheckBox) findViewById(R.id.beef_cb);
        seafood_cb = (CheckBox) findViewById(R.id.seafood_cb);
        whitefish_cb = (CheckBox) findViewById(R.id.whitefish_cb);
        bean_cb = (CheckBox) findViewById(R.id.bean_cb);
        chicken_cb = (CheckBox) findViewById(R.id.chicken_cb);
        cheese_cb = (CheckBox) findViewById(R.id.cheese_cb);
        pico_cb = (CheckBox) findViewById(R.id.pico_cb);
        lbt_cb = (CheckBox) findViewById(R.id.lbt_cb);

        soda_cb = (CheckBox) findViewById(R.id.soda_cb);
        tequilla_cb = (CheckBox) findViewById(R.id.tequilla_cb);
        cerveza_cb = (CheckBox) findViewById(R.id.cerveza_cb);
        juice_cb = (CheckBox) findViewById(R.id.juice_cb);

        btnSendSMS.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                sendSMS(sms);
            }
        });
    }

    public void onCheckboxClicked(View view) {

        switch(view.getId()) {
            case R.id.beef_cb:
                fillings += "Beef ";
                break;
            case R.id.chicken_cb:
                fillings += "Chicken ";
                break;
            case R.id.bean_cb:
                fillings += "Bean ";
                break;
            case R.id.seafood_cb:
                fillings += "Sea Food ";
                break;
            case R.id.whitefish_cb:
                fillings += "White Fish ";
                break;
            case R.id.pico_cb:
                fillings += "Pico de Gallo ";
                break;
            case R.id.lbt_cb:
                fillings += "LBT ";
                break;
            case R.id.soda_cb:
                beverage += "Soda ";
                break;
            case R.id.tequilla_cb:
                beverage += "Tequilla ";
                break;
            case R.id.juice_cb:
                beverage += "Juice ";
                break;
            case R.id.cerveza_cb:
                beverage += "Cerveza ";
                break;
            default:
                break;
        }
    }

    //---sends an SMS message to another device---
    public void sendSMS(String message)
    {
        /*Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + 5556));
        intent.putExtra("sms_body", message);
        startActivity(intent);*/

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("01649687204", null, "SUCCESS", null, null);

    }

}
