package mbtkerteam.com.engvolunteered;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements BottomNewAccountDialog.BottomSheetListener {

    ProgressBar progressBar;
    EditText PhoneEditTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        PhoneEditTxt = (EditText) findViewById(R.id.PhoneEditTxt);
    }


    public void SingInButton(View view) {

        if (PhoneEditTxt.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "الرجاء ادخال رقم الجوال!", Toast.LENGTH_LONG).show();

            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 1s = 1000ms

                Intent intent = new Intent(getApplicationContext(), VerificationLoginActivity.class);
                intent.putExtra("Phone", PhoneEditTxt.getText().toString());
                startActivity(intent);

            }

        }, 2000);

    }

    public void CreateAccountButton(View view) {

        BottomNewAccountDialog bottomSheet = new BottomNewAccountDialog();
        bottomSheet.show(getSupportFragmentManager(), "BottomSheetDialog");
    }

    public void SkipButton(View view) {

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void onButtonClicked(int text) {

        if (text == 1)
        {
            Intent intent = new Intent(getApplicationContext(), CreateEngAccountActivity.class);
            startActivity(intent);

        } else
        {
            Intent intent = new Intent(getApplicationContext(), OrganisationLoginActivity.class);
            startActivity(intent);
        }
    }
}