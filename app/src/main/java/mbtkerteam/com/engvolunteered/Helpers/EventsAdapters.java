package mbtkerteam.com.engvolunteered.Helpers;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

import mbtkerteam.com.engvolunteered.R;

public class EventsAdapters extends BaseAdapter {

    private final Context context;
    private ArrayList<EventsModel> MyArray;

    // 1
    public EventsAdapters(Context context, ArrayList<EventsModel> MyArray) {
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
            convertV = layoutInflater.inflate(R.layout.layout_events_list, null);
        }

        final View convertView = convertV;

        LinearLayout CellLayout = (LinearLayout) convertView.findViewById(R.id.CellLayout);
        TextView TopicTxt = (TextView) convertView.findViewById(R.id.TopicTxt);
        TextView DateTxt = (TextView) convertView.findViewById(R.id.DateTxt);
        TextView PlaceTxt = (TextView) convertView.findViewById(R.id.PlaceTxt);

        TopicTxt.setText("");
        DateTxt.setText("");
        PlaceTxt.setText("");

        TopicTxt.setText(MyArray.get(position).getTopic());
        DateTxt.setText("التاريخ : " + MyArray.get(position).getDate());
        PlaceTxt.setText("المكان : " + MyArray.get(position).getPlace());

        CellLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(CellLayout.getContext(), "عرض تفاصيل الفعالية", Toast.LENGTH_LONG).show();

            }
        });

        return convertView;
    }


}
