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

public class IdeaAdapters extends BaseAdapter {

    private final Context context;
    private ArrayList<String> MyArray;

    // 1
    public IdeaAdapters(Context context, ArrayList<String> MyArray) {
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
            convertV = layoutInflater.inflate(R.layout.layout_idea_list, null);
        }

        final View convertView = convertV;

        LinearLayout CellLayout = (LinearLayout) convertView.findViewById(R.id.CellLayout);
        TextView TopicTxt = (TextView) convertView.findViewById(R.id.TopicTxt);

        TopicTxt.setText("");
        TopicTxt.setText(MyArray.get(position));

        CellLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(CellLayout.getContext(), "عرض تفاصيل الفكرة", Toast.LENGTH_LONG).show();

            }
        });

        return convertView;
    }


}
