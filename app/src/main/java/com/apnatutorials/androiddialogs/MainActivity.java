package com.apnatutorials.androiddialogs;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

    }

    /**
     * Method is called when click on a button
     *
     * @param view
     */
    public void clickAnyButton(View view) {
        switch (view.getId()) {
            case R.id.btnAlertDialog:
                alertDialogDemo();
                break;
            case R.id.btnConfirmDialog:
                confirmDialogDemo();
                break;

            case R.id.btnPromptDialog:
                promptDialogDemo();
                break;

        }
    }

    /**
     * Alert dialog demo
     */
    private void alertDialogDemo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert dialog demo !");
        builder.setMessage("This is an alert dialog message");
        builder.setCancelable(true);
        builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Neutral button clicked", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    /**
     * confirm dialog demo
     */
    private void confirmDialogDemo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm dialog demo !");
        builder.setMessage("You are about to delete all records of database. Do you really want to proceed ?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You've choosen to delete all records", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "You've changed your mind to delete all records", Toast.LENGTH_SHORT).show();
            }
        });

        builder.show();
    }

    /**
     * Prompt dialog demo
     * it is used when you want to capture user input
     */
    private void promptDialogDemo() {
        final EditText edtText = new EditText(this);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Prompt dialog demo !");
        builder.setMessage("What is your name?");
        builder.setCancelable(false);
        builder.setView(edtText);
        builder.setNeutralButton("Prompt", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Hello " + edtText.getText() + " ! how are you?", Toast.LENGTH_LONG).show();
            }
        });
        builder.show();
    }


}
