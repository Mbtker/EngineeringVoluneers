package mbtkerteam.com.engvolunteered;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class VerificationLoginActivity extends AppCompatActivity {

    ProgressBar progressBar;
    EditText CodeEditTxt;
    TextView PhoneTxt;

    String PassPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_login);

        PassPhone = getIntent().getExtras().getString("Phone");

        PhoneTxt = (TextView) findViewById(R.id.PhoneTxt);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        CodeEditTxt = (EditText) findViewById(R.id.CodeEditTxt);

        PhoneTxt.setText(PassPhone);
    }


    public void ContinueButton(View view) {

        if (CodeEditTxt.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "الرجاء ادخال الكود!", Toast.LENGTH_LONG).show();

            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 1s = 1000ms

                Intent intent = new Intent(getApplicationContext(), EngMainActivity.class);
                startActivity(intent);
            }

        }, 3000);

    }


}