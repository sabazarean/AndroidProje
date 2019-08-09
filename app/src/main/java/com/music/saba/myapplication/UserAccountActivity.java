package com.music.saba.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserAccountActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar3);

        Button submitInfo = (Button)findViewById(R.id.signUpBtn);



        submitInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(UserAccountActivity.this, Submition.class);




//                if (userEmailId.length()==0) {
//                    Toast.makeText(UserAccountActivity.this, "You did not enter a email", Toast.LENGTH_SHORT).show();
//                    return;
//                }

                EditText name =(EditText)findViewById(R.id.fullName);
                String text= name.getText().toString();


                EditText userEmailId =(EditText) findViewById(R.id.userEmailId);
                String text1= userEmailId.getText().toString();

                i.putExtra("name",text);

                i.putExtra("email",text1);

                EditText mobileNumber =(EditText) findViewById(R.id.mobileNumber);
                String text2= mobileNumber.getText().toString();
                i.putExtra("mobile",text2);

                EditText location =(EditText) findViewById(R.id.location);
                String text3= location.getText().toString();
                i.putExtra("location",text3);

                EditText city =(EditText) findViewById(R.id.city);
                String text4= city.getText().toString();
                i.putExtra("city",text4);

                EditText post_code =(EditText) findViewById(R.id.post_code);
                String text5= post_code.getText().toString();
                i.putExtra("post_code",text5);

                EditText address =(EditText) findViewById(R.id.address);
                String text6= address.getText().toString();
                i.putExtra("address",text6);





                startActivity(i);


            }
        });






    }




}
