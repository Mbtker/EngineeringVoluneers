package mbtkerteam.com.engvolunteered.Helpers;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

import mbtkerteam.com.engvolunteered.R;

public class CityAdapter extends BaseAdapter {

    Context context;

    JSONArray Categoris = new JSONArray();

    public CityAdapter(Context context, JSONArray Categoris)
    {
        this.context = context;
        this.Categoris = Categoris;

        Resources resources = context.getResources();

    }

    @Override
    public int getCount() {
        return Categoris.length();
    }

    @Override
    public Object getItem(int i) {
        try {
            return Categoris.get(i);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "";
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.custom_city_listview, viewGroup, false);

        TextView Name = (TextView) row.findViewById(R.id.NameTxt);

        try {
            Name.setText(Categoris.getString(i));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return row;
    }
}
