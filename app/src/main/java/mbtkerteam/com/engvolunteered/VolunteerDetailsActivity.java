package mbtkerteam.com.engvolunteered;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import mbtkerteam.com.engvolunteered.Helpers.VolunteerModel;

public class VolunteerDetailsActivity extends AppCompatActivity {

    TextView TopicTxt, DetailsTxt, DateTxt, NeedTxt, FiledTxt, GanderTxt, OnlineTxt, UrgentTxt, OrganizationTxt, ContactTxt, WebSiteTxt;
    ImageView ShearingButton, FavoriteButton;
    VolunteerModel volunteer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_details);

        volunteer = (VolunteerModel) getIntent().getSerializableExtra("company");

        ShearingButton = (ImageView) findViewById(R.id.ShearingButton);
        FavoriteButton = (ImageView) findViewById(R.id.FavoriteButton);

        TopicTxt = (TextView) findViewById(R.id.TopicTxt);
        DetailsTxt = (TextView) findViewById(R.id.DetailsTxt);
        DateTxt = (TextView) findViewById(R.id.DateTxt);
        NeedTxt = (TextView) findViewById(R.id.NeedTxt);
        FiledTxt = (TextView) findViewById(R.id.FiledTxt);
        GanderTxt = (TextView) findViewById(R.id.GanderTxt);
        OnlineTxt = (TextView) findViewById(R.id.OnlineTxt);
        UrgentTxt = (TextView) findViewById(R.id.UrgentTxt);

        OrganizationTxt = (TextView) findViewById(R.id.OrganizationTxt);
        ContactTxt = (TextView) findViewById(R.id.ContactTxt);
        WebSiteTxt = (TextView) findViewById(R.id.WebSiteTxt);

        if (volunteer.isiSFavorite())
        {
            FavoriteButton.setImageResource(R.drawable.icon_favorite_on);

        } else
        {
            FavoriteButton.setImageResource(R.drawable.icon_favorite_off);
        }

        FavoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (volunteer.isiSFavorite())
                {
                    volunteer.setiSFavorite(false);
                    FavoriteButton.setImageResource(R.drawable.icon_favorite_off);

                } else
                {
                    volunteer.setiSFavorite(true);
                    FavoriteButton.setImageResource(R.drawable.icon_favorite_on);
                }

//                for (int i=0; i < IntroActivity.VolunteerList.size(); i++)
//                {
//                    if (IntroActivity.VolunteerList.get(i).getId().equals(volunteer.getId()))
//                    {
//                        IntroActivity.VolunteerList.get(i).setiSFavorite(FinaliSTrue);
//                    }
//                }

            }
        });

        TopicTxt.setText(volunteer.getTopic());
        DetailsTxt.setText(volunteer.getDescription());

        DateTxt.setText("التاريخ : " + volunteer.getDate());
        NeedTxt.setText("الاحتياج : " + volunteer.getNumberOfNeed());
        FiledTxt.setText("المجال : " + volunteer.getFiled());

        if (volunteer.getGender().equals("1"))
        {
            GanderTxt.setText("الجنس : ذكور");

        } else  if (volunteer.getGender().equals("2"))
        {
            GanderTxt.setText("الجنس : اناث");

        } else
        {
            GanderTxt.setText("الجنس : غير محدد");
        }

        if (volunteer.isiSOnline())
        {
            OnlineTxt.setText("عن بعد : نعم");

        } else
        {
            OnlineTxt.setText("عن بعد : لا");
        }

        OrganizationTxt.setText(volunteer.getTopic());
        ContactTxt.setText("رقم التواصل : 0112457854");
        WebSiteTxt.setText("الموقع الالكتروني : لا يوجد");

        ShearingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT, "التطوع الهندسي");
                    String sAux = "\n*وجدة هذه الفرصة التطوعية ";
                    String sAuxx = "\n العنوان : ";
                    String sAuxxx = volunteer.getTopic();
                    String sAuxxxx = ", حمل التطبيق الان لاجهزة الاندرويد : ";
                    // String sAuxxxxx = "\nhttps://goo.gl/Zv5kbx\n";
                    String sAuxxxxx = "Link ";
                    String sAuxxxxxx = "أجهزة الايفون: ";
                    // String sAuxxxxxxx = "\nhttps://appsto.re/sa/oQFcjb.i";
                    String sAuxxxxxxx = " Link ";
                    sAux = sAux + sAuxx + sAuxxx + sAuxxxx + sAuxxxxx + sAuxxxxxx + sAuxxxxxxx;
                    i.putExtra(Intent.EXTRA_TEXT, sAux);
                    startActivity(Intent.createChooser(i, "آختر .."));
                } catch(Exception e) {
                    //e.toString();
                }
            }
        });

    }


    public void joiningButton(View view) {

        Toast.makeText(getApplicationContext(), "تم ارسال طلب المشاركة بنجاح, سوف يتم التواصل معك قريباً", Toast.LENGTH_LONG).show();
    }
}