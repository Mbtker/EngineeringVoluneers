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
import mbtkerteam.com.engvolunteered.Helpers.GroupsAdapters;
import mbtkerteam.com.engvolunteered.Helpers.GroupsModel;

public class ChallengesFragment extends Fragment {

    TextView NewButton;

    GridView MyListView;
    TextView NoDataTxt;
    ProgressBar progressBar;

    private AlertDialog MyDialog;

    public ChallengesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_challenges, container, false);

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

                ChallengesAdapters challengesAdapters = new ChallengesAdapters(getActivity(), IntroActivity.ChallengesList);
                MyListView.setAdapter(challengesAdapters);

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
        TextView TopicTxt = (TextView) row.findViewById(R.id.TopicTxt);
        TextView NameTxt = (TextView) row.findViewById(R.id.NameTxt);
        Button CreateButton = (Button) row.findViewById(R.id.CreateButton);

        TopicTxt.setText("انشاء تحدي جديد");
        NameTxt.setHint("عنوان التحدي");

        CreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (NameTxt.getText().toString().isEmpty())
                {
                    Toast.makeText(getContext(), "الرجاء كتابة عنوان التحدي!", Toast.LENGTH_LONG).show();

                    return;
                }

               // IntroActivity.ChallengesList.add(new ChallengesModel("10", NameTxt.getText().toString(),"", "0"));

                Toast.makeText(getContext(), "تم ارسال طلب اضافة تحدي للفريق المختص للمراجعة", Toast.LENGTH_LONG).show();

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
