package com.andy_mitchell.mastermind.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.Button;

import com.andy_mitchell.mastermind.Colours;

public class SelectColour extends DialogFragment {

    private Colours colourToBeSelected = Colours.WHITE;
    private Button button;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        String[] options = {"Red",
                "Blue",
                "Yellow",
                "Green",
                "Black",
                "White"};

        builder.setTitle("Select colour")
                .setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                colourToBeSelected = Colours.RED;
                                button.setBackgroundColor(Color.RED);
                                break;
                            case 1:
                                colourToBeSelected = Colours.BLUE;
                                button.setBackgroundColor(Color.BLUE);
                                break;
                            case 2:
                                colourToBeSelected = Colours.YELLOW;
                                button.setBackgroundColor(Color.YELLOW);
                                break;
                            case 3:
                                colourToBeSelected = Colours.GREEN;
                                button.setBackgroundColor(Color.GREEN);
                                break;
                            case 4:
                                colourToBeSelected = Colours.BLACK;
                                button.setBackgroundColor(Color.BLACK);
                                break;
                            case 5:
                                colourToBeSelected = Colours.WHITE;
                                button.setBackgroundColor(Color.WHITE);
                                break;
                        }
                    }
                });

        return builder.create();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && null != data) {
            switch (requestCode) {
                case 0:
                    button.setTextColor(Color.RED);
                    break;
                case 1:
                    button.setTextColor(Color.BLUE);
                    break;
                case 2:
                    button.setTextColor(Color.YELLOW);
                    break;
                case 3:
                    button.setTextColor(Color.GREEN);
                    break;
                case 4:
                    button.setTextColor(Color.BLACK);
                    break;
                case 5:
                    button.setTextColor(Color.WHITE);
                    break;
            }
        }
    }

    public void setButton(Button button) {
        this.button = button;

    }

    public Colours getColourToBeSelected() {
        return colourToBeSelected;
    }
}
