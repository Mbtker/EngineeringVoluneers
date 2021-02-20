package mbtkerteam.com.engvolunteered;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import org.json.JSONException;

import java.util.ArrayList;

import mbtkerteam.com.engvolunteered.Helpers.CityAdapter;
import mbtkerteam.com.engvolunteered.Helpers.GroupsAdapters;
import mbtkerteam.com.engvolunteered.Helpers.GroupsModel;
import mbtkerteam.com.engvolunteered.Helpers.VolunteerAdapters;
import mbtkerteam.com.engvolunteered.Helpers.VolunteerModel;

public class GroupsFragment extends Fragment {

    TextView NewButton;

    GridView MyListView;
    TextView NoDataTxt;
    ProgressBar progressBar;

    private AlertDialog MyDialog;

    public GroupsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_groups, container, false);

        NewButton = (TextView) view.findViewById(R.id.NewButton);


        MyListView = (GridView) view.findViewById(R.id.MyListView);
        NoDataTxt = (TextView) view.findViewById(R.id.NoDataTxt);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

        NewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                OpenNewDialog();
            }
        });

        initData();

        return view;
    }

    public void initData()
    {
        MyListView.setVisibility(View.GONE);
        NoDataTxt.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 1s = 1000ms

                GroupsAdapters groupsAdapters = new GroupsAdapters(getActivity(), IntroActivity.GroupsList);
                MyListView.setAdapter(groupsAdapters);

                MyListView.setVisibility(View.VISIBLE);
                NoDataTxt.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);

            }

        }, 500);
    }

    private void OpenNewDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.new_dialog, null);
        TextView NameTxt = (TextView) row.findViewById(R.id.NameTxt);
        Button CreateButton = (Button) row.findViewById(R.id.CreateButton);

        CreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (NameTxt.getText().toString().isEmpty())
                {
                    Toast.makeText(getContext(), "الرجاء كتابة عنوان الفرقة!", Toast.LENGTH_LONG).show();

                    return;
                }

               // IntroActivity.GroupsList.add(new GroupsModel("7",NameTxt.getText().toString(),""));

                Toast.makeText(getContext(), "تم ارسال طلب انشاء الفرقة للفريق المختص للمراجعة", Toast.LENGTH_LONG).show();

             //   initData();

                MyDialog.dismiss();
            }
        });

        builder.setView(row);

        MyDialog = builder.create();


//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            dialogCity.getWindow().setBackgroundDrawable(getContext().getDrawable(R.drawable.dialog_out_bg));
//        }

        MyDialog.show();

        MyDialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(16);
        MyDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(14);

        int width = (int)(getResources().getDisplayMetrics().widthPixels*0.90);
        int height = (int)(getResources().getDisplayMetrics().heightPixels*0.55);

        MyDialog.getWindow().setLayout(width, WindowManager.LayoutParams.WRAP_CONTENT);
    }

}
