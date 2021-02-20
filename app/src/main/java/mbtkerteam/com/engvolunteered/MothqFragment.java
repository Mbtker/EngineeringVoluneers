package mbtkerteam.com.engvolunteered;

import android.app.AlertDialog;
import android.content.Context;
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

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

import java.util.ArrayList;

import mbtkerteam.com.engvolunteered.Helpers.CategoriesAdapters;
import mbtkerteam.com.engvolunteered.Helpers.ChallengesAdapters;
import mbtkerteam.com.engvolunteered.Helpers.ChallengesModel;
import mbtkerteam.com.engvolunteered.Helpers.CityAdapter;
import mbtkerteam.com.engvolunteered.Helpers.MothqAdapters;
import mbtkerteam.com.engvolunteered.Helpers.VideosCategoriesModel;
import mbtkerteam.com.engvolunteered.Helpers.VolunteerAdapters;
import mbtkerteam.com.engvolunteered.Helpers.VolunteerModel;

public class MothqFragment extends Fragment {

    static GridView MyListView;
    static TextView NoDataTxt;
    static ProgressBar progressBar;


    private RecyclerView MyCategoriesListView;
    private ArrayList<VideosCategoriesModel> CategoriesList = new ArrayList<>();

    static ArrayList<String> VideosList = new ArrayList<>();

    static Context context;

    public MothqFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mothq, container, false);

        context = getContext();

        CategoriesList.add(new VideosCategoriesModel("1", "الكـل"));
        CategoriesList.add(new VideosCategoriesModel("2", "كهرباء"));
        CategoriesList.add(new VideosCategoriesModel("3", "بناء"));
        CategoriesList.add(new VideosCategoriesModel("4", "تصميم"));
        CategoriesList.add(new VideosCategoriesModel("5", "تصليح الاجهزة"));
        CategoriesList.add(new VideosCategoriesModel("6", "ترميم"));
        CategoriesList.add(new VideosCategoriesModel("7", "انشاء"));

        VideosList.add("تركيب سخان");
        VideosList.add("تركيب مكيف");
        VideosList.add("تصليح tv");
        VideosList.add("توصيل عداد");
        VideosList.add("انشاء مخطط");
        VideosList.add("استبدال بطارية سيارة");
        VideosList.add("ترميم غرفة");
        VideosList.add("تركيب افياش");

        MyCategoriesListView = (RecyclerView) view.findViewById(R.id.MyCategoriesListView);

        MyListView = (GridView) view.findViewById(R.id.MyListView);
        NoDataTxt = (TextView) view.findViewById(R.id.NoDataTxt);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        MyCategoriesListView.setLayoutManager(linearLayoutManager);

        CategoriesAdapters categoriesAdapters = new CategoriesAdapters(getContext(), CategoriesList);
        MyCategoriesListView.setAdapter(categoriesAdapters);

        initData();

        return view;
    }

    static public void initData()
    {
        MyListView.setVisibility(View.GONE);
        NoDataTxt.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 1s = 1000ms

                MothqAdapters mothqAdapters = new MothqAdapters(context, VideosList);
                MyListView.setAdapter(mothqAdapters);

                MyListView.setVisibility(View.VISIBLE);
                NoDataTxt.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);

            }

        }, 500);
    }
}
