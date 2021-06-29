package com.nipun.ujjawal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText editTextPhone;
    Button buttonContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_select);
        editTextPhone = findViewById(R.id.idEdtPhoneNumber);
        buttonContinue = findViewById(R.id.contine);
        TextView call;
        call = findViewById(R.id.call1);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneIntent =
                        new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "121", null));
                startActivity(phoneIntent);
            }
        });
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String number = editTextPhone.getText().toString().trim();
                String code = "+91";
                if (number.isEmpty() || number.length() < 10) {
                    editTextPhone.setError("Valid number is required");
                    editTextPhone.requestFocus();
                    return;
                }

                String phoneNumber = code + number;

                Intent intent = new Intent(LoginActivity.this, OtpActivity.class);
                intent.putExtra("phoneNumber", phoneNumber);
                startActivity(intent);
                saveData();

            }
        });
    }

    /*@Override
    protected void onStart() {
        super.onStart();

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(intent);
        }
    }*/

    private void saveData() {
        sharedPrefNames name = new sharedPrefNames();
        SharedPreferences pref = getSharedPreferences(name.SHARED_PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        editor.apply();
    }


}