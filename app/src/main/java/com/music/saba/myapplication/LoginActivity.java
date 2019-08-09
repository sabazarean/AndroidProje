package com.music.saba.myapplication;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.google.common.util.concurrent.FutureCallback;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.ConvertFuture;
import com.koushikdutta.ion.Ion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LoginActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences = PreferenceManager
            .getDefaultSharedPreferences(G.context);
    SharedPreferences.Editor editor = sharedPreferences.edit();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        final EditText edtEmail = (EditText) findViewById(R.id.userEmailId);
        final EditText edtPassword = (EditText) findViewById(R.id.password);
        Button BtnLogin = (Button) findViewById(R.id.loginBtn);
        Button BtnSignUp = (Button) findViewById(R.id.signUpBtn);
        TextView txvForgot_password = (TextView) findViewById(R.id.forgot_password);
        CheckBox checkBox = (CheckBox) findViewById(R.id.show_hide_password);


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // checkbox status is changed from uncheck to checked.
                if (!isChecked) {
                    // show password
                    edtPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    // hide password
                    edtPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });


        BtnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = edtEmail.getText().toString();

                final String pass = edtPassword.getText().toString();

                if (!isValidEmail(email)) {
                    edtEmail.setError("Invalid Email");
                    return;
                }

                if (!isValidPassword(pass)) {
                    edtPassword.setError("Invalid Password");
                } else {
                    login(edtEmail.getText().toString(), edtPassword.getText().toString());
                }
//            Toast.makeText(SignUpActivity.class,"please complete tasks",Toast.LENGTH_SHORT).show();
            }
        });

        BtnSignUp.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MainIntent = new Intent(LoginActivity.this, SignUpActivity.class);
                LoginActivity.this.startActivity(MainIntent);
            }
        });
    }


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



    private static final String JSON_URL = "http://dimia.ir/api/login";

    private void login(final String email, final String password) {
        StringRequest postRequest = new StringRequest(Request.Method.POST, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("LOG", "" + response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.getString("status").equals("false")) {
                                Toast.makeText(getApplicationContext(), "" + jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                                Log.d("Response", "" + jsonObject.getString("message"));
                            } else {
                                JSONObject jsonUser = new JSONObject(jsonObject.getString("user"));
                                editor.putString("email", jsonUser.getString("email"));
                                editor.putString("name", jsonUser.getString("name"));
                                editor.putInt("id",jsonUser.getInt("id"));
                                editor.apply();

                                Intent loginIntent = new Intent(LoginActivity.this, ToolbarActivity.class);
                                LoginActivity.this.startActivity(loginIntent);
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
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("email", email);
                params.put("password", password);

                return params;
            }
        };

        //creating a request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        //adding the string request to request queue
        requestQueue.add(postRequest);
    }
}

