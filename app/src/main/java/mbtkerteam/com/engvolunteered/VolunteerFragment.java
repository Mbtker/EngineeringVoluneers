package mbtkerteam.com.engvolunteered;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.skydoves.powerspinner.IconSpinnerItem;
import com.skydoves.powerspinner.OnSpinnerItemSelectedListener;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import mbtkerteam.com.engvolunteered.Helpers.CityAdapter;
import mbtkerteam.com.engvolunteered.Helpers.VolunteerAdapters;
import mbtkerteam.com.engvolunteered.Helpers.VolunteerModel;

public class VolunteerFragment extends Fragment {


    TextView ChangeCityButton, ChangeFieldButton, SearchButton;

    GridView MyListView;
    TextView NoDataTxt;
    ProgressBar progressBar;

    String FinalCityName = "الكـل";

    private AlertDialog dialogCity;

    public VolunteerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_volunteer, container, false);

        ChangeCityButton = (TextView) view.findViewById(R.id.ChangeCityButton);
        ChangeFieldButton = (TextView) view.findViewById(R.id.ChangeFieldButton);
        SearchButton = (TextView) view.findViewById(R.id.SearchButton);

        MyListView = (GridView) view.findViewById(R.id.MyListView);
        NoDataTxt = (TextView) view.findViewById(R.id.NoDataTxt);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

        ChangeCityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                OpenCitesDialog();

            }
        });

        ChangeFieldButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                OpenFilesDialog();

            }
        });

        SearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                OpenSearchDialog();
            }
        });

        initData(FinalCityName);

        return view;
    }

    public void initData(String CityName)
    {
        ChangeCityButton.setText("المدينة : " + CityName);

        MyListView.setVisibility(View.GONE);
        NoDataTxt.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 1s = 1000ms

                if (CityName.equals("الكـل"))
                {
                    VolunteerAdapters volunteerAdapters = new VolunteerAdapters(getActivity(), IntroActivity.VolunteerList);
                    MyListView.setAdapter(volunteerAdapters);

                    MyListView.setVisibility(View.VISIBLE);
                    NoDataTxt.setVisibility(View.GONE);
                    progressBar.setVisibility(View.GONE);

                } else
                {
                    ArrayList<VolunteerModel> VolunteerList = new ArrayList<>();

                    for (int x=0; x < IntroActivity.VolunteerList.size(); x++)
                    {
                        if (IntroActivity.VolunteerList.get(x).getCityName() == CityName)
                        {
                            VolunteerList.add(IntroActivity.VolunteerList.get(x));
                        }
                    }

                    if (VolunteerList.size() > 0)
                    {
                        VolunteerAdapters volunteerAdapters = new VolunteerAdapters(getActivity(), VolunteerList);
                        MyListView.setAdapter(volunteerAdapters);

                        MyListView.setVisibility(View.VISIBLE);
                        NoDataTxt.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);

                    } else
                    {
                        MyListView.setVisibility(View.GONE);
                        NoDataTxt.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                    }

                }


            }

        }, 500);
    }

    private void OpenCitesDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.select_city_dialog, null);
        ListView listView = (ListView) row.findViewById(R.id.MyListView);

        listView.setAdapter(new CityAdapter(getContext(), IntroActivity.CityArray));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                try {

                    FinalCityName = IntroActivity.CityArray.get(i).toString();

                    Log.d("**** FinalCityName ", FinalCityName);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d("**** Error ", e.getLocalizedMessage());

                }

                initData(FinalCityName);

                dialogCity.dismiss();
            }
        });

        builder.setView(row);

        dialogCity = builder.create();


//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            dialogCity.getWindow().setBackgroundDrawable(getContext().getDrawable(R.drawable.dialog_out_bg));
//        }

        dialogCity.show();

        dialogCity.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(16);
        dialogCity.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(14);

        int width = (int)(getResources().getDisplayMetrics().widthPixels*0.80);
        int height = (int)(getResources().getDisplayMetrics().heightPixels*0.55);

        dialogCity.getWindow().setLayout(width, height);
    }

    private void OpenFilesDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.select_city_dialog, null);
        ListView listView = (ListView) row.findViewById(R.id.MyListView);

        listView.setAdapter(new CityAdapter(getContext(), IntroActivity.FilesArray));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String FinalFiled = "الكـل";

                try {

                    FinalFiled = IntroActivity.FilesArray.get(i).toString();


                } catch (JSONException e) {
                    e.printStackTrace();

                }

                ChangeFieldButton.setText("المجال : " + FinalFiled);

                ShowByFiled(FinalFiled);

                dialogCity.dismiss();
            }
        });

        builder.setView(row);

        dialogCity = builder.create();


