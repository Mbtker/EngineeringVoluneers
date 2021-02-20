package mbtkerteam.com.engvolunteered;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomNewAccountDialog extends BottomSheetDialogFragment {
    private BottomSheetListener mListener;

    TextView TopicTxt, OrganisationAccountButton, EngAccountButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.buttom_new_account_layout, container, false);

        TopicTxt = (TextView) v.findViewById(R.id.TopicTxt);
        EngAccountButton = (TextView) v.findViewById(R.id.EngAccountButton);
        OrganisationAccountButton = (TextView) v.findViewById(R.id.OrganisationAccountButton);


        EngAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mListener.onButtonClicked(1);
                dismiss();
            }
        });

        OrganisationAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mListener.onButtonClicked(2);
                dismiss();
            }
        });

        return v;
    }

    public interface  BottomSheetListener {
        void onButtonClicked(int text);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {

            mListener = (BottomSheetListener) context;

        } catch (ClassCastException e)
        {
            throw  new ClassCastException(context.toString());
        }

    }

}
