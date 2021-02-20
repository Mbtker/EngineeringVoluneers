package mbtkerteam.com.engvolunteered.Helpers;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import mbtkerteam.com.engvolunteered.IntroActivity;
import mbtkerteam.com.engvolunteered.R;
import mbtkerteam.com.engvolunteered.VolunteerDetailsActivity;

public class VolunteerAdapters extends BaseAdapter {

    private final Context context;
    private ArrayList<VolunteerModel> MyArray;

    // 1
    public VolunteerAdapters(Context context, ArrayList<VolunteerModel> MyArray) {
        this.context = context;
        this.MyArray = MyArray;
    }

    // 2
    @Override
    public int getCount() {
        return MyArray.size();
    }

    // 3
    @Override
    public long getItemId(int position) {
        return 0;
    }


    // 4
    @Override
    public Object getItem(int position) {
        return null;
    }

    // 5
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View getView(final int position, View convertV, ViewGroup parent) {

        if (convertV == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertV = layoutInflater.inflate(R.layout.layout_volunteer_list, null);
        }

        final View convertView = convertV;

        ImageView MyImageView = (ImageView) convertView.findViewById(R.id.MyImageView);


        ImageView FavoriteButton = (ImageView) convertView.findViewById(R.id.FavoriteButton);
        ImageView ShearingButton = (ImageView) convertView.findViewById(R.id.ShearingButton);
        TextView TopicTxt = (TextView) convertView.findViewById(R.id.TopicTxt);
        TextView DiseTxt = (TextView) convertView.findViewById(R.id.DiseTxt);
        TextView DayTxt = (TextView) convertView.findViewById(R.id.DayTxt);
        TextView NeedTxt = (TextView) convertView.findViewById(R.id.NeedTxt);
        TextView CityTxt = (TextView) convertView.findViewById(R.id.CityTxt);
        ProgressBar progressBar = (ProgressBar) convertView.findViewById(R.id.progressBar);
        LinearLayout CellLayout = (LinearLayout) convertView.findViewById(R.id.CellLayout);


        FavoriteButton.setImageResource(R.drawable.icon_favorite_off);
        // Picasso.with(convertView.getContext()).load(MyArray.get(position).Image).into(LogoImage);

        if (MyArray.get(position).isiSLoaded())
        {
            Glide.with(convertView.getContext())
                    .load(R.drawable.small_img)
                    .fitCenter()
                    .into(MyImageView);

            progressBar.setVisibility(View.GONE);

        } else
        {
            Glide.with(convertView.getContext())
                    .load(R.drawable.no_img)
                    .fitCenter()
                    .into(MyImageView);

            progressBar.setVisibility(View.VISIBLE);

            int Time = 500;

            if (position == 1 || position == 3 || position == 5 || position == 7 || position == 9 || position == 11)
            {
                Time = 1000;
            }

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 1s = 1000ms

                    Glide.with(convertView.getContext())
                            .load(R.drawable.small_img)
                            .fitCenter()
                            .into(MyImageView);

                    progressBar.setVisibility(View.GONE);

                    MyArray.get(position).setiSLoaded(true);
                    IntroActivity.VolunteerList.get(position).setiSLoaded(true);
                }

            }, Time);
        }

        if (MyArray.get(position).isiSFavorite())
        {
            FavoriteButton.setImageResource(R.drawable.icon_favorite_on);
        } else
        {
            FavoriteButton.setImageResource(R.drawable.icon_favorite_off);
        }

        FavoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (MyArray.get(position).isiSFavorite())
                {
                    MyArray.get(position).setiSFavorite(false);
                    IntroActivity.VolunteerList.get(position).setiSFavorite(false);
                    FavoriteButton.setImageResource(R.drawable.icon_favorite_off);

                } else
                {
                    MyArray.get(position).setiSFavorite(true);
                    IntroActivity.VolunteerList.get(position).setiSFavorite(true);
                    FavoriteButton.setImageResource(R.drawable.icon_favorite_on);
                }
            }
        });

        ShearingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT, "التطوع الهندسي");
                    String sAux = "\n*وجدة هذه الفرصة التطوعية ";
                    String sAuxx = "\n العنوان : ";
                    String sAuxxx = MyArray.get(position).getTopic();
                    String sAuxxxx = ", حمل التطبيق الان لاجهزة الاندرويد : ";
                    // String sAuxxxxx = "\nhttps://goo.gl/Zv5kbx\n";
                    String sAuxxxxx = "Link ";
                    String sAuxxxxxx = "أجهزة الايفون: ";
                    // String sAuxxxxxxx = "\nhttps://appsto.re/sa/oQFcjb.i";
                    String sAuxxxxxxx = " Link ";
                    sAux = sAux + sAuxx + sAuxxx + sAuxxxx + sAuxxxxx + sAuxxxxxx + sAuxxxxxxx;
                    i.putExtra(Intent.EXTRA_TEXT, sAux);
                    ShearingButton.getContext().startActivity(Intent.createChooser(i, "آختر .."));
                } catch(Exception e) {
                    //e.toString();
                }
            }
        });

        final String CityTopic = "المدينة : ";

        TopicTxt.setText(MyArray.get(position).Topic);
        DiseTxt.setText(MyArray.get(position).Description);
        DayTxt.setText(MyArray.get(position).Date);
        NeedTxt.setText(MyArray.get(position).NumberOfNeed);
        CityTxt.setText(CityTopic + MyArray.get(position).CityName);


        CellLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                VolunteerModel volunteer = MyArray.get(position);

                Intent intent = new Intent(context, VolunteerDetailsActivity.class);
                intent.putExtra("company", volunteer);
                context.startActivity(intent);

            }
        });

        return convertView;
    }


}
