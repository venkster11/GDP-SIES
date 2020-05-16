package com.venkat.gdp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class SubsDialog extends DialogFragment {
    TextView SubTxt;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_layout, null);

        SubTxt = view.findViewById(R.id.dialog_txt);

        SharedPreferences pref = getContext().getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();
        final boolean subedornot = pref.getBoolean("subed",false);

        if (subedornot) SubTxt.setText("Do you want to Unsubscribe");
        else SubTxt.setText("Do you want to Subscribe");

        builder.setView(view)
                .setTitle("Confirmation")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        if (subedornot){
                            editor.putBoolean("subed",false);
                            editor.apply();
                            Button button = getActivity().findViewById(R.id.btn_sub);
                            button.setText("Subscribe");
                        }
                        else {
                            editor.putBoolean("subed",true);
                            editor.apply();
                            Button button = getActivity().findViewById(R.id.btn_sub);
                            button.setText("Subscribed");
                        }

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        return builder.create();
    }
}
