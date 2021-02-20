package mbtkerteam.com.engvolunteered;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import mbtkerteam.com.engvolunteered.Helpers.LogOutDialogClass;

public class MoreGuestFragment extends Fragment {

    TextView ContactSupportButton, AboutButton, RegisterButton;

    public MoreGuestFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_more_guest, container, false);

        ContactSupportButton = (TextView) view.findViewById(R.id.ContactSupportButton);
        AboutButton = (TextView) view.findViewById(R.id.AboutButton);
        RegisterButton = (TextView) view.findViewById(R.id.RegisterButton);


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

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), CreateEngAccountActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}