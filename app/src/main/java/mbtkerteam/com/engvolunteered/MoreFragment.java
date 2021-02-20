package mbtkerteam.com.engvolunteered;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import mbtkerteam.com.engvolunteered.Helpers.LogOutDialogClass;

public class MoreFragment extends Fragment {

    TextView EditInfoButton, ContactSupportButton, AboutButton, LogOutButton;

    LogOutDialogClass LogOutDialog;

    public MoreFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more, container, false);

        EditInfoButton = (TextView) view.findViewById(R.id.EditInfoButton);
        ContactSupportButton = (TextView) view.findViewById(R.id.ContactSupportButton);
        AboutButton = (TextView) view.findViewById(R.id.AboutButton);
        LogOutButton = (TextView) view.findViewById(R.id.LogOutButton);

        LogOutDialog = new LogOutDialogClass(getContext());

        EditInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "عرض صفحة تعديل البيانات", Toast.LENGTH_LONG).show();

            }
        });

        ContactSupportButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getContext(), "فتح تذكرة دعم فني", Toast.LENGTH_LONG).show();
            }
        });

        AboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), AboutActivity.class);
                startActivity(intent);
            }
        });

        LogOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LogOutDialog.show();
            }
        });

        return view;
    }
}