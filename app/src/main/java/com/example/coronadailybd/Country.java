package com.example.coronadailybd;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hbb20.CountryCodePicker;


public class Country extends AppCompatActivity {

    CountryCodePicker ccp;
    Button button;
    TextView textView,textView1;
    ImageView imgi;

    // this is ashraful branch...
    //jhfjdfh

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);

        button = findViewById(R.id.button);
        ccp = findViewById(R.id.ccp);
        textView = findViewById(R.id.cc);
        textView1 = findViewById(R.id.cc1);
        imgi = findViewById(R.id.img9);





        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String c = ccp.getSelectedCountryName();

                int d = ccp.getSelectedCountryFlagResourceId();

                Intent intent = new Intent(Country.this, MainActivity.class);
                intent.putExtra("MODEL",c);
                intent.putExtra("img",d);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Country.this.startActivity(intent);
                finish();



            }
        });




        ccp.setDialogEventsListener(new CountryCodePicker.DialogEventsListener() {
            @Override
            public void onCcpDialogOpen(Dialog dialog) {

                onCcpDialogCancel(dialog);

            }

            @Override
            public void onCcpDialogDismiss(DialogInterface dialogInterface) {


                onCcpDialogCancel(dialogInterface);

            }

            @Override
            public void onCcpDialogCancel(DialogInterface dialogInterface) {

                textView.setText("Country : " + ccp.getSelectedCountryName());
                textView1.setText("Country Code : " + ccp.getSelectedCountryCode());
                imgi.setImageResource(ccp.getSelectedCountryFlagResourceId());




            }
        });











    }
}