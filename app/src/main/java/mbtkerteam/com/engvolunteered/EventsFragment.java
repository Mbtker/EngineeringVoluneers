package mbtkerteam.com.engvolunteered;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import mbtkerteam.com.engvolunteered.Helpers.ChallengesAdapters;
import mbtkerteam.com.engvolunteered.Helpers.ChallengesModel;
import mbtkerteam.com.engvolunteered.Helpers.EventsAdapters;

public class EventsFragment extends Fragment {

    GridView MyListView;
    TextView NoDataTxt;
    ProgressBar progressBar;

    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_events, container, false);

        MyListView = (GridView) view.findViewById(R.id.MyListView);
        NoDataTxt = (TextView) view.findViewById(R.id.NoDataTxt);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);

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

                EventsAdapters eventsAdapters = new EventsAdapters(getActivity(), IntroActivity.EventsList);
                MyListView.setAdapter(eventsAdapters);

                MyListView.setVisibility(View.VISIBLE);
                NoDataTxt.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);

            }

        }, 500);
    }

}
