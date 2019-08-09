package com.music.saba.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Submition extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submition);

        EditText name =(EditText) findViewById(R.id.fullName);
        EditText userEmailId =(EditText) findViewById(R.id.userEmailId);
        EditText mobileNumber =(EditText) findViewById(R.id.mobileNumber);
        EditText location =(EditText) findViewById(R.id.location);
        EditText city =(EditText) findViewById(R.id.city);
        EditText post_code =(EditText) findViewById(R.id.post_code);
        EditText address =(EditText) findViewById(R.id.address);

        Intent intent = getIntent();
        String fName = intent.getStringExtra("name");
        name.setText(fName);

        String fEmail = intent.getStringExtra("email");
        userEmailId.setText(fEmail);

        String fmobile = intent.getStringExtra("mobile");
        mobileNumber.setText(fmobile);


        String flocation= intent.getStringExtra("location");
        location.setText(flocation);

        String fCity = intent.getStringExtra("city");
        city.setText(fCity);



        String fpostCode = intent.getStringExtra("post_code");
        post_code.setText(fpostCode);

        String fAddress = intent.getStringExtra("address");
        address.setText(fAddress);


        Button editBtn =(Button) findViewById(R.id.editBtn);
        Button continueBtn =(Button) findViewById(R.id.continueBtn);


        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialogBox();
            }
        });


        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent clothIntent = new Intent(Submition.this, FinalShopping.class);
                startActivity(clothIntent);
            }
        });

    }

    public void dialogBox() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("اطلاعات شما با موفقیت ویرایش شد");
        alertDialogBuilder.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });



        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
