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

public class GroupsAdapters extends BaseAdapter {

    private final Context context;
    private ArrayList<GroupsModel> MyArray;

    // 1
    public GroupsAdapters(Context context, ArrayList<GroupsModel> MyArray) {
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
            convertV = layoutInflater.inflate(R.layout.layout_groups_list, null);
        }

        final View convertView = convertV;

        LinearLayout CellLayout = (LinearLayout) convertView.findViewById(R.id.CellLayout);
        TextView TopicTxt = (TextView) convertView.findViewById(R.id.TopicTxt);

        TopicTxt.setText("");
        TopicTxt.setText(MyArray.get(position).getTopic());

        CellLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(CellLayout.getContext(), "عرض تفاصيل الفرقة والانضمام", Toast.LENGTH_LONG).show();

            }
        });

        return convertView;
    }


}
