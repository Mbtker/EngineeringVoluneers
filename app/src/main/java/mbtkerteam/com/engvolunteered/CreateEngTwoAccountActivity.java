package mbtkerteam.com.engvolunteered;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class CreateEngTwoAccountActivity extends AppCompatActivity {

    EditText NameEditTxt, NationalIDEditTxt, EngIDEditTxt, PhoneEditTxt, EmailEditTxt, SpecializationEditTxt, ExperienceEditTxt;
    ProgressBar progressBar;

    String PassNationalID, PassEngID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_eng_two_account);

        PassNationalID = getIntent().getExtras().getString("NationalID");
        PassEngID = getIntent().getExtras().getString("EngID");

        NameEditTxt = (EditText) findViewById(R.id.NameEditTxt);
        NationalIDEditTxt = (EditText) findViewById(R.id.NationalIDEditTxt);
        EngIDEditTxt = (EditText) findViewById(R.id.EngIDEditTxt);
        PhoneEditTxt = (EditText) findViewById(R.id.PhoneEditTxt);
        EmailEditTxt = (EditText) findViewById(R.id.EmailEditTxt);
        com.skydoves.powerspinner.PowerSpinnerView SpecializationEditTxt = (com.skydoves.powerspinner.PowerSpinnerView) findViewById(R.id.SpecializationEditTxt);
        ExperienceEditTxt = (EditText) findViewById(R.id.ExperienceEditTxt);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        SpecializationEditTxt.setItems(R.array.Filed);

        NationalIDEditTxt.setText(PassNationalID);
        EngIDEditTxt.setText(PassEngID);

        NationalIDEditTxt.setEnabled(false);
        EngIDEditTxt.setEnabled(false);

    }


    public void ContinueButton(View view) {

        if (NameEditTxt.getText().toString().isEmpty() || PhoneEditTxt.getText().toString().isEmpty() || EmailEditTxt.getText().toString().isEmpty() || ExperienceEditTxt.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "جميع الحقول مطلوبة!", Toast.LENGTH_LONG).show();

            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 1s = 1000ms

                SharedPreferences sharedPref = getSharedPreferences("LoginStatus", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean("iSLogin", true);
                editor.apply();

                Intent intent = new Intent(getApplicationContext(), SelectInterestingAtivity.class);
                startActivity(intent);
            }

        }, 3000);


    }
}