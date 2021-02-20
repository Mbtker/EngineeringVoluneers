package mbtkerteam.com.engvolunteered;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class OrganisationLoginActivity extends AppCompatActivity {

    EditText UserNameEditTxt, PassEditTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organisation_login);

        UserNameEditTxt = (EditText) findViewById(R.id.UserNameEditTxt);
        PassEditTxt = (EditText) findViewById(R.id.PassEditTxt);

    }


    public void SingInButton(View view) {

        if (UserNameEditTxt.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "الرجاء ادخال اسم المستخدم!", Toast.LENGTH_LONG).show();

        } else if (PassEditTxt.getText().toString().isEmpty())
        {
            Toast.makeText(getApplicationContext(), "الرجاء ادخل كلمة المرور!", Toast.LENGTH_LONG).show();

        } else
        {

        }
    }
}