//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            dialogCity.getWindow().setBackgroundDrawable(getContext().getDrawable(R.drawable.dialog_out_bg));
//        }

        dialogCity.show();

        dialogCity.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(16);
        dialogCity.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(14);

        int width = (int)(getResources().getDisplayMetrics().widthPixels*0.80);
        int height = (int)(getResources().getDisplayMetrics().heightPixels*0.55);

        dialogCity.getWindow().setLayout(width, height);
    }

    public void ShowByFiled(String FinalFiled)
    {
        MyListView.setVisibility(View.GONE);
        NoDataTxt.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 1s = 1000ms

                if (FinalFiled.equals("الكـل"))
                {
                    VolunteerAdapters volunteerAdapters = new VolunteerAdapters(getActivity(), IntroActivity.VolunteerList);
                    MyListView.setAdapter(volunteerAdapters);

                    MyListView.setVisibility(View.VISIBLE);
                    NoDataTxt.setVisibility(View.GONE);
                    progressBar.setVisibility(View.GONE);

                } else
                {
                    ArrayList<VolunteerModel> VolunteerList = new ArrayList<>();

                    for (int x=0; x < IntroActivity.VolunteerList.size(); x++)
                    {
                        if (IntroActivity.VolunteerList.get(x).getFiled() == FinalFiled)
                        {
                            VolunteerList.add(IntroActivity.VolunteerList.get(x));
                        }
                    }

                    if (VolunteerList.size() > 0)
                    {
                        VolunteerAdapters volunteerAdapters = new VolunteerAdapters(getActivity(), VolunteerList);
                        MyListView.setAdapter(volunteerAdapters);

                        MyListView.setVisibility(View.VISIBLE);
                        NoDataTxt.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);

                    } else
                    {
                        MyListView.setVisibility(View.GONE);
                        NoDataTxt.setVisibility(View.VISIBLE);
                        progressBar.setVisibility(View.GONE);
                    }

                }
            }

        }, 500);
    }

    private void OpenSearchDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.adv_search_dialog, null);
        ListView listView = (ListView) row.findViewById(R.id.MyListView);

        com.skydoves.powerspinner.PowerSpinnerView CityEditTxt = (com.skydoves.powerspinner.PowerSpinnerView) row.findViewById(R.id.CityEditTxt);
        com.skydoves.powerspinner.PowerSpinnerView GanderEditTxt = (com.skydoves.powerspinner.PowerSpinnerView) row.findViewById(R.id.GanderEditTxt);
        com.skydoves.powerspinner.PowerSpinnerView FiledEditTxt = (com.skydoves.powerspinner.PowerSpinnerView) row.findViewById(R.id.FiledEditTxt);

        Button SearchButton = (Button) row.findViewById(R.id.SearchButton);

        CityEditTxt.setItems(R.array.Cites);
        GanderEditTxt.setItems(R.array.gander);
        FiledEditTxt.setItems(R.array.fields);

        SearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String GetSlected = GanderEditTxt.getText().toString();

             //   Toast.makeText(getContext(), GetSlected, Toast.LENGTH_LONG).show();

                initData(FinalCityName);

                dialogCity.dismiss();
            }
        });

        builder.setView(row);

        dialogCity = builder.create();


//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            dialogCity.getWindow().setBackgroundDrawable(getContext().getDrawable(R.drawable.dialog_out_bg));
//        }

        dialogCity.show();

        dialogCity.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(16);
        dialogCity.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(14);

        int width = (int)(getResources().getDisplayMetrics().widthPixels*0.90);
        int height = (int)(getResources().getDisplayMetrics().heightPixels*0.55);

        dialogCity.getWindow().setLayout(width, WindowManager.LayoutParams.WRAP_CONTENT);
    }
}
