package com.music.saba.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;


/**
 * Created by Arvin on 31/01/2018.
 */

public class SignUpActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences = PreferenceManager
            .getDefaultSharedPreferences(G.context);
    SharedPreferences.Editor editor = sharedPreferences.edit();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final EditText edtFullName = (EditText)findViewById(R.id.fullName);
        final EditText edtEmail = (EditText)findViewById(R.id.userEmailId);
        final EditText edtConfirmPassword =(EditText)findViewById(R.id.confirmPassword);
        final EditText edtPassword =(EditText)findViewById(R.id.password);
        CheckBox chbConditions = (CheckBox)findViewById(R.id.terms_conditions);
        Button BtnSignUp = (Button)findViewById(R.id.signUpBtn);


        chbConditions.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // checkbox status is changed from uncheck to checked.
                if (!isChecked) {
                    // show password
                    edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    edtConfirmPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // hide password
                    edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    edtConfirmPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });



        BtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String conf = edtConfirmPassword.getText().toString();

                final String email = edtEmail.getText().toString();

                final String pass = edtPassword.getText().toString();

                if (!isValidEmail(email)) {
                    edtEmail.setError("ایمیل نامعتبر");
                    return;
                }

                if (!conf.equals(pass)){
                    edtPassword.setError("رمزعبور با هم یکی نیست");
                    return;
                }

                if (!isValidPassword(pass)) {
                    edtPassword.setError("رمزعبور نامعتبر");
                }

                else {

                    signUp(edtEmail.getText().toString(), edtPassword.getText().toString() ,edtFullName.getText().toString());
                }

            }
        });

    }

//


    //compare password and confirm password

//    String confPass = ((EditText)findViewById(R.id.confirmPassword)).getText().toString();
//    String pass = ((EditText)findViewById(R.id.password)).getText().toString();
//    boolean correct = pass.equals(confPass);


    // validating email id
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // validating password with retype password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() >= 6) {
            return true;
        } else {
            return false;
        }
    }


    private static final String JSON_URL = "http://dimia.ir/api/create";

    private void signUp(final String email, final String password, final String username) {
        StringRequest postRequest = new StringRequest(Request.Method.POST, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.i("LOG",""+response);
                            Log.i("LOG",""+response);
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.getString("status").equals("false")) {
                                Toast.makeText(getApplicationContext(), "" + jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                                Log.d("Response", "" + jsonObject.getString("message"));
                            }

                            else {
                                JSONObject jsonUser = new JSONObject(jsonObject.getString("user"));
                                editor.putString("email", jsonUser.getString("email"));
                                editor.putString("name", jsonUser.getString("name"));
                                editor.putInt("id",jsonUser.getInt("id"));
                                editor.apply();

                                Toast.makeText(getApplicationContext(), "شما با موفقیت عضو شدید", Toast.LENGTH_SHORT).show();
                                Intent loginIntent = new Intent(SignUpActivity.this, ToolbarActivity.class);
                                SignUpActivity.this.startActivity(loginIntent);
                            }

                            Log.d("Response", "" + jsonObject.getString("status"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        // response
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", "" + error.getMessage());
                    }
                }
        )

        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("email", email);
                params.put("password", password);
                params.put("name", username);
                return params;
            }
        };

        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //adding the string request to request queue
        requestQueue.add(postRequest);
    }

}

