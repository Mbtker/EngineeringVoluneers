package mbtkerteam.com.engvolunteered;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class CreateEngAccountActivity extends AppCompatActivity {


    EditText NationalIDEditTxt, EngIDEditTxt;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_eng_account);

        NationalIDEditTxt = (EditText) findViewById(R.id.NationalIDEditTxt);
        EngIDEditTxt = (EditText) findViewById(R.id.EngIDEditTxt);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);


    }

    public void ContinueButton(View view) {

        if (NationalIDEditTxt.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "الرجاء ادخل رقم السجل المدني!", Toast.LENGTH_LONG).show();

        } else if (EngIDEditTxt.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "الرجاء ادخال رقم العضوية!", Toast.LENGTH_LONG).show();

        } else
        {
            progressBar.setVisibility(View.VISIBLE);

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 1s = 1000ms

                    progressBar.setVisibility(View.INVISIBLE);

                    Intent intent = new Intent(getApplicationContext(), CreateEngTwoAccountActivity.class);
                    intent.putExtra("NationalID", NationalIDEditTxt.getText().toString());
                    intent.putExtra("EngID", EngIDEditTxt.getText().toString());
                    startActivity(intent);

                    finish();
                }

            }, 2000);
        }
    }
}