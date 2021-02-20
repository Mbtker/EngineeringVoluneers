package mbtkerteam.com.engvolunteered.Helpers;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import mbtkerteam.com.engvolunteered.LoginActivity;
import mbtkerteam.com.engvolunteered.R;

public class LogOutDialogClass extends Dialog {

    public Activity c;
    public Dialog d;
    public Button OkButt, CancelButt;
    public TextView MessageTxt;
    public Context context;

    public LogOutDialogClass(Context context) {
        super(context);
        // super(a);
        // TODO Auto-generated constructor stub
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.log_out_dialog);

        getWindow().setLayout((int)(GlobalVariable.Width * .9),(int)(ViewGroup.LayoutParams.WRAP_CONTENT));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setBackgroundDrawable(context.getDrawable(R.drawable.log_out_bg));
        }

        this.setCancelable(false);

        MessageTxt = (TextView) findViewById(R.id.MessgaeTextView);
        OkButt = (Button) findViewById(R.id.OkButton);
        CancelButt = (Button) findViewById(R.id.CancelButton);

        OkButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preferences = getContext().getSharedPreferences("LoginStatus", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.clear();
                editor.commit();

                Intent intent = new Intent(context, LoginActivity.class);
                context.startActivity(intent);
            }
        });

        CancelButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dismiss();

            }
        });

    }

}
