package mbtkerteam.com.engvolunteered.Helpers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

import mbtkerteam.com.engvolunteered.IntroActivity;
import mbtkerteam.com.engvolunteered.R;

public class InterestingAdapters extends BaseAdapter {

    private final Context mContext;
    private ArrayList<InterestingModel> MyList = new ArrayList<>();

    // 1
    public InterestingAdapters(Context context, ArrayList<InterestingModel> MyList) {
        this.mContext = context;
        this.MyList = MyList;
    }

    // 2
    @Override
    public int getCount() {
        return MyList.size();
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.layout_intrests, null);
        }

        final LinearLayout GoToDetailsButton = (LinearLayout) convertView.findViewById(R.id.GoToDetailsButton);
     //   final LinearLayout bg_image = (LinearLayout) convertView.findViewById(R.id.bg_image);

        final ImageView SelectedImage = (ImageView) convertView.findViewById(R.id.SelectedImage);

        TextView CategoryName = (TextView) convertView.findViewById(R.id.CategoryName);

        CategoryName.setText("");
        SelectedImage.setVisibility(View.INVISIBLE);
      //  bg_image.setVisibility(View.INVISIBLE);

        CategoryName.setText("");

        CategoryName.setText(MyList.get(position).Name);

        if (IntroActivity.InterestingList.get(position).iSSelected)
        {
          //  bg_image.setVisibility(View.VISIBLE);
        }

        GoToDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (IntroActivity.InterestingList.get(position).iSSelected)
                {
                    IntroActivity.InterestingList.get(position).iSSelected = false;
                 //   bg_image.setVisibility(View.INVISIBLE);
                    SelectedImage.setVisibility(View.INVISIBLE);

                } else
                {
                    IntroActivity.InterestingList.get(position).iSSelected = true;
                 //   bg_image.setVisibility(View.VISIBLE);
                    SelectedImage.setVisibility(View.VISIBLE);

                }

            }
        });

        return convertView;
    }


}
