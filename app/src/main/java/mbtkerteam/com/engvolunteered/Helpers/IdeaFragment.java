package mbtkerteam.com.engvolunteered.Helpers;

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

import java.util.ArrayList;

import mbtkerteam.com.engvolunteered.IntroActivity;
import mbtkerteam.com.engvolunteered.R;

public class IdeaFragment extends Fragment {

    GridView MyListView;
    TextView NoDataTxt, NewButton;
    ProgressBar progressBar;

    ArrayList<String> IdeaList = new ArrayList<>();

    private AlertDialog MyDialog;

    public IdeaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_idea, container, false);

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

                IdeaAdapters ideaAdapters = new IdeaAdapters(getActivity(), IdeaList);
                MyListView.setAdapter(ideaAdapters);

                MyListView.setVisibility(View.VISIBLE);
                NoDataTxt.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);

            }

        }, 500);
    }

    private void OpenNewDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(getContext().LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.new_idea_dialog, null);
        TextView NameTxt = (TextView) row.findViewById(R.id.NameTxt);
        TextView DetailsTxt = (TextView) row.findViewById(R.id.DetailsTxt);
        Button CreateButton = (Button) row.findViewById(R.id.CreateButton);

        CreateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (NameTxt.getText().toString().isEmpty() || DetailsTxt.getText().toString().isEmpty())
                {
                    Toast.makeText(getContext(), "كافة الحقول مطلوبة!", Toast.LENGTH_LONG).show();

                    return;
                }

                IdeaList.add(NameTxt.getText().toString());

                Toast.makeText(getContext(), "تم الارسال للفريق المختص للمراجعة", Toast.LENGTH_LONG).show();

                initData();

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
