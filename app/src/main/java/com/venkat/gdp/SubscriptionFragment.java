package com.venkat.gdp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SubscriptionFragment extends Fragment {

    Button SubBtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.subscription_fragment,container,false);

        SubBtn = view.findViewById(R.id.btn_sub);

        SharedPreferences pref = getContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        boolean subvalue = pref.getBoolean("subed",false);

        if(subvalue) SubBtn.setText("Subscribed");
        else SubBtn.setText("Subscribe");

        SubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SubsDialog subsDialog = new SubsDialog();
                subsDialog.show(getFragmentManager(),null);
            }
        });

        return view;
    }
}
